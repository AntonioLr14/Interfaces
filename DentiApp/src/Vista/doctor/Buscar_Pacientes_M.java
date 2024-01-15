package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;

import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;

import Controlador.BBDD;
import prueba.Campo_texto_theme;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Buscar_Pacientes_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private Campo_texto_theme tfDNI_NombreCompleto;
	private JTable table;
	public BBDD bbdd= new BBDD();

	/**
	 * Create the panel.
	 */
	public Buscar_Pacientes_M() {
		setOpaque(false);
		//Creamos panel principal
		setLayout(null);
		setBounds(100, 100, 720, 500);
		setBackground(new Color(255, 255, 255));
		bbdd.conectar();
		
		//Creamos los componentes del panel
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(82, 123, 432, 131);
		
		
		tfDNI_NombreCompleto = new Campo_texto_theme(20);
		tfDNI_NombreCompleto.setBounds(145, 77, 134, 28);
		
		JLabel lblDNI_NombreCompleto = new JLabel("DNI / Nombre completo");
		lblDNI_NombreCompleto.setBounds(145, 54, 135, 13);
		
		BotonDentista btndntstConsultar = new BotonDentista();
	
		btndntstConsultar.setText("Consultar");
		btndntstConsultar.setRadius(30);
		btndntstConsultar.setBorder(null);
		btndntstConsultar.setBounds(351, 77, 160, 30);
		
		BotonDentista botonDentista = new BotonDentista();
		botonDentista.setText("<html><p align='center'>Generar<br>Informes</html>");
		botonDentista.setRadius(30);
		botonDentista.setBorder(null);
		botonDentista.setBounds(524, 219, 100, 35);
		
		
		//Añadimos componentes al panel
		add(table);
		add(tfDNI_NombreCompleto);
		add(lblDNI_NombreCompleto);
		add(btndntstConsultar);
		add(botonDentista);

		
		//Metodos de la clase
		btndntstConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultar();
 
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

			

	}
	public void consultar() {
		String consulta="SELECT DNI_Usuario as DNI,correo, concat(nombre,' ',Apellidos) as 'Nombre Completo',Telefono FROM dentiapp.paciente inner join usuario on DNI = DNI_Usuario where concat(nombre,' ',Apellidos)='"+tfDNI_NombreCompleto.getText()+"' or DNI_Usuario='"+tfDNI_NombreCompleto.getText()+"';";
	            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	            try {
					bbdd.SelectValor(table, consulta);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	}
}
