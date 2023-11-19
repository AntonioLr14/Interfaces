package Vista.administrador.gestion_de_usuarios;

import java.security.MessageDigest;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controlador.BBDD;
import botonDentista.BotonDentista;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;

public class Insertar_Usuario extends JPanel {
	
	// Atributos
	protected BBDD dbconn;
	
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
		
		perfil_usuario.addItem("...");
		perfil_usuario.addItem("admin");
		perfil_usuario.addItem("doctores");
		perfil_usuario.addItem("paciente");
		perfil_usuario.addItem("proveedor");
		
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
		
		// Asignacion de los eventos
		boton_aceptar.addActionListener( (event) -> {
			
			try {
			
				if (dni_usuario.getText().isBlank()) {
					throw new Exception("No has introducido el DNI del usuario correctamente");
				}
				
				if (nombre_usuario.getText().isBlank()) {
					throw new Exception("No has introducido el nombre del usuario correctamente");
				}
				
				if (apellidos_usuario.getText().isBlank()) {
					throw new Exception("No has introducido los apellidos del usuario correctamente");
				}
				
				if (telefono_usuario.getText().isBlank()) {
					throw new Exception("No has introducido el telefono del usuario correctamente");
				}
				
				if (perfil_usuario.getSelectedIndex() == 0) {
					throw new Exception("No has seleccionado el perfil del usuario correctamente");
				}
				
				String contrasena_encriptada = "";
				
				MessageDigest encriptacion = MessageDigest.getInstance("SHA3-512");
				
				byte[] contrasena_bytes = encriptacion.digest(dni_usuario.getText().getBytes());
				
				for (int i = 0;i < contrasena_bytes.length;i++) {
					contrasena_encriptada += String.format("%X",contrasena_bytes[i]);
				}
				
				this.dbconn = new BBDD();
				
				this.dbconn.insertar(
					"usuario",
					0 + "," +
					dni_usuario.getText() + "," +
					contrasena_encriptada + "," +
					nombre_usuario.getText() + "," +
					apellidos_usuario.getText() + "," +
					Integer.parseInt(telefono_usuario.getText()) + "," +
					perfil_usuario.getSelectedItem().toString() + "," +
					1
				);
				
				if (perfil_usuario.getSelectedItem().toString().equalsIgnoreCase("doctores")) {
					
					this.dbconn.insertar(
						"doctores",
						dni_usuario.getText() + "," +
						0 + "," +
						"null" + "," +
						"null" + "," +
						1000 + "," +
						nombre_usuario.getText() + "@DENTILAX.com"
					);
				}
				
				if (perfil_usuario.getSelectedItem().toString().equalsIgnoreCase("paciente")) {
					
					this.dbconn.insertar(
						"paciente",
						dni_usuario.getText() + "," +
						nombre_usuario.getText() + "@DENTILAX.com"
					);
				}

				if (perfil_usuario.getSelectedItem().toString().equalsIgnoreCase("proveedor")) {
	
					this.dbconn.insertar(
						"proveedor",
						0 + "," +
						"null" + "," +
						nombre_usuario.getText() + "@DENTILAX.com"
					);
				}
				
				JOptionPane.showMessageDialog(
					null,
					"Has insertado el usuario en la base de datos con exito",
					"Inserccion de usuarios",
					JOptionPane.INFORMATION_MESSAGE,
					null
				);
			}
			catch (Exception error) {
				
				JOptionPane.showMessageDialog(
					null,
					error.getMessage(),
					"Error en la inserccion de usuarios",
					JOptionPane.ERROR_MESSAGE,
					null
				);
			}
		});
	}
}
