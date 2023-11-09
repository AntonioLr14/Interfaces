package Vista.administrador;

import javax.swing.JPanel;

import Vista.Login_Inicio;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;

public class Crear_Factura extends JPanel {

	// Atributos
	protected JComboBox<String> dni_nombre_usuario;
	protected JComboBox<String> tratamiento;
	protected JComboBox<String> tipo_pago;
	protected JComboBox<String> numero_meses;
	
	// Constructores
	public Crear_Factura() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(255,255, 255));
		setLayout(null);
		
		// Creacion de los elementos graficos
		this.dni_nombre_usuario = new JComboBox<String>();
		this.tratamiento = new JComboBox<String>();
		this.tipo_pago = new JComboBox<String>();
		this.numero_meses = new JComboBox<String>();
		
		this.dni_nombre_usuario.setBounds(10,35,205,30);
		this.dni_nombre_usuario.setBackground(new Color(255, 255, 255));
		this.tratamiento.setBounds(226,35,205,30);
		this.tratamiento.setBackground(new Color(255, 255, 255));
		this.tipo_pago.setBounds(442,35,205,30);
		this.tipo_pago.setBackground(new Color(255, 255, 255));
		this.numero_meses.setBounds(658,35,50,30);
		this.numero_meses.setBackground(new Color(255, 255, 255));

		JLabel etiqueta_dni_nombre_usuario = new JLabel("DNI:");
		etiqueta_dni_nombre_usuario.setBounds(10, 20, 165, 13);
		
		JLabel etiqueta_tratamiento = new JLabel("Tratamiento:");
		etiqueta_tratamiento.setBounds(226, 20, 92, 13);

		JLabel etiqueta_tipo_pago = new JLabel("Tipo de pago:");
		etiqueta_tipo_pago.setBounds(442, 20, 97, 13);
		
		JLabel etiqueta_numero_meses = new JLabel("M");
		etiqueta_numero_meses.setBounds(671, 20, 12, 13);

		add(this.dni_nombre_usuario);
		add(this.tratamiento);
		add(this.tipo_pago);
		add(this.numero_meses);
		add(etiqueta_dni_nombre_usuario);
		add(etiqueta_tratamiento);
		add(etiqueta_tipo_pago);
		add(etiqueta_numero_meses);
		
		BotonDentista btndntstAceptar = new BotonDentista();
		btndntstAceptar.setBorder(null);
		btndntstAceptar.setRadius(30);
		btndntstAceptar.setText("Aceptar");
		btndntstAceptar.setBounds(279, 110, 160, 30);
		add(btndntstAceptar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoadminabajo.png")));
		lblFondo.setBounds(0, 0, 728, 218);
		add(lblFondo);
	}
}
