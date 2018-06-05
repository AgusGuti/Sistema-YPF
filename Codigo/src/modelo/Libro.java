package modelo;

public class Libro {
	
	private int idLibro;
	private String isbn;
	private String titulo;
	private String autores;
	private String editorial;
	private double precio;
	
	
	public Libro(int idLibro, String isbn, String titulo, String autores, String editorial, double precio) {
		super();
		this.idLibro = idLibro;
		this.isbn = isbn;
		this.titulo = titulo;
		this.autores = autores;
		this.editorial = editorial;
		this.precio = precio;
	}
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", isbn=" + isbn + ", titulo=" + titulo + ", autores=" + autores
				+ ", editorial=" + editorial + ", precio=" + precio + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autores == null) ? 0 : autores.hashCode());
		result = prime * result + ((editorial == null) ? 0 : editorial.hashCode());
		result = prime * result + idLibro;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Libro other = (Libro) obj;
		if (autores == null) {
			if (other.autores != null)
				return false;
		} else if (!autores.equals(other.autores))
			return false;
		if (editorial == null) {
			if (other.editorial != null)
				return false;
		} else if (!editorial.equals(other.editorial))
			return false;
		if (idLibro != other.idLibro)
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	
	//METODOS
	
	
	public boolean esValidoISBN (String isbn)
	{
		boolean valido = false;
		
		if (isbn.length() == 13 && Funciones.esCadenaNros(isbn))
		{
			String[] cadenaNros = isbn.split("");
			int sumaPosicionImpar = 0;
			int sumaPosicionPar = 0;
			int suma = 0;
			int resto = 0;
			
			
			for(int i=0; i<(cadenaNros.length-1);i++)
			{
				if(i%2 == 0)
					sumaPosicionPar += 3 * Integer.parseInt(cadenaNros[i]);
				else
					sumaPosicionImpar += Integer.parseInt(cadenaNros[i]);
			}
			
			suma = sumaPosicionImpar + sumaPosicionPar;
			
			resto = suma;
			
			while(resto%10 != 0)
					resto ++;
			
			resto = resto - suma;
		
			if(isbn == (String.valueOf(suma) + String.valueOf(resto)))
				valido = true;
		}
		
		
		
		return valido;
	}
	
	
	public String formatearISBN()
	{
		String[] cadenaNros = this.isbn.split("");
		String mensaje = cadenaNros[0] + cadenaNros[1] + cadenaNros[2] + "-" + cadenaNros[3] + cadenaNros[4] + "-";
		mensaje = mensaje + cadenaNros[5] + cadenaNros[6] + cadenaNros[7] + cadenaNros[8] + cadenaNros[9] + "-";
		mensaje = mensaje + cadenaNros[10] + cadenaNros[11] + "-" + cadenaNros[12];
		
		return mensaje;
	}

}
