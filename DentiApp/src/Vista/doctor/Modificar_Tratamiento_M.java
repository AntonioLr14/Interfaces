package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Choice;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import Vista.Login_Inicio;
import botonDentista.BotonDentista;
import prueba.Campo_texto_theme;

public class Modificar_Tratamiento_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private Campo_texto_theme tfNombrePaciente;

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
		
		Choice choiceTratamientoAntiguo = new Choice();
		choiceTratamientoAntiguo.setBounds(155, 88, 120, 18);
		add(choiceTratamientoAntiguo);
		
		Choice choiceTratamientoNuevo = new Choice();
		choiceTratamientoNuevo.setBounds(155, 181, 120, 18);
		add(choiceTratamientoNuevo);
		
		JLabel lblNombrePaciente = new JLabel("Insertar nombre del paciente");
		lblNombrePaciente.setBounds(403, 59, 174, 13);
		add(lblNombrePaciente);
		
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


	}
}
