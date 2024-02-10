package Vista.administrador.gestion_medica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controlador.BBDD;
import Vista.Login_Inicio;
import Vista.administrador.Administrador;

import java.awt.Choice;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;

public class Insertar_Especialidad extends JPanel {
	private Campo_texto_theme nombre_especialidad;
	private Despegable_editable_theme doctor;
	private ResultSet resultset;

	// Constructores
	public Insertar_Especialidad() throws Exception {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);


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
				try {
					Administrador.getDbconn().insertUpdateDelete("INSERT INTO `dentiapp`.`especialidades` (`Nombre`, `Descripcion`) VALUES ('"+nombre_especialidad.getText()+"', 'Por determinar');");
					resultset=Administrador.getDbconn().consulta("SELECT DNI from personas where concat(personas.nombre,' ',personas.apellidos) "
							+ "='"+doctor.getSelectedItem().toString()+"'" );
					String DNI_doctor=null;
					while(resultset.next()) {
						DNI_doctor=resultset.getString("DNI");
					}
					resultset=Administrador.getDbconn().consulta("SELECT ID_especialidad from especialidades where nombre='"+nombre_especialidad.getText()+"'");
					int id_especialidad=0;
					while(resultset.next()) {
						id_especialidad=resultset.getInt("ID_Especialidad");
					}
					Administrador.getDbconn().insertUpdateDelete("UPDATE doctores set ID_Especialidad='"+id_especialidad+"' where DNI='"+DNI_doctor+"'");
					JOptionPane.showMessageDialog(null, "Especialidad insertada con éxito al doctor "+doctor.getSelectedItem().toString());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				/*
				String insert=0+","+nombre_especialidad.getText()+","+"Por determinar";
				dbconn.insertar("especialidad", insert);
				String id_doctor="";
				String id_esp="";
				try {
					id_doctor = dbconn.SelectLista("DNI_Usuario", "usuario where nombre='"+doctor.getSelectedItem().toString()+"'").get(0);
					id_esp = dbconn.SelectLista("Id_especialidad", "especialidad where nombre='"+nombre_especialidad.getText()+"'").get(0);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dbconn.update("doctores", "ID_especialidad='"+id_esp+"'", "DNI='"+id_doctor+"'");*/
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
			resultset = Administrador.getDbconn().consulta("SELECT concat(personas.nombre,' ',personas.apellidos) as 'Nombre completo' FROM personas "
					+ "inner join doctores on personas.DNI=doctores.DNI;");
			while (resultset.next()) {
				desplegable_tratamiento.addItem(resultset.getString("Nombre completo"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}
