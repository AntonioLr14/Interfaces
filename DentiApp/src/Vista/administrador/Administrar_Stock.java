package Vista.administrador;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JSeparator;

public class Administrar_Stock extends JPanel {

	// Atributos
	protected JPanel panel;
	
	// Constructores
	public Administrar_Stock() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(230, 247, 255));
		setLayout(null);
		
		// Creacion de los elementos graficos
		this.panel = new JPanel();
		this.panel.setBounds(97,153,526,193);
		this.panel.setBackground(new Color(230, 247, 255));
		
		JButton boton_actualizar_stock = new JButton("Actualizar stock");
		
		boton_actualizar_stock.setBounds(58, 40, 160, 30);
		boton_actualizar_stock.setBorderPainted(false);
		boton_actualizar_stock.setContentAreaFilled(false);
		
		JButton boton_insertar_material = new JButton("Insertar material");
		
		boton_insertar_material.setBounds(276, 40, 160, 30);
		boton_insertar_material.setBorderPainted(false);
		boton_insertar_material.setContentAreaFilled(false);

		JButton boton_modificar_material = new JButton("Modificar material");
		
		boton_modificar_material.setBounds(507, 40, 165, 30);
		boton_modificar_material.setBorderPainted(false);
		boton_modificar_material.setContentAreaFilled(false);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 80, 200, 10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(490, 80, 200, 10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(260, 80, 200, 10);
		
		add(boton_actualizar_stock);
		add(boton_insertar_material);
		add(boton_modificar_material);
		add(separator);
		add(separator_1);
		add(separator_2);
		add(this.panel);
		
		// Asignacion de los eventos
		boton_actualizar_stock.addActionListener( (event) -> {
			
			if (this.panel.isShowing()) {
				remove(this.panel);
			}
			
			// Establecimiento del panel de actualizar stock
			this.panel = new Actualizar_Stock();
			this.panel.setLocation(-20,100);
			
			add(this.panel);
			updateUI();
		});
		
		boton_insertar_material.addActionListener( (event) -> {
					
			if (this.panel.isShowing()) {
				remove(this.panel);
			}
			
			// Establecimiento del panel de insertar material
			this.panel = new Insertar_Material();
			this.panel.setLocation(0,100);
			
			add(this.panel);
			updateUI();
		});
		
		boton_modificar_material.addActionListener( (event) -> {
			
			if (this.panel.isShowing()) {
				remove(this.panel);
			}
			
			// Establecimiento del panel de modificar material
			this.panel = new Modificar_Stock();
			this.panel.setLocation(-20,100);
			
			add(this.panel);
			updateUI();
		});
	}
}
