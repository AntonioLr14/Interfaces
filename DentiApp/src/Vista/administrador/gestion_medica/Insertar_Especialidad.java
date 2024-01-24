package Vista.administrador.gestion_medica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlador.BBDD;
import Vista.Login_Inicio;

import java.awt.Choice;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;

public class Insertar_Especialidad extends JPanel {
	private Campo_texto_theme nombre_especialidad;
	private Despegable_editable_theme doctor;
	private BBDD dbconn;

	// Constructores
	public Insertar_Especialidad() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		dbconn=new BBDD();
		dbconn.conectar();

		JLabel etiqueta_nueva_especialidad = new JLabel("Nueva especialidad:");
		etiqueta_nueva_especialidad.setBounds(103, 40, 143, 13);
		
		JLabel etiqueta_doctor = new JLabel("Doctor:");
		etiqueta_doctor.setBounds(411, 40, 52, 13);
		
		nombre_especialidad = new Campo_texto_theme(20);
		nombre_especialidad.setBounds(103, 55, 205, 30);
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
		
		doctor = new Despegable_editable_theme(20);
		doctor.setBounds(411, 55, 205, 30);
		add(doctor);
		mostrarcombo(doctor);
	}
	private void mostrarcombo(JComboBox desplegable_tratamiento) {

		desplegable_tratamiento.addItem("...");
		try {
			for(String nombre:dbconn.SelectLista("Nombre", "usuario where perfil='doctores'")) {
				desplegable_tratamiento.addItem(nombre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}
