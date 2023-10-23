package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;

public class Actualizar_Stock extends JPanel {

	// Atributos
	protected JComboBox<String> material;
	protected JTextField cantidad_total;
	protected JTextField stock;

	// Constructores
	public Actualizar_Stock() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(230, 247, 255));
		setLayout(null);
		
		// Creacion de los elementos graficos
		this.material = new JComboBox<String>();
		this.cantidad_total = new JTextField();
		this.stock = new JTextField();

		this.material.setBounds(103,15,205,30);
		this.material.setBackground(new Color(255, 255, 255));
		this.cantidad_total.setBounds(411, 15, 205, 30);
		this.stock.setBounds(628, 15, 35, 30);
		this.stock.setEditable(false);

		JLabel etiqueta_material = new JLabel("Material:");
		etiqueta_material.setBounds(103, 0, 64, 13);
		
		JLabel etiqueta_cantidad_total = new JLabel("Cantidad total:");
		etiqueta_cantidad_total.setBounds(411, 0, 107, 13);
		
		JLabel etiqueta_stock = new JLabel("Stock");
		etiqueta_stock.setBounds(625, 0, 39, 13);
				
		JButton boton_actualizar = new JButton("Actualizar");
		
		boton_actualizar.setBounds(280, 90, 160, 30);
		boton_actualizar.setContentAreaFilled(false);
		
		add(this.material);
		add(this.cantidad_total);
		add(this.stock);
		add(etiqueta_material);
		add(etiqueta_cantidad_total);
		add(etiqueta_stock);
		add(boton_actualizar);
	}
}
