package Vista.administrador.gestion_medica;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import Vista.Login_Inicio;
import Vista.administrador.Administrador;
import Vista.doctor.Medico;

import javax.swing.JLabel;
import java.awt.Choice;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.BBDD;
import prueba.Despegable_editable_theme;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Consultar_Especialidad extends JPanel {
	private Despegable_editable_theme especialidad;
	protected JScrollPane scrollpanel;
	protected JTable consultas_especialidad;
	private ResultSet resultset;
	
	// Constructores
	public Consultar_Especialidad() throws Exception {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		
		JLabel etiqueta_especialidad = new JLabel("Especialidad:");
		etiqueta_especialidad.setBounds(118, 40, 94, 13);
		add(etiqueta_especialidad);
		
		BotonDentista btndntstConsultar = new BotonDentista();
	
		
		btndntstConsultar.setBorder(null);
		btndntstConsultar.setRadius(30);
		btndntstConsultar.setText("Consultar");
		btndntstConsultar.setBounds(441, 55, 160, 30);
		add(btndntstConsultar);
		
		especialidad = new Despegable_editable_theme(20);
		especialidad.setBounds(118, 55, 205, 30);
		add(especialidad);
		mostrarcombo(especialidad);
		
		this.scrollpanel = new JScrollPane();
		
		this.scrollpanel.setBounds(112, 156, 500, 130);
		this.scrollpanel.setBorder(new LineBorder(Color.black));
		this.scrollpanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.scrollpanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		
		this.consultas_especialidad = new JTable();
		
		this.consultas_especialidad.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		this.scrollpanel.setViewportView(consultas_especialidad);
		
		add(scrollpanel);
		DefaultTableModel modelo_consultas_especialidad = (DefaultTableModel) this.consultas_especialidad.getModel();
		consultas_especialidad.setCellEditor(null);
		
		btndntstConsultar.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				String consulta = "SELECT * from dentiapp.especialidades where nombre='"+especialidad.getSelectedItem().toString()+"';";
				 try {
		             DefaultTableModel modelo_consultas_especialidad = (DefaultTableModel) consultas_especialidad.getModel();

		             // Limpiar las filas existentes de la tabla
		             for (; modelo_consultas_especialidad.getRowCount() > 0;) {
		                 modelo_consultas_especialidad.removeRow(0);
		             }

		             // Llamar a cabeceraTabla para configurar el encabezado de la tabla
		             Administrador.getDbconn().cabeceraTabla(consultas_especialidad, consulta);

		             // Utilizar el método consulta para ejecutar la consulta SQL
		             resultset = Administrador.getDbconn().consulta(consulta);

		             // Procesar el ResultSet y llenar la tabla
		             while (resultset.next()) {
		                 Vector<Object> filas = new Vector<>();
		                 for (int i = 1; i <= 3; i++) {
		                     filas.add(resultset.getString(i));
		                 }
		                 modelo_consultas_especialidad.addRow(filas);
		             }

		             // Deshabilitar la edición de celdas
		             consultas_especialidad.setDefaultEditor(consultas_especialidad.getColumnClass(0), null);

		         } catch (SQLException e1) {
		             e1.printStackTrace();
		         } catch (Exception e1) {
		             e1.printStackTrace();
		         }
			}
		});
	}
	private void mostrarcombo(JComboBox desplegable_tratamiento) {

		desplegable_tratamiento.addItem("...");
		try {
			resultset = Administrador.getDbconn().consulta("SELECT nombre FROM especialidades;");
			while (resultset.next()) {
				desplegable_tratamiento.addItem(resultset.getString("nombre"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}
