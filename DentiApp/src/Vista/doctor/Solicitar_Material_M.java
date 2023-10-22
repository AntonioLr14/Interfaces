package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Choice;
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
		
		JLabel lblNewLabel = new JLabel("Material");
		lblNewLabel.setBounds(153, 100, 70, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setBounds(390, 100, 80, 13);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(350, 119, 120, 19);
		add(textField);
		textField.setColumns(10);
		
		Choice choice = new Choice();
		choice.setBounds(115, 119, 120, 18);
		add(choice);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(236, 246, 120, 21);
		add(btnNewButton);

	}
}
