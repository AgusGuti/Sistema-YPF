package modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Venta {
	
	private int idVenta;
	private Cliente cliente;
	private GregorianCalendar fechaHora;
	private boolean cerrada;
	private List<Item> lstItem;
	
	
	public Venta(int idVenta, Cliente cliente, GregorianCalendar fechaHora, boolean cerrada) {
		super();
		this.idVenta = idVenta;
		this.cliente = cliente;
		this.fechaHora = fechaHora;
		this.cerrada = cerrada;
		this.lstItem = new ArrayList<Item>();
		}
	
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public GregorianCalendar getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
	}
	public boolean getCerrada() {
		return cerrada;
	}
	public void setCerrada(boolean cerrada) {
		this.cerrada = cerrada;
	}
	public List<Item> getLstItem() {
		return lstItem;
	}
	public void setLstItem(List<Item> lstItem) {
		this.lstItem = lstItem;
	}
	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", cliente=" + cliente + ", fechaHora=" + fechaHora + ", cerrada="
				+ cerrada + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (cerrada ? 1231 : 1237);
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((fechaHora == null) ? 0 : fechaHora.hashCode());
		result = prime * result + idVenta;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venta other = (Venta) obj;
		if (cerrada != other.cerrada)
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (fechaHora == null) {
			if (other.fechaHora != null)
				return false;
		} else if (!fechaHora.equals(other.fechaHora))
			return false;
		if (idVenta != other.idVenta)
			return false;
		return true;
	}
	
	
	public Item traerItem (Libro libro)
	{
		int indice = 0;
		Item datoItem = null;
		
		while (datoItem == null && indice<this.lstItem.size())
		{
			if(this.lstItem.get(indice).getLibro().equals(libro))
				datoItem = this.lstItem.get(indice);
			
			indice++;			
		}
		
		
		return datoItem;		
	}

	
	public boolean agregarItem (Libro libro,int cantidad)
	{
		int idNuevo = 1;
		Item nuevoItem = null;
		
		if(this.lstItem.size() != 0)
			idNuevo = this.lstItem.get(this.lstItem.size() - 1).getIdItem() + 1;
		
		nuevoItem = new Item(idNuevo, libro, cantidad);
		
		return this.lstItem.add(nuevoItem);
	}
	
	public boolean agregarLibro (Libro libro, int cantidad)
	{
		boolean valido = true;
		Item item = this.traerItem(libro);
				
		if(item == null)
			valido = this.agregarItem(libro, cantidad);
		else
			item.setCantidad(item.getCantidad() + cantidad);
			
		return valido;
	}
	
	public boolean eliminarLibro (Libro libro, int cantidad)
	{
		boolean valido = true;
		Item item = this.traerItem(libro) ;
				
		if(item.getCantidad() < cantidad)
			valido = this.lstItem.remove(item);
		else
			item.setCantidad(item.getCantidad() - cantidad);
			
		return valido;
	}
	
	public double calcularTotal ()
	{
		double Total = 0;
		
		for(Item datoItem : this.lstItem)
		{
			Total += datoItem.calcularSubTotal();			
		}
		
		return Total;
	}
	
	public double calcularDescuento ()
	{
		int cantidad = 0;
		double descuento = 0;
		
		for(Item datoItem : this.lstItem)
			cantidad += datoItem.getCantidad();
		
		if(cantidad >= 5)
		{
			descuento = this.libroBarato();		//Le paso el valor del libro mas barato de la venta.
		}
			
		return descuento;		//El valor final lo dejo como el valor de solamente un ejemplar del libro mas barato.
	}
	
	
	public double libroBarato()
	{
		double minimo = this.lstItem.get(0).getLibro().getPrecio();
				
		for (Item datoItem : this.lstItem)
		{
			if (datoItem.getLibro().getPrecio() < minimo)
			{
				minimo = datoItem.getLibro().getPrecio();
			}
		}
		
		return minimo;
	}
	
	
	public double calcularTotalAPagar ()
	{
		return this.calcularTotal() - this.calcularDescuento();		
	}
	
	
	
}
