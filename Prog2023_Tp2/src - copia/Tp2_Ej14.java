/*
 * 14. Pedir por consola el ingreso de 10 números enteros positivos.
Contar cuántas veces se ingresaron números pares y mostrarlo
por pantalla.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp2_Ej14 {

	public static void main (String [] args) {
		
		final int max = 10;
		final int dos = 2;
		int num;
		int aux;
		int count;
		aux = 0;
		count = 0;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			while(aux < max) {
				
				System.out.println("Introduce un numero");
				num = Integer.valueOf(entrada.readLine());
				if(num % dos == 0) {
					count++;
				}
				aux++;
			}
			
			System.out.println("Hay "+count+" pares entre los numeros ingresados");
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
}