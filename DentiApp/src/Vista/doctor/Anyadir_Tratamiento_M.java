package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Vista.Login_Inicio;

import java.awt.Choice;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import botonDentista.BotonDentista;

public class Anyadir_Tratamiento_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfTratamiento;

	/**
	 * Create the panel.
	 */
	public Anyadir_Tratamiento_M() {
		setBounds(100, 100, 720, 500);
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		
		Choice choice = new Choice();
		choice.setBounds(391, 84, 148, 37);
		add(choice);
		
		JLabel lblTratamiento = new JLabel("Tratamiento");
		lblTratamiento.setBounds(434, 61, 81, 13);
		add(lblTratamiento);
		
		tfTratamiento = new JTextField();
		tfTratamiento.setBounds(165, 84, 154, 26);
		add(tfTratamiento);
		tfTratamiento.setColumns(10);
		
		JLabel lblInsertarNombrePaciente = new JLabel("Insertar nombre del paciente");
		lblInsertarNombrePaciente.setBackground(new Color(240, 240, 240));
		lblInsertarNombrePaciente.setBounds(165, 61, 170, 13);
		add(lblInsertarNombrePaciente);
		
		BotonDentista btndntstAgregarTratamiento = new BotonDentista();
		btndntstAgregarTratamiento.setBorder(null);
		btndntstAgregarTratamiento.setRadius(30);
		btndntstAgregarTratamiento.setText("Agregar tratamiento");
		btndntstAgregarTratamiento.setBounds(273, 154, 185, 37);
		add(btndntstAgregarTratamiento);

		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(0, 128, 255));
		lblFondo.setIcon(new ImageIcon(Login_Inicio.class.getResource("/Vista/imagenes/fondoabajo.png")));
		lblFondo.setBounds(0, -81, 728, 527);
		add(lblFondo);
	}
}
