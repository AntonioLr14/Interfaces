package Modelo;

public class Proveedor {
	//atributos
	protected int ID_proveedor;
	protected String Nombre;
	protected String Direccion;
	protected int Telefono;
	protected String Correo;
	//métodos
	public int getID_proveedor() {
		return ID_proveedor;
	}
	public void setID_proveedor(int iD_proveedor) {
		ID_proveedor = iD_proveedor;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public int getTelefono() {
		return Telefono;
	}
	public void setTelefono(int telefono) {
		Telefono = telefono;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	@Override
	public String toString() {
		return "Proveedor [ID_proveedor=" + ID_proveedor + ", Nombre=" + Nombre + ", Direccion=" + Direccion
				+ ", Telefono=" + Telefono + ", Correo=" + Correo + "]";
	}
	//constructor
	public Proveedor(int iD_proveedor, String nombre, String direccion, int telefono, String correo) {
		super();
		ID_proveedor = iD_proveedor;
		Nombre = nombre;
		Direccion = direccion;
		Telefono = telefono;
		Correo = correo;
	}
	
	

}
