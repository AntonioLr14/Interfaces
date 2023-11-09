package Vista.administrador;

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

public class Eliminar_Consulta extends JPanel {

	// Atributos
	protected JTextField dni_nombre_usuario;
	protected JComboBox<String> fecha;
	protected JTextArea eliminar_citas;
	
	// Constructores
	public Eliminar_Consulta() {
		
		setBounds(0, 0, 730, 325);
		setBackground(new Color(255,255,255));
		setLayout(null);
		
		// Creacion de los elementos graficos
		this.dni_nombre_usuario = new JTextField();
		this.fecha = new JComboBox<String>();
		this.eliminar_citas = new JTextArea();
		eliminar_citas.setBorder(new LineBorder(new Color(0, 0, 0)));

		this.dni_nombre_usuario.setBounds(100, 15, 205, 30);
		this.fecha.setBounds(372, 15, 205, 30);
		this.fecha.setBackground(new Color(255, 255, 255));
		this.eliminar_citas.setBounds(158, 56, 365, 130);

		JLabel etiqueta_dni_nombre_usuario = new JLabel("DNI / Nombre completo:");
		etiqueta_dni_nombre_usuario.setBounds(100, 0, 165, 13);
		
		JLabel etiqueta_fecha = new JLabel("Fecha:");
		etiqueta_fecha.setBounds(372, 0, 47, 13);

		add(this.dni_nombre_usuario);
		add(this.fecha);
		add(this.eliminar_citas);
		add(etiqueta_dni_nombre_usuario);
		add(etiqueta_fecha);
		
		BotonDentista btndntstEliminar = new BotonDentista();
		btndntstEliminar.setBorder(null);
		btndntstEliminar.setText("Eliminar");
		btndntstEliminar.setRadius(30);
		btndntstEliminar.setBounds(533, 150, 100, 35);
		add(btndntstEliminar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoadminabajo.png")));
		lblFondo.setBounds(0, 0, 728, 218);
		add(lblFondo);
	}
}
