package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Button;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import botonDentista.BotonDentista;
import prueba.Campo_texto_theme;

public class Solicitar_Material_M extends JPanel {

	private static final long serialVersionUID = 1L;
	Campo_texto_theme tfCantidad;

	/**
	 * Create the panel.
	 */
	public Solicitar_Material_M() {
		setBounds(100, 100, 720, 500);
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		
		tfCantidad = new Campo_texto_theme(20);
		tfCantidad.setBounds(428, 78, 118, 25);
		add(tfCantidad);
		
		JLabel lblMaterial = new JLabel("Material");
		lblMaterial.setBounds(229, 59, 70, 13);
		add(lblMaterial);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(466, 59, 80, 13);
		add(lblCantidad);
		
		Choice choiceMaterial = new Choice();
		choiceMaterial.setBounds(191, 78, 124, 29);
		add(choiceMaterial);
		
		BotonDentista btndntstSolicitar = new BotonDentista();
		btndntstSolicitar.setBorder(null);
		btndntstSolicitar.setText("Solicitar");
		btndntstSolicitar.setRadius(30);
		btndntstSolicitar.setBounds(297, 147, 160, 30);
		add(btndntstSolicitar);
		
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoabajo.png")));
		lblFondo.setBounds(0, -81, 728, 527);
		add(lblFondo);


	}
}
