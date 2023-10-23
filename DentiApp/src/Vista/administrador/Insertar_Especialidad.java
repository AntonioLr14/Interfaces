package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;

public class Insertar_Especialidad extends JPanel {

	// Atributos
	protected JTextField nombre_especialidad;
	protected JComboBox<String> doctor;

	// Constructores
	public Insertar_Especialidad() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(230, 247, 255));
		setLayout(null);
		
		// Creacion de los elementos graficos
		this.nombre_especialidad = new JTextField();
		this.doctor = new JComboBox<String>();
		
		this.nombre_especialidad.setBounds(103, 55, 205, 30);
		this.doctor.setBounds(411,55,205,30);
		this.doctor.setBackground(new Color(255, 255, 255));

		JLabel etiqueta_nueva_especialidad = new JLabel("Nueva especialidad:");
		etiqueta_nueva_especialidad.setBounds(103, 40, 143, 13);
		
		JLabel etiqueta_doctor = new JLabel("Doctor:");
		etiqueta_doctor.setBounds(411, 40, 52, 13);
		
		JButton boton_agregar = new JButton("Agregar especialidad");
		
		boton_agregar.setBounds(267, 135, 185, 30);
		boton_agregar.setContentAreaFilled(false);
		
		add(this.nombre_especialidad);
		add(this.doctor);
		add(etiqueta_nueva_especialidad);
		add(etiqueta_doctor);
		add(boton_agregar);
	}
}
