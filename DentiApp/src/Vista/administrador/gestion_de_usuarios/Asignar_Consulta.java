package Vista.administrador.gestion_de_usuarios;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Calendar;
import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import Controlador.BBDD;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;
import javax.swing.ScrollPaneConstants;

public class Asignar_Consulta extends JPanel {
	
	// Atributos
	protected Campo_texto_theme dni_nombre_usuario;
	protected Despegable_editable_theme<String> especialidad;
	protected Campo_texto_theme nombre_doctor;
	protected JDateChooser fecha;
	protected JScrollPane scrollpanel;
	protected JTable citas_usuario;
	protected BotonDentista boton_asignar_cita;
	protected JLabel etiqueta_dni_nombre_usuario;
	protected JLabel etiqueta_especialidad;
	protected JLabel etiqueta_nombre_doctor;
	protected JLabel etiqueta_fecha;
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
		this.dni_nombre_usuario.setBounds(106, 30, 205, 30);
		
		this.especialidad = new Despegable_editable_theme<String>(20);
		this.especialidad.setBounds(106, 92, 205, 30);
		
		this.nombre_doctor = new Campo_texto_theme(20);
		this.nombre_doctor.setBounds(417, 92, 205, 30);
		
		this.fecha = new JDateChooser();
		
		this.fecha.setBounds(417,30,205,30);
		this.fecha.setDateFormatString("yyyy/M/d");
		this.fecha.setDate(Calendar.getInstance().getTime());
		this.fecha.getCalendarButton().setContentAreaFilled(false);
		
		JTextField fecha_texto = (JTextField) this.fecha.getComponent(1);
		fecha_texto.setEditable(false);

		JCalendar fecha_calendario = this.fecha.getJCalendar();
		
		fecha_calendario.setSundayForeground(null);
		fecha_calendario.setWeekdayForeground(null);
		fecha_calendario.setWeekOfYearVisible(false);
		fecha_calendario.setDecorationBackgroundColor(Color.lightGray);
		fecha_calendario.setMinSelectableDate(Calendar.getInstance().getTime());
		
		Container spinner_mes = (Container) fecha_calendario.getMonthChooser().getSpinner();
		
		for (;spinner_mes.getComponents().length > 1;) {
			spinner_mes.remove(0);
		}
		
		this.scrollpanel = new JScrollPane();
		
		this.scrollpanel.setBounds(182, 132, 365, 115);
		this.scrollpanel.setBorder(new LineBorder(Color.black));
		this.scrollpanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		this.scrollpanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.citas_usuario = new JTable();
		
		this.citas_usuario.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		this.citas_usuario.setTableHeader(null);

		this.scrollpanel.setViewportView(citas_usuario);
						
		this.boton_asignar_cita = new BotonDentista();
		
		this.boton_asignar_cita.setBounds(559, 212, 100, 35);
		this.boton_asignar_cita.setBorder(null);
		this.boton_asignar_cita.setRadius(30);
		this.boton_asignar_cita.setText("<html><p align='center'>Asignar<br>cita</html>");
		this.boton_asignar_cita.setFocusable(false);
				
		this.etiqueta_dni_nombre_usuario = new JLabel();
		
		this.etiqueta_dni_nombre_usuario.setBounds(106, 0, 205, 30);
		this.etiqueta_dni_nombre_usuario.setText("<html>DNI / Nombre completo<br>paciente:</html>");
		
		this.etiqueta_especialidad = new JLabel();
		
		this.etiqueta_especialidad.setBounds(106, 77, 94, 15);
		this.etiqueta_especialidad.setText("Especialidad:");
		
		this.etiqueta_nombre_doctor = new JLabel();
		
		this.etiqueta_nombre_doctor.setBounds(417, 77, 205, 15);
		this.etiqueta_nombre_doctor.setText("Nombre completo doctor:");
		
		this.etiqueta_fecha = new JLabel();
		
		this.etiqueta_fecha.setBounds(417,15,205,15);
		this.etiqueta_fecha.setText("Fecha:");
		
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
					
					String doctor = "";
					
					if (this.nombre_doctor.getText().isBlank()) {
						doctor = "%";
					}
					else {
						doctor = this.nombre_doctor.getText();
					}
									
					ArrayList<String> dni_doctores = new ArrayList<String>(this.dbconn.SelectLista(
						"usuario.DNI_Usuario",
						"doctores inner join usuario on DNI = usuario.DNI_Usuario" +
						" inner join especialidad on doctores.ID_Especialidad = especialidad.ID_Especialidad" +
						" where Estado = 1 and especialidad.Nombre = '" + valor_especialidad.getSelectedItem().toString() + "'" +
						" and concat(usuario.Nombre,' ',usuario.Apellidos) like '" + doctor + "'"
					));
					
					ArrayList<String> nombre_doctores = new ArrayList<String>(this.dbconn.SelectLista(
						"usuario.Nombre",
						"doctores inner join usuario on DNI = usuario.DNI_Usuario" +
						" inner join especialidad on doctores.ID_Especialidad = especialidad.ID_Especialidad" +
						" where Estado = 1 and especialidad.Nombre = '" + valor_especialidad.getSelectedItem().toString() + "'" +
						" and concat(usuario.Nombre,' ',usuario.Apellidos) like '" + doctor + "'"
					));
					
					ArrayList<String> apellidos_doctores = new ArrayList<String>(this.dbconn.SelectLista(
						"usuario.Apellidos",
						"doctores inner join usuario on DNI = usuario.DNI_Usuario" +
						" inner join especialidad on doctores.ID_Especialidad = especialidad.ID_Especialidad" +
						" where Estado = 1 and especialidad.Nombre = '" + valor_especialidad.getSelectedItem().toString() + "'" +
						" and concat(usuario.Nombre,' ',usuario.Apellidos) like '" + doctor + "'"
					));
					
					if (dni_doctores.size() != 0) {
						
						this.dbconn.SelectValor(
							this.citas_usuario,
							"select usuario.DNI_Usuario, usuario.Nombre, doctores.Fecha_Nacimiento from usuario" +
							" inner join doctores on DNI_Usuario = DNI where DNI_Usuario IS NULL;"
						);
					}
					
					String[] horas = {"09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00"};
					
					for (int i = 0;i < dni_doctores.size();i++) {
						
						int dia = this.fecha.getCalendar().get(Calendar.DAY_OF_MONTH);
						int mes = this.fecha.getCalendar().get(Calendar.MONTH) + 1;
						int ano = this.fecha.getCalendar().get(Calendar.YEAR);
						
						for (int w = 0;w < horas.length;w++) {
							
							ArrayList<String> citas = new ArrayList<String>(this.dbconn.SelectLista(
								"ID_Cita",
								"citas where ID_Doctor = '" + dni_doctores.get(i) + "'" +
								" and Fecha_Hora = '" + ano + "-" + mes + "-" + dia + " " + horas[w] + "'"
							));
							
							if (citas.size() == 0) {
								
								modelo_citas_usuario = (DefaultTableModel) this.citas_usuario.getModel();
								
								modelo_citas_usuario.setValueAt("Fecha_Hora",0,2);
								modelo_citas_usuario.setValueAt("Nombre_Completo",0,1);

								modelo_citas_usuario.addRow(
									new String[] {
										dni_doctores.get(i),
										nombre_doctores.get(i) + " " + apellidos_doctores.get(i),
										ano + "-" + mes + "-" + dia + " " + horas[w]
									}
								);
								
								this.citas_usuario.setModel(modelo_citas_usuario);
								this.citas_usuario.setDefaultEditor(this.citas_usuario.getColumnClass(0), null);
							}
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
					throw new Exception("No has introducido el DNI o el nombre completo del usuario correctamente");
				}
				else {
					
					ArrayList<String> perfil = new ArrayList<String>(this.dbconn.SelectLista(
						"Perfil",
						"usuario where DNI_Usuario = '" + this.dni_nombre_usuario.getText() + "'" +
						"or concat(Nombre,' ',Apellidos) = '" + this.dni_nombre_usuario.getText() + "'"
					));
					
					if (perfil.size() == 0) {
						throw new Exception("No has introducido el DNI o el nombre completo del usuario correctamente");
					}
					
					if (!perfil.get(0).equalsIgnoreCase("paciente")) {
						throw new Exception("No has introducido el DNI del usuario de un paciente");
					}
				}
				
				if (this.especialidad.getSelectedIndex() == 0) {
					throw new Exception("No has seleccionado la especialidad correctamente");
				}
				
				if (this.citas_usuario.getSelectedRow() < 1) {
					throw new Exception("No has seleccionado la fecha y hora de las citas correctamente");
				}
				
				ArrayList<String> dni_usuario = new ArrayList<String>(this.dbconn.SelectLista(
					"DNI_Usuario",
					"usuario where DNI_Usuario = '" + this.dni_nombre_usuario.getText() + "'" +
					"or concat(Nombre,' ',Apellidos) = '" + this.dni_nombre_usuario.getText() + "'"
				));
				
					
				String dni_doctor = (String) this.citas_usuario.getModel().getValueAt(this.citas_usuario.getSelectedRow(),0);
				String fecha_consulta = (String) this.citas_usuario.getModel().getValueAt(this.citas_usuario.getSelectedRow(),2);
				
				this.dbconn.insertar(
					"citas",
					0 + "," +
					dni_usuario.get(0) + "," +
					dni_doctor + "," +
					1 + "," +
					fecha_consulta + "," +
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
		add(nombre_doctor);
		add(fecha);
		add(scrollpanel);
		add(boton_asignar_cita);

		add(etiqueta_dni_nombre_usuario);
		add(etiqueta_especialidad);
		add(etiqueta_nombre_doctor);
		add(etiqueta_fecha);
	}
}
