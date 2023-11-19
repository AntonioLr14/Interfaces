package Vista.administrador.gestion_de_usuarios;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.Color;
import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;
import Controlador.BBDD;
import prueba.Campo_texto_theme;

public class Consultar_Usuarios extends JPanel {
	
	// Atributos
	protected BBDD dbconn;
	
	// Constructores
	public Consultar_Usuarios() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		
		// Creacion de los elementos graficos
		JTable consultas_usuario = new JTable();
		
		consultas_usuario.setBounds(177, 130, 365, 130);
		consultas_usuario.setBorder(new LineBorder(Color.black));
		consultas_usuario.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		Campo_texto_theme dni_nombre_usuario = new Campo_texto_theme(20);
		dni_nombre_usuario.setBounds(118, 55, 205, 30);
		
		BotonDentista boton_generar_informes = new BotonDentista();
		
		boton_generar_informes.setBounds(557, 225, 100, 35);
		boton_generar_informes.setBorder(null);
		boton_generar_informes.setRadius(30);
		boton_generar_informes.setText("<html><p align='center'>Generar<br>Informes</html>");
		boton_generar_informes.setFocusable(false);
		
		BotonDentista boton_consultar = new BotonDentista();

		boton_consultar.setBounds(441, 55, 160, 30);
		boton_consultar.setBorder(null);
		boton_consultar.setRadius(30);
		boton_consultar.setText("Consultar");
		boton_consultar.setFocusable(false);
		
		JLabel etiqueta_dni_nombre_usuario = new JLabel();
		
		etiqueta_dni_nombre_usuario.setBounds(118, 40, 165, 14);
		etiqueta_dni_nombre_usuario.setText("DNI / Nombre completo:");

		add(consultas_usuario);
		add(dni_nombre_usuario);
		add(boton_generar_informes);
		add(boton_consultar);

		add(etiqueta_dni_nombre_usuario);
		
		// Asignacion de los eventos
		boton_consultar.addActionListener( (event) -> {
			
			try {
				
				if (dni_nombre_usuario.getText().isBlank()) {
					throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
				}
				
				this.dbconn = new BBDD();
				
				this.dbconn.conectar();
				
				this.dbconn.SelectValor(
					consultas_usuario,
					"select DNI_Usuario, Nombre, Apellidos, Telefono, Perfil, Estado from usuario " +
					"where DNI_Usuario = '" + dni_nombre_usuario.getText() +
					"' or concat(Nombre,' ',Apellidos) = '" + dni_nombre_usuario.getText() +
					"';"
				);
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
