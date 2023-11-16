package Vista.doctor;

import javax.swing.JPanel;
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
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Consultar_Historial_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private Campo_texto_theme tfDNI_NombreCompleto;
	private BBDD bbdd=new BBDD();
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Consultar_Historial_M() {
		setBounds(100, 100, 720, 500);
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		
	    tfDNI_NombreCompleto = new Campo_texto_theme(20);
		tfDNI_NombreCompleto.setBounds(153, 84, 130, 30);
		add(tfDNI_NombreCompleto);
		
		JLabel lblDNI_NombreCompleto = new JLabel("DNI / Nombre completo");
		lblDNI_NombreCompleto.setBounds(153, 61, 130, 13);
		add(lblDNI_NombreCompleto);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(64, 141, 452, 152);
		add(table);
		
		BotonDentista btndntstConsultar = new BotonDentista();
		btndntstConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String consulta="SELECT * FROM dentiapp.citas where ID_Paciente=(select dni from dentiapp.paciente where dni='"+tfDNI_NombreCompleto.getText()+"' or Nombre='"+tfDNI_NombreCompleto.getText()+"');";
	            
	            try {
					bbdd.SelectValor(table, consulta);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoabajo.png")));
		lblFondo.setBounds(0, -81, 728, 527);
		add(lblFondo);

	}
}
