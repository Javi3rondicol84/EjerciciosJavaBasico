/*
 * 4. Escribir un programa donde el usuario ingrese un número entre 0
y 999, y muestre un mensaje de cuántos dígitos tiene. Además, si
tiene 3 dígitos debe informar qué número es.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp2_Ej4 {

	public static void main (String [] args) {
		
		int num;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Ingrese un num entre 0 y 999");
			num = Integer.valueOf(entrada.readLine());
			
			if(num >= 0 && num <= 9) {
				System.out.println("el numero tiene un digito");
			}
			else if(num >= 10 && num <= 99) {
				System.out.println("el numero tiene dos digitos");
			}
			else if(num >= 100 && num <= 999) {
				System.out.println("el numero tiene tres digitos y es "+num);
			}
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
}