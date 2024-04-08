/*
 * 14.Escribir un programa que mientras el usuario ingresa un
car�cter distinto del car�cter �*�, invoque a un m�todo que imprima
si es car�cter d�gito o car�cter letra min�scula, y si es letra
min�scula imprimir si es vocal o consonante.
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
				System.out.println("min�scula");
				
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