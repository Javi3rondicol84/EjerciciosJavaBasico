/*
 * 1. Cargar un arreglo de tamaño 15, pidiendo el ingreso por teclado
de valores entre 1 y 12. Luego mostrar cómo quedó cargado.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Base {

	public static int MAX = 15;
	
	public static void main (String [] args) {
		
		int [] arr = new int[MAX];
		
		cargar_arreglo(arr);
		
		imprimir_arreglo(arr);
		
	}
	
	public static void cargar_arreglo(int [] arr) {
	
		int indice, num;
		indice = 0;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
		
				System.out.println("Introduzca valores entre 1 y 12");			
			while(indice < MAX) {
				num = Integer.valueOf(entrada.readLine());
				arr[indice] = num;
				indice++;
			}
			
		}
		catch(Exception exc) {
			
		}
		
	}
	
	public static void imprimir_arreglo(int [] arr) {
		
		int indice;
		indice = 0;
		
		System.out.println("Arreglo: ");
		while(indice < MAX) {
			
			System.out.print("["+arr[indice]+"]");
			
			indice++;
		}
		
		
	}
	
	
}