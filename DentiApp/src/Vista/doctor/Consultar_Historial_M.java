package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class Consultar_Historial_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfDNI_NombreCompleto;

	/**
	 * Create the panel.
	 */
	public Consultar_Historial_M() {
		setBounds(100, 100, 641, 328);
		setLayout(null);
		setBackground(new Color(230, 247, 255));
		
		JLabel lblDNI_NombreCompleto = new JLabel("DNI / Nombre completo");
		lblDNI_NombreCompleto.setBounds(89, 77, 130, 13);
		add(lblDNI_NombreCompleto);
		
		tfDNI_NombreCompleto = new JTextField();
		tfDNI_NombreCompleto.setBounds(89, 100, 115, 19);
		add(tfDNI_NombreCompleto);
		tfDNI_NombreCompleto.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setContentAreaFilled(false);
		btnConsultar.setBounds(391, 99, 85, 21);
		add(btnConsultar);
		
		JTextArea taGenerarInforme = new JTextArea();
		taGenerarInforme.setBounds(100, 157, 352, 110);
		add(taGenerarInforme);
		
		JButton btnGenerarinforme = new JButton("Generar informes");
		btnGenerarinforme.setContentAreaFilled(false);
		btnGenerarinforme.setBounds(469, 248, 166, 21);
		add(btnGenerarinforme);

	}
}
