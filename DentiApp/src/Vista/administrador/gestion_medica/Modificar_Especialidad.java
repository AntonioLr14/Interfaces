package Vista.administrador.gestion_medica;

import javax.swing.JPanel;

import Vista.Login_Inicio;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;
import prueba.Despegable_editable_theme;

public class Modificar_Especialidad extends JPanel {
	private Despegable_editable_theme especialidad;
	private Despegable_editable_theme doctor;
	
	
	// Constructores
	public Modificar_Especialidad() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		
		JLabel etiqueta_doctor = new JLabel("Doctor:");
		etiqueta_doctor.setBounds(411, 40, 52, 13);
		
		JLabel etiqueta_especialidad = new JLabel("Especialidad:");
		etiqueta_especialidad.setBounds(103, 40, 94, 13);
		add(etiqueta_doctor);
		add(etiqueta_especialidad);
		
		BotonDentista btndntstAceptar = new BotonDentista();
		btndntstAceptar.setText("Aceptar");
		btndntstAceptar.setRadius(30);
		btndntstAceptar.setBorder(null);
		btndntstAceptar.setBounds(280, 135, 160, 30);
		add(btndntstAceptar);
		
		especialidad = new Despegable_editable_theme(20);
		especialidad.setBounds(103, 55, 205, 30);
		add(especialidad);
		
		doctor = new Despegable_editable_theme(20);
		doctor.setBounds(411, 55, 205, 30);
		add(doctor);
	}
}
