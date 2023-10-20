package Vista;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JButton;

public class Consultar_Especialidad extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Consultar_Especialidad() {
		setBounds(100, 100, 620, 328);
		setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(151, 115, 319, 148);
		add(textPane);
		
		JLabel lblNewLabel = new JLabel("Especialidad");
		lblNewLabel.setBounds(132, 23, 82, 13);
		add(lblNewLabel);
		
		Choice choice = new Choice();
		choice.setBounds(97, 53, 138, 18);
		add(choice);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setBounds(353, 53, 131, 21);
		add(btnNewButton);

	}
}
