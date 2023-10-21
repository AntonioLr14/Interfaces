package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Modificar_Tratamiento_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Modificar_Tratamiento_M() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tratamiento antiguo");
		lblNewLabel.setBounds(102, 74, 93, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tratamiento nuevo");
		lblNewLabel_1.setBounds(102, 165, 93, 13);
		add(lblNewLabel_1);
		
		Choice choice = new Choice();
		choice.setBounds(91, 103, 120, 18);
		add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(91, 196, 120, 18);
		add(choice_1);
		
		JLabel lblNewLabel_2 = new JLabel("Insertar nombre del paciente");
		lblNewLabel_2.setBounds(380, 74, 133, 13);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(380, 102, 133, 19);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(380, 193, 133, 21);
		add(btnNewButton);

	}

}
