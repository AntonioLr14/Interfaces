package Vista.administrador.gestion_de_material;

import javax.swing.JPanel;

import Vista.Login_Inicio;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Modificar_Pedido extends JPanel {

	// Atributos
	protected JComboBox<String> proveedor;
	protected JComboBox<String> fecha;
	
	// Constructores
	public Modificar_Pedido() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		
		// Creacion de los elementos graficos
		this.proveedor = new JComboBox<String>();
		this.fecha = new JComboBox<String>();
		
		this.proveedor.setBounds(103,55,205,30);
		this.proveedor.setBackground(new Color(255, 255, 255));
		this.fecha.setBounds(411,55,205,30);
		this.fecha.setBackground(new Color(255, 255, 255));

		JLabel etiqueta_proveedor = new JLabel("Proveedor:");
		etiqueta_proveedor.setBounds(103, 40, 78, 13);
		
		JLabel etiqueta_fecha = new JLabel("Fecha:");
		etiqueta_fecha.setBounds(411, 40, 47, 13);

		add(this.proveedor);
		add(this.fecha);
		add(etiqueta_proveedor);
		add(etiqueta_fecha);
		
		BotonDentista btndntstEliminar = new BotonDentista();

		btndntstEliminar.setText("Eliminar");
		btndntstEliminar.setRadius(30);
		btndntstEliminar.setBorder(null);
		btndntstEliminar.setBounds(280, 135, 160, 30);
		add(btndntstEliminar);
	}
}
