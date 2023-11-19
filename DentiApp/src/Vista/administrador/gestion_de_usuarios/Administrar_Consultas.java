package Vista.administrador.gestion_de_usuarios;

import javax.swing.JPanel;
import botonDentista.BotonDentista;

public class Administrar_Consultas extends JPanel {

	// Atributos
	protected JPanel panel;
	
	// Constructores
	public Administrar_Consultas() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		
		// Creacion de los elementos graficos
		this.panel = new JPanel();
		
		this.panel.setBounds(0, 139, 720, 208);
		this.panel.setOpaque(false);
				
		BotonDentista boton_asignar_consulta = new BotonDentista();
	
		boton_asignar_consulta.setBounds(57, 26, 161, 30);
		boton_asignar_consulta.setBorder(null);
		boton_asignar_consulta.setRadius(30);
		boton_asignar_consulta.setText("Asignar Consultar");
		boton_asignar_consulta.setFocusable(false);

		BotonDentista boton_consultar_consulta = new BotonDentista();
		
		boton_consultar_consulta.setBounds(274, 26, 168, 30);
		boton_consultar_consulta.setBorder(null);
		boton_consultar_consulta.setRadius(30);
		boton_consultar_consulta.setText("Consultar Consulta");
		boton_consultar_consulta.setFocusable(false);

		BotonDentista boton_eliminar_consulta = new BotonDentista();
		
		boton_eliminar_consulta.setBounds(504, 26, 160, 29);
		boton_eliminar_consulta.setBorder(null);
		boton_eliminar_consulta.setRadius(30);
		boton_eliminar_consulta.setText("Eliminar Consulta");
		boton_eliminar_consulta.setFocusable(false);

		add(this.panel);
		add(boton_asignar_consulta);
		add(boton_consultar_consulta);
		add(boton_eliminar_consulta);
		
		// Asignacion de los eventos
		boton_asignar_consulta.addActionListener( (event) -> {
			
			if (this.panel.isShowing()) {
				remove(this.panel);
			}
			
			// Establecimiento del panel de asignar consultas
			this.panel = new Asignar_Consulta();
			this.panel.setLocation(0,90);
			
			add(this.panel);
			updateUI();
		});
		
		boton_consultar_consulta.addActionListener(event -> {
			
			if (this.panel.isShowing()) {
				remove(this.panel);
			}
			
			// Establecimiento del panel de consultar consultas
			this.panel = new Consultar_Consultas();
			this.panel.setLocation(0,90);
			
			add(this.panel);
			updateUI();
		});
		
		boton_eliminar_consulta.addActionListener( (event) -> {
			
			if (this.panel.isShowing()) {
				remove(this.panel);
			}
			
			// Establecimiento del panel de eliminar consultas
			this.panel = new Eliminar_Consulta();
			this.panel.setLocation(0,90);
			
			add(this.panel);
			updateUI();
		});
	}
}
