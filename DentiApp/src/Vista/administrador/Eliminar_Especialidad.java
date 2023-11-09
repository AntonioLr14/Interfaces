package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;

public class Eliminar_Especialidad extends JPanel {

	// Atributos
	protected JComboBox<String> especialidad;

	// Constructores
	public Eliminar_Especialidad() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(230, 247, 255));
		setLayout(null);
		
		// Creacion de los elementos graficos
		this.especialidad = new JComboBox<String>();
		
		this.especialidad.setBounds(118,235,205,30);
		this.especialidad.setBackground(new Color(255, 255, 255));

		JLabel etiqueta_especialidad = new JLabel("Especialidad:");
		etiqueta_especialidad.setBounds(118, 220, 94, 13);
		
		add(this.especialidad);
		add(etiqueta_especialidad);
		
		BotonDentista btndntstEliminar = new BotonDentista();
		btndntstEliminar.setBorder(null);
		btndntstEliminar.setRadius(30);
		btndntstEliminar.setText("Eliminar");
		btndntstEliminar.setBounds(441, 235, 160, 30);
		add(btndntstEliminar);
	}
}
