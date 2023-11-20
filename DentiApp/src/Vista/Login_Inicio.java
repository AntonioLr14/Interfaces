package Vista;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.BBDD;
import Controlador.ConexionMySQL;
import Controlador.Controlador;
import Modelo.Usuario;
import Vista.administrador.Administrador;
import Vista.doctor.Medico;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.lang.System.Logger.Level;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import botonDentista.BotonDentista;
import prueba.Campo_texto_theme;
import prueba.Campo_contrasena_theme;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login_Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private String usuario;
	private String contra;
	 private ConexionMySQL conexion;
     private Controlador controlador;
     private Campo_texto_theme tfUsuario;
     private Campo_contrasena_theme pfcontra;
     private BBDD bbdd= new BBDD();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Inicio frame = new Login_Inicio();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login_Inicio() {
		//Llamada al metodo para conectar con la bbdd
		conectarClase();
		//Creacion de los paneles
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pfcontra = new Campo_contrasena_theme(20);
		pfcontra.setEchoChar('●');
		pfcontra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(!pfcontra.getText().isEmpty()) {
					if(e.getKeyCode()==KeyEvent.VK_ENTER) {
						try {
							obtenerUsuarios();
						} catch (NoSuchAlgorithmException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		pfcontra.setBounds(316, 237, 176, 41);
		contentPane.add(pfcontra);
		
	
		//Creacion de los elementos gráficos
		JLabel lblDNIUsuario = new JLabel("DNI Usuario");
		lblDNIUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDNIUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDNIUsuario.setBounds(212, 140, 75, 41);
		contentPane.add(lblDNIUsuario);
		
	 tfUsuario = new Campo_texto_theme(20);
		tfUsuario.setBounds(316, 140, 176, 41);
		contentPane.add(tfUsuario);
		
		JLabel lblContra = new JLabel("Contraseña");
		lblContra.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblContra.setHorizontalAlignment(SwingConstants.TRAILING);
		lblContra.setBounds(212, 237, 75, 41);
		contentPane.add(lblContra);
		
		JCheckBox mostrar_contra = new JCheckBox("Mostrar Contraseña");
		mostrar_contra.setContentAreaFilled(false);

		mostrar_contra.setForeground(new Color(0, 0, 0));
		mostrar_contra.setFont(new Font("Tahoma", Font.PLAIN, 11));
		mostrar_contra.setBackground(Color.WHITE);
		mostrar_contra.setBounds(212, 354, 154, 23);
		contentPane.add(mostrar_contra);
		
		JButton btnReestablecerContra = new JButton("Reestablecer Contraseña");
		btnReestablecerContra.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnReestablecerContra.setContentAreaFilled(false);
		btnReestablecerContra.setBorderPainted(false);
		btnReestablecerContra.setBounds(185, 324, 200, 23);
		contentPane.add(btnReestablecerContra);
		
		BotonDentista btndntstEntrar = new BotonDentista();
		btndntstEntrar.setBorder(null);
		btndntstEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   try {
					obtenerUsuarios();
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btndntstEntrar.setRadius(50);
		btndntstEntrar.setText("Entrar");
		btndntstEntrar.setBounds(389, 304, 112, 41);
		contentPane.add(btndntstEntrar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondologin.png")));
		lblFondo.setBounds(0, 0, 728, 527);
		contentPane.add(lblFondo);
		
		btnReestablecerContra.addActionListener(new ActionListener() {
			//Cambio de contraseña del usuario deseado
			public void actionPerformed(ActionEvent e) {
				String nombreu=JOptionPane.showInputDialog("Introduzca el DNI del usuario:");
				String mensaje = JOptionPane.showInputDialog("Introduzca la nueva contraseña:");
				String mensaje2 = JOptionPane.showInputDialog("Repita la contraseña");
				if(mensaje.equals(mensaje2)) {
					try {
						usuarioExiste(nombreu, mensaje2);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "La contraseña introducida no es la misma.");
				}
			}

			private void usuarioExiste(String nombreu, String mensaje2) throws SQLException {
				ArrayList<Usuario> lista= controlador.ObtenerTodosArticulos();
				boolean usuarioExiste=true;
				for(int i=0;i<lista.size();i++){
					if(nombreu.equals(lista.get(i).getDNI_Usuario())) {
						usuarioExiste=true;
						break;
					}else {
						usuarioExiste=false;
					}
				}
				if(usuarioExiste) {
					String consulta=controlador.UpdateUsuario( mensaje2,nombreu);
					JOptionPane.showMessageDialog(null, "Contraseña cambiada con exito.");
				}else {
					JOptionPane.showMessageDialog(null,"Usuario no existente");
				}
			}
		});
		mostrar_contra.addMouseListener(new MouseAdapter() {
			@Override
			
			//Mostrar la contraseña si el checbox está seleccionado
			public void mouseClicked(MouseEvent e) {
				if(mostrar_contra.isSelected()==true){
					pfcontra.setEchoChar((char)0); 
				}else {
					pfcontra.setEchoChar((char)'●');
				}
			}
		});

		//Características del frame
		setTitle("DentiApp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 566);
		setResizable(false);
		setLocationRelativeTo(null);
		//Introduccion del icono en la parte superior izquierda del frame
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login_Inicio.class.getResource("/Vista/imagenes/diente.png")));

	}
	//Métodos de la clase
	
	//Conecta con la base de datos
	public void conectarClase(){
        try{
	        conexion=new ConexionMySQL("jdbc:mysql://localhost:3306/dentiapp","root","1234");
	           controlador=new Controlador(conexion);
            conexion.conectar();
        }catch(SQLException ex){
           ex.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
}
	
	//Obtencion de todas las tuplas de la bbdd usuarios
	public void obtenerUsuarios() throws NoSuchAlgorithmException {
		String contrasena_encriptada = "";
		
		MessageDigest encriptacion = MessageDigest.getInstance("SHA3-512");
		
		byte[] contrasena_bytes = encriptacion.digest(String.valueOf(pfcontra.getPassword()).getBytes());
		
		for (int i = 0;i < contrasena_bytes.length;i++) {
			contrasena_encriptada += String.format("%X",contrasena_bytes[i]);
		}
		ArrayList<Usuario> lista;
		try {
			lista = controlador.ObtenerTodosArticulos();//Guardamos todos los datos de la bbdd en un arraylist de usuarios
			boolean comprob=true;
			 if(tfUsuario.getText().equals("") || String.valueOf(pfcontra.getPassword()).equalsIgnoreCase("")) {
		    	JOptionPane.showMessageDialog(null, "Debes relenar todos los campos.");
		    }
			 else {
				
		    	for(int i=0;i<lista.size();i++){
		            if(tfUsuario.getText().equals(lista.get(i).getDNI_Usuario())&&(contrasena_encriptada.equals(lista.get(i).getContrasenya()))){
		                setVisible(false);
		                if(lista.get(i).getPerfil().equalsIgnoreCase("Admin")) {
		                	 Administrador admin=new Administrador();	                        
		                        admin.setVisible(true);
		                }else {
		                	Medico medico=new Medico();
		                	medico.setVisible(true);
		                }
		             comprob=true;
		                break;
		            }
		            else {
		            	comprob=false;
		            }
		        }
		    }
			
			 if(!comprob) {
		        	JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrectos.");
		        }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
