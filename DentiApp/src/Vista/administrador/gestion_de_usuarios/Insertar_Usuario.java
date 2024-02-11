package Vista.administrador.gestion_de_usuarios;

import java.security.MessageDigest;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Vista.Login_Inicio;
import botonDentista.BotonDentista;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;

public class Insertar_Usuario extends JPanel {
	
	// Atributos
	protected Campo_texto_theme dni_usuario;
	protected Campo_texto_theme nombre_usuario;
	protected Campo_texto_theme apellidos_usuario;
	protected Campo_texto_theme telefono_usuario;
	protected Despegable_editable_theme<String> perfil_usuario;
	protected BotonDentista boton_aceptar;
	protected JLabel etiqueta_dni_usuario;
	protected JLabel etiqueta_nombre_usuario;
	protected JLabel etiqueta_apellidos_usuario;
	protected JLabel etiqueta_telefono_usuario;
	protected JLabel etiqueta_perfil_usuario;
	
	// Constructores
	public Insertar_Usuario() {
				
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		
		// Creacion de los elementos graficos
		this.dni_usuario = new Campo_texto_theme(20);
		this.dni_usuario.setBounds(25, 55, 205, 30);
		
		this.nombre_usuario = new Campo_texto_theme(20);
		this.nombre_usuario.setBounds(257, 55, 205, 30);

		this.apellidos_usuario = new Campo_texto_theme(20);
		this.apellidos_usuario.setBounds(488, 55, 205, 30);
		
		this.telefono_usuario = new Campo_texto_theme(20);
		this.telefono_usuario.setBounds(103, 135, 205, 30);
				
		this.perfil_usuario = new Despegable_editable_theme<String>(20);
		this.perfil_usuario.setBounds(411, 135, 205, 30);
		
		this.perfil_usuario.addItem("...");
		this.perfil_usuario.addItem("Administrador");
		this.perfil_usuario.addItem("Doctor");
		this.perfil_usuario.addItem("Paciente");
		this.perfil_usuario.addItem("Proveedor");
		
		this.boton_aceptar = new BotonDentista();

		this.boton_aceptar.setBounds(280, 215, 160, 30);
		this.boton_aceptar.setBorder(null);
		this.boton_aceptar.setRadius(30);
		this.boton_aceptar.setText("Aceptar");
		this.boton_aceptar.setFocusable(false);

		this.etiqueta_dni_usuario = new JLabel();
		
		this.etiqueta_dni_usuario.setBounds(26, 40, 29, 14);
		this.etiqueta_dni_usuario.setText("DNI:");
		
		this.etiqueta_nombre_usuario = new JLabel();
		
		this.etiqueta_nombre_usuario.setBounds(257, 40, 60, 14);
		this.etiqueta_nombre_usuario.setText("Nombre:");
		
		this.etiqueta_apellidos_usuario = new JLabel();
		
		this.etiqueta_apellidos_usuario.setBounds(488, 40, 70, 14);
		this.etiqueta_apellidos_usuario.setText("Apellidos:");

		this.etiqueta_telefono_usuario = new JLabel();
		
		this.etiqueta_telefono_usuario.setBounds(103, 120, 67, 14);
		this.etiqueta_telefono_usuario.setText("Telefono:");

		this.etiqueta_perfil_usuario = new JLabel();
		
		this.etiqueta_perfil_usuario.setBounds(411, 120, 42, 14);
		this.etiqueta_perfil_usuario.setText("Perfil:");
		
		add(dni_usuario);
		add(nombre_usuario);
		add(apellidos_usuario);
		add(telefono_usuario);
		add(perfil_usuario);
		add(boton_aceptar);
		
		add(etiqueta_dni_usuario);
		add(etiqueta_nombre_usuario);
		add(etiqueta_apellidos_usuario);
		add(etiqueta_telefono_usuario);
		add(etiqueta_perfil_usuario);
		
		// Asignacion de los eventos
		this.boton_aceptar.addActionListener( (event) -> {
			
			try {
			
				if (this.dni_usuario.getText().isBlank()) {
					throw new Exception("No has introducido el DNI del usuario correctamente");
				}
				
				if (this.nombre_usuario.getText().isBlank()) {
					throw new Exception("No has introducido el nombre del usuario correctamente");
				}
				
				if (this.apellidos_usuario.getText().isBlank()) {
					throw new Exception("No has introducido los apellidos del usuario correctamente");
				}
				
				if (this.telefono_usuario.getText().isBlank()) {
					throw new Exception("No has introducido el telefono del usuario correctamente");
				}
				
				if (this.perfil_usuario.getSelectedIndex() == 0) {
					throw new Exception("No has seleccionado el perfil del usuario correctamente");
				}
				
				int resultado_persona = 0;
				int resultado_perfil = 0;
				
				
				String contrasena_encriptada = "";
				
				MessageDigest encriptacion = MessageDigest.getInstance("SHA3-512");
				
				byte[] contrasena_bytes = encriptacion.digest(this.dni_usuario.getText().getBytes());
				
				for (int i = 0;i < contrasena_bytes.length;i++) {
					contrasena_encriptada += String.format("%x",contrasena_bytes[i]);
				}
				
				resultado_persona = Login_Inicio.dbconn.insertUpdateDelete("insert into Personas (DNI, Nombre, Apellidos, Telefono, Correo) values ('" +
					this.dni_usuario.getText() + "','" +
					this.nombre_usuario.getText() + "','" +
					this.apellidos_usuario.getText() + "','" +
					this.telefono_usuario.getText() + "','" +
					this.nombre_usuario.getText() + "@DENTILAX.com');"
				);
				
				if (this.perfil_usuario.getSelectedItem().toString().equalsIgnoreCase("Administrador")) {
					
					resultado_perfil = Login_Inicio.dbconn.insertUpdateDelete("insert into Usuarios (DNI, Contrasena, Perfil, Estado) values ('" +
						this.dni_usuario.getText() + "','" +
						contrasena_encriptada + "','" +
						this.perfil_usuario.getSelectedItem().toString() + "'," +
						1 + ");"					
					);
				}
				
				if (this.perfil_usuario.getSelectedItem().toString().equalsIgnoreCase("Doctor")) {
					
					int dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
					int mes = Calendar.getInstance().get(Calendar.MONTH) + 1;
					int ano = Calendar.getInstance().get(Calendar.YEAR);
					
					resultado_perfil = Login_Inicio.dbconn.insertUpdateDelete("insert into Doctores (DNI, ID_especialidad, Salario, Fecha_inicio_contrato, Fecha_fin_contrato) values ('" +
						this.dni_usuario.getText() + "'," +
						1 + "," +
						1000 + ",'" +
						ano + "-" + mes + "-" + dia + "'," +
						null + ");"
					);
					
					resultado_perfil = Login_Inicio.dbconn.insertUpdateDelete("insert into Usuarios (DNI, Contrasena, Perfil, Estado) values ('" +
						this.dni_usuario.getText() + "','" +
						contrasena_encriptada + "','" +
						this.perfil_usuario.getSelectedItem().toString() + "'," +
						1 + ");"
					);
				}
				
				if (this.perfil_usuario.getSelectedItem().toString().equalsIgnoreCase("Paciente")) {
					
					resultado_perfil = Login_Inicio.dbconn.insertUpdateDelete("insert into Pacientes (DNI) values ('" +
						this.dni_usuario.getText() + "');"
					);
				}

				if (this.perfil_usuario.getSelectedItem().toString().equalsIgnoreCase("Proveedor")) {
	
					resultado_perfil = Login_Inicio.dbconn.insertUpdateDelete("insert into Proveedores (DNI, Direccion, Empresa) values ('" +
						this.dni_usuario.getText() + "'," +
						null + ",'" +
						this.nombre_usuario.getText() + " S.L.');"
					);
				}
				
				if (resultado_persona != 0 && resultado_perfil != 0) {
					
					JOptionPane.showMessageDialog(
						null,
						"Has insertado el usuario en la base de datos con exito",
						"Inserccion de usuarios",
						JOptionPane.INFORMATION_MESSAGE,
						null
					);
				}
				else {
					throw new Exception("Ha ocurrido un error en la inserccion de usuarios");
				}
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
