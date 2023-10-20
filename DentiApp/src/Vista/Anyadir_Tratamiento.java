package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Anyadir_Tratamiento extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;


	public Anyadir_Tratamiento() {
		setBounds(100, 100, 612, 325);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tratamiento");
		lblNewLabel.setBounds(121, 105, 67, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Precio");
		lblNewLabel_1.setBounds(303, 105, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Especialidad");
		lblNewLabel_2.setBounds(460, 105, 76, 14);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(255, 152, 131, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(88, 152, 131, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		Choice choice = new Choice();
		choice.setBounds(432, 152, 131, 20);
		add(choice);
		
		JButton btnNewButton = new JButton("Agregar Tratamiento");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(255, 269, 144, 23);
		add(btnNewButton);

	}
}
