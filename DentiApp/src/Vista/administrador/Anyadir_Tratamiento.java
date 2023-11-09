package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Anyadir_Tratamiento extends JPanel {

	// Atributos
	protected JTextField nombre_tratamiento;
	protected JTextField precio_tratamiento;
	protected JComboBox<String> especialidad;

	// Constructores
	public Anyadir_Tratamiento() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(230, 247, 255));
		setLayout(null);
		
		// Creacion de los elementos graficos
		this.nombre_tratamiento = new JTextField();
		this.precio_tratamiento = new JTextField();
		this.especialidad = new JComboBox<String>();
		
		this.nombre_tratamiento.setBounds(257, 55, 205, 30);
		this.precio_tratamiento.setBounds(26, 55, 205, 30);
		this.especialidad.setBounds(488,55,205,30);
		this.especialidad.setBackground(new Color(255, 255, 255));

		JLabel etiqueta_nombre_tratamiento = new JLabel("Tratamiento:");
		etiqueta_nombre_tratamiento.setBounds(257, 40, 92, 14);
		
		JLabel etiqueta_precio_tratamiento = new JLabel("Precio:");
		etiqueta_precio_tratamiento.setBounds(26, 40, 49, 14);
		
		JLabel etiqueta_especialidad = new JLabel("Especialidad:");
		etiqueta_especialidad.setBounds(488, 40, 94, 14);
		
		add(this.nombre_tratamiento);
		add(this.precio_tratamiento);
		add(this.especialidad);
		add(etiqueta_nombre_tratamiento);
		add(etiqueta_precio_tratamiento);
		add(etiqueta_especialidad);
		
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
	}
}
