package Vista.administrador.gestion_medica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import java.awt.Choice;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import prueba.Campo_texto_theme;

public class Insertar_Especialidad extends JPanel {
	protected JComboBox<String> doctor;
	private Campo_texto_theme nombre_especialidad;

	// Constructores
	public Insertar_Especialidad() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(255,255, 255));
		setLayout(null);
		this.doctor = new JComboBox<String>();
		this.doctor.setBounds(411,55,205,30);
		this.doctor.setBackground(new Color(255, 255, 255));

		JLabel etiqueta_nueva_especialidad = new JLabel("Nueva especialidad:");
		etiqueta_nueva_especialidad.setBounds(103, 40, 143, 13);
		
		JLabel etiqueta_doctor = new JLabel("Doctor:");
		etiqueta_doctor.setBounds(411, 40, 52, 13);
		
		nombre_especialidad = new Campo_texto_theme(20);
		nombre_especialidad.setBounds(103, 55, 205, 30);
		add(this.doctor);
		add(etiqueta_nueva_especialidad);
		add(etiqueta_doctor);
		add(nombre_especialidad);

		
		BotonDentista btndntstAgregarEspecialidad = new BotonDentista();
		btndntstAgregarEspecialidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btndntstAgregarEspecialidad.setBorder(null);
		btndntstAgregarEspecialidad.setRadius(30);
		btndntstAgregarEspecialidad.setText("Agregar especialidad");
		btndntstAgregarEspecialidad.setBounds(267, 135, 185, 30);
		add(btndntstAgregarEspecialidad);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoabajo.png")));
		lblFondo.setBounds(0, -72, 728, 527);
		add(lblFondo);
	}
}
