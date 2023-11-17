package Vista.administrador.gestion_de_material;

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
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;

public class Actualizar_Stock extends JPanel {
	private Campo_texto_theme stock;
	private Campo_texto_theme cantidad_total;
	private Despegable_editable_theme material;

	// Constructores
	public Actualizar_Stock() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);

		JLabel etiqueta_material = new JLabel("Material:");
		etiqueta_material.setBounds(100, 20, 64, 13);
		
		JLabel etiqueta_cantidad_total = new JLabel("Cantidad total:");
		etiqueta_cantidad_total.setBounds(408, 20, 107, 13);
		
		JLabel etiqueta_stock = new JLabel("Stock");
		etiqueta_stock.setBounds(622, 20, 39, 13);
		
		stock = new Campo_texto_theme(20);
		stock.setBounds(625, 35, 35, 30);
		
		cantidad_total = new Campo_texto_theme(20);
		cantidad_total.setBounds(408, 35, 205, 30);
		
		material = new Despegable_editable_theme(20);
		material.setBounds(100, 35, 205, 30);
		add(material);
		add(etiqueta_material);
		add(etiqueta_cantidad_total);
		add(etiqueta_stock);
		add(stock);
		add(cantidad_total);
		
		BotonDentista btndntstActualizar = new BotonDentista();
		btndntstActualizar.setBorder(null);
		btndntstActualizar.setText("Actualizar");
		btndntstActualizar.setRadius(50);
		btndntstActualizar.setBounds(276, 98, 160, 39);
		add(btndntstActualizar);
	}
}
