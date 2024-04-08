/*
 * 9. Escribir un programa que mientras el usuario ingrese un número
entero entre 1 y 10, pida ingresar un carácter, y por cada carácter
ingresado imprima:
a. “letra minúscula” si el carácter es una letra del abecedario en
minúscula;
b. “letra mayúscula” si el carácter es una letra del abecedario
en mayúscula;
c. “dígito” si el caracter corresponde a un número;
d. “otro” para los restantes casos de caracteres.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp03_Ej9 {

	public static void main (String [] args) {
		
		int num;
		char car;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			do {
				System.out.println("Introduzca un num entre 1 y 10.");
				num = Integer.valueOf(entrada.readLine());
				
				if((num >= 1) || (num <= 10)) {
					
					System.out.println("Ingrese un caracter");
					car = entrada.readLine().charAt(0);
					
					imprimir(car);
				}
				
			}while((num >= 1) || (num <= 10));
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	public static void imprimir(char car) {
		
		if(Character.isLowerCase(car)) {
			System.out.println("minúscula");
		}
		else if(Character.isUpperCase(car)) {
			System.out.println("mayuscula");
		}
		else if(Character.isDigit(car)) {
			System.out.println("digito");
		}
		else {
			System.out.println("otro");
		}
	}
}

		
		
	
	

