package prueba;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout.Constraints;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Dentiapp extends JFrame {

	protected JPanel contentPane;
	protected JPanel panelprueba;

	public Dentiapp() {
		
		this.contentPane = new JPanel();
		this.panelprueba = new JPanel();
		
		this.contentPane.setLayout(null);
		
		JButton boton_consultar_usuarios = new JButton("Consultar usuarios");
		boton_consultar_usuarios.setBounds(31, 68, 169, 25);
		
		JButton boton_anadir_tratamiento = new JButton("Anadir tratamiento");
		boton_anadir_tratamiento.setBounds(228, 12, 169, 25);
		
		JButton boton_modificar_usuarios = new JButton("Modificar usuarios");
		boton_modificar_usuarios.setBounds(31, 124, 165, 25);
		
		JButton boton_modificar_tratamiento = new JButton("Modificar tratamiento");
		boton_modificar_tratamiento.setBounds(229, 70, 188, 25);
		
		JButton boton_administrar_consultas = new JButton("Administrar consultas");
		boton_administrar_consultas.setBounds(28, 180, 189, 25);
		
		JButton boton_insertar_especialidad = new JButton("Insertar especialidad");
		boton_insertar_especialidad.setBounds(228, 128, 185, 25);
		
		JButton boton_modificar_especialidad = new JButton("Modificar especialidad");
		boton_modificar_especialidad.setBounds(433, 12, 193, 25);
		
		JButton boton_consultar_especialidad = new JButton("Consultar especialidad");
		boton_consultar_especialidad.setBounds(241, 186, 197, 25);
		
		JButton boton_administrar_facturas = new JButton("Administrar facturas");
		boton_administrar_facturas.setBounds(445, 128, 179, 25);
		
		JButton boton_eliminar_especialidad = new JButton("Eliminar especialidad");
		boton_eliminar_especialidad.setBounds(446, 70, 184, 25);
		
		JButton boton_crear_pedidos = new JButton("Crear pedidos");
		boton_crear_pedidos.setBounds(462, 186, 134, 25);
		
		JButton boton_consultar_pedidos = new JButton("Consultar pedidos");
		boton_consultar_pedidos.setBounds(31, 236, 164, 25);
		
		JButton boton_modificar_pedidos = new JButton("Modificar pedidos");
		boton_modificar_pedidos.setBounds(255, 244, 160, 25);
		
		JButton boton_administrar_stock = new JButton("Administrar stock");
		boton_administrar_stock.setBounds(475, 244, 158, 25);
		
		JButton boton_insertar_usuarios = new JButton("Insertar usuarios");
		boton_insertar_usuarios.setBounds(35, 12, 157, 25);
		
		JLabel etiquetaprueba = new JLabel("Esto es un mensaje de prueba");
		etiquetaprueba.setBounds(198, 67, 215, 15);
						
		boton_insertar_usuarios.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				this.contentPane.remove(panelprueba);
			}
			
			panelprueba = new Dentiapppanel();
			panelprueba.setLocation(0,300);
			
			this.contentPane.add(panelprueba);
			this.contentPane.updateUI();
		});
		
		boton_consultar_usuarios.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				this.contentPane.remove(panelprueba);
			}
			
			panelprueba = new Dentiapppanel();
			panelprueba.setLocation(0,300);
			
			this.contentPane.add(panelprueba);
			this.contentPane.updateUI();
		});
		
		boton_modificar_usuarios.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				this.contentPane.remove(panelprueba);
			}
			
			panelprueba = new Dentiapppanel();
			panelprueba.setLocation(0,300);
			
			this.contentPane.add(panelprueba);
			this.contentPane.updateUI();
		});
		
		boton_administrar_consultas.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				this.contentPane.remove(panelprueba);
			}
			
			panelprueba = new Dentiapppanel();
			panelprueba.setLocation(0,300);
			
			this.contentPane.add(panelprueba);
			this.contentPane.updateUI();
		});
		
		boton_anadir_tratamiento.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				this.contentPane.remove(panelprueba);
			}
			
			panelprueba = new Dentiapppanel();
			panelprueba.setLocation(0,300);
			
			this.contentPane.add(panelprueba);
			this.contentPane.updateUI();
		});
		
		boton_modificar_tratamiento.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				this.contentPane.remove(panelprueba);
			}
			
			panelprueba = new Dentiapppanel();
			panelprueba.setLocation(0,300);
			
			this.contentPane.add(panelprueba);
			this.contentPane.updateUI();
		});
		
		boton_insertar_especialidad.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				this.contentPane.remove(panelprueba);
			}
			
			panelprueba = new Dentiapppanel();
			panelprueba.setLocation(0,300);
			
			this.contentPane.add(panelprueba);
			this.contentPane.updateUI();
		});
		
		boton_consultar_especialidad.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				this.contentPane.remove(panelprueba);
			}
			
			panelprueba = new Dentiapppanel();
			panelprueba.setLocation(0,300);
			
			this.contentPane.add(panelprueba);
			this.contentPane.updateUI();
		});
		
		boton_modificar_especialidad.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				this.contentPane.remove(panelprueba);
			}
			
			panelprueba = new Dentiapppanel();
			panelprueba.setLocation(0,300);
			
			this.contentPane.add(panelprueba);
			this.contentPane.updateUI();
		});
		
		boton_eliminar_especialidad.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				this.contentPane.remove(panelprueba);
			}
			
			panelprueba = new Dentiapppanel();
			panelprueba.setLocation(0,300);
			
			this.contentPane.add(panelprueba);
			this.contentPane.updateUI();
		});
		
		boton_administrar_facturas.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				this.contentPane.remove(panelprueba);
			}
			
			panelprueba = new Dentiapppanel();
			panelprueba.setLocation(0,300);
			
			this.contentPane.add(panelprueba);
			this.contentPane.updateUI();
		});
		
		boton_crear_pedidos.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				this.contentPane.remove(panelprueba);
			}
			
			panelprueba = new Dentiapppanel();
			panelprueba.setLocation(0,300);
			
			this.contentPane.add(panelprueba);
			this.contentPane.updateUI();
		});
		
		boton_consultar_pedidos.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				this.contentPane.remove(panelprueba);
			}
			
			panelprueba = new Dentiapppanel();
			panelprueba.setLocation(0,300);
			
			this.contentPane.add(panelprueba);
			this.contentPane.updateUI();
		});
		
		boton_modificar_pedidos.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				this.contentPane.remove(panelprueba);
			}
			
			panelprueba = new Dentiapppanel();
			panelprueba.setLocation(0,300);
			
			this.contentPane.add(panelprueba);
			this.contentPane.updateUI();
		});
		
		boton_administrar_stock.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				this.contentPane.remove(panelprueba);
			}
			
			panelprueba = new Dentiapppanel();
			panelprueba.setLocation(0,300);
			
			this.contentPane.add(panelprueba);
			this.contentPane.updateUI();
		});
		
		this.contentPane.add(boton_consultar_usuarios);
		this.contentPane.add(boton_anadir_tratamiento);
		this.contentPane.add(boton_modificar_usuarios);
		this.contentPane.add(boton_modificar_tratamiento);
		this.contentPane.add(boton_administrar_consultas);
		this.contentPane.add(boton_insertar_especialidad);
		this.contentPane.add(boton_modificar_especialidad);
		this.contentPane.add(boton_consultar_especialidad);
		this.contentPane.add(boton_administrar_facturas);
		this.contentPane.add(boton_eliminar_especialidad);
		this.contentPane.add(boton_crear_pedidos);
		this.contentPane.add(boton_consultar_pedidos);
		this.contentPane.add(boton_modificar_pedidos);
		this.contentPane.add(boton_administrar_stock);
		this.contentPane.add(boton_insertar_usuarios);
				
		setContentPane(this.contentPane);
		
		setTitle("DentiApp");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(700,500));
	}
	
	public static void main(String[] args) {
		
		Dentiapp dentiapp = new Dentiapp();
		dentiapp.setVisible(true);
	}
}
