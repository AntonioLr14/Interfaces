package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Choice;

public class Eliminar_Consulta extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Eliminar_Consulta() {
		setLayout(null);
		setBounds(100, 100, 612, 325);
		JLabel lblNewLabel = new JLabel("DNI / Nombre completo");
		lblNewLabel.setBounds(93, 64, 113, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha");
		lblNewLabel_1.setBounds(371, 64, 45, 13);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(93, 87, 121, 19);
		add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(84, 159, 385, 84);
		add(textArea);
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.setBounds(479, 222, 132, 21);
		add(btnNewButton);
		
		Choice choice = new Choice();
		choice.setBounds(371, 88, 121, 18);
		add(choice);

	}

}
