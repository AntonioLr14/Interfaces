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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;

import com.mysql.cj.protocol.Resultset;

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
	private ResultSet resultset; 
	
	

	// Constructores
	public Crear_Pedidos() {

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
		btndntstcrearpedido.setBorder(null);
		btndntstcrearpedido.setRadius(30);
		btndntstcrearpedido.setText("<html><p align='center'>Crear<br>pedido</html>");
		btndntstcrearpedido.setBounds(554, 225, 100, 35);
		add(btndntstcrearpedido);
		btndntstcrearpedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(unidades_material.getText().isEmpty()||proveedores.getSelectedItem().toString().equals("...")||material.getSelectedItem().toString().equals("...")) {
					JOptionPane.showMessageDialog(null,"Rellene todos los campos para crear el pedido");
				}else {
						int ID_Proveedor=0;
						try {
							resultset = Login_Inicio.dbconn.consulta("SELECT Id_Proveedor from proveedores where empresa = '"+proveedores.getSelectedItem().toString()+"'");
							while(resultset.next()) {
								ID_Proveedor=resultset.getInt("Id_Proveedor");
							}
							int ID_Material =0;
							resultset = Login_Inicio.dbconn.consulta("SELECT Id_Material from materiales where nombre = '"+material.getSelectedItem().toString()+"'");
							while(resultset.next()) {
								ID_Material=resultset.getInt("Id_Material");
							}
						double Precio = 25;
						double precio_total = Precio*Double.parseDouble(unidades_material.getText());
				        LocalDate fechaDeInscripcion = LocalDate.now();
				       String valores=0+","+ID_Proveedor+ ","+ID_Material+","+unidades_material.getText()+","+precio_total+",'"+fechaDeInscripcion+"',"+null;
				        Login_Inicio.dbconn.insertUpdateDelete("INSERT INTO `dentiapp`.`pedidos` (`ID_pedido`, `ID_proveedor`, `ID_material`, `Cantidad`, `Precio_total`, `Fecha_inicio_pedido`, `Fecha_fin_pedido`) VALUES ("+valores+")");
				        JOptionPane.showMessageDialog(null, "Pedido creado con éxito");
				        } catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				

				
			}
			}
		
		});
		

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
					
					 resultset = Login_Inicio.dbconn.consulta("SELECT empresa FROM proveedores;");
					
					while (resultset.next()) {
						proveedores.addItem(resultset.getString("empresa"));
					}
				}
				catch (Exception error) {
					error.printStackTrace();
				}

			}
		});
		/*				try {
					
					for(String nombre:dbconn.SelectListaCondicion("Nombre", "usuario","where Perfil = 'proveedor' and DNI_Usuario=(SELECT ID_Proveedor from dentiapp.stock where nombre='"+material.getSelectedItem().toString()+"')")) {
						proveedores.addItem(nombre);
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}*/
		
		try {
			
			 resultset = Login_Inicio.dbconn.consulta("SELECT nombre FROM Materiales where estado>0;");
			
			while (resultset.next()) {
				this.material.addItem(resultset.getString("nombre"));
			}
		}
		catch (Exception error) {
			error.printStackTrace();
		}
		
		
		

	}
}

