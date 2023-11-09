package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;

public class Consultar_Consultas extends JPanel {

	// Atributos
	protected JTextField dni_nombre_usuario;
	protected JComboBox<String> fecha;
	protected JTextArea consultas_usuario;

	// Constructores
	public Consultar_Consultas() {
		
		setBounds(0, 0, 730, 325);
		setBackground(new Color(230, 247, 255));
		setLayout(null);
		
		// Creacion de los elementos graficos
		this.dni_nombre_usuario = new JTextField();
		this.fecha = new JComboBox<String>();
		this.consultas_usuario = new JTextArea();
		consultas_usuario.setBorder(new LineBorder(new Color(0, 0, 0)));

		this.dni_nombre_usuario.setBounds(100, 15, 205, 30);
		this.fecha.setBounds(372, 15, 205, 30);
		this.fecha.setBackground(new Color(255, 255, 255));
		this.consultas_usuario.setBounds(152, 56, 365, 130);

		JLabel etiqueta_dni_nombre_usuario = new JLabel("DNI / Nombre completo:");
		etiqueta_dni_nombre_usuario.setBounds(100, 0, 165, 13);
		
		JLabel etiqueta_fecha = new JLabel("Fecha:");
		etiqueta_fecha.setBounds(372, 0, 47, 13);

		add(this.dni_nombre_usuario);
		add(this.fecha);
		add(this.consultas_usuario);
		add(etiqueta_dni_nombre_usuario);
		add(etiqueta_fecha);
		
		BotonDentista btndntstConsultar = new BotonDentista();
		btndntstConsultar.setBorder(null);
		btndntstConsultar.setRadius(30);
		btndntstConsultar.setText("Consultar");
		btndntstConsultar.setBounds(528, 139, 107, 35);
		add(btndntstConsultar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoadminabajo.png")));
		lblFondo.setBounds(0, 0, 728, 218);
		add(lblFondo);
	}
}
