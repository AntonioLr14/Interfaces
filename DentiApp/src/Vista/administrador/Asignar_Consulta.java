package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;

public class Asignar_Consulta extends JPanel {

	// Atributos
	protected JTextField dni_nombre_usuario;
	protected JComboBox<String> especialidad;
	protected JTextArea citas_usuario;
	
	// Constructores
	public Asignar_Consulta() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		// Creacion de los elementos graficos
		
		JLabel etiqueta_dni_nombre_usuario = new JLabel("DNI / Nombre completo:");
		etiqueta_dni_nombre_usuario.setBounds(100, 0, 165, 13);
		
		this.dni_nombre_usuario = new JTextField();
		this.especialidad = new JComboBox<String>();
		
		this.dni_nombre_usuario.setBounds(100, 15, 205, 30);
		this.especialidad.setBounds(372, 15, 205, 30);
		this.especialidad.setBackground(new Color(255, 255, 255));

	
		add(this.dni_nombre_usuario);
		add(this.especialidad);
		
		JLabel etiqueta_especialidad = new JLabel("Especialidad:");
		etiqueta_especialidad.setBounds(372, 0, 94, 13);
		add(etiqueta_especialidad);
		add(etiqueta_dni_nombre_usuario);
		this.citas_usuario = new JTextArea();
		this.citas_usuario.setBounds(145, 79, 365, 130);
		add(this.citas_usuario);
		
		BotonDentista btndntstAsignarCita = new BotonDentista();
		btndntstAsignarCita.setBorder(null);
		btndntstAsignarCita.setRadius(30);
		btndntstAsignarCita.setText("<html><p align='center'>Asignar<br>cita</html>");
		btndntstAsignarCita.setBounds(520, 150, 100, 35);
		add(btndntstAsignarCita);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoadminabajo.png")));
		lblFondo.setBounds(0, 0, 730, 218);
		add(lblFondo);
	}
}
