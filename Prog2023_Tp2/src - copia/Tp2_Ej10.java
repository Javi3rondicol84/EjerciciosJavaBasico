/*
 * 10. Escribir un programa que mientras que el usuario ingrese un
número entero entre 1 y 10 inclusive, lleve la suma de los
números ingresados. Finalmente, cuando sale del ciclo muestre
por pantalla el resultado de la suma. ¿En qué casos termina?
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp2_Ej10 {

	public static void main (String [] args) {
		
		final int min = 1;
		final int max = 10;
		int num = 0;
		int suma = 0;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			do {
				
				System.out.println("Introduzca un numero");
				num = Integer.valueOf(entrada.readLine());
				
				if(num >= 1 && num <= 10) {
					suma = suma + num;
				}
				
				
			}while(num >= 1 && num <= 10);
			
			
			System.out.println("La suma de los numeros ingresados es de: "+suma);
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
}