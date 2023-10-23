package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class Consultar_Factura extends JPanel {

	// Atributos
	protected JTextField dni_nombre_usuario;
	protected JTextArea consultas_facturas;

	// Constructores
	public Consultar_Factura() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(230, 247, 255));
		setLayout(null);

		// Creacion de los elementos graficos
		this.dni_nombre_usuario = new JTextField();
		this.consultas_facturas = new JTextArea();
		
		this.dni_nombre_usuario.setBounds(118, 15, 205, 30);
		this.consultas_facturas.setBounds(177,90,365,130);

		JLabel etiqueta_dni_nombre_usuario = new JLabel("DNI / Nombre completo:");
		etiqueta_dni_nombre_usuario.setBounds(118, 0, 165, 13);
		
		JButton boton_consultar = new JButton("Consultar");
		
		boton_consultar.setBounds(441, 15, 160, 30);
		boton_consultar.setContentAreaFilled(false);

		add(this.dni_nombre_usuario);
		add(this.consultas_facturas);
		add(etiqueta_dni_nombre_usuario);
		add(boton_consultar);
	}
}
