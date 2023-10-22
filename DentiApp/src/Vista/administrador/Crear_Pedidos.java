package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class Crear_Pedidos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Crear_Pedidos() {
		setBounds(100, 100, 620, 328);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Material");
		lblNewLabel.setBounds(106, 73, 73, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("U");
		lblNewLabel_1.setBounds(236, 73, 45, 13);
		add(lblNewLabel_1);
		
		Choice choice = new Choice();
		choice.setBounds(72, 109, 123, 18);
		add(choice);
		
		textField = new JTextField();
		textField.setBounds(232, 108, 23, 19);
		add(textField);
		textField.setColumns(10);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(376, 109, 123, 18);
		add(choice_1);
		
		JLabel lblNewLabel_2 = new JLabel("Proveedor");
		lblNewLabel_2.setBounds(399, 73, 88, 13);
		add(lblNewLabel_2);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(93, 158, 381, 97);
		add(textPane);
		
		JButton btnNewButton = new JButton("Crear pedido");
		btnNewButton.setBounds(494, 234, 102, 21);
		add(btnNewButton);

	}

}
