package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Consultar_Consultas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Consultar_Consultas() {
		setLayout(null);
		setBounds(100, 100, 612, 325);
		
		JLabel lblNewLabel = new JLabel("DNI / Nombre completo");
		lblNewLabel.setBounds(91, 48, 157, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha");
		lblNewLabel_1.setBounds(388, 48, 82, 13);
		add(lblNewLabel_1);
		
		Choice choice = new Choice();
		choice.setBounds(388, 67, 120, 18);
		add(choice);
		
		textField = new JTextField();
		textField.setBounds(91, 71, 120, 19);
		add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(121, 119, 365, 122);
		add(textArea);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setBounds(496, 220, 117, 21);
		add(btnNewButton);

	}
}
