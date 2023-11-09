package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import Vista.Login_Inicio;

import javax.swing.JLabel;
import java.awt.Choice;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;

public class Consultar_Especialidad extends JPanel {

	// Atributos
	protected JComboBox<String> especialidad;
	protected JTextArea consultas_especialidad;
	
	// Constructores
	public Consultar_Especialidad() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(255,255, 255));
		setLayout(null);
		
		// Creacion de los elementos graficos
		this.especialidad = new JComboBox<String>();
		this.consultas_especialidad = new JTextArea();
		
		this.especialidad.setBounds(118,55,205,30);
		this.especialidad.setBackground(new Color(255, 255, 255));
		this.consultas_especialidad.setBounds(177, 130, 365, 130);
		
		JLabel etiqueta_especialidad = new JLabel("Especialidad:");
		etiqueta_especialidad.setBounds(118, 40, 94, 13);

		add(this.especialidad);
		add(this.consultas_especialidad);
		add(etiqueta_especialidad);
		
		BotonDentista btndntstConsultar = new BotonDentista();
		btndntstConsultar.setBorder(null);
		btndntstConsultar.setRadius(30);
		btndntstConsultar.setText("Consultar");
		btndntstConsultar.setBounds(441, 55, 160, 30);
		add(btndntstConsultar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoabajo.png")));
		lblFondo.setBounds(0, -72, 728, 527);
		add(lblFondo);
	}
}
