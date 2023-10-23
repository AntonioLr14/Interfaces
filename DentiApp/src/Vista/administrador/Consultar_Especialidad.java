package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;

public class Consultar_Especialidad extends JPanel {

	protected JComboBox<String> especialidad;
	protected JTextArea consultas_especialidad;
	
	public Consultar_Especialidad() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		
		this.especialidad = new JComboBox<String>();
		this.consultas_especialidad = new JTextArea();
		
		this.especialidad.setBounds(118,55,205,30);
		this.especialidad.setBackground(new Color(255, 255, 255));
		this.consultas_especialidad.setBounds(177, 130, 365, 130);
		
		JLabel etiqueta_especialidad = new JLabel("Especialidad:");
		etiqueta_especialidad.setBounds(118, 40, 94, 13);
		
		JButton boton_consultar = new JButton("Consultar");
		
		boton_consultar.setContentAreaFilled(false);
		boton_consultar.setBounds(441, 55, 160, 30);

		add(this.especialidad);
		add(this.consultas_especialidad);
		add(etiqueta_especialidad);
		add(boton_consultar);
	}
}
