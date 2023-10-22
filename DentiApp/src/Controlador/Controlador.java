package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;


public class Controlador {

    private ConexionMySQL conexion;

    public Controlador(ConexionMySQL conexion) {
        this.conexion = conexion;
    }

    public ArrayList<Usuario> ObtenerTodosArticulos() throws SQLException { // Va a devolver un ArrayList de Usuarios
        ArrayList<Usuario> lista = new ArrayList<>();
        String consulta = "SELECT * FROM usuario";
        ResultSet rset = conexion.ejecutarSelect(consulta);
        while (rset.next()) {
        	int id=rset.getInt("ID_Usuario");
            String nombre = rset.getString("Nombre");
            String contra = rset.getString("Contrasenya");
            String perfil = rset.getString("Perfil");
            Usuario us = new Usuario(id,nombre, contra, perfil);
            lista.add(us);
        }
        return lista;
    }
    
    public String UpdateUsuario(String nuevo, String nombre) throws SQLException {
        String consulta = "UPDATE usuario set Contrasenya ='" + nuevo + "' where ID_Usuario = " + nombre + " ;";
        System.out.println(consulta);
        //UPDATE producto set precio=2*precio where id_fabricante=(SELECT id FROM fabricante WHERE nombre='Asus');
        conexion.ejecutarInsertDeleteUpdate(consulta);
        return consulta;
    }
}
