package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.Button;

public class Anyadir_Tratamientos extends JInternalFrame {

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
					Anyadir_Tratamientos frame = new Anyadir_Tratamientos();
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
	public Anyadir_Tratamientos() {
		setBounds(100, 100, 622, 373);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tratamiento");
		lblNewLabel.setBounds(127, 90, 88, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Precio");
		lblNewLabel_1.setBounds(302, 90, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Especialidad");
		lblNewLabel_2.setBounds(441, 90, 68, 14);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(109, 162, 132, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(251, 162, 132, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		Choice choice = new Choice();
		choice.setBounds(404, 162, 132, 20);
		getContentPane().add(choice);
		
		Button button = new Button("Agregar Tratamiento");
		button.setBounds(251, 257, 132, 22);
		getContentPane().add(button);

	}
}
