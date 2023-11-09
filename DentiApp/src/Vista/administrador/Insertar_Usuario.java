package Vista.administrador;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Choice;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Rectangle;
import java.awt.Color;
import botonDentista.BotonDentista;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Insertar_Usuario extends JPanel {

	// Atributos
	protected JTextField dni_usuario;
	protected JTextField nombre_usuario;
	protected JTextField apellidos_usuario;
	protected JTextField telefono_usuario;
	protected JComboBox<String> perfil_usuario;

	// Constructores
	public Insertar_Usuario() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(230, 247, 255));
		setLayout(null);
		
		// Creacion de los elementos graficos
		this.dni_usuario = new JTextField();
		this.nombre_usuario = new JTextField();
		this.apellidos_usuario = new JTextField();
		this.telefono_usuario = new JTextField();
		this.perfil_usuario = new JComboBox<String>();
		
		this.dni_usuario.setBounds(26, 55, 205, 30);
		this.nombre_usuario.setBounds(257, 55, 205, 30);
		this.apellidos_usuario.setBounds(488, 55, 205, 30);
		this.telefono_usuario.setBounds(103, 135, 205, 30);
		this.perfil_usuario.setBounds(411, 135, 205, 30);
		this.perfil_usuario.setBackground(new Color(255, 255, 255));

		JLabel etiqueta_dni_usuario = new JLabel("DNI:");
		etiqueta_dni_usuario.setBounds(26, 40, 29, 14);
		
		JLabel etiqueta_nombre_usuario = new JLabel("Nombre:");
		etiqueta_nombre_usuario.setBounds(257, 40, 60, 14);
		
		JLabel etiqueta_apellidos_usuario = new JLabel("Apellidos:");
		etiqueta_apellidos_usuario.setBounds(488, 40, 70, 14);

		JLabel etiqueta_telefono = new JLabel("Telefono:");
		etiqueta_telefono.setBounds(103, 120, 67, 14);

		JLabel etiqueta_perfil_usuario = new JLabel("Perfil:");
		etiqueta_perfil_usuario.setBounds(411, 120, 42, 14);

		add(this.dni_usuario);
		add(this.nombre_usuario);
		add(this.apellidos_usuario);
		add(this.telefono_usuario);
		add(this.perfil_usuario);
		add(etiqueta_dni_usuario);
		add(etiqueta_nombre_usuario);
		add(etiqueta_perfil_usuario);
		add(etiqueta_apellidos_usuario);
		add(etiqueta_telefono);
		
		BotonDentista btndntstAceptar = new BotonDentista();
		btndntstAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btndntstAceptar.setText("Aceptar");
		btndntstAceptar.setRadius(30);
		btndntstAceptar.setBorder(null);
		btndntstAceptar.setBounds(280, 215, 160, 30);
		add(btndntstAceptar);
	}
}
