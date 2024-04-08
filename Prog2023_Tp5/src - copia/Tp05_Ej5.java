/*
 * 5. Hacer un programa que dado un arreglo de caracteres de tamaño
10 que se encuentra cargado, invierta el orden del contenido. Este
intercambio no se debe realizar de manera explícita, hay que
hacer un método que incluya una iteración de intercambio.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp05_Ej5 {

	public static int MAX = 10;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	
	public static void main (String [] args) {
		
		int [] arr = new int[MAX];
		
		cargar_arreglo(arr);
		
		imprimir_arreglo(arr);
		
		intercambiar_arreglo(arr);
		
		imprimir_arreglo(arr);
	}
	
	public static void intercambiar_arreglo(int [] arr) {
		int indice = 0;
		int aux = 0;
		
		while(indice < MAX/2) {
			aux = arr[indice];
			arr[indice] = arr[MAX-1-indice];
			arr[MAX-1-indice] = aux;
			
			indice++;
		}
		
		
	}
	
	
	public static void cargar_arreglo(int [] arr) {
		
		Random r = new Random();
		int indice;
		indice = 0;
		
		while(indice < MAX) {
			
			arr[indice] = (r.nextInt(MAXVALOR-MINVALOR+1)+MINVALOR);
			
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