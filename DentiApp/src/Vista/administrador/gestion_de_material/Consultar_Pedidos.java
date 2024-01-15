package Vista.administrador.gestion_de_material;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import Vista.Login_Inicio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;

import Controlador.BBDD;
import prueba.Despegable_editable_theme;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Consultar_Pedidos extends JPanel {
	private Despegable_editable_theme proveedor;
	private Despegable_editable_theme fecha;
	protected BBDD dbconn;
	private JTable table;
	
	// Constructores
	public Consultar_Pedidos() {
		
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
		
		BotonDentista btndntstConsultar = new BotonDentista();
		btndntstConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(proveedor.getSelectedItem().toString().equals("...")||fecha.getSelectedItem().toString().equals("...")) {
					JOptionPane.showMessageDialog(null,"Rellene todos los campos para crear el pedido");
				}else {
					try {
						String consulta="SELECT * from dentiapp.pedidos WHERE Nombre_Proveedor='"+proveedor.getSelectedItem().toString()+"' and Fecha='"+fecha.getSelectedItem().toString()+"';";
						dbconn.SelectValor(table,consulta) ;
					} catch (SQLException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
				}


			}
			
		});
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
		proveedor.addItem("...");
		
		try {
			for(String nombre:dbconn.SelectListaCondicion("Nombre", "usuario","where Perfil = 'proveedor'")) {
				proveedor.addItem(nombre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fecha.addItem("...");
		
		table = new JTable();
		table.setBounds(177, 130, 365, 130);
		add(table);
		
	}
}
