package Vista.administrador.gestion_medica;

import javax.swing.JPanel;
import Vista.Login_Inicio;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.sql.ResultSet;
import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import prueba.Despegable_editable_theme;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Consultar_Especialidad extends JPanel {
	
	// Atributos
	protected Despegable_editable_theme<String> especialidad;
	protected JScrollPane scrollpanel;
	protected JTable consultas_especialidad;
	
	// Constructores
	public Consultar_Especialidad() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		
		// Creacion de los elementos graficos
		this.especialidad = new Despegable_editable_theme<>(20);
		this.especialidad.setBounds(118, 55, 205, 30);
		
		this.especialidad.addItem("...");
		
		try {
			
			ResultSet resultset = Login_Inicio.dbconn.consulta("SELECT nombre FROM Especialidades;");
			
			while (resultset.next()) {
				this.especialidad.addItem(resultset.getString("nombre"));
			}
		}
		catch (Exception error) {
			
			JOptionPane.showMessageDialog(
				null,
				error.getMessage(),
				"Error en la consulta de la especialidad",
				JOptionPane.ERROR_MESSAGE,
				null
			);
		}

		this.scrollpanel = new JScrollPane();
		
		this.scrollpanel.setBounds(112, 156, 500, 130);
		this.scrollpanel.setBorder(new LineBorder(Color.black));
		this.scrollpanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.scrollpanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

		this.consultas_especialidad = new JTable();
		this.consultas_especialidad.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		this.scrollpanel.setViewportView(this.consultas_especialidad);
		
		BotonDentista boton_consultar = new BotonDentista();
		
		boton_consultar.setBounds(441, 55, 160, 30);
		boton_consultar.setBorder(null);
		boton_consultar.setRadius(30);
		boton_consultar.setText("Consultar");
		boton_consultar.setFocusable(false);
		
		JLabel etiqueta_especialidad = new JLabel("Especialidad:");
		etiqueta_especialidad.setBounds(118, 40, 94, 13);
		
		add(this.especialidad);
		add(this.scrollpanel);
		add(boton_consultar);

		add(etiqueta_especialidad);

		// Establecimiento de los eventos
		boton_consultar.addActionListener( (event) -> {
			
			 try {
				 
	             DefaultTableModel modelo_consultas_especialidad = (DefaultTableModel) this.consultas_especialidad.getModel();

	             for (; modelo_consultas_especialidad.getRowCount() > 0;) {
	                 modelo_consultas_especialidad.removeRow(0);
	             }

	 			 String consulta = "SELECT * from Especialidades where nombre = '" + this.especialidad.getSelectedItem().toString() + "';";

	             Login_Inicio.dbconn.cabeceraTabla(this.consultas_especialidad, consulta);

	             ResultSet resultset = Login_Inicio.dbconn.consulta(consulta);

	             while (resultset.next()) {
	            	 
	            	 int id = resultset.getInt("ID_especialidad");
	            	 String nombre = resultset.getString("Nombre");
	            	 String descripcion = resultset.getString("Descripcion");
	            	 
	            	 String[] fila = {String.valueOf(id), nombre, descripcion};
	            	 
	                 modelo_consultas_especialidad.addRow(fila);
	             }

	             this.consultas_especialidad.setDefaultEditor(this.consultas_especialidad.getColumnClass(0), null);
	         }
			 catch (Exception error) {
				 
				 JOptionPane.showMessageDialog(
					null,
					error.getMessage(),
					"Error en la consulta de la especialidad",
					JOptionPane.ERROR_MESSAGE,
					null
				);
	         }
		});
	}
}
