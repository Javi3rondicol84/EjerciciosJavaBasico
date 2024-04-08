/*
 * 6. Escribir un programa que mientras el usuario ingrese un número
entero menor que 100 y mayor a 1, muestre por pantalla si el
número es múltiplo de 2 y múltiplo de 3 simultáneamente. (¿Los
valores mencionados en el enunciado deberían ser constantes?.
De a poco habría que definirlos como constantes).
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp2_Ej6 {

	public static void main (String [] args) {
		final int max = 100;
		final int min = 1;
		final int dos = 2;
		final int tres = 3;
		int num;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Introduce un numero");
			num = Integer.valueOf(entrada.readLine());
			
			if((num > min) && (num < 100)) {
				if((num % dos == 0) && (num % tres == 0)) {
					System.out.println("El numero es simultaneamente multiplo de 2 y 3");
				}
			}
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
}