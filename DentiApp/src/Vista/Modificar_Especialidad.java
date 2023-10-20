package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JButton;

public class Modificar_Especialidad extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Modificar_Especialidad() {
		setBounds(100, 100, 620, 328);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Doctor");
		lblNewLabel.setBounds(138, 71, 60, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Especialidad");
		lblNewLabel_1.setBounds(387, 71, 85, 13);
		add(lblNewLabel_1);
		
		Choice choice = new Choice();
		choice.setBounds(104, 103, 119, 18);
		add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(353, 103, 119, 18);
		add(choice_1);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(237, 226, 109, 21);
		add(btnNewButton);

	}
}
