package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JButton;

public class Insertar_Especialidad extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Insertar_Especialidad() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nueva especialidad");
		lblNewLabel.setBounds(125, 85, 102, 22);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Doctor");
		lblNewLabel_1.setBounds(392, 90, 102, 13);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(103, 131, 135, 19);
		add(textField);
		textField.setColumns(10);
		
		Choice choice = new Choice();
		choice.setBounds(356, 131, 129, 18);
		add(choice);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(243, 236, 114, 21);
		add(btnNewButton);

	}

}
