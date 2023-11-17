package Vista.administrador.gestion_de_material;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import botonDentista.BotonDentista;
import prueba.Campo_texto_theme;

public class Insertar_Material extends JPanel {
	
	private Campo_texto_theme nombre_material;
	private Campo_texto_theme cantidad_total;

	// Constructores
	public Insertar_Material() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);

		JLabel etiqueta_nombre_material = new JLabel("Nuevo material:");
		etiqueta_nombre_material.setBounds(100, 20, 112, 13);
		
		JLabel etiqueta_cantidad_total = new JLabel("Cantidad total:");
		etiqueta_cantidad_total.setBounds(408, 20, 107, 13);
		
		cantidad_total = new Campo_texto_theme(20);
		cantidad_total.setBounds(408, 35, 205, 30);
		
		nombre_material = new Campo_texto_theme(20);
		nombre_material.setBounds(103, 35, 205, 30);
		add(etiqueta_nombre_material);
		add(etiqueta_cantidad_total);
		add(cantidad_total);
		add(nombre_material);

		BotonDentista btndntstAgregarMaterial = new BotonDentista();
		
		btndntstAgregarMaterial.setBorder(null);
		btndntstAgregarMaterial.setRadius(30);
		btndntstAgregarMaterial.setText("Agregar material");
		btndntstAgregarMaterial.setBounds(277, 110, 160, 30);
		add(btndntstAgregarMaterial);
	}
}
