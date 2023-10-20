package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Modificar_Especialidad extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Modificar_Especialidad() {
		setBounds(100, 100, 620, 328);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Doctor");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(104, 71, 119, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Especialidad");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(373, 71, 119, 13);
		add(lblNewLabel_1);
		
		Choice choice = new Choice();
		choice.setBounds(104, 103, 119, 18);
		add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(373, 103, 119, 18);
		add(choice_1);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(245, 212, 109, 33);
		add(btnNewButton);

	}
}
