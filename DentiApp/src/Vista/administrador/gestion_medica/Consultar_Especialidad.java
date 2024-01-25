package Vista.administrador.gestion_medica;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import Vista.Login_Inicio;

import javax.swing.JLabel;
import java.awt.Choice;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.sql.SQLException;

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
	private BBDD dbconn;
	protected JScrollPane scrollpanel;
	protected JTable consultas_especialidad;
	
	// Constructores
	public Consultar_Especialidad() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		
		dbconn=new BBDD();
		dbconn.conectar();
		
		JLabel etiqueta_especialidad = new JLabel("Especialidad:");
		etiqueta_especialidad.setBounds(118, 40, 94, 13);
		add(etiqueta_especialidad);
		
		BotonDentista btndntstConsultar = new BotonDentista();
		btndntstConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dbconn.SelectValor(consultas_especialidad, "SELECT * from dentiapp.especialidad where Nombre='"+especialidad.getSelectedItem().toString()+"'");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
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
		
		this.scrollpanel.setBounds(182, 156, 400, 130);
		this.scrollpanel.setBorder(new LineBorder(Color.black));
		this.scrollpanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.scrollpanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		
		this.consultas_especialidad = new JTable();
		
		this.consultas_especialidad.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		this.consultas_especialidad.setTableHeader(null);
		
		this.scrollpanel.setViewportView(consultas_especialidad);
		
		add(scrollpanel);
		DefaultTableModel modelo_consultas_especialidad = (DefaultTableModel) this.consultas_especialidad.getModel();
		consultas_especialidad.setEnabled(false);
	}
	private void mostrarcombo(JComboBox desplegable_tratamiento) {

		desplegable_tratamiento.addItem("...");
		try {
			for(String nombre:dbconn.SelectLista("Nombre", "especialidad")) {
				desplegable_tratamiento.addItem(nombre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}
