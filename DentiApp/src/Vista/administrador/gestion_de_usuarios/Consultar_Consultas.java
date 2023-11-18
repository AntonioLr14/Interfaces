package Vista.administrador.gestion_de_usuarios;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;

public class Consultar_Consultas extends JPanel {

	// Constructores
	public Consultar_Consultas() {
		
		setBounds(0, 0, 730, 325);
		setLayout(null);
		setOpaque(false);
		
		// Creacion de los elementos graficos
		JTextArea consultas_usuario = new JTextArea();
		
		consultas_usuario.setBounds(182, 56, 365, 130);
		consultas_usuario.setBorder(new LineBorder(Color.black));
		
		Campo_texto_theme dni_nombre_usuario = new Campo_texto_theme(20);
		dni_nombre_usuario.setBounds(106, 15, 205, 30);
		
		Despegable_editable_theme<String> fecha = new Despegable_editable_theme<String>(20);
		fecha.setBounds(417, 15, 205, 30);
		
		BotonDentista boton_consultar = new BotonDentista();
		
		boton_consultar.setBounds(559, 151, 107, 35);
		boton_consultar.setBorder(null);
		boton_consultar.setRadius(30);
		boton_consultar.setText("Consultar");
		boton_consultar.setFocusable(false);
				
		JLabel etiqueta_dni_nombre_usuario = new JLabel();
		
		etiqueta_dni_nombre_usuario.setBounds(106, 0, 165, 13);
		etiqueta_dni_nombre_usuario.setText("DNI / Nombre completo:");
		
		JLabel etiqueta_fecha = new JLabel();
		
		etiqueta_fecha.setBounds(417, 0, 47, 13);
		etiqueta_fecha.setText("Fecha:");
		
		add(consultas_usuario);
		add(dni_nombre_usuario);
		add(fecha);
		add(boton_consultar);

		add(etiqueta_dni_nombre_usuario);
		add(etiqueta_fecha);
	}
}
