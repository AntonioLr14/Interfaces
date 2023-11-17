package Vista.administrador.gestion_de_material;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import Vista.Login_Inicio;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;
import prueba.Despegable_editable_theme;

public class Consultar_Pedidos extends JPanel {
	protected JTextArea consultas_pedidos;
	private Despegable_editable_theme proveedor;
	private Despegable_editable_theme fecha;
	
	// Constructores
	public Consultar_Pedidos() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		this.consultas_pedidos = new JTextArea();
		consultas_pedidos.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.consultas_pedidos.setBounds(177,130,365,130);
		
		JLabel etiqueta_proveedor = new JLabel("Proveedor:");
		etiqueta_proveedor.setBounds(103, 40, 78, 13);
		
		JLabel etiqueta_fecha = new JLabel("Fecha:");
		etiqueta_fecha.setBounds(411, 40, 47, 13);
		add(this.consultas_pedidos);
		add(etiqueta_proveedor);
		add(etiqueta_fecha);
		
		BotonDentista btndntstConsultar = new BotonDentista();
		btndntstConsultar.setText("Consultar");
		btndntstConsultar.setRadius(30);
		btndntstConsultar.setBorder(null);
		btndntstConsultar.setBounds(552, 225, 107, 35);
		add(btndntstConsultar);
		
		proveedor = new Despegable_editable_theme(20);
		proveedor.setBounds(103, 55, 205, 30);
		add(proveedor);
		
		fecha = new Despegable_editable_theme(20);
		fecha.setBounds(411, 55, 205, 30);
		add(fecha);
	}
}
