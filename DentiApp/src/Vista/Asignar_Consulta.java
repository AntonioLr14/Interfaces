package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Asignar_Consulta extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Asignar_Consulta() {
		setLayout(null);
		setBounds(100, 100, 612, 325);
		
		JLabel lblNewLabel = new JLabel("DNI / Nombre completo");
		lblNewLabel.setBounds(92, 20, 138, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Especialidad");
		lblNewLabel_1.setBounds(364, 20, 108, 13);
		add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(80, 59, 398, 124);
		add(textArea);
		
		JButton btnNewButton = new JButton("Asignar cita");
		btnNewButton.setBounds(488, 167, 123, 21);
		add(btnNewButton);
		

	}

}
