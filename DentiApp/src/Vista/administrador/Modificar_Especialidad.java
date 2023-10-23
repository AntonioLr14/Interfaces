package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;

public class Modificar_Especialidad extends JPanel {

	// Atributos
	protected JComboBox<String> doctor;
	protected JComboBox<String> especialidad;
	
	// Constructores
	public Modificar_Especialidad() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(230, 247, 255));
		setLayout(null);
		
		// Creacion de los elementos graficos
		this.doctor = new JComboBox<String>();
		this.especialidad = new JComboBox<String>();
		
		this.doctor.setBounds(411,55,205,30);
		this.doctor.setBackground(new Color(255, 255, 255));
		this.especialidad.setBounds(103,55,205,30);
		this.especialidad.setBackground(new Color(255, 255, 255));
		
		JLabel etiqueta_doctor = new JLabel("Doctor:");
		etiqueta_doctor.setBounds(411, 40, 52, 13);
		
		JLabel etiqueta_especialidad = new JLabel("Especialidad:");
		etiqueta_especialidad.setBounds(103, 40, 94, 13);
		
		JButton boton_aceptar = new JButton("Aceptar");
		
		boton_aceptar.setBounds(280, 135, 160, 30);
		boton_aceptar.setContentAreaFilled(false);
		
		add(this.doctor);
		add(this.especialidad);
		add(etiqueta_doctor);
		add(etiqueta_especialidad);
		add(boton_aceptar);
	}
}
