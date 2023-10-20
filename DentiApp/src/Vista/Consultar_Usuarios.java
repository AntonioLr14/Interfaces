package Vista;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Consultar_Usuarios extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consultar_Usuarios frame = new Consultar_Usuarios();
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
	public Consultar_Usuarios() {
		setBounds(100, 100, 612, 325);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DNI / Nombre Completo");
		lblNewLabel.setBounds(109, 42, 139, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setBounds(497, 38, 89, 23);
		getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(100, 95, 365, 130);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Generar Informe");
		btnNewButton_1.setBounds(483, 202, 113, 23);
		getContentPane().add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(302, 39, 163, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

	}

}
