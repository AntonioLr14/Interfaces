package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JButton;

public class Actualizar_Stock extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public Actualizar_Stock() {
		setLayout(null);
		setBounds(100, 100, 612, 325);
		JLabel lblNewLabel = new JLabel("Material");
		lblNewLabel.setBounds(119, 66, 45, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad total");
		lblNewLabel_1.setBounds(328, 66, 72, 13);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Stock");
		lblNewLabel_2.setBounds(459, 66, 45, 13);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(328, 89, 121, 19);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(459, 89, 45, 19);
		add(textField_1);
		textField_1.setColumns(10);
		
		Choice choice = new Choice();
		choice.setBounds(119, 85, 121, 18);
		add(choice);
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.setBounds(256, 226, 85, 21);
		add(btnNewButton);

	}

}
