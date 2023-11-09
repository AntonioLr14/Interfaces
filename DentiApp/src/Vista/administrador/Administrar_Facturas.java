package Vista.administrador;

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
		setBackground(new Color(255,255, 255));
		setLayout(null);
		
		// Creacion de los elementos graficos
		this.panel = new JPanel();
		panel.setOpaque(false);
		this.panel.setBounds(0, 142, 720, 208);
		this.panel.setBackground(new Color(255,255, 255));
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
	
	JLabel lblFondo = new JLabel("");
	lblFondo.setBackground(new Color(0, 128, 255));
	lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoadminarriba.png")));
	lblFondo.setBounds(0, 0, 728, 142);
	add(lblFondo);
	JLabel lblFondo1 = new JLabel("");
	lblFondo1.setBackground(new Color(0, 128, 255));
	lblFondo1.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoadminabajo.png")));
	lblFondo1.setBounds(0,142, 730, 218);
	add(lblFondo1);
	
	btndntstConsultarFactura.addActionListener( (event) -> {
		lblFondo1.setVisible(false);
		if (this.panel.isShowing()) {
			remove(this.panel);
		}
		
		// Establecimiento del panel de consultar facturas
		this.panel = new Consultar_Factura();
		this.panel.setLocation(0,142);
		
		add(this.panel);
		updateUI();
	});
	
	btndntstCrearFactura.addActionListener( (event) -> {
		lblFondo1.setVisible(false);
		if (this.panel.isShowing()) {
			remove(this.panel);
		}
		
		// Establecimiento del panel de crear facturas
		this.panel = new Crear_Factura();
		this.panel.setLocation(0,142);
		
		add(this.panel);
		updateUI();
	});
	}
	
}
