package modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Libreria {
	
	private List<Libro> lstLibros;
	private List<Cliente> lstClientes;
	private List<Venta> lstVentas;
	
	
	
	public Libreria() {
		super();
		this.lstLibros = new ArrayList<Libro>();
		this.lstClientes = new ArrayList<Cliente>();
		this.lstVentas = new ArrayList<Venta>();
	}
	public List<Libro> getLstLibros() {
		return lstLibros;
	}
	public void setLstLibros(List<Libro> lstLibros) {
		this.lstLibros = lstLibros;
	}
	public List<Cliente> getLstClientes() {
		return lstClientes;
	}
	public void setLstClientes(List<Cliente> lstClientes) {
		this.lstClientes = lstClientes;
	}
	public List<Venta> getLstVentas() {
		return lstVentas;
	}
	public void setLstVentas(List<Venta> lstVentas) {
		this.lstVentas = lstVentas;
	}
	@Override
	public String toString() {
		return "Libreria [lstLibros=" + lstLibros + ", lstClientes=" + lstClientes + ", lstVentas=" + lstVentas + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lstClientes == null) ? 0 : lstClientes.hashCode());
		result = prime * result + ((lstLibros == null) ? 0 : lstLibros.hashCode());
		result = prime * result + ((lstVentas == null) ? 0 : lstVentas.hashCode());
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
		Libreria other = (Libreria) obj;
		if (lstClientes == null) {
			if (other.lstClientes != null)
				return false;
		} else if (!lstClientes.equals(other.lstClientes))
			return false;
		if (lstLibros == null) {
			if (other.lstLibros != null)
				return false;
		} else if (!lstLibros.equals(other.lstLibros))
			return false;
		if (lstVentas == null) {
			if (other.lstVentas != null)
				return false;
		} else if (!lstVentas.equals(other.lstVentas))
			return false;
		return true;
	}
	
	
	
	//METODOS

	public Libro traerLibro (String isbn)
	{
		int indice = 0;
		Libro datoLibro = null;
		
		while (datoLibro == null && indice<this.lstLibros.size())
		{
			if(this.lstLibros.get(indice).getIsbn() == isbn)
				datoLibro = this.lstLibros.get(indice);
			
			indice++;			
		}
				
		return datoLibro;		
	}
	
	
	
	public Libro traerLibro (int idLibro)
	{
		int indice = 0;
		Libro datoLibro = null;
		
		while (datoLibro == null && indice<this.lstLibros.size())
		{
			if(this.lstLibros.get(indice).getIdLibro() == idLibro)
				datoLibro = this.lstLibros.get(indice);
			
			indice++;			
		}
		
		
		return datoLibro;		
	}
	
	
	public boolean agregarLibro (String isbn, String titulo, String autores, String editorial, double precio) throws Exception
	{
		int idNuevo = 1;
		Libro nuevoLibro = null;
		
		if(this.traerLibro(isbn) == null)
		{
			if(this.lstLibros.size() != 0)
				idNuevo = this.lstLibros.get(this.lstLibros.size() - 1).getIdLibro() + 1;
			
			nuevoLibro = new Libro(idNuevo, isbn, titulo, autores, editorial, precio);
		}
		else throw new Exception("El libro ya existe");
		
		return this.lstLibros.add(nuevoLibro);
		
	}
	
	
	public Cliente traerCliente (long dni)
	{
		int indice = 0;
		Cliente datoCliente = null;
		
		while (datoCliente == null && indice<this.lstClientes.size())
		{
			if(this.lstClientes.get(indice).getDni() == dni)
				datoCliente = this.lstClientes.get(indice);
			
			indice++;			
		}
		
		
		return datoCliente;		
	}
	
	
	public boolean agregarCliente (long dni, String apellido, String nombre) throws Exception
	{
		int idNuevo = 1;
		Cliente nuevoCliente = null;
		
		if(this.traerCliente(dni) == null)
		{
			if(this.lstClientes.size() != 0)
				idNuevo = this.lstClientes.get(this.lstClientes.size() - 1).getIdCliente() + 1;
			
			nuevoCliente = new Cliente(idNuevo, dni, apellido, nombre);
		}
		else throw new Exception("El cliente ya existe");
		
		return this.lstClientes.add(nuevoCliente);
		
	}

	
	public List<Venta> traerVenta (Cliente cliente, boolean cerrada)
	{
		int idNuevo = 1;
		List<Venta> listaVentas = null;
		
		for (Venta datoVenta : this.lstVentas)
		{
			if(listaVentas.size() != 0)
				idNuevo = listaVentas.get(listaVentas.size() - 1).getIdVenta() + 1;
			
			if(datoVenta.getCliente().equals(cliente) && datoVenta.getCerrada() == cerrada)
				listaVentas.add(new Venta(idNuevo, cliente, datoVenta.getFechaHora(), cerrada));				
		}
				
		return listaVentas;		
	}

	public Venta traerVenta (Cliente cliente)
	{
		int indice = 0;
		Venta datoVenta = null;
		
		while (datoVenta == null && indice<this.lstVentas.size())
		{
			if(this.lstVentas.get(indice).getCliente().equals(cliente) && this.lstVentas.get(indice).getCerrada() == false)
				datoVenta = this.lstVentas.get(indice);
			
			indice++;			
		}
				
		return datoVenta;		
	}
	
	
	public boolean agregarLibro (Cliente cliente, Libro libro, int cantidad)
	{
		boolean valido = true;
		Venta venta = this.traerVenta(cliente);
		Item item = null;
				
		if(venta == null)
		{
			this.agregarVenta(cliente);
			venta = this.traerVenta(cliente);
		}
			
		item = venta.traerItem(libro);
		
		if(item == null)
			valido = venta.agregarItem(libro, cantidad);
		else
			item.setCantidad(item.getCantidad() + cantidad);
			
		return valido;		
	}
	

	public boolean eliminarLibro (Cliente cliente, Libro libro, int cantidad)
	{
		boolean valido = true;
		Venta venta = this.traerVenta(cliente);
		Item item = venta.traerItem(libro);
				
		if(item.getCantidad() < cantidad)
			valido = venta.getLstItem().remove(item);
		else
			item.setCantidad(item.getCantidad() - cantidad);
			
		return valido;
	}
	
	
	public boolean agregarVenta (Cliente cliente)
	{
		int idNuevo = 1;
		Venta nuevaVenta = null;
		GregorianCalendar fechaActual = new GregorianCalendar(); //Fecha del sistema
		
		
			if(this.lstVentas.size() != 0)
				idNuevo = this.lstVentas.get(this.lstVentas.size() - 1).getIdVenta() + 1;
			
			nuevaVenta = new Venta(idNuevo, cliente, fechaActual, false);
		
		
		return this.lstVentas.add(nuevaVenta);
		
	}
	
	
	public boolean cerrarVenta (Cliente cliente)
	{
		boolean valido = true;
		
		this.traerVenta(cliente).setCerrada(true);
		
		return valido;
	}

}
