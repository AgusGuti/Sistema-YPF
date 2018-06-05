package modelo;

public class Cliente {
	
	private int idCliente;
	private long dni;
	private String apellido;
	private String nombre;
	
	
	
	public Cliente(int idCliente, long dni, String apellido, String nombre) {
		super();
		this.idCliente = idCliente;
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + (int) (dni ^ (dni >>> 32));
		result = prime * result + idCliente;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Cliente other = (Cliente) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (dni != other.dni)
			return false;
		if (idCliente != other.idCliente)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	//METODOS
	
	
}
