package Vista;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class Administrar_Consultas extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrar_Consultas frame = new Administrar_Consultas();
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
	public Administrar_Consultas() {
		setBounds(100, 100, 620, 328);
		setLayout(null);
		
		JButton btnNewButton = new JButton("Asignar consulta");
		btnNewButton.setBounds(67, 27, 113, 21);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Eliminar consulta");
		btnNewButton_1.setBounds(438, 27, 113, 21);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Consultar consulta");
		btnNewButton_2.setBounds(251, 27, 122, 21);
		add(btnNewButton_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(48, 58, 146, 10);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(239, 58, 146, 10);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(422, 58, 146, 2);
		add(separator_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(48, 101, 526, 193);
		add(panel);

	}
}
