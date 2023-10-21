package Modelo;

public class Citas {
	//atributos
	protected int ID_Cita;
	protected int ID_Paciente;
	protected int ID_Doctor;
	protected int ID_Epecialidad;
	protected String Fecha_Hora;
	protected String Motivo_Visita;
	
	//métodos
	public int getID_Cita() {
		return ID_Cita;
	}
	public void setID_Cita(int iD_Cita) {
		ID_Cita = iD_Cita;
	}
	public int getID_Paciente() {
		return ID_Paciente;
	}
	public void setID_Paciente(int iD_Paciente) {
		ID_Paciente = iD_Paciente;
	}
	public int getID_Doctor() {
		return ID_Doctor;
	}
	public void setID_Doctor(int iD_Doctor) {
		ID_Doctor = iD_Doctor;
	}
	public int getID_Epecialidad() {
		return ID_Epecialidad;
	}
	public void setID_Epecialidad(int iD_Epecialidad) {
		ID_Epecialidad = iD_Epecialidad;
	}
	public String getFecha_Hora() {
		return Fecha_Hora;
	}
	public void setFecha_Hora(String fecha_Hora) {
		Fecha_Hora = fecha_Hora;
	}
	public String getMotivo_Visita() {
		return Motivo_Visita;
	}
	public void setMotivo_Visita(String motivo_Visita) {
		Motivo_Visita = motivo_Visita;
	}
	@Override
	public String toString() {
		return "Citas [ID_Cita=" + ID_Cita + ", ID_Paciente=" + ID_Paciente + ", ID_Doctor=" + ID_Doctor
				+ ", ID_Epecialidad=" + ID_Epecialidad + ", Fecha_Hora=" + Fecha_Hora + ", Motivo_Visita="
				+ Motivo_Visita + "]";
	}
	//contructor
	public Citas(int iD_Cita, int iD_Paciente, int iD_Doctor, int iD_Epecialidad, String fecha_Hora,
			String motivo_Visita) {
		super();
		ID_Cita = iD_Cita;
		ID_Paciente = iD_Paciente;
		ID_Doctor = iD_Doctor;
		ID_Epecialidad = iD_Epecialidad;
		Fecha_Hora = fecha_Hora;
		Motivo_Visita = motivo_Visita;
	}
	
	

	

}
