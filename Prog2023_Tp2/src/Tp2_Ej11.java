/*
 * 11. Escribir un programa que mientras el usuario ingrese un
caracter letra minúscula, acumule la cantidad de vocales que
ingresó. Finalmente muestre por pantalla dicha cantidad.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp2_Ej11 {

	public static void main (String [] args) {
		
		char car;
		int vocales = 0;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			do{
				System.out.println("Introduzca un caracter minuscula");
				car = entrada.readLine().charAt(0);
				
				if((car == 'a') || (car == 'e') || (car == 'i') || (car == 'o') || (car == 'u')) {
					vocales++;
				}
				 
			}while((car >= 'a') && (car <= 'z'));
			
			System.out.println("Se introdujeron "+vocales+" vocales");
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
}