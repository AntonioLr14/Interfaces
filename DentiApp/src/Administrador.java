import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JDesktopPane;
import javax.swing.SwingConstants;

public class Administrador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrador frame = new Administrador();
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
	public Administrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 726, 510);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 106, 726, 354);
		panel.add(desktopPane);
		
		JButton btnInsertarUsuario = new JButton("");
		btnInsertarUsuario.setBorder(null);
		btnInsertarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Insertar_Usuario Insertar_Usuario =new Insertar_Usuario();
				desktopPane.add(Insertar_Usuario);
				Insertar_Usuario.setVisible(true);
				Insertar_Usuario.setLocation(0,0);
				try {
					Insertar_Usuario.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnInsertarUsuario.setIcon(new ImageIcon("C:\\Users\\Medac\\Desktop\\fotosinterfaces\\511506 1.png"));
		btnInsertarUsuario.setBounds(10, 26, 37, 35);
		panel.add(btnInsertarUsuario);
		
		JButton btnConsultarUsuario = new JButton("");
		btnConsultarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultar_Usuarios Consultar_Usuarios = new Consultar_Usuarios();
				desktopPane.add(Consultar_Usuarios);
				Consultar_Usuarios.setVisible(true);
				Consultar_Usuarios.setLocation(0,0);
				try {
					Consultar_Usuarios.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConsultarUsuario.setIcon(new ImageIcon("C:\\Users\\Medac\\Desktop\\fotosinterfaces\\6700170 1.png"));
		btnConsultarUsuario.setBounds(57, 26, 37, 35);
		panel.add(btnConsultarUsuario);
		
		JButton btnModificarUsuario = new JButton("");
		btnModificarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modificar_Usuario Modificar_Usuario =new Modificar_Usuario(); 
				desktopPane.add(Modificar_Usuario);
				Modificar_Usuario.setVisible(true);
				Modificar_Usuario.setLocation(0, 0);
				try {
					Modificar_Usuario.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		btnModificarUsuario.setIcon(new ImageIcon("C:\\Users\\Medac\\Desktop\\fotosinterfaces\\2521856 1.png"));
		btnModificarUsuario.setBounds(104, 26, 37, 35);
		panel.add(btnModificarUsuario);
		
		JButton btnAdministrarConsultas = new JButton("");
		btnAdministrarConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAdministrarConsultas.setIcon(new ImageIcon("C:\\Users\\Medac\\Desktop\\fotosinterfaces\\4419817 1.png"));
		btnAdministrarConsultas.setBounds(151, 26, 37, 35);
		panel.add(btnAdministrarConsultas);
		
		JButton btnAnyadirTratamiento = new JButton("");
		btnAnyadirTratamiento.setIcon(new ImageIcon("C:\\Users\\Medac\\Desktop\\fotosinterfaces\\3079219 1.png"));
		btnAnyadirTratamiento.setBounds(198, 26, 37, 35);
		panel.add(btnAnyadirTratamiento);
		
		JButton btnModificarTratamiento = new JButton("");
		btnModificarTratamiento.setIcon(new ImageIcon("C:\\Users\\Medac\\Desktop\\fotosinterfaces\\2950064 1.png"));
		btnModificarTratamiento.setBounds(245, 25, 37, 36);
		panel.add(btnModificarTratamiento);
		
		JButton btnInsertarEspecialidad = new JButton("");
		btnInsertarEspecialidad.setIcon(new ImageIcon("C:\\Users\\Medac\\Desktop\\fotosinterfaces\\doctor_icon_142653 1.png"));
		btnInsertarEspecialidad.setBounds(292, 25, 37, 36);
		panel.add(btnInsertarEspecialidad);
		
		JButton btnConsultarEspecialidad = new JButton("");
		btnConsultarEspecialidad.setIcon(new ImageIcon("C:\\Users\\Medac\\Desktop\\fotosinterfaces\\5393109 1.png"));
		btnConsultarEspecialidad.setBounds(339, 25, 37, 36);
		panel.add(btnConsultarEspecialidad);
		
		JButton btnModificarEspecialidad = new JButton("");
		btnModificarEspecialidad.setIcon(new ImageIcon("C:\\Users\\Medac\\Desktop\\fotosinterfaces\\refresh-doctor-flat-icon-vector-16269600-removebg-preview 1.png"));
		btnModificarEspecialidad.setBounds(386, 25, 37, 36);
		panel.add(btnModificarEspecialidad);
		
		JButton btnEliminarEspecialidad = new JButton("");
		btnEliminarEspecialidad.setIcon(new ImageIcon("C:\\Users\\Medac\\Desktop\\fotosinterfaces\\Sin título 1.png"));
		btnEliminarEspecialidad.setBounds(433, 25, 37, 36);
		panel.add(btnEliminarEspecialidad);
		
		JButton btnAdministrarFacturas = new JButton("");
		btnAdministrarFacturas.setIcon(new ImageIcon("C:\\Users\\Medac\\Desktop\\fotosinterfaces\\3358993 1.png"));
		btnAdministrarFacturas.setBounds(480, 24, 37, 37);
		panel.add(btnAdministrarFacturas);
		
		JButton btnCrearPedidos = new JButton("");
		btnCrearPedidos.setIcon(new ImageIcon("C:\\Users\\Medac\\Desktop\\fotosinterfaces\\4305318 2.png"));
		btnCrearPedidos.setBounds(527, 25, 37, 36);
		panel.add(btnCrearPedidos);
		
		JButton btnConsultarPedidos = new JButton("");
		btnConsultarPedidos.setIcon(new ImageIcon("C:\\Users\\Medac\\Desktop\\fotosinterfaces\\89760 2.png"));
		btnConsultarPedidos.setBounds(574, 26, 37, 35);
		panel.add(btnConsultarPedidos);
		
		JButton btnModificarPedido = new JButton("");
		btnModificarPedido.setIcon(new ImageIcon("C:\\Users\\Medac\\Desktop\\fotosinterfaces\\3624080 2.png"));
		btnModificarPedido.setBounds(621, 24, 37, 37);
		panel.add(btnModificarPedido);
		
		JButton btnAdministrarStock = new JButton("");
		btnAdministrarStock.setIcon(new ImageIcon("C:\\Users\\Medac\\Desktop\\fotosinterfaces\\1554570 2.png"));
		btnAdministrarStock.setBounds(668, 26, 37, 35);
		panel.add(btnAdministrarStock);
		
		JLabel lblNewLabel = new JLabel("Gestión de usuarios");
		lblNewLabel.setBounds(53, 72, 106, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" Gestión médica");
		lblNewLabel_1.setBounds(198, 72, 106, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gestión económica");
		lblNewLabel_2.setBounds(386, 72, 121, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gestión de material");
		lblNewLabel_3.setBounds(584, 72, 121, 14);
		panel.add(lblNewLabel_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 94, 695, 14);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(192, 24, 67, 37);
		panel.add(separator_1);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(286, 26, 67, 35);
		panel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(474, 26, 67, 35);
		panel.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(520, 26, 67, 35);
		panel.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(662, 26, 51, 35);
		panel.add(separator_5);
		
		
	}
}
