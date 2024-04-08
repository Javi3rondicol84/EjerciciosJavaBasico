/*
 * Escribir un programa que permita el ingreso de un número entero
por teclado e imprima el cociente de la división de dicho número
por 2, 3, y 4. En base a los resultados obtenidos analice cada
caso si es correcto o no.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ej9 {

	public static void main (String [] args) {
		
		int num;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Introduce un num entero: ");
			num = Integer.valueOf(entrada.readLine());
			
			System.out.println(num+" dividido por 2 es igual a: "+(num/2));
			System.out.println(num+" dividido por 3 es igual a: "+(num/3));
			System.out.println(num+" dividido por 4 es igual a: "+(num/4));
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
}