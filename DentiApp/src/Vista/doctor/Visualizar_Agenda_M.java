package Vista.doctor;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
import javax.swing.table.DefaultTableModel;

import Controlador.BBDD;

import javax.swing.JTable;

public class Visualizar_Agenda_M extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable agenda;
	private BBDD bbdd=new BBDD();
	private JScrollPane scrollpanel;

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
		
		
		
	this.scrollpanel = new JScrollPane();
		
		this.scrollpanel.setBounds(83, 66, 551, 207);
		this.scrollpanel.setBorder(new LineBorder(Color.black));
		this.scrollpanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.scrollpanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		
		this.agenda = new JTable();
		

		this.agenda.setTableHeader(null);
		this.scrollpanel.setViewportView(agenda);
		
		add(scrollpanel);
		
		JTextArea taAgenda = new JTextArea();
		taAgenda.setBorder(new LineBorder(new Color(0, 0, 0)));
		taAgenda.setBounds(113, 66, 511, 207);
		add(taAgenda);
		
		
		String consulta="SELECT * FROM dentiapp.citas where ID_Doctor='"+id+"';";
		  agenda.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        try {
			bbdd.SelectValor(agenda, consulta);
			agenda.setDefaultEditor(agenda.getColumnClass(0), null);
			
			DefaultTableModel modelo_agenda = (DefaultTableModel) this.agenda.getModel();	
			
			modelo_agenda.setValueAt("Cita",0,0);
			modelo_agenda.setValueAt("DNI Paciente",0,1);
			modelo_agenda.setValueAt("DNI Doctor",0,2);
			modelo_agenda.setValueAt("Tratamiento",0,3);
			modelo_agenda.setValueAt("Fecha y hora",0,4);
			modelo_agenda.setValueAt("Motivo visita",0,5);
			this.agenda.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
