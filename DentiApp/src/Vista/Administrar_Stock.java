package Vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Administrar_Stock extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Administrar_Stock() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("Actualizar stock");
		btnNewButton.setBounds(71, 50, 129, 21);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Instertar material");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(245, 50, 129, 21);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Modificar material");
		btnNewButton_2.setBounds(432, 50, 129, 21);
		add(btnNewButton_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(36, 81, 171, 27);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(409, 81, 171, 21);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(224, 81, 171, 21);
		add(separator_2);

	}

}
