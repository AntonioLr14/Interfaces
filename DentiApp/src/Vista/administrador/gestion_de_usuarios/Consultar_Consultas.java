package Vista.administrador.gestion_de_usuarios;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;

public class Consultar_Consultas extends JPanel {
	protected JTextArea consultas_usuario;
	private Campo_texto_theme dni_nombre_usuario;
	private Despegable_editable_theme despegable_editable_theme;

	// Constructores
	public Consultar_Consultas() {
		
		setBounds(0, 0, 730, 325);
		setLayout(null);
		setOpaque(false);
		this.consultas_usuario = new JTextArea();
		consultas_usuario.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.consultas_usuario.setBounds(152, 56, 365, 130);

		JLabel etiqueta_dni_nombre_usuario = new JLabel("DNI / Nombre completo:");
		etiqueta_dni_nombre_usuario.setBounds(100, 0, 165, 13);
		
		JLabel etiqueta_fecha = new JLabel("Fecha:");
		etiqueta_fecha.setBounds(372, 0, 47, 13);
		
		dni_nombre_usuario = new Campo_texto_theme(20);
		dni_nombre_usuario.setBounds(100, 15, 205, 30);
		add(this.consultas_usuario);
		add(etiqueta_dni_nombre_usuario);
		add(etiqueta_fecha);
		add(dni_nombre_usuario);

		
		BotonDentista btndntstConsultar = new BotonDentista();
		
		btndntstConsultar.setBorder(null);
		btndntstConsultar.setRadius(30);
		btndntstConsultar.setText("Consultar");
		btndntstConsultar.setBounds(528, 139, 107, 35);
		add(btndntstConsultar);
		
		despegable_editable_theme = new Despegable_editable_theme(20);
		despegable_editable_theme.setBounds(372, 15, 205, 30);
		add(despegable_editable_theme);
	}
}
