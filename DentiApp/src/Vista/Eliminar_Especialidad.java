package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JButton;

public class Eliminar_Especialidad extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Eliminar_Especialidad() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Especialidad");
		lblNewLabel.setBounds(143, 112, 83, 13);
		add(lblNewLabel);
		
		Choice choice = new Choice();
		choice.setBounds(106, 131, 135, 18);
		add(choice);
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.setBounds(344, 131, 135, 21);
		add(btnNewButton);

	}

}
