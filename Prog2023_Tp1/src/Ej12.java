/*
 * Escribir un programa que permita ingresar dos números enteros,
incremente el primero y decremente el segundo, para luego
mostrar por pantalla en ambos casos, el valor original y el
modificado.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ej12 {

	public static void main (String [] args) {
		
		int num1;
		int num2;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("introduzca dos numeros enteros: ");
			num1 = Integer.valueOf(entrada.readLine());
			num2 = Integer.valueOf(entrada.readLine());
			
			System.out.println("primer numero: "+num1+", incrementado: "+(num1 = num1 + 1));
			System.out.println("Segundo numero: "+num2+", incrementado: "+(num2 = num2 - 1));
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
}