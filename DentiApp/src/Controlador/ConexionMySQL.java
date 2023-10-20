package Controlador;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.TimeZone;


public class ConexionMySQL {
    private String USUARIO;
    private String BBDD;
    private  String PASS;
    private String HOST;
    private Connection connection;
    private TimeZone zonaHoraria;
   
    public ConexionMySQL(String usuario, String pass, String bd){
        HOST = "localhost";
        USUARIO = usuario;
        PASS = pass;
        BBDD = bd;
        connection = null;
    }
     public void conectar() throws SQLException, ClassNotFoundException{
        if(connection == null || connection.isClosed()){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Calendar now = Calendar.getInstance();
                zonaHoraria = now.getTimeZone();
                connection = (Connection)DriverManager.getConnection("jdbc:mysql://"+HOST+"/"+BBDD+"?user="+USUARIO+"&password="+PASS+"&userLegacyDateTimeCode=false&serverTimeZone="+zonaHoraria.getID());
            } catch(SQLException e){
                System.out.println("Error");
            }
        }
    }
     public void Desconectar() throws SQLException{
        if(connection != null && !connection.isClosed()){
            connection.close();
        }
       
    }
      public ResultSet EjercutarSelect(String consulta) throws SQLException{
        Statement stmt = connection.createStatement();
        ResultSet rset = stmt.executeQuery(consulta);
        return rset;
    }
   
   
    public int EjecutarInsertDeleteUpdate(String consulta) throws SQLException{
        Statement stmt = connection.createStatement();
        int fila = stmt.executeUpdate(consulta);
        return fila;
    }
}
