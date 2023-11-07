package a;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Prueba extends JFrame {

	protected JPanel contentPane;

	public Prueba() {
		
		this.contentPane = new JPanel();

		setContentPane(this.contentPane);
		
		setMinimumSize(new Dimension(500,500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
	}
	
	public static void main(String[] args) {
		Prueba a = new Prueba();
		a.setVisible(true);
	}
}
