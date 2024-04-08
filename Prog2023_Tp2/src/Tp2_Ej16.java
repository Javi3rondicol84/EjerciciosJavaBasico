/*
 * 16. Pedir por consola 15 caracteres. Imprimir la mayor cantidad de
‘a’ seguidas que se ingresaron.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp2_Ej16 {

	public static void main (String [] args) {
		
		final int max = 15;
		char car;
		int aux = 0;
		int cantmayor = 0;
		int count = 0;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			while(count < max) {
				System.out.println("Introduce 15 caracteres");
				car = entrada.readLine().charAt(0);
				
				if(car == 'a') {
					aux++;
				}
				else {
					aux = 0;
				}
				
				if(aux > cantmayor) {
					cantmayor = aux;
				}
				
				count++;
			}
			
			System.out.println("Se introdujeron "+cantmayor+" 'a' seguidas en mayor cantidad.");
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
}