package Vista.administrador.gestion_economica;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import botonDentista.BotonDentista;
/*import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;*/
import java.sql.ResultSet;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import Vista.Login_Inicio;
import prueba.Campo_texto_theme;

public class Consultar_Factura extends JPanel {

	// Atributos
	protected Campo_texto_theme dni_nombre_usuario;
	//protected JasperReport reporte;
	protected JScrollPane scrollpanel;
	protected JTable consultar_facturas;

	// Constructores
	public Consultar_Factura() {

		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);

		// Creacion de los elementos graficos
		this.dni_nombre_usuario = new Campo_texto_theme(20);
		this.dni_nombre_usuario.setBounds(118, 25, 205, 30);
				
		this.scrollpanel = new JScrollPane();

		this.scrollpanel.setBounds(67, 58, 600, 130);
		this.scrollpanel.setBorder(new LineBorder(Color.black));
		this.scrollpanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.scrollpanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

		this.consultar_facturas = new JTable();

		this.consultar_facturas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		this.scrollpanel.setViewportView(this.consultar_facturas);
		
		BotonDentista boton_consultar = new BotonDentista();

		boton_consultar.setBounds(441, 25, 160, 30);
		boton_consultar.setBorder(null);
		boton_consultar.setRadius(30);
		boton_consultar.setText("Consultar");
		boton_consultar.setFocusable(false);

		JLabel etiqueta_dni_nombre_usuario = new JLabel("DNI / Nombre completo:");
		etiqueta_dni_nombre_usuario.setBounds(118, 10, 165, 13);

		add(this.dni_nombre_usuario);
		add(this.scrollpanel);
		add(boton_consultar);
		add(etiqueta_dni_nombre_usuario);
		
		// Establecimiento de los eventos
		boton_consultar.addActionListener( (event) -> {

			try {
				
				DefaultTableModel modelo_consultas_facturas = (DefaultTableModel) this.consultar_facturas.getModel();

				for (; modelo_consultas_facturas.getRowCount() > 0;) {
					modelo_consultas_facturas.removeRow(0);
				}

				ResultSet id_pacientes = Login_Inicio.dbconn.consulta(
					"SELECT ID_paciente from Pacientes" +
					" where DNI = '" + this.dni_nombre_usuario.getText() + "';"
				);
				
				int id_paciente = 0;
				
				while (id_pacientes.next()) {
					id_paciente = id_pacientes.getInt("ID_paciente");
				}
				
				String consulta = "SELECT * FROM Pagos where ID_paciente = " + id_paciente + ";";

				Login_Inicio.dbconn.cabeceraTabla(this.consultar_facturas, consulta);

				ResultSet resultset = Login_Inicio.dbconn.consulta(consulta);

				while (resultset.next()) {
					
					int id_pago = resultset.getInt("ID_pago");
					int id_p = resultset.getInt("ID_paciente");
					String tipo = resultset.getString("Tipo");
					int duracion = resultset.getInt("Duracion");
					float cantidad_abonada = resultset.getFloat("Cantidad_abonada");
					float cantidad_total_a_pagar = resultset.getFloat("Cantidad_total_a_pagar");
					
					String[] fila = {
						String.valueOf(id_pago),
						String.valueOf(id_p),
						tipo,
						String.valueOf(duracion),
						String.valueOf(cantidad_abonada),
						String.valueOf(cantidad_total_a_pagar)
					};
					
					modelo_consultas_facturas.addRow(fila);
				}

				this.consultar_facturas.setDefaultEditor(this.consultar_facturas.getColumnClass(0), null);

				/*Map parametros = new HashMap();
				parametros.put("id_paciente", id_paciente);
				reporte = JasperCompileManager.compileReport("src/Informes/Informe_Facturas.jrxml");
				JasperPrint jp = JasperFillManager.fillReport(reporte, parametros, conexion);
				JasperViewer.viewReport(jp, false);*/
				
			}
			catch (Exception error) {
				
				JOptionPane.showMessageDialog(
					null,
					error.getMessage(),
					"Error en la consulta de facturas",
					JOptionPane.ERROR_MESSAGE,
					null
				);
			}
		});
	}
}
