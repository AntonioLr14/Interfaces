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

public class Consultar_Stock_M extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Consultar_Stock_M() {
		setBounds(100, 100, 720, 500);
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		
		JLabel lblMaterial = new JLabel("Material");
		lblMaterial.setBounds(212, 67, 68, 13);
		add(lblMaterial);
		
		JLabel lblUnidadesStock = new JLabel("Unidades en stock");
		lblUnidadesStock.setBounds(281, 171, 109, 36);
		add(lblUnidadesStock);
		
		Choice choiceMaterial = new Choice();
		choiceMaterial.setBounds(174, 86, 120, 18);
		add(choiceMaterial);
		
		JTextPane tpUnidadesStock = new JTextPane();
		tpUnidadesStock.setBounds(400, 171, 52, 36);
		add(tpUnidadesStock);
		
		BotonDentista btndntstConsultar = new BotonDentista();
		btndntstConsultar.setText("Consultar");
		btndntstConsultar.setRadius(30);
		btndntstConsultar.setBorder(null);
		btndntstConsultar.setBounds(400, 76, 160, 30);
		add(btndntstConsultar);

		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoabajo.png")));
		lblFondo.setBounds(0, -81, 728, 527);
		add(lblFondo);

	}
}
