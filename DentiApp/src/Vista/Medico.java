package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Panel;

public class Medico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelprueba;

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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 726, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JButton btnAnyadirTratamiento = new JButton("");
		btnAnyadirTratamiento.setContentAreaFilled(false);
		btnAnyadirTratamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				
				panelprueba = new Anyadir_Tratamiento_M();
				panelprueba.setLocation(25,120);
				
				panel.add(panelprueba);
				panel.updateUI();
			}
		});
		btnAnyadirTratamiento.setIcon(new ImageIcon(Medico.class.getResource("/Vista/tratamiento (2) 1.png")));
		btnAnyadirTratamiento.setBounds(80, 11, 44, 39);
		panel.add(btnAnyadirTratamiento);
		
		JButton btnModificarTratamiento = new JButton("");
		btnModificarTratamiento.setContentAreaFilled(false);
		btnModificarTratamiento.setIcon(new ImageIcon(Medico.class.getResource("/Vista/reporte 1.png")));
		btnModificarTratamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				
				panelprueba = new Modificar_Tratamiento_M();
				panelprueba.setLocation(25,120);
				
				panel.add(panelprueba);
				panel.updateUI();
			}
		});
		btnModificarTratamiento.setBounds(148, 11, 44, 39);
		panel.add(btnModificarTratamiento);
		
		JButton btnConsultarHistorial = new JButton("");
		btnConsultarHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				
				panelprueba = new Consultar_Historial_M();
				panelprueba.setLocation(25,120);
				
				panel.add(panelprueba);
				panel.updateUI();
			}
		});
		btnConsultarHistorial.setContentAreaFilled(false);
		btnConsultarHistorial.setIcon(new ImageIcon(Medico.class.getResource("/Vista/historial-medico (2) 1.png")));
		btnConsultarHistorial.setBounds(222, 11, 44, 39);
		panel.add(btnConsultarHistorial);
		
		JButton btnModificarOdontograma = new JButton("");
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
		btnModificarOdontograma.setIcon(new ImageIcon(Medico.class.getResource("/Vista/dientes-apinados (1) 1.png")));
		btnModificarOdontograma.setBounds(299, 11, 44, 39);
		panel.add(btnModificarOdontograma);
		
		JButton btnSolicitarMaterial = new JButton("");
		btnSolicitarMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				
				panelprueba = new Solicitar_Material_M();
				panelprueba.setLocation(25,120);
				
				panel.add(panelprueba);
				panel.updateUI();
			}
		});
		btnSolicitarMaterial.setContentAreaFilled(false);
		btnSolicitarMaterial.setIcon(new ImageIcon(Medico.class.getResource("/Vista/carpeta 1.png")));
		btnSolicitarMaterial.setBounds(385, 11, 44, 39);
		panel.add(btnSolicitarMaterial);
		
		JButton btnConsultarStock = new JButton("");
		btnConsultarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				
				panelprueba = new Consultar_Stock_M();
				panelprueba.setLocation(25,120);
				
				panel.add(panelprueba);
				panel.updateUI();
			}
		});
		btnConsultarStock.setContentAreaFilled(false);
		btnConsultarStock.setIcon(new ImageIcon(Medico.class.getResource("/Vista/cajas 1.png")));
		btnConsultarStock.setBounds(464, 11, 44, 39);
		panel.add(btnConsultarStock);
		
		JButton btnBuscarPacientes = new JButton("");
		btnBuscarPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				
				panelprueba = new Buscar_Pacientes_M();
				panelprueba.setLocation(25,120);
				
				panel.add(panelprueba);
				panel.updateUI();
			}
		});
		btnBuscarPacientes.setContentAreaFilled(false);
		btnBuscarPacientes.setIcon(new ImageIcon(Medico.class.getResource("/Vista/6700170 1.png")));
		btnBuscarPacientes.setBounds(547, 11, 44, 39);
		panel.add(btnBuscarPacientes);
		
		JButton btnVisualizarAgenda = new JButton("");
		btnVisualizarAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (panelprueba.isShowing()) {
					panel.remove(panelprueba);
				}
				
				panelprueba = new Visualizar_Agenda_M();
				panelprueba.setLocation(25,120);
				
				panel.add(panelprueba);
				panel.updateUI();
			}
		});
		btnVisualizarAgenda.setContentAreaFilled(false);
		btnVisualizarAgenda.setIcon(new ImageIcon(Medico.class.getResource("/Vista/4419817 1.png")));
		btnVisualizarAgenda.setBounds(614, 11, 44, 39);
		panel.add(btnVisualizarAgenda);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 92, 861, 36);
		panel.add(separator);
	}
}
