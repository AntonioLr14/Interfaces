package Vista.administrador.gestion_de_material;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.sql.SQLException;
import java.time.LocalDate;

import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;

import Controlador.BBDD;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Crear_Pedidos extends JPanel {
	protected JTextArea pedidos;
	private Campo_texto_theme unidades_material;
	private Despegable_editable_theme material;
	private Despegable_editable_theme proveedores;
	protected BBDD dbconn;
	

	// Constructores
	public Crear_Pedidos() {
		this.dbconn = new BBDD();
		this.dbconn.conectar();
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		this.pedidos = new JTextArea();
		pedidos.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.pedidos.setBounds(177,130,365,130);
		
		JLabel etiqueta_material = new JLabel("Material:");
		etiqueta_material.setBounds(103,40, 64, 13);
		
		JLabel etiqueta_unidades_material = new JLabel("U");
		etiqueta_unidades_material.setBounds(330, 40, 10, 13);
		
		JLabel etiqueta_proveedor = new JLabel("Proveedor:");
		etiqueta_proveedor.setBounds(411, 40, 78, 13);
		
		unidades_material = new Campo_texto_theme(20);
		unidades_material.setBounds(320, 56, 35, 30);
		add(this.pedidos);
		add(etiqueta_material);
		add(etiqueta_unidades_material);
		add(etiqueta_proveedor);
		add(unidades_material);

		
		BotonDentista btndntstcrearpedido = new BotonDentista();
		btndntstcrearpedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(unidades_material.getText().isEmpty()||proveedores.getSelectedItem().toString().equals("...")||material.getSelectedItem().toString().equals("...")) {
					JOptionPane.showMessageDialog(null,"Rellene todos los campos para crear el pedido");
				}else {
					try {
						int ID_Proveedor= Integer.parseInt(dbconn.SelectListaCondicion("DNI_Usuario", "Usuario", "where Nombre='"+proveedores.getSelectedItem().toString()+"'").get(0));
						double Precio = Double.parseDouble(dbconn.SelectListaCondicion("Precio", "Stock", "where Nombre='"+material.getSelectedItem().toString()+"' AND ID_Proveedor = "+ID_Proveedor).get(0));
						double precio_total = Precio*Double.parseDouble(unidades_material.getText());
				        LocalDate fechaDeInscripcion = LocalDate.now();
				       String valores=0+ ","+unidades_material.getText()+","+precio_total+","+fechaDeInscripcion+","+proveedores.getSelectedItem().toString();
				        dbconn.insertar("pedidos", valores);
				        JOptionPane.showMessageDialog(null, "Pedido creado con éxito");
				        } catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				
			}
		});
		
		btndntstcrearpedido.setBorder(null);
		btndntstcrearpedido.setRadius(30);
		btndntstcrearpedido.setText("<html><p align='center'>Crear<br>pedido</html>");
		btndntstcrearpedido.setBounds(554, 225, 100, 35);
		add(btndntstcrearpedido);
		proveedores = new Despegable_editable_theme(20);
		proveedores.setBounds(411, 55, 205, 30);
		add(proveedores);
		proveedores.addItem("...");
		
		material = new Despegable_editable_theme(20);
		material.setBounds(103, 55, 205, 30);
		add(material);
		material.addItem("...");
		
		
		material.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					for(String nombre:dbconn.SelectListaCondicion("Nombre", "usuario","where Perfil = 'proveedor' and DNI_Usuario=(SELECT ID_Proveedor from dentiapp.stock where nombre='"+material.getSelectedItem().toString()+"')")) {
						proveedores.addItem(nombre);
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		});
		
		try {
			for(String nombre:dbconn.SelectListaCondicion("Nombre", "Stock","Where Estado>0")) {
				material.addItem(nombre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}
}
