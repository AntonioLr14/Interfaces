package Vista.administrador.gestion_de_usuarios;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
		
		this.dbconn = new BBDD();
		this.dbconn.conectar();
		
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
		this.eliminar_citas.setTableHeader(null);
		
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
						
						ArrayList<String> perfil = new ArrayList<String>(this.dbconn.SelectLista(
							"Perfil",
							"usuario where DNI_Usuario = '" + this.dni_nombre_usuario.getText() + "'" +
							"or concat(Nombre,' ',Apellidos) = '" + this.dni_nombre_usuario.getText() + "'"
						));
						
						if (!perfil.get(0).equalsIgnoreCase("paciente")) {
							throw new Exception("No has introducido el DNI del usuario de un paciente");
						}
					}
					
					DefaultTableModel modelo_eliminar_citas = (DefaultTableModel) this.eliminar_citas.getModel();
					
					for (;modelo_eliminar_citas.getRowCount() > 0;) {
						modelo_eliminar_citas.removeRow(0);
					}
	
					this.dbconn.SelectValor(
						this.eliminar_citas,
						"select ID_Doctor, ID_Tratamiento, Motivo_visita from citas" +
						" where ID_Cita IS NULL"
					);
					
					ArrayList<String> dni_doctor = new ArrayList<String>(this.dbconn.SelectLista(
						"ID_Doctor",
						"citas inner join usuario on ID_Paciente = DNI_Usuario" +
						" where (ID_Paciente = '" + this.dni_nombre_usuario.getText() + "'" +
						" or concat(Nombre,' ',Apellidos) = '" + this.dni_nombre_usuario.getText() + "')" +
						" and Fecha_Hora = '" + this.fecha.getSelectedItem().toString() + "'"
					));
					
					ArrayList<String> id_tratamiento = new ArrayList<String>(this.dbconn.SelectLista(
						"ID_Tratamiento",
						"citas inner join usuario on ID_Paciente = DNI_Usuario" +
						" where (ID_Paciente = '" + this.dni_nombre_usuario.getText() + "'" +
						" or concat(Nombre,' ',Apellidos) = '" + this.dni_nombre_usuario.getText() + "')" +
						" and Fecha_Hora = '" + this.fecha.getSelectedItem().toString() + "'"
					));
					
					ArrayList<String> motivo_visita = new ArrayList<String>(this.dbconn.SelectLista(
						"Motivo_visita",
						"citas inner join usuario on ID_Paciente = DNI_Usuario" +
						" where (ID_Paciente = '" + this.dni_nombre_usuario.getText() + "'" +
						" or concat(Nombre,' ',Apellidos) = '" + this.dni_nombre_usuario.getText() + "')" +
						" and Fecha_Hora = '" + this.fecha.getSelectedItem().toString() + "'"
					));
					
					modelo_eliminar_citas = (DefaultTableModel) this.eliminar_citas.getModel();
					
					for (int  i = 0;i < dni_doctor.size();i++) {
						
						modelo_eliminar_citas.addRow(
							new String[] {
								dni_doctor.get(i),
								id_tratamiento.get(i),
								motivo_visita.get(i)
							}
						);
					}
					
					this.eliminar_citas.setModel(modelo_eliminar_citas);
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
					
					ArrayList<String> perfil = new ArrayList<String>(this.dbconn.SelectLista(
						"Perfil",
						"usuario where DNI_Usuario = '" + this.dni_nombre_usuario.getText() + "'" +
						"or concat(Nombre,' ',Apellidos) = '" + this.dni_nombre_usuario.getText() + "'"
					));
					
					if (!perfil.get(0).equalsIgnoreCase("paciente")) {
						throw new Exception("No has introducido el DNI del usuario de un paciente");
					}
				}
				
				ArrayList<String> fechas = new ArrayList<String>(
					this.dbconn.SelectLista(
						"Fecha_Hora",
						"citas inner join usuario on ID_Paciente = DNI_Usuario" +
						" where ID_Paciente = '" + this.dni_nombre_usuario.getText() + "'" +
						" or concat(Nombre, ' ',Apellidos) = '" + this.dni_nombre_usuario.getText() + "'"
					)
				);
				
				this.fecha.removeActionListener(evento);
								
				if (fechas.size() != 0) {
					
					this.fecha.removeAllItems();
					
					this.fecha.addItem("...");

					for (int i = 0;i < fechas.size();i++) {
						this.fecha.addItem(fechas.get(i));						
					}
					
					this.fecha.setEnabled(true);
				}
				else {
					this.fecha.removeAllItems();
					this.fecha.setEnabled(false);
				}
				
				this.fecha.addActionListener(evento);
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
		});
		
		this.boton_eliminar.addActionListener( (event) -> {
			
			try {
				
				if (this.dni_nombre_usuario.getText().isBlank()) {
					throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
				}
				else {
					
					ArrayList<String> perfil = new ArrayList<String>(this.dbconn.SelectLista(
						"Perfil",
						"usuario where DNI_Usuario = '" + this.dni_nombre_usuario.getText() + "'" +
						"or concat(Nombre,' ',Apellidos) = '" + this.dni_nombre_usuario.getText() + "'"
					));
					
					if (!perfil.get(0).equalsIgnoreCase("paciente")) {
						throw new Exception("No has introducido el DNI del usuario de un paciente");
					}
				}
				
				if (this.fecha.isEnabled() == false || this.fecha.getSelectedIndex() == 0) {
					throw new Exception("No has seleccionado la fecha de la consulta correctamente");
				}
				
				this.dbconn.borrar(
					"citas",
					"ID_Paciente = '" + this.dni_nombre_usuario.getText() + "' and Fecha_Hora",
					this.fecha.getSelectedItem().toString()
				);
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
