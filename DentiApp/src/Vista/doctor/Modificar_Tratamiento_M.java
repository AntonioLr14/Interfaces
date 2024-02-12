package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Choice;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
	private Despegable_editable_theme desplegable_tratamiento;
	private ResultSet resultset;
	

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public Modificar_Tratamiento_M() throws Exception {
		setOpaque(false);
		setBounds(100, 100, 720, 500);
		setLayout(null);

		desplegable_tratamiento = new Despegable_editable_theme(20);
		desplegable_tratamiento.setBounds(391, 84, 148, 30);

		desplegable_tratamiento.addItem("...");

		try {
			resultset = Login_Inicio.dbconn.consulta("SELECT nombre FROM tratamientos order by ID_tratamiento;");
			while (resultset.next()) {
				desplegable_tratamiento.addItem(resultset.getString("nombre"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Campo_texto_theme tfDNI_NombrePaciente = new Campo_texto_theme(20);
		tfDNI_NombrePaciente.setBounds(165, 84, 154, 30);

		JLabel lblTratamiento = new JLabel("Tratamiento");
		lblTratamiento.setBounds(434, 61, 81, 13);

		JLabel lblInsertarNombrePaciente = new JLabel("Insertar nombre del paciente");
		lblInsertarNombrePaciente.setBackground(new Color(240, 240, 240));
		lblInsertarNombrePaciente.setBounds(165, 61, 170, 13);

		BotonDentista btndntstAgregarTratamiento = new BotonDentista();
		btndntstAgregarTratamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDate fecha_actual =LocalDate.now();
				LocalDate fecha_cita;
				
				try {
					if(tfDNI_NombrePaciente.getText().isBlank()||desplegable_tratamiento.getSelectedItem().toString().equals("...")) {
						throw new Exception("Debes rellenar todos los campos");
					}
					resultset = Login_Inicio.dbconn.consulta(
							"SELECT fecha_hora from citas inner join pacientes on citas.ID_Paciente=pacientes.ID_Paciente "
									+ "inner join personas on pacientes.DNI=personas.DNI where personas.DNI='"
									+ tfDNI_NombrePaciente.getText() + "' "
									+ "or concat(personas.nombre,' ',personas.apellidos)='"
									+ tfDNI_NombrePaciente.getText() + "' order by citas.fecha_hora;");
					ArrayList<LocalDate> fechas = new ArrayList<LocalDate>();
					String[] Stringfecha=null;
					while(resultset.next()) {
						Stringfecha=resultset.getString("fecha_hora").split(" ");
						LocalDate fechaBase=LocalDate.parse(Stringfecha[0]);
						if(fecha_actual.isAfter(fechaBase)||fecha_actual.equals(fechaBase)) {
							fechas.add(fechaBase);
						}
					}
					fecha_cita=fechas.get(fechas.size()-1);
					resultset=Login_Inicio.dbconn.consulta("Select ID_Tratamiento from tratamientos where nombre='"+desplegable_tratamiento.getSelectedItem().toString()+"';");
					int id_tratamiento=0;
					while(resultset.next()) {
						id_tratamiento=resultset.getInt("id_tratamiento");
					}
					Login_Inicio.dbconn.insertUpdateDelete("UPDATE dentiapp.citas SET id_tratamiento='"+id_tratamiento+"' where fecha_hora='"+fecha_cita+" "+Stringfecha[1]+"';");
					JOptionPane.showMessageDialog(null,"Tratamiento agragado con éxito.");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		});
		btndntstAgregarTratamiento.setBorder(null);
		btndntstAgregarTratamiento.setRadius(30);
		btndntstAgregarTratamiento.setFocusable(false);
		btndntstAgregarTratamiento.setText("Agregar tratamiento");
		btndntstAgregarTratamiento.setBounds(273, 154, 185, 37);

		add(desplegable_tratamiento);
		add(tfDNI_NombrePaciente);
		add(lblTratamiento);
		add(lblInsertarNombrePaciente);
		add(btndntstAgregarTratamiento);
		}
	}

