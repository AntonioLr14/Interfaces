package Vista.administrador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import Vista.administrador.gestion_de_material.Administrar_Stock;
import Vista.administrador.gestion_de_material.Consultar_Pedidos;
import Vista.administrador.gestion_de_material.Crear_Pedidos;
import Vista.administrador.gestion_de_material.Modificar_Pedido;
import Vista.administrador.gestion_de_usuarios.Administrar_Consultas;
import Vista.administrador.gestion_de_usuarios.Consultar_Usuarios;
import Vista.administrador.gestion_de_usuarios.Insertar_Usuario;
import Vista.administrador.gestion_de_usuarios.Modificar_Usuario;
import Vista.administrador.gestion_economica.Administrar_Facturas;
import Vista.administrador.gestion_medica.Anyadir_Tratamiento;
import Vista.administrador.gestion_medica.Consultar_Especialidad;
import Vista.administrador.gestion_medica.Eliminar_Especialidad;
import Vista.administrador.gestion_medica.Insertar_Especialidad;
import Vista.administrador.gestion_medica.Modificar_Especialidad;
import Vista.administrador.gestion_medica.Modificar_Tratamiento;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;

public class Administrador extends JFrame {

	// Atributos
	protected JPanel contentPane;
	protected JPanel panel;
	protected JButton boton_insertar_usuarios;
	protected JButton boton_consultar_usuarios;
	protected JButton boton_modificar_usuarios;
	protected JButton boton_administrar_consultas;
	protected JButton boton_anadir_tratamientos;
	protected JButton boton_modificar_tratamientos;
	protected JButton boton_insertar_especialidad;
	protected JButton boton_consultar_especialidad;
	protected JButton boton_modificar_especialidad;
	protected JButton boton_eliminar_especialidad;
	protected JButton boton_administrar_facturas;
	protected JButton boton_crear_pedidos;
	protected JButton boton_consultar_pedidos;
	protected JButton boton_modificar_pedidos;
	protected JButton boton_administrar_stock;
	protected JLabel etiqueta_gestion_de_usuarios;
	protected JLabel etiqueta_gestion_medica;
	protected JLabel etiqueta_gestion_economica;
	protected JLabel etiqueta_gestion_de_material;
	protected JLabel etiqueta_fondo;

	// Constructores
	public Administrador() {
		
		// Creacion de los paneles
		this.contentPane = new JPanel();
		this.panel = new JPanel();
		
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		
		this.etiqueta_fondo = new JLabel();
		
		this.etiqueta_fondo.setBounds(0, 0, 735, 500);
		this.etiqueta_fondo.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/fondomedico.png")));
				
		// Creacion de los elementos graficos
		this.boton_insertar_usuarios = new JButton();
	
		this.boton_insertar_usuarios.setBounds(10, 25, 37, 35);
		this.boton_insertar_usuarios.setContentAreaFilled(false);
		this.boton_insertar_usuarios.setToolTipText("Insertar usuarios (I+U)");
		this.boton_insertar_usuarios.setFocusable(false);
		
		this.boton_insertar_usuarios.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/insertar_usuarios.png")));

		this.boton_consultar_usuarios = new JButton();
		
		this.boton_consultar_usuarios.setBounds(57, 25, 37, 35);
		this.boton_consultar_usuarios.setContentAreaFilled(false);
		this.boton_consultar_usuarios.setToolTipText("Consultar usuarios(C+U)");
		this.boton_consultar_usuarios.setFocusable(false);
		
		this.boton_consultar_usuarios.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/consultar_usuarios.png")));
		
		this.boton_modificar_usuarios = new JButton();
		
		this.boton_modificar_usuarios.setBounds(104, 25, 37, 35);
		this.boton_modificar_usuarios.setContentAreaFilled(false);
		this.boton_modificar_usuarios.setToolTipText("Modificar usuarios(M+U)");
		this.boton_modificar_usuarios.setFocusable(false);
		
		this.boton_modificar_usuarios.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/modificar_usuarios.png")));

		this.boton_administrar_consultas = new JButton();
		
		this.boton_administrar_consultas.setBounds(151, 25, 37, 35);
		this.boton_administrar_consultas.setContentAreaFilled(false);
		this.boton_administrar_consultas.setToolTipText("Administrar consultas (A+C)");
		this.boton_administrar_consultas.setFocusable(false);
		
		this.boton_administrar_consultas.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/administrar_consultas.png")));

		this.boton_anadir_tratamientos = new JButton();
		
		this.boton_anadir_tratamientos.setBounds(198, 25, 37, 35);
		this.boton_anadir_tratamientos.setContentAreaFilled(false);
		this.boton_anadir_tratamientos.setToolTipText("Anadir tratamientos(A+T)");
		this.boton_anadir_tratamientos.setFocusable(false);
		
		this.boton_anadir_tratamientos.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/anadir_tratamientos.png")));
		
		this.boton_modificar_tratamientos = new JButton();
		
		this.boton_modificar_tratamientos.setBounds(245, 25, 37, 36);
		this.boton_modificar_tratamientos.setContentAreaFilled(false);
		this.boton_modificar_tratamientos.setToolTipText("Modificar tratamientos(M+T)");
		this.boton_modificar_tratamientos.setFocusable(false);
		
		this.boton_modificar_tratamientos.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/modificar_tratamientos.png")));

		this.boton_insertar_especialidad = new JButton();
		
		this.boton_insertar_especialidad.setBounds(293, 25, 37, 36);
		this.boton_insertar_especialidad.setContentAreaFilled(false);
		this.boton_insertar_especialidad.setToolTipText("Insertar especialidad(I+E)");
		this.boton_insertar_especialidad.setFocusable(false);
		
		this.boton_insertar_especialidad.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/insertar_especialidad.png")));

		this.boton_consultar_especialidad = new JButton();
		
		this.boton_consultar_especialidad.setBounds(340, 25, 37, 36);
		this.boton_consultar_especialidad.setContentAreaFilled(false);
		this.boton_consultar_especialidad.setToolTipText("Consultar especialidad(C+E)");
		this.boton_consultar_especialidad.setFocusable(false);
		
		this.boton_consultar_especialidad.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/consultar_especialidad.png")));

		this.boton_modificar_especialidad = new JButton();
		
		this.boton_modificar_especialidad.setBounds(387, 25, 37, 36);
		this.boton_modificar_especialidad.setContentAreaFilled(false);
		this.boton_modificar_especialidad.setToolTipText("Modificar especialidad(M+E)");
		this.boton_modificar_especialidad.setFocusable(false);
		
		this.boton_modificar_especialidad.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/modificar_especialidad.png")));

		this.boton_eliminar_especialidad = new JButton();
		
		this.boton_eliminar_especialidad.setBounds(434, 25, 37, 36);
		this.boton_eliminar_especialidad.setContentAreaFilled(false);
		this.boton_eliminar_especialidad.setToolTipText("Eliminar especialidad(B+E)");
		this.boton_eliminar_especialidad.setFocusable(false);
		
		this.boton_eliminar_especialidad.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/eliminar_especialidad.png")));

		this.boton_administrar_facturas = new JButton();
		
		this.boton_administrar_facturas.setBounds(481, 25, 37, 37);
		this.boton_administrar_facturas.setContentAreaFilled(false);
		this.boton_administrar_facturas.setToolTipText("Administrar facturas(A+F)");
		this.boton_administrar_facturas.setFocusable(false);
		
		this.boton_administrar_facturas.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/administrar_facturas.png")));

		this.boton_crear_pedidos = new JButton();
		
		this.boton_crear_pedidos.setBounds(528, 25, 37, 36);
		this.boton_crear_pedidos.setContentAreaFilled(false);
		this.boton_crear_pedidos.setToolTipText("Crear pedidos(C+P)");
		this.boton_crear_pedidos.setFocusable(false);
		
		this.boton_crear_pedidos.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/crear_pedidos.png")));
		
		this.boton_consultar_pedidos = new JButton();
		
		this.boton_consultar_pedidos.setBounds(575, 25, 37, 35);
		this.boton_consultar_pedidos.setContentAreaFilled(false);
		this.boton_consultar_pedidos.setToolTipText("Consultar pedidos(B+P)");
		this.boton_consultar_pedidos.setFocusable(false);
		
		this.boton_consultar_pedidos.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/consultar_pedidos.png")));

		this.boton_modificar_pedidos = new JButton();
		
		this.boton_modificar_pedidos.setBounds(622, 25, 37, 37);
		this.boton_modificar_pedidos.setContentAreaFilled(false);
		this.boton_modificar_pedidos.setToolTipText("Modificar pedidos(M+P)");
		this.boton_modificar_pedidos.setFocusable(false);
		
		this.boton_modificar_pedidos.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/modificar_pedidos.png")));

		this.boton_administrar_stock = new JButton();
		
		this.boton_administrar_stock.setBounds(669, 25, 37, 35);
		this.boton_administrar_stock.setContentAreaFilled(false);
		this.boton_administrar_stock.setToolTipText("Administrar stock(A+S)");
		this.boton_administrar_stock.setFocusable(false);
		
		this.boton_administrar_stock.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/administrar_stock.png")));
		
		this.etiqueta_gestion_de_usuarios = new JLabel();
		
		this.etiqueta_gestion_de_usuarios.setBounds(30, 78, 143, 14);
		this.etiqueta_gestion_de_usuarios.setText("Gestión de usuarios");
		
		this.etiqueta_gestion_medica = new JLabel();
		
		this.etiqueta_gestion_medica.setBounds(275, 78, 113, 14);
		this.etiqueta_gestion_medica.setText("Gestión médica");
		
		this.etiqueta_gestion_economica = new JLabel();
		
		this.etiqueta_gestion_economica.setBounds(460, 70, 75, 36);
		this.etiqueta_gestion_economica.setText("<html><p align='center'>Gestión<br>económica</html>");
				
		this.etiqueta_gestion_de_material = new JLabel();
		
		this.etiqueta_gestion_de_material.setBounds(545, 78, 143, 14);
		this.etiqueta_gestion_de_material.setText("Gestión de material");
		
		JSeparator separator = new JSeparator();
		
		separator.setBounds(10, 110, 695, 1);
		separator.setOrientation(SwingConstants.HORIZONTAL);
		separator.setBackground(Color.black);
		
		JSeparator separator_1 = new JSeparator();
		
		separator_1.setBounds(192, 25, 1, 35);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(Color.black);
		
		JSeparator separator_2 = new JSeparator();
		
		separator_2.setBounds(287, 25, 1, 35);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBackground(Color.black);
		
		JSeparator separator_3 = new JSeparator();
		
		separator_3.setBounds(475, 25, 1, 35);
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBackground(Color.black);
		
		JSeparator separator_4 = new JSeparator();
		
		separator_4.setBounds(522, 25, 1, 35);
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBackground(Color.black);
		
		JSeparator separator_5 = new JSeparator();
		
		separator_5.setBounds(663, 25, 1, 35);
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBackground(Color.black);
		
		this.contentPane.add(boton_insertar_usuarios);
		this.contentPane.add(boton_consultar_usuarios);
		this.contentPane.add(boton_modificar_usuarios);
		this.contentPane.add(boton_administrar_consultas);
		this.contentPane.add(boton_anadir_tratamientos);
		this.contentPane.add(boton_modificar_tratamientos);
		this.contentPane.add(boton_insertar_especialidad);
		this.contentPane.add(boton_consultar_especialidad);
		this.contentPane.add(boton_modificar_especialidad);
		this.contentPane.add(boton_eliminar_especialidad);
		this.contentPane.add(boton_administrar_facturas);
		this.contentPane.add(boton_crear_pedidos);
		this.contentPane.add(boton_consultar_pedidos);
		this.contentPane.add(boton_modificar_pedidos);
		this.contentPane.add(boton_administrar_stock);
		
		this.contentPane.add(etiqueta_gestion_de_usuarios);
		this.contentPane.add(etiqueta_gestion_medica);
		this.contentPane.add(etiqueta_gestion_economica);
		this.contentPane.add(etiqueta_gestion_de_material);
		
		this.contentPane.add(separator);
		this.contentPane.add(separator_1);
		this.contentPane.add(separator_2);
		this.contentPane.add(separator_3);
		this.contentPane.add(separator_4);
		this.contentPane.add(separator_5);
		
		this.contentPane.add(etiqueta_fondo);

		setContentPane(contentPane);
		
		// Asignacion de los eventos
		this.boton_insertar_usuarios.addActionListener( (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);

			// Establecimiento del panel de insertar usuarios
			panel = new Insertar_Usuario();
			panel.setLocation(0,100);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);
			
			this.contentPane.updateUI();
		});
				
		this.boton_consultar_usuarios.addActionListener( (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			// Establecimiento del panel de consultar usuarios
			panel = new Consultar_Usuarios();
			panel.setLocation(0,100);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		});
				
		this.boton_modificar_usuarios.addActionListener( (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			// Establecimiento del panel de modificar usuarios
			panel = new Modificar_Usuario();
			panel.setLocation(0,100);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		});
				
		this.boton_administrar_consultas.addActionListener( (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			// Establecimiento del panel de administrar consultas
			panel = new Administrar_Consultas();
			panel.setLocation(0,115);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		});
		
		this.boton_anadir_tratamientos.addActionListener( (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			// Establecimiento del panel de anadir tratamientos
			panel = new Anyadir_Tratamiento();
			panel.setLocation(0,100);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		});
				
		this.boton_modificar_tratamientos.addActionListener( (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			// Establecimiento del panel de modificar tratamientos
			panel = new Modificar_Tratamiento();
			panel.setLocation(0,100);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		});
				
		this.boton_insertar_especialidad.addActionListener( (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			// Establecimiento del panel de insertar especialidad
			panel = new Insertar_Especialidad();
			panel.setLocation(0,100);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		});
				
		this.boton_consultar_especialidad.addActionListener( (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			// Establecimiento del panel de consultar especialidad
			panel = new Consultar_Especialidad();
			panel.setLocation(0,100);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		});
				
		this.boton_modificar_especialidad.addActionListener( (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			// Establecimiento del panel de modificar especialidad
			panel = new Modificar_Especialidad();
			panel.setLocation(0,100);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		});
				
		this.boton_eliminar_especialidad.addActionListener( (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			// Establecimiento del panel de eliminar especialidad
			panel = new Eliminar_Especialidad();
			panel.setLocation(0,100);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		});
				
		this.boton_administrar_facturas.addActionListener( (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			// Establecimiento del panel de administrar facturas
			panel = new Administrar_Facturas();
			panel.setLocation(0,115);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		});
				
		this.boton_crear_pedidos.addActionListener( (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			// Establecimiento del panel de crear pedidos
			panel = new Crear_Pedidos();
			panel.setLocation(0,100);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		});
		
		this.boton_consultar_pedidos.addActionListener( (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			// Establecimiento del panel de consultar pedidos
			panel = new Consultar_Pedidos();
			panel.setLocation(0,100);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		});
				
		this.boton_modificar_pedidos.addActionListener( (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			// Establecimiento del panel de modificar pedidos
			panel = new Modificar_Pedido();
			panel.setLocation(0,100);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		});
				
		this.boton_administrar_stock.addActionListener( (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			// Establecimiento del panel de administrar stock
			panel = new Administrar_Stock();
			panel.setLocation(0,115);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		});
		
		contentPane.addKeyListener(new KeyAdapter() {
			private ArrayList <Integer> combo=new ArrayList<>();
			@Override
			public void keyPressed(KeyEvent e) {
				
				combo.add(e.getKeyCode());
				if(combo.contains(KeyEvent.VK_I)&&combo.contains(KeyEvent.VK_U)) {
					if (panel.isShowing()) {
						contentPane.remove(panel);
					}
					
				 contentPane.remove(etiqueta_fondo);

					// Establecimiento del panel de insertar usuarios
					panel = new Insertar_Usuario();
					panel.setLocation(0,100);
					
					contentPane.add(panel);
					contentPane.add(etiqueta_fondo);
					
					contentPane.updateUI();
					combo.clear();
				}
				
				//Atajo de teclado para Consultar_Usuario
				
				if(combo.contains(KeyEvent.VK_C)&&combo.contains(KeyEvent.VK_U)) {
					if (panel.isShowing()) {
						contentPane.remove(panel);
					}
					
				 contentPane.remove(etiqueta_fondo);

					// Establecimiento del panel de consultar usuarios
					panel = new Consultar_Usuarios();
					panel.setLocation(0,100);
					
					contentPane.add(panel);
					contentPane.add(etiqueta_fondo);
					
					contentPane.updateUI();
					combo.clear();
				}
				
				//Atajo de teclado para Modificar_Usuario
				
				if(combo.contains(KeyEvent.VK_M)&&combo.contains(KeyEvent.VK_U)) {
					if (panel.isShowing()) {
						contentPane.remove(panel);
					}
					
				 contentPane.remove(etiqueta_fondo);

					// Establecimiento del panel de modificar usuarios
					panel = new Modificar_Usuario();
					panel.setLocation(0,100);
					
					contentPane.add(panel);
					contentPane.add(etiqueta_fondo);
					
					contentPane.updateUI();
					combo.clear();
				}
				
				//Atajo de teclado para Administrar consultas
				
				if(combo.contains(KeyEvent.VK_A)&&combo.contains(KeyEvent.VK_C)) {
					if (panel.isShowing()) {
						contentPane.remove(panel);
					}
					
				 contentPane.remove(etiqueta_fondo);

					// Establecimiento del panel de Administrar consultas
					panel = new Administrar_Consultas();
					panel.setLocation(0,100);
					
					contentPane.add(panel);
					contentPane.add(etiqueta_fondo);
					
					contentPane.updateUI();
					combo.clear();
				}
				
				//Atajo de teclado para Añadir tratamiento
				
				if(combo.contains(KeyEvent.VK_A)&&combo.contains(KeyEvent.VK_T)) {
					if (panel.isShowing()) {
						contentPane.remove(panel);
					}
					
				 contentPane.remove(etiqueta_fondo);

					// Establecimiento del panel de Añadir tratamiento
					panel = new Anyadir_Tratamiento();
					panel.setLocation(0,100);
					
					contentPane.add(panel);
					contentPane.add(etiqueta_fondo);
					
					contentPane.updateUI();
					combo.clear();
				}
				
				//Atajo de teclado para Modificar_Tratamiento
				
				if(combo.contains(KeyEvent.VK_M)&&combo.contains(KeyEvent.VK_T)) {
					if (panel.isShowing()) {
						contentPane.remove(panel);
					}
					
				 contentPane.remove(etiqueta_fondo);

					// Establecimiento del panel de modificar tratamiento
					panel = new Modificar_Tratamiento();
					panel.setLocation(0,100);
					
					contentPane.add(panel);
					contentPane.add(etiqueta_fondo);
					
					contentPane.updateUI();
					combo.clear();
				}
				
				//Atajo de teclado para Insertar especialidad
				
				if(combo.contains(KeyEvent.VK_I)&&combo.contains(KeyEvent.VK_E)) {
					if (panel.isShowing()) {
						contentPane.remove(panel);
					}
					
				 contentPane.remove(etiqueta_fondo);

					// Establecimiento del panel de insertar especialidad
					panel = new Insertar_Especialidad();
					panel.setLocation(0,100);
					
					contentPane.add(panel);
					contentPane.add(etiqueta_fondo);
					
					contentPane.updateUI();
					combo.clear();
				}
				
				//Atajo de teclado para Consultar especialidad
				
				if(combo.contains(KeyEvent.VK_C)&&combo.contains(KeyEvent.VK_E)) {
					if (panel.isShowing()) {
						contentPane.remove(panel);
					}
					
				 contentPane.remove(etiqueta_fondo);

					// Establecimiento del panel de Consultar Especialidad
					panel = new Consultar_Especialidad();
					panel.setLocation(0,100);
					
					contentPane.add(panel);
					contentPane.add(etiqueta_fondo);
					
					contentPane.updateUI();
					combo.clear();
				}
				
				//Atajo de teclado para Modificar_Especialidad
				
				if(combo.contains(KeyEvent.VK_M)&&combo.contains(KeyEvent.VK_E)) {
					if (panel.isShowing()) {
						contentPane.remove(panel);
					}
					
				 contentPane.remove(etiqueta_fondo);

					// Establecimiento del panel de modificar especialidad
					panel = new Modificar_Especialidad();
					panel.setLocation(0,100);
					
					contentPane.add(panel);
					contentPane.add(etiqueta_fondo);
					
					contentPane.updateUI();
					combo.clear();
				}
				
				//Atajo de teclado para Eliminar_Especialidad
				
				if(combo.contains(KeyEvent.VK_B)&&combo.contains(KeyEvent.VK_E)) {
					if (panel.isShowing()) {
						contentPane.remove(panel);
					}
					
				 contentPane.remove(etiqueta_fondo);

					// Establecimiento del panel de eliminar especialidad
					panel = new Eliminar_Especialidad();
					panel.setLocation(0,100);
					
					contentPane.add(panel);
					contentPane.add(etiqueta_fondo);
					
					contentPane.updateUI();
					combo.clear();
				}
				
				//Atajo de teclado para Administrar facturas
				
				if(combo.contains(KeyEvent.VK_A)&&combo.contains(KeyEvent.VK_F)) {
					if (panel.isShowing()) {
						contentPane.remove(panel);
					}
					
				 contentPane.remove(etiqueta_fondo);

					// Establecimiento del panel de Administrar facturas
					panel = new Administrar_Facturas();
					panel.setLocation(0,100);
					
					contentPane.add(panel);
					contentPane.add(etiqueta_fondo);
					
					contentPane.updateUI();
					combo.clear();
				}
				
				//Atajo de teclado para crear pedidos
				
				if(combo.contains(KeyEvent.VK_C)&&combo.contains(KeyEvent.VK_P)) {
					if (panel.isShowing()) {
						contentPane.remove(panel);
					}
					
				 contentPane.remove(etiqueta_fondo);

					// Establecimiento del panel de crear pedidos
					panel = new Crear_Pedidos();
					panel.setLocation(0,100);
					
					contentPane.add(panel);
					contentPane.add(etiqueta_fondo);
					
					contentPane.updateUI();
					combo.clear();
				}
				
				//Atajo de teclado para Consultar pedidos (buscar)
				
				if(combo.contains(KeyEvent.VK_B)&&combo.contains(KeyEvent.VK_P)) {
					if (panel.isShowing()) {
						contentPane.remove(panel);
					}
					
				 contentPane.remove(etiqueta_fondo);

					// Establecimiento del panel de consultar pedidos
					panel = new Consultar_Pedidos();
					panel.setLocation(0,100);
					
					contentPane.add(panel);
					contentPane.add(etiqueta_fondo);
					
					contentPane.updateUI();
					combo.clear();
				}
				
				//Atajo de teclado para modificar pedidos
				
				if(combo.contains(KeyEvent.VK_M)&&combo.contains(KeyEvent.VK_P)) {
					if (panel.isShowing()) {
						contentPane.remove(panel);
					}
					
				 contentPane.remove(etiqueta_fondo);

					// Establecimiento del panel de modificar pedidos
					panel = new Modificar_Pedido();
					panel.setLocation(0,100);
					
					contentPane.add(panel);
					contentPane.add(etiqueta_fondo);
					
					contentPane.updateUI();
					combo.clear();
				}
				
				//Atajo de teclado para administrar stock
				
				if(combo.contains(KeyEvent.VK_A)&&combo.contains(KeyEvent.VK_S)) {
					if (panel.isShowing()) {
						contentPane.remove(panel);
					}
					
				 contentPane.remove(etiqueta_fondo);

					// Establecimiento del panel de administrar stock
					panel = new Administrar_Stock();
					panel.setLocation(0,100);
					
					contentPane.add(panel);
					contentPane.add(etiqueta_fondo);
					
					contentPane.updateUI();
					combo.clear();
				}
				
			}
		});
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(etiqueta_fondo, popupMenu);

		JMenu menuGestionUsuarios = new JMenu("Gestión de Usuarios");
		popupMenu.add(menuGestionUsuarios);
		
		JMenuItem menuInsertarUsuario = new JMenuItem("Insertar Usuario");
		menuInsertarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
						if (panel.isShowing()) {
							contentPane.remove(panel);
						}
						
						contentPane.remove(etiqueta_fondo);

						// Establecimiento del panel de insertar usuarios
						panel = new Insertar_Usuario();
						panel.setLocation(0,100);
						
						contentPane.add(panel);
						contentPane.add(etiqueta_fondo);
						
						contentPane.updateUI();
						
						
					}
				});

		menuGestionUsuarios.add(menuInsertarUsuario);
		
		JMenuItem menuConsultarUsuario = new JMenuItem("Consultar Usuario");
		menuConsultarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (panel.isShowing()) {
					contentPane.remove(panel);
				}
				
				contentPane.remove(etiqueta_fondo);

				// Establecimiento del panel de insertar usuarios
				panel = new Consultar_Usuarios();
				panel.setLocation(0,100);
				
				contentPane.add(panel);
				contentPane.add(etiqueta_fondo);
					
				contentPane.updateUI();
			}
		});

		menuGestionUsuarios.add(menuConsultarUsuario);
		
		JMenuItem menuModificarUsuario = new JMenuItem("Modificar Usuario");
		menuModificarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel.isShowing()) {
					contentPane.remove(panel);
				}
				
				contentPane.remove(etiqueta_fondo);

				// Establecimiento del panel de modificar usuarios
				panel = new Modificar_Usuario();
				panel.setLocation(0,100);
				
				contentPane.add(panel);
				contentPane.add(etiqueta_fondo);
					
				contentPane.updateUI();
			}
		});
		
		
		menuGestionUsuarios.add(menuModificarUsuario);
		
		JMenuItem menuAdministrarConsulta = new JMenuItem("Administrar Consulta");
		menuAdministrarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (panel.isShowing()) {
					contentPane.remove(panel);
				}
				
				contentPane.remove(etiqueta_fondo);

				// Establecimiento del panel de administrar consultas
				panel = new Administrar_Consultas();
				panel.setLocation(0,100);
				
				contentPane.add(panel);
				contentPane.add(etiqueta_fondo);
					
				contentPane.updateUI();
			}
		});
		
		menuGestionUsuarios.add(menuAdministrarConsulta);
		
		JMenu menuGestionMedica = new JMenu("Gestión Médica");
		popupMenu.add(menuGestionMedica);
		
		JMenuItem menuAnyadirTratamiento = new JMenuItem("Añadir Tratamiento");
		menuAnyadirTratamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (panel.isShowing()) {
					contentPane.remove(panel);
				}
				
				contentPane.remove(etiqueta_fondo);

				// Establecimiento del panel de añadir tratamiento
				panel = new Anyadir_Tratamiento();
				panel.setLocation(0,100);
				
				contentPane.add(panel);
				contentPane.add(etiqueta_fondo);
					
				contentPane.updateUI();
			}
		});
		
		menuGestionMedica.add(menuAnyadirTratamiento);
		
		JMenuItem menuModificarTratamiento = new JMenuItem("Modificar Tratamiento");
		menuModificarTratamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel.isShowing()) {
					contentPane.remove(panel);
				}
				
				contentPane.remove(etiqueta_fondo);

				// Establecimiento del panel de modificar tratamiento
				panel = new Modificar_Tratamiento();
				panel.setLocation(0,100);
				
				contentPane.add(panel);
				contentPane.add(etiqueta_fondo);
					
				contentPane.updateUI();
			}
		});
		
		menuGestionMedica.add(menuModificarTratamiento);
		
		JMenuItem menuInsertarEspecialidad = new JMenuItem("Insertar Especialidad");
		menuInsertarEspecialidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel.isShowing()) {
					contentPane.remove(panel);
				}
				
				contentPane.remove(etiqueta_fondo);

				// Establecimiento del panel de insertar especialidad
				panel = new Insertar_Especialidad();
				panel.setLocation(0,100);
				
				contentPane.add(panel);
				contentPane.add(etiqueta_fondo);
					
				contentPane.updateUI();
			}
		});
		
		menuGestionMedica.add(menuInsertarEspecialidad);
		
		JMenuItem menuConsultarEspecialidad = new JMenuItem("Consultar Especialidad");
		menuConsultarEspecialidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel.isShowing()) {
					contentPane.remove(panel);
				}
				
				contentPane.remove(etiqueta_fondo);

				// Establecimiento del panel de Consultar especialidad
				panel = new Consultar_Especialidad();
				panel.setLocation(0,100);
				
				contentPane.add(panel);
				contentPane.add(etiqueta_fondo);
					
				contentPane.updateUI();
				}
		});
		
		menuGestionMedica.add(menuConsultarEspecialidad);
		
		JMenuItem menuModificarEspecialidad = new JMenuItem("Modificar Especialidad");
		menuModificarEspecialidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel.isShowing()) {
					contentPane.remove(panel);
				}
				
				contentPane.remove(etiqueta_fondo);

				// Establecimiento del panel de modificar especialidad
				panel = new Modificar_Especialidad();
				panel.setLocation(0,100);
				
				contentPane.add(panel);
				contentPane.add(etiqueta_fondo);
					
				contentPane.updateUI();
			}
		});
		
		menuGestionMedica.add(menuModificarEspecialidad);
		
		JMenuItem menuEliminarEspecialidad = new JMenuItem("Eliminar Especialidad");
		menuEliminarEspecialidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel.isShowing()) {
					contentPane.remove(panel);
				}
				
				contentPane.remove(etiqueta_fondo);

				// Establecimiento del panel de eliminar especialidad
				panel = new Eliminar_Especialidad();
				panel.setLocation(0,100);
				
				contentPane.add(panel);
				contentPane.add(etiqueta_fondo);
					
				contentPane.updateUI();
			}
		});
		
		menuGestionMedica.add(menuEliminarEspecialidad);
		
		JMenuItem menuFacturas = new JMenuItem("Facturas");
		menuFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel.isShowing()) {
					contentPane.remove(panel);
				}
				
				contentPane.remove(etiqueta_fondo);

				// Establecimiento del panel de administrar facturas
				panel = new Administrar_Facturas();
				panel.setLocation(0,100);
				
				contentPane.add(panel);
				contentPane.add(etiqueta_fondo);
					
				contentPane.updateUI();
			}
		});
		
		popupMenu.add(menuFacturas);
		
	
		
		JMenu menuGestionMaterial = new JMenu("Gestión de Material");
		popupMenu.add(menuGestionMaterial);
		
		JMenuItem menuCrearPedido = new JMenuItem("Crear Pedido");
		menuCrearPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel.isShowing()) {
					contentPane.remove(panel);
				}
				
				contentPane.remove(etiqueta_fondo);

				// Establecimiento del panel de crear pedido
				panel = new Crear_Pedidos();
				panel.setLocation(0,100);
				
				contentPane.add(panel);
				contentPane.add(etiqueta_fondo);
					
				contentPane.updateUI();
			}
		});
		
		menuGestionMaterial.add(menuCrearPedido);
		
		JMenuItem menuConsultarPedido = new JMenuItem("Consultar Pedido");
		menuConsultarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel.isShowing()) {
					contentPane.remove(panel);
				}
				
				contentPane.remove(etiqueta_fondo);

				// Establecimiento del panel de Consultar pedido
				panel = new Consultar_Pedidos();
				panel.setLocation(0,100);
				
				contentPane.add(panel);
				contentPane.add(etiqueta_fondo);
					
				contentPane.updateUI();
			}
		});
	
		menuGestionMaterial.add(menuConsultarPedido);
		
		JMenuItem menuModificarPedido = new JMenuItem("Modificar Pedido");
		menuModificarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel.isShowing()) {
					contentPane.remove(panel);
				}
				
				contentPane.remove(etiqueta_fondo);

				// Establecimiento del panel de modificar pedido
				panel = new Modificar_Pedido();
				panel.setLocation(0,100);
				
				contentPane.add(panel);
				contentPane.add(etiqueta_fondo);
					
				contentPane.updateUI();
			}
		});
		
		menuGestionMaterial.add(menuModificarPedido);
		
		JMenuItem menuAdministrarStock = new JMenuItem("Administrar Stock");
		menuAdministrarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel.isShowing()) {
					contentPane.remove(panel);
				}
				
				contentPane.remove(etiqueta_fondo);

				// Establecimiento del panel de Administrar stock
				panel = new Administrar_Stock();
				panel.setLocation(0,100);
				
				contentPane.add(panel);
				contentPane.add(etiqueta_fondo);
					
				contentPane.updateUI();
			}
		});
		
		menuGestionMaterial.add(menuAdministrarStock);
		
		// Caracteristicas del frame
		setTitle("DentiApp perfil administrador");
		setResizable(false);
		
		setIconImage(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/diente.png")).getImage());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(735,500));
		setLocationRelativeTo(null);
		contentPane.setFocusable(true);
		
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	public static void main(String[] args) {
		Administrador administrador = new Administrador();
		administrador.setVisible(true);
	}
}