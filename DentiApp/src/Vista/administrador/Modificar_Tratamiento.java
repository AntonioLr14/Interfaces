package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;
import prueba.Campo_texto_theme;

public class Modificar_Tratamiento extends JPanel {

	// Atributos
	protected JComboBox<String> tratamiento;
	protected JComboBox<String> operacion;
	private Campo_texto_theme modificacion_tratamiento;

	// Constructores
	public Modificar_Tratamiento() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(255,255, 255));
		setLayout(null);
		
		// Creacion de los elementos graficos
		this.tratamiento = new JComboBox<String>();
		this.operacion = new JComboBox<String>();

		this.tratamiento.setBounds(411,55,205,30);
		this.tratamiento.setBackground(new Color(255, 255, 255));
		this.operacion.setBounds(103,55,205,30);
		this.operacion.setBackground(new Color(255, 255, 255));

		JLabel etiqueta_tratamiento = new JLabel("Tratamiento:");
		etiqueta_tratamiento.setBounds(411, 40, 92, 13);
		
		JLabel etiqueta_operacion = new JLabel("Operación:");
		etiqueta_operacion.setBounds(103, 40, 78, 13);
		
		modificacion_tratamiento = new Campo_texto_theme(20);
		modificacion_tratamiento.setBounds(257, 125, 205, 30);

		add(this.tratamiento);
		add(this.operacion);
		add(etiqueta_tratamiento);
		add(etiqueta_operacion);
		add(modificacion_tratamiento);
		
		BotonDentista btndntstAceptar = new BotonDentista();
		btndntstAceptar.setText("Aceptar");
		btndntstAceptar.setRadius(30);
		btndntstAceptar.setBorder(null);
		btndntstAceptar.setBounds(280, 205, 160, 30);
		add(btndntstAceptar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoabajo.png")));
		lblFondo.setBounds(0, -72, 728, 527);
		add(lblFondo);
	}
}
