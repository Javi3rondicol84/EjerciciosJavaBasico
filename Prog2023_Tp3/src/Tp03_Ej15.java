/*
 * 15. Escribir un programa que mientras que el usuario ingrese un
número entero natural, llame a un método que calcule la
sumatoria entre 1 y dicho número y se lo retorne como resultado.
 */



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp03_Ej15 {

	public static void main (String [] args) {
		
		int num;
		int resultado;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Ingrese un numero natural");
			num = Integer.valueOf(entrada.readLine());
			
			if(num > 0) {
				resultado = sumatoria(num);
				
				System.out.println(resultado);
			}
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	public static int sumatoria(int num) {
		int sum = 0;
		int indice = 0;
		
		while(indice <= num) {
			
			sum = sum + indice;
			
			indice++;
		}
		
		
		return sum;
	}
	
}