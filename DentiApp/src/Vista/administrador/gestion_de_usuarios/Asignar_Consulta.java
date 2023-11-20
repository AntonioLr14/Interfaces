package Vista.administrador.gestion_de_usuarios;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import Controlador.BBDD;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;
import javax.swing.ScrollPaneConstants;

public class Asignar_Consulta extends JPanel {
	
	// Atributos
	protected Campo_texto_theme dni_nombre_usuario;
	protected Despegable_editable_theme<String> especialidad;
	protected JScrollPane scrollpanel;
	protected JTable citas_usuario;
	protected BotonDentista boton_asignar_cita;
	protected JLabel etiqueta_dni_nombre_usuario;
	protected JLabel etiqueta_especialidad;
	protected BBDD dbconn;
	
	// Constructores
	public Asignar_Consulta() {
		
		setBounds(0, 0, 730, 325);
		setLayout(null);
		setOpaque(false);
		
		this.dbconn = new BBDD();
		
		this.dbconn.conectar();

		// Creacion de los elementos graficos
		this.dni_nombre_usuario = new Campo_texto_theme(20);
		this.dni_nombre_usuario.setBounds(106, 15, 205, 30);
		
		this.especialidad = new Despegable_editable_theme<String>(20);
		this.especialidad.setBounds(417, 15, 205, 30);
		
		this.scrollpanel = new JScrollPane();
		
		this.scrollpanel.setBounds(182, 56, 365, 130);
		this.scrollpanel.setBorder(new LineBorder(Color.black));
		this.scrollpanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		this.scrollpanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.citas_usuario = new JTable();
		
		this.citas_usuario.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		this.citas_usuario.setTableHeader(null);

		this.scrollpanel.setViewportView(citas_usuario);
						
		this.boton_asignar_cita = new BotonDentista();
		
		this.boton_asignar_cita.setBounds(559, 151, 100, 35);
		this.boton_asignar_cita.setBorder(null);
		this.boton_asignar_cita.setRadius(30);
		this.boton_asignar_cita.setText("<html><p align='center'>Asignar<br>cita</html>");
		this.boton_asignar_cita.setFocusable(false);
		
		this.etiqueta_dni_nombre_usuario = new JLabel();
		
		this.etiqueta_dni_nombre_usuario.setBounds(106, 0, 165, 13);
		this.etiqueta_dni_nombre_usuario.setText("DNI / Nombre completo:");
		
		this.etiqueta_especialidad = new JLabel();
		
		this.etiqueta_especialidad.setBounds(417, 0, 94, 13);
		this.etiqueta_especialidad.setText("Especialidad:");
		
		try {
			
			ArrayList<String> especialidades = new ArrayList<String>(this.dbconn.SelectLista("Nombre","especialidad"));

			this.especialidad.addItem("...");
			
			for (int i = 0; i < especialidades.size();i++) {
				this.especialidad.addItem(especialidades.get(i));
			}
		}
		catch (Exception error) {
			
			JOptionPane.showMessageDialog(
				null,
				error.getMessage(),
				"Error en la consulta de las citas",
				JOptionPane.ERROR_MESSAGE,
				null
			);
		}
		
		// Asignacion de los eventos
		this.especialidad.addActionListener( (event) -> {
			
			try {
				
				Despegable_editable_theme<String> valor_especialidad = (Despegable_editable_theme<String>) event.getSource();
				
				DefaultTableModel modelo_citas_usuario = (DefaultTableModel) this.citas_usuario.getModel();				
				
				for (;modelo_citas_usuario.getRowCount() > 0;) {
					modelo_citas_usuario.removeRow(0);
				}
				
				if (valor_especialidad.getSelectedIndex() != 0) {
									
					ArrayList<String> dni_doctores = new ArrayList<String>(this.dbconn.SelectLista(
						"usuario.DNI_Usuario",
						"doctores inner join usuario on DNI = usuario.DNI_Usuario" +
						" inner join especialidad on doctores.ID_Especialidad = especialidad.ID_Especialidad" +
						" where Estado = 1 and especialidad.Nombre = '" + valor_especialidad.getSelectedItem().toString() + "'"
					));
					
					ArrayList<String> nombre_doctores = new ArrayList<String>(this.dbconn.SelectLista(
						"usuario.Nombre",
						"doctores inner join usuario on DNI = usuario.DNI_Usuario" +
						" inner join especialidad on doctores.ID_Especialidad = especialidad.ID_Especialidad" +
						" where Estado = 1 and especialidad.Nombre = '" + valor_especialidad.getSelectedItem().toString() + "'"
					));
					
					ArrayList<String> apellidos_doctores = new ArrayList<String>(this.dbconn.SelectLista(
						"usuario.Apellidos",
						"doctores inner join usuario on DNI = usuario.DNI_Usuario" +
						" inner join especialidad on doctores.ID_Especialidad = especialidad.ID_Especialidad" +
						" where Estado = 1 and especialidad.Nombre = '" + valor_especialidad.getSelectedItem().toString() + "'"
					));
					
					if (dni_doctores.size() != 0) {
						
						this.dbconn.SelectValor(
							this.citas_usuario,
							"select usuario.DNI_Usuario, usuario.Nombre, doctores.Fecha_Nacimiento from usuario" +
							" inner join doctores on DNI_Usuario = DNI where DNI_Usuario IS NULL;"
						);
					}
					
					Calendar fecha = Calendar.getInstance();
					String[] horas = {"09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00"};
					
					for (int i = 0;i < dni_doctores.size();i++) {
						
						for (int w = 0;w < 7;w++) {
							
							int dia = fecha.get(Calendar.DAY_OF_MONTH);
							int mes = fecha.get(Calendar.MONTH) + 1;
							int ano = fecha.get(Calendar.YEAR);
							
							for (int n = 0;n < horas.length;n++) {
								
								ArrayList<String> citas = new ArrayList<String>(this.dbconn.SelectLista(
									"ID_Cita",
									"citas where ID_Doctor = '" + dni_doctores.get(i) + "'" +
									" and Fecha_Hora = '" + dia + "-" + mes + "-" + ano + " " + horas[n] + "'"
								));
								
								if (citas.size() == 0) {
									
									modelo_citas_usuario = (DefaultTableModel) this.citas_usuario.getModel();
									
									modelo_citas_usuario.setValueAt("Fecha_Hora",0,2);
									modelo_citas_usuario.setValueAt("Nombre_Completo",0,1);

									modelo_citas_usuario.addRow(
										new String[] {
											dni_doctores.get(i),
											nombre_doctores.get(i) + " " + apellidos_doctores.get(i),
											dia + "-" + mes + "-" + ano + " " + horas[n]
										}
									);
									
									this.citas_usuario.setModel(modelo_citas_usuario);
									this.citas_usuario.setDefaultEditor(this.citas_usuario.getColumnClass(0), null);
								}
							}
							
							fecha.add(Calendar.DAY_OF_MONTH,1);
						}
					}
				}
			}
			catch (Exception error) {
				
				JOptionPane.showMessageDialog(
					null,
					error.getMessage(),
					"Error en la consulta de las citas",
					JOptionPane.ERROR_MESSAGE,
					null
				);
			}
		});
		
		this.boton_asignar_cita.addActionListener( (event) -> {
			
			try {
				
				if (this.dni_nombre_usuario.getText().isBlank()) {
					throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
				}
				
				if (this.especialidad.getSelectedIndex() == 0) {
					throw new Exception("No has seleccionado la especialidad correctamente");
				}
				
				if (this.citas_usuario.getSelectedRow() < 1) {
					throw new Exception("No has seleccionado la fecha y hora de las citas correctamente");
				}
				
				String dni_doctor = (String) this.citas_usuario.getModel().getValueAt(this.citas_usuario.getSelectedRow(),0);
				String fecha = (String) this.citas_usuario.getModel().getValueAt(this.citas_usuario.getSelectedRow(),2);
				
				this.dbconn.insertar(
					"citas",
					0 + "," +
					this.dni_nombre_usuario.getText() + "," +
					dni_doctor + "," +
					0 + "," +
					fecha + "," +
					"Por determinar"
				);
				
				JOptionPane.showMessageDialog(
					null,
					"Has asignado la cita en la base de datos correctamente",
					"Asignacion de consultas",
					JOptionPane.INFORMATION_MESSAGE,
					null
				);
			}
			catch (Exception error) {
				
				JOptionPane.showMessageDialog(
					null,
					error.getMessage(),
					"Error en la asignacion de las consultas",
					JOptionPane.ERROR_MESSAGE,
					null
				);
			}
		});
		
		add(dni_nombre_usuario);
		add(especialidad);
		add(scrollpanel);
		add(boton_asignar_cita);

		add(etiqueta_dni_nombre_usuario);
		add(etiqueta_especialidad);
	}
}
