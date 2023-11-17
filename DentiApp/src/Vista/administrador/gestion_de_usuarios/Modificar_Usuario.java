package Vista.administrador.gestion_de_usuarios;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;

public class Modificar_Usuario extends JPanel {
	private Campo_texto_theme dni_nombre_usuario;
	private Campo_texto_theme textField_1;
	private Despegable_editable_theme despegable_editable_theme;

	// Constructores
	public Modificar_Usuario() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);

		JLabel etiqueta_dni_usuario = new JLabel("DNI:");
		etiqueta_dni_usuario.setBounds(103, 40, 165, 14);
		
		JLabel etiqueta_operacion_usuario = new JLabel("Operación:");
		etiqueta_operacion_usuario.setBounds(411, 40, 78, 14);
		
		textField_1 = new Campo_texto_theme(20);
		textField_1.setBounds(257, 135, 205, 30);
		
		dni_nombre_usuario = new Campo_texto_theme(20);
		dni_nombre_usuario.setBounds(103, 55, 205, 30);
		add(etiqueta_dni_usuario);
		add(etiqueta_operacion_usuario);
		add(textField_1);
		add(dni_nombre_usuario);

		BotonDentista btndntstAceptar = new BotonDentista();
		
		btndntstAceptar.setText("Aceptar");
		btndntstAceptar.setRadius(30);
		btndntstAceptar.setBorder(null);
		btndntstAceptar.setBounds(280, 220, 160, 30);
		add(btndntstAceptar);
		
		despegable_editable_theme = new Despegable_editable_theme(20);
		despegable_editable_theme.setBounds(411, 55, 205, 30);
		add(despegable_editable_theme);
	}
}
