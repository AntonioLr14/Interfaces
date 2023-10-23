package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Choice;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Modificar_Tratamiento_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Modificar_Tratamiento_M() {
		setBounds(100, 100, 620, 328);
		setLayout(null);
		setBackground(new Color(230, 247, 255));
		
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
		lblNewLabel_2.setBounds(355, 74, 158, 13);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(355, 102, 158, 33);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(380, 193, 133, 33);
		add(btnNewButton);

	}

}
