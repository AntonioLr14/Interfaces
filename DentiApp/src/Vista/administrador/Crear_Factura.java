package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JButton;

public class Crear_Factura extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Crear_Factura() {
		setLayout(null);
		setBounds(100, 100, 612, 325);
		JLabel lblNewLabel = new JLabel("DNI / Nombre completo");
		lblNewLabel.setBounds(54, 70, 120, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo de pago");
		lblNewLabel_1.setBounds(383, 70, 85, 13);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tratamiento");
		lblNewLabel_2.setBounds(242, 70, 84, 13);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("M");
		lblNewLabel_3.setBounds(489, 70, 45, 13);
		add(lblNewLabel_3);
		
		Choice choice = new Choice();
		choice.setBounds(54, 89, 120, 18);
		add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(348, 89, 120, 18);
		add(choice_1);
		
		Choice choice_2 = new Choice();
		choice_2.setBounds(206, 89, 120, 18);
		add(choice_2);
		
		Choice choice_3 = new Choice();
		choice_3.setBounds(489, 89, 38, 18);
		add(choice_3);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(276, 213, 85, 21);
		add(btnNewButton);

	}

}
