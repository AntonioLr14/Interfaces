package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.SwingConstants;

import Vista.Login_Inicio;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.BBDD;

import javax.swing.JTable;

public class Visualizar_Agenda_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable agenda;
	private JScrollPane scrollpanel;
	private ResultSet resultset;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public Visualizar_Agenda_M(String id) throws Exception {
		setOpaque(false);
		setLayout(null);
		setBounds(100, 100, 720, 500);
		setBackground(new Color(255, 255, 255));
		JLabel lblAgenda = new JLabel("Agenda");
		lblAgenda.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgenda.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAgenda.setBounds(318, 27, 89, 28);
		add(lblAgenda);
		
		
		
	this.scrollpanel = new JScrollPane();
		
		this.scrollpanel.setBounds(63, 66, 600, 207);
		this.scrollpanel.setBorder(new LineBorder(Color.black));
		this.scrollpanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.scrollpanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		
		this.agenda = new JTable();
		
		this.scrollpanel.setViewportView(agenda);
		
		add(scrollpanel);
		
		JTextArea taAgenda = new JTextArea();
		taAgenda.setBorder(new LineBorder(new Color(0, 0, 0)));
		taAgenda.setBounds(113, 66, 511, 207);
		add(taAgenda);
		
		
		String consulta="SELECT * FROM dentiapp.citas where ID_doctor='2';";
		  agenda.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		  try {
	             DefaultTableModel modelo_consultas_agenda = (DefaultTableModel) agenda.getModel();

	             // Limpiar las filas existentes de la tabla
	             for (; modelo_consultas_agenda.getRowCount() > 0;) {
	                 modelo_consultas_agenda.removeRow(0);
	             }

	             // Llamar a cabeceraTabla para configurar el encabezado de la tabla
	             try {
					Medico.dbconn.cabeceraTabla(agenda, consulta);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	             
	             // Utilizar el método consulta para ejecutar la consulta SQL
	             resultset = Medico.dbconn.consulta(consulta);

	             // Procesar el ResultSet y llenar la tabla
	             while (resultset.next()) {
	                 Vector<Object> filas = new Vector<>();
	                 for (int i = 1; i <= 6; i++) {
	                     filas.add(resultset.getString(i));
	                 }
	                 modelo_consultas_agenda.addRow(filas);
	             }

	             // Deshabilitar la edición de celdas
	             agenda.setDefaultEditor(agenda.getColumnClass(0), null);

	         } catch (SQLException e1) {
	             e1.printStackTrace();
	         } catch (Exception e1) {
	             e1.printStackTrace();
	         }

	}
}
