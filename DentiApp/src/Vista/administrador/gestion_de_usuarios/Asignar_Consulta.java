package Vista.administrador.gestion_de_usuarios;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;

public class Asignar_Consulta extends JPanel {
	
	// Constructores
	public Asignar_Consulta() {
		
		setBounds(0, 0, 730, 325);
		setLayout(null);
		setOpaque(false);

		// Creacion de los elementos graficos
		Campo_texto_theme dni_nombre_usuario = new Campo_texto_theme(20);
		dni_nombre_usuario.setBounds(106, 15, 205, 30);
		
		JTextArea citas_usuario = new JTextArea();
		
		citas_usuario.setBounds(182, 56, 365, 130);
		citas_usuario.setBorder(new LineBorder(Color.black));
		
		Despegable_editable_theme<String> especialidad = new Despegable_editable_theme<String>(20);
		especialidad.setBounds(417, 15, 205, 30);
		
		BotonDentista boton_asignar_cita = new BotonDentista();
		
		boton_asignar_cita.setBounds(559, 151, 100, 35);
		boton_asignar_cita.setBorder(null);
		boton_asignar_cita.setRadius(30);
		boton_asignar_cita.setText("<html><p align='center'>Asignar<br>cita</html>");
		boton_asignar_cita.setFocusable(false);
		
		JLabel etiqueta_dni_nombre_usuario = new JLabel();
		
		etiqueta_dni_nombre_usuario.setBounds(106, 0, 165, 13);
		etiqueta_dni_nombre_usuario.setText("DNI / Nombre completo:");
		
		JLabel etiqueta_especialidad = new JLabel();
		
		etiqueta_especialidad.setBounds(417, 0, 94, 13);
		etiqueta_especialidad.setText("Especialidad:");
		
		add(dni_nombre_usuario);
		add(citas_usuario);
		add(especialidad);
		add(boton_asignar_cita);

		add(etiqueta_especialidad);
		add(etiqueta_dni_nombre_usuario);
	}
}
