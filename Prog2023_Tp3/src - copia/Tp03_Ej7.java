/*
 * 7. Escribir un programa que mientras el usuario cargue desde
teclado un número entero distinto de 0, imprima por pantalla la
suma que se obtiene de invocar un método que calcula la
sumatoria de los primeros 200 números naturales (son números
enteros entre 1 y 200).
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp03_Ej7 {

	public static void main (String [] args) {
		
		int returned;
		int num;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
			do {
			
			System.out.println("Ingrese un numero distinto de 0");
			num = Integer.valueOf(entrada.readLine());
			
			if(num != 0) {
				returned = sumatoria();
				System.out.println(returned);
			}
			
			}while(num != 0);
			
	
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
	
	}
	
	public static int sumatoria() {
		int sum = 0;
		int aux = 0;
		int min = 1;
		final int max = 200;
		
		while(min <= max) {
			
			sum = sum + min;
			
			min++;
		}
		
		return sum;
	}
	
	
}