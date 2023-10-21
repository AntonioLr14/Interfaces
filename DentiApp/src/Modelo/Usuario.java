package Modelo;

public class Usuario {
	protected int ID_Usuario;
	protected String Nombre;
	protected String Contrasenya;
	protected String Perfil;
	
	
	public int getID_Usuario() {
		return ID_Usuario;
	}
	public void setID_Usuario(int iD_Usuario) {
		ID_Usuario = iD_Usuario;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getContrasenya() {
		return Contrasenya;
	}
	public void setContrasenya(String contrasenya) {
		Contrasenya = contrasenya;
	}
	public String getPerfil() {
		return Perfil;
	}
	public void setPerfil(String perfil) {
		Perfil = perfil;
	}
	
	@Override
	public String toString() {
		return "Usuario [ID_Usuario=" + ID_Usuario + ", Nombre=" + Nombre + ", Contrasenya=" + Contrasenya + ", Perfil="
				+ Perfil + "]";
	}
	public Usuario(int iD_Usuario, String nombre, String contrasenya, String perfil) {
		super();
		ID_Usuario = iD_Usuario;
		Nombre = nombre;
		Contrasenya = contrasenya;
		Perfil = perfil;
	}
	
	
	

}
