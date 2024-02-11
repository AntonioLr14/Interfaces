package Vista.administrador.gestion_de_usuarios;

import java.security.MessageDigest;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Vista.Login_Inicio;
import botonDentista.BotonDentista;
import prueba.Campo_contrasena_theme;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;

public class Modificar_Usuario extends JPanel {
	
	// Atributos
	protected Campo_texto_theme dni_usuario;
	protected Despegable_editable_theme<String> operacion_usuario;
	protected Campo_texto_theme valor_nombre_operacion;
	protected Campo_texto_theme valor_apellidos_operacion;
	protected Campo_contrasena_theme valor_contrasena_operacion;
	protected Despegable_editable_theme<String> valor_despegable_operacion;
	protected BotonDentista boton_aceptar;
	protected JLabel etiqueta_dni_usuario;
	protected JLabel etiqueta_operacion_usuario;
	
	// Constructores
	public Modificar_Usuario() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		
		// Creacion de los elementos graficos
		this.dni_usuario = new Campo_texto_theme(20);
		this.dni_usuario.setBounds(103, 55, 205, 30);
		
		this.operacion_usuario = new Despegable_editable_theme<String>(20);
		this.operacion_usuario.setBounds(411, 55, 205, 30);
		
		this.operacion_usuario.addItem("...");
		this.operacion_usuario.addItem("Modificar nombre y apellidos");
		this.operacion_usuario.addItem("Modificar contrasena");
		this.operacion_usuario.addItem("Modificar perfil");
		this.operacion_usuario.addItem("Modificar estado");

		this.valor_nombre_operacion = new Campo_texto_theme(20);
		
		this.valor_nombre_operacion.setBounds(103, 135, 205, 30);
		this.valor_nombre_operacion.setVisible(false);
		
		this.valor_apellidos_operacion = new Campo_texto_theme(20);
		
		this.valor_apellidos_operacion.setBounds(411, 135, 205, 30);
		this.valor_apellidos_operacion.setVisible(false);
		
		this.valor_contrasena_operacion = new Campo_contrasena_theme(20);
		
		this.valor_contrasena_operacion.setBounds(257, 135, 205, 30);
		this.valor_contrasena_operacion.setEchoChar('●');
		this.valor_contrasena_operacion.setVisible(false);
		
		this.valor_despegable_operacion = new Despegable_editable_theme<String>(20);
		
		this.valor_despegable_operacion.setBounds(257,135,205,30);
		this.valor_despegable_operacion.setVisible(false);
				
		this.boton_aceptar = new BotonDentista();
		
		this.boton_aceptar.setBounds(280, 220, 160, 30);
		this.boton_aceptar.setBorder(null);
		this.boton_aceptar.setRadius(30);
		this.boton_aceptar.setText("Aceptar");
		this.boton_aceptar.setFocusable(false);
		
		this.etiqueta_dni_usuario = new JLabel();
		
		this.etiqueta_dni_usuario.setBounds(103, 40, 165, 14);
		this.etiqueta_dni_usuario.setText("DNI:");
		
		this.etiqueta_operacion_usuario = new JLabel();
		
		this.etiqueta_operacion_usuario.setBounds(411, 40, 78, 14);
		this.etiqueta_operacion_usuario.setText("Operación:");
		
		// Asignacion de los eventos
		this.operacion_usuario.addActionListener( (event) -> {
			
			Despegable_editable_theme<String> operacion = (Despegable_editable_theme<String>) event.getSource();
			
			if (operacion.getSelectedItem().equals("Modificar nombre y apellidos")) {
				
				this.valor_nombre_operacion.setVisible(true);
				this.valor_apellidos_operacion.setVisible(true);
				this.valor_contrasena_operacion.setVisible(false);
				this.valor_despegable_operacion.setVisible(false);
			}
			
			if (operacion.getSelectedItem().equals("Modificar contrasena")) {
				
				this.valor_nombre_operacion.setVisible(false);
				this.valor_apellidos_operacion.setVisible(false);
				this.valor_contrasena_operacion.setVisible(true);
				this.valor_despegable_operacion.setVisible(false);
			}

			if (operacion.getSelectedItem().equals("Modificar perfil")) {

				this.valor_nombre_operacion.setVisible(false);
				this.valor_apellidos_operacion.setVisible(false);
				this.valor_contrasena_operacion.setVisible(false);
				this.valor_despegable_operacion.setVisible(true);
				
				this.valor_despegable_operacion.removeAllItems();
				
				this.valor_despegable_operacion.addItem("...");
				this.valor_despegable_operacion.addItem("Administrador");
				this.valor_despegable_operacion.addItem("Doctor");
			}

			if (operacion.getSelectedItem().equals("Modificar estado")) {
				
				this.valor_nombre_operacion.setVisible(false);
				this.valor_apellidos_operacion.setVisible(false);
				this.valor_contrasena_operacion.setVisible(false);
				this.valor_despegable_operacion.setVisible(true);
				
				this.valor_despegable_operacion.removeAllItems();
				
				this.valor_despegable_operacion.addItem("...");
				this.valor_despegable_operacion.addItem("Alta");
				this.valor_despegable_operacion.addItem("Baja");
			}
		});
		
		this.boton_aceptar.addActionListener( (event) -> {
			
			try {
				
				if (this.dni_usuario.getText().isBlank()) {
					throw new Exception("No has introducido el DNI del usuario correctamente");
				}
				
				if (this.operacion_usuario.getSelectedIndex() == 0) {
					throw new Exception("No has seleccionado la operacion correctamente");
				}
				
				int resultado = 0;
				
				if (this.operacion_usuario.getSelectedItem().equals("Modificar nombre y apellidos")) {
					
					if (this.valor_nombre_operacion.getText().isBlank()) {
						throw new Exception("No has introducido el nombre del usuario correctamente");
					}
					
					if (this.valor_apellidos_operacion.getText().isBlank()) {
						throw new Exception("No has introducido los apellidos del usuario correctamente");
					}
										
					resultado = Login_Inicio.dbconn.insertUpdateDelete("update Personas set Nombre = '" + this.valor_nombre_operacion.getText() + "'," +
						" Apellidos = '" + this.valor_apellidos_operacion.getText() + "' where" +
						" DNI = '" + this.dni_usuario.getText() + "';"					
					);
				}
				
				if (this.operacion_usuario.getSelectedItem().equals("Modificar contrasena")) {
					
					if (String.valueOf(this.valor_contrasena_operacion.getPassword()).isBlank()) {
						throw new Exception("No has introducido la contrasena del usuario correctamente");
					}
					
					String contrasena_ecriptada = "";
					
					MessageDigest encriptacion = MessageDigest.getInstance("SHA3-512");
					
					byte[] contrasena_bytes = encriptacion.digest(String.valueOf(this.valor_contrasena_operacion.getPassword()).getBytes());
					
					for (int i = 0;i < contrasena_bytes.length;i++) {
						contrasena_ecriptada += String.format("%x",contrasena_bytes[i]);
					}
					
					resultado = Login_Inicio.dbconn.insertUpdateDelete("update Usuarios set Contrasena = '" + contrasena_ecriptada + "'" +
						" where DNI = '" + this.dni_usuario.getText() + "';"					
					);
				}

				if (this.operacion_usuario.getSelectedItem().equals("Modificar perfil")) {

					if (this.valor_despegable_operacion.getSelectedIndex() == 0) {
						throw new Exception("No has seleccionado el perfil del usuario correctamente");
					}
					
					resultado = Login_Inicio.dbconn.insertUpdateDelete("update Usuarios set Perfil = '" + this.valor_despegable_operacion.getSelectedItem().toString() + "'" +
						" where DNI = '" + this.dni_usuario.getText() + "';"
					);
				}

				if (this.operacion_usuario.getSelectedItem().equals("Modificar estado")) {
					
					if (this.valor_despegable_operacion.getSelectedIndex() == 0) {
						throw new Exception("No has seleccionado el estado del usuario correctamente");
					}
					
					int valor = 0;
					
					if (this.valor_despegable_operacion.getSelectedItem().equals("Alta")) {
						valor = 1;
					}
					
					if (this.valor_despegable_operacion.getSelectedItem().equals("Baja")) {
						valor = 0;
					}
					
					resultado = Login_Inicio.dbconn.insertUpdateDelete("update Usuarios set Estado = " + valor + " where" +
						" DNI = '" + this.dni_usuario.getText() + "';"
					);
				}
				
				if (resultado != 0) {
					
					JOptionPane.showMessageDialog(
						null,
						"Has modificado el usuario en la base de datos con exito",
						"Modificacion de usuarios",
						JOptionPane.INFORMATION_MESSAGE,
						null
					);
				}
				else {
					throw new Exception("Ha ocurrido un error en la modificacion del usuario");
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
		
		add(dni_usuario);
		add(operacion_usuario);
		add(valor_nombre_operacion);
		add(valor_apellidos_operacion);
		add(valor_contrasena_operacion);
		add(valor_despegable_operacion);
		add(boton_aceptar);
		
		add(etiqueta_dni_usuario);
		add(etiqueta_operacion_usuario);
	}
}
