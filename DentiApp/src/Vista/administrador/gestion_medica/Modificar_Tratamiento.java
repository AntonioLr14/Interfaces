package Vista.administrador.gestion_medica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;

public class Modificar_Tratamiento extends JPanel {
	private Campo_texto_theme modificacion_tratamiento;
	private Despegable_editable_theme operacion;
	private Despegable_editable_theme tratamiento;

	// Constructores
	public Modificar_Tratamiento() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);

		JLabel etiqueta_tratamiento = new JLabel("Tratamiento:");
		etiqueta_tratamiento.setBounds(411, 40, 92, 13);
		
		JLabel etiqueta_operacion = new JLabel("Operación:");
		etiqueta_operacion.setBounds(103, 40, 78, 13);
		
		modificacion_tratamiento = new Campo_texto_theme(20);
		modificacion_tratamiento.setBounds(257, 125, 205, 30);
		add(etiqueta_tratamiento);
		add(etiqueta_operacion);
		add(modificacion_tratamiento);
		
		BotonDentista btndntstAceptar = new BotonDentista();
		btndntstAceptar.setText("Aceptar");
		btndntstAceptar.setRadius(30);
		btndntstAceptar.setBorder(null);
		btndntstAceptar.setBounds(280, 205, 160, 30);
		add(btndntstAceptar);
		
		operacion = new Despegable_editable_theme(20);
		operacion.setBounds(103, 55, 205, 30);
		add(operacion);
		
		tratamiento = new Despegable_editable_theme(20);
		tratamiento.setBounds(411, 55, 205, 30);
		add(tratamiento);
	}
}
