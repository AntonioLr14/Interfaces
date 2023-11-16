package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import prueba.Campo_texto_theme;

public class Anyadir_Tratamiento extends JPanel {
	protected JComboBox<String> especialidad;
	private Campo_texto_theme nombre_tratamiento;
	private Campo_texto_theme precio_tratamiento;

	// Constructores
	public Anyadir_Tratamiento() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color( 255 , 255 , 255));
		setLayout(null);
		this.especialidad = new JComboBox<String>();
		this.especialidad.setBounds(488,55,205,30);
		this.especialidad.setBackground(new Color(255, 255, 255));

		JLabel etiqueta_nombre_tratamiento = new JLabel("Tratamiento:");
		etiqueta_nombre_tratamiento.setBounds(257, 40, 92, 14);
		
		JLabel etiqueta_precio_tratamiento = new JLabel("Precio:");
		etiqueta_precio_tratamiento.setBounds(26, 40, 49, 14);
		
		JLabel etiqueta_especialidad = new JLabel("Especialidad:");
		etiqueta_especialidad.setBounds(488, 40, 94, 14);
		
		nombre_tratamiento = new Campo_texto_theme(20);
		nombre_tratamiento.setBounds(257, 55, 205, 30);
		
		precio_tratamiento = new Campo_texto_theme(20);
		precio_tratamiento.setBounds(26, 55, 205, 30);
		add(this.especialidad);
		add(etiqueta_nombre_tratamiento);
		add(etiqueta_precio_tratamiento);
		add(etiqueta_especialidad);
		add(nombre_tratamiento);
		add(precio_tratamiento);

		
		BotonDentista btndntstAgregarTratamiento = new BotonDentista();
		btndntstAgregarTratamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btndntstAgregarTratamiento.setBorder(null);
		btndntstAgregarTratamiento.setRadius(30);
		btndntstAgregarTratamiento.setText("Agregar tratamiento");
		btndntstAgregarTratamiento.setBounds(270, 135, 180, 30);
		add(btndntstAgregarTratamiento);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoabajo.png")));
		lblFondo.setBounds(0, -72, 728, 527);
		add(lblFondo);
	}
}
