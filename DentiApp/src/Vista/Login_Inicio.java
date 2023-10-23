package Vista;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class Login_Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsuario;
	private JTextField textField_1;
	private String usuario;
	private String contra;
	 private ConexionMySQL conexion;
     private Controlador controlador;
     private JTextField pfcontra;

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
		   this.setLocationRelativeTo(null);
	        conexion=new ConexionMySQL("jdbc:mysql://localhost:3306/dentiapp","root","1234");
	           controlador=new Controlador(conexion);
	                   conectarClase();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 566);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DNI Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(212, 140, 75, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(212, 237, 75, 41);
		contentPane.add(lblNewLabel_1);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(316, 140, 176, 41);
		
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setBackground(new Color(123, 186, 232));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	                ArrayList<Usuario> lista;
					try {
						lista = controlador.ObtenerTodosArticulos();
						boolean comprob=true;
						 if(tfUsuario.getText().equals("") || pfcontra.getText().equalsIgnoreCase("")) {
	                    	JOptionPane.showMessageDialog(null, "Debes relenar todos los campos.");
	                    }
						 else {
	                    	for(int i=0;i<lista.size();i++){
								int usu=Integer.parseInt(tfUsuario.getText());
			                    if(usu==lista.get(i).getID_Usuario()&&(pfcontra.getText().toString().equals(lista.get(i).getContrasenya()))){
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
		});
		btnNewButton.setBounds(395, 315, 97, 41);
		contentPane.add(btnNewButton);
		
		pfcontra = new JTextField();
		pfcontra.setColumns(10);
		pfcontra.setBounds(316, 237, 176, 41);
		contentPane.add(pfcontra);
		
		JButton btnReestablecerContra = new JButton("Reestablecer Contraseña");
		btnReestablecerContra.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnReestablecerContra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreu=JOptionPane.showInputDialog("Introduzca el nombre de usuario:");
				String mensaje = JOptionPane.showInputDialog("Introduzca la nueva contraseña:");
				String mensaje2 = JOptionPane.showInputDialog("Repita la contraseña");
				if(mensaje.equals(mensaje2)) {
					try {
						String consulta=controlador.UpdateUsuario( mensaje2,nombreu);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnReestablecerContra.setContentAreaFilled(false);
		btnReestablecerContra.setBorderPainted(false);
		btnReestablecerContra.setBounds(185, 324, 200, 23);
		contentPane.add(btnReestablecerContra);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondologin.png")));
		lblNewLabel_2.setBounds(0, 0, 728, 527);
		contentPane.add(lblNewLabel_2);
		
	}
	public void conectarClase(){
        try{
            conexion.conectar();
        }catch(SQLException ex){
           ex.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
}
}
