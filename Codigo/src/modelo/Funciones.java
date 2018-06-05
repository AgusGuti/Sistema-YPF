package modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Funciones 
{
	//METODOS
	
	public static boolean esBisiesto(int anio)
	{
		boolean valido = false;
		
		if ((anio%4==0) && (anio%100!=0 || anio%400==0))
			valido = true;
				
		return valido;
		
	}
		
	public static int traerAnio(GregorianCalendar fecha)
	{
		return fecha.get(Calendar.YEAR);
	}
	
	public static int traerMes(GregorianCalendar fecha)
	{
		return (fecha.get(Calendar.MONTH) + 1);
	}
	
	public static int traerDia(GregorianCalendar fecha)
	{
		return fecha.get(Calendar.DAY_OF_MONTH);
	}
		
	public static boolean esFechaValida (int anio, int mes, int dia)
	{
		boolean valido = true;
		
		if(mes<1||mes>12)
			valido = false;
		
		if(mes==1||mes==3||mes==5||mes==7||mes==8||mes==10||mes==12)
		{
			if(dia<1||dia>31)		//Meses de 31
				valido = false;
		}
		
		if(mes==4||mes==6||mes==9||mes==11)
		{
			if(dia<1||dia>30)
				valido = false;			//Meses de 30
		}
		
		if(mes==2)			//Febrero
		{
			if (Funciones.esBisiesto(anio))
			{
				if(dia<1||dia>29)
					valido = false;
			}
			else
			{
				if(dia<1||dia>28)
					valido = false;
			}
			
		}
		
		return valido;
	}

	public  static GregorianCalendar traerFecha (int anio, int mes, int dia)
	{
		GregorianCalendar dato = new GregorianCalendar(anio, mes-1, dia);
		return dato;
	}
	
	public  static GregorianCalendar traerFecha (String fecha)		//dd-mm-aaaa
	{
		String[] partes = fecha.split("/");			//Separar el String por el caracter indicado
		int dia = Integer.parseInt(partes[0]);		// Parseint pasar de String a int
		int mes = Integer.parseInt(partes[1]);
		int anio = Integer.parseInt(partes[2]);
		
		GregorianCalendar dato = new GregorianCalendar(anio, mes, dia);
		
		return dato;
	}
	
	public static String traerFechaCorta (GregorianCalendar fecha)
	{
		String mes = String.valueOf((fecha.get(Calendar.MONTH) + 1));
		
		if (fecha.get(Calendar.MONTH) + 1 < 10)
			mes = "0" + mes;
		
		
		return (fecha.get(Calendar.DAY_OF_MONTH) + "/" + mes + "/" + fecha.get(Calendar.YEAR));
	}
	
	public static String traerFechaCortaHora (GregorianCalendar fecha)
	{
		String mes = String.valueOf((fecha.get(Calendar.MONTH) + 1));
		
		if (fecha.get(Calendar.MONTH) + 1 < 10)
			mes = "0" + mes;
		
		String fechaCorta = fecha.get(Calendar.DAY_OF_MONTH) + "/" + mes + "/" + fecha.get(Calendar.YEAR);
		fechaCorta = fechaCorta + " " + fecha.get(Calendar.HOUR_OF_DAY) + ":" + fecha.get(Calendar.MINUTE) + ":" +  fecha.get(Calendar.SECOND);
		return fechaCorta;
	}
	
	public static GregorianCalendar traerFechaProximo (GregorianCalendar fecha, int cantDias)
	{
		GregorianCalendar dato = (GregorianCalendar) fecha.clone();
		
		dato.set(fecha.get(Calendar.YEAR), fecha.get(Calendar.MONTH), fecha.get(Calendar.DAY_OF_MONTH) + cantDias);
		
		return dato;
	}
	
	public static boolean esDiaHabil (GregorianCalendar fecha)
	{
		boolean valida = true;
		
		if (fecha.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || fecha.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
		{
			valida = false;
		}
		
		return valida;
	}
	
	public static String traerDiaDeLaSemana (GregorianCalendar fecha)
	{
		String dia = ""; 
		
		switch (fecha.get(Calendar.DAY_OF_WEEK))
		{
		case 0:
			dia = "Domingo";
			break;
			
		case 1:
			dia = "Lunes";
			break;
			
		case 2:
			dia = "Martes";
			break;
			
		case 3:
			dia = "Miercoles";
			break;
			
		case 4:
			dia = "Jueves";
			break;
			
		case 5:
			dia = "Viernes";
			break;
			
		case 6:
			dia = "Sabado";
			break;
		}
		
		return dia;
	}
	
	public static String traerMesEnLetras (GregorianCalendar fecha)
	{
		String mes = ""; 
		
		switch (fecha.get(Calendar.MONTH))
		{
		case 0:
			mes = "Enero";
			break;
			
		case 1:
			mes = "Febrero";
			break;
			
		case 2:
			mes = "Marzo";
			break;
			
		case 3:
			mes = "Abril";
			break;
			
		case 4:
			mes = "Mayo";
			break;
			
		case 5:
			mes = "Junio";
			break;
			
		case 6:
			mes = "Julio";
			break;
		
		case 7:
			mes = "Agosto";
			break;
			
		case 8:
			mes = "Septiembre";
			break;
			
		case 9:
			mes = "Octubre";
			break;
			
		case 10:
			mes = "Noviembre";
			break;
			
		case 11:
			mes = "Diciembre";
			break;
		}
		
		return mes;
	}

	public static String traerFechaLarga (GregorianCalendar fecha)
	{
		String fechaLarga = Funciones.traerDiaDeLaSemana(fecha) + " " + fecha.get(Calendar.DAY_OF_MONTH) + " de ";
		fechaLarga = fechaLarga + Funciones.traerMesEnLetras(fecha) + " del " + Funciones.traerAnio(fecha); 
		
		return fechaLarga;
	}
	

	public static boolean sonFechasIguales (GregorianCalendar fecha, GregorianCalendar fecha1)
	{
		boolean valido = false;
		
		if(fecha.get(Calendar.YEAR)==fecha1.get(Calendar.YEAR) && fecha.get(Calendar.MONTH)==fecha1.get(Calendar.MONTH) && fecha.get(Calendar.DAY_OF_MONTH)==fecha1.get(Calendar.DAY_OF_MONTH))
			valido = true;
		
		return valido;
	}

	public static boolean sonFechasHorasIguales (GregorianCalendar fecha, GregorianCalendar fecha1) //Preguntar el sentido de este metodo
	{
		return (fecha.equals(fecha1));
	}

	public static int traerCantDiasDeUnMes (int anio, int mes)
	{
		int dias = 0;
		
		if(mes==1||mes==3||mes==5||mes==7||mes==8||mes==10||mes==12)
		{
			dias = 31;
		}
		
		if(mes==4||mes==6||mes==9||mes==11)
		{
			dias = 30;
		}
		
		if(mes==2 && Funciones.esBisiesto(anio))			//Febrero
		{
			if (Funciones.esBisiesto(anio))
				dias = 29;
			else
				dias = 28;
		}
		
		return dias;
	}
	
	public static double aproximar2Decimal (double valor)
	{
		double resultado = (double) Math.round(100*valor) / 100;
		
		return resultado;		
	}
	
	public static boolean esNumero (char c)
	{
		boolean valido = false;
		
		switch (c)
		{
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			valido = true;
			break;			
		}
		
		return valido;
	}
	
	public static boolean esLetra (char c)
	{
		boolean valido = false;
		
		String caracter = c + "" ;
		caracter = caracter.toLowerCase();
		
		switch (caracter)
		{
		case "a":
		case "b":
		case "c":
		case "d":
		case "e":
		case "f":
		case "g":
		case "h":
		case "i":
		case "j":
		case "k":
		case "l":
		case "m":
		case "n":
		case "o":
		case "p":
		case "q":
		case "r":
		case "s":
		case "t":
		case "u":
		case "v":
		case "w":
		case "x":
		case "y":
		case "z":
			valido = true;
			break;
		}
					
		return valido;
	}

	public static boolean esCadenaNros (String cadena)
	{
		boolean valido = true;
		char[] dato = cadena.toCharArray(); 	//Paso un String a un array Char
		int i;
			
		for (i=0;i<cadena.length();i++)
		{
			if (!Funciones.esNumero(dato[i]))
			{
				valido = false;
			}
		}
		
		return valido;
	}
	
	public static boolean esCadenaLetras (String cadena)
	{
		boolean valido = true;
		char[] dato = cadena.toCharArray(); 	//Paso un String a un array Char
		int i;
			
		for (i=0;i<cadena.length();i++)
		{
			if (!Funciones.esLetra(dato[i]))
			{
				valido = false;
			}
		}
		
		return valido;
	}
	
	//FIN METODOS
	
	//AGREGADOS
	
	public static double convertirADouble (int n)
	{
		return((double) n);
	}
	
	//FIN AGREGADOS
	
}


