/*
 * 18. Escribir un programa que mientras que el usuario ingrese un
número distinto de 0, pida ingresar otros dos números e imprima
el resultado de la división entre los dos últimos números
ingresados. ¿Existe alguna restricción para la división? res: el cero.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp2_Ej18 {

	public static void main (String [] args) {
		 
		final int cero = 0; 
		int num, num2, num3, result;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			do {
				
				System.out.println("Introduzca un numero distinto a cero");
				num = Integer.valueOf(entrada.readLine());
				
				if(num != 0) {
					System.out.println("Introduzca otros dos numeros para dividirlos entre si");
					num2 = Integer.valueOf(entrada.readLine());
					num3 = Integer.valueOf(entrada.readLine());
					
					result = num2 / num3;
					
					System.out.println("el resultado de la division es "+result);
				}
				
			}while(num != cero);
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
}