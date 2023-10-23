package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;

public class Asignar_Consulta extends JPanel {

	// Atributos
	protected JTextField dni_nombre_usuario;
	protected JComboBox<String> especialidad;
	protected JTextArea citas_usuario;
	
	// Constructores
	public Asignar_Consulta() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(230, 247, 255));
		setLayout(null);

		// Creacion de los elementos graficos
		this.dni_nombre_usuario = new JTextField();
		this.especialidad = new JComboBox<String>();
		this.citas_usuario = new JTextArea();
		
		this.dni_nombre_usuario.setBounds(67, 15, 205, 30);
		this.especialidad.setBounds(339, 15, 205, 30);
		this.especialidad.setBackground(new Color(255, 255, 255));
		this.citas_usuario.setBounds(123, 90, 365, 130);

		JLabel etiqueta_dni_nombre_usuario = new JLabel("DNI / Nombre completo:");
		etiqueta_dni_nombre_usuario.setBounds(67, 0, 165, 13);
		
		JLabel etiqueta_especialidad = new JLabel("Especialidad:");
		etiqueta_especialidad.setBounds(339, 0, 94, 13);
				
		JButton boton_asignar_cita = new JButton("<html><p align='center'>Asignar<br>cita</html>");
		
		boton_asignar_cita.setContentAreaFilled(false);
		boton_asignar_cita.setBounds(500, 185, 100, 35);
		
		add(this.dni_nombre_usuario);
		add(this.especialidad);
		add(this.citas_usuario);
		add(etiqueta_dni_nombre_usuario);
		add(etiqueta_especialidad);
		add(boton_asignar_cita);
	}
}
