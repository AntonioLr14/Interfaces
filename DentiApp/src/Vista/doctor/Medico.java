package Vista.doctor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controlador.BBDD;
import Vista.Login_Inicio;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JPopupMenu;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Medico extends JFrame {

	// Atributos
	protected JPanel panel;
	protected JPanel panelprueba;
	protected JButton boton_anadir_tratamiento;
	protected JButton boton_modificar_tratamiento;
	protected JButton boton_consultar_historial;
	protected JButton boton_modificar_odontograma;
	protected JButton boton_buscar_pacientes;
	protected JButton boton_visualizar_agenda;
	protected JButton boton_solicitar_material;
	protected JButton boton_consultar_stock;
	protected JLabel etiqueta_gestion_tratamientos;
	protected JLabel etiqueta_gestion_pacientes;
	protected JLabel etiqueta_gestion_material;
	protected JPopupMenu popupMenu;
	protected JMenu menu_gestion_tratamientos;
	protected JMenu menu_gestion_pacientes;
	protected JMenu menu_gestion_material;
	protected JMenuItem opcion_anadir_tratamiento;
	protected JMenuItem opcion_modificar_tratamiento;
	protected JMenuItem opcion_consultar_historial;
	protected JMenuItem opcion_modificar_odontograma;
	protected JMenuItem opcion_buscar_pacientes;
	protected JMenuItem opcion_visualizar_agenda;
	protected JMenuItem opcion_solicitar_material;
	protected JMenuItem opcion_consultar_stock;
	protected JLabel etiqueta_fondo;
	protected BBDD dbconn;

	// Constructores
	public Medico() {
		
		try {
			this.dbconn = new BBDD();
			this.dbconn.conectar();
		}
		catch (Exception error) {
			
			JOptionPane.showMessageDialog(
				null,
				error.getMessage(),
				"Error en el inicio de seion del doctor",
				JOptionPane.ERROR_MESSAGE,
				null
			);
		}
		
		//Creacion de los paneles
		this.panel = new JPanel();
		this.panelprueba = new JPanel();
		
		this.panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.panel.setLayout(null);
		this.panel.setFocusable(true);
				
		//Creacion de los elementos gráficos
		this.etiqueta_fondo = new JLabel();
		
		this.etiqueta_fondo.setBounds(0, 0, 735, 500);
		this.etiqueta_fondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondomedico.png")));

		this.boton_anadir_tratamiento = new JButton();
		
		this.boton_anadir_tratamiento.setBounds(81, 14, 44, 39);
		this.boton_anadir_tratamiento.setContentAreaFilled(false);
		this.boton_anadir_tratamiento.setToolTipText("Añadir Tratamiento (A + T)");
		this.boton_anadir_tratamiento.setFocusable(false);
		
		this.boton_anadir_tratamiento.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/tratamiento (3).png")));

		this.boton_modificar_tratamiento = new JButton();

		this.boton_modificar_tratamiento.setBounds(149, 14, 44, 39);
		this.boton_modificar_tratamiento.setContentAreaFilled(false);
		this.boton_modificar_tratamiento.setToolTipText("Modificar Tratamiento (M + T)");
		this.boton_modificar_tratamiento.setFocusable(false);

		this.boton_modificar_tratamiento.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/reporte.png")));

		this.boton_consultar_historial = new JButton();

		this.boton_consultar_historial.setBounds(241, 14, 44, 39);
		this.boton_consultar_historial.setContentAreaFilled(false);
		this.boton_consultar_historial.setToolTipText("Consultar Historial (C + H)");
		this.boton_consultar_historial.setFocusable(false);
		
		this.boton_consultar_historial.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/historial_medico.png")));
		
		this.boton_modificar_odontograma = new JButton();

		this.boton_modificar_odontograma.setBounds(311, 14, 44, 39);
		this.boton_modificar_odontograma.setContentAreaFilled(false);
		this.boton_modificar_odontograma.setToolTipText("Modificar Odontograma (M + O)");
		this.boton_modificar_odontograma.setFocusable(false);

		this.boton_modificar_odontograma.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/dientes_apinados.png")));
		
		this.boton_buscar_pacientes = new JButton();
		
		this.boton_buscar_pacientes.setBounds(386, 14, 44, 39);
		this.boton_buscar_pacientes.setContentAreaFilled(false);
		this.boton_buscar_pacientes.setToolTipText("Buscar Pacientes (B + P)");
		this.boton_buscar_pacientes.setFocusable(false);
		
		this.boton_buscar_pacientes.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/consultar_usuarios.png")));

		this.boton_visualizar_agenda = new JButton();

		this.boton_visualizar_agenda.setBounds(453, 14, 44, 39);
		this.boton_visualizar_agenda.setContentAreaFilled(false);
		this.boton_visualizar_agenda.setToolTipText("Visualizar Agenda (V + A)");
		this.boton_visualizar_agenda.setFocusable(false);
		
		this.boton_visualizar_agenda.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/administrar_consultas.png")));

		this.boton_solicitar_material = new JButton();

		this.boton_solicitar_material.setBounds(536, 14, 44, 39);
		this.boton_solicitar_material.setContentAreaFilled(false);
		this.boton_solicitar_material.setToolTipText("Solicitar Material (S + M)");
		this.boton_solicitar_material.setFocusable(false);

		this.boton_solicitar_material.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/carpeta.png")));
		
		this.boton_consultar_stock = new JButton();

		this.boton_consultar_stock.setBounds(615, 14, 44, 39);
		this.boton_consultar_stock.setContentAreaFilled(false);
		this.boton_consultar_stock.setToolTipText("Consultar Stock (C + S)");
		this.boton_consultar_stock.setFocusable(false);
		
		this.boton_consultar_stock.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/cajas.png")));
				
		JSeparator separator = new JSeparator();

		separator.setBounds(21, 86, 678, 36);
		separator.setOrientation(SwingConstants.HORIZONTAL);
		separator.setBackground(Color.black);
		
		JSeparator separator_1 = new JSeparator();

		separator_1.setBounds(206, 14, 67, 45);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(Color.black);
		
		JSeparator separator_2 = new JSeparator();

		separator_2.setBounds(513, 14, 67, 45);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBackground(Color.black);
		
		this.etiqueta_gestion_tratamientos = new JLabel();
		
		this.etiqueta_gestion_tratamientos.setBounds(27, 60, 176, 14);
		this.etiqueta_gestion_tratamientos.setText("Gestión de Tratamientos");
		
		this.etiqueta_gestion_pacientes = new JLabel();
		
		this.etiqueta_gestion_pacientes.setBounds(295, 60, 151, 14);
		this.etiqueta_gestion_pacientes.setText("Gestión de Pacientes");
		
		this.etiqueta_gestion_material = new JLabel();
		
		this.etiqueta_gestion_material.setBounds(522, 58, 155, 14);
		this.etiqueta_gestion_material.setText("Gestión de Material");
						
		this.panel.add(this.boton_anadir_tratamiento);
		this.panel.add(this.boton_modificar_tratamiento);
		this.panel.add(this.boton_consultar_historial);
		this.panel.add(this.boton_modificar_odontograma);
		this.panel.add(this.boton_buscar_pacientes);
		this.panel.add(this.boton_visualizar_agenda);
		this.panel.add(this.boton_solicitar_material);
		this.panel.add(this.boton_consultar_stock);
		
		this.panel.add(separator);
		this.panel.add(separator_1);
		this.panel.add(separator_2);
		
		this.panel.add(this.etiqueta_gestion_tratamientos);
		this.panel.add(this.etiqueta_gestion_pacientes);
		this.panel.add(this.etiqueta_gestion_material);
		
		this.panel.add(this.etiqueta_fondo);
		
		setContentPane(this.panel);

		// Creacion del menu popup
		this.popupMenu = new JPopupMenu();

		this.menu_gestion_tratamientos = new JMenu();
		this.menu_gestion_tratamientos.setText("Gestión de Tratamiento");
		
		this.menu_gestion_pacientes = new JMenu();
		this.menu_gestion_pacientes.setText("Gestión de pacientes");
		
		this.menu_gestion_material = new JMenu();
		this.menu_gestion_material.setText("Gestión de Material");
		
		this.opcion_anadir_tratamiento = new JMenuItem();
		this.opcion_anadir_tratamiento.setText("Añadir Tratamiento");
		
		this.opcion_modificar_tratamiento = new JMenuItem();
		this.opcion_modificar_tratamiento.setText("Modificar Tratamiento");

		this.opcion_consultar_historial = new JMenuItem();
		this.opcion_consultar_historial.setText("Consultar Historial");

		this.opcion_modificar_odontograma = new JMenuItem();
		this.opcion_modificar_odontograma.setText("Modificar Odontograma");

		this.opcion_buscar_pacientes = new JMenuItem();
		this.opcion_buscar_pacientes.setText("Buscar Pacientes");

		this.opcion_visualizar_agenda = new JMenuItem();
		this.opcion_visualizar_agenda.setText("Visualizar Agenda");

		this.opcion_solicitar_material = new JMenuItem();
		this.opcion_solicitar_material.setText("Solicitar Material");

		this.opcion_consultar_stock = new JMenuItem();
		this.opcion_consultar_stock.setText("Consultar Stock");
				
		this.popupMenu.add(this.menu_gestion_tratamientos);
		this.popupMenu.add(this.menu_gestion_pacientes);
		this.popupMenu.add(this.menu_gestion_material);
		
		this.menu_gestion_tratamientos.add(this.opcion_anadir_tratamiento);
		this.menu_gestion_tratamientos.add(this.opcion_modificar_tratamiento);
		
		this.menu_gestion_pacientes.add(this.opcion_consultar_historial);
		this.menu_gestion_pacientes.add(this.opcion_modificar_odontograma);
		this.menu_gestion_pacientes.add(this.opcion_buscar_pacientes);
		this.menu_gestion_pacientes.add(this.opcion_visualizar_agenda);
		
		this.menu_gestion_material.add(this.opcion_solicitar_material);
		this.menu_gestion_material.add(this.opcion_consultar_stock);
		
		// Asignacion de los eventos
		
		// Establecimiento del panel de anadir tratamiento
		ActionListener anadir_tratamiento = (event) -> {
			
			if (this.panelprueba.isShowing()) {
				this.panel.remove(this.panelprueba);
			}
			
			this.panelprueba = new Anyadir_Tratamiento_M();
			this.panelprueba.setLocation(0,100);
			
			this.panel.add(this.panelprueba);
			this.panel.add(this.etiqueta_fondo);
			this.panel.updateUI();
		};
		
		// Establecimiento del panel de modificar tratamiento
		ActionListener modificar_tratamiento = (event) -> {
			
			if (this.panelprueba.isShowing()) {
				this.panel.remove(this.panelprueba);
			}
			
			try {
				this.panelprueba = new Modificar_Tratamiento_M();
			}
			catch (Exception error) {
				error.printStackTrace();
			}
			
			this.panelprueba.setLocation(0,100);
			
			this.panel.add(this.panelprueba);
			this.panel.add(this.etiqueta_fondo);
			this.panel.updateUI();
		};

		// Establecimiento del panel de consultar historial
		ActionListener consultar_historial = (event) -> {
			
			if (this.panelprueba.isShowing()) {
				this.panel.remove(this.panelprueba);
			}
			
			try {
				this.panelprueba = new Consultar_Historial_M();
			}
			catch (Exception error) {
				error.printStackTrace();
			}
			
			this.panelprueba.setLocation(0,100);
			
			this.panel.add(this.panelprueba);
			this.panel.add(this.etiqueta_fondo);
			this.panel.updateUI();
		};
		
		// Establecimiento del panel de modificar odontograma
		ActionListener modificar_odontograma = (event) -> {
			
			if (this.panelprueba.isShowing()) {
				this.panel.remove(this.panelprueba);
			}
			
			try {
				this.panelprueba = new Modificar_Odontograma_M();
			}
			catch (Exception error) {
				error.printStackTrace();
			}
			
			this.panelprueba.setLocation(0,100);
			
			this.panel.add(this.panelprueba);
			this.panel.add(this.etiqueta_fondo);
			this.panel.updateUI();
		};
		
		// Establecimiento del panel de buscar pacientes
		ActionListener buscar_pacientes = (event) -> {
			
			if (this.panelprueba.isShowing()) {
				this.panel.remove(this.panelprueba);
			}
			
			try {
				this.panelprueba = new Buscar_Pacientes_M();
			}
			catch (Exception error) {
				error.printStackTrace();
			}
			
			this.panelprueba.setLocation(0,100);
			
			this.panel.add(this.panelprueba);
			this.panel.add(this.etiqueta_fondo);
			this.panel.updateUI();
		};

		// Establecimiento del panel de visualizar agenda
		ActionListener visualizar_agenda = (event) -> {
			
			if (this.panelprueba.isShowing()) {
				this.panel.remove(this.panelprueba);
			}
			
			try {
				this.panelprueba = new Visualizar_Agenda_M();
			}
			catch (Exception error) {
				error.printStackTrace();
			}
			
			this.panelprueba.setLocation(0,100);
			
			this.panel.add(this.panelprueba);
			this.panel.add(this.etiqueta_fondo);
			this.panel.updateUI();
		};

		// Establecimiento del panel de solicitar material
		ActionListener solicitar_material = (event) -> {
			
			if (this.panelprueba.isShowing()) {
				this.panel.remove(this.panelprueba);
			}
			
			try {
				this.panelprueba = new Solicitar_Material_M();
			}
			catch (Exception error) {
				error.printStackTrace();
			}
			
			this.panelprueba.setLocation(0,100);
			
			this.panel.add(this.panelprueba);
			this.panel.add(this.etiqueta_fondo);
			this.panel.updateUI();
		};

		// Establecimiento del panel de consultar stock
		ActionListener consultar_stock = (event) -> {
			
			if (this.panelprueba.isShowing()) {
				this.panel.remove(this.panelprueba);
			}
			
			this.panelprueba = new Consultar_Stock_M();
			this.panelprueba.setLocation(0,100);
			
			this.panel.add(this.panelprueba);
			this.panel.add(this.etiqueta_fondo);
			this.panel.updateUI();
		};
		
		// Establecimiento de los eventos de raton al panel
		this.panel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent event) {
				
				// Establecimiento del menu popup
				if (event.getButton() == MouseEvent.BUTTON3) {
					popupMenu.show(panel,event.getX(),event.getY());
				}
				else {
					popupMenu.setVisible(false);
				}
			}
		});
		
		// Establecimiento de los eventos de teclado al panel
		this.panel.addKeyListener(new KeyAdapter() {
			
			protected ArrayList <Integer> combo = new ArrayList<>();
			
			@Override
			public void keyReleased(KeyEvent event) {
				combo.clear();
			}
			
			@Override
			public void keyPressed(KeyEvent event) {
				
				combo.add(event.getKeyCode());
				
				// Atajo de teclado para anadir tratamiento
				if(combo.contains(KeyEvent.VK_A) && combo.contains(KeyEvent.VK_T)) {

					boton_anadir_tratamiento.doClick();
					combo.clear();
				}
				
				// Atajo de teclado para modificar tratamiento
				if(combo.contains(KeyEvent.VK_M) && combo.contains(KeyEvent.VK_T)) {

					boton_modificar_tratamiento.doClick();
					combo.clear();
				}
				
				// Atajo de teclado para consultar historial
				if(combo.contains(KeyEvent.VK_C) && combo.contains(KeyEvent.VK_H)) {

					boton_consultar_historial.doClick();
					combo.clear();
				}
				
				// Atajo de teclado para modificar odontograma
				if(combo.contains(KeyEvent.VK_M) && combo.contains(KeyEvent.VK_O)) {

					boton_modificar_odontograma.doClick();
					combo.clear();
				}
				
				// Atajo de teclado para buscar pacientes
				if(combo.contains(KeyEvent.VK_B) && combo.contains(KeyEvent.VK_P)) {

					boton_buscar_pacientes.doClick();
					combo.clear();
				}
				
				// Atajo de teclado para visualizar agenda
				if(combo.contains(KeyEvent.VK_V) && combo.contains(KeyEvent.VK_A)) {

					boton_visualizar_agenda.doClick();
					combo.clear();
				}
				
				// Atajo de teclado para solicitar material
				if(combo.contains(KeyEvent.VK_S) && combo.contains(KeyEvent.VK_M)) {

					boton_solicitar_material.doClick();
					combo.clear();
				}
				
				// Atajo de teclado para consultar stock
				if(combo.contains(KeyEvent.VK_C) && combo.contains(KeyEvent.VK_S)) {

					boton_consultar_stock.doClick();
					combo.clear();
				}
			}
		});
		
		// Asignacion de los eventos
		this.opcion_anadir_tratamiento.addActionListener(anadir_tratamiento);
		this.opcion_modificar_tratamiento.addActionListener(modificar_tratamiento);
		this.opcion_consultar_historial.addActionListener(consultar_historial);
		this.opcion_modificar_odontograma.addActionListener(modificar_odontograma);
		this.opcion_buscar_pacientes.addActionListener(buscar_pacientes);
		this.opcion_visualizar_agenda.addActionListener(visualizar_agenda);
		this.opcion_solicitar_material.addActionListener(solicitar_material);
		this.opcion_consultar_stock.addActionListener(consultar_stock);
		
		this.boton_anadir_tratamiento.addActionListener(anadir_tratamiento);
		this.boton_modificar_tratamiento.addActionListener(modificar_tratamiento);
		this.boton_consultar_historial.addActionListener(consultar_historial);
		this.boton_modificar_odontograma.addActionListener(modificar_odontograma);
		this.boton_buscar_pacientes.addActionListener(buscar_pacientes);
		this.boton_visualizar_agenda.addActionListener(visualizar_agenda);
		this.boton_solicitar_material.addActionListener(solicitar_material);
		this.boton_consultar_stock.addActionListener(consultar_stock);

		//Características del frame
		setTitle("DentiApp perfil doctor");
		setResizable(false);

		setIconImage(Toolkit.getDefaultToolkit().getImage(Medico.class.getResource("/Vista/imagenes/diente.png")));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(735,500));
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		Medico medico = new Medico();
		medico.setVisible(true);
	}
}
