package Vista.administrador.gestion_de_usuarios;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Choice;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Rectangle;
import java.awt.Color;
import botonDentista.BotonDentista;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import prueba.Campo_texto_theme;
import prueba.Despegable_theme;
import prueba.Despegable_editable_theme;

public class Insertar_Usuario extends JPanel {
	protected JComboBox<String> perfil_usuario;
	private Campo_texto_theme apellidos_usuario;
	private Campo_texto_theme telefono_usuario;
	private Campo_texto_theme dni_usuario;
	private Campo_texto_theme nombre_usuario;

	// Constructores
	public Insertar_Usuario() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		this.perfil_usuario = new JComboBox<String>();
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
		
		 apellidos_usuario = new Campo_texto_theme(20);
		apellidos_usuario.setBounds(488, 55, 205, 30);
		
		
		 telefono_usuario = new Campo_texto_theme(20);
		telefono_usuario.setBounds(103, 135, 205, 30);
		
		 dni_usuario = new Campo_texto_theme(20);
		dni_usuario.setBounds(25, 55, 205, 30);
		
		 nombre_usuario = new Campo_texto_theme(20);
		nombre_usuario.setBounds(257, 55, 205, 30);
		add(this.perfil_usuario);
		add(etiqueta_dni_usuario);
		add(etiqueta_nombre_usuario);
		add(etiqueta_perfil_usuario);
		add(etiqueta_apellidos_usuario);
		add(etiqueta_telefono);
		add(apellidos_usuario);
		add(telefono_usuario);
		add(dni_usuario);
		add(nombre_usuario);
		
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
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoabajo.png")));
		lblFondo.setBounds(0, -72, 728, 527);
		add(lblFondo);		
	}
}
