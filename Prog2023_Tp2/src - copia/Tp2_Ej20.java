/*
 * 20. Pedir números enteros positivos por teclado. En cada iteración
el usuario puede ingresar 0 para salir del programa. Si ingresa un
número distinto de 0 se debe pedir el ingreso de un carácter.
a. Si es ‘a’ se debe permitir al usuario escribir un texto libre e
imprimirlo por pantalla.
b. Si es ‘b’ se deben pedir 5 números positivos e informar si
fueron ingresados en orden ascendente.
c. Si es ‘c’ se deben pedir dos números enteros negativos e
imprimir la raíz cuadrada de su multiplicación. La raíz
cuadrada de un número se calcula con la sentencia:
Math.sqrt(numero).
d. Ante cualquier otro carácter ingresado se debe informar un
error y pedir nuevamente el carácter.
 */



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp2_Ej20 {

	public static void main (String [] args) {
		
		char car;
		String texto;
		int num, n1, n2, n3, n4, n5, raiz;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			do {
				
				System.out.println("Ingrese un numero, si ingresa cero finalizara el programa.");
				num = Integer.valueOf(entrada.readLine());
				
				if(num != 0) {
					
						do { 
							
							System.out.println("Ingrese un caracter entre a y c.");
							car = entrada.readLine().charAt(0);
							
							if(car == 'a') {
								System.out.println("Introduzca cualquier texto");
								texto = entrada.readLine();
								
								System.out.println(texto);
							}
							else if(car == 'b') {
								System.out.println("Introduzca cinco numeros");
								n1 = Integer.valueOf(entrada.readLine());
								n2 = Integer.valueOf(entrada.readLine());
								n3 = Integer.valueOf(entrada.readLine());
								n4 = Integer.valueOf(entrada.readLine());
								n5 = Integer.valueOf(entrada.readLine());
								
								if( (n1 < n2) && (n2 < n3) && (n3 < n4) && (n4 < n5)) {
									System.out.println("Estan en orden ascendente.");
								}
								else {
									System.out.println("No estan en orden ascendente.");
								}
							}
							else if(car == 'c') {
								
								do {
									System.out.println("Introduzca dos numeros negativos");
									n1 = Integer.valueOf(entrada.readLine());
									n2 = Integer.valueOf(entrada.readLine());
									
									if((n1 < 0) && (n2 < 0)) {
										raiz = n1 * n2;
										
										System.out.println("La raiz cuadrada de ambos numeros multiplicados es de: "+(Math.sqrt(raiz)));
									}
									
								}while((n1 >= 0) || (n2 >= 0));
								
							}
							else {
								System.out.println("Introduzca un caracter correcto");
							}
						
							
						}while((car == 'a') && (car == 'b') && (car == 'c'));
						
					
				}
				
				
				
			}while(num != 0);
			
			
		
		
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
}