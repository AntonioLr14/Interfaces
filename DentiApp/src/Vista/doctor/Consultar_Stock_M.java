package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import botonDentista.BotonDentista;
import prueba.Despegable_editable_theme;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

import Vista.Login_Inicio;
import prueba.Campo_texto_theme;

public class Consultar_Stock_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private Despegable_editable_theme material;
	private Campo_texto_theme tpUnidadesStock;
	private ResultSet resultset;


	/**
	 * Create the panel.
	 */
	public Consultar_Stock_M() {

		setOpaque(false);
		setBounds(100, 100, 720, 500);
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		
		material = new Despegable_editable_theme(20);
		material.setBounds(174, 84, 148, 30);
		add(material);
		material.addItem("...");
		try {
			resultset=Login_Inicio.dbconn.consulta("SELECT nombre FROM materiales;");
			while(resultset.next()) {
				material.addItem(resultset.getString("nombre"));
			}
			
		} catch (NumberFormatException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblMaterial = new JLabel("Material");
		lblMaterial.setBounds(212, 67, 68, 13);
		add(lblMaterial);
		
		JLabel lblUnidadesStock = new JLabel("Unidades en stock");
		lblUnidadesStock.setBounds(281, 171, 109, 36);
		add(lblUnidadesStock);
		
		tpUnidadesStock = new Campo_texto_theme(20);
		tpUnidadesStock.setHorizontalAlignment(SwingConstants.CENTER);
		tpUnidadesStock.setFont(new Font("Tahoma", Font.BOLD, 18));
		tpUnidadesStock.setBounds(400, 171, 52, 36);
		add(tpUnidadesStock);
		
		BotonDentista btndntstConsultar = new BotonDentista();
		btndntstConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(material.getSelectedItem().toString().equals("...")) {
					JOptionPane.showMessageDialog(null, "Rellene todos los campos");
				}else {
					/*try {
						List<String> cantidades;
						cantidades=dbconn.SelectListaCondicion("Cantidad", "Stock", "where nombre ='"+material.getSelectedItem().toString()+"'");
						int total=0;
						for(String num:cantidades) {
							total+=Integer.parseInt(num);
						}
						tpUnidadesStock.setText(String.valueOf(total));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}*/
					try {
						resultset=Login_Inicio.dbconn.consulta("SELECT cantidad from materiales where nombre='"+material.getSelectedItem().toString()+"'");
						String id_material="";
						while(resultset.next()) {
							 id_material=resultset.getString("cantidad");
						}
						tpUnidadesStock.setText(id_material);
						
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
	
		btndntstConsultar.setText("Consultar");
		btndntstConsultar.setRadius(30);
		btndntstConsultar.setBorder(null);
		btndntstConsultar.setFocusable(false);
		btndntstConsultar.setBounds(400, 76, 160, 30);
		add(btndntstConsultar);
		

		
	}
}
