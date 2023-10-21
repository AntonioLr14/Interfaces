package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Buscar_Pacientes_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Buscar_Pacientes_M() {
		setLayout(null);
		setBounds(100, 100, 612, 325);
		
		JLabel lblNewLabel = new JLabel("DNI / Nombre completo");
		lblNewLabel.setBounds(110, 67, 135, 13);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(110, 90, 119, 19);
		add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(110, 136, 369, 131);
		add(textArea);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setBounds(374, 89, 85, 21);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Generar informe");
		btnNewButton_1.setBounds(489, 245, 119, 21);
		add(btnNewButton_1);

	}
}
