package Vista.doctor;

import javax.swing.JPanel;

import Vista.Login_Inicio;

import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Modificar_Odontograma_M extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Modificar_Odontograma_M() {
		setOpaque(false);
		setBounds(100, 100, 720, 500);
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel = new JLabel("Odontograma");
		lblNewLabel.setBounds(310, 31, 123, 13);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(166, 81, 50, 50);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBounds(166, 144, 50, 51);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBounds(166, 205, 50, 50);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBounds(293, 80, 50, 51);
		add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setBounds(293, 144, 50, 50);
		add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setContentAreaFilled(false);
		btnNewButton_5.setBounds(293, 205, 50, 50);
		add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setContentAreaFilled(false);
		btnNewButton_6.setBounds(412, 81, 50, 50);
		add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.setContentAreaFilled(false);
		btnNewButton_7.setBounds(412, 144, 50, 51);
		add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.setContentAreaFilled(false);
		btnNewButton_8.setBounds(412, 205, 50, 50);
		add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("");
		btnNewButton_9.setContentAreaFilled(false);
		btnNewButton_9.setBounds(529, 144, 50, 51);
		add(btnNewButton_9);


	}
}
