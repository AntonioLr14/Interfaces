package Modelo;

public class Tratamiento {
	//atributos
	protected int ID_Tratamiento;
	protected String Nombre;
	protected double Precio;
	//métodos
	public int getID_Tratamiento() {
		return ID_Tratamiento;
	}
	public void setID_Tratamiento(int iD_Tratamiento) {
		ID_Tratamiento = iD_Tratamiento;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public double getPrecio() {
		return Precio;
	}
	public void setPrecio(double precio) {
		Precio = precio;
	}
	@Override
	public String toString() {
		return "Tratamiento [ID_Tratamiento=" + ID_Tratamiento + ", Nombre=" + Nombre + ", Precio=" + Precio + "]";
	}
	//constructor
	public Tratamiento(int iD_Tratamiento, String nombre, double precio) {
		super();
		ID_Tratamiento = iD_Tratamiento;
		Nombre = nombre;
		Precio = precio;
	}
	
	

}
