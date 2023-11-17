package Vista.administrador.gestion_de_material;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import botonDentista.BotonDentista;
import prueba.Campo_texto_theme;

public class Modificar_Stock extends JPanel {

	// Atributos
	protected JComboBox<String> material;
	protected JComboBox<String> estado;
	Campo_texto_theme stock;
	
	// Constructores
	public Modificar_Stock() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		
		// Creacion de los elementos graficos
		this.material = new JComboBox<String>();
		this.estado = new JComboBox<String>();

		this.material.setBounds(100,35,205,30);
		this.material.setBackground(new Color(255, 255, 255));
		this.estado.setBounds(408, 35, 205, 30);
		this.estado.setBackground(new Color(255, 255, 255));

		JLabel etiqueta_material = new JLabel("Material:");
		etiqueta_material.setBounds(100, 20, 64, 13);
		
		JLabel etiqueta_estado = new JLabel("Estado:");
		etiqueta_estado.setBounds(408, 20, 107, 13);
		
		JLabel etiqueta_stock = new JLabel("Stock");
		etiqueta_stock.setBounds(622, 20, 39, 13);
		
		stock = new Campo_texto_theme(20);
		stock.setBounds(625, 35, 35, 30);
		
		add(this.material);
		add(this.estado);
		add(etiqueta_material);
		add(etiqueta_estado);
		add(etiqueta_stock);
		add(stock);

		BotonDentista btndntstAceptar = new BotonDentista();
		
		btndntstAceptar.setText("Aceptar");
		btndntstAceptar.setRadius(30);
		btndntstAceptar.setBorder(null);
		btndntstAceptar.setBounds(277, 110, 160, 30);
		add(btndntstAceptar);
	}
}
