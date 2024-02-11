package Vista.administrador.gestion_de_material;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Vista.Login_Inicio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;

import Controlador.BBDD;
import prueba.Despegable_editable_theme;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Consultar_Pedidos extends JPanel {
	private Despegable_editable_theme proveedor;
	private Despegable_editable_theme fecha;
	private JTable consultas_pedidos;
	private JScrollPane scrollpanel;
	private ResultSet resultset;

	// Constructores
	public Consultar_Pedidos() {

		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);

		JLabel etiqueta_proveedor = new JLabel("Proveedor:");
		etiqueta_proveedor.setBounds(103, 40, 78, 13);

		JLabel etiqueta_fecha = new JLabel("Fecha:");
		etiqueta_fecha.setBounds(411, 40, 47, 13);

		BotonDentista btndntstConsultar = new BotonDentista();

		btndntstConsultar.setText("Consultar");
		btndntstConsultar.setRadius(30);
		btndntstConsultar.setBorder(null);
		btndntstConsultar.setBounds(304, 96, 107, 35);
		add(btndntstConsultar);

		add(etiqueta_proveedor);
		add(etiqueta_fecha);

		this.scrollpanel = new JScrollPane();

		this.scrollpanel.setBounds(64, 141, 600, 152);
		this.scrollpanel.setBorder(new LineBorder(Color.black));
		this.scrollpanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.scrollpanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

		this.consultas_pedidos = new JTable();

		this.consultas_pedidos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		this.scrollpanel.setViewportView(consultas_pedidos);

		add(scrollpanel);

		proveedor = new Despegable_editable_theme(20);
		proveedor.setBounds(103, 55, 205, 30);
		add(proveedor);
		proveedor.addItem("...");
		fecha = new Despegable_editable_theme(20);
		fecha.setBounds(411, 55, 205, 30);
		add(fecha);
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
		btndntstConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (proveedor.getSelectedItem().toString().equals("...")
						|| fecha.getSelectedItem().toString().equals("...")) {
					JOptionPane.showMessageDialog(null, "Rellene todos los campos para crear el pedido");
				} else {
					int id_proveedor = 0;
						try {
							resultset = Login_Inicio.dbconn.consulta("SELECT ID_proveedor from proveedores where Empresa='"
									+ proveedor.getSelectedItem().toString() + "'");
							while (resultset.next()) {
								id_proveedor = resultset.getInt("ID_proveedor");
							}

						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					String consulta = "SELECT * from dentiapp.pedidos WHERE ID_proveedor='"
							+ id_proveedor + "' and fecha_inicio_pedido='"
							+ fecha.getSelectedItem().toString() + "';";
					consultas_pedidos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					try {
						DefaultTableModel modelo_consultas_pedidos = (DefaultTableModel) consultas_pedidos.getModel();

						// Limpiar las filas existentes de la tabla
						for (; modelo_consultas_pedidos.getRowCount() > 0;) {
							modelo_consultas_pedidos.removeRow(0);
						}

						// Llamar a cabeceraTabla para configurar el encabezado de la tabla
						try {
							Login_Inicio.dbconn.cabeceraTabla(consultas_pedidos, consulta);
						} catch (Exception err) {
							// TODO Auto-generated catch block
							err.printStackTrace();
						}

						// Utilizar el método consulta para ejecutar la consulta SQL
						resultset = Login_Inicio.dbconn.consulta(consulta);

						// Procesar el ResultSet y llenar la tabla
						while (resultset.next()) {
							Vector<Object> filas = new Vector<>();
							for (int i = 1; i <= 6; i++) {
								filas.add(resultset.getString(i));
							}
							modelo_consultas_pedidos.addRow(filas);
						}

						// Deshabilitar la edición de celdas
						consultas_pedidos.setDefaultEditor(consultas_pedidos.getColumnClass(0), null);

					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

			}

		});
	}
}
