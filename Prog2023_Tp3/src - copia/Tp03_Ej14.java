/*
 * 14.Escribir un programa que mientras el usuario ingresa un
carácter distinto del carácter ‘*’, invoque a un método que imprima
si es carácter dígito o carácter letra minúscula, y si es letra
minúscula imprimir si es vocal o consonante.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp03_Ej14 {

	public static void main (String [] args) {
		
		char car;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			car = entrada.readLine().charAt(0);
			
			if(car != '*') {
				comprobar(car);
			}
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
		public static void comprobar(char car) {
			
			if(Character.isLowerCase(car)) {
				System.out.println("minúscula");
				
				if((car == 'a') ||(car == 'e') || (car == 'i') || (car == 'o') || (car == 'u')) {
					System.out.println("es vocal");
				}
				else {
					System.out.println("es consonante");
				}
			}

			else if(Character.isDigit(car)) {
				System.out.println("digito");
			}

		
	}
	
}