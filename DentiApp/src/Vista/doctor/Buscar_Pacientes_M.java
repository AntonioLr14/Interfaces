package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.JButton;

public class Buscar_Pacientes_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Buscar_Pacientes_M() {
		setLayout(null);
		setBounds(100, 100, 638, 325);
		setBackground(new Color(230, 247, 255));
		
		JLabel lblNewLabel = new JLabel("DNI / Nombre completo");
		lblNewLabel.setBounds(110, 67, 135, 13);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(110, 90, 134, 28);
		add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(110, 136, 369, 131);
		add(textArea);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(355, 89, 104, 21);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Generar informe");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBounds(489, 241, 139, 25);
		add(btnNewButton_1);

	}
}
