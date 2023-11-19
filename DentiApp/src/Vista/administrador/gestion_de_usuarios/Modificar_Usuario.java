package Vista.administrador.gestion_de_usuarios;

import java.security.MessageDigest;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controlador.BBDD;
import botonDentista.BotonDentista;
import prueba.Campo_contrasena_theme;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;

public class Modificar_Usuario extends JPanel {
	
	// Atributos
	protected BBDD dbconn;
	
	// Constructores
	public Modificar_Usuario() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		
		// Creacion de los elementos graficos
		Campo_texto_theme valor_nombre_operacion = new Campo_texto_theme(20);
		
		valor_nombre_operacion.setBounds(103, 135, 205, 30);
		valor_nombre_operacion.setVisible(false);
		
		Campo_texto_theme valor_apellidos_operacion = new Campo_texto_theme(20);
		
		valor_apellidos_operacion.setBounds(411, 135, 205, 30);
		valor_apellidos_operacion.setVisible(false);
		
		Campo_contrasena_theme valor_contrasena_operacion = new Campo_contrasena_theme(20);
		
		valor_contrasena_operacion.setBounds(257, 135, 205, 30);
		valor_contrasena_operacion.setEchoChar('●');
		valor_contrasena_operacion.setVisible(false);
		
		Despegable_editable_theme<String> valor_despegable_operacion = new Despegable_editable_theme<String>(20);
		
		valor_despegable_operacion.setBounds(257,135,205,30);
		valor_despegable_operacion.setVisible(false);
		
		Campo_texto_theme dni_usuario = new Campo_texto_theme(20);
		dni_usuario.setBounds(103, 55, 205, 30);
		
		Despegable_editable_theme<String> operacion_usuario = new Despegable_editable_theme<String>(20);
		operacion_usuario.setBounds(411, 55, 205, 30);
		
		operacion_usuario.addItem("...");
		operacion_usuario.addItem("Modificar nombre y apellidos");
		operacion_usuario.addItem("Modificar contrasena");
		operacion_usuario.addItem("Modificar perfil");
		operacion_usuario.addItem("Modificar estado");
		
		BotonDentista boton_aceptar = new BotonDentista();
		
		boton_aceptar.setBounds(280, 220, 160, 30);
		boton_aceptar.setBorder(null);
		boton_aceptar.setRadius(30);
		boton_aceptar.setText("Aceptar");
		boton_aceptar.setFocusable(false);
		
		JLabel etiqueta_dni_usuario = new JLabel();
		
		etiqueta_dni_usuario.setBounds(103, 40, 165, 14);
		etiqueta_dni_usuario.setText("DNI:");
		
		JLabel etiqueta_operacion_usuario = new JLabel();
		
		etiqueta_operacion_usuario.setBounds(411, 40, 78, 14);
		etiqueta_operacion_usuario.setText("Operación:");
		
		// Asignacion de los eventos
		operacion_usuario.addActionListener( (event) -> {
			
			Despegable_editable_theme<String> operacion = (Despegable_editable_theme<String>) event.getSource();
			
			if (operacion.getSelectedItem().toString().equalsIgnoreCase("Modificar nombre y apellidos")) {
				
				valor_contrasena_operacion.setVisible(false);
				valor_despegable_operacion.setVisible(false);
				valor_nombre_operacion.setVisible(true);
				valor_apellidos_operacion.setVisible(true);
			}
			
			if (operacion.getSelectedItem().toString().equalsIgnoreCase("Modificar contrasena")) {
				
				valor_contrasena_operacion.setVisible(true);
				valor_despegable_operacion.setVisible(false);
				valor_nombre_operacion.setVisible(false);
				valor_apellidos_operacion.setVisible(false);
			}

			if (operacion.getSelectedItem().toString().equalsIgnoreCase("Modificar perfil")) {

				valor_contrasena_operacion.setVisible(false);
				valor_despegable_operacion.setVisible(true);
				valor_nombre_operacion.setVisible(false);
				valor_apellidos_operacion.setVisible(false);
				
				valor_despegable_operacion.removeAllItems();
				
				valor_despegable_operacion.addItem("...");
				valor_despegable_operacion.addItem("admin");
				valor_despegable_operacion.addItem("doctores");
				valor_despegable_operacion.addItem("paciente");
				valor_despegable_operacion.addItem("proveedor");
			}

			if (operacion.getSelectedItem().toString().equalsIgnoreCase("Modificar estado")) {
				
				valor_contrasena_operacion.setVisible(false);
				valor_despegable_operacion.setVisible(true);
				valor_nombre_operacion.setVisible(false);
				valor_apellidos_operacion.setVisible(false);
				
				valor_despegable_operacion.removeAllItems();
				
				valor_despegable_operacion.addItem("...");
				valor_despegable_operacion.addItem("Alta");
				valor_despegable_operacion.addItem("Baja");
			}
		});
		
		boton_aceptar.addActionListener( (event) -> {
			
			try {
				
				if (dni_usuario.getText().isBlank()) {
					throw new Exception("No has introducido el DNI del usuario correctamente");
				}
				
				if (operacion_usuario.getSelectedIndex() == 0) {
					throw new Exception("No has seleccionado la operacion correctamente");
				}
				
				this.dbconn = new BBDD();
				
				this.dbconn.conectar();
								
				if (operacion_usuario.getSelectedItem().toString().equalsIgnoreCase("Modificar nombre y apellidos")) {
					
					if (valor_nombre_operacion.getText().isBlank()) {
						throw new Exception("No has introducido el nombre del usuario correctamente");
					}
					
					if (valor_apellidos_operacion.getText().isBlank()) {
						throw new Exception("No has introducido los apellidos del usuario correctamente");
					}
					
					this.dbconn.update(
						"usuario",
						"DNI_Usuario = '" + dni_usuario.getText() + "'",
						"Nombre = '" + valor_nombre_operacion.getText() +
						"', Apellidos = '" + valor_apellidos_operacion.getText() + "'"
					);
				}
				
				if (operacion_usuario.getSelectedItem().toString().equalsIgnoreCase("Modificar contrasena")) {
					
					if (String.valueOf(valor_contrasena_operacion.getPassword()).isBlank()) {
						throw new Exception("No has introducido la contrasena del usuario correctamente");
					}
					
					String contrasena_ecriptada = "";
					
					MessageDigest encriptacion = MessageDigest.getInstance("SHA3-512");
					
					byte[] contrasena_bytes = encriptacion.digest(String.valueOf(valor_contrasena_operacion.getPassword()).getBytes());
					
					for (int i = 0;i < contrasena_bytes.length;i++) {
						contrasena_ecriptada += String.format("%X",contrasena_bytes[i]);
					}
					
					this.dbconn.update(
						"usuario",
						"DNI_Usuario = '" + dni_usuario.getText() + "'",
						"Contrasenya = '" + contrasena_ecriptada + "'"
					);
				}

				if (operacion_usuario.getSelectedItem().toString().equalsIgnoreCase("Modificar perfil")) {

					if (valor_despegable_operacion.getSelectedIndex() == 0) {
						throw new Exception("No has seleccionado el perfil el usuario correctamente");
					}
					
					this.dbconn.update(
						"usuario",
						"DNI_Usuario = '" + dni_usuario.getText() + "'",
						"Perfil = '" + valor_despegable_operacion.getSelectedItem().toString() + "'"
					);
				}

				if (operacion_usuario.getSelectedItem().toString().equalsIgnoreCase("Modificar estado")) {
					
					if (valor_despegable_operacion.getSelectedIndex() == 0) {
						throw new Exception("No has seleccionado el estado del usuario correctamente");
					}
					
					int valor = 0;
					
					if (valor_despegable_operacion.getSelectedItem().toString().equalsIgnoreCase("Alta")) {
						valor = 1;
					}
					
					if (valor_despegable_operacion.getSelectedItem().toString().equalsIgnoreCase("Baja")) {
						valor = 0;
					}
						
					this.dbconn.update(
						"usuario",
						"DNI_Usuario = '" + dni_usuario.getText() + "'",
						"Estado = " + valor
					);
				}
			}
			catch (Exception error) {
				
				JOptionPane.showMessageDialog(
					null,
					error.getMessage(),
					"Error en la modificacion del usuario",
					JOptionPane.ERROR_MESSAGE,
					null
				);
			}
		});
		
		add(valor_nombre_operacion);
		add(valor_apellidos_operacion);
		add(valor_contrasena_operacion);
		add(dni_usuario);
		add(operacion_usuario);
		add(valor_despegable_operacion);
		add(boton_aceptar);
		
		add(etiqueta_dni_usuario);
		add(etiqueta_operacion_usuario);
	}
}
