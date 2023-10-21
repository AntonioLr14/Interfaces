package Modelo;

public class Pedidos {
	//atributos
	protected int ID_pedidos;
	protected int Cantidad;
	protected double Precio_Pedido;
	protected String Fecha;
	//atributos
	public int getID_pedidos() {
		return ID_pedidos;
	}
	public void setID_pedidos(int iD_pedidos) {
		ID_pedidos = iD_pedidos;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	public double getPrecio_Pedido() {
		return Precio_Pedido;
	}
	public void setPrecio_Pedido(double precio_Pedido) {
		Precio_Pedido = precio_Pedido;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	@Override
	public String toString() {
		return "Pedidos [ID_pedidos=" + ID_pedidos + ", Cantidad=" + Cantidad + ", Precio_Pedido=" + Precio_Pedido
				+ ", Fecha=" + Fecha + "]";
	}
	//constructor
	public Pedidos(int iD_pedidos, int cantidad, double precio_Pedido, String fecha) {
		super();
		ID_pedidos = iD_pedidos;
		Cantidad = cantidad;
		Precio_Pedido = precio_Pedido;
		Fecha = fecha;
	}
	

}
