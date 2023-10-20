package Vista;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

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
		setBounds(100, 100, 612, 325);

	}

}
