package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;

import Controlador.BBDD;
import prueba.Campo_texto_theme;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Consultar_Historial_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private Campo_texto_theme tfDNI_NombreCompleto;
	private JTable consultar_historial;
	private JScrollPane scrollpanel;
	private ResultSet resultset;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public Consultar_Historial_M() throws Exception {
		setOpaque(false);
		
		setBounds(100, 100, 720, 500);
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		
	    tfDNI_NombreCompleto = new Campo_texto_theme(20);
		tfDNI_NombreCompleto.setBounds(153, 84, 130, 30);
		add(tfDNI_NombreCompleto);
		
		JLabel lblDNI_NombreCompleto = new JLabel("DNI / Nombre completo");
		lblDNI_NombreCompleto.setBounds(153, 61, 130, 13);
		add(lblDNI_NombreCompleto);
		
		this.scrollpanel = new JScrollPane();
		
		this.scrollpanel.setBounds(64,141,600,152);
		this.scrollpanel.setBorder(new LineBorder(Color.black));
		this.scrollpanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.scrollpanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		
		this.consultar_historial = new JTable();
		
		this.consultar_historial.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		this.scrollpanel.setViewportView(consultar_historial);
		
		add(scrollpanel);
		
		
		
		BotonDentista btndntstConsultar = new BotonDentista();
		 btndntstConsultar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
		            String consulta = "SELECT * FROM dentiapp.citas where ID_Paciente=(select ID_paciente from dentiapp.pacientes where dni='" + tfDNI_NombreCompleto.getText() + "')"
		            		+ " or ID_paciente=(SELECT ID_paciente from dentiapp.pacientes where DNI=(SELECT DNI from dentiapp.personas where concat(Nombre,' ',Apellidos)='" + tfDNI_NombreCompleto.getText() + "'));";

		            try {
		                DefaultTableModel modelo_consultas_historial = (DefaultTableModel) consultar_historial.getModel();

		                // Limpiar las filas existentes de la tabla
		                for (; modelo_consultas_historial.getRowCount() > 0;) {
		                    modelo_consultas_historial.removeRow(0);
		                }

		                // Llamar a cabeceraTabla para configurar el encabezado de la tabla
		                Login_Inicio.dbconn.cabeceraTabla(consultar_historial, consulta);

		                // Utilizar el método consulta para ejecutar la consulta SQL
		                resultset = Login_Inicio.dbconn.consulta(consulta);

		                // Procesar el ResultSet y llenar la tabla
		                while (resultset.next()) {
		                    Vector<Object> filas = new Vector<>();
		                    for (int i = 1; i <= 6; i++) {
		                        filas.add(resultset.getString(i));
		                    }
		                    modelo_consultas_historial.addRow(filas);
		                }

		                // Deshabilitar la edición de celdas
		                consultar_historial.setDefaultEditor(consultar_historial.getColumnClass(0), null);

		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            } catch (Exception e1) {
		                e1.printStackTrace();
		            }
		        }
		    });
		tfDNI_NombreCompleto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyCode() == KeyEvent.VK_ENTER) {
					btndntstConsultar.doClick();
			}
		}
		});
		btndntstConsultar.setText("Consultar");
		btndntstConsultar.setRadius(30);
		btndntstConsultar.setBorder(null);
		btndntstConsultar.setBounds(394, 84, 160, 30);
		add(btndntstConsultar);
		

	}
}
