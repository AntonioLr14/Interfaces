package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import botonDentista.BotonDentista;

public class Buscar_Pacientes_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfDNI_NombreCompleto;

	/**
	 * Create the panel.
	 */
	public Buscar_Pacientes_M() {
		setLayout(null);
		setBounds(100, 100, 720, 500);
		setBackground(new Color(255, 255, 255));
		
		JLabel lblDNI_NombreCompleto = new JLabel("DNI / Nombre completo");
		lblDNI_NombreCompleto.setBounds(145, 54, 135, 13);
		add(lblDNI_NombreCompleto);
		
		tfDNI_NombreCompleto = new JTextField();
		tfDNI_NombreCompleto.setBounds(145, 77, 134, 28);
		add(tfDNI_NombreCompleto);
		tfDNI_NombreCompleto.setColumns(10);
		
		JTextArea taGenerarInforme = new JTextArea();
		taGenerarInforme.setBounds(145, 123, 369, 131);
		add(taGenerarInforme);
		
		BotonDentista btndntstConsultar = new BotonDentista();
		btndntstConsultar.setText("Consultar");
		btndntstConsultar.setRadius(30);
		btndntstConsultar.setBorder(null);
		btndntstConsultar.setBounds(351, 77, 160, 30);
		add(btndntstConsultar);
		
		BotonDentista botonDentista = new BotonDentista();
		botonDentista.setText("<html><p align='center'>Generar<br>Informes</html>");
		botonDentista.setRadius(30);
		botonDentista.setBorder(null);
		botonDentista.setBounds(524, 219, 100, 35);
		add(botonDentista);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoabajo.png")));
		lblFondo.setBounds(0, -81, 728, 527);
		add(lblFondo);

	}
}
