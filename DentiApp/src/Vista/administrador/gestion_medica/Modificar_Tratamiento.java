package Vista.administrador.gestion_medica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controlador.BBDD;
import Vista.Login_Inicio;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.sql.SQLException;

import botonDentista.BotonDentista;
import prueba.Campo_texto_theme;
import prueba.Despegable_editable_theme;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Modificar_Tratamiento extends JPanel {
	private Campo_texto_theme modificacion_tratamiento;
	private Despegable_editable_theme operacion;
	private Despegable_editable_theme tratamiento;
	private BBDD dbconn;
	// Constructores
	public Modificar_Tratamiento() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		setOpaque(false);
		dbconn=new BBDD();
		dbconn.conectar();

		JLabel etiqueta_tratamiento = new JLabel("Tratamiento:");
		etiqueta_tratamiento.setBounds(411, 40, 92, 13);
		
		JLabel etiqueta_operacion = new JLabel("Operación:");
		etiqueta_operacion.setBounds(103, 40, 78, 13);
		
		modificacion_tratamiento = new Campo_texto_theme(20);
		modificacion_tratamiento.setBounds(257, 141, 205, 30);
		add(etiqueta_tratamiento);
		add(etiqueta_operacion);
		add(modificacion_tratamiento);
		
		BotonDentista btndntstAceptar = new BotonDentista();
		
		btndntstAceptar.setText("Aceptar");
		btndntstAceptar.setRadius(30);
		btndntstAceptar.setBorder(null);
		btndntstAceptar.setBounds(280, 205, 160, 30);
		add(btndntstAceptar);
		
		operacion = new Despegable_editable_theme(20);
		operacion.setBounds(103, 55, 205, 30);
		add(operacion);
		rellenarCombo();
		
		tratamiento = new Despegable_editable_theme(20);
		tratamiento.setBounds(411, 55, 205, 30);
		add(tratamiento);
		mostrarcombo(tratamiento);
		
		JLabel lblValor = new JLabel("Nuevo valor:");
		lblValor.setHorizontalAlignment(SwingConstants.CENTER);
		lblValor.setBounds(257, 111, 205, 29);
		add(lblValor);
		
		btndntstAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (operacion.getSelectedIndex()) {
				case 1:
					dbconn.update("tratamiento", "nombre='"+modificacion_tratamiento.getText()+"'", "nombre ='"+tratamiento.getSelectedItem().toString()+"'");
					break;
				case 2:
					if(esParseableAEntero(modificacion_tratamiento.getText())) {
						dbconn.update("tratamiento", "precio='"+modificacion_tratamiento.getText()+"'", "nombre ='"+tratamiento.getSelectedItem().toString()+"'");
					}else {
						JOptionPane.showMessageDialog(null, "El valor introducido no es un número");
					}
					break;
				case 3:
					if(modificacion_tratamiento.getText().equalsIgnoreCase("alta")|| modificacion_tratamiento.getText().equalsIgnoreCase("baja")) {
						dbconn.update("tratamiento", "estado='"+modificacion_tratamiento.getText()+"'", "nombre ='"+tratamiento.getSelectedItem().toString()+"'");
					}else {
						JOptionPane.showInternalMessageDialog(null, "El nuevo valor solo puede ser 'Alta' o 'Baja'");
					}
					
					break;
				case 4:
					try {
						String especialidad=dbconn.SelectLista("Id_especialidad", "especialidad where nombre='"+modificacion_tratamiento.getText()+"'").get(0);
						dbconn.update("tratamiento", "Id_Especialidad='"+especialidad+"'", "nombre ='"+tratamiento.getSelectedItem().toString()+"'");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				default:
					JOptionPane.showMessageDialog(null, "Elige una operación.");
				}
			}
		});
	}

	public void rellenarCombo() {
		operacion.addItem("...");
		operacion.addItem("Modificar nombre");
		operacion.addItem("Modificar precio");
		operacion.addItem("Modificar estado");
		operacion.addItem("Modificar especialidad");
	}
	
	private void mostrarcombo(JComboBox desplegable_tratamiento) {

		desplegable_tratamiento.addItem("...");
		try {
			for(String nombre:dbconn.SelectLista("Nombre", "Tratamiento")) {
				desplegable_tratamiento.addItem(nombre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
    public static boolean esParseableAEntero(String valor) {
        try {
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
