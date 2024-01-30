package Vista.administrador.gestion_medica;

import javax.swing.JPanel;

import Controlador.BBDD;
import Vista.Login_Inicio;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.sql.SQLException;

import botonDentista.BotonDentista;
import prueba.Despegable_editable_theme;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Eliminar_Especialidad extends JPanel {
	private Despegable_editable_theme especialidad;
	private BBDD dbconn;

	// Constructores
	public Eliminar_Especialidad() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		dbconn=new BBDD();
		dbconn.conectar();

		JLabel etiqueta_especialidad = new JLabel("Especialidad:");
		etiqueta_especialidad.setBounds(120, 75, 94, 13);
		add(etiqueta_especialidad);
		
		BotonDentista btndntstEliminar = new BotonDentista();
		btndntstEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconn.borrar("especialidad", "nombre", especialidad.getSelectedItem().toString());
			}
		});
		btndntstEliminar.setBorder(null);
		btndntstEliminar.setRadius(30);
		btndntstEliminar.setText("Eliminar");
		btndntstEliminar.setBounds(443, 90, 160, 30);
		add(btndntstEliminar);
		
		especialidad = new Despegable_editable_theme(20);
		especialidad.setBounds(120, 90, 205, 30);
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
