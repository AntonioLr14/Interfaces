package prueba;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Rectangle;

public class Dentiapppanel extends JPanel {

	public Dentiapppanel() {
		
		setBounds(new Rectangle(0, 0, 700, 200));
		setLayout(null);
		
		JButton boton_aceptar = new JButton("Aceptar");
		boton_aceptar.setBounds(291, 87, 117, 25);
		boton_aceptar.setContentAreaFilled(false);
		
		boton_aceptar.addActionListener( (event) -> {
			System.exit(0);
		});
		
		add(boton_aceptar);
	}
}
