package Vista.administrador.gestion_de_usuarios;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.sql.ResultSet;
import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import Vista.Login_Inicio;
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
								
				if (this.dni_nombre_usuario.getText().isBlank()) {
					throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
				}
				else {
					
					ResultSet perfil = Login_Inicio.dbconn.consulta(
						"select Perfil from Usuarios" +
						" inner join Personas on Usuarios.DNI = Personas.DNI" +
						" where Personas.DNI = '" + this.dni_nombre_usuario.getText() + "'" +
						" or concat(Nombre,' ',Apellidos) = '" + this.dni_nombre_usuario.getText() + "';"
					);
					
					if (perfil.next()) {
						throw new Exception("No has introducido el DNI del usuario de un paciente");
					}
				}
				
				ResultSet fechas = Login_Inicio.dbconn.consulta(
					"select Fecha_hora from Citas" +
					" inner join Pacientes on Citas.ID_paciente = Pacientes.ID_paciente" +
					" inner join Personas on Pacientes.DNI = Personas.DNI" +
					" where Personas.DNI = '" + this.dni_nombre_usuario.getText() + "'" +
					" or concat(Nombre,' ',Apellidos) = '" + this.dni_nombre_usuario.getText() + "';"
				);
				
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
					
					ResultSet perfil = Login_Inicio.dbconn.consulta(
						"select Perfil from Usuarios" +
						" inner join Personas on Usuarios.DNI = Personas.DNI" +
						" where Personas.DNI = '" + this.dni_nombre_usuario.getText() + "'" +
						" or concat(Nombre,' ',Apellidos) = '" + this.dni_nombre_usuario.getText() + "';"
					);
					
					if (perfil.next()) {
						throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
					}
				}
				
				if (this.fecha.isEnabled() == false || this.fecha.getSelectedIndex() == 0) {
					throw new Exception("No has seleccionado la fecha de la consulta correctamente");
				}
				
				DefaultTableModel modelo_consultas_usuario = (DefaultTableModel) this.consultas_usuario.getModel();
				
				for (;modelo_consultas_usuario.getRowCount() > 0;) {
					modelo_consultas_usuario.removeRow(0);
				}

				Login_Inicio.dbconn.cabeceraTabla(this.consultas_usuario,
					"select ID_doctor, ID_tratamiento, Observaciones from Citas" +
					" where ID_cita IS NULL;"
				);
				
				String fecha_hora = this.fecha.getSelectedItem().toString();
				
				String fecha = fecha_hora.split(" ")[0];
				String hora = fecha_hora.split(" ")[1];
				
				String dia = fecha.split("-")[0];
				String mes = fecha.split("-")[1];
				String ano = fecha.split("-")[2];
				
				ResultSet citas = Login_Inicio.dbconn.consulta(
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
					
					modelo_consultas_usuario.addRow(fila);
				}
				
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
