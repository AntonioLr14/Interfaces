package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;

import Controlador.BBDD;
import prueba.Campo_texto_theme;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Consultar_Historial_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private Campo_texto_theme tfDNI_NombreCompleto;
	private BBDD bbdd=new BBDD();
	private JTable consultar_historial;
	private JScrollPane scrollpanel;

	/**
	 * Create the panel.
	 */
	public Consultar_Historial_M() {
		setOpaque(false);
		
		setBounds(100, 100, 720, 500);
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		bbdd.conectar();
		
	    tfDNI_NombreCompleto = new Campo_texto_theme(20);
		tfDNI_NombreCompleto.setBounds(153, 84, 130, 30);
		add(tfDNI_NombreCompleto);
		
		JLabel lblDNI_NombreCompleto = new JLabel("DNI / Nombre completo");
		lblDNI_NombreCompleto.setBounds(153, 61, 130, 13);
		add(lblDNI_NombreCompleto);
		
		this.scrollpanel = new JScrollPane();
		
		this.scrollpanel.setBounds(64,141,452,152);
		this.scrollpanel.setBorder(new LineBorder(Color.black));
		this.scrollpanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.scrollpanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		
		this.consultar_historial = new JTable();
		
		this.consultar_historial.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		this.consultar_historial.setTableHeader(null);
		this.scrollpanel.setViewportView(consultar_historial);
		
		add(scrollpanel);
		
		BotonDentista btndntstConsultar = new BotonDentista();
		btndntstConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String consulta="SELECT * FROM dentiapp.citas where ID_Paciente=(select DNI_Usuario from dentiapp.usuario where dni_usuario='"+tfDNI_NombreCompleto.getText()+"' or concat(Nombre,' ',Apellidos)='"+tfDNI_NombreCompleto.getText()+"');";
	            
	            try {
					bbdd.SelectValor(consultar_historial, consulta);
					consultar_historial.setDefaultEditor(consultar_historial.getColumnClass(0), null);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		tfDNI_NombreCompleto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyCode() == KeyEvent.VK_ENTER) {
					btndntstConsultar.doClick();
			}
		}
		});
		btndntstConsultar.setText("Consultar");
		btndntstConsultar.setRadius(30);
		btndntstConsultar.setBorder(null);
		btndntstConsultar.setBounds(394, 84, 160, 30);
		add(btndntstConsultar);
		
		BotonDentista botonDentista = new BotonDentista();
		botonDentista.setText("<html><p align='center'>Generar<br>Informes</html>");
		botonDentista.setRadius(30);
		botonDentista.setBorder(null);
		botonDentista.setBounds(526, 216, 100, 35);
		add(botonDentista);

	}
}
