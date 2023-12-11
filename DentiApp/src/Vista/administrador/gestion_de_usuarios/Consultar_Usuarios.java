package Vista.administrador.gestion_de_usuarios;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;
import Controlador.BBDD;
import prueba.Campo_texto_theme;

public class Consultar_Usuarios extends JPanel {
	
	// Atributos
	protected Campo_texto_theme dni_nombre_usuario;
	protected JScrollPane scrollpanel;
	protected JTable consultas_usuario;
	protected BotonDentista boton_consultar;
	protected BotonDentista boton_generar_informes;
	protected JLabel etiqueta_dni_nombre_usuario;
	protected BBDD dbconn;
	
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
		this.consultas_usuario.setTableHeader(null);
		
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
				
				this.dbconn = new BBDD();
				
				this.dbconn.conectar();
				
				this.dbconn.SelectValor(
					this.consultas_usuario,
					"select DNI_Usuario, Nombre, Apellidos, Telefono, Perfil, Estado from usuario " +
					"where DNI_Usuario = '" + this.dni_nombre_usuario.getText() +
					"' or concat(Nombre,' ',Apellidos) = '" + this.dni_nombre_usuario.getText() +
					"';"
				);
				
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
