package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Choice;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;

import Controlador.BBDD;
import Controlador.Controlador;
import Vista.Login_Inicio;
import botonDentista.BotonDentista;
import prueba.Despegable_editable_theme;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Consultar_Stock_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private Despegable_editable_theme material;
	protected BBDD dbconn;
	private JTextField tpUnidadesStock;


	/**
	 * Create the panel.
	 */
	public Consultar_Stock_M() {
		this.dbconn = new BBDD();
		this.dbconn.conectar();
		setOpaque(false);
		setBounds(100, 100, 720, 500);
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		
		material = new Despegable_editable_theme(20);
		material.setBounds(174, 84, 148, 30);
		add(material);
		material.addItem("");
		
		JLabel lblMaterial = new JLabel("Material");
		lblMaterial.setBounds(212, 67, 68, 13);
		add(lblMaterial);
		
		JLabel lblUnidadesStock = new JLabel("Unidades en stock");
		lblUnidadesStock.setBounds(281, 171, 109, 36);
		add(lblUnidadesStock);
		
		tpUnidadesStock = new JTextField();
		tpUnidadesStock.setHorizontalAlignment(SwingConstants.CENTER);
		tpUnidadesStock.setFont(new Font("Tahoma", Font.BOLD, 18));
		tpUnidadesStock.setBounds(400, 171, 52, 36);
		add(tpUnidadesStock);
		tpUnidadesStock.setColumns(10);
		
		BotonDentista btndntstConsultar = new BotonDentista();
		btndntstConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
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
				}
			}
		});
		btndntstConsultar.setText("Consultar");
		btndntstConsultar.setRadius(30);
		btndntstConsultar.setBorder(null);
		btndntstConsultar.setBounds(400, 76, 160, 30);
		add(btndntstConsultar);

		

		try {
			for(String nombre:dbconn.SelectLista("Nombre", "Stock")) {
				material.addItem(nombre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
