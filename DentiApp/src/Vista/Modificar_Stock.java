package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JButton;

public class Modificar_Stock extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Modificar_Stock() {
		setLayout(null);
		setBounds(100, 100, 612, 325);
		JLabel lblNewLabel = new JLabel("Material");
		lblNewLabel.setBounds(103, 66, 45, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Stock");
		lblNewLabel_1.setBounds(415, 66, 45, 13);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Estado");
		lblNewLabel_2.setBounds(285, 66, 85, 13);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(413, 89, 47, 19);
		add(textField);
		textField.setColumns(10);
		
		Choice choice = new Choice();
		choice.setBounds(103, 85, 122, 18);
		add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(285, 89, 122, 18);
		add(choice_1);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(242, 233, 85, 21);
		add(btnNewButton);

	}

}
