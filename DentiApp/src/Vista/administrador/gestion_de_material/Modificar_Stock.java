package Vista.administrador.gestion_de_material;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controlador.BBDD;
import Vista.Login_Inicio;

import java.awt.Color;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import botonDentista.BotonDentista;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Modificar_Stock extends JPanel {
	private Campo_texto_theme stock;
	private Despegable_editable_theme material;
	private Despegable_editable_theme estado;
	protected BBDD dbconn;
	
	// Constructores
	public Modificar_Stock() {
		this.dbconn = new BBDD();
		this.dbconn.conectar();
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);

		JLabel etiqueta_material = new JLabel("Material:");
		etiqueta_material.setBounds(100, 20, 64, 13);
		
		JLabel etiqueta_estado = new JLabel("Estado:");
		etiqueta_estado.setBounds(408, 20, 107, 13);
		
		JLabel etiqueta_stock = new JLabel("Stock");
		etiqueta_stock.setBounds(622, 20, 39, 13);
		
		stock = new Campo_texto_theme(20);
		stock.setBounds(625, 35, 35, 30);
		add(etiqueta_material);
		add(etiqueta_estado);
		add(etiqueta_stock);
		add(stock);

		BotonDentista btndntstAceptar = new BotonDentista();
		btndntstAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(estado.getSelectedItem().toString().equals("Alta")) {
					dbconn.update("Stock", "Estado = 1", "Nombre='"+material.getSelectedItem().toString()+"';");
				}else if(estado.getSelectedItem().toString().equals("Baja")) {
					dbconn.update("Stock", "Estado = 0", "Nombre='"+material.getSelectedItem().toString()+"';");
				}else {
					JOptionPane.showMessageDialog(null,"Seleccione un estado válido");
				}
				
				
				
			}
		});
		
		btndntstAceptar.setText("Aceptar");
		btndntstAceptar.setRadius(30);
		btndntstAceptar.setBorder(null);
		btndntstAceptar.setBounds(277, 110, 160, 30);
		add(btndntstAceptar);
		
		material = new Despegable_editable_theme(20);
		material.setBounds(100, 35, 205, 30);
		add(material);
		material.addItem("...");
		try {
			for(String nombre:dbconn.SelectLista("Nombre", "Stock")) {
				material.addItem(nombre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		material.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> cantidades;
				try {
					cantidades=dbconn.SelectListaCondicion("Cantidad", "Stock", "where nombre ='"+material.getSelectedItem().toString()+"'");
					int total=0;
					for(String num:cantidades) {
						total+=Integer.parseInt(num);
					}
					stock.setText(String.valueOf(total));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});


		
		estado = new Despegable_editable_theme(20);
		estado.setBounds(408, 35, 205, 30);
		add(estado);
		estado.addItem(" ");
		estado.addItem("Alta");
		estado.addItem("Baja");
		

	}
}
