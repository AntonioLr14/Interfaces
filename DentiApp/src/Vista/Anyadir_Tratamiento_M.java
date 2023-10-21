package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JButton;

public class Anyadir_Tratamiento_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Anyadir_Tratamiento_M() {
		setBounds(100, 100, 620, 328);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Insertar nombre del paciente");
		lblNewLabel.setBounds(103, 92, 140, 13);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(103, 115, 140, 19);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tratamiento");
		lblNewLabel_1.setBounds(372, 92, 81, 13);
		add(lblNewLabel_1);
		
		Choice choice = new Choice();
		choice.setBounds(337, 115, 140, 18);
		add(choice);
		
		JButton btnNewButton = new JButton("Agregar tratamiento");
		btnNewButton.setBounds(227, 270, 125, 21);
		add(btnNewButton);

	}

}
