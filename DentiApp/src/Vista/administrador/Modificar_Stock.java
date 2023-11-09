package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import botonDentista.BotonDentista;

public class Modificar_Stock extends JPanel {

	// Atributos
	protected JComboBox<String> material;
	protected JComboBox<String> estado;
	protected JTextField stock;
	
	// Constructores
	public Modificar_Stock() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(255,255, 255));
		setLayout(null);
		
		// Creacion de los elementos graficos
		this.material = new JComboBox<String>();
		this.estado = new JComboBox<String>();
		this.stock = new JTextField();

		this.material.setBounds(100,35,205,30);
		this.material.setBackground(new Color(255, 255, 255));
		this.estado.setBounds(408, 35, 205, 30);
		this.estado.setBackground(new Color(255, 255, 255));
		this.stock.setBounds(625, 35, 35, 30);
		this.stock.setEditable(false);

		JLabel etiqueta_material = new JLabel("Material:");
		etiqueta_material.setBounds(100, 20, 64, 13);
		
		JLabel etiqueta_estado = new JLabel("Estado:");
		etiqueta_estado.setBounds(408, 20, 107, 13);
		
		JLabel etiqueta_stock = new JLabel("Stock");
		etiqueta_stock.setBounds(622, 20, 39, 13);
		
		add(this.material);
		add(this.estado);
		add(this.stock);
		add(etiqueta_material);
		add(etiqueta_estado);
		add(etiqueta_stock);
		
		BotonDentista btndntstAceptar = new BotonDentista();
		btndntstAceptar.setText("Aceptar");
		btndntstAceptar.setRadius(30);
		btndntstAceptar.setBorder(null);
		btndntstAceptar.setBounds(277, 110, 160, 30);
		add(btndntstAceptar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoadminabajo.png")));
		lblFondo.setBounds(0, 0, 728, 218);
		add(lblFondo);
	}
}
