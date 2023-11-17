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
import prueba.Despegable_editable_theme;

public class Modificar_Pedido extends JPanel {
	private Despegable_editable_theme proveedor;
	private Despegable_editable_theme fecha;
	// Constructores
	public Modificar_Pedido() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);

		JLabel etiqueta_proveedor = new JLabel("Proveedor:");
		etiqueta_proveedor.setBounds(103, 40, 78, 13);
		
		JLabel etiqueta_fecha = new JLabel("Fecha:");
		etiqueta_fecha.setBounds(411, 40, 47, 13);
		add(etiqueta_proveedor);
		add(etiqueta_fecha);
		
		BotonDentista btndntstEliminar = new BotonDentista();

		btndntstEliminar.setText("Eliminar");
		btndntstEliminar.setRadius(30);
		btndntstEliminar.setBorder(null);
		btndntstEliminar.setBounds(280, 135, 160, 30);
		add(btndntstEliminar);
		
		proveedor = new Despegable_editable_theme(20);
		proveedor.setBounds(103, 55, 205, 30);
		add(proveedor);
		
		fecha = new Despegable_editable_theme(20);
		fecha.setBounds(411, 55, 205, 30);
		add(fecha);
	}
}
