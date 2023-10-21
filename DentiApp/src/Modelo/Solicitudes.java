package Modelo;

public class Solicitudes {
	//atributos
	protected int ID_Solicitud;
	protected int ID_Cita;
	protected int ID_Material;
	protected int Cantidad;
	//métodos
	public int getID_Solicitud() {
		return ID_Solicitud;
	}
	public void setID_Solicitud(int iD_Solicitud) {
		ID_Solicitud = iD_Solicitud;
	}
	public int getID_Cita() {
		return ID_Cita;
	}
	public void setID_Cita(int iD_Cita) {
		ID_Cita = iD_Cita;
	}
	public int getID_Material() {
		return ID_Material;
	}
	public void setID_Material(int iD_Material) {
		ID_Material = iD_Material;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "Solicitudes [ID_Solicitud=" + ID_Solicitud + ", ID_Cita=" + ID_Cita + ", ID_Material=" + ID_Material
				+ ", Cantidad=" + Cantidad + "]";
	}
	//constructor
	public Solicitudes(int iD_Solicitud, int iD_Cita, int iD_Material, int cantidad) {
		super();
		ID_Solicitud = iD_Solicitud;
		ID_Cita = iD_Cita;
		ID_Material = iD_Material;
		Cantidad = cantidad;
	}
	

}
