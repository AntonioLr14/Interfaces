package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class Consultar_Pedidos extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Consultar_Pedidos() {
		setBounds(100, 100, 620, 328);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Proveedor");
		lblNewLabel.setBounds(126, 42, 70, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha");
		lblNewLabel_1.setBounds(394, 42, 45, 13);
		add(lblNewLabel_1);
		
		Choice choice = new Choice();
		choice.setBounds(93, 61, 129, 18);
		add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(346, 61, 129, 18);
		add(choice_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(113, 110, 349, 147);
		add(textPane);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setBounds(497, 240, 85, 21);
		add(btnNewButton);

	}

}
