/*
 * 9. Escribir un programa que mientras el usuario ingrese un n�mero
entero entre 1 y 10, pida ingresar un car�cter, y por cada car�cter
ingresado imprima:
a. �letra min�scula� si el car�cter es una letra del abecedario en
min�scula;
b. �letra may�scula� si el car�cter es una letra del abecedario
en may�scula;
c. �d�gito� si el caracter corresponde a un n�mero;
d. �otro� para los restantes casos de caracteres.
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
			System.out.println("min�scula");
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

		
		
	
	

