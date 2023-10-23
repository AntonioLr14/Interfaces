package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.Color;

public class Anyadir_Tratamiento_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfTratamiento;

	/**
	 * Create the panel.
	 */
	public Anyadir_Tratamiento_M() {
		setBounds(100, 100, 620, 328);
		setLayout(null);
		setBackground(new Color(230, 247, 255));
		
		Choice choice = new Choice();
		choice.setBounds(329, 115, 148, 37);
		add(choice);
		
		JLabel lblTratamiento = new JLabel("Tratamiento");
		lblTratamiento.setBounds(372, 92, 81, 13);
		add(lblTratamiento);
		
		tfTratamiento = new JTextField();
		tfTratamiento.setBounds(103, 115, 154, 26);
		add(tfTratamiento);
		tfTratamiento.setColumns(10);
		
		JLabel lblInsertarNombrePaciente = new JLabel("Insertar nombre del paciente");
		lblInsertarNombrePaciente.setBackground(new Color(240, 240, 240));
		lblInsertarNombrePaciente.setBounds(103, 92, 170, 13);
		add(lblInsertarNombrePaciente);
		
		JButton btnAgregarTratamiento = new JButton("Agregar tratamiento");
		btnAgregarTratamiento.setBackground(new Color(255, 255, 255));
		btnAgregarTratamiento.setBounds(213, 238, 185, 37);
		add(btnAgregarTratamiento);

	}

}
