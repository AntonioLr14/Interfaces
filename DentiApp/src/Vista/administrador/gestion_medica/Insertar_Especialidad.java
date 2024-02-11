package Vista.administrador.gestion_medica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Vista.Login_Inicio;
import botonDentista.BotonDentista;
import java.sql.ResultSet;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;

public class Insertar_Especialidad extends JPanel {
	
	// Atributos
	protected Campo_texto_theme nombre_especialidad;
	protected Despegable_editable_theme<String> doctor;

	// Constructores
	public Insertar_Especialidad() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);

		// Creacion de los elementos graficos		
		this.nombre_especialidad = new Campo_texto_theme(20);
		this.nombre_especialidad.setBounds(103, 55, 205, 30);
		
		this.doctor = new Despegable_editable_theme<>(20);
		this.doctor.setBounds(411, 55, 205, 30);
		
		this.doctor.addItem("...");
		
		try {
			
			ResultSet resultset = Login_Inicio.dbconn.consulta(
				"SELECT concat(Personas.nombre,' ',Personas.apellidos) as 'Nombre completo' FROM Personas" +
				" inner join Doctores on Personas.DNI = Doctores.DNI;"
			);
			
			while (resultset.next()) {
				this.doctor.addItem(resultset.getString("Nombre completo"));
			}

		}
		catch (Exception error) {
			
			JOptionPane.showMessageDialog(
				null,
				error.getMessage(),
				"Error en la inserccion de la especialidad",
				JOptionPane.ERROR_MESSAGE,
				null
			);
		}
		
		BotonDentista boton_agregar_especialida = new BotonDentista();

		boton_agregar_especialida.setBounds(267, 135, 185, 30);
		boton_agregar_especialida.setBorder(null);
		boton_agregar_especialida.setRadius(30);
		boton_agregar_especialida.setText("Agregar especialidad");
		
		JLabel etiqueta_nueva_especialidad = new JLabel("Nueva especialidad:");
		etiqueta_nueva_especialidad.setBounds(103, 40, 143, 13);
		
		JLabel etiqueta_doctor = new JLabel("Doctor:");
		etiqueta_doctor.setBounds(411, 40, 52, 13);
		
		add(this.nombre_especialidad);
		add(this.doctor);
		add(boton_agregar_especialida);

		add(etiqueta_nueva_especialidad);
		add(etiqueta_doctor);
		
		// Establecimiento de los eventos
		boton_agregar_especialida.addActionListener( (event) -> {
				
			int resultado_especialidad = 0;
			int resultado_doctor_especialidad = 0;
			
			try {
				
				resultado_especialidad = Login_Inicio.dbconn.insertUpdateDelete(
					"INSERT INTO Especialidades (`Nombre`, `Descripcion`) VALUES ('" +
					this.nombre_especialidad.getText() + "', '" +
					"Por determinar');"
				);
				
				ResultSet resultset = Login_Inicio.dbconn.consulta(
					"SELECT DNI from Personas" +
					" where concat(Personas.nombre,' ',Personas.apellidos) = '" +
					this.doctor.getSelectedItem().toString() + "'"
				);
				
				String DNI_doctor = "";
				
				while(resultset.next()) {
					DNI_doctor = resultset.getString("DNI");
				}
				
				resultset = Login_Inicio.dbconn.consulta(
					"SELECT ID_especialidad from Especialidades" +
					" where nombre = '" + this.nombre_especialidad.getText() + "';"
				);
				
				int id_especialidad = 0;
				
				while(resultset.next()) {
					id_especialidad = resultset.getInt("ID_Especialidad");
				}
				
				resultado_doctor_especialidad = Login_Inicio.dbconn.insertUpdateDelete(
					"UPDATE Doctores set ID_especialidad = '" + id_especialidad + "'" +
					" where DNI = '" + DNI_doctor + "';"
				);
				
				if (resultado_especialidad != 0 && resultado_doctor_especialidad != 0) {
					JOptionPane.showMessageDialog(null, "Especialidad insertada con éxito al doctor " + this.doctor.getSelectedItem().toString());
				}
				else {
					throw new Exception("Ha ocurrido un error en la inserccion de la especialidad");
				}
			}
			catch (Exception error) {
				
				JOptionPane.showMessageDialog(
					null,
					error.getMessage(),
					"Error en la inserccion de la especialidad",
					JOptionPane.ERROR_MESSAGE,
					null
				);
			}
		});
	}
}
