package Vista.administrador.gestion_de_usuarios;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import java.sql.ResultSet;
import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import Vista.Login_Inicio;
import prueba.Campo_texto_theme;

public class Consultar_Usuarios extends JPanel {
	
	// Atributos
	protected Campo_texto_theme dni_nombre_usuario;
	protected JScrollPane scrollpanel;
	protected JTable consultas_usuario;
	protected BotonDentista boton_consultar;
	protected BotonDentista boton_generar_informes;
	protected JLabel etiqueta_dni_nombre_usuario;
	
	// Constructores
	public Consultar_Usuarios() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		
		// Creacion de los elementos graficos
		this.dni_nombre_usuario = new Campo_texto_theme(20);
		this.dni_nombre_usuario.setBounds(118, 55, 205, 30);

		this.scrollpanel = new JScrollPane();
		
		this.scrollpanel.setBounds(177, 130, 365, 130);
		this.scrollpanel.setBorder(new LineBorder(Color.black));
		this.scrollpanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		this.scrollpanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.consultas_usuario = new JTable();
		this.consultas_usuario.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		this.scrollpanel.setViewportView(consultas_usuario);
		
		this.boton_consultar = new BotonDentista();

		this.boton_consultar.setBounds(441, 55, 160, 30);
		this.boton_consultar.setBorder(null);
		this.boton_consultar.setRadius(30);
		this.boton_consultar.setText("Consultar");
		this.boton_consultar.setFocusable(false);

		this.boton_generar_informes = new BotonDentista();
		
		this.boton_generar_informes.setBounds(557, 225, 100, 35);
		this.boton_generar_informes.setBorder(null);
		this.boton_generar_informes.setRadius(30);
		this.boton_generar_informes.setText("<html><p align='center'>Generar<br>Informes</html>");
		this.boton_generar_informes.setFocusable(false);
				
		this.etiqueta_dni_nombre_usuario = new JLabel();
		
		this.etiqueta_dni_nombre_usuario.setBounds(118, 40, 165, 14);
		this.etiqueta_dni_nombre_usuario.setText("DNI / Nombre completo:");

		add(dni_nombre_usuario);
		add(scrollpanel);
		add(boton_consultar);
		add(boton_generar_informes);

		add(etiqueta_dni_nombre_usuario);
		
		// Asignacion de los eventos
		this.boton_consultar.addActionListener( (event) -> {
			
			try {
				
				if (this.dni_nombre_usuario.getText().isBlank()) {
					throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
				}
				
				DefaultTableModel modelo = (DefaultTableModel) this.consultas_usuario.getModel();
				
				for (;modelo.getRowCount() > 0;) {
					modelo.removeRow(0);
				}
				
				ResultSet perfil_usuario = Login_Inicio.dbconn.consulta("select * from Usuarios where" +
					" DNI = '" + this.dni_nombre_usuario.getText() + "';"
				);
				
				if (perfil_usuario.next()) {
					
					Login_Inicio.dbconn.cabeceraTabla(
						this.consultas_usuario,
						"select Personas.DNI, Nombre, Telefono, Perfil, Estado from Personas" +
						" inner join Usuarios on Personas.DNI = Usuarios.DNI" +
						" where Personas.DNI IS NULL;"
					);
					
					ResultSet resultado = Login_Inicio.dbconn.consulta(
						"select Personas.DNI, Nombre, Apellidos, Telefono, Perfil, Estado from Personas" +
						" inner join Usuarios on Personas.DNI = Usuarios.DNI" +
						" where Personas.DNI = '" + this.dni_nombre_usuario.getText() +
						"' or concat(Nombre,' ',Apellidos) = '" + this.dni_nombre_usuario.getText() + "';"
					);
										
					for (;resultado.next();) {
						
						String dni = resultado.getString("Personas.DNI");
						String nombre = resultado.getString("Nombre");
						String apellidos = resultado.getString("Apellidos");
						String telefono = resultado.getString("Telefono");
						String perfil = resultado.getString("Perfil");
						boolean estado = resultado.getBoolean("Estado");
						
						String[] fila = {dni,nombre + " " + apellidos,telefono,perfil,String.valueOf(estado)};
						modelo.addRow(fila);
					}
				}
				else {
					
					Login_Inicio.dbconn.cabeceraTabla(
						this.consultas_usuario,
						"select DNI, Nombre, Telefono from Personas where DNI IS NULL;"
					);
					
					ResultSet resultado = Login_Inicio.dbconn.consulta(
						"select DNI, Nombre, Apellidos, Telefono from Personas" +
						" where DNI = '" + this.dni_nombre_usuario.getText() +
						"' or concat(Nombre,' ',Apellidos) = '" + this.dni_nombre_usuario.getText() + "';"
					);
					
					for (;resultado.next();) {
						
						String dni = resultado.getString("DNI");
						String nombre = resultado.getString("Nombre");
						String apellidos = resultado.getString("Apellidos");
					    String telefono = resultado.getString("Telefono");
						
						String[] fila = {dni,nombre + " " + apellidos,telefono};
						modelo.addRow(fila);
					}
				}
				
				this.consultas_usuario.getColumnModel().getColumn(1).setHeaderValue("Nombre_Completo");
				this.consultas_usuario.setDefaultEditor(this.consultas_usuario.getColumnClass(0), null);
			}
			catch (Exception error) {
				
				JOptionPane.showMessageDialog(
					null,
					error.getMessage(),
					"Error en la consulta de usuarios",
					JOptionPane.ERROR_MESSAGE,
					null
				);
			}
		});
	}
}
