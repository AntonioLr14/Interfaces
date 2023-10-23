package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;

public class Crear_Factura extends JPanel {

	protected JComboBox<String> dni_nombre_usuario;
	protected JComboBox<String> tratamiento;
	protected JComboBox<String> tipo_pago;
	protected JComboBox<String> numero_meses;
	
	public Crear_Factura() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		
		this.dni_nombre_usuario = new JComboBox<String>();
		this.tratamiento = new JComboBox<String>();
		this.tipo_pago = new JComboBox<String>();
		this.numero_meses = new JComboBox<String>();
		
		this.dni_nombre_usuario.setBounds(11,15,205,30);
		this.dni_nombre_usuario.setBackground(new Color(255, 255, 255));
		this.tratamiento.setBounds(227,15,205,30);
		this.tratamiento.setBackground(new Color(255, 255, 255));
		this.tipo_pago.setBounds(443,15,205,30);
		this.tipo_pago.setBackground(new Color(255, 255, 255));
		this.numero_meses.setBounds(659,15,50,30);
		this.numero_meses.setBackground(new Color(255, 255, 255));

		JLabel etiqueta_dni_nombre_usuario = new JLabel("DNI / Nombre completo:");
		etiqueta_dni_nombre_usuario.setBounds(11, 0, 165, 13);
		
		JLabel etiqueta_tratamiento = new JLabel("Tratamiento:");
		etiqueta_tratamiento.setBounds(227, 0, 92, 13);

		JLabel etiqueta_tipo_pago = new JLabel("Tipo de pago:");
		etiqueta_tipo_pago.setBounds(443, 0, 97, 13);
		
		JLabel etiqueta_numero_meses = new JLabel("M");
		etiqueta_numero_meses.setBounds(672, 0, 12, 13);
		
		JButton boton_aceptar = new JButton("Aceptar");
		
		boton_aceptar.setBounds(280, 90, 160, 30);
		boton_aceptar.setContentAreaFilled(false);

		add(this.dni_nombre_usuario);
		add(this.tratamiento);
		add(this.tipo_pago);
		add(this.numero_meses);
		add(etiqueta_dni_nombre_usuario);
		add(etiqueta_tratamiento);
		add(etiqueta_tipo_pago);
		add(etiqueta_numero_meses);
		add(boton_aceptar);
	}
}
