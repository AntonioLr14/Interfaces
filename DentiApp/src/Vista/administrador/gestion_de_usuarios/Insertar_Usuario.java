package Vista.administrador.gestion_de_usuarios;

import javax.swing.JLabel;
import javax.swing.JPanel;
import botonDentista.BotonDentista;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;

public class Insertar_Usuario extends JPanel {
	
	// Constructores
	public Insertar_Usuario() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		
		// Creacion de los elementos graficos
		Campo_texto_theme apellidos_usuario = new Campo_texto_theme(20);
		apellidos_usuario.setBounds(488, 55, 205, 30);
		
		Campo_texto_theme telefono_usuario = new Campo_texto_theme(20);
		telefono_usuario.setBounds(103, 135, 205, 30);
		
		Campo_texto_theme dni_usuario = new Campo_texto_theme(20);
		dni_usuario.setBounds(25, 55, 205, 30);
		
		Campo_texto_theme nombre_usuario = new Campo_texto_theme(20);
		nombre_usuario.setBounds(257, 55, 205, 30);
		
		Despegable_editable_theme<String> perfil_usuario = new Despegable_editable_theme<String>(20);
		perfil_usuario.setBounds(411, 135, 205, 30);
		
		BotonDentista boton_aceptar = new BotonDentista();

		boton_aceptar.setBounds(280, 215, 160, 30);
		boton_aceptar.setBorder(null);
		boton_aceptar.setRadius(30);
		boton_aceptar.setText("Aceptar");
		boton_aceptar.setFocusable(false);

		JLabel etiqueta_dni_usuario = new JLabel();
		
		etiqueta_dni_usuario.setBounds(26, 40, 29, 14);
		etiqueta_dni_usuario.setText("DNI:");
		
		JLabel etiqueta_nombre_usuario = new JLabel();
		
		etiqueta_nombre_usuario.setBounds(257, 40, 60, 14);
		etiqueta_nombre_usuario.setText("Nombre:");
		
		JLabel etiqueta_apellidos_usuario = new JLabel();
		
		etiqueta_apellidos_usuario.setBounds(488, 40, 70, 14);
		etiqueta_apellidos_usuario.setText("Apellidos:");

		JLabel etiqueta_telefono = new JLabel();
		
		etiqueta_telefono.setBounds(103, 120, 67, 14);
		etiqueta_telefono.setText("Telefono:");

		JLabel etiqueta_perfil_usuario = new JLabel();
		
		etiqueta_perfil_usuario.setBounds(411, 120, 42, 14);
		etiqueta_perfil_usuario.setText("Perfil:");
		
		add(apellidos_usuario);
		add(telefono_usuario);
		add(dni_usuario);
		add(nombre_usuario);
		add(perfil_usuario);
		add(boton_aceptar);
		
		add(etiqueta_dni_usuario);
		add(etiqueta_nombre_usuario);
		add(etiqueta_perfil_usuario);
		add(etiqueta_apellidos_usuario);
		add(etiqueta_telefono);
	}
}
