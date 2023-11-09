package Vista.administrador;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import Vista.Login_Inicio;

import java.awt.event.ActionListener;
import botonDentista.BotonDentista;
import java.awt.event.ActionEvent;

public class Administrar_Consultas extends JPanel {

	// Atributos
	protected JPanel panel;
	
	// Constructores
	public Administrar_Consultas() {
		
		setBounds(0, 0, 720, 500);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		// Creacion de los elementos graficos
		this.panel = new JPanel();
		this.panel.setBounds(0, 139, 720, 208);
		this.panel.setBackground(new Color(255,255, 255));
		add(this.panel);
		
		BotonDentista btndntstAsignarConsultar = new BotonDentista();
	
		btndntstAsignarConsultar.setText("Asignar Consultar");
		btndntstAsignarConsultar.setBorder(null);
		btndntstAsignarConsultar.setRadius(30);
		btndntstAsignarConsultar.setBounds(57, 26, 161, 30);
		add(btndntstAsignarConsultar);
		
		BotonDentista btndntstConsultarConsulta = new BotonDentista();
		
		btndntstConsultarConsulta.setText("Consultar Consulta");
		btndntstConsultarConsulta.setBorder(null);
		btndntstConsultarConsulta.setRadius(30);
		btndntstConsultarConsulta.setBounds(274, 26, 168, 30);
		add(btndntstConsultarConsulta);
		
		BotonDentista btndntstEliminarConsulta = new BotonDentista();
		btndntstEliminarConsulta.setBorder(null);

		btndntstEliminarConsulta.setText("Eliminar Consulta");
		btndntstEliminarConsulta.setRadius(30);
		btndntstEliminarConsulta.setBounds(504, 26, 160, 29);
		add(btndntstEliminarConsulta);
		btndntstAsignarConsultar.addActionListener( (event) -> {
				if (this.panel.isShowing()) {
					remove(this.panel);
				}
				
				// Establecimiento del panel de asignar consultas
				this.panel = new Asignar_Consulta();
				this.panel.setLocation(0,142);
				
				add(this.panel);
				updateUI();
		});
		btndntstConsultarConsulta.addActionListener(event -> {
			if (this.panel.isShowing()) {
				remove(this.panel);
			}
			
			// Establecimiento del panel de consultar consultas
			this.panel = new Consultar_Consultas();
			this.panel.setLocation(0,142);
			
			add(this.panel);
			updateUI();
		});
		btndntstEliminarConsulta.addActionListener( (event) -> {
			
			if (this.panel.isShowing()) {
				remove(this.panel);
			}
			
			// Establecimiento del panel de eliminar consultas
			this.panel = new Eliminar_Consulta();
			this.panel.setLocation(0,142);
			
			add(this.panel);
			updateUI();
		});
		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoadminarriba.png")));
		lblFondo.setBounds(0, 0, 728, 142);
		add(lblFondo);
	}
	
}
