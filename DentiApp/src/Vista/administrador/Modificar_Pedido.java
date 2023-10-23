package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JButton;

public class Modificar_Pedido extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Modificar_Pedido() {
		setBounds(100, 100, 620, 328);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Proveedor");
		lblNewLabel.setBounds(160, 84, 67, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha");
		lblNewLabel_1.setBounds(410, 84, 45, 13);
		add(lblNewLabel_1);
		
		Choice choice = new Choice();
		choice.setBounds(131, 124, 120, 18);
		add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(372, 124, 120, 18);
		add(choice_1);
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.setBounds(252, 249, 120, 21);
		add(btnNewButton);

	}

}
