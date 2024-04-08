/*
 * Viendo el �xito de las promociones implementadas por la
competencia, el supermercado Soberano decidi� aplicar la misma
idea. En Soberano, hay un descuento del 8% si se cumplen las
siguientes condiciones: es viernes o s�bado, el n�mero de ticket
es par, el importe es a lo sumo de $15.000 y el DNI del cliente
termina en un n�mero impar. Escribir un programa que dado el
d�a, el n�mero de ticket, el importe y el DNI verifique si debe
aplicar el descuento o no. Puede suponer un dato num�rico para
el d�a como en el inciso anterior.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BonusTrack_ej3 {

	public static void main (String [] args) {
		
		final int DNI;
		int imprt;
		int nroticket;
		int day;
	
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Introduzca el dia donde se hizo la compra: (1-viernes, 2-sabado)");
			day = Integer.valueOf(entrada.readLine());
			System.out.println("Introduzca el importe del ticket");
			imprt = Integer.valueOf(entrada.readLine());
			System.out.println("Introduzca el DNI");
			DNI = Integer.valueOf(entrada.readLine());
			System.out.println("Introduzca el importe del ticket");
			nroticket = Integer.valueOf(entrada.readLine());
			
			//viernes = 1, sabado = 2
			
		System.out.println("Aplica el descuento? "+(((day == 1) || (day == 2)) && (nroticket % 2 == 0) && (imprt <= 15000 ) && (DNI % 2 != 0)));
			
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
}