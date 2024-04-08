/*
 * 15. Pedir por consola el ingreso de números enteros. Cuando se
ingrese un 0 se debe terminar el programa informando el
promedio de los números ingresados, cuál fue el mayor número y
cuál fue el menor número.
 */



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp2_Ej15 {

	public static void main (String [] args) {
		
		int numero, aux, aux2, suma, num2, num3, maxnum, minnum;
		float promedio;
		numero = 1;
		aux = 0;
		suma = 0;
		num2 = 0;
		maxnum = 0;
		minnum = 0;
		promedio = 0;
		num3 = 0;
		aux2 = 0;

		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			do {
				System.out.println("Ingrese un numero");
				numero = Integer.valueOf(entrada.readLine());
				
				if(numero > 0) {
					if(numero > num2) {
						maxnum = numero;
						num2 = numero;
					}
					else if((numero <= num2)) {
					
							num3 = numero;
							
							if((aux2 == 0) || (num3 < minnum)) {
								minnum = numero;
								aux2++;
							}
							
						}
					
					}
					
					suma = suma + numero;
					aux++;
					promedio = suma / aux;
				
				
				
			}while(numero != 0);
			
			
			System.out.println("El promedio de los numeros es: "+promedio);
			System.out.println("El numero más grande es "+maxnum+", y el más pequeño es "+minnum);
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
}