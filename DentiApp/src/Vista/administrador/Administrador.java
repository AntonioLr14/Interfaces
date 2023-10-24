package Vista.administrador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Administrador extends JFrame {

	// Atributos
	protected JPanel contentPane;
	protected JPanel panelprueba;

	// Constructores
	public Administrador() {
		
		// Creacion de los paneles
		contentPane = new JPanel();
		panelprueba = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(230, 247, 255));
		contentPane.setLayout(null);
		
		// Creacion de los elementos graficos
		JButton boton_insertar_usuarios = new JButton();
		
		boton_insertar_usuarios.setBounds(10, 25, 37, 35);
		boton_insertar_usuarios.setContentAreaFilled(false);
		boton_insertar_usuarios.setToolTipText("Insertar usuarios");

		boton_insertar_usuarios.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/insertar_usuarios.png")));

		JButton boton_consultar_usuarios = new JButton();
		
		boton_consultar_usuarios.setBounds(57, 25, 37, 35);
		boton_consultar_usuarios.setContentAreaFilled(false);
		boton_consultar_usuarios.setToolTipText("Consultar usuarios");
		
		boton_consultar_usuarios.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/consultar_usuarios.png")));
		
		JButton boton_modificar_usuarios = new JButton();
		
		boton_modificar_usuarios.setBounds(104, 25, 37, 35);
		boton_modificar_usuarios.setContentAreaFilled(false);
		boton_modificar_usuarios.setToolTipText("Modificar usuarios");
		
		boton_modificar_usuarios.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/modificar_usuarios.png")));

		JButton boton_administrar_consultas = new JButton();
		
		boton_administrar_consultas.setBounds(151, 25, 37, 35);
		boton_administrar_consultas.setContentAreaFilled(false);
		boton_administrar_consultas.setToolTipText("Administrar consultas");
		
		boton_administrar_consultas.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/administrar_consultas.png")));

		JButton boton_anadir_tratamientos = new JButton();
		
		boton_anadir_tratamientos.setBounds(198, 25, 37, 35);
		boton_anadir_tratamientos.setContentAreaFilled(false);
		boton_anadir_tratamientos.setToolTipText("Anadir tratamientos");
		
		boton_anadir_tratamientos.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/anadir_tratamientos.png")));
		
		JButton boton_modificar_tratamientos = new JButton();
		
		boton_modificar_tratamientos.setBounds(245, 25, 37, 36);
		boton_modificar_tratamientos.setContentAreaFilled(false);
		boton_modificar_tratamientos.setToolTipText("Modificar tratamientos");
		
		boton_modificar_tratamientos.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/modificar_tratamientos.png")));

		JButton boton_insertar_especialidad = new JButton();
		
		boton_insertar_especialidad.setBounds(293, 25, 37, 36);
		boton_insertar_especialidad.setContentAreaFilled(false);
		boton_insertar_especialidad.setToolTipText("Insertar especialidad");
		
		boton_insertar_especialidad.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/insertar_especialidad.png")));

		JButton boton_consultar_especialidad = new JButton();
		
		boton_consultar_especialidad.setBounds(340, 25, 37, 36);
		boton_consultar_especialidad.setContentAreaFilled(false);
		boton_consultar_especialidad.setToolTipText("Consultar especialidad");
		
		boton_consultar_especialidad.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/consultar_especialidad.png")));

		JButton boton_modificar_especialidad = new JButton();
		
		boton_modificar_especialidad.setBounds(387, 25, 37, 36);
		boton_modificar_especialidad.setContentAreaFilled(false);
		boton_modificar_especialidad.setToolTipText("Modificar especialidad");
		
		boton_modificar_especialidad.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/modificar_especialidad.png")));

		JButton boton_eliminar_especialidad = new JButton();
		
		boton_eliminar_especialidad.setBounds(434, 25, 37, 36);
		boton_eliminar_especialidad.setContentAreaFilled(false);
		boton_eliminar_especialidad.setToolTipText("Eliminar especialidad");
		
		boton_eliminar_especialidad.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/eliminar_especialidad.png")));

		JButton boton_administrar_facturas = new JButton();
		
		boton_administrar_facturas.setBounds(481, 25, 37, 37);
		boton_administrar_facturas.setContentAreaFilled(false);
		boton_administrar_facturas.setToolTipText("Administrar facturas");
		
		boton_administrar_facturas.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/administrar_facturas.png")));

		JButton boton_crear_pedidos = new JButton();
		
		boton_crear_pedidos.setBounds(528, 25, 37, 36);
		boton_crear_pedidos.setContentAreaFilled(false);
		boton_crear_pedidos.setToolTipText("Crear pedidos");
		
		boton_crear_pedidos.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/crear_pedidos.png")));
		
		JButton boton_consultar_pedidos = new JButton();
		
		boton_consultar_pedidos.setBounds(575, 25, 37, 35);
		boton_consultar_pedidos.setContentAreaFilled(false);
		boton_consultar_pedidos.setToolTipText("Consultar pedidos");
		
		boton_consultar_pedidos.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/consultar_pedidos.png")));

		JButton boton_modificar_pedidos = new JButton();
		
		boton_modificar_pedidos.setBounds(622, 25, 37, 37);
		boton_modificar_pedidos.setContentAreaFilled(false);
		boton_modificar_pedidos.setToolTipText("Modificar pedidos");
		
		boton_modificar_pedidos.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/modificar_pedidos.png")));

		JButton boton_administrar_stock = new JButton();
		
		boton_administrar_stock.setBounds(669, 25, 37, 35);
		boton_administrar_stock.setContentAreaFilled(false);
		boton_administrar_stock.setToolTipText("Administrar stock");
		
		boton_administrar_stock.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/administrar_stock.png")));
		
		JLabel etiqueta_gestion_de_usuarios = new JLabel("Gestión de usuarios");
		etiqueta_gestion_de_usuarios.setBounds(30, 78, 143, 14);
		
		JLabel etiqueta_gestion_medica = new JLabel(" Gestión médica");
		etiqueta_gestion_medica.setBounds(274, 78, 113, 14);
		
		JLabel etiqueta_gestion_economica = new JLabel("<html><p align='center'>Gestión<br>económica</html>");
		etiqueta_gestion_economica.setBounds(460, 70, 75, 36);
				
		JLabel etiqueta_gestion_de_material = new JLabel("Gestión de material");
		etiqueta_gestion_de_material.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta_gestion_de_material.setBounds(545, 78, 143, 14);
		
		JSeparator separator = new JSeparator();
		
		separator.setBounds(10, 110, 695, 2);
		separator.setOrientation(SwingConstants.HORIZONTAL);
		
		JSeparator separator_1 = new JSeparator();
		
		separator_1.setBounds(192, 25, 67, 35);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		
		JSeparator separator_2 = new JSeparator();
		
		separator_2.setBounds(287, 25, 67, 35);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		
		JSeparator separator_3 = new JSeparator();
		
		separator_3.setBounds(475, 25, 67, 35);
		separator_3.setOrientation(SwingConstants.VERTICAL);
		
		JSeparator separator_4 = new JSeparator();
		
		separator_4.setBounds(522, 25, 67, 35);
		separator_4.setOrientation(SwingConstants.VERTICAL);
		
		JSeparator separator_5 = new JSeparator();
		
		separator_5.setBounds(663, 25, 51, 35);
		separator_5.setOrientation(SwingConstants.VERTICAL);

		// Asignacion de los eventos
		boton_insertar_usuarios.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				contentPane.remove(panelprueba);
			}
			
			// Establecimiento del panel de insertar usuarios
			panelprueba = new Insertar_Usuario();
			panelprueba.setLocation(0,100);
			
			contentPane.add(panelprueba);
			contentPane.updateUI();
		});
				
		boton_consultar_usuarios.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				contentPane.remove(panelprueba);
			}
			
			// Establecimiento del panel de consultar usuarios
			panelprueba = new Consultar_Usuarios();
			panelprueba.setLocation(20,100);
			
			contentPane.add(panelprueba);
			contentPane.updateUI();
		});
				
		boton_modificar_usuarios.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				contentPane.remove(panelprueba);
			}
			
			// Establecimiento del panel de modificar usuarios
			panelprueba = new Modificar_Usuario();
			panelprueba.setLocation(0,100);
			
			contentPane.add(panelprueba);
			contentPane.updateUI();
		});
				
		boton_administrar_consultas.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				contentPane.remove(panelprueba);
			}
			
			// Establecimiento del panel de administrar consultas
			panelprueba = new Administrar_Consultas();
			panelprueba.setLocation(0,115);
			
			contentPane.add(panelprueba);
			contentPane.updateUI();
		});
		
		boton_anadir_tratamientos.addActionListener( (event) -> {

			if (panelprueba.isShowing()) {
				contentPane.remove(panelprueba);
			}
			
			// Establecimiento del panel de anadir tratamientos
			panelprueba = new Anyadir_Tratamiento();
			panelprueba.setLocation(0,100);
			
			contentPane.add(panelprueba);
			contentPane.updateUI();
		});
				
		boton_modificar_tratamientos.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				contentPane.remove(panelprueba);
			}
			
			// Establecimiento del panel de modificar tratamientos
			panelprueba = new Modificar_Tratamiento();
			panelprueba.setLocation(0,100);
			
			contentPane.add(panelprueba);
			contentPane.updateUI();
		});
				
		boton_insertar_especialidad.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				contentPane.remove(panelprueba);
			}
			
			// Establecimiento del panel de insertar especialidad
			panelprueba = new Insertar_Especialidad();
			panelprueba.setLocation(0,100);
			
			contentPane.add(panelprueba);
			contentPane.updateUI();
		});
				
		boton_consultar_especialidad.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				contentPane.remove(panelprueba);
			}
			
			// Establecimiento del panel de consultar especialidad
			panelprueba = new Consultar_Especialidad();
			panelprueba.setLocation(0,100);
			
			contentPane.add(panelprueba);
			contentPane.updateUI();
		});
				
		boton_modificar_especialidad.addActionListener( (event) -> {

			if (panelprueba.isShowing()) {
				contentPane.remove(panelprueba);
			}
			
			// Establecimiento del panel de modificar especialidad
			panelprueba = new Modificar_Especialidad();
			panelprueba.setLocation(0,100);
			
			contentPane.add(panelprueba);
			contentPane.updateUI();
		});
				
		boton_eliminar_especialidad.addActionListener( (event) -> {

			if (panelprueba.isShowing()) {
				contentPane.remove(panelprueba);
			}
			
			// Establecimiento del panel de eliminar especialidad
			panelprueba = new Eliminar_Especialidad();
			panelprueba.setLocation(0,0);
			
			contentPane.add(panelprueba);
			contentPane.updateUI();
		});
				
		boton_administrar_facturas.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				contentPane.remove(panelprueba);
			}
			
			// Establecimiento del panel de administrar facturas
			panelprueba = new Administrar_Facturas();
			panelprueba.setLocation(0,115);
			
			contentPane.add(panelprueba);
			contentPane.updateUI();
		});
				
		boton_crear_pedidos.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				contentPane.remove(panelprueba);
			}
			
			// Establecimiento del panel de crear pedidos
			panelprueba = new Crear_Pedidos();
			panelprueba.setLocation(0,100);
			
			contentPane.add(panelprueba);
			contentPane.updateUI();
		});
		
		boton_consultar_pedidos.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				contentPane.remove(panelprueba);
			}
			
			// Establecimiento del panel de consultar pedidos
			panelprueba = new Consultar_Pedidos();
			panelprueba.setLocation(0,100);
			
			contentPane.add(panelprueba);
			contentPane.updateUI();
		});
				
		boton_modificar_pedidos.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				contentPane.remove(panelprueba);
			}
			
			// Establecimiento del panel de modificar pedidos
			panelprueba = new Modificar_Pedido();
			panelprueba.setLocation(0,100);
			
			contentPane.add(panelprueba);
			contentPane.updateUI();
		});
				
		boton_administrar_stock.addActionListener( (event) -> {
			
			if (panelprueba.isShowing()) {
				contentPane.remove(panelprueba);
			}
			
			// Establecimiento del panel de administrar stock
			panelprueba = new Administrar_Stock();
			panelprueba.setLocation(0,115);
			
			contentPane.add(panelprueba);
			contentPane.updateUI();
		});
		
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
		
		setContentPane(contentPane);
		
		// Caracteristicas del frame
		setTitle("DentiApp perfil administrador");
		setIconImage(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/diente.png")).getImage());
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(735,500));
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		
		Administrador administrador = new Administrador();
		administrador.setVisible(true);
	}
}