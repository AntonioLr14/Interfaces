package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Consultar_Historial_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Consultar_Historial_M() {
		setBounds(100, 100, 641, 328);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DNI / Nombre completo");
		lblNewLabel.setBounds(89, 77, 130, 13);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(89, 100, 115, 19);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(391, 99, 85, 21);
		add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(100, 157, 352, 110);
		add(textArea);
		
		JButton btnNewButton_1 = new JButton("Generar informes");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBounds(469, 248, 166, 21);
		add(btnNewButton_1);

	}
}
