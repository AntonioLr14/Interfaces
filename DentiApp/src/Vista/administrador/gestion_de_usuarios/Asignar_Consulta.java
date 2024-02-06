package Vista.administrador.gestion_de_usuarios;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Container;
import java.sql.ResultSet;
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
		
		try {
			this.dbconn = new BBDD();
			this.dbconn.conectar();
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
			
			this.especialidad.addItem("...");

			ResultSet especialidades = this.dbconn.consulta("select Nombre from Especialidades;");
			
			for (;especialidades.next();) {
				this.especialidad.addItem(especialidades.getString("Nombre"));
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
				
				this.dbconn.cabeceraTabla(this.citas_usuario, 
					"select DNI, Nombre, Apellidos from Personas" +
					" where DNI IS NULL;"
				);
					
				this.citas_usuario.getColumnModel().getColumn(1).setHeaderValue("Nombre_Completo");
				this.citas_usuario.getColumnModel().getColumn(2).setHeaderValue("Fecha_Hora");
				
				if (valor_especialidad.getSelectedIndex() != 0) {
					
					String doctor = "";
					
					if (this.nombre_doctor.getText().isBlank()) {
						doctor = "%";
					}
					else {
						doctor = this.nombre_doctor.getText();
					}
					
					ResultSet resultado = this.dbconn.consulta(
						"select Doctores.DNI, Personas.Nombre, Apellidos from Personas" +
						" inner join Usuarios on Personas.DNI = Usuarios.DNI" +
						" inner join Doctores on Personas.DNI = Doctores.DNI" +
						" inner join Especialidades on Doctores.ID_especialidad = Especialidades.ID_especialidad" +
						" where Estado = 1 and Especialidades.Nombre = '" + valor_especialidad.getSelectedItem().toString() + "'" +
						" and concat(Personas.Nombre,' ',Apellidos) like '" + doctor + "';"
					);
					
					String[] horas = {"09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00"};
					
					int dia = this.fecha.getCalendar().get(Calendar.DAY_OF_MONTH);
					int mes = this.fecha.getCalendar().get(Calendar.MONTH) + 1;
					int ano = this.fecha.getCalendar().get(Calendar.YEAR);
					
					for (;resultado.next();) {
						
						String dni = resultado.getString("Doctores.DNI");
						String nombre = resultado.getString("Personas.Nombre");
						String apellidos = resultado.getString("Apellidos");
						
						for (int w = 0;w < horas.length;w++) {
							
							ResultSet citas = this.dbconn.consulta(
								"select ID_cita from Citas" +
								" inner join Doctores on Citas.ID_doctor = Doctores.ID_doctor" +
								" where Doctores.DNI = '" + dni + "'" +
								" and Fecha_hora = '" + ano + "-" + mes + "-" + dia + " " + horas[w] + "';"
							);
							
							if (citas.next() == false) {
								
								modelo_citas_usuario.addRow(
									new String[] {
										dni,
										nombre + " " + apellidos,
										dia + "-" + mes + "-" + ano + " " + horas[w]
									}
								);
							}
						}
					}
					
					this.citas_usuario.setDefaultEditor(this.citas_usuario.getColumnClass(0), null);
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
					
					ResultSet perfil = this.dbconn.consulta(
						"select Perfil from Usuarios" +
						" inner join Personas on Personas.DNI = Usuarios.DNI" +
						" where Usuarios.DNI = '" + this.dni_nombre_usuario.getText() +
						"' or concat(Nombre,' ',Apellidos) = '" + this.dni_nombre_usuario.getText() + "';"
					);
					
					if (perfil.next()) {
						throw new Exception("No has introducido el DNI del usuario de un paciente");
					}
				}
				
				if (this.especialidad.getSelectedIndex() == 0) {
					throw new Exception("No has seleccionado la especialidad correctamente");
				}
				
				String dni_doctor = (String) this.citas_usuario.getModel().getValueAt(this.citas_usuario.getSelectedRow(),0);
				String fecha_consulta = (String) this.citas_usuario.getModel().getValueAt(this.citas_usuario.getSelectedRow(),2);
				
				String dias = fecha_consulta.split(" ")[0];
				String horas = fecha_consulta.split(" ")[1];
				
				String dia = dias.split("-")[0];
				String mes = dias.split("-")[1];
				String ano = dias.split("-")[2];
				
				ResultSet paciente = this.dbconn.consulta(
					"select ID_paciente from Pacientes" +
					" inner join Personas on Pacientes.DNI = Personas.DNI" +
					" where Personas.DNI = '" + this.dni_nombre_usuario.getText() + "'" +
					" or concat(Nombre,' ',Apellidos) = '" + this.dni_nombre_usuario.getText() + "';"
				);
				
				ResultSet doctor = this.dbconn.consulta(
					"select ID_doctor from Doctores" +
					" inner join Personas on Doctores.DNI = Personas.DNI" +
					" where Personas.DNI = '" + dni_doctor + "';"
				);
				
				paciente.next();
				doctor.next();
				
				int inserccionval = this.dbconn.insertUpdateDelete(
					"insert into Citas (ID_paciente, ID_doctor, ID_tratamiento, Fecha_hora, Observaciones) values (" +
					paciente.getInt("ID_paciente") + "," +
					doctor.getInt("ID_doctor") + "," +
					1 + ",'" +
					ano + "-" + mes + "-" + dia + " " + horas + "','" +
					"Por determinar');"
				);
				
				if (inserccionval != 0) { 
					
					JOptionPane.showMessageDialog(
						null,
						"Has asignado la cita en la base de datos correctamente",
						"Asignacion de consultas",
						JOptionPane.INFORMATION_MESSAGE,
						null
					);
				}
				else {
					throw new Exception("Ha ocurrido un error en la asignacion de consultas");
				}
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
