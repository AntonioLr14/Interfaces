package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Modificar_Tratamiento extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Modificar_Tratamiento() {
		setBounds(100, 100, 620, 328);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tratamiento");
		lblNewLabel.setBounds(145, 39, 108, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Operación");
		lblNewLabel_1.setBounds(405, 39, 119, 13);
		add(lblNewLabel_1);
		
		Choice choice = new Choice();
		choice.setBounds(122, 74, 108, 18);
		add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(382, 74, 108, 18);
		add(choice_1);
		
		textField = new JTextField();
		textField.setBounds(236, 182, 155, 19);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Modificar nombre/ Modificar precio/ Modificar estado/ Modificar especialidad");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(87, 130, 426, 13);
		add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(262, 240, 108, 21);
		add(btnNewButton);

	}
}
