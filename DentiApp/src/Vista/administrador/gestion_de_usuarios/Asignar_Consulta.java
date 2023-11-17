package Vista.administrador.gestion_de_usuarios;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;

public class Asignar_Consulta extends JPanel {
	protected JTextArea citas_usuario;
	private Campo_texto_theme dni_nombre_usuario;
	private Despegable_editable_theme despegable_editable_theme;
	
	// Constructores
	public Asignar_Consulta() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);

		// Creacion de los elementos graficos
		
		JLabel etiqueta_dni_nombre_usuario = new JLabel("DNI / Nombre completo:");
		etiqueta_dni_nombre_usuario.setBounds(100, 0, 165, 13);
		
		dni_nombre_usuario = new Campo_texto_theme(20);
		dni_nombre_usuario.setBounds(100, 15, 205, 30);
		add(dni_nombre_usuario);

		JLabel etiqueta_especialidad = new JLabel("Especialidad:");
		etiqueta_especialidad.setBounds(372, 0, 94, 13);
		add(etiqueta_especialidad);
		add(etiqueta_dni_nombre_usuario);
		this.citas_usuario = new JTextArea();
		citas_usuario.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.citas_usuario.setBounds(145, 56, 365, 130);
		add(this.citas_usuario);
		
		BotonDentista btndntstAsignarCita = new BotonDentista();
		btndntstAsignarCita.setBorder(null);
		btndntstAsignarCita.setRadius(30);
		btndntstAsignarCita.setText("<html><p align='center'>Asignar<br>cita</html>");
		btndntstAsignarCita.setBounds(520, 127, 100, 35);
		add(btndntstAsignarCita);
		
		despegable_editable_theme = new Despegable_editable_theme(20);
		despegable_editable_theme.setBounds(372, 15, 205, 30);
		add(despegable_editable_theme);
	}
}
