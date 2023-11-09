package Vista.administrador;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import Vista.Login_Inicio;
import botonDentista.BotonDentista;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Consultar_Usuarios extends JPanel {

	// Atributos
	protected JTextField dni_nombre_usuario;
	protected JTextArea consultas_usuario;

	// Constructores
	public Consultar_Usuarios() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(255,255, 255));
		setLayout(null);
		
		// Creacion de los elementos graficos
		this.dni_nombre_usuario = new JTextField();
		this.consultas_usuario = new JTextArea();

		this.dni_nombre_usuario.setBounds(82, 55, 205, 30);
		this.consultas_usuario.setBounds(123, 130, 365, 130);

		JLabel etiqueta_dni_nombre_usuario = new JLabel("DNI / Nombre completo:");
		etiqueta_dni_nombre_usuario.setBounds(82, 40, 165, 14);

		add(this.consultas_usuario);
		add(this.dni_nombre_usuario);
		add(etiqueta_dni_nombre_usuario);
		
		BotonDentista botonDentista = new BotonDentista();
		botonDentista.setBorder(null);
		botonDentista.setRadius(30);
		botonDentista.setText("<html><p align='center'>Generar<br>Informes</html>");
		botonDentista.setBounds(500, 225, 100, 35);
		add(botonDentista);
		
		BotonDentista btndntstConsultar = new BotonDentista();
		btndntstConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btndntstConsultar.setText("Consultar");
		btndntstConsultar.setRadius(30);
		btndntstConsultar.setBorder(null);
		btndntstConsultar.setBounds(369, 55, 160, 30);
		add(btndntstConsultar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoabajo.png")));
		lblFondo.setBounds(0, -72, 728, 527);
		add(lblFondo);
		
		
	}
}
