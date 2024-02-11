package Vista.doctor.ayudas;

import java.awt.Color;
import java.awt.Dimension;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.JEditorPane;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;

public class Mostrar_ayuda extends JFrame{
	
	// Atributos
	protected JPanel panel;
	protected JScrollPane scrollpanel;
	protected JEditorPane panel_html;
	protected JTree indice;

	// Constructores
	public Mostrar_ayuda() {
		
		// Creacion de los paneles
		this.panel = new JPanel();
		
		this.panel.setBorder(new EmptyBorder(5,5,5,5));
		this.panel.setLayout(null);

		// Creacion de los elementos graficos
		this.scrollpanel = new JScrollPane();
		
		this.scrollpanel.setBounds(210, 12, 578, 439);
		this.scrollpanel.setBorder(new LineBorder(Color.black));
		this.scrollpanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.panel_html = new JEditorPane();
		
		this.panel_html.setContentType("text/html");
		this.panel_html.setEditable(false);
		
		this.scrollpanel.setViewportView(this.panel_html);

		DefaultMutableTreeNode doctor = new DefaultMutableTreeNode();
		doctor.setUserObject("doctor");
		
		DefaultTreeCellRenderer nodos = new DefaultTreeCellRenderer();
		nodos.setBackgroundNonSelectionColor(null);

		this.indice = new JTree(doctor);

		this.indice.setBounds(10, 12, 200, 439);
		this.indice.setBackground(null);
		this.indice.setCellRenderer(nodos);
		this.indice.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
				
		this.panel.add(this.scrollpanel);
		this.panel.add(this.indice);

		try {

			// Establecimiento de los nodos al indice
			DirectoryStream<Path> directorios = Files.newDirectoryStream(Path.of("src/Vista/doctor/ayudas/html/"), "*_*");

			directorios.forEach( (a) -> {
				
				try {

					DefaultMutableTreeNode directorio = new DefaultMutableTreeNode();
					directorio.setUserObject(a.getFileName().toString().replaceAll("_", " "));

					DirectoryStream<Path> archivos = Files.newDirectoryStream(Path.of(a.toFile().getPath()), "*.html");
					
					archivos.forEach( (b) -> {

						DefaultMutableTreeNode archivo = new DefaultMutableTreeNode();
						
						String nombre_archivo = b.getFileName().toString().replaceAll("_", " ");
						archivo.setUserObject(nombre_archivo.replaceAll(".html", ""));

						directorio.add(archivo);
					});
					
					doctor.add(directorio);
				}
				catch (Exception error) {
					
					JOptionPane.showMessageDialog(
						null,
						error.getMessage(),
						"Error en la visualizacion de las ayudas",
						JOptionPane.ERROR_MESSAGE,
						null
					);
				}
			});
		}
		catch (Exception error) {
			
			JOptionPane.showMessageDialog(
				null,
				error.getMessage(),
				"Error en la visualizacion de las ayudas",
				JOptionPane.ERROR_MESSAGE,
				null
			);
		}

		// Establecimiento de los eventos
		this.indice.addTreeSelectionListener( (event) -> {
			
			try {
				
				DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) this.indice.getLastSelectedPathComponent();
				
				if (nodo.isLeaf()) {
					
					String directorio = nodo.getParent().toString().replaceAll("\s", "_");
					String archivo = nodo.getUserObject().toString().replaceAll("\s", "_");
					
					String contenido = Files.readString(Path.of("src/Vista/doctor/ayudas/html/" + directorio + "/" + archivo + ".html"));

					this.panel_html.setText(contenido);
					this.panel_html.moveCaretPosition(0);
				}
			}
			catch (Exception error) {
				
				JOptionPane.showMessageDialog(
					null,
					error.getMessage(),
					"Error en la visualizacion de las ayudas",
					JOptionPane.ERROR_MESSAGE,
					null
				);
			}
		});				
		
		this.panel_html.addHyperlinkListener( (event) -> {
		
			if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
		
				try {
					
					String contenido = Files.readString(Path.of(event.getURL().getPath()));
					
					this.panel_html.setText(contenido);
					this.panel_html.moveCaretPosition(0);
				}
				catch (Exception error) {
					
					JOptionPane.showMessageDialog(
						null,
						error.getMessage(),
						"Error en la visualizacion de las ayudas",
						JOptionPane.ERROR_MESSAGE,
						null
					);
				}
			}
		});
				
		// Caracteristicas del frame
		setContentPane(this.panel);
		
		setResizable(false);
		
		setTitle("Ayuda del doctor");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(800,500));
		setLocationByPlatform(true);
	}
}
