package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JSeparator;

public class Visualizar_Agenda_M extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Visualizar_Agenda_M() {
		setLayout(null);
		setBounds(100, 100, 612, 325);
		
		JLabel lblNewLabel = new JLabel("Agenda");
		lblNewLabel.setBounds(276, 36, 45, 13);
		add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(54, 75, 511, 207);
		add(textArea);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(212, 59, 173, 18);
		add(separator);

	}
}
