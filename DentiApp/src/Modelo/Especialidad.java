package Modelo;

public class Especialidad {
	//atributos
	protected int ID_Especialidad;
	protected String Nombre;
	protected String Descripcion;
	
	//métodos
	public int getID_Especialidad() {
		return ID_Especialidad;
	}
	public void setID_Especialidad(int iD_Especialidad) {
		ID_Especialidad = iD_Especialidad;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "Especialidad [ID_Especialidad=" + ID_Especialidad + ", Nombre=" + Nombre + ", Descripcion="
				+ Descripcion + "]";
	}
	//constructor
	public Especialidad(int iD_Especialidad, String nombre, String descripcion) {
		super();
		ID_Especialidad = iD_Especialidad;
		Nombre = nombre;
		Descripcion = descripcion;
	}
	
	
	
}
