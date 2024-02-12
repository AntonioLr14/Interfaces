package Vista.administrador.gestion_de_material;

import javax.swing.JPanel;

import Controlador.BBDD;
import Vista.Login_Inicio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import prueba.Despegable_editable_theme;

public class Modificar_Pedido extends JPanel {
	private Despegable_editable_theme proveedor;
	private Despegable_editable_theme fecha;
	private ResultSet resultset;

	// Constructores
	public Modificar_Pedido() {

		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);

		JLabel etiqueta_proveedor = new JLabel("Proveedor:");
		etiqueta_proveedor.setBounds(103, 40, 78, 13);

		JLabel etiqueta_fecha = new JLabel("Fecha:");
		etiqueta_fecha.setBounds(411, 40, 47, 13);
		add(etiqueta_proveedor);
		add(etiqueta_fecha);

		proveedor = new Despegable_editable_theme(20);
		proveedor.setBounds(103, 55, 205, 30);
		add(proveedor);
		proveedor.addItem("...");

		fecha = new Despegable_editable_theme(20);
		fecha.setBounds(411, 55, 205, 30);
		add(fecha);
		

		BotonDentista btndntstEliminar = new BotonDentista();
		btndntstEliminar.setText("Eliminar");
		btndntstEliminar.setRadius(30);
		btndntstEliminar.setBorder(null);
		btndntstEliminar.setBounds(280, 135, 160, 30);
		add(btndntstEliminar);

		btndntstEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (proveedor.getSelectedItem().toString().equals("...")
						|| fecha.getSelectedItem().toString().equals("...")) {
					JOptionPane.showMessageDialog(null, "Rellene todos los campos");
				} else {
					try {
						int id_proveedor = 0;
						resultset = Login_Inicio.dbconn.consulta("SELECT ID_proveedor from proveedores where Empresa='"
								+ proveedor.getSelectedItem().toString() + "'");
						while (resultset.next()) {
							id_proveedor = resultset.getInt("ID_proveedor");
						}
						Login_Inicio.dbconn
								.insertUpdateDelete("Delete from pedidos where ID_proveedor ='" + id_proveedor
										+ "' and fecha_inicio_pedido = '" + fecha.getSelectedItem().toString() + "'");
						JOptionPane.showMessageDialog(null, "Pedido eliminaado con éxito");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});

		try {
			resultset = Login_Inicio.dbconn.consulta("SELECT EMPRESA from proveedores");

			while (resultset.next()) {
				proveedor.addItem(resultset.getString("Empresa"));
			}
			proveedor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int id_proveedor = 0;
					try {
						resultset = Login_Inicio.dbconn.consulta("SELECT ID_proveedor from proveedores where Empresa='"
								+ proveedor.getSelectedItem().toString() + "'");
						while (resultset.next()) {
							id_proveedor = resultset.getInt("ID_proveedor");
						}

						resultset = Login_Inicio.dbconn.consulta(
								"SELECT fecha_inicio_pedido from pedidos where id_proveedor = '" + id_proveedor + "'");
						fecha.addItem("...");
						while (resultset.next()) {
							fecha.addItem(resultset.getString("fecha_inicio_pedido"));
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
