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

import Controlador.BBDD;
import prueba.Despegable_editable_theme;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Consultar_Especialidad extends JPanel {
	protected JTextArea consultas_especialidad;
	private Despegable_editable_theme especialidad;
	private BBDD dbconn;
	
	// Constructores
	public Consultar_Especialidad() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		
		dbconn=new BBDD();
		dbconn.conectar();
		
		this.consultas_especialidad = new JTextArea();
		consultas_especialidad.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.consultas_especialidad.setBounds(177, 130, 365, 130);
		
		JLabel etiqueta_especialidad = new JLabel("Especialidad:");
		etiqueta_especialidad.setBounds(118, 40, 94, 13);
		add(this.consultas_especialidad);
		add(etiqueta_especialidad);
		
		BotonDentista btndntstConsultar = new BotonDentista();
		btndntstConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
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
