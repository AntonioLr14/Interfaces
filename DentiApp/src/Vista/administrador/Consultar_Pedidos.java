package Vista.administrador;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Consultar_Pedidos extends JPanel {

	protected JComboBox<String> proveedor;
	protected JComboBox<String> fecha;
	protected JTextArea consultas_pedidos;
	
	public Consultar_Pedidos() {
		
		setBounds(0, 0, 720, 500);
		setLayout(null);
		
		this.proveedor = new JComboBox<String>();
		this.fecha = new JComboBox<String>();
		this.consultas_pedidos = new JTextArea();
		
		JLabel lblNewLabel = new JLabel("Proveedor:");
		lblNewLabel.setBounds(126, 42, 70, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha:");
		lblNewLabel_1.setBounds(394, 42, 45, 13);
		add(lblNewLabel_1);
		
		Choice choice = new Choice();
		choice.setBounds(93, 61, 129, 18);
		add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(346, 61, 129, 18);
		add(choice_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(113, 110, 349, 147);
		add(textPane);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setBounds(497, 240, 85, 21);
		add(btnNewButton);
	}
}
