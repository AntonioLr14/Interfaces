package Vista.administrador.gestion_economica;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.JTextArea;
import botonDentista.BotonDentista;
/*import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;*/

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;



import Controlador.BBDD;
import Vista.administrador.Administrador;
import Vista.doctor.Medico;
import prueba.Campo_texto_theme;

public class Consultar_Factura extends JPanel {

	protected JTextArea consultas_facturas;
	private Campo_texto_theme dni_nombre_usuario;
	private JasperReport reporte;
	private Connection conexion;
	private ResultSet resultset;
	private JTable consultar_facturas;
	private JScrollPane scrollpanel;

	// Constructores
	public Consultar_Factura() throws Exception {

		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		//conexion = Administrador.getDbconn().conectar();


		JLabel etiqueta_dni_nombre_usuario = new JLabel("DNI / Nombre completo:");
		etiqueta_dni_nombre_usuario.setBounds(118, 10, 165, 13);

		dni_nombre_usuario = new Campo_texto_theme(20);
		dni_nombre_usuario.setBounds(118, 25, 205, 30);
		add(etiqueta_dni_nombre_usuario);
		add(dni_nombre_usuario);
		this.scrollpanel = new JScrollPane();

		this.scrollpanel.setBounds(67, 58, 600, 130);
		this.scrollpanel.setBorder(new LineBorder(Color.black));
		this.scrollpanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.scrollpanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

		this.consultar_facturas = new JTable();

		this.consultar_facturas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		this.scrollpanel.setViewportView(consultar_facturas);

		add(scrollpanel);

		BotonDentista btndntstConsultar = new BotonDentista();
		btndntstConsultar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					resultset = Administrador.getDbconn().consulta(
							"SELECT id_paciente from pacientes where dni='" + dni_nombre_usuario.getText() + "'");
					int id_paciente = 0;
					while (resultset.next()) {
						id_paciente = resultset.getInt("id_paciente");
					}
					String consulta = "SELECT * FROM dentiapp.pagos where id_paciente='" + id_paciente + "'";

					DefaultTableModel modelo_consultas_facturas = (DefaultTableModel) consultar_facturas.getModel();

					// Limpiar las filas existentes de la tabla
					for (; modelo_consultas_facturas.getRowCount() > 0;) {
						modelo_consultas_facturas.removeRow(0);
					}

					// Llamar a cabeceraTabla para configurar el encabezado de la tabla
					Administrador.getDbconn().cabeceraTabla(consultar_facturas, consulta);

					// Utilizar el método consulta para ejecutar la consulta SQL
					resultset = Administrador.getDbconn().consulta(consulta);

					// Procesar el ResultSet y llenar la tabla
					while (resultset.next()) {
						Vector<Object> filas = new Vector<>();
						for (int i = 1; i <= 6; i++) {
							filas.add(resultset.getString(i));
						}
						modelo_consultas_facturas.addRow(filas);
					}

					// Deshabilitar la edición de celdas
					consultar_facturas.setDefaultEditor(consultar_facturas.getColumnClass(0), null);

					/*Map parametros = new HashMap();
					parametros.put("id_paciente", id_paciente);
					reporte = JasperCompileManager.compileReport("src/Informes/Informe_Facturas.jrxml");
					JasperPrint jp = JasperFillManager.fillReport(reporte, parametros, conexion);
					JasperViewer.viewReport(jp, false);*/
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btndntstConsultar.setText("Consultar");
		btndntstConsultar.setRadius(30);
		btndntstConsultar.setBorder(null);
		btndntstConsultar.setBounds(441, 25, 160, 30);
		add(btndntstConsultar);
	}
}
