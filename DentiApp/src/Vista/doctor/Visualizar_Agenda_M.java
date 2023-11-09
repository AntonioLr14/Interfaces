package Vista.doctor;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.SwingConstants;

import Vista.Login_Inicio;

public class Visualizar_Agenda_M extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Visualizar_Agenda_M() {
		setLayout(null);
		setBounds(100, 100, 720, 500);
		setBackground(new Color(255, 255, 255));
		JLabel lblAgenda = new JLabel("Agenda");
		lblAgenda.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgenda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAgenda.setBounds(318, 27, 89, 28);
		add(lblAgenda);
		
		JTextArea taAgenda = new JTextArea();
		taAgenda.setBounds(113, 66, 511, 207);
		add(taAgenda);

		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoabajo.png")));
		lblFondo.setBounds(0, -81, 728, 527);
		add(lblFondo);

	}
}
