package Vista.administrador;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;

public class Modificar_Usuario extends JPanel {

	// Atributos
	protected JTextField dni_nombre_usuario;
	protected JTextField textField_1;
	protected JComboBox<String> operacion_usuario;

	// Constructores
	public Modificar_Usuario() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(255,255, 255));
		setLayout(null);
		
		// Creacion de los elementos graficos
		this.dni_nombre_usuario = new JTextField();
		this.operacion_usuario = new JComboBox<String>();
		this.textField_1 = new JTextField();

		this.dni_nombre_usuario.setBounds(103, 55, 205, 30);
		this.operacion_usuario.setBounds(411, 55, 205, 30);
		this.operacion_usuario.setBackground(new Color(255, 255, 255));
		this.textField_1.setBounds(257, 135, 205, 30);

		JLabel etiqueta_dni_usuario = new JLabel("DNI:");
		etiqueta_dni_usuario.setBounds(103, 40, 165, 14);
		
		JLabel etiqueta_operacion_usuario = new JLabel("Operación:");
		etiqueta_operacion_usuario.setBounds(411, 40, 78, 14);
		
		add(this.dni_nombre_usuario);
		add(this.operacion_usuario);
		add(this.textField_1);
		add(etiqueta_dni_usuario);
		add(etiqueta_operacion_usuario);
		
		BotonDentista btndntstAceptar = new BotonDentista();
		btndntstAceptar.setText("Aceptar");
		btndntstAceptar.setRadius(30);
		btndntstAceptar.setBorder(null);
		btndntstAceptar.setBounds(280, 220, 160, 30);
		add(btndntstAceptar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoabajo.png")));
		lblFondo.setBounds(0, -72, 728, 527);
		add(lblFondo);
	}
}
