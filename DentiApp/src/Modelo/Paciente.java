package Modelo;

public class Paciente {

	//atributos
	protected String DNI;
	protected String Nombre;
	protected String Apellido;
	protected int Telefono;
	protected String Direccion;
	
	//métodos
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public int getTelefono() {
		return Telefono;
	}
	public void setTelefono(int telefono) {
		Telefono = telefono;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	@Override
	public String toString() {
		return "Paciente [DNI=" + DNI + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Telefono=" + Telefono
				+ ", Direccion=" + Direccion + "]";
	}
	//constructor
	public Paciente(String dNI, String nombre, String apellido, int telefono, String direccion) {
		super();
		DNI = dNI;
		Nombre = nombre;
		Apellido = apellido;
		Telefono = telefono;
		Direccion = direccion;
	}
	
	
	
	
}
