package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Button;
import javax.swing.JButton;

public class Solicitar_Material_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Solicitar_Material_M() {
		setBounds(100, 100, 620, 328);
		setLayout(null);
		setBackground(new Color(230, 247, 255));
		JLabel lblNewLabel = new JLabel("Material");
		lblNewLabel.setBounds(153, 100, 70, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setBounds(390, 100, 80, 13);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(350, 119, 118, 25);
		add(textField);
		textField.setColumns(10);
		
		Choice choice = new Choice();
		choice.setBounds(115, 119, 124, 29);
		add(choice);
		
		JButton btnNewButton = new JButton("Solicitar");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(236, 226, 121, 28);
		add(btnNewButton);

	}
}
