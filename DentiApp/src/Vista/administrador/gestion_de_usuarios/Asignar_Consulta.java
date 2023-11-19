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
	protected BBDD dbconn;
	
	// Constructores
	public Asignar_Consulta() {
		
		setBounds(0, 0, 730, 325);
		setLayout(null);
		setOpaque(false);
		
		this.dbconn = new BBDD();
		
		this.dbconn.conectar();

		// Creacion de los elementos graficos
		Campo_texto_theme dni_nombre_usuario = new Campo_texto_theme(20);
		dni_nombre_usuario.setBounds(106, 15, 205, 30);
		
		JScrollPane scrollpanel = new JScrollPane();
		
		scrollpanel.setBounds(182, 56, 365, 130);
		scrollpanel.setBorder(new LineBorder(Color.black));
		scrollpanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollpanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JTable citas_usuario = new JTable();
		
		citas_usuario.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		citas_usuario.setTableHeader(null);

		scrollpanel.setViewportView(citas_usuario);
		
		Despegable_editable_theme<String> especialidad = new Despegable_editable_theme<String>(20);
		especialidad.setBounds(417, 15, 205, 30);
		
		try {
			
			ArrayList<String> especialidades = new ArrayList<String>(this.dbconn.SelectLista("Nombre","especialidad"));

			especialidad.addItem("...");
			
			for (int i = 0; i < especialidades.size();i++) {
				especialidad.addItem(especialidades.get(i));
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
				
		BotonDentista boton_asignar_cita = new BotonDentista();
		
		boton_asignar_cita.setBounds(559, 151, 100, 35);
		boton_asignar_cita.setBorder(null);
		boton_asignar_cita.setRadius(30);
		boton_asignar_cita.setText("<html><p align='center'>Asignar<br>cita</html>");
		boton_asignar_cita.setFocusable(false);
		
		JLabel etiqueta_dni_nombre_usuario = new JLabel();
		
		etiqueta_dni_nombre_usuario.setBounds(106, 0, 165, 13);
		etiqueta_dni_nombre_usuario.setText("DNI / Nombre completo:");
		
		JLabel etiqueta_especialidad = new JLabel();
		
		etiqueta_especialidad.setBounds(417, 0, 94, 13);
		etiqueta_especialidad.setText("Especialidad:");
		
		// Asignacion de los eventos
		especialidad.addActionListener( (event) -> {
			
			try {
				
				Despegable_editable_theme<String> valor_especialidad = (Despegable_editable_theme<String>) event.getSource();
				
				DefaultTableModel modelo_citas_usuario = (DefaultTableModel) citas_usuario.getModel();				
				
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
							citas_usuario,
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
																											
									modelo_citas_usuario = (DefaultTableModel) citas_usuario.getModel();
									
									modelo_citas_usuario.setValueAt("Fecha_Hora",0,2);
									modelo_citas_usuario.setValueAt("Nombre_Completo",0,1);

									modelo_citas_usuario.addRow(
										new String[] {
											dni_doctores.get(i),
											nombre_doctores.get(i) + " " + apellidos_doctores.get(i),
											dia + "-" + mes + "-" + ano + " " + horas[n]
										}
									);
									
									citas_usuario.setModel(modelo_citas_usuario);
									citas_usuario.setDefaultEditor(citas_usuario.getColumnClass(0), null);
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
		
		boton_asignar_cita.addActionListener( (event) -> {
			
			try {
				
				if (dni_nombre_usuario.getText().isBlank()) {
					throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
				}
				
				if (especialidad.getSelectedIndex() == 0) {
					throw new Exception("No has seleccionado la especialidad correctamente");
				}
				
				if (citas_usuario.getSelectedRow() < 1) {
					throw new Exception("No has seleccionado la fecha y hora de las citas correctamente");
				}
				
				String dni_doctor = (String) citas_usuario.getModel().getValueAt(citas_usuario.getSelectedRow(),0);
				String fecha = (String) citas_usuario.getModel().getValueAt(citas_usuario.getSelectedRow(),2);
				
				this.dbconn.insertar(
					"citas",
					0 + "," +
					dni_nombre_usuario.getText() + "," +
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
		add(scrollpanel);
		add(especialidad);
		add(boton_asignar_cita);

		add(etiqueta_especialidad);
		add(etiqueta_dni_nombre_usuario);
	}
}
