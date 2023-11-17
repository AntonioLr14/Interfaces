package Vista.administrador.gestion_medica;

import javax.swing.JPanel;

import Vista.Login_Inicio;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;
import prueba.Despegable_editable_theme;

public class Eliminar_Especialidad extends JPanel {
	private Despegable_editable_theme especialidad;

	// Constructores
	public Eliminar_Especialidad() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);

		JLabel etiqueta_especialidad = new JLabel("Especialidad:");
		etiqueta_especialidad.setBounds(120, 75, 94, 13);
		add(etiqueta_especialidad);
		
		BotonDentista btndntstEliminar = new BotonDentista();
		btndntstEliminar.setBorder(null);
		btndntstEliminar.setRadius(30);
		btndntstEliminar.setText("Eliminar");
		btndntstEliminar.setBounds(443, 90, 160, 30);
		add(btndntstEliminar);
		
		especialidad = new Despegable_editable_theme(20);
		especialidad.setBounds(120, 90, 205, 30);
		add(especialidad);
	}
}
