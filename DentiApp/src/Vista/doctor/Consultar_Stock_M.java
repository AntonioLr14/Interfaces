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
		lblNewLabel_1.setBounds(198, 191, 96, 13);
		add(lblNewLabel_1);
		
		Choice choice = new Choice();
		choice.setBounds(91, 106, 120, 18);
		add(choice);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setBounds(370, 106, 85, 21);
		add(btnNewButton);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(317, 191, 39, 21);
		add(textPane);

	}

}
