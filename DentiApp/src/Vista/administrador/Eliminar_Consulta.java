package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;

public class Eliminar_Consulta extends JPanel {

	protected JTextField dni_nombre_usuario;
	protected JComboBox<String> fecha;
	protected JTextArea eliminar_citas;
	
	public Eliminar_Consulta() {
		
		setLayout(null);
		setBounds(0, 0, 612, 325);
		
		this.dni_nombre_usuario = new JTextField();
		this.fecha = new JComboBox<String>();
		this.eliminar_citas = new JTextArea();

		this.dni_nombre_usuario.setBounds(67, 15, 205, 30);
		this.fecha.setBounds(339, 15, 205, 30);
		this.fecha.setBackground(new Color(255, 255, 255));
		this.eliminar_citas.setBounds(123, 90, 365, 130);

		JLabel etiqueta_dni_nombre_usuario = new JLabel("DNI / Nombre completo:");
		etiqueta_dni_nombre_usuario.setBounds(67, 0, 165, 13);
		
		JLabel etiqueta_fecha = new JLabel("Fecha:");
		etiqueta_fecha.setBounds(339, 0, 47, 13);
						
		JButton boton_eliminar = new JButton("Eliminar");
		
		boton_eliminar.setBounds(500, 185, 100, 35);
		boton_eliminar.setContentAreaFilled(false);

		add(this.dni_nombre_usuario);
		add(this.fecha);
		add(this.eliminar_citas);
		add(etiqueta_dni_nombre_usuario);
		add(etiqueta_fecha);
		add(boton_eliminar);
	}
}
