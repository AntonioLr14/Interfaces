package Vista.administrador.gestion_economica;

import javax.swing.JPanel;

import Vista.Login_Inicio;
import Vista.administrador.Administrador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;
import prueba.Despegable_editable_theme;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Crear_Factura extends JPanel {
	private Despegable_editable_theme dni_nombre_usuario;
	private Despegable_editable_theme tratamiento;
	private Despegable_editable_theme tipo_pago;
	private Despegable_editable_theme numero_meses;
	private ResultSet resultset;

	// Constructores
	public Crear_Factura() {

		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);

		JLabel etiqueta_dni_nombre_usuario = new JLabel("DNI:");
		etiqueta_dni_nombre_usuario.setBounds(10, 20, 165, 13);

		JLabel etiqueta_tratamiento = new JLabel("Tratamiento:");
		etiqueta_tratamiento.setBounds(226, 20, 92, 13);

		JLabel etiqueta_tipo_pago = new JLabel("Tipo de pago:");
		etiqueta_tipo_pago.setBounds(442, 20, 97, 13);

		JLabel etiqueta_numero_meses = new JLabel("M");
		etiqueta_numero_meses.setBounds(671, 20, 12, 13);
		add(etiqueta_dni_nombre_usuario);
		add(etiqueta_tratamiento);
		add(etiqueta_tipo_pago);
		add(etiqueta_numero_meses);

		BotonDentista btndntstAceptar = new BotonDentista();
		btndntstAceptar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int id_paciente = 0;
				try {
					resultset = Administrador.getDbconn().consulta("SELECT id_paciente from pacientes where DNI='"
							+ dni_nombre_usuario.getSelectedItem().toString() + "'");
					while (resultset.next()) {
						id_paciente = resultset.getInt("id_paciente");
					}
					resultset = Administrador.getDbconn().consulta("SELECT precio from Tratamientos where nombre='"
							+ tratamiento.getSelectedItem().toString() + "'");
					float precio = 0;
					while (resultset.next()) {
						precio = resultset.getFloat("precio");
					}
					if (tipo_pago.getSelectedItem().toString().equalsIgnoreCase("Pago unico")) {
						Administrador.getDbconn().insertUpdateDelete(
								"INSERT INTO `dentiapp`.`pagos` (`ID_paciente`, `Tipo`, "
										+ "`Cantidad_abonada`, `Cantidad_total_a_pagar`) VALUES ('" + id_paciente
										+ "', 'Pago unico', '" + precio + "', '" + precio + "');");
						JOptionPane.showMessageDialog(null, "Factura creada con éxito.");
					} else if (tipo_pago.getSelectedItem().toString().equalsIgnoreCase("Pago fraccionado")) {
						Administrador.getDbconn().insertUpdateDelete(
								"INSERT INTO `dentiapp`.`pagos` (`ID_paciente`, `Tipo`, `Duracion`, "
										+ "`Cantidad_abonada`, `Cantidad_total_a_pagar`) VALUES ('" + id_paciente
										+ "', 'Pago Fraccionado', '" + numero_meses.getSelectedItem().toString()
										+ "', '" + precio / Float.parseFloat(numero_meses.getSelectedItem().toString())
										+ "', '" + precio + "');");
						JOptionPane.showMessageDialog(null, "Factura creada con éxito.");
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btndntstAceptar.setBorder(null);
		btndntstAceptar.setRadius(30);
		btndntstAceptar.setText("Aceptar");
		btndntstAceptar.setBounds(279, 110, 160, 30);
		add(btndntstAceptar);

		dni_nombre_usuario = new Despegable_editable_theme(20);
		dni_nombre_usuario.setBounds(10, 35, 205, 30);
		add(dni_nombre_usuario);

		tratamiento = new Despegable_editable_theme(20);
		tratamiento.setBounds(226, 35, 205, 30);
		add(tratamiento);

		tipo_pago = new Despegable_editable_theme(20);
		tipo_pago.setBounds(442, 35, 205, 30);
		add(tipo_pago);

		numero_meses = new Despegable_editable_theme(20);
		numero_meses.setBounds(658, 35, 50, 30);
		add(numero_meses);

		dni_nombre_usuario.addItem("...");
		try {
			resultset = Administrador.getDbconn().consulta("SELECT DNI from pacientes");
			while (resultset.next()) {
				dni_nombre_usuario.addItem(resultset.getString("DNI"));
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tratamiento.addItem("...");
		try {
			resultset = Administrador.getDbconn().consulta("SELECT nombre from tratamientos");
			while (resultset.next()) {
				tratamiento.addItem(resultset.getString("nombre"));
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tipo_pago.addItem("...");
		tipo_pago.addItem("Pago unico");
		tipo_pago.addItem("Pago fraccionado");
		tipo_pago.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tipo_pago.getSelectedItem().toString().equalsIgnoreCase("Pago fraccionado")) {
					numero_meses.addItem("...");
					for (int i = 2; i <= 24; i = i + 2) {
						numero_meses.addItem(i);

					}
				}
			}
		});

	}
}
