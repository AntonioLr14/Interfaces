package Modelo;

public class Pagar {
	//atributos
	protected int ID_Pago;
	protected String DNI_Paciente;
	protected double Cantidad_Pagada;
	protected String Pago;
	protected String Duracion_Pago;
	protected double Cantidad_Total_Pagar;
	//métodos
	public int getID_Pago() {
		return ID_Pago;
	}
	public void setID_Pago(int iD_Pago) {
		ID_Pago = iD_Pago;
	}
	public String getDNI_Paciente() {
		return DNI_Paciente;
	}
	public void setDNI_Paciente(String dNI_Paciente) {
		DNI_Paciente = dNI_Paciente;
	}
	public double getCantidad_Pagada() {
		return Cantidad_Pagada;
	}
	public void setCantidad_Pagada(double cantidad_Pagada) {
		Cantidad_Pagada = cantidad_Pagada;
	}
	public String getPago() {
		return Pago;
	}
	public void setPago(String pago) {
		Pago = pago;
	}
	public String getDuracion_Pago() {
		return Duracion_Pago;
	}
	public void setDuracion_Pago(String duracion_Pago) {
		Duracion_Pago = duracion_Pago;
	}
	public double getCantidad_Total_Pagar() {
		return Cantidad_Total_Pagar;
	}
	public void setCantidad_Total_Pagar(double cantidad_Total_Pagar) {
		Cantidad_Total_Pagar = cantidad_Total_Pagar;
	}
	@Override
	public String toString() {
		return "Pagar [ID_Pago=" + ID_Pago + ", DNI_Paciente=" + DNI_Paciente + ", Cantidad_Pagada=" + Cantidad_Pagada
				+ ", Pago=" + Pago + ", Duracion_Pago=" + Duracion_Pago + ", Cantidad_Total_Pagar="
				+ Cantidad_Total_Pagar + "]";
	}
	//constructor
	public Pagar(int iD_Pago, String dNI_Paciente, double cantidad_Pagada, String pago, String duracion_Pago,
			double cantidad_Total_Pagar) {
		super();
		ID_Pago = iD_Pago;
		DNI_Paciente = dNI_Paciente;
		Cantidad_Pagada = cantidad_Pagada;
		Pago = pago;
		Duracion_Pago = duracion_Pago;
		Cantidad_Total_Pagar = cantidad_Total_Pagar;
	}
	
	
	
	

}
