/*
 * 7. Escribir un programa que mientras el usuario ingresa un caracter
distinto del carácter ‘*’, muestre por pantalla si es carácter dígito, o
si es carácter vocal minúscula.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp2_Ej7 {

	public static void main (String [] args) {
		
		char caracter;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Introduce un caracter");
			caracter = entrada.readLine().charAt(0);
			
 			if(caracter != '*') {
 				if(caracter == '1' || caracter == '2' || caracter == '3' || caracter == '4' || caracter == '5' || caracter == '6' || caracter == '7' || caracter == '8' || caracter == '9') {
 					System.out.println("Es un digito");
 				}
 				else if(caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u') {
 					System.out.println("es vocal");
 				}
 				else {
 					System.out.println("es consonante");
 				}
 			}
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
}