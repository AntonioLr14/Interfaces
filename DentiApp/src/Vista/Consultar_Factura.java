package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Consultar_Factura extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Consultar_Factura() {
		setLayout(null);
		setBounds(100, 100, 612, 325);
		JLabel lblNewLabel = new JLabel("DNI / Nombre completo");
		lblNewLabel.setBounds(85, 72, 107, 13);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(85, 95, 120, 19);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(360, 94, 85, 21);
		add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(100, 140, 385, 109);
		add(textArea);

	}

}
