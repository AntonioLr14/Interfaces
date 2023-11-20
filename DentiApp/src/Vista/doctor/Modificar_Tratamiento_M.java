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
import prueba.Despegable_editable_theme;

public class Modificar_Tratamiento_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private Campo_texto_theme tfNombrePaciente;
	private BBDD bbdd = new BBDD();
	private Despegable_editable_theme tratamiento_nuevo;
	private Despegable_editable_theme tratamiento_antiguo;
	

	/**
	 * Create the panel.
	 */
	public Modificar_Tratamiento_M() {
		setOpaque(false);
		setBounds(100, 100, 720, 500);
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		
		tratamiento_nuevo = new Despegable_editable_theme(20);
		tratamiento_nuevo.setBounds(155, 185, 158, 30);
		add(tratamiento_nuevo);
		
		tratamiento_antiguo = new Despegable_editable_theme(20);
		tratamiento_antiguo.setBounds(155, 88, 158, 30);
		add(tratamiento_antiguo);

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

		JLabel lblNombrePaciente = new JLabel("Insertar nombre del paciente");
		lblNombrePaciente.setBounds(403, 59, 174, 13);
		add(lblNombrePaciente);

		BotonDentista btndntstAceptar = new BotonDentista();
		btndntstAceptar.setText("Aceptar");
		btndntstAceptar.setRadius(30);
		btndntstAceptar.setBorder(null);
		btndntstAceptar.setBounds(417, 181, 160, 30);
		add(btndntstAceptar);

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
