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
	protected Campo_texto_theme dni_nombre_usuario;
	protected Despegable_editable_theme<String> fecha;
	protected JScrollPane scrollpanel;
	protected JTable consultas_usuario;
	protected BotonDentista boton_consultar;
	protected JLabel etiqueta_dni_nombre_usuario;
	protected JLabel etiqueta_fecha;
	protected BBDD dbconn;
	
	// Constructores
	public Consultar_Consultas() {
		
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
		
		this.consultas_usuario = new JTable();
		
		this.consultas_usuario.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		this.consultas_usuario.setTableHeader(null);
		
		this.scrollpanel.setViewportView(consultas_usuario);
				
		this.boton_consultar = new BotonDentista();
		
		this.boton_consultar.setBounds(559, 151, 107, 35);
		this.boton_consultar.setBorder(null);
		this.boton_consultar.setRadius(30);
		this.boton_consultar.setText("Consultar");
		this.boton_consultar.setFocusable(false);
				
		this.etiqueta_dni_nombre_usuario = new JLabel();
		
		this.etiqueta_dni_nombre_usuario.setBounds(106, 0, 165, 13);
		this.etiqueta_dni_nombre_usuario.setText("DNI / Nombre completo:");
		
		this.etiqueta_fecha = new JLabel();
		
		this.etiqueta_fecha.setBounds(417, 0, 47, 13);
		this.etiqueta_fecha.setText("Fecha:");
		
		// Asignacion de los eventos
		this.dni_nombre_usuario.addActionListener( (event) -> {
			
			try {
				
				this.dbconn = new BBDD();
				
				this.dbconn.conectar();
				
				if (this.dni_nombre_usuario.getText().isBlank()) {
					throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
				}
				else {
					
					ArrayList<String> perfil = new ArrayList<String>(this.dbconn.SelectLista(
						"Perfil",
						"usuario where DNI_Usuario = '" + this.dni_nombre_usuario.getText() + "'" +
						"or concat(Nombre,' ',Apellidos) = '" + this.dni_nombre_usuario.getText() + "'"
					));
					
					if (perfil.size() == 0) {
						throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
					}
					
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
				
				if (fechas.size() != 0) {
					
					this.fecha.removeAllItems();
					
					this.fecha.addItem("...");

					for (int i = 0;i < fechas.size();i++) {
						this.fecha.addItem(fechas.get(i));						
					}
					
					this.fecha.setEnabled(true);
				}
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
		
		this.boton_consultar.addActionListener( (event) -> {
			
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
					
					if (perfil.size() == 0) {
						throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
					}
					
					if (!perfil.get(0).equalsIgnoreCase("paciente")) {
						throw new Exception("No has introducido el DNI del usuario de un paciente");
					}
				}
				
				if (this.fecha.isEnabled() == false || this.fecha.getSelectedIndex() == 0) {
					throw new Exception("No has seleccionado la fecha de la consulta correctamente");
				}
				
				DefaultTableModel modelo_consultas_usuario = (DefaultTableModel) this.consultas_usuario.getModel();
				
				for (;modelo_consultas_usuario.getRowCount() > 0;) {
					modelo_consultas_usuario.removeRow(0);
				}

				this.dbconn.SelectValor(
					this.consultas_usuario,
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
				
				modelo_consultas_usuario = (DefaultTableModel) this.consultas_usuario.getModel();
				
				for (int  i = 0;i < dni_doctor.size();i++) {
					
					modelo_consultas_usuario.addRow(
						new String[] {
							dni_doctor.get(i),
							id_tratamiento.get(i),
							motivo_visita.get(i)
						}
					);
				}
				
				this.consultas_usuario.setModel(modelo_consultas_usuario);
				this.consultas_usuario.setDefaultEditor(this.consultas_usuario.getColumnClass(0), null);
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
		
		add(dni_nombre_usuario);
		add(fecha);
		add(scrollpanel);
		add(boton_consultar);

		add(etiqueta_dni_nombre_usuario);
		add(etiqueta_fecha);
	}
}
