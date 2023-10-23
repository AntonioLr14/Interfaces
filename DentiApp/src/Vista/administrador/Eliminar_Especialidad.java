package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;

public class Eliminar_Especialidad extends JPanel {

	protected JComboBox<String> especialidad;

	public Eliminar_Especialidad() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		
		this.especialidad = new JComboBox<String>();
		
		this.especialidad.setBounds(118,235,205,30);
		this.especialidad.setBackground(new Color(255, 255, 255));

		JLabel etiqueta_especialidad = new JLabel("Especialidad:");
		etiqueta_especialidad.setBounds(118, 220, 94, 13);
		
		JButton boton_eliminar = new JButton("Eliminar");
		
		boton_eliminar.setBounds(441, 235, 160, 30);
		boton_eliminar.setContentAreaFilled(false);
		
		add(this.especialidad);
		add(etiqueta_especialidad);
		add(boton_eliminar);
	}
}
