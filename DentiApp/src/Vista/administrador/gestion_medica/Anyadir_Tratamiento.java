package Vista.administrador.gestion_medica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Vista.Login_Inicio;
import botonDentista.BotonDentista;
import java.sql.ResultSet;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;

public class Anyadir_Tratamiento extends JPanel {
	
	// Atributos
	protected Campo_texto_theme nombre_tratamiento;
	protected Campo_texto_theme precio_tratamiento;
	protected Despegable_editable_theme<String> especialidad;

	// Constructores
	public Anyadir_Tratamiento(){
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		
		// Creacion de los elementos graficos		
		this.nombre_tratamiento = new Campo_texto_theme(20);
		this.nombre_tratamiento.setBounds(257, 55, 205, 30);
		
		this.precio_tratamiento = new Campo_texto_theme(20);
		this.precio_tratamiento.setBounds(26, 55, 205, 30);
		
		this.especialidad = new Despegable_editable_theme(30);
		this.especialidad.setBounds(488, 55, 205, 30);

		BotonDentista boton_agregar_tratamiento = new BotonDentista();

		boton_agregar_tratamiento.setBounds(270, 135, 180, 30);
		boton_agregar_tratamiento.setBorder(null);
		boton_agregar_tratamiento.setRadius(30);
		boton_agregar_tratamiento.setText("Agregar tratamiento");
		boton_agregar_tratamiento.setFocusable(false);
				
		JLabel etiqueta_nombre_tratamiento = new JLabel("Tratamiento:");
		etiqueta_nombre_tratamiento.setBounds(257, 40, 92, 14);
		
		JLabel etiqueta_precio_tratamiento = new JLabel("Precio:");
		etiqueta_precio_tratamiento.setBounds(26, 40, 49, 14);
		
		JLabel etiqueta_especialidad = new JLabel("Especialidad:");
		etiqueta_especialidad.setBounds(488, 40, 94, 14);
		
		add(this.nombre_tratamiento);
		add(this.precio_tratamiento);
		add(this.especialidad);
		add(boton_agregar_tratamiento);

		add(etiqueta_nombre_tratamiento);
		add(etiqueta_precio_tratamiento);
		add(etiqueta_especialidad);
		
		this.especialidad.addItem("...");
		
		try {

			ResultSet resultset = Login_Inicio.dbconn.consulta("SELECT nombre FROM Especialidades;");

			while(resultset.next()) {
				this.especialidad.addItem(resultset.getString("nombre"));
			}
		}
		catch (Exception error) {
			
			JOptionPane.showMessageDialog(
				null,
				error.getMessage(),
				"Error en la inserccion de tratamientos",
				JOptionPane.ERROR_MESSAGE,
				null
			);
		}
		
		// Establecimiento de los eventos
		boton_agregar_tratamiento.addActionListener( (event) -> {
				
			try {
				
				ResultSet resultado = Login_Inicio.dbconn.consulta(
					"SELECT ID_Especialidad from Especialidades" +
					" where nombre = '" + this.especialidad.getSelectedItem().toString() + "';"
				);
				
				resultado.next();
				
				String id_especialidad = resultado.getString("ID_Especialidad");
				
				int inserccion = Login_Inicio.dbconn.insertUpdateDelete(
					"INSERT INTO Tratamientos (`ID_especialidad`, `Nombre`, `Precio`, `Estado`) VALUES ('" +
					id_especialidad + "', '" +
					this.nombre_tratamiento.getText() + "', '" +
					this.precio_tratamiento.getText() + "', " +
					"1);"
				);
				
				if (inserccion != 0) {
					JOptionPane.showMessageDialog(null, "Nuevo tratamiento insertado con exito.");
				}
				else {
					throw new Exception("Ha ocurrido un error en la inserccion del tratamiento");
				}
			}
			catch (Exception error) {
				
				JOptionPane.showMessageDialog(
					null,
					error.getMessage(),
					"Error en la inserccion de tratamientos",
					JOptionPane.ERROR_MESSAGE,
					null
				);
			}
		});
	}
}
