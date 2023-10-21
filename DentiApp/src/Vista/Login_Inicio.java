package Vista;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ConexionMySQL;
import Controlador.Controlador;
import Modelo.Usuario;

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

public class Login_Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsuario;
	private JTextField textField_1;
	private JPasswordField pfcontra;
	private String usuario;
	private String contra;
	 private ConexionMySQL conexion;
     private Controlador controlador;

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
	        conexion=new ConexionMySQL("root"," ","Dentiapp");
	           controlador=new Controlador(conexion);
	                   conectarClase();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 566);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(168, 140, 75, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(168, 237, 75, 41);
		contentPane.add(lblNewLabel_1);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(280, 142, 176, 41);
		
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		pfcontra = new JPasswordField();
		pfcontra.setBounds(280, 234, 176, 41);
		contentPane.add(pfcontra);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	                ArrayList<Usuario> lista;
					try {
						lista = controlador.ObtenerTodosArticulos();
						for(int i=0;i<lista.size();i++){
		                    if(tfUsuario.getText().equals(lista.get(i).getID_Usuario())&&(pfcontra.getText().equals(lista.get(i).getContrasenya()))){
		                        setVisible(false);
		                        Administrador admin=new Administrador();	                        
		                        admin.setVisible(true);
		                        break;
		                    }else {
		                    	JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
		                    }
		                }
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	                
			}

			public void login(String usuario, String contra) {
				
				
			}
		});
		btnNewButton.setBounds(395, 315, 97, 41);
		contentPane.add(btnNewButton);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Reestablecer Contraseña");
		lblNewLabel_2.setBounds(182, 328, 149, 14);
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
