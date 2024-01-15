package Vista.administrador.gestion_de_material;

import javax.swing.JPanel;

import Controlador.BBDD;
import Vista.Login_Inicio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import prueba.Despegable_editable_theme;

public class Modificar_Pedido extends JPanel {
	private Despegable_editable_theme proveedor;
	private Despegable_editable_theme fecha;
	protected BBDD dbconn;
	// Constructores
	public Modificar_Pedido() {
		
		this.dbconn = new BBDD();
		this.dbconn.conectar();
		
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
		btndntstEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(proveedor.getSelectedItem().toString().equals("...")||fecha.getSelectedItem().toString().equals("...")) {
					JOptionPane.showMessageDialog(null,"Rellene todos los campos");
				}else {
					dbconn.borrarDobleCondi("pedidos", "Nombre_Proveedor", proveedor.getSelectedItem().toString(), "Fecha", fecha.getSelectedItem().toString());
				}

			}
		});

		btndntstEliminar.setText("Eliminar");
		btndntstEliminar.setRadius(30);
		btndntstEliminar.setBorder(null);
		btndntstEliminar.setBounds(280, 135, 160, 30);
		add(btndntstEliminar);
		
		proveedor = new Despegable_editable_theme(20);
		proveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for(String fechas:dbconn.SelectListaCondicion("Fecha", "pedidos","where Nombre_Proveedor = '"+proveedor.getSelectedItem().toString()+"'")) {
						fecha.addItem(fechas);

					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		});
		proveedor.setBounds(103, 55, 205, 30);
		add(proveedor);
		proveedor.addItem("...");
		
		try {
			for(String nombre:dbconn.SelectListaCondicion("Nombre", "usuario","where Perfil = 'proveedor'")) {
				proveedor.addItem(nombre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		fecha = new Despegable_editable_theme(20);
		fecha.setBounds(411, 55, 205, 30);
		add(fecha);
		fecha.addItem("...");


	}
}
