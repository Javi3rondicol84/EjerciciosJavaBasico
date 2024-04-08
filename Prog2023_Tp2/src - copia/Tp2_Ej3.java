/*
 * Escribir un programa que solicite el ingreso de un número mayor a
50, y lo muestre por pantalla en caso de ser múltiplo de 2 o 3.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp2_Ej3 {

	public static void main (String [] args) {
		
		final int dos = 2;
		final int tres = 3;
		int num;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Introduce un numero mayor a 50");
			num = Integer.valueOf(entrada.readLine());
			
			if(num > 50) {
				if((num % dos == 0) || (num % tres == 0)) {
					System.out.println(num);
				}
			}
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
}