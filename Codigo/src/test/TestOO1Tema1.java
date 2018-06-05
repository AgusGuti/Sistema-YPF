package test;

import modelo.Libreria;
import modelo.Libro;

public class TestOO1Tema1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Libro libro = null;
		
		//1)
		//Escenario 1
				
		libro = new Libro(0, "978849249370", "", "", "", 0.0);		
		System.out.println();	
		System.out.println(libro.esValidoISBN(libro.getIsbn()));
		
		//Escenario 2
		libro = new Libro(0, "9788492493705", "", "", "", 0.0);		
		System.out.println();	
		System.out.println(libro.esValidoISBN(libro.getIsbn()));
		
		//Escenario 3
		libro = new Libro(0, "97831614841A0", "", "", "", 0.0);		
		System.out.println();	
		System.out.println(libro.esValidoISBN(libro.getIsbn()));
		
		//Escenario 4
		libro = new Libro(0, "9783161484100", "", "", "", 0.0);		
		System.out.println();	
		System.out.println(libro.esValidoISBN(libro.getIsbn()));
		
		
		//2)
		libro = new Libro(0, "9783161484100", "", "", "", 0.0);
		System.out.println();	
		System.out.println(libro.formatearISBN());
		
		//3)
		
		//Escenario 1
		
		Libreria libreria = new Libreria();
		
		try
		{
		libreria.agregarLibro("9788483067775", "La linea del horizonte", "Baltazar Garzon", "Debate Editorial", 157.2);
		}
		catch (Exception e)
		{
			System.out.println();	
			System.out.println(e.getMessage());			
		}
		
		
		//Escenario 2
		
							
		try
		{
		libreria.agregarLibro("9788483067775", "La linea del horizonte", "Baltazar Garzon", "Debate Editorial", 157.2);
		}
		catch (Exception e)
		{
			System.out.println();	
			System.out.println(e.getMessage());			
		}
		
		try
		{
		libreria.agregarLibro("9788466202916", "Antologia", "Federico Garcia Lorca", "Libsa", 40.0);
		libreria.agregarLibro("9788498159882", "El Caratero de Neruda", "Antonio Skarmeta", "Diario El Pais S.A.", 53.8);
		libreria.agregarLibro("9788446029410", "Globalizacion, posmodernidad y educacion", "Arostegui/Martinez" , "AKAL", 38.0);
		
		}
		catch (Exception e)
		{
			System.out.println();	
			System.out.println(e.getMessage());			
		}
		
		
		//4)
		
		System.out.println();	
		System.out.println("Libros: ");
		System.out.println(libreria.getLstLibros().toString());
		
		//5)
		
		System.out.println();	
		System.out.println("Libro solicitado: ");
		System.out.println(libreria.traerLibro("9788498159882").toString());
		
		//6)
		try
		{
			libreria.agregarCliente(11111111, "Piña", "Felipe");
			libreria.agregarCliente(22222222, "Zaiat", "Alfredo");
		}
		catch (Exception e)
		{
			System.out.println();	
			System.out.println(e.getMessage());			
		}
		
		
		//7)
		
		System.out.println();	
		System.out.println("Clientes: ");
		System.out.println(libreria.getLstClientes().toString());
		
		//8)
		

			libreria.agregarLibro(libreria.traerCliente(11111111), libreria.traerLibro("9788466202916"), 4);
			libreria.agregarLibro(libreria.traerCliente(11111111), libreria.traerLibro("9788446029410"), 3);
			libreria.agregarLibro(libreria.traerCliente(11111111), libreria.traerLibro("9788498159882"), 1);

		
		//9)
		
			System.out.println();	
			System.out.println("Venta en curso de: ");
			System.out.println(libreria.traerCliente(11111111).toString());
			System.out.println("Total: ");
			System.out.println(libreria.traerVenta(libreria.traerCliente(11111111)).calcularTotal());
			System.out.println("Descuento: ");
			System.out.println(libreria.traerVenta(libreria.traerCliente(11111111)).calcularDescuento());
			System.out.println("Total a pagar: ");
			System.out.println(libreria.traerVenta(libreria.traerCliente(11111111)).calcularTotalAPagar());
			
			
		//10)

			libreria.eliminarLibro(libreria.traerCliente(11111111), libreria.traerLibro("9788466202916"), 1);
			libreria.eliminarLibro(libreria.traerCliente(11111111), libreria.traerLibro("9788498159882"), 1);
			
			
		//11)
			
			libreria.cerrarVenta(libreria.traerCliente(11111111));

		
	}

}
