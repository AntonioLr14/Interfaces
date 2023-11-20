package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Choice;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;

import Vista.Login_Inicio;
import botonDentista.BotonDentista;
import prueba.Despegable_editable_theme;

public class Consultar_Stock_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private Despegable_editable_theme material;

	/**
	 * Create the panel.
	 */
	public Consultar_Stock_M() {
		setOpaque(false);
		setBounds(100, 100, 720, 500);
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		
		material = new Despegable_editable_theme(20);
		material.setBounds(174, 84, 148, 30);
		add(material);
		
		JLabel lblMaterial = new JLabel("Material");
		lblMaterial.setBounds(212, 67, 68, 13);
		add(lblMaterial);
		
		JLabel lblUnidadesStock = new JLabel("Unidades en stock");
		lblUnidadesStock.setBounds(281, 171, 109, 36);
		add(lblUnidadesStock);
		
		JTextPane tpUnidadesStock = new JTextPane();
		tpUnidadesStock.setBounds(400, 171, 52, 36);
		add(tpUnidadesStock);
		
		BotonDentista btndntstConsultar = new BotonDentista();
		btndntstConsultar.setText("Consultar");
		btndntstConsultar.setRadius(30);
		btndntstConsultar.setBorder(null);
		btndntstConsultar.setBounds(400, 76, 160, 30);
		add(btndntstConsultar);

	}
}
