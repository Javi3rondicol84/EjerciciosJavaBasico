/*
 * 13. Escribir un programa que mientras que el usuario ingrese un
caracter letra minúscula, pida ingresar un número entero. Si el
número ingresado está entre 1 y 5 inclusive deberá imprimir la

tabla de multiplicar de dicho número.
 */



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp2_Ej13 {

	public static void main (String [] args) {
		
		char letra;
		int num;
		int max = 10;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			do {
				
				System.out.println("Ingrese un caracter minuscula");
				letra = entrada.readLine().charAt(0);
				
				if((letra >= 'a') && (letra <= 'z')) {
					System.out.println("Ingrese un numero entero");
					num = Integer.valueOf(entrada.readLine());
					
					if((num >= 1) && (num <= 5)) {
						
						System.out.println("La tabla de "+num+" es:");
						
						for(int i = 1; i <= max; i++) {
							
							System.out.println(num+"*"+i+"="+(num*i));
							
						}
						
						
					}
				}
				
			}while((letra >= 'a') && (letra <= 'z'));
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
}