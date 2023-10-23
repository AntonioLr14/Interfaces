package Vista.doctor;

import javax.swing.JPanel;

import java.awt.Color;

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
		setBackground(new Color(230, 247, 255));
		JLabel lblAgenda = new JLabel("Agenda");
		lblAgenda.setBounds(276, 36, 45, 13);
		add(lblAgenda);
		
		JTextArea taAgenda = new JTextArea();
		taAgenda.setBounds(54, 75, 511, 207);
		add(taAgenda);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(212, 59, 173, 18);
		add(separator);

	}
}
