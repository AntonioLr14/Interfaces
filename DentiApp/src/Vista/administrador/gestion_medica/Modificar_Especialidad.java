package Vista.administrador.gestion_medica;

import javax.swing.JPanel;

import Controlador.BBDD;
import Vista.Login_Inicio;
import Vista.administrador.Administrador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.JobAttributes;
import java.sql.ResultSet;
import java.sql.SQLException;

import botonDentista.BotonDentista;
import prueba.Despegable_editable_theme;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Modificar_Especialidad extends JPanel {
	private Despegable_editable_theme especialidad;
	private Despegable_editable_theme doctor;
	private ResultSet resultset;
	
	
	// Constructores
	public Modificar_Especialidad() throws Exception {
		
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
		btndntstAceptar.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				try {
					
					resultset=Administrador.getDbconn().consulta("SELECT DNI from personas where concat(personas.nombre,' ',personas.apellidos) "
							+ "='"+doctor.getSelectedItem().toString()+"'" );
					String DNI_doctor=null;
					while(resultset.next()) {
						DNI_doctor=resultset.getString("DNI");
					}
					resultset=Administrador.getDbconn().consulta("SELECT ID_especialidad from especialidades where nombre='"+especialidad.getSelectedItem().toString()+"'");
					int id_especialidad=0;
					while(resultset.next()) {
						id_especialidad=resultset.getInt("ID_Especialidad");
					}
					Administrador.getDbconn().insertUpdateDelete("UPDATE doctores set ID_Especialidad='"+id_especialidad+"' where DNI='"+DNI_doctor+"'");
					JOptionPane.showMessageDialog(null, "Especialidad modificada con éxito para el doctor "+doctor.getSelectedItem().toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
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
		especialidad.addItem("...");
		doctor.addItem("...");
		try {
			resultset = Administrador.getDbconn().consulta("SELECT concat(personas.nombre,' ',personas.apellidos) as 'Nombre completo' FROM personas "
					+ "inner join doctores on personas.DNI=doctores.DNI;");
			while (resultset.next()) {
				doctor.addItem(resultset.getString("Nombre completo"));
			}
			resultset = Administrador.getDbconn().consulta("SELECT nombre FROM especialidades order by ID_Especialidad;");
			while (resultset.next()) {
				especialidad.addItem(resultset.getString("nombre"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mostrarcombo(especialidad,"especialidad");
		mostrarcombo(doctor,"usuario where perfil='doctores'");
	}
	private void mostrarcombo(JComboBox desplegable_tratamiento,String tabla) {

		desplegable_tratamiento.addItem("...");
		
		}
}
