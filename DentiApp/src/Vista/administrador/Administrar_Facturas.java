package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class Administrar_Facturas extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Administrar_Facturas() {
		setBounds(100, 100, 620, 328);
		setLayout(null);
		
		JButton btnNewButton = new JButton("Crear Factura");
		btnNewButton.setBounds(123, 44, 128, 21);
		add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(100, 72, 175, 10);
		add(separator);
		
		JButton btnNewButton_1 = new JButton("Consultar factura");
		btnNewButton_1.setBounds(375, 44, 126, 21);
		add(btnNewButton_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(352, 72, 175, 21);
		add(separator_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(100, 103, 427, 187);
		add(panel);

	}

}
