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
		lblNewLabel.setBounds(137, 67, 46, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Operación");
		lblNewLabel_1.setBounds(378, 67, 68, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(137, 88, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		Choice choice = new Choice();
		choice.setBounds(378, 88, 115, 20);
		add(choice);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(258, 225, 89, 33);
		add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(205, 150, 194, 33);
		add(textField_1);
		textField_1.setColumns(10);

	}

}
