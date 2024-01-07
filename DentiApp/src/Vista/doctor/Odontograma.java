package Vista.doctor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Vista.Login_Inicio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import prueba.Campo_texto_editable_theme;
import prueba.Campo_texto_theme;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import botonDentista.BotonDentista;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Odontograma extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static String id ="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Odontograma dialog = new Odontograma(id);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Odontograma(String id) {
		this.id=id;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
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
		btndntstAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btndntstAceptar.setText("Aceptar");
		btndntstAceptar.setRadius(30);
		btndntstAceptar.setBounds(335, 221, 89, 32);
		contentPanel.add(btndntstAceptar);
		
		JLabel lblarriba = new JLabel("");
		lblarriba.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblarriba.setOpaque(true);
		lblarriba.setBackground(new Color(255, 255, 255));
		lblarriba.setBounds(34, 51, 42, 14);
		contentPanel.add(lblarriba);
		
		JLabel lblizq = new JLabel("");
		lblizq.setOpaque(true);
		lblizq.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblizq.setBackground(Color.WHITE);
		lblizq.setBounds(34, 64, 14, 22);
		contentPanel.add(lblizq);
		
		JLabel lblder = new JLabel("");
		lblder.setOpaque(true);
		lblder.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblder.setBackground(Color.WHITE);
		lblder.setBounds(62, 64, 14, 22);
		contentPanel.add(lblder);
		
		JLabel lblabajo = new JLabel("");
		lblabajo.setOpaque(true);
		lblabajo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblabajo.setBackground(Color.WHITE);
		lblabajo.setBounds(34, 86, 42, 14);
		contentPanel.add(lblabajo);
		
		JLabel lblcentro = new JLabel("");
		lblcentro.setOpaque(true);
		lblcentro.setBackground(new Color(255, 255, 255));
		lblcentro.setBorder(null);
		lblcentro.setBounds(48, 64, 14, 22);
		contentPanel.add(lblcentro);
		JLabel etiqueta_fondo = new JLabel("");
		etiqueta_fondo.setBackground(Color.WHITE);
		etiqueta_fondo.setIcon(new ImageIcon(Odontograma.class.getResource("/Vista/imagenes/fondoodonto.png")));
		etiqueta_fondo.setBounds(0, 0, 434, 261);
		contentPanel.add(etiqueta_fondo);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Medico.class.getResource("/Vista/imagenes/diente.png")));
		setTitle("DentiApp Odontograma");
		
		if(id.equals("11")) {
			lblizq.setBackground(Color.red);
		}else if(id.equals("12")) {
			lblder.setBackground(Color.green);
		}else if(id.equals("21")) {
			lblder.setBackground(Color.blue);
			lblcentro.setBackground(Color.yellow);
			lblizq.setBackground(Color.red);
			lblarriba.setBackground(Color.gray);
			lblabajo.setBackground(Color.orange);
		}
	}
}
