package Vista;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JButton;

public class Modificar_Usuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;


	public Modificar_Usuario() {
		setBounds(100, 100, 612, 325);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DNI");
		lblNewLabel.setBounds(202, 58, 46, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Operación");
		lblNewLabel_1.setBounds(440, 58, 68, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(202, 79, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		Choice choice = new Choice();
		choice.setBounds(440, 79, 115, 20);
		add(choice);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(334, 230, 89, 23);
		add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(281, 136, 192, 20);
		add(textField_1);
		textField_1.setColumns(10);

	}

}
