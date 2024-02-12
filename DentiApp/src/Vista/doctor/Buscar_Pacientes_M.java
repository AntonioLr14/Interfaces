package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Vista.Login_Inicio;

import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;

import Controlador.BBDD;
import prueba.Campo_texto_theme;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Buscar_Pacientes_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private Campo_texto_theme tfDNI_NombreCompleto;
	private JTable consultas_pacientes;
	private JScrollPane scrollpanel;
	private ResultSet resultset;

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public Buscar_Pacientes_M() throws Exception {
		setOpaque(false);
		// Creamos panel principal
		setLayout(null);
		setBounds(100, 100, 720, 500);
		setBackground(new Color(255, 255, 255));

		// Creamos los componentes del panel
		this.scrollpanel = new JScrollPane();

		this.scrollpanel.setBounds(62, 118, 600, 152);
		this.scrollpanel.setBorder(new LineBorder(Color.black));
		this.scrollpanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.scrollpanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

		this.consultas_pacientes = new JTable();

		this.consultas_pacientes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		this.scrollpanel.setViewportView(consultas_pacientes);

		add(scrollpanel);

		tfDNI_NombreCompleto = new Campo_texto_theme(20);
		tfDNI_NombreCompleto.setBounds(145, 77, 134, 28);

		JLabel lblDNI_NombreCompleto = new JLabel("DNI / Nombre completo");
		lblDNI_NombreCompleto.setBounds(145, 54, 135, 13);

		BotonDentista btndntstConsultar = new BotonDentista();

		btndntstConsultar.setText("Consultar");
		btndntstConsultar.setRadius(30);
		btndntstConsultar.setBorder(null);
		btndntstConsultar.setFocusable(false);
		btndntstConsultar.setBounds(351, 77, 160, 30);

		// Añadimos componentes al panel
		add(tfDNI_NombreCompleto);
		add(lblDNI_NombreCompleto);
		add(btndntstConsultar);
		
		BotonDentista btnOdontograma = new BotonDentista();
		btnOdontograma.setBorder(null);
		btnOdontograma.setFocusTraversalKeysEnabled(false);
		btnOdontograma.setFocusPainted(false);
		btnOdontograma.setFocusable(false);
		btnOdontograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String DNI = "";
				int filaSeleccionada = 0;
				int columnaSeleccionada = 1;

				if (filaSeleccionada != -1 && columnaSeleccionada != -1) {
					Object valorCelda = consultas_pacientes.getValueAt(filaSeleccionada, columnaSeleccionada);

					// Guardar el valor de la celda en un String
					DNI = valorCelda.toString();

					try {
						/*Modificar_Odontograma_M odon = new Modificar_Odontograma_M();

		                // Get the top-level container (presumably a JFrame)
		                Container topLevelContainer = SwingUtilities.getWindowAncestor(Buscar_Pacientes_M.this);

		                // Replace the content of the top-level container with the Modificar_Odontograma_M panel
		                ((JFrame) topLevelContainer).setContentPane(odon);

		                // Revalidate and repaint to update the UI
		                topLevelContainer.revalidate();
		                topLevelContainer.repaint();*/
						
						
						Medico medico=new Medico(Medico.id);
						medico.setVisible(true);
						setVisible(false);
						if (medico.panelprueba.isShowing()) {
							medico.panel.remove(medico.panelprueba);
						}
						
						try {
							medico.panelprueba = new Modificar_Odontograma_M(DNI);
						}
						catch (Exception error) {
							error.printStackTrace();
						}
						
						medico.panelprueba.setLocation(0,100);
						
						medico.panel.add(medico.panelprueba);
						medico.panel.add(medico.etiqueta_fondo);
						medico.panel.updateUI();
						

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});
		btnOdontograma.setRadius(30);
		btnOdontograma.setText("<html><p align='center'>Mostrar<br>Odontograma</html>");
		btnOdontograma.setBounds(280, 281, 146, 37);
		add(btnOdontograma);

		// Metodos de la clase
		btndntstConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultar();

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

	}

	public void consultar() {
		String consulta = "SELECT pacientes.Id_paciente as ID,pacientes.DNI as DNI,personas.correo, concat(personas.nombre,' ',personas.Apellidos) as 'Nombre Completo',personas.Telefono FROM"
				+ " dentiapp.personas inner join dentiapp.pacientes on personas.DNI = pacientes.DNI where concat(personas.nombre,' ',personas.Apellidos)='"
				+ tfDNI_NombreCompleto.getText() + "' or personas.DNI='" + tfDNI_NombreCompleto.getText() + "';";
		try {
			DefaultTableModel modelo_consultas_paciente = (DefaultTableModel) consultas_pacientes.getModel();

			// Limpiar las filas existentes de la tabla
			for (; modelo_consultas_paciente.getRowCount() > 0;) {
				modelo_consultas_paciente.removeRow(0);
			}

			// Llamar a cabeceraTabla para configurar el encabezado de la tabla
			Login_Inicio.dbconn.cabeceraTabla(consultas_pacientes, consulta);

			// Utilizar el método consulta para ejecutar la consulta SQL
			resultset = Login_Inicio.dbconn.consulta(consulta);

			// Procesar el ResultSet y llenar la tabla
			while (resultset.next()) {
				Vector<Object> filas = new Vector<>();
				for (int i = 1; i <= 5; i++) {
					filas.add(resultset.getString(i));
				}
				modelo_consultas_paciente.addRow(filas);
			}

			// Deshabilitar la edición de celdas
			consultas_pacientes.setDefaultEditor(consultas_pacientes.getColumnClass(0), null);

		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
