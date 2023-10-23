package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Choice;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextPane;

public class Consultar_Stock_M extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Consultar_Stock_M() {
		setBounds(100, 100, 620, 328);
		setLayout(null);
		setBackground(new Color(230, 247, 255));
		
		JLabel lblMaterial = new JLabel("Material");
		lblMaterial.setBounds(129, 87, 68, 13);
		add(lblMaterial);
		
		JLabel lblUnidadesStock = new JLabel("Unidades en stock");
		lblUnidadesStock.setBounds(198, 191, 109, 36);
		add(lblUnidadesStock);
		
		Choice choiceMaterial = new Choice();
		choiceMaterial.setBounds(91, 106, 120, 18);
		add(choiceMaterial);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setContentAreaFilled(false);
		btnConsultar.setBounds(349, 105, 105, 35);
		add(btnConsultar);
		
		JTextPane tpUnidadesStock = new JTextPane();
		tpUnidadesStock.setBounds(317, 191, 52, 36);
		add(tpUnidadesStock);

	}

}
