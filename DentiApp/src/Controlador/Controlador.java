package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import java.util.ArrayList;


public class Controlador {
    private ConexionMySQL conexion;
     public Controlador(ConexionMySQL conexion){
         this.conexion=conexion;
}
         
     
     /*public ArrayList<Cancion> Obtener usuarios() throws SQLException{
        ArrayList<Cancion> lista = new ArrayList<>();
        String consulta = "SELECT * FROM usuarios";
        ResultSet rset = conexion.EjercutarSelect(consulta);
        while(rset.next()){
            String  = rset.getString("Nombre");
            String album = rset.getString("Album");
            String artista = rset.getString("Artista");
            String duracion = rset.getString("Duracion");
            Cancion can = new Cancion(titulo, album, artista, duracion);
            lista.add(can);
        }
        return lista;
    }*/
}
