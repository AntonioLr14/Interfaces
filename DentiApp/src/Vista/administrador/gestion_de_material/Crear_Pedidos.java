package Vista.administrador.gestion_de_material;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;
import prueba.Campo_texto_theme;

public class Crear_Pedidos extends JPanel {

	// Atributos
	protected JComboBox<String> material;
	protected JComboBox<String> proveedor;
	protected JTextArea pedidos;
	private Campo_texto_theme unidades_material;

	// Constructores
	public Crear_Pedidos() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);

		// Creacion de los elementos graficos
		this.material = new JComboBox<String>();
		this.proveedor = new JComboBox<String>();
		this.pedidos = new JTextArea();
		pedidos.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		this.material.setBounds(103,55,205,30);
		this.material.setBackground(new Color(255, 255, 255));
		this.proveedor.setBounds(411,55,205,30);
		this.proveedor.setBackground(new Color(255, 255, 255));
		this.pedidos.setBounds(177,130,365,130);
		
		JLabel etiqueta_material = new JLabel("Material:");
		etiqueta_material.setBounds(103,40, 64, 13);
		
		JLabel etiqueta_unidades_material = new JLabel("U");
		etiqueta_unidades_material.setBounds(330, 40, 10, 13);
		
		JLabel etiqueta_proveedor = new JLabel("Proveedor:");
		etiqueta_proveedor.setBounds(411, 40, 78, 13);
		
		unidades_material = new Campo_texto_theme(20);
		unidades_material.setBounds(320, 56, 35, 30);

		add(this.material);
		add(this.proveedor);
		add(this.pedidos);
		add(etiqueta_material);
		add(etiqueta_unidades_material);
		add(etiqueta_proveedor);
		add(unidades_material);

		
		BotonDentista btndntstAligncentercrearpedido = new BotonDentista();
		
		btndntstAligncentercrearpedido.setBorder(null);
		btndntstAligncentercrearpedido.setRadius(30);
		btndntstAligncentercrearpedido.setText("<html><p align='center'>Crear<br>pedido</html>");
		btndntstAligncentercrearpedido.setBounds(554, 225, 100, 35);
		add(btndntstAligncentercrearpedido);
	}
}
