package Controlador;

import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class BBDD {
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/dentiapp";
	private static final String USUARIO = "root";
	private static final String CLAVE = "1234";
	protected static final Component ConsultarCliente = null;

	static Connection cn = null;
	Statement stm = null;
	ResultSet Resultado = null;

	DefaultTableModel model = new DefaultTableModel();

	public Connection conectar() {

		try {
			cn = DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("Conexión OK");
			stm = cn.createStatement();

		} catch (SQLException e) {
			System.out.println("Error en la conexión");
			e.printStackTrace();
		}

		return cn;
	}

	public void insertar(String tableName, String valorintro) {
		conectar();
		try {
			DatabaseMetaData metaData = (DatabaseMetaData) cn.getMetaData();
			ResultSet resultSet = metaData.getColumns(null, null, tableName, null);
			String columnNames = "";

			while (resultSet.next()) {
				String columnName = resultSet.getString("COLUMN_NAME");
				columnNames += columnName + ",";
			}

			columnNames = columnNames.substring(0, columnNames.length() - 1); // Elimina la última coma
			// Pasa un String con todos los valores del insertar
			String valores = "";
			String[] valoresintro = valorintro.split(",");
			String[] columnNamesArray = columnNames.split(",");
			for (int i = 0; i < columnNamesArray.length; i++) {
				String columnName = columnNamesArray[i];
				String valor = valoresintro[i];
				
				if (valor.equalsIgnoreCase("null")) {
					valores += valor;					
				}
				else {
					valores += "'" + valor + "'";					
				}
				
				if (i < columnNamesArray.length - 1) {
					valores += ",";
				}
			}

			Statement statement = cn.createStatement();
			String query = "INSERT INTO " + tableName + " (" + columnNames + ") VALUES (" + valores + ")";
			statement.executeUpdate(query);
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(String tableName, String condicion, String valores) {
		try {
			// Utilizar metadatos para obtener información sobre la tabla
			DatabaseMetaData metaData = (DatabaseMetaData) cn.getMetaData();
			ResultSet resultSet = metaData.getPrimaryKeys(null, null, tableName);
			String primaryKeyName = "";
			if (resultSet.next()) {
				primaryKeyName = resultSet.getString("COLUMN_NAME");
			}

			// Solicitar al usuario una condición para actualizar registros
			// condicion = JOptionPane.showInputDialog("Ingrese la condición para actualizar
			// registros de la tabla " + tableName + " (Ejemplo: " + primaryKeyName + " =
			// 5):");

			if (condicion != null && !condicion.isEmpty()) {
				// Solicitar al usuario un conjunto de valores para actualizar
				// String valores = JOptionPane.showInputDialog("Ingrese el conjunto de valores
				// para actualizar (Ejemplo: columna1 = 'nuevo_valor', columna2 = 10):");

				if (valores != null && !valores.isEmpty()) {
					Statement statement = cn.createStatement();
					String query = "UPDATE " + tableName + " SET " + valores + " WHERE " + condicion;

					statement.executeUpdate(query);
					statement.close();

					JOptionPane.showMessageDialog(null,
							"Se han actualizado los registros que cumplan con la condición:\n" + condicion);
				} else {
					JOptionPane.showMessageDialog(null,
							"No se han especificado valores para actualizar. La operación se canceló.");
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"No se ha especificado una condición de actualización. La operación se canceló.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void borrar(String tableName, String condicion, String valor) {
		try {
			// Utilizar metadatos para obtener información sobre la tabla
			DatabaseMetaData metaData = (DatabaseMetaData) cn.getMetaData();
			ResultSet resultSet = metaData.getPrimaryKeys(null, null, tableName);
			String primaryKeyName = "";
			if (resultSet.next()) {
				primaryKeyName = resultSet.getString("COLUMN_NAME");
			}

			// Solicitar al usuario una condición para borrar registros
			// String condicion = JOptionPane.showInputDialog("Ingrese la condición para
			// borrar registros de la tabla " + tableName + " (Ejemplo: " + primaryKeyName +
			// " = 5):");

			if (condicion != null && !condicion.isEmpty()) {
				Statement statement = cn.createStatement();
				String query = "DELETE FROM " + tableName + " WHERE " + condicion + "= '" + valor + "';";

				statement.executeUpdate(query);
				statement.close();

				JOptionPane.showMessageDialog(null,
						"Se han eliminado los registros que cumplan con la condición:\n" + condicion);
			} else {
				JOptionPane.showMessageDialog(null,
						"No se ha especificado una condición de borrado. La operación se canceló.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<String> getColumnNames(String tableName) throws SQLException {
		List<String> columnNames = new ArrayList<>();

		DatabaseMetaData metaData = cn.getMetaData();
		ResultSet resultSet = metaData.getColumns(null, null, tableName, null);

		while (resultSet.next()) {
			String columnName = resultSet.getString("COLUMN_NAME");
			columnNames.add(columnName);
		}

		resultSet.close();
		return columnNames;
	}
	public List<String> SelectLista(String nombreCampo, String tableName) throws SQLException{
		List<String> valores = new ArrayList<>();

		DatabaseMetaData metaData = cn.getMetaData();
		ResultSet resultSet =stm.executeQuery("Select "+nombreCampo+" from dentiapp."+tableName+" ;");

		while (resultSet.next()) {
			String valor = resultSet.getString(nombreCampo);
			valores.add(valor);
		}

		resultSet.close();
		return valores;
		
		
	}
	

	public void SelectValor(JTable jTable1, String consultaSQL) throws SQLException {
		Vector<Object> filas = null;

	       //Vaciar tabla
        if (model.getRowCount()>0){
            int rows= jTable1.getRowCount();
            for (int a = 1; a<=rows; a++) {
                model.removeRow(0);
            }
        } 
        
        //Realizar consulta
        Resultado = stm.executeQuery(consultaSQL);

        // Obtener metadatos de la consulta
        ResultSetMetaData metaData = Resultado.getMetaData();
        int columnCount = metaData.getColumnCount();

        String[] columnNames = new String[columnCount];
        // Imprimir los nombres de las columnas
        for (int i = 1; i <= columnCount; i++) {
            model.addColumn(metaData.getColumnName(i));
            columnNames [i-1]= metaData.getColumnName(i);
            model.setColumnIdentifiers(columnNames);
        }
        
        model.addRow(columnNames);
        jTable1.setDefaultRenderer(Object.class, new FirstRowRenderer());
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
      

        // Imprimir los datos
        while (Resultado.next()) {
            filas = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                filas.add(Resultado.getString(i));
            }
            model.addRow(filas);
        }
        
        jTable1.setModel(model);
	}
	  private class FirstRowRenderer extends DefaultTableCellRenderer {
	        @Override
	        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	            Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

	            // Check if it's the first row
	            if (row == 0) {
	                // Set a different background color for the first row
	                rendererComponent.setBackground(Color.LIGHT_GRAY);
	            } else {
	                // Set the default background color for other rows
	                rendererComponent.setBackground(table.getBackground());
	            }

	            return rendererComponent;
	        }
	  }
	Statement createStatement() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}
}
