package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;

public class Consultar_Pedidos extends JPanel {

	// Atributos
	protected JComboBox<String> proveedor;
	protected JComboBox<String> fecha;
	protected JTextArea consultas_pedidos;
	
	// Constructores
	public Consultar_Pedidos() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(230, 247, 255));
		setLayout(null);
		
		// Creacion de los elementos graficos
		this.proveedor = new JComboBox<String>();
		this.fecha = new JComboBox<String>();
		this.consultas_pedidos = new JTextArea();
		
		this.proveedor.setBounds(103,55,205,30);
		this.proveedor.setBackground(new Color(255, 255, 255));
		this.fecha.setBounds(411,55,205,30);
		this.fecha.setBackground(new Color(255, 255, 255));
		this.consultas_pedidos.setBounds(177,130,365,130);
		
		JLabel etiqueta_proveedor = new JLabel("Proveedor:");
		etiqueta_proveedor.setBounds(103, 40, 78, 13);
		
		JLabel etiqueta_fecha = new JLabel("Fecha:");
		etiqueta_fecha.setBounds(411, 40, 47, 13);

		add(this.proveedor);
		add(this.fecha);
		add(this.consultas_pedidos);
		add(etiqueta_proveedor);
		add(etiqueta_fecha);
		
		BotonDentista btndntstConsultar = new BotonDentista();
		btndntstConsultar.setText("Consultar");
		btndntstConsultar.setRadius(30);
		btndntstConsultar.setBorder(null);
		btndntstConsultar.setBounds(552, 225, 107, 35);
		add(btndntstConsultar);
	}
}
