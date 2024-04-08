/*
 * 12. Escribir un programa que mientras el usuario ingrese un
carácter letra minúscula, se quede con la menor y la mayor letra
ingresada. Finalmente muestre por pantalla dichas letras.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp2_Ej12 {

	public static void main (String [] args) {
		
		char letra;
		char auxmin = ' ';
		char auxmax = ' ';
		char auxletra = 'a';
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			do {
				
				System.out.println("Introduzca una letra minuscula");
				letra = entrada.readLine().charAt(0);
				
				if((letra >= 'a') && (letra <= 'z')) {
					if(letra > auxletra) {
						
						auxmax = letra;
					}
					else {
						auxmin = letra;
					}
				}
				
				auxletra = letra;
				
				
			}while((letra >= 'a') && (letra <= 'z'));
			
			System.out.println("La mayor letra ingresada fué: "+auxmax+" y la menor letra ingresada fué: "+auxmin);
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
}