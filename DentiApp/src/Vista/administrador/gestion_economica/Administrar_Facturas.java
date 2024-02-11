package Vista.administrador.gestion_economica;

import javax.swing.JPanel;
import botonDentista.BotonDentista;

public class Administrar_Facturas extends JPanel {

	// Atributos
	protected JPanel panel;
	
	// Constructores
	public Administrar_Facturas() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		
		// Creacion de los elementos graficos
		this.panel = new JPanel();
		
		this.panel.setBounds(0, 142, 720, 208);
		this.panel.setOpaque(false);
		
		BotonDentista boton_crear_factura = new BotonDentista();
		
		boton_crear_factura.setBounds(137, 40, 160, 30);
		boton_crear_factura.setBorder(null);
		boton_crear_factura.setRadius(30);
		boton_crear_factura.setText("Crear Factura");
		boton_crear_factura.setFocusable(false);
		
		BotonDentista boton_consultar_factura = new BotonDentista();
		
		boton_consultar_factura.setBounds(435, 40, 160, 30);
		boton_consultar_factura.setBorder(null);
		boton_consultar_factura.setRadius(30);
		boton_consultar_factura.setText("Consultar Factura");
		boton_consultar_factura.setFocusable(false);

		add(this.panel);
		add(boton_crear_factura);
		add(boton_consultar_factura);
	
		// Establecimiento de los eventos
		boton_consultar_factura.addActionListener( (event) -> {
			
			if (this.panel.isShowing()) {
				remove(this.panel);
			}
			
			// Establecimiento del panel de consultar facturas
			this.panel = new Consultar_Factura();
			this.panel.setLocation(0,112);
			
			add(this.panel);
			updateUI();
		});
		
		boton_crear_factura.addActionListener( (event) -> {
			
			if (this.panel.isShowing()) {
				remove(this.panel);
			}
			
			// Establecimiento del panel de crear facturas
			this.panel = new Crear_Factura();
			this.panel.setLocation(0,112);
			
			add(this.panel);
			updateUI();
		});
	}
}
