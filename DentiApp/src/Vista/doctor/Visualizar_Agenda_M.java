package Vista.doctor;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.SwingConstants;

import Vista.Login_Inicio;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import Controlador.BBDD;

import javax.swing.JTable;

public class Visualizar_Agenda_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private BBDD bbdd=new BBDD();

	/**
	 * Create the panel.
	 */
	public Visualizar_Agenda_M(String id) {
		setOpaque(false);
		setLayout(null);
		setBounds(100, 100, 720, 500);
		setBackground(new Color(255, 255, 255));
		JLabel lblAgenda = new JLabel("Agenda");
		lblAgenda.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgenda.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAgenda.setBounds(318, 27, 89, 28);
		add(lblAgenda);
		bbdd.conectar();
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(113, 66, 511, 207);
		add(table);
		
		JTextArea taAgenda = new JTextArea();
		taAgenda.setBorder(new LineBorder(new Color(0, 0, 0)));
		taAgenda.setBounds(113, 66, 511, 207);
		add(taAgenda);
		
		
		String consulta="SELECT * FROM dentiapp.citas where ID_Doctor='"+id+"';";
		  table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        try {
			bbdd.SelectValor(table, consulta);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
