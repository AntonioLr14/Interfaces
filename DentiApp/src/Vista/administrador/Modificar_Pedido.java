package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;

public class Modificar_Pedido extends JPanel {

	// Atributos
	protected JComboBox<String> proveedor;
	protected JComboBox<String> fecha;
	
	// Constructores
	public Modificar_Pedido() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(230, 247, 255));
		setLayout(null);
		
		// Creacion de los elementos graficos
		this.proveedor = new JComboBox<String>();
		this.fecha = new JComboBox<String>();
		
		this.proveedor.setBounds(103,55,205,30);
		this.proveedor.setBackground(new Color(255, 255, 255));
		this.fecha.setBounds(411,55,205,30);
		this.fecha.setBackground(new Color(255, 255, 255));

		JLabel etiqueta_proveedor = new JLabel("Proveedor:");
		etiqueta_proveedor.setBounds(103, 40, 78, 13);
		
		JLabel etiqueta_fecha = new JLabel("Fecha:");
		etiqueta_fecha.setBounds(411, 40, 47, 13);
		
		JButton boton_eliminar = new JButton("Eliminar");
		
		boton_eliminar.setBounds(280, 135, 160, 30);
		boton_eliminar.setContentAreaFilled(false);

		add(this.proveedor);
		add(this.fecha);
		add(etiqueta_proveedor);
		add(etiqueta_fecha);
		add(boton_eliminar);
	}
}
