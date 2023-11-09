package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Actualizar_Stock extends JPanel {

	// Atributos
	protected JComboBox<String> material;
	protected JTextField cantidad_total;
	protected JTextField stock;

	// Constructores
	public Actualizar_Stock() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(255,255, 255));
		setLayout(null);
		
		// Creacion de los elementos graficos
		this.material = new JComboBox<String>();
		this.cantidad_total = new JTextField();
		this.stock = new JTextField();

		this.material.setBounds(100,35,205,30);
		this.material.setBackground(new Color(255, 255, 255));
		this.cantidad_total.setBounds(408, 35, 205, 30);
		this.stock.setBounds(625, 35, 35, 30);
		this.stock.setEditable(false);

		JLabel etiqueta_material = new JLabel("Material:");
		etiqueta_material.setBounds(100, 20, 64, 13);
		
		JLabel etiqueta_cantidad_total = new JLabel("Cantidad total:");
		etiqueta_cantidad_total.setBounds(408, 20, 107, 13);
		
		JLabel etiqueta_stock = new JLabel("Stock");
		etiqueta_stock.setBounds(622, 20, 39, 13);

		
		add(this.material);
		add(this.cantidad_total);
		add(this.stock);
		add(etiqueta_material);
		add(etiqueta_cantidad_total);
		add(etiqueta_stock);
		
		BotonDentista btndntstActualizar = new BotonDentista();
		btndntstActualizar.setBorder(null);
		btndntstActualizar.setText("Actualizar");
		btndntstActualizar.setRadius(50);
		btndntstActualizar.setBounds(276, 98, 160, 39);
		add(btndntstActualizar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoadminabajo.png")));
		lblFondo.setBounds(0, 0, 728, 218);
		add(lblFondo);
	}
}
