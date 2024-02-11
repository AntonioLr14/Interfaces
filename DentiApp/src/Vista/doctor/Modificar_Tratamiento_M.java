package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
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
	private Campo_texto_theme tfDNI_NombrePaciente;
	private Despegable_editable_theme tratamiento_nuevo;
	private Despegable_editable_theme tratamiento_antiguo;
	private ResultSet resultset;
	

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public Modificar_Tratamiento_M() throws Exception {
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

		tfDNI_NombrePaciente = new Campo_texto_theme(20);
		tfDNI_NombrePaciente.setBounds(419, 87, 158, 33);
		add(tfDNI_NombrePaciente);

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
		btndntstAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDate fecha_actual =LocalDate.now();
				LocalDate fecha_cita;
				try {
					resultset = Login_Inicio.dbconn.consulta(
							"SELECT fecha_hora from citas inner join pacientes on citas.ID_Paciente=pacientes.ID_Paciente "
									+ "inner join personas on pacientes.DNI=personas.DNI where personas.DNI='"
									+ tfDNI_NombrePaciente.getText() + "' "
									+ "or concat(personas.nombre,' ',personas.apellidos)='"
									+ tfDNI_NombrePaciente.getText() + "' order by citas.fecha_hora;");
					ArrayList<LocalDate> fechas = new ArrayList<LocalDate>();
					while(resultset.next()) {
						LocalDate fechaBase=resultset.getDate("fecha_hora").toLocalDate();
						if(fecha_actual.isAfter(fechaBase)||fecha_actual.equals(fechaBase)) {
							fechas.add(fechaBase);
						}
					}
					fecha_cita=fechas.get(fechas.size()-1);
					resultset=Login_Inicio.dbconn.consulta("Select ID_Tratamiento from tratamientos where nombre='"+tratamiento_nuevo.getSelectedItem().toString()+"';");
					int id_tratamiento_nuevo=0;
					while(resultset.next()) {
						id_tratamiento_nuevo=resultset.getInt("id_tratamiento");
					}
					resultset=Login_Inicio.dbconn.consulta("Select ID_Tratamiento from tratamientos where nombre='"+tratamiento_antiguo.getSelectedItem().toString()+"';");
					int id_tratamiento_antiguo=0;
					while(resultset.next()) {
						id_tratamiento_antiguo=resultset.getInt("id_tratamiento");
					}
					Login_Inicio.dbconn.insertUpdateDelete("UPDATE dentiapp.citas SET id_tratamiento='"+id_tratamiento_nuevo+"' where ID_Tratamiento='"+tratamiento_antiguo+"';");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btndntstAceptar.setText("Aceptar");
		btndntstAceptar.setRadius(30);
		btndntstAceptar.setBorder(null);
		btndntstAceptar.setBounds(417, 181, 160, 30);
		add(btndntstAceptar);

		
		mostrarcombo(tratamiento_nuevo);
		mostrarcombo(tratamiento_antiguo);
	}

	private void mostrarcombo(JComboBox desplegable_tratamiento) {

		desplegable_tratamiento.addItem("...");
		try {
			resultset=Login_Inicio.dbconn.consulta("SELECT nombre FROM tratamientos;");
			while(resultset.next()) {
				desplegable_tratamiento.addItem(resultset.getString("nombre"));
		} 
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

