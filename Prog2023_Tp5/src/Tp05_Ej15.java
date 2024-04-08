/*
 * 15. Hacer un programa que devuelva la posición de inicio y fin de la
primera secuencia de números distinta de ceros.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp05_Ej15 {

	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	
	public static void main (String [] args) {
		
		int [] arr = new int[MAX];
		int inicio = 0;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			cargar_arreglo(arr);
			
			imprimir_arreglo(arr);
			
			inicio = buscar_pos_inicio(arr);
			
			System.out.println("La pos inicio es de: "+inicio);
		
		}
		catch(Exception exc) {
			
		}
		
	}
	
	public static int buscar_pos_inicio(int [] arr) {
		
		int inicio = 0;
		
		while((inicio < MAX-1) && (arr[inicio] == 0)) {
			inicio++;
		}
		
		
		return inicio;
	}
	
	
	public static void cargar_arreglo(int [] arr) {
		
		arr[0] = 0;
		arr[MAX-1] = 0;
		
		Random r = new Random();
		int indice;
		indice = 1;
		
		while(indice < MAX) {
			
			if(r.nextDouble() > probabilidad) {
				arr[indice] = (r.nextInt(MAXVALOR-MINVALOR+1)+MINVALOR);
			}
			
			indice++;
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