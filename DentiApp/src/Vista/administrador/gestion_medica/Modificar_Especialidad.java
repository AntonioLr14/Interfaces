package Vista.administrador.gestion_medica;

import javax.swing.JPanel;
import Vista.Login_Inicio;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import botonDentista.BotonDentista;
import prueba.Despegable_editable_theme;

public class Modificar_Especialidad extends JPanel {
	
	// Atributos
	protected Despegable_editable_theme<String> especialidad;
	protected Despegable_editable_theme<String> doctor;
	
	// Constructores
	public Modificar_Especialidad() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		
		// Creacion de los elementos graficos
		this.especialidad = new Despegable_editable_theme<>(20);
		this.especialidad.setBounds(103, 55, 205, 30);
		
		this.doctor = new Despegable_editable_theme<>(20);
		this.doctor.setBounds(411, 55, 205, 30);
		
		this.especialidad.addItem("...");
		this.doctor.addItem("...");
		
		try {
			
			ResultSet nombre_especialidad = Login_Inicio.dbconn.consulta("SELECT nombre FROM Especialidades order by ID_especialidad;");
			
			ResultSet nombre_doctores = Login_Inicio.dbconn.consulta(
				"SELECT concat(Personas.nombre,' ',Personas.apellidos) as 'Nombre completo' FROM Personas" +
				" inner join Doctores on Personas.DNI = Doctores.DNI;"
			);
			
			while (nombre_especialidad.next()) {
				this.especialidad.addItem(nombre_especialidad.getString("nombre"));
			}

			while (nombre_doctores.next()) {
				this.doctor.addItem(nombre_doctores.getString("Nombre completo"));
			}
		}
		catch (Exception error) {
			
			JOptionPane.showMessageDialog(
				null,
				error.getMessage(),
				"Error en la modificacion de la especialidad",
				JOptionPane.ERROR_MESSAGE,
				null
			);
		}
				
		BotonDentista boton_aceptar = new BotonDentista();
		
		boton_aceptar.setBounds(280, 135, 160, 30);
		boton_aceptar.setBorder(null);
		boton_aceptar.setRadius(30);
		boton_aceptar.setText("Aceptar");
		
		JLabel etiqueta_especialidad = new JLabel("Especialidad:");
		etiqueta_especialidad.setBounds(103, 40, 94, 13);

		JLabel etiqueta_doctor = new JLabel("Doctor:");
		etiqueta_doctor.setBounds(411, 40, 52, 13);

		add(this.especialidad);
		add(this.doctor);
		add(boton_aceptar);

		add(etiqueta_especialidad);
		add(etiqueta_doctor);

		// Establecimiento de los eventos
		boton_aceptar.addActionListener( (event) -> {

			try {
				
				ResultSet resultset = Login_Inicio.dbconn.consulta(
					"SELECT DNI from Personas" +
					" where concat(Personas.nombre,' ',Personas.apellidos) = '" + this.doctor.getSelectedItem().toString() + "';"
				);
				
				String DNI_doctor = null;
				
				while(resultset.next()) {
					DNI_doctor = resultset.getString("DNI");
				}
				
				resultset = Login_Inicio.dbconn.consulta(
					"SELECT ID_especialidad from Especialidades" +
					" where nombre = '" + this.especialidad.getSelectedItem().toString() + "';"
				);
				
				resultset.next();
				
				int id_especialidad = resultset.getInt("ID_especialidad");
				
				int resultado = Login_Inicio.dbconn.insertUpdateDelete(
					"UPDATE Doctores set ID_especialidad = '" + id_especialidad + "'" +
					" where DNI = '" + DNI_doctor + "';"
				);
				
				if (resultado != 0) {
					JOptionPane.showMessageDialog(null, "Especialidad modificada con éxito para el doctor " + this.doctor.getSelectedItem().toString());
				}
				else {
					throw new Exception("Ha ocurrido un error en la modificacion de la especialidad");
				}
			}
			catch (Exception error) {
				
				JOptionPane.showMessageDialog(
					null,
					error.getMessage(),
					"Error en la modificacion de la especialidad",
					JOptionPane.ERROR_MESSAGE,
					null
				);
			}
		});
	}
}
