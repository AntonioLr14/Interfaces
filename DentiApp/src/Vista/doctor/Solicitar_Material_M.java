package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controlador.BBDD;
import Vista.Login_Inicio;

import java.awt.Choice;
import java.awt.Color;
import java.sql.SQLException;
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
	private Campo_texto_theme tfCita;
	private Despegable_editable_theme material;
	protected BBDD dbconn;

	/**
	 * Create the panel.
	 */
	public Solicitar_Material_M() {
		this.dbconn = new BBDD();
		this.dbconn.conectar();
		setOpaque(false);
		setBounds(100, 100, 720, 500);
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		
		material = new Despegable_editable_theme(20);
		material.setBounds(112, 78, 128, 30);
		add(material);
		material.addItem("...");
		try {
			for(String nombre:dbconn.SelectLista("Nombre", "Stock")) {
				material.addItem(nombre);
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
				if(material.getSelectedItem().toString().equals(" ")) {
					JOptionPane.showMessageDialog(null,"Seleccione un material");
				}else {
					try {
						int id_material = Integer.parseInt(dbconn.SelectListaCondicion("ID_Material", "Stock", " where nombre ='"+material.getSelectedItem().toString()+"'").get(0));
						String valores = 0+","+tfCita.getText()+","+String.valueOf(id_material)+","+tfCantidad.getText();
						dbconn.insertar("Solicitudes",valores);
						JOptionPane.showMessageDialog(null,"Solicitud realizada");
					} catch (NumberFormatException | SQLException e1) {
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
		
		 tfCita = new Campo_texto_theme(20);
		tfCita.setBounds(492, 78, 138, 30);
		add(tfCita);
		
		JLabel lblCita = new JLabel("ID Cita");
		lblCita.setBounds(539, 58, 46, 14);
		add(lblCita);


	}
}
