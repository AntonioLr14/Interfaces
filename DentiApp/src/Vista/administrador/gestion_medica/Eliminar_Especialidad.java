package Vista.administrador.gestion_medica;

import javax.swing.JPanel;
import Vista.Login_Inicio;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import botonDentista.BotonDentista;
import prueba.Despegable_editable_theme;

public class Eliminar_Especialidad extends JPanel {
	
	// Atributos
	protected Despegable_editable_theme<String> especialidad;

	// Constructores
	public Eliminar_Especialidad() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);

		// Creacion de los elementos graficos
		this.especialidad = new Despegable_editable_theme<>(20);
		this.especialidad.setBounds(120, 90, 205, 30);
		
		this.especialidad.addItem("...");
		
		try {
			
			ResultSet resultset = Login_Inicio.dbconn.consulta("SELECT nombre FROM Especialidades;");
			
			while (resultset.next()) {
				this.especialidad.addItem(resultset.getString("nombre"));
			}
		}
		catch (Exception error) {
			
			JOptionPane.showMessageDialog(
				null,
				error.getMessage(),
				"Error en la eliminacion de la especialidad",
				JOptionPane.ERROR_MESSAGE,
				null
			);
		}
		
		BotonDentista boton_eliminar = new BotonDentista();
				
		boton_eliminar.setBounds(443, 90, 160, 30);
		boton_eliminar.setBorder(null);
		boton_eliminar.setRadius(30);
		boton_eliminar.setText("Eliminar");
		boton_eliminar.setFocusable(false);
		
		JLabel etiqueta_especialidad = new JLabel("Especialidad:");
		etiqueta_especialidad.setBounds(120, 75, 94, 13);
		
		add(this.especialidad);
		add(boton_eliminar);
		
		add(etiqueta_especialidad);

		// Establecimiento de los eventos
		boton_eliminar.addActionListener( (event) -> {
			
			try {
				
				int resultado = Login_Inicio.dbconn.insertUpdateDelete("DELETE from Especialidades" +
					" where nombre = '" + this.especialidad.getSelectedItem().toString() + "';"
				);
				
				if (resultado != 0) {
					JOptionPane.showMessageDialog(null, "La especilidad se ha eliminado correctamente");
				}
				else {
					throw new Exception("Ha ocurrido un error en la eliminacion de la especialidad");
				}
			}
			catch (Exception error) {
				
				JOptionPane.showMessageDialog(
					null,
					error.getMessage(),
					"Error en la eliminacion de la especialidad",
					JOptionPane.ERROR_MESSAGE,
					null
				);
			}
		});
	}
}
