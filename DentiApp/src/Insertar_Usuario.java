import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Insertar_Usuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField_DNI;
	private JTextField textField_Nombre;
	private JTextField textField_Apellidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insertar_Usuario frame = new Insertar_Usuario();
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
	public Insertar_Usuario() {
		setBounds(100, 100, 612, 325);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DNI");
		lblNewLabel.setBounds(109, 44, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(109, 149, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Perfil");
		lblNewLabel_2.setBounds(364, 44, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Apellidos");
		lblNewLabel_3.setBounds(364, 149, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		Choice choice_Perfil = new Choice();
		choice_Perfil.setBounds(420, 38, 120, 20);
		getContentPane().add(choice_Perfil);
		
		textField_DNI = new JTextField();
		textField_DNI.setBounds(165, 41, 86, 20);
		getContentPane().add(textField_DNI);
		textField_DNI.setColumns(10);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setBounds(165, 146, 116, 20);
		getContentPane().add(textField_Nombre);
		textField_Nombre.setColumns(10);
		
		textField_Apellidos = new JTextField();
		textField_Apellidos.setBounds(420, 146, 116, 20);
		getContentPane().add(textField_Apellidos);
		textField_Apellidos.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(279, 226, 89, 23);
		getContentPane().add(btnAceptar);

	}
}
