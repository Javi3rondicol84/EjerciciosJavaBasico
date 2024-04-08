/*
 * Escribir un programa que permita el ingreso de dos números
enteros por teclado e imprima:
a. si el primero es mayor al segundo.
b. si ambos son múltiplos de 2.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ej10 {

	public static void main (String [] args) {
		int num1;
		int num2;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Introduzca dos numeros enteros: ");
			num1 = Integer.valueOf(entrada.readLine());
			num2 = Integer.valueOf(entrada.readLine());
			
			System.out.println(+num1+" es mayor a "+num2+"? "+(num1 > num2));
			System.out.println(+num1+" y "+num2+" son multiplos de 2? "+((num1 % 2 == 0) && (num2 % 2 == 0)));
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
}