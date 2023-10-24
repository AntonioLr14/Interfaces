package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Choice;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Modificar_Tratamiento_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNombrePaciente;

	/**
	 * Create the panel.
	 */
	public Modificar_Tratamiento_M() {
		setBounds(100, 100, 620, 328);
		setLayout(null);
		setBackground(new Color(230, 247, 255));
		
		JLabel lblTratamientoAntiguo = new JLabel("Tratamiento antiguo");
		lblTratamientoAntiguo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTratamientoAntiguo.setBounds(62, 74, 133, 13);
		add(lblTratamientoAntiguo);
		
		JLabel lblTratamientoNuevo = new JLabel("Tratamiento nuevo");
		lblTratamientoNuevo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTratamientoNuevo.setBounds(62, 165, 133, 13);
		add(lblTratamientoNuevo);
		
		Choice choiceTratamientoAntiguo = new Choice();
		choiceTratamientoAntiguo.setBounds(91, 103, 120, 18);
		add(choiceTratamientoAntiguo);
		
		Choice choiceTratamientoNuevo = new Choice();
		choiceTratamientoNuevo.setBounds(91, 196, 120, 18);
		add(choiceTratamientoNuevo);
		
		JLabel lblNombrePaciente = new JLabel("Insertar nombre del paciente");
		lblNombrePaciente.setBounds(339, 74, 174, 13);
		add(lblNombrePaciente);
		
		tfNombrePaciente = new JTextField();
		tfNombrePaciente.setBounds(355, 102, 158, 33);
		add(tfNombrePaciente);
		tfNombrePaciente.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setContentAreaFilled(false);
		btnAceptar.setBounds(380, 193, 133, 33);
		add(btnAceptar);

	}

}
