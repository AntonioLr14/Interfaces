package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import botonDentista.BotonDentista;

public class Insertar_Material extends JPanel {

	// Atributos
	protected JTextField nombre_material;
	protected JTextField cantidad_total;

	// Constructores
	public Insertar_Material() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(255,255,255));
		setLayout(null);
		
		// Creacion de los elementos graficos
		this.nombre_material = new JTextField();
		this.cantidad_total = new JTextField();

		this.nombre_material.setBounds(100, 35, 205, 30);
		this.cantidad_total.setBounds(408, 35, 205, 30);

		JLabel etiqueta_nombre_material = new JLabel("Nuevo material:");
		etiqueta_nombre_material.setBounds(100, 20, 112, 13);
		
		JLabel etiqueta_cantidad_total = new JLabel("Cantidad total:");
		etiqueta_cantidad_total.setBounds(408, 20, 107, 13);
		
		add(this.nombre_material);
		add(this.cantidad_total);
		add(etiqueta_nombre_material);
		add(etiqueta_cantidad_total);
		
		BotonDentista btndntstAgregarMaterial = new BotonDentista();
		btndntstAgregarMaterial.setBorder(null);
		btndntstAgregarMaterial.setRadius(30);
		btndntstAgregarMaterial.setText("Agregar material");
		btndntstAgregarMaterial.setBounds(277, 110, 160, 30);
		add(btndntstAgregarMaterial);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoadminabajo.png")));
		lblFondo.setBounds(0, 0, 728, 218);
		add(lblFondo);
	}
}
