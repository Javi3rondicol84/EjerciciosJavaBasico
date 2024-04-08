/*
 * En Carrefive, los días martes y jueves hay “PROMO”. En los días
martes, si el importe total de la compra supera los $13.000 el
descuento es del 5%, pero si supera los $20.000 es del 7.5%. Los
jueves, en cambio, el descuento es para todos los tickets cuyo
importe supere los $25.000 y será el 10% con un tope de reintegro
de $3.000 por ticket. Escribir un programa que dado el día de la
semana que se hace la compra y el importe del ticket, verifique si
aplica hacer el descuento o no. Puede suponer un dato numérico
para cada día, ejemplo: 1 para el martes y 2 para el jueves.
 */



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BonusTrack_ej2 {

	public static void main (String [] args) {
		
		int imprt;
		int day;
		
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Introduce el dia donde se hizo la compra: (1-martes, 2-jueves)");
			day = Integer.valueOf(entrada.readLine());
			System.out.println("Introduce el importe del ticket");
			imprt = Integer.valueOf(entrada.readLine());
			
			System.out.println("Aplica el descuento de 5%? "+((day == 1)&&(imprt > 13000)&&(imprt < 20000)) + ", Aplica el descuento de 7.5%?" + ((day == 1)&&(imprt > 20000)));
			System.out.println("Aplica el descuento con 10% de reintegro?"+ ((day == 2) && (imprt > 25000)));
			
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
}