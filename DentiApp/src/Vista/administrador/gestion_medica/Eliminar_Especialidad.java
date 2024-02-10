package Vista.administrador.gestion_medica;

import javax.swing.JPanel;

import Controlador.BBDD;
import Vista.Login_Inicio;
import Vista.administrador.Administrador;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

import botonDentista.BotonDentista;
import prueba.Despegable_editable_theme;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Eliminar_Especialidad extends JPanel {
	private Despegable_editable_theme especialidad;
	private ResultSet resultset;

	// Constructores
	public Eliminar_Especialidad() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);

		JLabel etiqueta_especialidad = new JLabel("Especialidad:");
		etiqueta_especialidad.setBounds(120, 75, 94, 13);
		add(etiqueta_especialidad);
		
		BotonDentista btndntstEliminar = new BotonDentista();
		btndntstEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Administrador.getDbconn().insertUpdateDelete("DELETE from especialidades where nombre='"+especialidad.getSelectedItem().toString()+"'");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
