package Vista.administrador.gestion_economica;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import Vista.Login_Inicio;
import botonDentista.BotonDentista;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		add(this.panel);
		
		BotonDentista btndntstCrearFactura = new BotonDentista();
		
		btndntstCrearFactura.setBorder(null);
		btndntstCrearFactura.setText("Crear Factura");
		btndntstCrearFactura.setRadius(30);
		btndntstCrearFactura.setBounds(137, 40, 160, 30);
		add(btndntstCrearFactura);
		
		BotonDentista btndntstConsultarFactura = new BotonDentista();
		
		btndntstConsultarFactura.setText("Consultar Factura");
		btndntstConsultarFactura.setRadius(30);
		btndntstConsultarFactura.setBorder(null);
		btndntstConsultarFactura.setBounds(435, 40, 160, 30);
		add(btndntstConsultarFactura);
	
		btndntstConsultarFactura.addActionListener( (event) -> {
			
			if (this.panel.isShowing()) {
				remove(this.panel);
			}
			
			// Establecimiento del panel de consultar facturas
			try {
				this.panel = new Consultar_Factura();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.panel.setLocation(0,112);
			
			add(this.panel);
			updateUI();
		});
		
		btndntstCrearFactura.addActionListener( (event) -> {
			
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
