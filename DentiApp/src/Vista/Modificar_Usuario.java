package Vista;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JButton;

public class Modificar_Usuario extends JInternalFrame {

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
					Modificar_Usuario frame = new Modificar_Usuario();
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
	public Modificar_Usuario() {
		setBounds(100, 100, 612, 325);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DNI");
		lblNewLabel.setBounds(202, 58, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Operación");
		lblNewLabel_1.setBounds(440, 58, 68, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(202, 79, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		Choice choice = new Choice();
		choice.setBounds(440, 79, 115, 20);
		getContentPane().add(choice);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(334, 230, 89, 23);
		getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(281, 136, 192, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

	}

}
