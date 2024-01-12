package Vista.doctor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Vista.Login_Inicio;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import prueba.Campo_texto_editable_theme;
import prueba.Campo_texto_theme;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import botonDentista.BotonDentista;
import java.awt.Color;
import javax.swing.border.LineBorder;

import Controlador.BBDD;
import java.awt.Font;

public class Odontograma extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static String id ="";
	private static String DNI="";
	private JTable table;
	private BBDD bbdd=new BBDD();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Odontograma dialog = new Odontograma(id,DNI);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Odontograma(String id, String DNI_Usuario) {
		this.id=id;
		this.DNI=DNI_Usuario;
		setBounds(100, 100, 483, 330);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		bbdd.conectar();
		
		JLabel lblNewLabel = new JLabel("Id:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(118, 11, 73, 28);
		contentPanel.add(lblNewLabel);
		
		Campo_texto_theme campo_texto_theme_4 = new Campo_texto_theme(20);
		campo_texto_theme_4.setHorizontalAlignment(SwingConstants.CENTER);
		campo_texto_theme_4.setText(id);
		campo_texto_theme_4.setEditable(false);
		campo_texto_theme_4.setBackground(new Color(0, 128, 255));
		campo_texto_theme_4.setBounds(204, 11, 78, 28);
		contentPanel.add(campo_texto_theme_4);
		
		BotonDentista btndntstAceptar = new BotonDentista();
		btndntstAceptar.setBorder(null);
		btndntstAceptar.setFocusable(false);
		
		btndntstAceptar.setText("Aceptar");
		btndntstAceptar.setRadius(30);
		btndntstAceptar.setBounds(356, 202, 89, 32);
		contentPanel.add(btndntstAceptar);
		
		JLabel lblarriba = new JLabel("");
		lblarriba.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblarriba.setOpaque(true);
		lblarriba.setBackground(new Color(255, 255, 255));
		lblarriba.setBounds(27, 75, 42, 14);
		contentPanel.add(lblarriba);
		
		JLabel lblizq = new JLabel("");
		lblizq.setOpaque(true);
		lblizq.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblizq.setBackground(Color.WHITE);
		lblizq.setBounds(27, 88, 14, 22);
		contentPanel.add(lblizq);
		
		JLabel lblder = new JLabel("");
		lblder.setOpaque(true);
		lblder.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblder.setBackground(Color.WHITE);
		lblder.setBounds(55, 88, 14, 22);
		contentPanel.add(lblder);
		
		JLabel lblabajo = new JLabel("");
		lblabajo.setOpaque(true);
		lblabajo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblabajo.setBackground(Color.WHITE);
		lblabajo.setBounds(27, 110, 42, 14);
		contentPanel.add(lblabajo);
		
		
		JLabel lblcentro = new JLabel("");
		lblcentro.setOpaque(true);
		lblcentro.setBackground(new Color(255, 255, 255));
		lblcentro.setBorder(null);
		lblcentro.setBounds(41, 88, 14, 22);
		contentPanel.add(lblcentro);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(81, 51, 375, 88);
		contentPanel.add(table);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		introducirImagen(id, lblImagen);		
		lblImagen.setBounds(24, 144, 42, 79);
		contentPanel.add(lblImagen);
		
		JLabel lblTratamiento = new JLabel("Tratamiento:");
		lblTratamiento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTratamiento.setBounds(98, 185, 89, 22);
		contentPanel.add(lblTratamiento);
		
		Campo_texto_theme tf_tratamiento = new Campo_texto_theme(20);
		tf_tratamiento.setBounds(204, 182, 89, 28);
		contentPanel.add(tf_tratamiento);
		
		JLabel lblNuevoTratamiento = new JLabel("Insertar nuevo tratamiento");
		lblNuevoTratamiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoTratamiento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNuevoTratamiento.setBounds(146, 157, 225, 14);
		contentPanel.add(lblNuevoTratamiento);
		
		JLabel lblLugar = new JLabel("Sitio:");
		lblLugar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLugar.setBounds(98, 218, 93, 28);
		contentPanel.add(lblLugar);
		
		Campo_texto_theme tf_sitio = new Campo_texto_theme(20);
		tf_sitio.setBounds(204, 218, 89, 28);
		contentPanel.add(tf_sitio);
		
		JLabel etiqueta_fondo = new JLabel("");
		etiqueta_fondo.setBackground(Color.WHITE);
		etiqueta_fondo.setIcon(new ImageIcon(Odontograma.class.getResource("/Vista/imagenes/fondoodonto.png")));
		etiqueta_fondo.setBounds(0, 0, 469, 293);
		contentPanel.add(etiqueta_fondo);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Medico.class.getResource("/Vista/imagenes/diente.png")));
		setTitle("DentiApp Odontograma");
		
		mostrarInfo(id);
		pintarDiente(id, lblarriba, lblizq, lblder, lblabajo, lblcentro);
		
		btndntstAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf_tratamiento.getText().equalsIgnoreCase("")) {
					setVisible(false);
				}else {
					insertar(id, tf_tratamiento, tf_sitio);
					JOptionPane.showMessageDialog(null, "Tratamiento introducido exitosamente.");
					setVisible(false);
				}
				
			}
		});
		
	}

	private void insertar(String id, Campo_texto_theme tf_tratamiento, Campo_texto_theme tf_sitio) {
		LocalDate lfecha=LocalDate.now();
		String fecha=lfecha.toString();
		String valorInsert=0+","+id+","+DNI+","+tf_tratamiento.getText()+","+fecha+","+tf_sitio.getText(); 
		bbdd.insertar("odontograma", valorInsert);
	}

	private void pintarDiente(String id, JLabel lblarriba, JLabel lblizq, JLabel lblder, JLabel lblabajo,
			JLabel lblcentro) {
		List <String> colores = new ArrayList<>();
		String cadena="odontograma where id_diente='"+id+"' and paciente_DNI='"+DNI+"';";
		try {
			colores=bbdd.SelectLista("lugar",cadena);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0;i<colores.size();i++) {
			if(colores.get(i).equalsIgnoreCase("arriba")) {
				lblarriba.setBackground(Color.red);
			}else if(colores.get(i).equalsIgnoreCase("abajo")) {
				lblabajo.setBackground(Color.red);
			}else if(colores.get(i).equalsIgnoreCase("izquierda")) {
				lblizq.setBackground(Color.red);
			}else if(colores.get(i).equalsIgnoreCase("derecha")) {
				lblder.setBackground(Color.red);
			}else if(colores.get(i).equalsIgnoreCase("centro")) {
				lblcentro.setBackground(Color.red);
			}
		}
	}

	private void mostrarInfo(String id) {
		String consulta="SELECT * FROM dentiapp.odontograma where id_diente='"+id+"' and paciente_DNI='"+DNI+"';";
		  table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
      try {
			bbdd.SelectValor(table, consulta);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void introducirImagen(String id, JLabel lblImagen) {
		if(id.equalsIgnoreCase("11") || id.equalsIgnoreCase("21")) {
			lblImagen.setIcon(new ImageIcon(Odontograma.class.getResource("/Vista/imagenes/diente-de-incisivos.png")));
		}else if(id.equalsIgnoreCase("12") || id.equalsIgnoreCase("22" )){
			lblImagen.setIcon(new ImageIcon(Odontograma.class.getResource("/Vista/imagenes/diente-canino.png")));
		}else if(id.equalsIgnoreCase("13") || id.equalsIgnoreCase("23")) {
			lblImagen.setIcon(new ImageIcon(Odontograma.class.getResource("/Vista/imagenes/premolar.png")));
		}else {
			lblImagen.setIcon(new ImageIcon(Odontograma.class.getResource("/Vista/imagenes/diente_odon.png")));
		}
	}
}
