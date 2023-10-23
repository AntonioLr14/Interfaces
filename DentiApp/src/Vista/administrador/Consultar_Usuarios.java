package Vista.administrador;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Consultar_Usuarios extends JPanel {

	// Atributos
	protected JTextField dni_nombre_usuario;
	protected JTextArea consultas_usuario;

	// Constructores
	public Consultar_Usuarios() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		
		// Creacion de los elementos graficos
		this.dni_nombre_usuario = new JTextField();
		this.consultas_usuario = new JTextArea();

		this.dni_nombre_usuario.setBounds(82, 55, 205, 30);
		this.consultas_usuario.setBounds(123, 130, 365, 130);

		JLabel etiqueta_dni_nombre_usuario = new JLabel("DNI / Nombre completo:");
		etiqueta_dni_nombre_usuario.setBounds(82, 40, 165, 14);
		
		JButton boton_consultar = new JButton("Consultar");
		
		boton_consultar.setBounds(369, 55, 160, 30);
		boton_consultar.setContentAreaFilled(false);

		JButton boton_generar_informe = new JButton("<html><p align='center'>Generar<br>Informes</html>");
		
		boton_generar_informe.setBounds(500, 225, 100, 35);
		boton_generar_informe.setContentAreaFilled(false);

		add(this.consultas_usuario);
		add(this.dni_nombre_usuario);
		add(etiqueta_dni_nombre_usuario);
		add(boton_consultar);
		add(boton_generar_informe);
	}
}
