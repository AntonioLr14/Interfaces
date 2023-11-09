package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import botonDentista.BotonDentista;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class Consultar_Factura extends JPanel {

	// Atributos
	protected JTextField dni_nombre_usuario;
	protected JTextArea consultas_facturas;

	// Constructores
	public Consultar_Factura() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(255,255, 255));
		setLayout(null);

		// Creacion de los elementos graficos
		this.dni_nombre_usuario = new JTextField();
		this.consultas_facturas = new JTextArea();
		consultas_facturas.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		this.dni_nombre_usuario.setBounds(118, 25, 205, 30);
		this.consultas_facturas.setBounds(177,58,365,130);

		JLabel etiqueta_dni_nombre_usuario = new JLabel("DNI / Nombre completo:");
		etiqueta_dni_nombre_usuario.setBounds(118, 10, 165, 13);

		add(this.dni_nombre_usuario);
		add(this.consultas_facturas);
		add(etiqueta_dni_nombre_usuario);
		
		BotonDentista btndntstConsultar = new BotonDentista();
		btndntstConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btndntstConsultar.setText("Consultar");
		btndntstConsultar.setRadius(30);
		btndntstConsultar.setBorder(null);
		btndntstConsultar.setBounds(441, 25, 160, 30);
		add(btndntstConsultar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoadminabajo.png")));
		lblFondo.setBounds(0, 0, 728, 218);
		add(lblFondo);
	}
}
