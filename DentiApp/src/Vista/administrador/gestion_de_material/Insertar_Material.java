package Vista.administrador.gestion_de_material;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controlador.BBDD;
import Vista.Login_Inicio;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import botonDentista.BotonDentista;
import prueba.Campo_texto_theme;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Insertar_Material extends JPanel {
	
	private Campo_texto_theme nombre_material;
	private Campo_texto_theme cantidad_total;
	private ResultSet resulset;
	// Constructores
	public Insertar_Material() {

		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);

		JLabel etiqueta_nombre_material = new JLabel("Nuevo material:");
		etiqueta_nombre_material.setBounds(100, 20, 112, 13);
		
		JLabel etiqueta_cantidad_total = new JLabel("Cantidad total:");
		etiqueta_cantidad_total.setBounds(408, 20, 107, 13);
		
		cantidad_total = new Campo_texto_theme(20);
		cantidad_total.setBounds(408, 35, 205, 30);
		
		nombre_material = new Campo_texto_theme(20);
		nombre_material.setBounds(103, 35, 205, 30);
		add(etiqueta_nombre_material);
		add(etiqueta_cantidad_total);
		add(cantidad_total);
		add(nombre_material);

		BotonDentista btndntstAgregarMaterial = new BotonDentista();
		btndntstAgregarMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nombre_material.getText().isEmpty()||cantidad_total.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Rellene todos los campos");
				}else {
					String valores = 0+",'"+nombre_material.getText()+"', "+Integer.parseInt(cantidad_total.getText())+", "+1;
					try {
						Login_Inicio.dbconn.insertUpdateDelete("INSERT INTO `dentiapp`.`materiales` (`ID_material`, `Nombre`, `Cantidad`, `Estado`) VALUES ("+valores+");");
						JOptionPane.showMessageDialog(null,"Material insertado");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}

			}
		});
		
		btndntstAgregarMaterial.setBorder(null);
		btndntstAgregarMaterial.setRadius(30);
		btndntstAgregarMaterial.setText("Agregar material");
		btndntstAgregarMaterial.setBounds(277, 110, 160, 30);
		add(btndntstAgregarMaterial);
	}
}
