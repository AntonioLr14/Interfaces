package Vista.administrador.gestion_de_material;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controlador.BBDD;
import Vista.Login_Inicio;

import java.awt.Color;
import java.sql.ResultSet;
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
import java.awt.Font;
import javax.swing.SwingConstants;

public class Modificar_Stock extends JPanel {
	private Campo_texto_theme stock;
	private Despegable_editable_theme material;
	private Despegable_editable_theme estado;
	private ResultSet resultset;
	
	// Constructores
	public Modificar_Stock() {

		
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
		stock.setHorizontalAlignment(SwingConstants.CENTER);
		stock.setFont(new Font("Tahoma", Font.BOLD, 18));
		stock.setBounds(625, 35, 35, 30);
		add(etiqueta_material);
		add(etiqueta_estado);
		add(etiqueta_stock);
		add(stock);

		BotonDentista btndntstAceptar = new BotonDentista();
		btndntstAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(estado.getSelectedItem().toString().equals("Alta")) {
					try {
						Login_Inicio.dbconn.insertUpdateDelete("UPDATE materiales set estado =1 where nombre ='"+material.getSelectedItem().toString()+"'" );
						JOptionPane.showMessageDialog(null,material.getSelectedItem().toString()+" dado de alta. ");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(estado.getSelectedItem().toString().equals("Baja")) {
					try {
						Login_Inicio.dbconn.insertUpdateDelete("UPDATE materiales set estado =0 where nombre ='"+material.getSelectedItem().toString()+"'" );
						JOptionPane.showMessageDialog(null,material.getSelectedItem().toString()+" dado de baja. ");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(estado.getSelectedItem().toString().equals("...")||material.getSelectedItem().toString().equals("...")) {
					JOptionPane.showMessageDialog(null,"Rellene todos los campos");
				}
				else {
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
			
			 resultset = Login_Inicio.dbconn.consulta("SELECT nombre FROM Materiales;");
			
			while (resultset.next()) {
				this.material.addItem(resultset.getString("nombre"));
			}
		}
		catch (Exception error) {
			error.printStackTrace();
		}
		material.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					resultset = Login_Inicio.dbconn.consulta("SELECT cantidad from materiales where Nombre = '"+material.getSelectedItem().toString()+"'");
					int total=0;
					while(resultset.next()) {
						total += resultset.getInt("cantidad");
					}


					stock.setText(String.valueOf(total));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});


		
		estado = new Despegable_editable_theme(20);
		estado.setBounds(408, 35, 205, 30);
		add(estado);
		estado.addItem("...");
		estado.addItem("Alta");
		estado.addItem("Baja");
		

	}
}
