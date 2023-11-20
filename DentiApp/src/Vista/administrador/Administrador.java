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
	protected JPopupMenu popupMenu;
	protected JMenu menu_gestion_usuarios;
	protected JMenu menu_gestion_medica;
	protected JMenuItem opcion_administrar_facturas;
	protected JMenu menu_gestion_material;
	protected JMenuItem opcion_insertar_usuarios;
	protected JMenuItem opcion_consultar_usuarios;
	protected JMenuItem opcion_modificar_usuarios;
	protected JMenuItem opcion_administrar_consultas;
	protected JMenuItem opcion_anadir_tratamientos;
	protected JMenuItem opcion_modificar_tratamientos;
	protected JMenuItem opcion_insertar_especialidad;
	protected JMenuItem opcion_consultar_especialidad;
	protected JMenuItem opcion_modificar_especialidad;
	protected JMenuItem opcion_eliminar_especialidad;
	protected JMenuItem opcion_crear_pedidos;
	protected JMenuItem opcion_consultar_pedidos;
	protected JMenuItem opcion_modificar_pedidos;
	protected JMenuItem opcion_administrar_stock;
	protected JLabel etiqueta_fondo;

	// Constructores
	public Administrador() {
		
		// Creacion de los paneles
		this.contentPane = new JPanel();
		this.panel = new JPanel();
		
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		this.contentPane.setFocusable(true);
		
		// Establecimiento del fondo del panel
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

		// Creacion del menu popup
		this.popupMenu = new JPopupMenu();
		
		this.menu_gestion_usuarios = new JMenu();
		this.menu_gestion_usuarios.setText("Gestión de Usuarios");
		
		this.menu_gestion_medica = new JMenu();
		this.menu_gestion_medica.setText("Gestion medica");
		
		this.opcion_administrar_facturas = new JMenuItem();
		this.opcion_administrar_facturas.setText("Administrar facturas");
		
		this.menu_gestion_material = new JMenu();
		this.menu_gestion_material.setText("Gestion de material");
				
		this.opcion_insertar_usuarios = new JMenuItem();
		this.opcion_insertar_usuarios.setText("Insertar usuarios");
		
		this.opcion_consultar_usuarios = new JMenuItem();
		this.opcion_consultar_usuarios.setText("Consultar usuarios");
		
		this.opcion_modificar_usuarios = new JMenuItem();
		this.opcion_modificar_usuarios.setText("Modificar usuarios");

		this.opcion_administrar_consultas = new JMenuItem();
		this.opcion_administrar_consultas.setText("Administrar consultas");

		this.opcion_anadir_tratamientos = new JMenuItem();
		this.opcion_anadir_tratamientos.setText("Anadir tratamientos");

		this.opcion_modificar_tratamientos = new JMenuItem();
		this.opcion_modificar_tratamientos.setText("Modificar tratamientos");

		this.opcion_insertar_especialidad = new JMenuItem();
		this.opcion_insertar_especialidad.setText("Insertar especialidad");

		this.opcion_consultar_especialidad = new JMenuItem();
		this.opcion_consultar_especialidad.setText("Consultar especialidad");

		this.opcion_modificar_especialidad = new JMenuItem();
		this.opcion_modificar_especialidad.setText("Modificar especialidad");

		this.opcion_eliminar_especialidad = new JMenuItem();
		this.opcion_eliminar_especialidad.setText("Eliminar especialidad");
		
		this.opcion_crear_pedidos = new JMenuItem();
		this.opcion_crear_pedidos.setText("Crear pedidos");

		this.opcion_consultar_pedidos = new JMenuItem();
		this.opcion_consultar_pedidos.setText("Consultar pedidos");

		this.opcion_modificar_pedidos = new JMenuItem();
		this.opcion_modificar_pedidos.setText("Modificar pedidos");

		this.opcion_administrar_stock = new JMenuItem();
		this.opcion_administrar_stock.setText("Administrar stock");
		
		this.popupMenu.add(menu_gestion_usuarios);
		this.popupMenu.add(menu_gestion_medica);
		this.popupMenu.add(opcion_administrar_facturas);
		this.popupMenu.add(menu_gestion_material);

		this.menu_gestion_usuarios.add(opcion_insertar_usuarios);
		this.menu_gestion_usuarios.add(opcion_consultar_usuarios);
		this.menu_gestion_usuarios.add(opcion_modificar_usuarios);
		this.menu_gestion_usuarios.add(opcion_administrar_consultas);
		
		this.menu_gestion_medica.add(opcion_anadir_tratamientos);
		this.menu_gestion_medica.add(opcion_modificar_tratamientos);
		this.menu_gestion_medica.add(opcion_insertar_especialidad);
		this.menu_gestion_medica.add(opcion_consultar_especialidad);
		this.menu_gestion_medica.add(opcion_modificar_especialidad);
		this.menu_gestion_medica.add(opcion_eliminar_especialidad);
		
		this.menu_gestion_material.add(opcion_crear_pedidos);
		this.menu_gestion_material.add(opcion_consultar_pedidos);
		this.menu_gestion_material.add(opcion_modificar_pedidos);
		this.menu_gestion_material.add(opcion_administrar_stock);
		
		// Establecimiento de los eventos
		
		// Establecimiento del panel de insertar usuarios
		ActionListener insertar_usuarios = (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);

			panel = new Insertar_Usuario();
			panel.setLocation(0,100);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);
			
			this.contentPane.updateUI();
		};
		
		// Establecimiento del panel de consultar usuarios
		ActionListener consultar_usuarios = (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			panel = new Consultar_Usuarios();
			panel.setLocation(0,100);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		};
		
		// Establecimiento del panel de modificar usuarios
		ActionListener modificar_usuarios = (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			panel = new Modificar_Usuario();
			panel.setLocation(0,100);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		};
		
		// Establecimiento del panel de administrar consultas
		ActionListener administrar_consultas = (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			panel = new Administrar_Consultas();
			panel.setLocation(0,115);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		};
		
		// Establecimiento del panel de anadir tratamientos
		ActionListener anadir_tratamientos = (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			panel = new Anyadir_Tratamiento();
			panel.setLocation(0,100);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		};
		
		// Establecimiento del panel de modificar tratamientos
		ActionListener modificar_tratamientos = (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			panel = new Modificar_Tratamiento();
			panel.setLocation(0,100);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		};
		
		// Establecimiento del panel de insertar especialidad
		ActionListener insertar_especialidad = (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			panel = new Insertar_Especialidad();
			panel.setLocation(0,100);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		};
		
		// Establecimiento del panel de consultar especialidad
		ActionListener consultar_especialidad = (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			panel = new Consultar_Especialidad();
			panel.setLocation(0,100);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		};
		
		// Establecimiento del panel de modificar especialidad
		ActionListener modificar_especialidad = (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			panel = new Modificar_Especialidad();
			panel.setLocation(0,100);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		};
		
		// Establecimiento del panel de eliminar especialidad
		ActionListener eliminar_especialidad = (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			panel = new Eliminar_Especialidad();
			panel.setLocation(0,100);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		};
		
		// Establecimiento del panel de administrar facturas
		ActionListener administrar_facturas = (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			panel = new Administrar_Facturas();
			panel.setLocation(0,115);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		};
		
		// Establecimiento del panel de crear pedidos
		ActionListener crear_pedidos = (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			panel = new Crear_Pedidos();
			panel.setLocation(0,100);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		};
		
		// Establecimiento del panel de consultar pedidos
		ActionListener consultar_pedidos = (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			panel = new Consultar_Pedidos();
			panel.setLocation(0,100);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		};
		
		// Establecimiento del panel de modificar pedidos
		ActionListener modificar_pedidos = (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			panel = new Modificar_Pedido();
			panel.setLocation(0,100);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		};
		
		// Establecimiento del panel de administrar stock
		ActionListener administrar_stock = (event) -> {
			
			if (panel.isShowing()) {
				this.contentPane.remove(panel);
			}
			
			this.contentPane.remove(etiqueta_fondo);
			
			panel = new Administrar_Stock();
			panel.setLocation(0,115);
			
			this.contentPane.add(panel);
			this.contentPane.add(etiqueta_fondo);

			this.contentPane.updateUI();
		};
		
		// Establecimiento de los eventos de raton al panel
		this.contentPane.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent event) {
				
				// Establecimiento del menu popup
				if (event.getButton() == MouseEvent.BUTTON3) {
					popupMenu.show(contentPane,event.getX(),event.getY());
				}
				else {
					popupMenu.setVisible(false);
				}
			}
		});
		
		// Establecimiento de los eventos de teclado al panel
		this.contentPane.addKeyListener(new KeyAdapter() {
			
			protected ArrayList<Integer> combo = new ArrayList<>();
			
			@Override
			public void keyReleased(KeyEvent event) {
				combo.clear();
			}
			
			@Override
			public void keyPressed(KeyEvent event) {
				
				combo.add(event.getKeyCode());
				
				// Atajo de teclado para insertar usuarios
				if(combo.contains(KeyEvent.VK_I) && combo.contains(KeyEvent.VK_U)) {
					
					boton_insertar_usuarios.doClick();
					combo.clear();
				}
				
				// Atajo de teclado para consultar usuarios
				if(combo.contains(KeyEvent.VK_C) && combo.contains(KeyEvent.VK_U)) {
					
					boton_consultar_usuarios.doClick();
					combo.clear();
				}
				
				// Atajo de teclado para modificar usuarios
				if(combo.contains(KeyEvent.VK_M) && combo.contains(KeyEvent.VK_U)) {
					
					boton_modificar_usuarios.doClick();
					combo.clear();
				}
				
				// Atajo de teclado para administrar consultas
				if(combo.contains(KeyEvent.VK_A) && combo.contains(KeyEvent.VK_C)) {
					
					boton_administrar_consultas.doClick();
					combo.clear();
				}
				
				// Atajo de teclado para anadir tratamientos
				if(combo.contains(KeyEvent.VK_A) && combo.contains(KeyEvent.VK_T)) {
					
					boton_anadir_tratamientos.doClick();
					combo.clear();
				}
				
				// Atajo de teclado para modificar tratamientos
				if(combo.contains(KeyEvent.VK_M) && combo.contains(KeyEvent.VK_T)) {
					
					boton_modificar_tratamientos.doClick();
					combo.clear();
				}
				
				// Atajo de teclado para insertar especialidad
				if(combo.contains(KeyEvent.VK_I) && combo.contains(KeyEvent.VK_E)) {
					
					boton_insertar_especialidad.doClick();
					combo.clear();
				}
				
				// Atajo de teclado para consultar especialidad
				if(combo.contains(KeyEvent.VK_C) && combo.contains(KeyEvent.VK_E)) {
					
					boton_consultar_especialidad.doClick();
					combo.clear();
				}
				
				// Atajo de teclado para modificar especialidad
				if(combo.contains(KeyEvent.VK_M) && combo.contains(KeyEvent.VK_E)) {
					
					boton_modificar_especialidad.doClick();
					combo.clear();
				}
				
				// Atajo de teclado para eliminar especialidad
				if(combo.contains(KeyEvent.VK_D) && combo.contains(KeyEvent.VK_E)) {
					
					boton_eliminar_especialidad.doClick();
					combo.clear();
				}
				
				// Atajo de teclado para administrar facturas
				if(combo.contains(KeyEvent.VK_A) && combo.contains(KeyEvent.VK_F)) {
					
					boton_administrar_facturas.doClick();
					combo.clear();
				}
				
				// Atajo de teclado para crear pedidos
				if(combo.contains(KeyEvent.VK_C) && combo.contains(KeyEvent.VK_P)) {
					
					boton_crear_pedidos.doClick();
					combo.clear();
				}
				
				// Atajo de teclado para consultar pedidos
				if(combo.contains(KeyEvent.VK_S) && combo.contains(KeyEvent.VK_P)) {
					
					boton_consultar_pedidos.doClick();
					combo.clear();
				}
				
				// Atajo de teclado para modificar pedidos
				if(combo.contains(KeyEvent.VK_M) && combo.contains(KeyEvent.VK_P)) {
					
					boton_modificar_pedidos.doClick();
					combo.clear();
				}
				
				// Atajo de teclado para administrar stock
				if(combo.contains(KeyEvent.VK_A) && combo.contains(KeyEvent.VK_S)) {
					
					boton_administrar_stock.doClick();
					combo.clear();
				}
			}
		});
		
		// Asignacion de los eventos
		opcion_insertar_usuarios.addActionListener(insertar_usuarios);
		opcion_consultar_usuarios.addActionListener(consultar_usuarios);
		opcion_modificar_usuarios.addActionListener(modificar_usuarios);
		opcion_administrar_consultas.addActionListener(administrar_consultas);
		opcion_anadir_tratamientos.addActionListener(anadir_tratamientos);
		opcion_modificar_tratamientos.addActionListener(modificar_tratamientos);
		opcion_insertar_especialidad.addActionListener(insertar_especialidad);
		opcion_consultar_especialidad.addActionListener(consultar_especialidad);
		opcion_modificar_especialidad.addActionListener(modificar_especialidad);
		opcion_eliminar_especialidad.addActionListener(eliminar_especialidad);
		opcion_administrar_facturas.addActionListener(administrar_facturas);
		opcion_crear_pedidos.addActionListener(crear_pedidos);
		opcion_consultar_pedidos.addActionListener(consultar_pedidos);
		opcion_modificar_pedidos.addActionListener(modificar_pedidos);
		opcion_administrar_stock.addActionListener(administrar_stock);
		
		this.boton_insertar_usuarios.addActionListener(insertar_usuarios);
		this.boton_consultar_usuarios.addActionListener(consultar_usuarios);
		this.boton_modificar_usuarios.addActionListener(modificar_usuarios);
		this.boton_administrar_consultas.addActionListener(administrar_consultas);
		this.boton_anadir_tratamientos.addActionListener(anadir_tratamientos);
		this.boton_modificar_tratamientos.addActionListener(modificar_tratamientos);
		this.boton_insertar_especialidad.addActionListener(insertar_especialidad);
		this.boton_consultar_especialidad.addActionListener(consultar_especialidad);
		this.boton_modificar_especialidad.addActionListener(modificar_especialidad);
		this.boton_eliminar_especialidad.addActionListener(eliminar_especialidad);
		this.boton_administrar_facturas.addActionListener(administrar_facturas);
		this.boton_crear_pedidos.addActionListener(crear_pedidos);
		this.boton_consultar_pedidos.addActionListener(consultar_pedidos);
		this.boton_modificar_pedidos.addActionListener(modificar_pedidos);
		this.boton_administrar_stock.addActionListener(administrar_stock);
				
		// Caracteristicas del frame
		setTitle("DentiApp perfil administrador");
		setResizable(false);
		
		setIconImage(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/diente.png")).getImage());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(735,500));
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		Administrador administrador = new Administrador();
		administrador.setVisible(true);
	}
}