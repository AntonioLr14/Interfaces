package Vista.administrador.gestion_de_usuarios;

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
import javax.swing.border.LineBorder;
import prueba.Campo_texto_theme;

public class Consultar_Usuarios extends JPanel {
	
	protected JTextArea consultas_usuario;
	protected Campo_texto_theme dni_nombre_usuario;

	// Constructores
	public Consultar_Usuarios() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		
		this.consultas_usuario = new JTextArea();
		
		this.consultas_usuario.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.consultas_usuario.setBounds(123, 130, 365, 130);

		JLabel etiqueta_dni_nombre_usuario = new JLabel("DNI / Nombre completo:");
		etiqueta_dni_nombre_usuario.setBounds(82, 40, 165, 14);
		
		dni_nombre_usuario = new Campo_texto_theme(20);
		dni_nombre_usuario.setBounds(82, 55, 205, 30);

		add(this.consultas_usuario);
		add(etiqueta_dni_nombre_usuario);
		add(dni_nombre_usuario);

		
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
	}
}
