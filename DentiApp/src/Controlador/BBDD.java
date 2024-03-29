package Controlador;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BBDD {
	
	// Atributos
	protected String host;
	protected String usuario;
	protected String password;
	public static Connection dbconn;

	// Constructores
	public BBDD() {
		this.host = "jdbc:mysql://localhost:3306/dentiapp";
		this.usuario = "root";
		this.password = "1234";
	}
	
	// Metodos
	public Connection conectar() throws Exception {
		
		if (Objects.isNull(dbconn) || dbconn.isClosed()) {
			dbconn = DriverManager.getConnection(host,usuario,password);
			return dbconn;
		}
		else {
			throw new Exception("No estas desconectado de la base de datos");
		}
	}
	
	public void desconectar() throws Exception {
		
		if (Objects.nonNull(dbconn) && dbconn.isClosed() == false) {
			dbconn.close();
		}
		else {
			throw new Exception("No estas conectado de la base de datos");
		}
	}
	
	public ResultSet consulta(String consulta) throws Exception{
		
		PreparedStatement estamento = dbconn.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet resultado = estamento.executeQuery();
		
		return resultado;
	}

	public int insertUpdateDelete(String consulta) throws Exception{
		
		PreparedStatement estamento = dbconn.prepareStatement(consulta);
		int resultado = estamento.executeUpdate();
		
		return resultado;
	}
	
	public ArrayList<String> getColumnas(String tabla) throws Exception{
		
		DatabaseMetaData metadatos = dbconn.getMetaData();
		ResultSet resultado = metadatos.getColumns(null, null, tabla, null);
		
		ArrayList<String> columnas = new ArrayList<>();

		while (resultado.next()) {
			columnas.add(resultado.getString("COLUMN_NAME"));
		}
		
		return columnas;
	}
	
	public void cabeceraTabla(JTable tabla, String consulta) throws Exception {
		
		DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
		
        ResultSetMetaData metadatos = consulta(consulta).getMetaData();
        modelo.setColumnCount(metadatos.getColumnCount());

        for (int i = 1; i <= modelo.getColumnCount(); i++) {
        	tabla.getColumnModel().getColumn(i - 1).setHeaderValue(metadatos.getColumnName(i));
        }
        
        tabla.getTableHeader().setBackground(new Color(55,153,255));
	}
}
