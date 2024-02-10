package Vista.administrador.gestion_medica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controlador.BBDD;
import Vista.Login_Inicio;
import Vista.administrador.Administrador;
import Vista.doctor.Medico;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import botonDentista.BotonDentista;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;

public class Anyadir_Tratamiento extends JPanel {
	private Campo_texto_theme nombre_tratamiento;
	private Campo_texto_theme precio_tratamiento;
	private Despegable_editable_theme especialidad;
	private ResultSet resultset;

	// Constructores
	public Anyadir_Tratamiento() throws Exception {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		JLabel etiqueta_nombre_tratamiento = new JLabel("Tratamiento:");
		etiqueta_nombre_tratamiento.setBounds(257, 40, 92, 14);
		
		JLabel etiqueta_precio_tratamiento = new JLabel("Precio:");
		etiqueta_precio_tratamiento.setBounds(26, 40, 49, 14);
		
		JLabel etiqueta_especialidad = new JLabel("Especialidad:");
		etiqueta_especialidad.setBounds(488, 40, 94, 14);
		
		nombre_tratamiento = new Campo_texto_theme(20);
		nombre_tratamiento.setBounds(257, 55, 205, 30);
		
		precio_tratamiento = new Campo_texto_theme(20);
		precio_tratamiento.setBounds(26, 55, 205, 30);
		add(etiqueta_nombre_tratamiento);
		add(etiqueta_precio_tratamiento);
		add(etiqueta_especialidad);
		add(nombre_tratamiento);
		add(precio_tratamiento);

		BotonDentista btndntstAgregarTratamiento = new BotonDentista();


		btndntstAgregarTratamiento.setBorder(null);
		btndntstAgregarTratamiento.setRadius(30);
		btndntstAgregarTratamiento.setText("Agregar tratamiento");
		btndntstAgregarTratamiento.setBounds(270, 135, 180, 30);
		add(btndntstAgregarTratamiento);
		
		especialidad = new Despegable_editable_theme(30);
		especialidad.setBounds(488, 55, 205, 30);
		add(especialidad);
		mostrarcombo(especialidad);
		btndntstAgregarTratamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					resultset=Administrador.getDbconn().consulta("SELECT ID_Especialidad from dentiapp.especialidades where nombre='"+especialidad.getSelectedItem().toString()+"'");
					String id_especialidad="";
					while(resultset.next()) {
						 id_especialidad=resultset.getString("ID_Especialidad");
					}
					String consulta="INSERT INTO `dentiapp`.`tratamientos` (`ID_especialidad`, `Nombre`, `Precio`, `Estado`) VALUES ('"+id_especialidad+"', '"+nombre_tratamiento.getText()+""
							+ "', '"+precio_tratamiento.getText()+"', '1');";
					Administrador.getDbconn().insertUpdateDelete(consulta);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Nuevo tratamiento insertado con exito.");
			}
		});
		
	}
	private void mostrarcombo(JComboBox desplegable_tratamiento) {

		desplegable_tratamiento.addItem("...");
		try {
			resultset=Administrador.getDbconn().consulta("SELECT nombre FROM especialidades;");
			while(resultset.next()) {
				desplegable_tratamiento.addItem(resultset.getString("nombre"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}
