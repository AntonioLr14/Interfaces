package Vista.administrador;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JSeparator;

public class Administrar_Facturas extends JPanel {

	// Atributos
	protected JPanel panel;
	
	// Constructores
	public Administrar_Facturas() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(230, 247, 255));
		setLayout(null);
		
		// Creacion de los elementos graficos
		this.panel = new JPanel();
		this.panel.setBounds(97, 153, 526, 193);
		this.panel.setBackground(new Color(230, 247, 255));

		JButton boton_crear_facturas = new JButton("Crear Factura");
		
		boton_crear_facturas.setBounds(133, 40, 160, 30);
		boton_crear_facturas.setContentAreaFilled(false);
		boton_crear_facturas.setBorderPainted(false);

		JButton boton_consultar_facturas = new JButton("Consultar factura");
		
		boton_consultar_facturas.setBounds(426, 40, 160, 30);
		boton_consultar_facturas.setContentAreaFilled(false);
		boton_consultar_facturas.setBorderPainted(false);

		JSeparator separator = new JSeparator();
		separator.setBounds(115, 80, 200, 10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(412, 80, 200, 10);
		
		add(boton_crear_facturas);
		add(boton_consultar_facturas);
		add(separator);
		add(separator_1);
		add(this.panel);
		
		// Asignacion de los eventos
		boton_crear_facturas.addActionListener( (event) -> {
			
			if (this.panel.isShowing()) {
				remove(this.panel);
			}
			
			// Establecimiento del panel de crear facturas
			this.panel = new Crear_Factura();
			this.panel.setLocation(0,100);
			
			add(this.panel);
			updateUI();
		});
		
		boton_consultar_facturas.addActionListener( (event) -> {
			
			if (this.panel.isShowing()) {
				remove(this.panel);
			}
			
			// Establecimiento del panel de consultar facturas
			this.panel = new Consultar_Factura();
			this.panel.setLocation(0,100);
			
			add(this.panel);
			updateUI();
		});
	}
}
