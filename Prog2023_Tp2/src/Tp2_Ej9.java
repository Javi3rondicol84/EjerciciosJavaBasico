/*
 * 9. Escribir un programa que mientras que el usuario ingrese un
car�cter d�gito o car�cter letra min�scula, imprima si es car�cter
d�gito o car�cter letra min�scula, y si es letra min�scula imprimir si
es vocal o consonante.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp2_Ej9 {

	public static void main (String [] args) {
		
		char caracter;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Introduce un caracter");
			caracter = entrada.readLine().charAt(0);
			
			if((caracter >= '1') &&  (caracter <= '9')) {
				System.out.println("es un digito");
			}
			else if((caracter >= 'a') &&  (caracter <= 'z')) {
				System.out.println("es letra minuscula");
				
				 if(caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u') {
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