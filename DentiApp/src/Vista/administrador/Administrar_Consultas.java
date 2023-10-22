package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class Administrar_Consultas extends JPanel {

	// Atributos
	protected JPanel panel;
	
	// Constructores
	public Administrar_Consultas() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		
		// Creacion de los elementos graficos
		this.panel = new JPanel();
		this.panel.setBounds(97, 153, 526, 193);

		JButton boton_asignar_consulta = new JButton("Asignar consulta");
		
		boton_asignar_consulta.setBounds(58, 40, 160, 30);
		boton_asignar_consulta.setBorderPainted(false);
		boton_asignar_consulta.setContentAreaFilled(false);
		
		JButton boton_consultar_consulta = new JButton("Consultar consulta");
		
		boton_consultar_consulta.setBounds(284, 40, 168, 30);
		boton_consultar_consulta.setBorderPainted(false);
		boton_consultar_consulta.setContentAreaFilled(false);
		
		JButton boton_eliminar_consulta = new JButton("Eliminar consulta");
		
		boton_eliminar_consulta.setBounds(502, 40, 160, 30);
		boton_eliminar_consulta.setBorderPainted(false);
		boton_eliminar_consulta.setContentAreaFilled(false);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 80, 200, 10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(260, 80, 200, 10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(490, 80, 200, 10);
				
		add(boton_asignar_consulta);
		add(boton_consultar_consulta);
		add(boton_eliminar_consulta);
		add(separator);
		add(separator_1);
		add(separator_2);
		add(this.panel);
		
		// Asignacion de los eventos
		boton_asignar_consulta.addActionListener( (event) -> {
			
			if (this.panel.isShowing()) {
				remove(this.panel);
			}
			
			// Establecimiento del panel de asignar consultas
			this.panel = new Asignar_Consulta();
			this.panel.setLocation(25,100);
			
			add(this.panel);
			updateUI();
		});
		
		boton_consultar_consulta.addActionListener( (event) -> {
					
					if (this.panel.isShowing()) {
						remove(this.panel);
					}
					
					// Establecimiento del panel de consultar consultas
					this.panel = new Consultar_Consultas();
					this.panel.setLocation(25,100);
					
					add(this.panel);
					updateUI();
				});
		
		boton_eliminar_consulta.addActionListener( (event) -> {
			
			if (this.panel.isShowing()) {
				remove(this.panel);
			}
			
			// Establecimiento del panel de eliminar consultas
			this.panel = new Eliminar_Consulta();
			this.panel.setLocation(25,100);
			
			add(this.panel);
			updateUI();
		});
	}
}
