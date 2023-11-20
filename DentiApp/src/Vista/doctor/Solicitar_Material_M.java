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
import prueba.Despegable_editable_theme;

public class Solicitar_Material_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private Campo_texto_theme tfCantidad;
	private Despegable_editable_theme despegable_editable_theme;

	/**
	 * Create the panel.
	 */
	public Solicitar_Material_M() {
		setOpaque(false);
		setBounds(100, 100, 720, 500);
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		
		despegable_editable_theme = new Despegable_editable_theme(20);
		despegable_editable_theme.setBounds(191, 78, 128, 30);
		add(despegable_editable_theme);
		
		tfCantidad = new Campo_texto_theme(20);
		tfCantidad.setBounds(428, 78, 138, 30);
		add(tfCantidad);
		
		JLabel lblMaterial = new JLabel("Material");
		lblMaterial.setBounds(229, 59, 70, 13);
		add(lblMaterial);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(466, 59, 80, 13);
		add(lblCantidad);
		
		BotonDentista btndntstSolicitar = new BotonDentista();
		btndntstSolicitar.setBorder(null);
		btndntstSolicitar.setText("Solicitar");
		btndntstSolicitar.setRadius(30);
		btndntstSolicitar.setBounds(297, 147, 160, 30);
		add(btndntstSolicitar);


	}
}
