package Modelo;

public class Stock {
	//atributos
	protected int ID_Material;
	protected int ID_Proveedor;
	protected int ID_Pedido;
	protected String Nombre;
	protected int Cantidad;
	protected double Precio;
	protected String Observaciones;
	//métodos
	public int getID_Material() {
		return ID_Material;
	}
	public void setID_Material(int iD_Material) {
		ID_Material = iD_Material;
	}
	public int getID_Proveedor() {
		return ID_Proveedor;
	}
	public void setID_Proveedor(int iD_Proveedor) {
		ID_Proveedor = iD_Proveedor;
	}
	public int getID_Pedido() {
		return ID_Pedido;
	}
	public void setID_Pedido(int iD_Pedido) {
		ID_Pedido = iD_Pedido;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	public double getPrecio() {
		return Precio;
	}
	public void setPrecio(double precio) {
		Precio = precio;
	}
	public String getObservaciones() {
		return Observaciones;
	}
	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}
	@Override
	public String toString() {
		return "Stock [ID_Material=" + ID_Material + ", ID_Proveedor=" + ID_Proveedor + ", ID_Pedido=" + ID_Pedido
				+ ", Nombre=" + Nombre + ", Cantidad=" + Cantidad + ", Precio=" + Precio + ", Observaciones="
				+ Observaciones + "]";
	}
	//constructor
	public Stock(int iD_Material, int iD_Proveedor, int iD_Pedido, String nombre, int cantidad, double precio,
			String observaciones) {
		super();
		ID_Material = iD_Material;
		ID_Proveedor = iD_Proveedor;
		ID_Pedido = iD_Pedido;
		Nombre = nombre;
		Cantidad = cantidad;
		Precio = precio;
		Observaciones = observaciones;
	}
	

}
