package Vista.administrador.gestion_de_usuarios;

import javax.swing.JLabel;
import javax.swing.JPanel;
import botonDentista.BotonDentista;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;

public class Modificar_Usuario extends JPanel {
	
	// Constructores
	public Modificar_Usuario() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		
		// Creacion de los elementos graficos
		Campo_texto_theme valor_operacion = new Campo_texto_theme(20);
		valor_operacion.setBounds(257, 135, 205, 30);
		
		Campo_texto_theme dni_usuario = new Campo_texto_theme(20);
		dni_usuario.setBounds(103, 55, 205, 30);
		
		Despegable_editable_theme<String> operacion_usuario = new Despegable_editable_theme<String>(20);
		operacion_usuario.setBounds(411, 55, 205, 30);
		
		BotonDentista boton_aceptar = new BotonDentista();
		
		boton_aceptar.setBounds(280, 220, 160, 30);
		boton_aceptar.setBorder(null);
		boton_aceptar.setRadius(30);
		boton_aceptar.setText("Aceptar");
		boton_aceptar.setFocusable(false);
		
		JLabel etiqueta_dni_usuario = new JLabel();
		
		etiqueta_dni_usuario.setBounds(103, 40, 165, 14);
		etiqueta_dni_usuario.setText("DNI:");
		
		JLabel etiqueta_operacion_usuario = new JLabel();
		
		etiqueta_operacion_usuario.setBounds(411, 40, 78, 14);
		etiqueta_operacion_usuario.setText("Operación:");
		
		add(valor_operacion);
		add(dni_usuario);
		add(operacion_usuario);
		add(boton_aceptar);
		
		add(etiqueta_dni_usuario);
		add(etiqueta_operacion_usuario);
	}
}
