/*
 * 10. Escribir un programa que mientras el usuario ingrese un
número entero entre 1 y 10 realice:
a. Si el numero ingresado es múltiplo de 3 pida ingresar un
caracter, y para el caracter ingresado imprima a qué tipo de
carácter está asociado:
i. “letra minúscula” si el caracter es una letra del
abecedario en minúscula;
ii. “letra mayúscula” si el caracter es una letra del
abecedario en mayúscula;
iii. “dígito” si el caracter corresponde a un número;
iv. “otro” para los restantes casos de caracteres.
b. Si el número ingresado es múltiplo de 5 imprima la tabla de
multiplicar del número ingresado.
 */




import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp03_Ej10 {

	public static void main (String [] args) {
		
		int num;
		char car;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			do {
				System.out.println("Introduzca un num entre 1 y 10.");
				num = Integer.valueOf(entrada.readLine());
				
				if((num >= 1) || (num <= 10)) {
					
					if(num % 3 == 0) {
						System.out.println("Ingrese un caracter");
						car = entrada.readLine().charAt(0);
						
						imprimir(car);
					}
					else if(num % 5 == 0) {
						tabla_multiplicar(num);
					}

				}
				
			}while((num >= 1) || (num <= 10));
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	public static void tabla_multiplicar(int num) {
		final int max = 10;
		
		for(int i = 1; i <= max; i++) {
			
			System.out.println("["+num+"*"+i+"="+(num*i)+"]");
		}
	}
	
	public static void imprimir(char car) {
		
		if(Character.isLowerCase(car)) {
			System.out.println("minúscula");
		}
		else if(Character.isUpperCase(car)) {
			System.out.println("mayuscula");
		}
		else if(Character.isDigit(car)) {
			System.out.println("digito");
		}
		else {
			System.out.println("otro");
		}
	}
}

		
		
	
	

