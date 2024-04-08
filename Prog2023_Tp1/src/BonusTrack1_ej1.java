/*
 * 1. La cadena de supermercados Carrefive debe imprimir el
encabezado del ticket de compra de los clientes con cierto formato
para cumplir las exigencias de la Administración Federal de
Ingresos PRIVADOS. En el mismo, debe figurar la fecha y hora,
número de ticket, CUIT, nombre del cajero, número de caja, dni
del cliente y la leyenda “El precio lo pone el cliente”. Un ejemplo
se muestra a continuación:
—-----------------------------------------------------------------
04/04/23 - 18:55 Ticket Nro. 3455674

CUIT: 99-34567833-9

Cajero: Luis Mercado Caja: 8
DNI: 33.333.333 “El precio lo pone el cliente”
—-----------------------------------------------------------------
Escribir un programa con declaración de constantes y variables
que pida al usuario el ingreso de los datos necesarios para
imprimir el encabezado del ticket.
 */



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BonusTrack1_ej1 {

	public static void main (String [] args) {
		/*
		 * debe figurar la fecha y hora,
número de ticket, CUIT, nombre del cajero, número de caja, dni
del cliente y la leyenda “El precio lo pone el cliente”.
		 */
		
		final String CUIT;
		final String DNI;
		String date;
		String time;
		String leyend;
		String atmName;
		int ticketNumber;
		int boxNumber;
	
		
		leyend = "El precio lo pone el cliente";
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Introduce el CUIT");
			CUIT = entrada.readLine();
			System.out.println("Introduce el Dni");
			DNI = entrada.readLine();
			System.out.println("Introduce la fecha");
			date = entrada.readLine();
			System.out.println("Introduce la hora");
			time = entrada.readLine();
			System.out.println("Introduce el nombre del cajero");
			atmName = entrada.readLine();
			System.out.println("Introduce el numero de ticket");
			ticketNumber = Integer.valueOf(entrada.readLine());
			System.out.println("Introduce el numero de caja");
			boxNumber = Integer.valueOf(entrada.readLine());
			
			
			System.out.print(date+" - "+time+"\t\tTicket Nro."+ticketNumber+"\n\t\tCUIT:"+CUIT+"\nCajero:"+atmName+"\tCaja:"+boxNumber+"\nDNI:"+DNI+"\t"+leyend);
			
			
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
}