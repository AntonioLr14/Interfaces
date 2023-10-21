package Modelo;

public class Historial {
	//atributos
	protected int ID_Historial;
	protected int ID_Cita;
	protected String Fecha;
	
	//metodos
	public int getID_Historial() {
		return ID_Historial;
	}
	public void setID_Historial(int iD_Historial) {
		ID_Historial = iD_Historial;
	}
	public int getID_Cita() {
		return ID_Cita;
	}
	public void setID_Cita(int iD_Cita) {
		ID_Cita = iD_Cita;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	@Override
	public String toString() {
		return "Historial [ID_Historial=" + ID_Historial + ", ID_Cita=" + ID_Cita + ", Fecha=" + Fecha + "]";
	}
	
	//constructor
	public Historial(int iD_Historial, int iD_Cita, String fecha) {
		super();
		ID_Historial = iD_Historial;
		ID_Cita = iD_Cita;
		Fecha = fecha;
	}
	
	
	

}
