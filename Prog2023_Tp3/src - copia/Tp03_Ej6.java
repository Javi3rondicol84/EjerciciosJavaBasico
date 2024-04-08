/*
 * 6. Escribir un programa que mientras el usuario cargue desde
teclado un carácter letra minúscula, llame a un método que
imprime por pantalla la tabla de multiplicar del 9.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp03_Ej6 {

	public static void main (String [] args) {
		
		char car;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Ingrese un caracter minuscula");
			car = entrada.readLine().charAt(0);
			
			if((Character.isLowerCase(car))) {
				imprimir_tabla();
			}
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	public static void imprimir_tabla() {
		final int nueve = 9;
		int max = 10;
		int indice = 1;
		
		System.out.println("Tabla del nueve");
			while(indice <= max) {
				
				System.out.println("["+nueve+"*"+indice+"="+(nueve*indice)+"]");
				
				indice++;
			}
	}
	
	
}