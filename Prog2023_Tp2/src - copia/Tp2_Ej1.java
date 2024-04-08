
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 1. Escribir un programa completo (declaración de constantes y
variables, carga de datos, procesamiento e impresión de
resultados) para cada caso o ítem que:
a. solicite un número e indique si es positivo o negativo.
b. solicite un número e imprima “grande” si es mayor a 100 y
“chico “ si es menor.
c. solicite un número del 1 al 7 e imprima el día de la semana.
d. solicite una letra e imprima si es vocal o consonante.
e. solicite 3 números e imprima “creciente” si los tres números
están en orden creciente, “decreciente” si están en orden
decreciente o “error” si no cumplen ningún orden
 */


public class Tp2_Ej1 {

	public static void main (String [] args) {
		
		final int size = 100;
		final int min = 0;
		int n1, n2, n3, n4, n5, n6;
		char letter; 
		
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			//a
			System.out.println("Introduzca un numero positivo o negativo");
			n1 = Integer.valueOf(entrada.readLine());
			
			if(n1 > min) {
				System.out.println(n1+" es positivo");
			}
			else {
				System.out.println(n1+" es negativo");
			}
			
			//b
			System.out.println("Introduzca un numero");
			n2 = Integer.valueOf(entrada.readLine());
			
			if(n2 > size) {
				System.out.println("grande");
			}
			else {
				System.out.println("pequeño");
			}
			
			//c
			
			System.out.println("Introduzca un numero del 1 al 7 para ver el dia");
			n3 = Integer.valueOf(entrada.readLine());
			
			switch(n3) {
			
				case 1: {
					System.out.println("Lunes");
					break;
				}
				case 2: {
					System.out.println("Martes");
					break;
				}
				case 3: {
					System.out.println("Miercoles");
					break;
				}
				case 4: {
					System.out.println("Jueves");
					break;
				}
				case 5: {
					System.out.println("Viernes");
					break;
				}
				case 6: {
					System.out.println("Sabado");
					break;
				}
				case 7: {
					System.out.println("Domingo");
					break;
				}
				default: {
					System.out.println("el numero debe ser entre 1 y 7");
				}
			
			}
			
			
			//d
			System.out.println("Introduzca una letra");
			letter = entrada.readLine().charAt(0);
			
			switch(letter) {
				case 'a': case 'e': case 'i': case 'o': case'u': {
					System.out.println("La letra "+letter+" es vocal");
					break;
				}
				default: {
					System.out.println("La letra "+letter+" es consonante");
				}
			}
			
			//e			
			System.out.println("Introduzca tres numeros");
			n4 = Integer.valueOf(entrada.readLine());
			n5 = Integer.valueOf(entrada.readLine());
			n6 = Integer.valueOf(entrada.readLine());
			
			if((n4 < n5) && (n5 < n6)) {
				System.out.println("creciente");
			}
			else if((n4 > n5) && (n5 > n6)) {
				System.out.println("decreciente");
			}
			else {
				System.out.println("error");
			}
			
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
}