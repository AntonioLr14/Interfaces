package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controlador.BBDD;
import Vista.administrador.Administrador;
import Vista.doctor.Medico;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.security.MessageDigest;
import java.sql.ResultSet;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import botonDentista.BotonDentista;
import prueba.Campo_texto_theme;
import prueba.Campo_contrasena_theme;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login_Inicio extends JFrame {

	// Atributos
	protected JPanel contentPane;
    protected Campo_texto_theme dni_usuario;
    protected Campo_contrasena_theme contrasena_usuario;
    protected JCheckBox mostrar_contrasena;
    protected JButton boton_restablecer_contrasena;
    protected BotonDentista boton_aceptar;
    protected JLabel etiqueta_dni_usuario;
    protected JLabel etiqueta_contrasena_usuario;
    protected JLabel etiqueta_fondo;
    protected BBDD dbconn;
    
    // Constructores
	public Login_Inicio() {
		
        try {
        	this.dbconn = new BBDD();
        	this.dbconn.conectar();
        }
        catch(Exception error){
        	
        	JOptionPane.showMessageDialog(
				null,
				error.getMessage(),
				"Error en la autenticacion de usuarios",
				JOptionPane.ERROR_MESSAGE,
				null
			);
        }
		
		// Creacion de los paneles
		this.contentPane = new JPanel();
		
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		
		//Establecimiento del fondo del panel
		 
		this.etiqueta_fondo = new JLabel();
		
		this.etiqueta_fondo.setBounds(0, 0, 728, 527);
		this.etiqueta_fondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondologin.png")));
		
		// Creacion de los elementos graficos
		this.contrasena_usuario = new Campo_contrasena_theme(20);
		
		this.contrasena_usuario.setBounds(316, 237, 176, 41);
		this.contrasena_usuario.setEchoChar('●');
			
	    this.dni_usuario = new Campo_texto_theme(20);
		this.dni_usuario.setBounds(316, 140, 176, 41);
				
		this.mostrar_contrasena = new JCheckBox();
		
		this.mostrar_contrasena.setBounds(212, 354, 154, 23);
		this.mostrar_contrasena.setContentAreaFilled(false);
		this.mostrar_contrasena.setFont(new Font("Tahoma", Font.PLAIN, 11));
		this.mostrar_contrasena.setText("Mostrar Contrasena");
		this.mostrar_contrasena.setForeground(Color.black);
		this.mostrar_contrasena.setBackground(Color.white);
		this.mostrar_contrasena.setFocusable(false);
		
		this.boton_restablecer_contrasena = new JButton();
		
		this.boton_restablecer_contrasena.setBounds(185, 324, 200, 23);
		this.boton_restablecer_contrasena.setContentAreaFilled(false);
		this.boton_restablecer_contrasena.setBorderPainted(false);
		this.boton_restablecer_contrasena.setFont(new Font("Tahoma", Font.PLAIN, 11));
		this.boton_restablecer_contrasena.setText("Reestablecer Contrasena");
		this.boton_restablecer_contrasena.setFocusable(false);
		
		this.boton_aceptar = new BotonDentista();
		
		this.boton_aceptar.setBounds(389, 304, 112, 41);
		this.boton_aceptar.setRadius(50);
		this.boton_aceptar.setBorder(null);
		this.boton_aceptar.setText("Entrar");
		this.boton_aceptar.setFocusable(false);
		
		this.etiqueta_dni_usuario = new JLabel();
		
		this.etiqueta_dni_usuario.setBounds(212, 140, 75, 41);
		this.etiqueta_dni_usuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		this.etiqueta_dni_usuario.setText("DNI Usuario");
		this.etiqueta_dni_usuario.setHorizontalAlignment(SwingConstants.TRAILING);
		
		this.etiqueta_contrasena_usuario = new JLabel();
		
		this.etiqueta_contrasena_usuario.setBounds(212, 237, 75, 41);
		this.etiqueta_contrasena_usuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		this.etiqueta_contrasena_usuario.setText("Contrasena");
		this.etiqueta_contrasena_usuario.setHorizontalAlignment(SwingConstants.TRAILING);
		
		this.contentPane.add(dni_usuario);
		this.contentPane.add(contrasena_usuario);
		this.contentPane.add(mostrar_contrasena);
		this.contentPane.add(boton_restablecer_contrasena);
		this.contentPane.add(boton_aceptar);
		
		this.contentPane.add(etiqueta_dni_usuario);
		this.contentPane.add(etiqueta_contrasena_usuario);

		this.contentPane.add(etiqueta_fondo);

		setContentPane(contentPane);
		
		// Establecimiento de los eventos
		
		// Establecimiento de los eventos de teclado
		this.dni_usuario.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent event) {
				
				if (event.getKeyCode() == KeyEvent.VK_ENTER) {
					boton_aceptar.doClick();
				}
			}
		});
		
		this.contrasena_usuario.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent event) {
				
				if (event.getKeyCode() == KeyEvent.VK_ENTER) {
					boton_aceptar.doClick();
				}
			}
		});

		// Establecimiento de los eventos de click del raton
		this.mostrar_contrasena.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent event) {
				
				if(mostrar_contrasena.isSelected() == true){
					contrasena_usuario.setEchoChar((char) 0); 
				}
				else {
					contrasena_usuario.setEchoChar((char) '●');
				}
			}
		});
		
		// Establecimiento de los eventos de accion
		this.boton_restablecer_contrasena.addActionListener((event) -> {
			
			try {

				String dni = JOptionPane.showInputDialog("Introduzca el DNI del usuario:");
				String contrasena = JOptionPane.showInputDialog("Introduzca la nueva contraseña:");
				String contrasenaval = JOptionPane.showInputDialog("Repita la contraseña:");

				if(contrasena.equals(contrasenaval)) {
					
					String contrasena_encriptada = "";
					
					MessageDigest encriptacion = MessageDigest.getInstance("SHA3-512");
					
					byte[] contrasena_bytes = encriptacion.digest(contrasena.getBytes());
					
					for (int i = 0;i < contrasena_bytes.length;i++) {
						contrasena_encriptada += String.format("%x",contrasena_bytes[i]);
					}
					
					ResultSet usuario = this.dbconn.consulta(
						"select DNI from Usuarios" +
						" where DNI = '" + dni + "';"
					);
					
					usuario.next();
					String dni_usuario = usuario.getString("DNI");
						
					if(dni.equals(dni_usuario)) {
						
						int resultado = this.dbconn.insertUpdateDelete(
							"update Usuarios set Contrasena = '" + contrasena_encriptada + "'" +
							" where DNI = '" + dni + "';"
						);
						
						if (resultado != 0) {
							JOptionPane.showMessageDialog(null, "Contraseña cambiada con exito.");
						}
						else {
							throw new Exception("Ha ocurrido un error en el restablecimiento de la contrasena");
						}
					}
					else {
						throw new Exception("El usuario no existe");
					}
				}
				else {
					throw new Exception("La contraseña introducida no es la misma.");
				}
			}
			catch (Exception error) {
				JOptionPane.showMessageDialog(null, error.getMessage());
			}
		});
		
		this.boton_aceptar.addActionListener((event) -> {
			
		    try {
		    	
		    	if (this.dni_usuario.getText().isBlank()) {
					throw new Exception("Debes relenar todos los campos.");
				}
				
				if (String.valueOf(this.contrasena_usuario.getPassword()).isBlank()) {
					throw new Exception("Debes relenar todos los campos.");
				}
				
				String contrasena_encriptada = "";
				
				MessageDigest encriptacion = MessageDigest.getInstance("SHA3-512");
				
				byte[] contrasena_bytes = encriptacion.digest(String.valueOf(contrasena_usuario.getPassword()).getBytes());
				
				for (int i = 0;i < contrasena_bytes.length;i++) {
					contrasena_encriptada += String.format("%x",contrasena_bytes[i]);
				}
				
				ResultSet usuario = this.dbconn.consulta(
					"select DNI, Contrasena, Perfil from Usuarios" +
					" where DNI = '" + this.dni_usuario.getText() + "';"
				);
				
				usuario.next();
				
				String dni = usuario.getString("DNI");
				String contrasena = usuario.getString("Contrasena");
				String perfil = usuario.getString("Perfil");
		    		
	            if (this.dni_usuario.getText().equals(dni) && (contrasena_encriptada.equals(contrasena))){
	                
	                if (perfil.equalsIgnoreCase("Administrador")) {
	                	                	
	                	Administrador admin = new Administrador();
	                    admin.setVisible(true);
	                    
	                	dispose();
	                }
	                
	                if (perfil.equalsIgnoreCase("Doctor")){
	                	                	
	                	Medico medico = new Medico();
	                	medico.setVisible(true);
	                	
	                	dispose();
	                }
	            }
	            else {
	    			throw new Exception("Usuario o Contraseña incorrectos.");
				}
		    }
		    catch (Exception error) {
		    	JOptionPane.showMessageDialog(null, error.getMessage());
		    }
		});
		
		// Caracteristicas del frame
		setTitle("DentiApp");
		setResizable(false);
		
		setIconImage(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/diente.png")).getImage());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(744, 566));
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		Login_Inicio frame = new Login_Inicio();
		frame.setVisible(true);
	}
}
