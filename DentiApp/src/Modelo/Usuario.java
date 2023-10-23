package Modelo;

public class Usuario {
	protected int ID_Usuario;
	protected String DNI_Usuario;
	protected String Contrasenya;
	protected String Perfil;
	
	
	public int getID_Usuario() {
		return ID_Usuario;
	}
	public void setID_Usuario(int iD_Usuario) {
		ID_Usuario = iD_Usuario;
	}
	public String getDNI_Usuario() {
		return DNI_Usuario;
	}
	public void setDNI_Usuario(String DNI_Usuario) {
		DNI_Usuario = DNI_Usuario;
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
		return "Usuario [ID_Usuario=" + ID_Usuario + ", Nombre=" + DNI_Usuario + ", Contrasenya=" + Contrasenya + ", Perfil="
				+ Perfil + "]";
	}
	public Usuario(int iD_Usuario, String nombre, String contrasenya, String perfil) {
		super();
		ID_Usuario = iD_Usuario;
		DNI_Usuario = nombre;
		Contrasenya = contrasenya;
		Perfil = perfil;
	}
	
	
	

}
