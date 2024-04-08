/*
 * 17. Escribir un programa que mientras que el usuario ingrese un
carácter letra minúscula, pida ingresar un número entero. Si el
número ingresado está entre 1 y 5 inclusive deberá imprimir la
tabla de multiplicar de dicho número.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp03_Ej17 {

	public static void main (String [] args) {
		
		int num;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Ingrese un num entre 1 y 5");
			num = Integer.valueOf(entrada.readLine());
			
			if((num >= 1) || (num <= 5)) {
				tabla_multiplicar(num);
			}
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	public static void tabla_multiplicar(int num) {
		
		int indice = 1;
		final int max = 10;
		
		while(indice <= max) {
			
			System.out.println(num+"*"+indice+"="+(num*indice));
			
			indice++;
		}
		
	}
}