package Vista.administrador;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JSeparator;
import botonDentista.BotonDentista;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		add(this.panel);
		
		BotonDentista btndntstCrearFactura = new BotonDentista();
		btndntstCrearFactura.setBorder(null);
	
		btndntstCrearFactura.setText("Crear Factura");
		btndntstCrearFactura.setRadius(30);
		btndntstCrearFactura.setBounds(137, 40, 160, 30);
		add(btndntstCrearFactura);
		
		BotonDentista btndntstConsultarFactura = new BotonDentista();
		btndntstConsultarFactura.addActionListener( (event) -> {
			
			if (this.panel.isShowing()) {
				remove(this.panel);
			}
			
			// Establecimiento del panel de consultar facturas
			this.panel = new Consultar_Factura();
			this.panel.setLocation(0,100);
			
			add(this.panel);
			updateUI();
		});
		btndntstConsultarFactura.setText("Consultar Factura");
		btndntstConsultarFactura.setRadius(30);
		btndntstConsultarFactura.setBorder(null);
		btndntstConsultarFactura.setBounds(435, 40, 160, 30);
		add(btndntstConsultarFactura);
	btndntstCrearFactura.addActionListener( (event) -> {
			
			if (this.panel.isShowing()) {
				remove(this.panel);
			}
			
			// Establecimiento del panel de crear facturas
			this.panel = new Crear_Factura();
			this.panel.setLocation(0,100);
			
			add(this.panel);
			updateUI();
		});
	}
}
