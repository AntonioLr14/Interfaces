package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlador.BBDD;
import Vista.Login_Inicio;

import java.awt.Choice;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.sql.SQLException;
import java.util.List;

import botonDentista.BotonDentista;
import prueba.Campo_texto_theme;
import prueba.Despegable_theme;
import prueba.Despegable_editable_theme;

public class Anyadir_Tratamiento_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private BBDD bbdd=new BBDD();
	private Despegable_editable_theme desplegable_tratamiento;

	/**
	 * Create the panel.
	 */
	public Anyadir_Tratamiento_M() {
		setBounds(100, 100, 720, 500);
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		bbdd.conectar();
		
		desplegable_tratamiento = new Despegable_editable_theme(20);
		desplegable_tratamiento.setBounds(391, 84, 148, 30);
		add(desplegable_tratamiento);
		
		Campo_texto_theme tfTratamiento = new Campo_texto_theme(20);
		tfTratamiento.setBounds(165, 84, 154, 30);
		add(tfTratamiento);
		
		JLabel lblTratamiento = new JLabel("Tratamiento");
		lblTratamiento.setBounds(434, 61, 81, 13);
		add(lblTratamiento);
		
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
	private void mostrarcombo(JComboBox cb,String tableName,String valor) {

		try {
			List<String> lista = bbdd.SelectLista(valor, tableName);
			for (String li : lista) {
				cb.addItem(li);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
