package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Choice;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import Controlador.BBDD;
import Vista.Login_Inicio;
import botonDentista.BotonDentista;
import prueba.Campo_texto_theme;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Modificar_Tratamiento_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private Campo_texto_theme tfNombrePaciente;
	private BBDD bbdd = new BBDD();

	/**
	 * Create the panel.
	 */
	public Modificar_Tratamiento_M() {
		setBounds(100, 100, 720, 500);
		setLayout(null);
		setBackground(new Color(255, 255, 255));

		tfNombrePaciente = new Campo_texto_theme(20);
		tfNombrePaciente.setBounds(419, 87, 158, 33);
		add(tfNombrePaciente);

		JLabel lblTratamientoAntiguo = new JLabel("Tratamiento antiguo");
		lblTratamientoAntiguo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTratamientoAntiguo.setBounds(126, 59, 133, 13);
		add(lblTratamientoAntiguo);

		JLabel lblTratamientoNuevo = new JLabel("Tratamiento nuevo");
		lblTratamientoNuevo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTratamientoNuevo.setBounds(126, 150, 133, 13);
		add(lblTratamientoNuevo);

		JComboBox cbTratamientoAntiguo = new JComboBox();
		cbTratamientoAntiguo.setBounds(155, 88, 120, 20);
		add(cbTratamientoAntiguo);

		JLabel lblNombrePaciente = new JLabel("Insertar nombre del paciente");
		lblNombrePaciente.setBounds(403, 59, 174, 13);
		add(lblNombrePaciente);
		
		JComboBox cbTratamientoNuevo = new JComboBox();
		cbTratamientoNuevo.setBounds(155, 185, 120, 20);
		add(cbTratamientoNuevo);

		BotonDentista btndntstAceptar = new BotonDentista();
		btndntstAceptar.setText("Aceptar");
		btndntstAceptar.setRadius(30);
		btndntstAceptar.setBorder(null);
		btndntstAceptar.setBounds(417, 181, 160, 30);
		add(btndntstAceptar);

		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoabajo.png")));
		lblFondo.setBounds(0, -81, 728, 527);
		add(lblFondo);
		mostrarcombo(cbTratamientoAntiguo);
		mostrarcombo(cbTratamientoNuevo);

		bbdd.conectar();
	}

	private void mostrarcombo(JComboBox cbTratamientoAntiguo) {

		try {
			List<String> lista = bbdd.SelectLista("nombre", "tratamiento");
			for (String li : lista) {
				cbTratamientoAntiguo.addItem(li);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
