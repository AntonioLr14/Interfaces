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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnAnyadirTratamiento = new JButton("");
		btnAnyadirTratamiento.setContentAreaFilled(false);
		btnAnyadirTratamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			}
		});
		btnAnyadirTratamiento.setIcon(new ImageIcon(Medico.class.getResource("/Vista/tratamiento (2) 1.png")));
		btnAnyadirTratamiento.setBounds(80, 24, 44, 39);
		contentPane.add(btnAnyadirTratamiento);
		
		JButton btnModificarTratamiento = new JButton("");
		btnModificarTratamiento.setContentAreaFilled(false);
		btnModificarTratamiento.setIcon(new ImageIcon(Medico.class.getResource("/Vista/reporte 1.png")));
		btnModificarTratamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificarTratamiento.setBounds(191, 24, 44, 39);
		contentPane.add(btnModificarTratamiento);
		
		JButton btnConsultarHistorial = new JButton("");
		btnConsultarHistorial.setContentAreaFilled(false);
		btnConsultarHistorial.setIcon(new ImageIcon(Medico.class.getResource("/Vista/historial-medico (2) 1.png")));
		btnConsultarHistorial.setBounds(297, 24, 44, 39);
		contentPane.add(btnConsultarHistorial);
		
		JButton btnModificarOdontograma = new JButton("");
		btnModificarOdontograma.setContentAreaFilled(false);
		btnModificarOdontograma.setIcon(new ImageIcon(Medico.class.getResource("/Vista/dientes-apinados (1) 1.png")));
		btnModificarOdontograma.setBounds(401, 24, 44, 39);
		contentPane.add(btnModificarOdontograma);
		
		JButton btnSolicitarMaterial = new JButton("");
		btnSolicitarMaterial.setContentAreaFilled(false);
		btnSolicitarMaterial.setIcon(new ImageIcon(Medico.class.getResource("/Vista/carpeta 1.png")));
		btnSolicitarMaterial.setBounds(503, 24, 44, 39);
		contentPane.add(btnSolicitarMaterial);
		
		JButton btnConsultarStock = new JButton("");
		btnConsultarStock.setContentAreaFilled(false);
		btnConsultarStock.setIcon(new ImageIcon(Medico.class.getResource("/Vista/cajas 1.png")));
		btnConsultarStock.setBounds(604, 22, 44, 39);
		contentPane.add(btnConsultarStock);
		
		JButton btnBuscarPacientes = new JButton("");
		btnBuscarPacientes.setContentAreaFilled(false);
		btnBuscarPacientes.setIcon(new ImageIcon(Medico.class.getResource("/Vista/6700170 1.png")));
		btnBuscarPacientes.setBounds(694, 24, 44, 39);
		contentPane.add(btnBuscarPacientes);
		
		JButton btnVisualizarAgenda = new JButton("");
		btnVisualizarAgenda.setContentAreaFilled(false);
		btnVisualizarAgenda.setIcon(new ImageIcon(Medico.class.getResource("/Vista/4419817 1.png")));
		btnVisualizarAgenda.setBounds(779, 24, 44, 39);
		contentPane.add(btnVisualizarAgenda);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 92, 861, 36);
		contentPane.add(separator);
		
		Panel panel = new Panel();
		panel.setBounds(80, 123, 736, 317);
		contentPane.add(panel);
	}
}
