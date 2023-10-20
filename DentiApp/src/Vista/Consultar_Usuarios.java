package Vista;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Consultar_Usuarios extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consultar_Usuarios frame = new Consultar_Usuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Consultar_Usuarios() {
		setBounds(100, 100, 612, 325);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DNI / Nombre Completo");
		lblNewLabel.setBounds(65, 40, 139, 14);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setBounds(453, 36, 89, 23);
		add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(56, 93, 365, 130);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Generar Informe");
		btnNewButton_1.setBounds(439, 200, 113, 23);
		add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(258, 37, 163, 20);
		add(textField_1);
		textField_1.setColumns(10);

	}

}
