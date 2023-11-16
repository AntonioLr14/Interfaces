package Controlador;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BBDD {
	 private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	    private static final String URL = "jdbc:mysql://localhost:3306/dentiapp?useSSL=false";
	    private static final String USUARIO = "root";
	    private static final String CLAVE = "1234";
	    protected static final Component ConsultarCliente = null;

	    Connection cn = null;
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
	    
	    
	    
	    public void insertar(String tableName,String valorintro) {
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
	            	//Pasa un String con todos los valores del insertar
	            String valores = "";
	            String[] valoresintro=valorintro.split(",");
	            String[] columnNamesArray = columnNames.split(",");
	            for (int i = 0; i < columnNamesArray.length; i++) {
	                String columnName = columnNamesArray[i];
	                String valor =valoresintro[i];
	                valores += "'" + valor + "'";
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
	    public void update(String tableName,String condicion,String valores) {
	        try {
	            // Utilizar metadatos para obtener información sobre la tabla
	            DatabaseMetaData metaData = (DatabaseMetaData) cn.getMetaData();
	            ResultSet resultSet = metaData.getPrimaryKeys(null, null, tableName);
	            String primaryKeyName = "";
	            if (resultSet.next()) {
	                primaryKeyName = resultSet.getString("COLUMN_NAME");
	            }

	            // Solicitar al usuario una condición para actualizar registros
	           // condicion = JOptionPane.showInputDialog("Ingrese la condición para actualizar registros de la tabla " + tableName + " (Ejemplo: " + primaryKeyName + " = 5):");

	            if (condicion != null && !condicion.isEmpty()) {
	                // Solicitar al usuario un conjunto de valores para actualizar
	                //String valores = JOptionPane.showInputDialog("Ingrese el conjunto de valores para actualizar (Ejemplo: columna1 = 'nuevo_valor', columna2 = 10):");

	                if (valores != null && !valores.isEmpty()) {
	                    Statement statement = cn.createStatement();
	                    String query = "UPDATE " + tableName + " SET " + valores + " WHERE " + condicion;
	                    
	                    statement.executeUpdate(query);
	                    statement.close();

	                    JOptionPane.showMessageDialog(null, "Se han actualizado los registros que cumplan con la condición:\n" + condicion);
	                } else {
	                    JOptionPane.showMessageDialog(null, "No se han especificado valores para actualizar. La operación se canceló.");
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "No se ha especificado una condición de actualización. La operación se canceló.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    public void borrar(String tableName,String condicion,String valor) {
	        try {
	            // Utilizar metadatos para obtener información sobre la tabla
	            DatabaseMetaData metaData = (DatabaseMetaData) cn.getMetaData();
	            ResultSet resultSet = metaData.getPrimaryKeys(null, null, tableName);
	            String primaryKeyName = "";
	            if (resultSet.next()) {
	                primaryKeyName = resultSet.getString("COLUMN_NAME");
	            }

	            // Solicitar al usuario una condición para borrar registros
	           // String condicion = JOptionPane.showInputDialog("Ingrese la condición para borrar registros de la tabla " + tableName + " (Ejemplo: " + primaryKeyName + " = 5):");

	            if (condicion != null && !condicion.isEmpty()) {
	                Statement statement = cn.createStatement();
	                String query = "DELETE FROM " + tableName + " WHERE " + condicion+"= '"+valor+"';";

	                
	                statement.executeUpdate(query);
	                statement.close();

	                JOptionPane.showMessageDialog(null, "Se han eliminado los registros que cumplan con la condición:\n" + condicion);
	            } else {
	                JOptionPane.showMessageDialog(null, "No se ha especificado una condición de borrado. La operación se canceló.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    public String[] SelectColumna(String[] a, String tableName) throws SQLException {
	    	ResultSet Resultado;
	    	String consultaSQL="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '"+tableName+"';";
	    	Resultado = stm.executeQuery(consultaSQL);

            // Obtener metadatos de la consulta
            ResultSetMetaData metaData = Resultado.getMetaData();
            int columnCount = metaData.getColumnCount();

            String[] columnNames = new String[columnCount];
            return a;
	    }
	    public String[] SelectValor(String[] a, String consultaSQL) throws SQLException {
	    	ResultSet Resultado;
	    	Resultado = stm.executeQuery(consultaSQL);

            // Obtener metadatos de la consulta
            ResultSetMetaData metaData = Resultado.getMetaData();
            int columnCount = metaData.getColumnCount();

            String[] columnNames = new String[columnCount];
            return a;
	    }
	    Statement createStatement() {
	        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	    }
}
