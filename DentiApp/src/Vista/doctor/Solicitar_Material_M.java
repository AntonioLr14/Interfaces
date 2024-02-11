package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controlador.BBDD;
import Vista.Login_Inicio;

import java.awt.Choice;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.Button;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import botonDentista.BotonDentista;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Solicitar_Material_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private Campo_texto_theme tfCantidad;
	private Campo_texto_theme tfDoctor;
	private Despegable_editable_theme<String> material;
	private ResultSet resultset;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public Solicitar_Material_M() throws Exception {

		setOpaque(false);
		setBounds(100, 100, 720, 500);
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		
		material = new Despegable_editable_theme<String>(20);
		material.setBounds(112, 78, 128, 30);
		add(material);
		material.addItem("...");
		try {
			resultset=Login_Inicio.dbconn.consulta("SELECT nombre FROM materiales;");
			while(resultset.next()) {
				material.addItem(resultset.getString("nombre"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tfCantidad = new Campo_texto_theme(20);
		tfCantidad.setBounds(297, 78, 138, 30);
		add(tfCantidad);
		
		JLabel lblMaterial = new JLabel("Material");
		lblMaterial.setBounds(147, 59, 70, 13);
		add(lblMaterial);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(339, 59, 80, 13);
		add(lblCantidad);
		
		BotonDentista btndntstSolicitar = new BotonDentista();
		btndntstSolicitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(material.getSelectedItem().toString().equals("...")||tfCantidad.getText().isEmpty()||tfDoctor.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Rellene todos los campos");
				}else {
					try {
						resultset=Login_Inicio.dbconn.consulta("SELECT ID_material from materiales where nombre='"+material.getSelectedItem().toString()+"'");
						String id_material="";
						while(resultset.next()) {
							 id_material=resultset.getString("ID_material");
						}
						
						//int id_material = Integer.parseInt(Medico.dbconn.SelectListaCondicion("ID_Material", "Stock", " where nombre ='"+material.getSelectedItem().toString()+"'").get(0));
						//String valores = 0+","+tfDoctor.getText()+","+String.valueOf(id_material)+","+tfCantidad.getText();
						 LocalDate fechaDeInscripcion = LocalDate.now();
						int material=Login_Inicio.dbconn.insertUpdateDelete("INSERT INTO `dentiapp`.`solicitudes` (`ID_doctor`, `ID_material`,"
								+ " `Cantidad`, `Fecha`) VALUES ('"+tfDoctor.getText()+"', '"+id_material+"', '"+tfCantidad.getText()+"','"+fechaDeInscripcion+"');");
						JOptionPane.showMessageDialog(null,"Solicitud realizada");
					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		
			}
		});
		btndntstSolicitar.setBorder(null);
		btndntstSolicitar.setText("Solicitar");
		btndntstSolicitar.setRadius(30);
		btndntstSolicitar.setBounds(297, 147, 160, 30);
		add(btndntstSolicitar);
		
		 tfDoctor = new Campo_texto_theme(20);
		tfDoctor.setBounds(492, 78, 138, 30);
		add(tfDoctor);
		
		JLabel lblDoctor = new JLabel("ID Doctor");
		lblDoctor.setBounds(539, 58, 70, 14);
		add(lblDoctor);


	}
}
