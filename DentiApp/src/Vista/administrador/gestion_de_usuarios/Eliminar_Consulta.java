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
	protected BBDD dbconn;
	
	// Constructores
	public Eliminar_Consulta() {
		
		setBounds(0, 0, 730, 325);
		setLayout(null);
		setOpaque(false);
		
		// Creacion de los elementos graficos
		JScrollPane scrollpanel = new JScrollPane();
		
		scrollpanel.setBounds(182, 56, 365, 130);
		scrollpanel.setBorder(new LineBorder(Color.black));
		scrollpanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollpanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		
		JTable eliminar_citas = new JTable();
		
		eliminar_citas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		eliminar_citas.setTableHeader(null);
		
		scrollpanel.setViewportView(eliminar_citas);
		
		Campo_texto_theme dni_nombre_usuario = new Campo_texto_theme(20);
		dni_nombre_usuario.setBounds(106, 15, 205, 30);
		
		Despegable_editable_theme<String> fecha = new Despegable_editable_theme<String>(20);
		
		fecha.setBounds(417, 15, 205, 30);
		fecha.setEnabled(false);

		BotonDentista boton_eliminar = new BotonDentista();
		
		boton_eliminar.setBounds(559, 151, 100, 35);
		boton_eliminar.setBorder(null);
		boton_eliminar.setRadius(30);
		boton_eliminar.setText("Eliminar");
		boton_eliminar.setFocusable(false);
				
		JLabel etiqueta_dni_nombre_usuario = new JLabel();
		
		etiqueta_dni_nombre_usuario.setBounds(106, 0, 165, 13);
		etiqueta_dni_nombre_usuario.setText("DNI / Nombre completo:");
		
		JLabel etiqueta_fecha = new JLabel();
		
		etiqueta_fecha.setBounds(417, 0, 47, 13);
		etiqueta_fecha.setText("Fecha:");
		
		// Asignacion de los eventos
		ActionListener evento = (event) -> {
			
			try {
				
				if (dni_nombre_usuario.getText().isBlank()) {
					throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
				}
				
				if (fecha.getSelectedIndex() != 0) {
					
					DefaultTableModel modelo_eliminar_citas = (DefaultTableModel) eliminar_citas.getModel();
					
					for (;modelo_eliminar_citas.getRowCount() > 0;) {
						modelo_eliminar_citas.removeRow(0);
					}
	
					this.dbconn.SelectValor(
						eliminar_citas,
						"select ID_Doctor, ID_Tratamiento, Motivo_visita from citas" +
						" where ID_Cita IS NULL"
					);
					
					ArrayList<String> dni_doctor = new ArrayList<String>(this.dbconn.SelectLista(
						"ID_Doctor",
						"citas inner join usuario on ID_Paciente = DNI_Usuario" +
						" where (ID_Paciente = '" + dni_nombre_usuario.getText() + "'" +
						" or concat(Nombre,' ',Apellidos) = '" + dni_nombre_usuario.getText() + "')" +
						" and Fecha_Hora = '" + fecha.getSelectedItem().toString() + "'"
					));
					
					ArrayList<String> id_tratamiento = new ArrayList<String>(this.dbconn.SelectLista(
						"ID_Tratamiento",
						"citas inner join usuario on ID_Paciente = DNI_Usuario" +
						" where (ID_Paciente = '" + dni_nombre_usuario.getText() + "'" +
						" or concat(Nombre,' ',Apellidos) = '" + dni_nombre_usuario.getText() + "')" +
						" and Fecha_Hora = '" + fecha.getSelectedItem().toString() + "'"
					));
					
					ArrayList<String> motivo_visita = new ArrayList<String>(this.dbconn.SelectLista(
						"Motivo_visita",
						"citas inner join usuario on ID_Paciente = DNI_Usuario" +
						" where (ID_Paciente = '" + dni_nombre_usuario.getText() + "'" +
						" or concat(Nombre,' ',Apellidos) = '" + dni_nombre_usuario.getText() + "')" +
						" and Fecha_Hora = '" + fecha.getSelectedItem().toString() + "'"
					));
					
					modelo_eliminar_citas = (DefaultTableModel) eliminar_citas.getModel();
					
					for (int  i = 0;i < dni_doctor.size();i++) {
						
						modelo_eliminar_citas.addRow(
							new String[] {
								dni_doctor.get(i),
								id_tratamiento.get(i),
								motivo_visita.get(i)
							}
						);
					}
					
					eliminar_citas.setModel(modelo_eliminar_citas);
					eliminar_citas.setDefaultEditor(eliminar_citas.getColumnClass(0), null);
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
		
		dni_nombre_usuario.addActionListener( (event) -> {
			
			try {
				
				this.dbconn = new BBDD();
				
				this.dbconn.conectar();
				
				ArrayList<String> fechas = new ArrayList<String>(
					this.dbconn.SelectLista(
						"Fecha_Hora",
						"citas inner join usuario on ID_Paciente = DNI_Usuario" +
						" where ID_Paciente = '" + dni_nombre_usuario.getText() + "'" +
						" or concat(Nombre, ' ',Apellidos) = '" + dni_nombre_usuario.getText() + "'"
					)
				);
				
				fecha.removeActionListener(evento);
								
				if (fechas.size() != 0) {
					
					fecha.removeAllItems();
					
					fecha.addItem("...");

					for (int i = 0;i < fechas.size();i++) {
						fecha.addItem(fechas.get(i));						
					}
					
					fecha.setEnabled(true);
				}
				else {
					fecha.removeAllItems();
					fecha.setEnabled(false);
				}
				
				fecha.addActionListener(evento);
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
		
		boton_eliminar.addActionListener( (event) -> {
			
			try {
				
				if (dni_nombre_usuario.getText().isBlank()) {
					throw new Exception("No has introducido el DNI o el nombre de usuario correctamente");
				}
				
				if (fecha.isEnabled() == false || fecha.getSelectedIndex() == 0) {
					throw new Exception("No has seleccionado la fecha de la consulta correctamente");
				}
				
				this.dbconn.borrar(
					"citas",
					"ID_Paciente = '" + dni_nombre_usuario.getText() + "' and Fecha_Hora",
					fecha.getSelectedItem().toString()
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
		
		add(scrollpanel);
		add(dni_nombre_usuario);
		add(fecha);
		add(boton_eliminar);
		
		add(etiqueta_dni_nombre_usuario);
		add(etiqueta_fecha);
	}
}
