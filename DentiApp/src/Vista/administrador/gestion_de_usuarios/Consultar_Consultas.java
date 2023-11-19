package Vista.administrador.gestion_de_usuarios;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.util.ArrayList;
import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import Controlador.BBDD;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;

public class Consultar_Consultas extends JPanel {

	// Atributos
	protected BBDD dbconn;
	
	// Constructores
	public Consultar_Consultas() {
		
		setBounds(0, 0, 730, 325);
		setLayout(null);
		setOpaque(false);
		
		// Creacion de los elementos graficos
		JScrollPane scrollpanel = new JScrollPane();
		
		scrollpanel.setBounds(182, 56, 365, 130);
		scrollpanel.setBorder(new LineBorder(Color.black));
		scrollpanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollpanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		
		JTable consultas_usuario = new JTable();
		
		consultas_usuario.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		consultas_usuario.setTableHeader(null);
		
		scrollpanel.setViewportView(consultas_usuario);
		
		Campo_texto_theme dni_nombre_usuario = new Campo_texto_theme(20);
		dni_nombre_usuario.setBounds(106, 15, 205, 30);
		
		Despegable_editable_theme<String> fecha = new Despegable_editable_theme<String>(20);
		
		fecha.setBounds(417, 15, 205, 30);
		fecha.setEnabled(false);
		
		BotonDentista boton_consultar = new BotonDentista();
		
		boton_consultar.setBounds(559, 151, 107, 35);
		boton_consultar.setBorder(null);
		boton_consultar.setRadius(30);
		boton_consultar.setText("Consultar");
		boton_consultar.setFocusable(false);
				
		JLabel etiqueta_dni_nombre_usuario = new JLabel();
		
		etiqueta_dni_nombre_usuario.setBounds(106, 0, 165, 13);
		etiqueta_dni_nombre_usuario.setText("DNI / Nombre completo:");
		
		JLabel etiqueta_fecha = new JLabel();
		
		etiqueta_fecha.setBounds(417, 0, 47, 13);
		etiqueta_fecha.setText("Fecha:");
		
		// Asignacion de los eventos
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
		
		boton_consultar.addActionListener( (event) -> {
			
			try {
				
				if (dni_nombre_usuario.getText().isBlank()) {
					throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
				}
				
				if (fecha.isEnabled() == false || fecha.getSelectedIndex() == 0) {
					throw new Exception("No has seleccionado la fecha de la consulta correctamente");
				}
				
				DefaultTableModel modelo_consultas_usuario = (DefaultTableModel) consultas_usuario.getModel();
				
				for (;modelo_consultas_usuario.getRowCount() > 0;) {
					modelo_consultas_usuario.removeRow(0);
				}

				this.dbconn.SelectValor(
					consultas_usuario,
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
				
				modelo_consultas_usuario = (DefaultTableModel) consultas_usuario.getModel();
				
				for (int  i = 0;i < dni_doctor.size();i++) {
					
					modelo_consultas_usuario.addRow(
						new String[] {
							dni_doctor.get(i),
							id_tratamiento.get(i),
							motivo_visita.get(i)
						}
					);
				}
				
				consultas_usuario.setModel(modelo_consultas_usuario);
				consultas_usuario.setDefaultEditor(consultas_usuario.getColumnClass(0), null);
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
		
		add(scrollpanel);
		add(dni_nombre_usuario);
		add(fecha);
		add(boton_consultar);

		add(etiqueta_dni_nombre_usuario);
		add(etiqueta_fecha);
	}
}
