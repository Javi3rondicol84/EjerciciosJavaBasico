/*
 * Escribir un programa que dado tres números reales ingresados
por el usuario, divida el primero por el segundo y al resultado
obtenido le reste el tercero. Muestre por pantalla el resultado
obtenido. Puede o no usar variables auxiliares para los cálculos.
Tenga en cuenta posibles errores en las operaciones.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ej7 {

	public static void main (String [] args) {
		
		double num1;
		double num2;
		double num3;
		

		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Introduzca tres numeros: ");
			num1 = Double.valueOf(entrada.readLine());
			num2 = Double.valueOf(entrada.readLine());
			num3 = Double.valueOf(entrada.readLine());
			
			num1 = num1 / num2;
			num1 = num1 - num3;
			
			System.out.println("Resultado de dividir el primero por el segundo y restarle el tercero: "+num1);
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
	
	}
	
	
}