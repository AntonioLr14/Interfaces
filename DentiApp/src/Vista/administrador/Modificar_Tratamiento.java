package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;

public class Modificar_Tratamiento extends JPanel {

	// Atributos
	protected JComboBox<String> tratamiento;
	protected JComboBox<String> operacion;
	protected JTextField modificacion_tratamiento;

	// Constructores
	public Modificar_Tratamiento() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(230, 247, 255));
		setLayout(null);
		
		// Creacion de los elementos graficos
		this.tratamiento = new JComboBox<String>();
		this.operacion = new JComboBox<String>();
		this.modificacion_tratamiento = new JTextField();

		this.tratamiento.setBounds(411,55,205,30);
		this.tratamiento.setBackground(new Color(255, 255, 255));
		this.operacion.setBounds(103,55,205,30);
		this.operacion.setBackground(new Color(255, 255, 255));
		this.modificacion_tratamiento.setBounds(257, 125, 205, 30);

		JLabel etiqueta_tratamiento = new JLabel("Tratamiento:");
		etiqueta_tratamiento.setBounds(411, 40, 92, 13);
		
		JLabel etiqueta_operacion = new JLabel("Operación:");
		etiqueta_operacion.setBounds(103, 40, 78, 13);

		add(this.tratamiento);
		add(this.operacion);
		add(this.modificacion_tratamiento);
		add(etiqueta_tratamiento);
		add(etiqueta_operacion);
		
		BotonDentista btndntstAceptar = new BotonDentista();
		btndntstAceptar.setText("Aceptar");
		btndntstAceptar.setRadius(30);
		btndntstAceptar.setBorder(null);
		btndntstAceptar.setBounds(280, 205, 160, 30);
		add(btndntstAceptar);
	}
}
