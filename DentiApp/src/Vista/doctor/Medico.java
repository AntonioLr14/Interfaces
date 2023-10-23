package Vista.doctor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class Medico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelprueba;
	private TextField tf;
	private JButton bt;
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

		panelprueba =new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 726, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JButton btnAnyadirTratamiento = new JButton("");
		btnAnyadirTratamiento.setToolTipText("Añadir Tratamiento");
		btnAnyadirTratamiento.setContentAreaFilled(false);
		btnAnyadirTratamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				
				panelprueba = new Anyadir_Tratamiento_M();
				panelprueba.setLocation(60,90);
				panelprueba.setOpaque(true);
			
				
				panel.add(panelprueba);
				panel.updateUI();
			}
		});
		btnAnyadirTratamiento.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/tratamiento (3).png")));
		btnAnyadirTratamiento.setBounds(81, 14, 44, 39);
		panel.add(btnAnyadirTratamiento);
		
		JButton btnModificarTratamiento = new JButton("");
		btnModificarTratamiento.setToolTipText("Modificar Tratamiento");
		btnModificarTratamiento.setContentAreaFilled(false);
		btnModificarTratamiento.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/reporte.png")));
		btnModificarTratamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				
				panelprueba = new Modificar_Tratamiento_M();
				panelprueba.setLocation(50,120);
				
				panel.add(panelprueba);
				panel.updateUI();
			}
		});
		btnModificarTratamiento.setBounds(149, 14, 44, 39);
		panel.add(btnModificarTratamiento);
		
		JButton btnConsultarHistorial = new JButton("");
		btnConsultarHistorial.setToolTipText("Consultar Historial");
		btnConsultarHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				
				panelprueba = new Consultar_Historial_M();
				panelprueba.setLocation(40,100);
				
				panel.add(panelprueba);
				panel.updateUI();
			}
		});
		btnConsultarHistorial.setContentAreaFilled(false);
		btnConsultarHistorial.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/historial_medico.png")));
		btnConsultarHistorial.setBounds(241, 14, 44, 39);
		panel.add(btnConsultarHistorial);
		
		JButton btnModificarOdontograma = new JButton("");
		btnModificarOdontograma.setToolTipText("Modificar Odontograma");
		btnModificarOdontograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				
				panelprueba = new Modificar_Odontograma_M();
				panelprueba.setLocation(25,120);
				
				panel.add(panelprueba);
				panel.updateUI();
			}
		});
		btnModificarOdontograma.setContentAreaFilled(false);
		btnModificarOdontograma.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/dientes_apinados.png")));
		btnModificarOdontograma.setBounds(311, 14, 44, 39);
		panel.add(btnModificarOdontograma);
		
		JButton btnSolicitarMaterial = new JButton("");
		btnSolicitarMaterial.setToolTipText("Solicitar Material");
		btnSolicitarMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				
				panelprueba = new Solicitar_Material_M();
				panelprueba.setLocation(70,100);
				
				panel.add(panelprueba);
				panel.updateUI();
			}
		});
		btnSolicitarMaterial.setContentAreaFilled(false);
		btnSolicitarMaterial.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/carpeta.png")));
		btnSolicitarMaterial.setBounds(536, 14, 44, 39);
		panel.add(btnSolicitarMaterial);
		
		JButton btnConsultarStock = new JButton("");
		btnConsultarStock.setToolTipText("Consultar Stock");
		btnConsultarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				
				panelprueba = new Consultar_Stock_M();
				panelprueba.setLocation(70,100);
				
				panel.add(panelprueba);
				panel.updateUI();
			}
		});
		btnConsultarStock.setContentAreaFilled(false);
		btnConsultarStock.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/cajas.png")));
		btnConsultarStock.setBounds(615, 14, 44, 39);
		panel.add(btnConsultarStock);
		
		JButton btnBuscarPacientes = new JButton("");
		btnBuscarPacientes.setToolTipText("Buscar Pacientes");
		btnBuscarPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				
				panelprueba = new Buscar_Pacientes_M();
				panelprueba.setLocation(25,100);
				
				panel.add(panelprueba);
				panel.updateUI();
			}
		});
		btnBuscarPacientes.setContentAreaFilled(false);
		btnBuscarPacientes.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/consultar_usuarios.png")));
		btnBuscarPacientes.setBounds(386, 14, 44, 39);
		panel.add(btnBuscarPacientes);
		
		JButton btnVisualizarAgenda = new JButton("");
		btnVisualizarAgenda.setToolTipText("Visualizar Agenda");
		btnVisualizarAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				
				panelprueba = new Visualizar_Agenda_M();
				panelprueba.setLocation(55,100);
				
				panel.add(panelprueba);
				panel.updateUI();
			}
		});
		btnVisualizarAgenda.setContentAreaFilled(false);
		btnVisualizarAgenda.setIcon(new ImageIcon(Medico.class.getResource("/Vista/imagenes/administrar_consultas.png")));
		btnVisualizarAgenda.setBounds(453, 14, 44, 39);
		panel.add(btnVisualizarAgenda);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(22, 92, 678, 36);
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
		
		JLabel lblNewLabel = new JLabel("Gestión de Tratamientos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(49, 67, 155, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gestión de Pacientes");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(310, 65, 120, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gestión de Material");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(523, 64, 155, 14);
		panel.add(lblNewLabel_2);
		

		
	}
}
