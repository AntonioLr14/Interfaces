package Vista.doctor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.BBDD;
import Vista.Login_Inicio;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Toolkit;

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
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 726, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
				
		//Creacion de los elementos gráficos
		JButton btnAnyadirTratamiento = new JButton("");
		btnAnyadirTratamiento.setToolTipText("Añadir Tratamiento");
		btnAnyadirTratamiento.setContentAreaFilled(false);
		
		btnAnyadirTratamiento.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/tratamiento (3).png")));
		btnAnyadirTratamiento.setBounds(81, 14, 44, 39);
		panel.add(btnAnyadirTratamiento);
		
		JButton btnModificarTratamiento = new JButton("");
		btnModificarTratamiento.setToolTipText("Modificar Tratamiento");
		btnModificarTratamiento.setContentAreaFilled(false);
		btnModificarTratamiento.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/reporte.png")));
		btnModificarTratamiento.setBounds(149, 14, 44, 39);
		panel.add(btnModificarTratamiento);
		
		JButton btnConsultarHistorial = new JButton("");
		btnConsultarHistorial.setToolTipText("Consultar Historial");
		btnConsultarHistorial.setContentAreaFilled(false);
		btnConsultarHistorial.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/historial_medico.png")));
		btnConsultarHistorial.setBounds(241, 14, 44, 39);
		panel.add(btnConsultarHistorial);
		
		JButton btnModificarOdontograma = new JButton("");
		btnModificarOdontograma.setToolTipText("Modificar Odontograma");
		btnModificarOdontograma.setContentAreaFilled(false);
		btnModificarOdontograma.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/dientes_apinados.png")));
		btnModificarOdontograma.setBounds(311, 14, 44, 39);
		panel.add(btnModificarOdontograma);
		
		JButton btnSolicitarMaterial = new JButton("");
		btnSolicitarMaterial.setToolTipText("Solicitar Material");
		btnSolicitarMaterial.setContentAreaFilled(false);
		btnSolicitarMaterial.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/carpeta.png")));
		btnSolicitarMaterial.setBounds(536, 14, 44, 39);
		panel.add(btnSolicitarMaterial);
		
		JButton btnConsultarStock = new JButton("");
		btnConsultarStock.setToolTipText("Consultar Stock");
		btnConsultarStock.setContentAreaFilled(false);
		btnConsultarStock.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/cajas.png")));
		btnConsultarStock.setBounds(615, 14, 44, 39);
		panel.add(btnConsultarStock);
		
		JButton btnBuscarPacientes = new JButton("");
		btnBuscarPacientes.setToolTipText("Buscar Pacientes");
		btnBuscarPacientes.setContentAreaFilled(false);
		btnBuscarPacientes.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/consultar_usuarios.png")));
		btnBuscarPacientes.setBounds(386, 14, 44, 39);
		panel.add(btnBuscarPacientes);
		
		JButton btnVisualizarAgenda = new JButton("");
		btnVisualizarAgenda.setToolTipText("Visualizar Agenda");
		btnVisualizarAgenda.setContentAreaFilled(false);
		btnVisualizarAgenda.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/administrar_consultas.png")));
		btnVisualizarAgenda.setBounds(453, 14, 44, 39);
		panel.add(btnVisualizarAgenda);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(21, 86, 678, 36);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(206, 14, 67, 45);
		panel.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(new Color(0, 0, 0));
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBounds(513, 14, 67, 45);
		panel.add(separator_1_1);
		
		JLabel lblGestionTratamientos = new JLabel("Gestión de Tratamientos");
		lblGestionTratamientos.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionTratamientos.setBounds(48, 61, 155, 14);
		panel.add(lblGestionTratamientos);
		
		JLabel lblGestionPacientes = new JLabel("Gestión de Pacientes");
		lblGestionPacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionPacientes.setBounds(309, 59, 120, 14);
		panel.add(lblGestionPacientes);
		
		JLabel lblGestionMaterial = new JLabel("Gestión de Material");
		lblGestionMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionMaterial.setBounds(522, 58, 155, 14);
		panel.add(lblGestionMaterial);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoarriba.png")));
		lblFondo.setBounds(0, 0, 730, 135);
		panel.add(lblFondo);
		JLabel lblFondo1 = new JLabel("");
		lblFondo1.setBackground(new Color(0, 128, 255));
		lblFondo1.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoabajo.png")));
		lblFondo1.setBounds(0,20, 730, 527);
		panel.add(lblFondo1);
		
		// Asignacion de los eventos
		btnAnyadirTratamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFondo1.setVisible(false);
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				//Creacion del panel Anyadir_Tratamiento_M
				panelprueba = new Anyadir_Tratamiento_M();
				panelprueba.setLocation(0,100);
				panelprueba.setOpaque(true);
			
				
				panel.add(panelprueba);
				panel.updateUI();
			}
		});
		btnModificarTratamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFondo1.setVisible(false);
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				//Creacion del panel Modificar_Tratamiento_M
				panelprueba = new Modificar_Tratamiento_M();
				panelprueba.setLocation(0,100);
				
				panel.add(panelprueba);
				panel.updateUI();
			}
		});
		btnConsultarHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFondo1.setVisible(false);
				lblFondo1.setVisible(false);
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				//Creacion del panel Consultar_Historial_M
				panelprueba = new Consultar_Historial_M();
				panelprueba.setLocation(0,100);
				
				panel.add(panelprueba);
				panel.updateUI();
			}
		});
		btnModificarOdontograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFondo1.setVisible(false);
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				//Creacion del panel Modificar_Odontograma_M
				panelprueba = new Modificar_Odontograma_M();
				panelprueba.setLocation(0,100);
				
				panel.add(panelprueba);
				panel.updateUI();
			}
		});
		btnSolicitarMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFondo1.setVisible(false);
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				//Creacion del panel Solicitar_Material_M
				panelprueba = new Solicitar_Material_M();
				panelprueba.setLocation(0,100);
				
				panel.add(panelprueba);
				panel.updateUI();
			}
		});
		btnConsultarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFondo1.setVisible(false);
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				//Creacion del panel Consultar_Stock_M
				panelprueba = new Consultar_Stock_M();
				panelprueba.setLocation(0,100);
				
				panel.add(panelprueba);
				panel.updateUI();
			}
		});
		btnBuscarPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFondo1.setVisible(false);
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				//Creacion del panel Buscar_Pacientes_M
				panelprueba = new Buscar_Pacientes_M();
				panelprueba.setLocation(0,100);
				
				panel.add(panelprueba);
				panel.updateUI();
			}
		});
		btnVisualizarAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFondo1.setVisible(false);
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				//Creacion del panel Visualiar_Agenda_M
				panelprueba = new Visualizar_Agenda_M();
				panelprueba.setLocation(0,100);
				
				panel.add(panelprueba);
				panel.updateUI();
			}
		});
		

		//Características del frame
				setTitle("DentiApp perfil doctor");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 735, 500);
				setResizable(false);
				setLocationRelativeTo(null);
		//Introduccion del icono en la parte superior izquierda del frame
				setIconImage(Toolkit.getDefaultToolkit().getImage(Medico.class.getResource("/Vista/imagenes/diente.png")));
	}
}
