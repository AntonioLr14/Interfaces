package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class Consultar_Stock_M extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Consultar_Stock_M() {
		setBounds(100, 100, 620, 328);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Material");
		lblNewLabel.setBounds(129, 87, 68, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Unidades en stock");
		lblNewLabel_1.setBounds(198, 191, 109, 36);
		add(lblNewLabel_1);
		
		Choice choice = new Choice();
		choice.setBounds(91, 106, 120, 18);
		add(choice);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(349, 105, 105, 35);
		add(btnNewButton);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(317, 191, 52, 36);
		add(textPane);

	}

}
