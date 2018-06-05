package modelo;

public class Item {

	private int idItem;
	private Libro libro;
	private int cantidad;
	
	
	public Item(int idItem, Libro libro, int cantidad) {
		super();
		this.idItem = idItem;
		this.libro = libro;
		this.cantidad = cantidad;
	}
	public int getIdItem() {
		return idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "Item [idItem=" + idItem + ", libro=" + libro + ", cantidad=" + cantidad + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + idItem;
		result = prime * result + ((libro == null) ? 0 : libro.hashCode());
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
		Item other = (Item) obj;
		if (cantidad != other.cantidad)
			return false;
		if (idItem != other.idItem)
			return false;
		if (libro == null) {
			if (other.libro != null)
				return false;
		} else if (!libro.equals(other.libro))
			return false;
		return true;
	}
	
	
	//METODOS
	
	
	public double calcularSubTotal ()
	{
		double subTotal = 0;
		
		subTotal = (this.getCantidad() * this.getLibro().getPrecio());			
		
		
		return subTotal;
	}
	
}
