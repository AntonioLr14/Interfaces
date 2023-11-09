package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;

public class Consultar_Historial_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfDNI_NombreCompleto;

	/**
	 * Create the panel.
	 */
	public Consultar_Historial_M() {
		setBounds(100, 100, 720, 500);
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		
		JLabel lblDNI_NombreCompleto = new JLabel("DNI / Nombre completo");
		lblDNI_NombreCompleto.setBounds(153, 61, 130, 13);
		add(lblDNI_NombreCompleto);
		
		tfDNI_NombreCompleto = new JTextField();
		tfDNI_NombreCompleto.setBounds(153, 84, 130, 30);
		add(tfDNI_NombreCompleto);
		tfDNI_NombreCompleto.setColumns(10);
		
		JTextArea taGenerarInforme = new JTextArea();
		taGenerarInforme.setBorder(new LineBorder(new Color(0, 0, 0)));
		taGenerarInforme.setBounds(164, 141, 352, 110);
		add(taGenerarInforme);
		
		BotonDentista btndntstConsultar = new BotonDentista();
		btndntstConsultar.setText("Consultar");
		btndntstConsultar.setRadius(30);
		btndntstConsultar.setBorder(null);
		btndntstConsultar.setBounds(394, 84, 160, 30);
		add(btndntstConsultar);
		
		BotonDentista botonDentista = new BotonDentista();
		botonDentista.setText("<html><p align='center'>Generar<br>Informes</html>");
		botonDentista.setRadius(30);
		botonDentista.setBorder(null);
		botonDentista.setBounds(526, 216, 100, 35);
		add(botonDentista);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoabajo.png")));
		lblFondo.setBounds(0, -81, 728, 527);
		add(lblFondo);

	}
}
