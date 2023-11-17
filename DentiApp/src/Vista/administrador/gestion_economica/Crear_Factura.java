package Vista.administrador.gestion_economica;

import javax.swing.JPanel;

import Vista.Login_Inicio;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;
import prueba.Despegable_editable_theme;

public class Crear_Factura extends JPanel {
	private Despegable_editable_theme dni_nombre_usuario;
	private Despegable_editable_theme tratamiento;
	private Despegable_editable_theme despegable_editable_theme;
	private Despegable_editable_theme numero_meses;
	
	// Constructores
	public Crear_Factura() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);

		JLabel etiqueta_dni_nombre_usuario = new JLabel("DNI:");
		etiqueta_dni_nombre_usuario.setBounds(10, 20, 165, 13);
		
		JLabel etiqueta_tratamiento = new JLabel("Tratamiento:");
		etiqueta_tratamiento.setBounds(226, 20, 92, 13);

		JLabel etiqueta_tipo_pago = new JLabel("Tipo de pago:");
		etiqueta_tipo_pago.setBounds(442, 20, 97, 13);
		
		JLabel etiqueta_numero_meses = new JLabel("M");
		etiqueta_numero_meses.setBounds(671, 20, 12, 13);
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
		
		dni_nombre_usuario = new Despegable_editable_theme(20);
		dni_nombre_usuario.setBounds(10, 35, 205, 30);
		add(dni_nombre_usuario);
		
		tratamiento = new Despegable_editable_theme(20);
		tratamiento.setBounds(226, 35, 205, 30);
		add(tratamiento);
		
		despegable_editable_theme = new Despegable_editable_theme(20);
		despegable_editable_theme.setBounds(442, 35, 205, 30);
		add(despegable_editable_theme);
		
		numero_meses = new Despegable_editable_theme(20);
		numero_meses.setBounds(658, 35, 50, 30);
		add(numero_meses);
	}
}
