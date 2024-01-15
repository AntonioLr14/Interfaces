package Vista.doctor;

import javax.swing.JPanel;

import Vista.Login_Inicio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import botonDentista.BotonDentista;
import javax.swing.border.LineBorder;

import Controlador.BBDD;
import prueba.Campo_texto_theme;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Modificar_Odontograma_M extends JPanel {
	private BBDD dbconn;
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Modificar_Odontograma_M() {
		setOpaque(false);
		setBounds(100, 100, 720, 500);
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		dbconn = new BBDD();
		dbconn.conectar();
		JLabel lblNewLabel = new JLabel("Odontograma");
		lblNewLabel.setBounds(336, 24, 123, 13);
		add(lblNewLabel);
		/*
		 * Id: 11, 12, 13, 14, 15 Id: 21, 22, 23, 24, 25
		 */

		BotonDentista botonAceptar = new BotonDentista();
		botonAceptar.setBorder(null);
		botonAceptar.setText("Aceptar");
		botonAceptar.setRadius(30);
		botonAceptar.setBounds(468, 61, 103, 33);
		add(botonAceptar);

		Campo_texto_theme tf_DNIUsuario = new Campo_texto_theme(20);
		tf_DNIUsuario.setBounds(334, 61, 123, 33);
		add(tf_DNIUsuario);

		JLabel lbl_DNI_Paciente = new JLabel("DNI / Nombre Completo:");
		lbl_DNI_Paciente.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_DNI_Paciente.setBounds(147, 61, 177, 34);
		add(lbl_DNI_Paciente);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (tf_DNIUsuario.getText().isBlank()) {
						throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
					} else {

						ArrayList<String> perfil = new ArrayList<String>(
								dbconn.SelectLista("Perfil", "usuario where DNI_Usuario = '" + tf_DNIUsuario.getText()
										+ "'" + "or concat(Nombre,' ',Apellidos) = '" + tf_DNIUsuario.getText() + "'"));

						if (perfil.size() == 0) {
							throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
						}

						if (!perfil.get(0).equalsIgnoreCase("paciente")) {
							throw new Exception("No has introducido el DNI del usuario de un paciente");
						}
						
					}
					Odontograma o = new Odontograma("11", tf_DNIUsuario.getText());
					o.setVisible(true);
					o.setLocationRelativeTo(null);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			
			}
		});

		btnNewButton_1.setIcon(
				new ImageIcon(Modificar_Odontograma_M.class.getResource("/Vista/imagenes/diente-de-incisivos.png")));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBounds(137, 125, 50, 51);
		add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (tf_DNIUsuario.getText().isBlank()) {
						throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
					} else {

						ArrayList<String> perfil = new ArrayList<String>(
								dbconn.SelectLista("Perfil", "usuario where DNI_Usuario = '" + tf_DNIUsuario.getText()
										+ "'" + "or concat(Nombre,' ',Apellidos) = '" + tf_DNIUsuario.getText() + "'"));

						if (perfil.size() == 0) {
							throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
						}

						if (!perfil.get(0).equalsIgnoreCase("paciente")) {
							throw new Exception("No has introducido el DNI del usuario de un paciente");
						}
						
					}
					Odontograma o = new Odontograma("12", tf_DNIUsuario.getText());
					o.setVisible(true);
					o.setLocationRelativeTo(null);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			
			}
		});
		btnNewButton_2
				.setIcon(new ImageIcon(Modificar_Odontograma_M.class.getResource("/Vista/imagenes/diente-canino.png")));
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBounds(240, 125, 50, 50);
		add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (tf_DNIUsuario.getText().isBlank()) {
						throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
					} else {

						ArrayList<String> perfil = new ArrayList<String>(
								dbconn.SelectLista("Perfil", "usuario where DNI_Usuario = '" + tf_DNIUsuario.getText()
										+ "'" + "or concat(Nombre,' ',Apellidos) = '" + tf_DNIUsuario.getText() + "'"));

						if (perfil.size() == 0) {
							throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
						}

						if (!perfil.get(0).equalsIgnoreCase("paciente")) {
							throw new Exception("No has introducido el DNI del usuario de un paciente");
						}
						
					}
					Odontograma o = new Odontograma("13", tf_DNIUsuario.getText());
					o.setVisible(true);
					o.setLocationRelativeTo(null);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			
			}
		});
		btnNewButton_3
				.setIcon(new ImageIcon(Modificar_Odontograma_M.class.getResource("/Vista/imagenes/premolar.png")));
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBounds(349, 125, 50, 51);
		add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (tf_DNIUsuario.getText().isBlank()) {
						throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
					} else {

						ArrayList<String> perfil = new ArrayList<String>(
								dbconn.SelectLista("Perfil", "usuario where DNI_Usuario = '" + tf_DNIUsuario.getText()
										+ "'" + "or concat(Nombre,' ',Apellidos) = '" + tf_DNIUsuario.getText() + "'"));

						if (perfil.size() == 0) {
							throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
						}

						if (!perfil.get(0).equalsIgnoreCase("paciente")) {
							throw new Exception("No has introducido el DNI del usuario de un paciente");
						}
						
					}
					Odontograma o = new Odontograma("14", tf_DNIUsuario.getText());
					o.setVisible(true);
					o.setLocationRelativeTo(null);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			
			}
		});
		btnNewButton_4
				.setIcon(new ImageIcon(Modificar_Odontograma_M.class.getResource("/Vista/imagenes/diente_odon.png")));
		btnNewButton_4.setFocusable(false);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setBounds(452, 127, 50, 50);
		add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (tf_DNIUsuario.getText().isBlank()) {
						throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
					} else {

						ArrayList<String> perfil = new ArrayList<String>(
								dbconn.SelectLista("Perfil", "usuario where DNI_Usuario = '" + tf_DNIUsuario.getText()
										+ "'" + "or concat(Nombre,' ',Apellidos) = '" + tf_DNIUsuario.getText() + "'"));

						if (perfil.size() == 0) {
							throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
						}

						if (!perfil.get(0).equalsIgnoreCase("paciente")) {
							throw new Exception("No has introducido el DNI del usuario de un paciente");
						}
						
					}
					Odontograma o = new Odontograma("15", tf_DNIUsuario.getText());
					o.setVisible(true);
					o.setLocationRelativeTo(null);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			
			}
		});
		btnNewButton_5
				.setIcon(new ImageIcon(Modificar_Odontograma_M.class.getResource("/Vista/imagenes/diente_odon.png")));
		btnNewButton_5.setFocusable(false);
		btnNewButton_5.setBorderPainted(false);
		btnNewButton_5.setBorder(null);
		btnNewButton_5.setContentAreaFilled(false);
		btnNewButton_5.setBounds(548, 126, 50, 50);
		add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (tf_DNIUsuario.getText().isBlank()) {
						throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
					} else {

						ArrayList<String> perfil = new ArrayList<String>(
								dbconn.SelectLista("Perfil", "usuario where DNI_Usuario = '" + tf_DNIUsuario.getText()
										+ "'" + "or concat(Nombre,' ',Apellidos) = '" + tf_DNIUsuario.getText() + "'"));

						if (perfil.size() == 0) {
							throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
						}

						if (!perfil.get(0).equalsIgnoreCase("paciente")) {
							throw new Exception("No has introducido el DNI del usuario de un paciente");
						}
						
					}
					Odontograma o = new Odontograma("21", tf_DNIUsuario.getText());
					o.setVisible(true);
					o.setLocationRelativeTo(null);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			
			}
		});
		btnNewButton_6.setIcon(
				new ImageIcon(Modificar_Odontograma_M.class.getResource("/Vista/imagenes/diente-de-incisivos.png")));
		btnNewButton_6.setFocusable(false);
		btnNewButton_6.setBorderPainted(false);
		btnNewButton_6.setBorder(null);
		btnNewButton_6.setContentAreaFilled(false);
		btnNewButton_6.setBounds(137, 186, 50, 50);
		add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (tf_DNIUsuario.getText().isBlank()) {
						throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
					} else {

						ArrayList<String> perfil = new ArrayList<String>(
								dbconn.SelectLista("Perfil", "usuario where DNI_Usuario = '" + tf_DNIUsuario.getText()
										+ "'" + "or concat(Nombre,' ',Apellidos) = '" + tf_DNIUsuario.getText() + "'"));

						if (perfil.size() == 0) {
							throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
						}

						if (!perfil.get(0).equalsIgnoreCase("paciente")) {
							throw new Exception("No has introducido el DNI del usuario de un paciente");
						}
						
					}
					Odontograma o = new Odontograma("22", tf_DNIUsuario.getText());
					o.setVisible(true);
					o.setLocationRelativeTo(null);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			
			}
		});
		btnNewButton_7
				.setIcon(new ImageIcon(Modificar_Odontograma_M.class.getResource("/Vista/imagenes/diente-canino.png")));
		btnNewButton_7.setFocusable(false);
		btnNewButton_7.setBorderPainted(false);
		btnNewButton_7.setBorder(null);
		btnNewButton_7.setContentAreaFilled(false);
		btnNewButton_7.setBounds(240, 186, 50, 51);
		add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (tf_DNIUsuario.getText().isBlank()) {
						throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
					} else {

						ArrayList<String> perfil = new ArrayList<String>(
								dbconn.SelectLista("Perfil", "usuario where DNI_Usuario = '" + tf_DNIUsuario.getText()
										+ "'" + "or concat(Nombre,' ',Apellidos) = '" + tf_DNIUsuario.getText() + "'"));

						if (perfil.size() == 0) {
							throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
						}

						if (!perfil.get(0).equalsIgnoreCase("paciente")) {
							throw new Exception("No has introducido el DNI del usuario de un paciente");
						}
						
					}
					Odontograma o = new Odontograma("23", tf_DNIUsuario.getText());
					o.setVisible(true);
					o.setLocationRelativeTo(null);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			
			}
		});
		btnNewButton_8
				.setIcon(new ImageIcon(Modificar_Odontograma_M.class.getResource("/Vista/imagenes/premolar.png")));
		btnNewButton_8.setFocusable(false);
		btnNewButton_8.setBorderPainted(false);
		btnNewButton_8.setBorder(null);
		btnNewButton_8.setContentAreaFilled(false);
		btnNewButton_8.setBounds(349, 187, 50, 50);
		add(btnNewButton_8);

		JButton btnNewButton_9 = new JButton("");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (tf_DNIUsuario.getText().isBlank()) {
						throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
					} else {

						ArrayList<String> perfil = new ArrayList<String>(
								dbconn.SelectLista("Perfil", "usuario where DNI_Usuario = '" + tf_DNIUsuario.getText()
										+ "'" + "or concat(Nombre,' ',Apellidos) = '" + tf_DNIUsuario.getText() + "'"));

						if (perfil.size() == 0) {
							throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
						}

						if (!perfil.get(0).equalsIgnoreCase("paciente")) {
							throw new Exception("No has introducido el DNI del usuario de un paciente");
						}
						
					}
					Odontograma o = new Odontograma("24", tf_DNIUsuario.getText());
					o.setVisible(true);
					o.setLocationRelativeTo(null);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			
			}
		});
		btnNewButton_9
				.setIcon(new ImageIcon(Modificar_Odontograma_M.class.getResource("/Vista/imagenes/diente_odon.png")));
		btnNewButton_9.setFocusable(false);
		btnNewButton_9.setBorderPainted(false);
		btnNewButton_9.setBorder(null);
		btnNewButton_9.setContentAreaFilled(false);
		btnNewButton_9.setBounds(452, 185, 50, 51);
		add(btnNewButton_9);

		JButton btnNewButton_10 = new JButton("");
		btnNewButton_10.setFocusable(false);
		btnNewButton_10.setBorderPainted(false);
		btnNewButton_10
				.setIcon(new ImageIcon(Modificar_Odontograma_M.class.getResource("/Vista/imagenes/diente_odon.png")));
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (tf_DNIUsuario.getText().isBlank()) {
						throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
					} else {

						ArrayList<String> perfil = new ArrayList<String>(
								dbconn.SelectLista("Perfil", "usuario where DNI_Usuario = '" + tf_DNIUsuario.getText()
										+ "'" + "or concat(Nombre,' ',Apellidos) = '" + tf_DNIUsuario.getText() + "'"));

						if (perfil.size() == 0) {
							throw new Exception("No has introducido el DNI o el nombre del usuario correctamente");
						}

						if (!perfil.get(0).equalsIgnoreCase("paciente")) {
							throw new Exception("No has introducido el DNI del usuario de un paciente");
						}
						
					}
					Odontograma o = new Odontograma("25", tf_DNIUsuario.getText());
					o.setVisible(true);
					o.setLocationRelativeTo(null);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			
			}
		});
		btnNewButton_10.setBorder(null);
		btnNewButton_10.setContentAreaFilled(false);
		btnNewButton_10.setBounds(548, 186, 50, 50);
		add(btnNewButton_10);

	}
}
