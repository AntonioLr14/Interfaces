package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.Color;

public class Anyadir_Tratamiento_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Anyadir_Tratamiento_M() {
		setBounds(100, 100, 620, 328);
		setLayout(null);
		setBackground(new Color(230, 247, 255));
		
		Choice choice = new Choice();
		choice.setBounds(329, 115, 148, 37);
		add(choice);
		
		JLabel lblNewLabel_1 = new JLabel("Tratamiento");
		lblNewLabel_1.setBounds(372, 92, 81, 13);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(103, 115, 154, 26);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Insertar nombre del paciente");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(103, 92, 170, 13);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Agregar tratamiento");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(213, 238, 185, 37);
		add(btnNewButton);

	}

}
