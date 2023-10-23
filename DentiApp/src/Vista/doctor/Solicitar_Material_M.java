package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Button;
import javax.swing.JButton;

public class Solicitar_Material_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfCantidad;

	/**
	 * Create the panel.
	 */
	public Solicitar_Material_M() {
		setBounds(100, 100, 620, 328);
		setLayout(null);
		setBackground(new Color(230, 247, 255));
		
		JLabel lblMaterial = new JLabel("Material");
		lblMaterial.setBounds(153, 100, 70, 13);
		add(lblMaterial);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(390, 100, 80, 13);
		add(lblCantidad);
		
		tfCantidad = new JTextField();
		tfCantidad.setBounds(350, 119, 118, 25);
		add(tfCantidad);
		tfCantidad.setColumns(10);
		
		Choice choiceMaterial = new Choice();
		choiceMaterial.setBounds(115, 119, 124, 29);
		add(choiceMaterial);
		
		JButton btnSolicitar = new JButton("Solicitar");
		btnSolicitar.setContentAreaFilled(false);
		btnSolicitar.setBounds(236, 226, 121, 28);
		add(btnSolicitar);

	}
}
