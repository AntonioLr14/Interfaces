package Vista.administrador.gestion_economica;

import javax.swing.JPanel;
import Vista.Login_Inicio;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import botonDentista.BotonDentista;
import prueba.Despegable_editable_theme;
import java.sql.ResultSet;

public class Crear_Factura extends JPanel {
	
	// Atributos
	protected Despegable_editable_theme<String> dni_nombre_usuario;
	protected Despegable_editable_theme<String> tratamiento;
	protected Despegable_editable_theme<String> tipo_pago;
	protected Despegable_editable_theme<String> numero_meses;

	// Constructores
	public Crear_Factura() {

		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);

		// Creacion de los elementos graficos
		this.dni_nombre_usuario = new Despegable_editable_theme<>(20);
		this.dni_nombre_usuario.setBounds(10, 35, 205, 30);
		
		this.dni_nombre_usuario.addItem("...");

		this.tratamiento = new Despegable_editable_theme<>(20);
		this.tratamiento.setBounds(226, 35, 205, 30);

		this.tratamiento.addItem("...");

		this.tipo_pago = new Despegable_editable_theme<>(20);
		this.tipo_pago.setBounds(442, 35, 205, 30);
		
		this.tipo_pago.addItem("...");
		this.tipo_pago.addItem("Pago unico");
		this.tipo_pago.addItem("Pago fraccionado");

		this.numero_meses = new Despegable_editable_theme<>(20);
		this.numero_meses.setBounds(658, 35, 50, 30);
		
		this.numero_meses.addItem("...");
		
		try {
			
			ResultSet dni_pacientes = Login_Inicio.dbconn.consulta("SELECT DNI from Pacientes");
			ResultSet nombre_tratamientos = Login_Inicio.dbconn.consulta("SELECT nombre from Tratamientos");

			while (dni_pacientes.next()) {
				this.dni_nombre_usuario.addItem(dni_pacientes.getString("DNI"));
			}
			
			while (nombre_tratamientos.next()) {
				this.tratamiento.addItem(nombre_tratamientos.getString("nombre"));
			}
		}
		catch (Exception error) {
			
			JOptionPane.showMessageDialog(
				null,
				error.getMessage(),
				"Error en la creacion de facturas",
				JOptionPane.ERROR_MESSAGE,
				null
			);
		}
		
		BotonDentista boton_aceptar = new BotonDentista();

		boton_aceptar.setBounds(279, 110, 160, 30);
		boton_aceptar.setBorder(null);
		boton_aceptar.setRadius(30);
		boton_aceptar.setText("Aceptar");
		boton_aceptar.setFocusable(false);

		JLabel etiqueta_dni_nombre_usuario = new JLabel("DNI:");
		etiqueta_dni_nombre_usuario.setBounds(10, 20, 165, 13);

		JLabel etiqueta_tratamiento = new JLabel("Tratamiento:");
		etiqueta_tratamiento.setBounds(226, 20, 92, 13);

		JLabel etiqueta_tipo_pago = new JLabel("Tipo de pago:");
		etiqueta_tipo_pago.setBounds(442, 20, 97, 13);

		JLabel etiqueta_numero_meses = new JLabel("M");
		etiqueta_numero_meses.setBounds(671, 20, 12, 13);
		
		add(this.dni_nombre_usuario);
		add(this.tratamiento);
		add(this.tipo_pago);
		add(this.numero_meses);
		add(boton_aceptar);

		add(etiqueta_dni_nombre_usuario);
		add(etiqueta_tratamiento);
		add(etiqueta_tipo_pago);
		add(etiqueta_numero_meses);
		
		// Establecimiento de los eventos
		this.tipo_pago.addActionListener( (event) -> {
			
			if (this.tipo_pago.getSelectedItem().toString().equalsIgnoreCase("Pago fraccionado")) {
								
				for (int i = 2; i <= 24; i += 2) {
					this.numero_meses.addItem(String.valueOf(i));
				}
			}
		});
		
		boton_aceptar.addActionListener( (event) -> {
				
			int id_paciente = 0;
			int resultado = 0;

			try {
				
				ResultSet id_pacientes = Login_Inicio.dbconn.consulta("SELECT ID_paciente from Pacientes" +
					" where DNI = '" + this.dni_nombre_usuario.getSelectedItem().toString() + "';"
				);
				
				ResultSet precio_tratamiento = Login_Inicio.dbconn.consulta(
					"SELECT precio from Tratamientos" +
					" where nombre = '" + this.tratamiento.getSelectedItem().toString() + "';"
				);

				while (id_pacientes.next()) {
					id_paciente = id_pacientes.getInt("ID_paciente");
				}
				
				precio_tratamiento.next();
				
				float precio = precio_tratamiento.getFloat("precio");

				if (this.tipo_pago.getSelectedItem().toString().equalsIgnoreCase("Pago unico")) {
					
					resultado = Login_Inicio.dbconn.insertUpdateDelete(
						"INSERT INTO Pagos (`ID_paciente`, `Tipo`, `Cantidad_abonada`, `Cantidad_total_a_pagar`) VALUES ('" +
						id_paciente + "', '" + 
						"Pago unico', '" +
						precio + "', '" +
						precio + "');"
					);
				}
				
				if (this.tipo_pago.getSelectedItem().toString().equalsIgnoreCase("Pago fraccionado")) {
					
					resultado = Login_Inicio.dbconn.insertUpdateDelete(
						"INSERT INTO Pagos (`ID_paciente`, `Tipo`, `Duracion`, `Cantidad_abonada`, `Cantidad_total_a_pagar`) VALUES ('" +
						id_paciente + "', '" + 
						"Pago Fraccionado', '" +
						this.numero_meses.getSelectedItem().toString() + "', '" +
						precio / Float.parseFloat(this.numero_meses.getSelectedItem().toString()) + "', '" +
						precio + "');"
					);
				}
				
				if (resultado != 0) {
					JOptionPane.showMessageDialog(null, "Factura creada con éxito.");
				}
				else {
					throw new Exception("Ha ocurrido un error en la creacion de la factura");
				}
			}
			catch (Exception error) {
				
				JOptionPane.showMessageDialog(
					null,
					error.getMessage(),
					"Error en la creacion de facturas",
					JOptionPane.ERROR_MESSAGE,
					null
				);
			}
		});
	}
}
