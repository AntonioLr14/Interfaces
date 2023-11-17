package Vista.administrador.gestion_de_material;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import Vista.Login_Inicio;
import botonDentista.BotonDentista;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Administrar_Stock extends JPanel {

	// Atributos
	protected JPanel panel;

	// Constructores
	public Administrar_Stock() {

		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);

		// Creacion de los elementos graficos
		this.panel = new JPanel();
		
		this.panel.setOpaque(false);
		this.panel.setBounds(0, 153,720, 193);
		add(this.panel);

		BotonDentista btndntstActualizarStock = new BotonDentista();

		btndntstActualizarStock.setBorder(null);
		btndntstActualizarStock.setText("Actualizar stock");
		btndntstActualizarStock.setRadius(30);
		btndntstActualizarStock.setBounds(55, 40, 160, 30);
		add(btndntstActualizarStock);

		BotonDentista btndntstInsertarMaterial = new BotonDentista();
		
		btndntstInsertarMaterial.setText("Insertar material");
		btndntstInsertarMaterial.setRadius(30);
		btndntstInsertarMaterial.setBorder(null);
		btndntstInsertarMaterial.setBounds(277, 40, 160, 30);
		add(btndntstInsertarMaterial);
		
		BotonDentista btndntstModificarMaterial = new BotonDentista();
		
		btndntstModificarMaterial.setBorder(null);
		btndntstModificarMaterial.setRadius(30);
		btndntstModificarMaterial.setText("Modificar material");
		btndntstModificarMaterial.setBounds(510, 40, 165, 30);
		add(btndntstModificarMaterial);

		// Asignacion de los eventos
		btndntstActualizarStock.addActionListener((event) -> {
			
			if (this.panel.isShowing()) {
				remove(this.panel);
			}

			// Establecimiento del panel de actualizar stock
			this.panel = new Actualizar_Stock();
			this.panel.setLocation(0, 142);

			add(this.panel);
			updateUI();
		});

		btndntstInsertarMaterial.addActionListener((event) -> {
			
			if (this.panel.isShowing()) {
				remove(this.panel);
			}

			// Establecimiento del panel de insertar material
			this.panel = new Insertar_Material();
			this.panel.setLocation(0, 142);

			add(this.panel);
			updateUI();
		});

		btndntstModificarMaterial.addActionListener((event) -> {
			
			if (this.panel.isShowing()) {
				remove(this.panel);
			}

			// Establecimiento del panel de modificar material
			this.panel = new Modificar_Stock();
			this.panel.setLocation(0, 142);

			add(this.panel);
			updateUI();
		});
	}
}
