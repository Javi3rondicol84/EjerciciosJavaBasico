/*
 * 11. Escribir un m�todo que retorne el mayor de dos n�meros. Usar
ese m�todo para calcular el m�ximo de una serie de n�meros
ingresados por el usuario (20 n�meros en total).
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp03_Ej11 {

	public static void main (String [] args) {
		
		int num1, num2;
		int nummax;
		final int max = 20;
		int indice = 0;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
		
			
			
			
			while(indice < max) {
				System.out.println("Introduzca dos numeros");
				num1 = Integer.valueOf(entrada.readLine());
				num2 = Integer.valueOf(entrada.readLine());
				nummax = calcular_maximo(num1, num2);
				if(nummax == 0) {
					System.out.println("los numeros son iguales");
				}
				else {
					System.out.println("El maximo de los dos numeros ingresados es: "+nummax);
				}
				
				indice++;
			}
		
			
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	public static int calcular_maximo(int num1, int num2) {
		int maxnum = 0;
		
		if(num1 > num2) {
			maxnum = num1;
		}
		else if(num2 > num1) {
			maxnum = num2;
		}
		
		return maxnum;
	}
}