package Vista.doctor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.BBDD;
import Vista.Login_Inicio;
import Vista.administrador.gestion_de_usuarios.Insertar_Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Medico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelprueba;
	private BBDD bbdd=new BBDD();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Medico frame = new Medico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public Medico() {
		
		//Creacion de los paneles
		panelprueba =new JPanel();
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 735,500);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
				
		//Creacion de los elementos gráficos
		JButton btnAnyadirTratamiento = new JButton("");
		btnAnyadirTratamiento.setToolTipText("Añadir Tratamiento (A+T)");
		btnAnyadirTratamiento.setContentAreaFilled(false);
		
		btnAnyadirTratamiento.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/tratamiento (3).png")));
		btnAnyadirTratamiento.setBounds(81, 14, 44, 39);
		
		JButton btnModificarTratamiento = new JButton("");
		btnModificarTratamiento.setToolTipText("Modificar Tratamiento (M+T)");
		btnModificarTratamiento.setContentAreaFilled(false);
		btnModificarTratamiento.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/reporte.png")));
		btnModificarTratamiento.setBounds(149, 14, 44, 39);
		
		JButton btnConsultarHistorial = new JButton("");
		btnConsultarHistorial.setToolTipText("Consultar Historial (C+H)");
		btnConsultarHistorial.setContentAreaFilled(false);
		btnConsultarHistorial.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/historial_medico.png")));
		btnConsultarHistorial.setBounds(241, 14, 44, 39);
		
		JButton btnModificarOdontograma = new JButton("");
		btnModificarOdontograma.setToolTipText("Modificar Odontograma (M+O)");
		btnModificarOdontograma.setContentAreaFilled(false);
		btnModificarOdontograma.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/dientes_apinados.png")));
		btnModificarOdontograma.setBounds(311, 14, 44, 39);
		
		JButton btnSolicitarMaterial = new JButton("");
		btnSolicitarMaterial.setToolTipText("Solicitar Material (S+M)");
		btnSolicitarMaterial.setContentAreaFilled(false);
		btnSolicitarMaterial.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/carpeta.png")));
		btnSolicitarMaterial.setBounds(536, 14, 44, 39);
		
		JButton btnConsultarStock = new JButton("");
		btnConsultarStock.setToolTipText("Consultar Stock (C+S)");
		btnConsultarStock.setContentAreaFilled(false);
		btnConsultarStock.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/cajas.png")));
		btnConsultarStock.setBounds(615, 14, 44, 39);
		
		JButton btnBuscarPacientes = new JButton("");
		btnBuscarPacientes.setToolTipText("Buscar Pacientes (B+P)");
		btnBuscarPacientes.setContentAreaFilled(false);
		btnBuscarPacientes.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/consultar_usuarios.png")));
		btnBuscarPacientes.setBounds(386, 14, 44, 39);
		
		JButton btnVisualizarAgenda = new JButton("");
		btnVisualizarAgenda.setToolTipText("Visualizar Agenda (V+A)");
		btnVisualizarAgenda.setContentAreaFilled(false);
		btnVisualizarAgenda.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/administrar_consultas.png")));
		btnVisualizarAgenda.setBounds(453, 14, 44, 39);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(21, 86, 678, 36);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(206, 14, 67, 45);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(new Color(0, 0, 0));
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBounds(513, 14, 67, 45);
		
		JLabel lblGestionTratamientos = new JLabel("Gestión de Tratamientos");
		lblGestionTratamientos.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionTratamientos.setBounds(48, 61, 155, 14);
		
		JLabel lblGestionPacientes = new JLabel("Gestión de Pacientes");
		lblGestionPacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionPacientes.setBounds(309, 59, 120, 14);
		
		JLabel lblGestionMaterial = new JLabel("Gestión de Material");
		lblGestionMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionMaterial.setBounds(522, 58, 155, 14);
		
		JLabel etiqueta_fondo = new JLabel("");
		etiqueta_fondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondomedico.png")));
		etiqueta_fondo.setBounds(0, 0, 735, 500);
		
		JPopupMenu popupMenu = new JPopupMenu();
		
		
		//Introudcion de la elementos graficos en el panel
		panel.add(btnAnyadirTratamiento);
		panel.add(btnModificarTratamiento);
		panel.add(btnConsultarHistorial);
		panel.add(btnModificarOdontograma);
		panel.add(btnSolicitarMaterial);
		panel.add(btnConsultarStock);
		panel.add(btnBuscarPacientes);
		panel.add(btnVisualizarAgenda);
		panel.add(separator);
		panel.add(separator_1);
		panel.add(separator_1_1);
		panel.add(lblGestionTratamientos);
		panel.add(lblGestionPacientes);
		panel.add(lblGestionMaterial);
		panel.add(etiqueta_fondo);
		addPopup(etiqueta_fondo, popupMenu);

			//Declaracion de eventos
		JMenu menuGestionTratamiento = new JMenu("Gestión de Tratamiento");
		popupMenu.add(menuGestionTratamiento);
		
		JMenuItem menuAnyadirTratamiento = new JMenuItem("Añadir Tratamiento");
		menuAnyadirTratamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				//Creacion del panel Anyadir_Tratamiento_M
				panelprueba = new Anyadir_Tratamiento_M();
				panelprueba.setLocation(0,100);
				
				panel.add(panelprueba);
				panel.add(etiqueta_fondo);
				panel.updateUI();
			}
		});
		menuGestionTratamiento.add(menuAnyadirTratamiento);
		
		JMenuItem menuModificarTratamiento = new JMenuItem("Modificar Tratamiento");
		menuModificarTratamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				//Creacion del panel Modificar_Tratamiento_M
				panelprueba = new Modificar_Tratamiento_M();
				panelprueba.setLocation(0,100);
				
				panel.add(panelprueba);
				panel.add(etiqueta_fondo);
				panel.updateUI();
			}
		});
		menuGestionTratamiento.add(menuModificarTratamiento);
		
		JMenu menuGestionPacientes = new JMenu("Gestión de pacientes");
		popupMenu.add(menuGestionPacientes);
		
		JMenuItem menuConsultarHistorial = new JMenuItem("Consultar Historial");
		menuConsultarHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				//Creacion del panel Consultar_Historial_M
				panelprueba = new Consultar_Historial_M();
				panelprueba.setLocation(0,100);
				
				panel.add(panelprueba);
				panel.add(etiqueta_fondo);
				panel.updateUI();
			}
		});
		menuGestionPacientes.add(menuConsultarHistorial);
		
		JMenuItem menuModificarOdontograma = new JMenuItem("Modificar Odontograma");
		menuModificarOdontograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				//Creacion del panel Modificar_Odontograma_M
				panelprueba = new Modificar_Odontograma_M();
				panelprueba.setLocation(0,100);
				
				panel.add(panelprueba);
				panel.add(etiqueta_fondo);
				panel.updateUI();
			}
		});
		menuGestionPacientes.add(menuModificarOdontograma);
		
		JMenuItem menuBuscarPacientes = new JMenuItem("Buscar Pacientes");
		menuBuscarPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				//Creacion del panel Buscar_Pacientes_M
				panelprueba = new Buscar_Pacientes_M();
				panelprueba.setLocation(0,100);
				
				panel.add(panelprueba);
				panel.add(etiqueta_fondo);
				panel.updateUI();
			}
		});
		menuGestionPacientes.add(menuBuscarPacientes);
		
		JMenuItem menuVisualizarAgenda = new JMenuItem("Visualizar Agenda");
		menuVisualizarAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				//Creacion del panel Visualizar_Agenda_M
				panelprueba = new Visualizar_Agenda_M();
				panelprueba.setLocation(0,100);
				
				panel.add(panelprueba);
				panel.add(etiqueta_fondo);
				panel.updateUI();
			}
		});
		menuGestionPacientes.add(menuVisualizarAgenda);
		
		JMenu menuGestionMaterial = new JMenu("Gestión de Material");
		popupMenu.add(menuGestionMaterial);
		
		JMenuItem menuSolicitarMaterial = new JMenuItem("Solicitar Material");
		menuSolicitarMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				//Creacion del panel Solicitar_Material_M
				panelprueba = new Solicitar_Material_M();
				panelprueba.setLocation(0,100);
				
				panel.add(panelprueba);
				panel.add(etiqueta_fondo);
				panel.updateUI();
			}
		});
		menuGestionMaterial.add(menuSolicitarMaterial);
		
		JMenuItem menuConsultarStock = new JMenuItem("Consultar Stock");
		menuConsultarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				//Creacion del panel Consultar_Stock_M
				panelprueba = new Consultar_Stock_M();
				panelprueba.setLocation(0,100);
				
				panel.add(panelprueba);
				panel.add(etiqueta_fondo);
				panel.updateUI();
			}
		});
		menuGestionMaterial.add(menuConsultarStock);
		
		// Asignacion de los eventos
		btnAnyadirTratamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				//Creacion del panel Anyadir_Tratamiento_M
				panelprueba = new Anyadir_Tratamiento_M();
				panelprueba.setLocation(0,100);
			
				
				panel.add(panelprueba);
				panel.add(etiqueta_fondo);
				panel.updateUI();
			}
		});
		btnModificarTratamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				//Creacion del panel Modificar_Tratamiento_M
				panelprueba = new Modificar_Tratamiento_M();
				panelprueba.setLocation(0,100);
				
				panel.add(panelprueba);
				panel.add(etiqueta_fondo);
				panel.updateUI();
			}
		});
		btnConsultarHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				//Creacion del panel Consultar_Historial_M
				panelprueba = new Consultar_Historial_M();
				panelprueba.setLocation(0,100);
				
				panel.add(panelprueba);
				panel.add(etiqueta_fondo);
				panel.updateUI();
			}
		});
		btnModificarOdontograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				//Creacion del panel Modificar_Odontograma_M
				panelprueba = new Modificar_Odontograma_M();
				panelprueba.setLocation(0,100);
				
				panel.add(panelprueba);
				panel.add(etiqueta_fondo);
				panel.updateUI();
			}
		});
		btnSolicitarMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				//Creacion del panel Solicitar_Material_M
				panelprueba = new Solicitar_Material_M();
				panelprueba.setLocation(0,100);
				
				panel.add(panelprueba);
				panel.add(etiqueta_fondo);
				panel.updateUI();
			}
		});
		btnConsultarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				//Creacion del panel Consultar_Stock_M
				panelprueba = new Consultar_Stock_M();
				panelprueba.setLocation(0,100);
				
				panel.add(panelprueba);
				panel.add(etiqueta_fondo);
				panel.updateUI();
			}
		});
		btnBuscarPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				//Creacion del panel Buscar_Pacientes_M
				panelprueba = new Buscar_Pacientes_M();
				panelprueba.setLocation(0,100);
				
				panel.add(panelprueba);
				panel.add(etiqueta_fondo);
				panel.updateUI();
			}
		});
		btnVisualizarAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				//Creacion del panel Visualiar_Agenda_M
				panelprueba = new Visualizar_Agenda_M();
				panelprueba.setLocation(0,100);
				
				panel.add(panelprueba);
				panel.add(etiqueta_fondo);
				panel.updateUI();
			}
		});
		panel.addKeyListener(new KeyAdapter() {
			private ArrayList <Integer> combo=new ArrayList<>();
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

		
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				combo.add(e.getKeyCode());
				if(combo.contains(KeyEvent.VK_A)&&combo.contains(KeyEvent.VK_T)) {

						if (panelprueba.isShowing()) {
							panel.remove(panelprueba);
						}
						panel.remove(etiqueta_fondo);
						//Creacion del panel Anyadir_Tratamiento_M
						panelprueba = new Anyadir_Tratamiento_M();
						panelprueba.setLocation(0,100);
						
						panel.add(panelprueba);
						panel.add(etiqueta_fondo);
						panel.updateUI();
						combo.clear();
					}
				if(combo.contains(KeyEvent.VK_M)&&combo.contains(KeyEvent.VK_T)) {

					if (panelprueba.isShowing()) {
						panel.remove(panelprueba);
					}
					panel.remove(etiqueta_fondo);
					//Creacion del panel Modificar_Tratamiento_M
					panelprueba = new Modificar_Tratamiento_M();
					panelprueba.setLocation(0,100);
					
					panel.add(panelprueba);
					panel.add(etiqueta_fondo);
					panel.updateUI();
					combo.clear();
				}
				if(combo.contains(KeyEvent.VK_C)&&combo.contains(KeyEvent.VK_H)) {

					if (panelprueba.isShowing()) {
						panel.remove(panelprueba);
					}
					panel.remove(etiqueta_fondo);
					//Creacion del panel Consultar_Historial_M
					panelprueba = new Consultar_Historial_M();
					panelprueba.setLocation(0,100);
					
					panel.add(panelprueba);
					panel.add(etiqueta_fondo);
					panel.updateUI();
					combo.clear();
				}
				if(combo.contains(KeyEvent.VK_M)&&combo.contains(KeyEvent.VK_O)) {

					if (panelprueba.isShowing()) {
						panel.remove(panelprueba);
					}
					panel.remove(etiqueta_fondo);
					//Creacion del panel Modificar_Odontograma_M
					panelprueba = new Modificar_Odontograma_M();
					panelprueba.setLocation(0,100);
					
					panel.add(panelprueba);
					panel.add(etiqueta_fondo);
					panel.updateUI();
					combo.clear();
				}
				if(combo.contains(KeyEvent.VK_B)&&combo.contains(KeyEvent.VK_P)) {

					if (panelprueba.isShowing()) {
						panel.remove(panelprueba);
					}
					panel.remove(etiqueta_fondo);
					//Creacion del panel Buscar_Pacientes_M
					panelprueba = new Buscar_Pacientes_M();
					panelprueba.setLocation(0,100);
					
					panel.add(panelprueba);
					panel.add(etiqueta_fondo);
					panel.updateUI();
					combo.clear();
				}
				if(combo.contains(KeyEvent.VK_V)&&combo.contains(KeyEvent.VK_A)) {

					if (panelprueba.isShowing()) {
						panel.remove(panelprueba);
					}
					panel.remove(etiqueta_fondo);
					//Creacion del panel Visualizar_Agenda_M
					panelprueba = new Visualizar_Agenda_M();
					panelprueba.setLocation(0,100);
					
					panel.add(panelprueba);
					panel.add(etiqueta_fondo);
					panel.updateUI();
					combo.clear();
				}
				if(combo.contains(KeyEvent.VK_S)&&combo.contains(KeyEvent.VK_M)) {

					if (panelprueba.isShowing()) {
						panel.remove(panelprueba);
					}
					panel.remove(etiqueta_fondo);
					//Creacion del panel Solicitar_Material_M
					panelprueba = new Solicitar_Material_M();
					panelprueba.setLocation(0,100);
					
					panel.add(panelprueba);
					panel.add(etiqueta_fondo);
					panel.updateUI();
					combo.clear();
				}
				if(combo.contains(KeyEvent.VK_C)&&combo.contains(KeyEvent.VK_S)) {

					if (panelprueba.isShowing()) {
						panel.remove(panelprueba);
					}
					panel.remove(etiqueta_fondo);
					//Creacion del panel Consultar_Stock_M
					panelprueba = new Consultar_Stock_M();
					panelprueba.setLocation(0,100);
					
					panel.add(panelprueba);
					panel.add(etiqueta_fondo);
					panel.updateUI();
					combo.clear();
				}
			}
			
		});

		//Características del frame
				setTitle("DentiApp perfil doctor");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 735, 500);
				setResizable(false);
				setLocationRelativeTo(null);
				panel.setFocusable(true);
		//Introduccion del icono en la parte superior izquierda del frame
				setIconImage(Toolkit.getDefaultToolkit().getImage(Medico.class.getResource("/Vista/imagenes/diente.png")));
	}
	//Creación de un método donde mostramos un menú con diferentes acciones
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
}
