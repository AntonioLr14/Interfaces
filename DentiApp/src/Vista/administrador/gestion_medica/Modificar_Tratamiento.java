package Vista.administrador.gestion_medica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Vista.Login_Inicio;
import java.sql.ResultSet;
import botonDentista.BotonDentista;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;
import javax.swing.SwingConstants;

public class Modificar_Tratamiento extends JPanel {
	
	protected Campo_texto_theme modificacion_tratamiento;
	protected Despegable_editable_theme<String> operacion;
	protected Despegable_editable_theme<String> tratamiento;

	// Constructores
	public Modificar_Tratamiento(){

		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);

		// Creacion de los elementos graficos
		this.modificacion_tratamiento = new Campo_texto_theme(20);
		this.modificacion_tratamiento.setBounds(257, 141, 205, 30);
		
		this.operacion = new Despegable_editable_theme<>(20);
		this.operacion.setBounds(103, 55, 205, 30);
		
		this.operacion.addItem("...");
		this.operacion.addItem("Modificar nombre");
		this.operacion.addItem("Modificar precio");
		this.operacion.addItem("Modificar estado");
		this.operacion.addItem("Modificar especialidad");

		this.tratamiento = new Despegable_editable_theme<>(20);
		this.tratamiento.setBounds(411, 55, 205, 30);
		
		try {
			
			ResultSet resultset = Login_Inicio.dbconn.consulta("SELECT nombre FROM Tratamientos;");

			while (resultset.next()) {
				this.tratamiento.addItem(resultset.getString("nombre"));
			}
		}
		catch (Exception error) {
			
			JOptionPane.showMessageDialog(
				null,
				error.getMessage(),
				"Error en la modificacion del tratamiento",
				JOptionPane.ERROR_MESSAGE,
				null
			);
		}
		
		BotonDentista boton_aceptar = new BotonDentista();

		boton_aceptar.setBounds(280, 205, 160, 30);
		boton_aceptar.setBorder(null);
		boton_aceptar.setRadius(30);
		boton_aceptar.setText("Aceptar");
		boton_aceptar.setFocusable(false);
		
		JLabel etiqueta_tratamiento = new JLabel("Tratamiento:");
		etiqueta_tratamiento.setBounds(411, 40, 92, 13);

		JLabel etiqueta_operacion = new JLabel("Operación:");
		etiqueta_operacion.setBounds(103, 40, 78, 13);

		JLabel etiqueta_valor = new JLabel("Nuevo valor:");
		
		etiqueta_valor.setBounds(257, 111, 205, 29);
		etiqueta_valor.setHorizontalAlignment(SwingConstants.CENTER);
		
		add(this.modificacion_tratamiento);
		add(this.operacion);
		add(this.tratamiento);
		add(boton_aceptar);

		add(etiqueta_tratamiento);
		add(etiqueta_operacion);
		add(etiqueta_valor);

		// Establecimiento de los eventos
		boton_aceptar.addActionListener( (event) -> {
			
			int opcion = this.operacion.getSelectedIndex();
			int resultado = 0;
			
			try {
				
				if (opcion == 0) {
					throw new Exception("Elige una operación.");
				}

				if (opcion == 1) {
					
					resultado = Login_Inicio.dbconn.insertUpdateDelete(
						"UPDATE Tratamientos SET nombre = '" + this.modificacion_tratamiento.getText() + "'" +
						" where nombre = '" + this.tratamiento.getSelectedItem().toString() + "'"
					);
				}
				
				if (opcion == 2) {
						
					resultado = Login_Inicio.dbconn.insertUpdateDelete(
						"UPDATE Tratamientos SET precio = " + this.modificacion_tratamiento.getText() +
						" where nombre = '" + this.tratamiento.getSelectedItem().toString() + "'"
					);
				}
				
				if (opcion == 3) {
					
					if (this.modificacion_tratamiento.getText().equalsIgnoreCase("1") || this.modificacion_tratamiento.getText().equalsIgnoreCase("0")) {
						
						resultado = Login_Inicio.dbconn.insertUpdateDelete(
							"UPDATE Tratamientos SET estado = " + this.modificacion_tratamiento.getText() +
							" where nombre = '" + this.tratamiento.getSelectedItem().toString() + "'"
						);
					}
					else {
						throw new Exception("El nuevo valor solo puede ser 'Alta' o 'Baja'");
					}
				}
				
				if (opcion == 4) {
					
					ResultSet resultset = Login_Inicio.dbconn.consulta(
						"SELECT id_especialidad FROM Especialidades" +
						" where id_especialidad = " + this.modificacion_tratamiento.getText() + ";"
					);
					
					int especialidad = 0 ;

					while (resultset.next()) {
						especialidad = resultset.getInt("id_especialidad");
					}
					
					resultado = Login_Inicio.dbconn.insertUpdateDelete(
						"UPDATE Tratamientos SET id_especialidad = '" + especialidad + "'" +
						" where nombre = '" + this.tratamiento.getSelectedItem().toString() + "'"
					);
				}
				
				if (resultado != 0) {
					JOptionPane.showMessageDialog(null, "Tratamiento modificado con éxito.");
				}
				else {
					throw new Exception("Ha ocurrido un error en la modificacion del tratamiento");
				}
			}
			catch (Exception error) {
				
				JOptionPane.showMessageDialog(
					null,
					error.getMessage(),
					"Error en la modificacion del tratamiento",
					JOptionPane.ERROR_MESSAGE,
					null
				);
			}
		});
	}
}
