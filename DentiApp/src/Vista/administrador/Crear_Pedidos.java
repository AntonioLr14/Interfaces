package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;

public class Crear_Pedidos extends JPanel {

	protected JComboBox<String> material;
	protected JTextField unidades_material;
	protected JComboBox<String> proveedor;
	protected JTextArea pedidos;

	public Crear_Pedidos() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);

		this.material = new JComboBox<String>();
		this.unidades_material = new JTextField();
		this.proveedor = new JComboBox<String>();
		this.pedidos = new JTextArea();
		
		this.material.setBounds(103,55,205,30);
		this.material.setBackground(new Color(255, 255, 255));
		this.unidades_material.setBounds(320, 56, 35, 30);
		this.proveedor.setBounds(411,55,205,30);
		this.proveedor.setBackground(new Color(255, 255, 255));
		this.pedidos.setBounds(177,130,365,130);
		
		JLabel etiqueta_material = new JLabel("Material:");
		etiqueta_material.setBounds(103,40, 64, 13);
		
		JLabel etiqueta_unidades_material = new JLabel("U");
		etiqueta_unidades_material.setBounds(330, 40, 10, 13);
		
		JLabel etiqueta_proveedor = new JLabel("Proveedor:");
		etiqueta_proveedor.setBounds(411, 40, 78, 13);
		
		JButton boton_crear = new JButton("<html><p align='center'>Crear<br>pedido</html>");
		
		boton_crear.setBounds(554, 225, 100, 35);
		boton_crear.setContentAreaFilled(false);

		add(this.material);
		add(this.unidades_material);
		add(this.proveedor);
		add(this.pedidos);
		add(etiqueta_material);
		add(etiqueta_unidades_material);
		add(etiqueta_proveedor);
		add(boton_crear);
	}
}
