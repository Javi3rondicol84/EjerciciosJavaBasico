/*
 * 17. Escribir un programa que dado un valor ingresado por el
usuario menor que 10 y mayor a 1, muestre por pantalla una
cuenta regresiva de números desde dicho valor hasta el 0
inclusive.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp2_Ej17 {

	public static void main (String [] args) {
	
		final int minimo = 0;
		int num;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Introduce un valor mayor a 1 y menor a 10");
			num = Integer.valueOf(entrada.readLine());
			
			if((num > 1) && (num < 10)) {
				while(num >= minimo) {
					
					System.out.println(num);
					num--;
				}
				
			}
		
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
}