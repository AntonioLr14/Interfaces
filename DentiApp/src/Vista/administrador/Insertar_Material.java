package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Insertar_Material extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public Insertar_Material() {
		setLayout(null);
		setBounds(100, 100, 612, 325);
		JLabel lblNewLabel = new JLabel("Material");
		lblNewLabel.setBounds(128, 54, 45, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad total");
		lblNewLabel_1.setBounds(394, 54, 72, 13);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(128, 77, 119, 19);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(394, 77, 119, 19);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar material");
		btnNewButton.setBounds(260, 164, 119, 21);
		add(btnNewButton);

	}

}
