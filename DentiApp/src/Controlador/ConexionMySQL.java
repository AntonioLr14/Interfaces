package Controlador;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.TimeZone;


public class ConexionMySQL {
	
	 private String url = "jdbc:mysql://localhost:3306/dentiapp";
     private String usuario = "root";
     private String contraseña = "1234"; 
     private Connection connection;



   public ConexionMySQL(String url, String usuario, String contraseña, Connection connection) {
		super();
		this.url = url;
		this.usuario = usuario;
		this.contraseña = contraseña;

	}
public void conectar() throws SQLException,ClassNotFoundException{
    if(connection==null||connection.isClosed()){


         // Intentar establecer la conexión
         try {
             connection = DriverManager.getConnection(url, usuario, contraseña);

             // La conexión se ha establecido correctamente
             System.out.println("¡Conexión exitosa a la base de datos!");

             // Aquí puedes realizar operaciones en la base de datos

             // No olvides cerrar la conexión cuando hayas terminado
             connection.close();

         } catch (SQLException e) {
             // Manejo de errores
             System.out.println("Error al conectar a la base de datos: " + e.getMessage());
         }
    }
}
   public void desconectar() throws SQLException{
if(connection!=null && !connection.isClosed()){
    connection.close();
    System.out.println("Estas desconectado de la base de datos");
}
}
   public ResultSet ejecutarSelect(String consulta) throws SQLException{
       Statement stmt=connection.createStatement();
       ResultSet rset=stmt.executeQuery(consulta);
       return rset;
   }
public int ejecutarInsertDeleteUpdate(String consulta) throws SQLException{
    Statement stmt=connection.createStatement();
    int fila=stmt.executeUpdate(consulta);
    return fila;
}
}
