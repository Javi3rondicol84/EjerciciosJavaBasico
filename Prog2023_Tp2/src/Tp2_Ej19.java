/*
 * 19. Construir un programa que solicite desde teclado un n�mero de
mes v�lido y posteriormente notifique por pantalla la cantidad de
d�as de ese mes. En el caso de que ingrese 2 como n�mero de
mes (febrero) deber� adem�s solicitar ingresar un n�mero de a�o
entre 2000 y 2019 inclusive (no debe seguir si no est� en ese
rango), y dependiendo de si es bisiesto o no imprimir la cantidad
de d�as correspondiente.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp2_Ej19 {

	public static void main (String [] args) {
		
		final int dos = 2;
		int month;
		int year;
		boolean frenar = false;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			do {
				System.out.println("Introduzca un numero de mes valido: ");
				month = Integer.valueOf(entrada.readLine());
				
				if(month == dos) {
					System.out.println("Introduzca un numero de a�o entre 2000 y 2019: ");
					year = Integer.valueOf(entrada.readLine());
					
					if((year < 2000) || (year > 2019)) {
						frenar = true;
					}
					else {
						
						if((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) {
							System.out.println("El a�o es bisiesto y tiene 366 dias");
						}
						else {
							System.out.println("El a�o tiene 365 dias");
						}	
					}	
				}
				
					switch(month) {
					case 1: case 3: case 5: case 7: case 8: case 10: case 12: {
						System.out.println("Tiene 31 dias");
						break;
					}
					case 4: case 6: case 9: case 11: {
						System.out.println("Tiene 30 dias");
						break;
					}

				}
				
				
				
			}while((month >= 1) && (month <= 12) && (frenar == false));
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
}