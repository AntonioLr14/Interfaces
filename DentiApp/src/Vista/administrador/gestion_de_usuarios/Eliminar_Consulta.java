package Vista.administrador.gestion_de_usuarios;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import Controlador.BBDD;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;

public class Eliminar_Consulta extends JPanel {
	
	// Atributos
	protected Campo_texto_theme dni_nombre_usuario;
	protected Despegable_editable_theme<String> fecha;
	protected JScrollPane scrollpanel;
	protected JTable eliminar_citas;
	protected BotonDentista boton_eliminar;
	protected JLabel etiqueta_dni_nombre_usuario;
	protected JLabel etiqueta_fecha;
	protected BBDD dbconn;
	
	// Constructores
	public Eliminar_Consulta() {
		
		try {
			this.dbconn = new BBDD();
			this.dbconn.conectar();
		}
		catch (Exception error) {
			
			JOptionPane.showMessageDialog(
				null,
				error.getMessage(),
				"Error en la consulta de citas",
				JOptionPane.ERROR_MESSAGE,
				null
			);
		}
		
		setBounds(0, 0, 730, 325);
		setLayout(null);
		setOpaque(false);
		
		// Creacion de los elementos graficos
		this.dni_nombre_usuario = new Campo_texto_theme(20);
		this.dni_nombre_usuario.setBounds(106, 15, 205, 30);

		this.fecha = new Despegable_editable_theme<String>(20);
		
		this.fecha.setBounds(417, 15, 205, 30);
		this.fecha.setEnabled(false);

		this.scrollpanel = new JScrollPane();
		
		this.scrollpanel.setBounds(182, 56, 365, 130);
		this.scrollpanel.setBorder(new LineBorder(Color.black));
		this.scrollpanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.scrollpanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		
		this.eliminar_citas = new JTable();
		this.eliminar_citas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		this.scrollpanel.setViewportView(eliminar_citas);
		
		this.boton_eliminar = new BotonDentista();
		
		this.boton_eliminar.setBounds(559, 151, 100, 35);
		this.boton_eliminar.setBorder(null);
		this.boton_eliminar.setRadius(30);
		this.boton_eliminar.setText("Eliminar");
		this.boton_eliminar.setFocusable(false);
				
		this.etiqueta_dni_nombre_usuario = new JLabel();
		
		this.etiqueta_dni_nombre_usuario.setBounds(106, 0, 165, 13);
		this.etiqueta_dni_nombre_usuario.setText("DNI / Nombre completo:");
		
		this.etiqueta_fecha = new JLabel();
		
		this.etiqueta_fecha.setBounds(417, 0, 47, 13);
		this.etiqueta_fecha.setText("Fecha:");
		
		// Asignacion de los eventos
		ActionListener evento = (event) -> {
			
			try {
				
				if (this.fecha.getSelectedIndex() != 0) {
					
					if (this.dni_nombre_usuario.getText().isBlank()) {
						throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
					}
					else {
						
						ResultSet perfil = this.dbconn.consulta(
							"select Perfil from Usuarios" +
							" inner join Personas on Usuarios.DNI = Personas.DNI" +
							" where Personas.DNI = '" + this.dni_nombre_usuario.getText() + "'" +
							" or concat(Nombre,' ',Apellidos) = '" + this.dni_nombre_usuario.getText() + "';"
						);
						
						if (perfil.next()) {
							throw new Exception("No has introducido el DNI del usuario de un paciente");
						}
					}
					
					DefaultTableModel modelo_eliminar_citas = (DefaultTableModel) this.eliminar_citas.getModel();
					
					for (;modelo_eliminar_citas.getRowCount() > 0;) {
						modelo_eliminar_citas.removeRow(0);
					}
	
					this.dbconn.cabeceraTabla(this.eliminar_citas,
						"select ID_doctor, ID_tratamiento, Observaciones from Citas" +
						" where ID_cita IS NULL;"
					);
					
					String fecha_hora = this.fecha.getSelectedItem().toString();
					
					String fecha = fecha_hora.split(" ")[0];
					String hora = fecha_hora.split(" ")[1];
					
					String dia = fecha.split("-")[0];
					String mes = fecha.split("-")[1];
					String ano = fecha.split("-")[2];
					
					ResultSet citas = this.dbconn.consulta(
						"select ID_doctor, ID_tratamiento, Observaciones from Citas" +
						" inner join Pacientes on Pacientes.ID_paciente = Citas.ID_paciente" +
						" inner join Personas on Pacientes.DNI = Personas.DNI" +
						" where (Personas.DNI = '" + this.dni_nombre_usuario.getText() + "'" +
						" or concat(Nombre,' ',Apellidos) = '" + this.dni_nombre_usuario.getText() + "')" +
						" and Fecha_hora = '" + ano + "-" + mes + "-" + dia + " " + hora + "';"
					);
					
					for (;citas.next();) {
						
						String[] fila = {
							String.valueOf(citas.getInt("ID_doctor")),
							String.valueOf(citas.getInt("ID_tratamiento")),
							citas.getString("Observaciones")
						};
						
						modelo_eliminar_citas.addRow(fila);
					}
					
					this.eliminar_citas.setDefaultEditor(this.eliminar_citas.getColumnClass(0), null);
				}
			}
			catch (Exception error) {
				
				JOptionPane.showMessageDialog(
					null,
					error.getMessage(),
					"Error en la consulta de citas",
					JOptionPane.ERROR_MESSAGE,
					null
				);
			}
		};
		
		this.dni_nombre_usuario.addActionListener( (event) -> {
			
			try {
								
				if (this.dni_nombre_usuario.getText().isBlank()) {
					throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
				}
				else {
					
					ResultSet perfil = this.dbconn.consulta(
						"select Perfil from Usuarios" +
						" inner join Personas on Usuarios.DNI = Personas.DNI" +
						" where Personas.DNI = '" + this.dni_nombre_usuario.getText() + "'" +
						" or concat(Nombre,' ',Apellidos) = '" + this.dni_nombre_usuario.getText() + "';"
					);
					
					if (perfil.next()) {
						throw new Exception("No has introducido el DNI del usuario de un paciente");
					}
				}
				
				ResultSet fechas = this.dbconn.consulta(
					"select Fecha_hora from Citas" +
					" inner join Pacientes on Pacientes.ID_paciente = Citas.ID_paciente" +
					" inner join Personas on Pacientes.DNI = Personas.DNI" +
					" where (Personas.DNI = '" + this.dni_nombre_usuario.getText() + "'" +
					" or concat(Nombre,' ',Apellidos) = '" + this.dni_nombre_usuario.getText() + "')" +
					" and convert(substring_index(Fecha_hora,' ',1),DATE) > concat(year(current_date()),'-',month(current_date()),'-',day(current_date()));"
				);
				
				this.fecha.removeActionListener(evento);
								
				if (fechas.next()) {
					
					this.fecha.removeAllItems();
					this.fecha.addItem("...");
					
					fechas.previous();

					for (;fechas.next();) {
						
						String fecha_hora = fechas.getString("Fecha_hora");

						String fecha = fecha_hora.split(" ")[0];
						String hora = fecha_hora.split(" ")[1];
						
						String dia = fecha.split("-")[2];
						String mes = fecha.split("-")[1];
						String ano = fecha.split("-")[0];

						this.fecha.addItem(dia + "-" + mes + "-" + ano + " " + hora);						
					}
					
					this.fecha.setEnabled(true);
				}
				
				this.fecha.addActionListener(evento);
			}
			catch (Exception error) {
				
				this.fecha.removeAllItems();
				this.fecha.setEnabled(false);
				
				JOptionPane.showMessageDialog(
					null,
					error.getMessage(),
					"Error en la consulta de citas",
					JOptionPane.ERROR_MESSAGE,
					null
				);
			}
		});
		
		this.boton_eliminar.addActionListener( (event) -> {
			
			try {
				
				if (this.dni_nombre_usuario.getText().isBlank()) {
					throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
				}
				else {
					
					ResultSet perfil = this.dbconn.consulta(
						"select Perfil from Usuarios" +
						" inner join Personas on Usuarios.DNI = Personas.DNI" +
						" where Personas.DNI = '" + this.dni_nombre_usuario.getText() + "'" +
						" or concat(Nombre,' ',Apellidos) = '" + this.dni_nombre_usuario.getText() + "';"
					);
					
					if (perfil.next()) {
						throw new Exception("No has introducido el DNI del usuario de un paciente");
					}
				}
				
				if (this.fecha.isEnabled() == false || this.fecha.getSelectedIndex() == 0) {
					throw new Exception("No has seleccionado la fecha de la consulta correctamente");
				}
				
				ResultSet dni_usuario = this.dbconn.consulta(
					"select DNI from Personas where DNI = '" + this.dni_nombre_usuario.getText() + "'" +
					" or concat(Nombre,' ',Apellidos) = '" + this.dni_nombre_usuario.getText() + "';"
				);

				dni_usuario.next();
				
				String fecha_hora = this.fecha.getSelectedItem().toString();
				
				String fecha = fecha_hora.split(" ")[0];
				String hora = fecha_hora.split(" ")[1];
				
				String dia = fecha.split("-")[0];
				String mes = fecha.split("-")[1];
				String ano = fecha.split("-")[2];
				
				int resultado = this.dbconn.insertUpdateDelete(
					"delete Citas.* from Citas" +
					" inner join Pacientes on Citas.ID_paciente = Pacientes.ID_paciente" +
					" where DNI = '" + dni_usuario.getString("DNI") + "'" +
					" and Fecha_hora = '" + ano + "-" + mes + "-" + dia + " " + hora + "';"
				);
				
				if (resultado != 0) {
					
					JOptionPane.showMessageDialog(
						null,
						"Has eliminado la cita en la base de datos correctamente",
						"Eliminacion de consultas",
						JOptionPane.INFORMATION_MESSAGE,
						null
					);
				}
				else {
					throw new Exception("Ha ocurrido un error en la eliminacion de la consulta");
				}
			}
			catch (Exception error) {
				
				JOptionPane.showMessageDialog(
					null,
					error.getMessage(),
					"Error en la eliminacion de la consulta",
					JOptionPane.ERROR_MESSAGE,
					null
				);
			}
		});
		
		add(dni_nombre_usuario);
		add(fecha);
		add(scrollpanel);
		add(boton_eliminar);
		
		add(etiqueta_dni_nombre_usuario);
		add(etiqueta_fecha);
	}
}
