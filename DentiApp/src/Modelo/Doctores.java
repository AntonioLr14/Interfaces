package Modelo;

public class Doctores {
	//atributos
	protected String DNI;
	protected int ID_Especislidad;
	protected String Nombre;
	protected String Apellidos;
	protected int Telefono;
	protected String Direccion;
	protected String Fecha_Nacimiento;
	protected double Salario;
	protected String Correo;
	//métodos
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public int getID_Especislidad() {
		return ID_Especislidad;
	}
	public void setID_Especislidad(int iD_Especislidad) {
		ID_Especislidad = iD_Especislidad;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
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
	public String getFecha_Nacimiento() {
		return Fecha_Nacimiento;
	}
	public void setFecha_Nacimiento(String fecha_Nacimiento) {
		Fecha_Nacimiento = fecha_Nacimiento;
	}
	public double getSalario() {
		return Salario;
	}
	public void setSalario(double salario) {
		Salario = salario;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	@Override
	public String toString() {
		return "Doctores [DNI=" + DNI + ", ID_Especislidad=" + ID_Especislidad + ", Nombre=" + Nombre + ", Apellidos="
				+ Apellidos + ", Telefono=" + Telefono + ", Direccion=" + Direccion + ", Fecha_Nacimiento="
				+ Fecha_Nacimiento + ", Salario=" + Salario + ", Correo=" + Correo + "]";
	}
	//constructor
	public Doctores(String dNI, int iD_Especislidad, String nombre, String apellidos, int telefono, String direccion,
			String fecha_Nacimiento, double salario, String correo) {
		super();
		DNI = dNI;
		ID_Especislidad = iD_Especislidad;
		Nombre = nombre;
		Apellidos = apellidos;
		Telefono = telefono;
		Direccion = direccion;
		Fecha_Nacimiento = fecha_Nacimiento;
		Salario = salario;
		Correo = correo;
	}
	
	
	
}
