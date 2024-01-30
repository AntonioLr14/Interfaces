package Vista.administrador.gestion_medica;

import javax.swing.JPanel;

import Controlador.BBDD;
import Vista.Login_Inicio;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.sql.SQLException;

import botonDentista.BotonDentista;
import prueba.Despegable_editable_theme;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Modificar_Especialidad extends JPanel {
	private Despegable_editable_theme especialidad;
	private Despegable_editable_theme doctor;
	private BBDD dbconn;
	
	
	// Constructores
	public Modificar_Especialidad() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		dbconn=new BBDD();
		dbconn.conectar();
		
		JLabel etiqueta_doctor = new JLabel("Doctor:");
		etiqueta_doctor.setBounds(411, 40, 52, 13);
		
		JLabel etiqueta_especialidad = new JLabel("Especialidad:");
		etiqueta_especialidad.setBounds(103, 40, 94, 13);
		add(etiqueta_doctor);
		add(etiqueta_especialidad);
		
		BotonDentista btndntstAceptar = new BotonDentista();
		btndntstAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id_esp=dbconn.SelectLista("ID_Especialidad", " especialidad where nombre='"+especialidad.getSelectedItem().toString()+"'").get(0);
					String dni_doc=dbconn.SelectLista("DNI_Usuario", " usuario where nombre='"+doctor.getSelectedItem().toString()+"'").get(0);
					dbconn.update("doctores", "ID_Especialidad='"+id_esp+"'", "DNI='"+dni_doc+"'");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
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
		mostrarcombo(especialidad,"especialidad");
		mostrarcombo(doctor,"usuario where perfil='doctores'");
	}
	private void mostrarcombo(JComboBox desplegable_tratamiento,String tabla) {

		desplegable_tratamiento.addItem("...");
		try {
			for(String nombre:dbconn.SelectLista("Nombre", tabla)) {
				desplegable_tratamiento.addItem(nombre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}
