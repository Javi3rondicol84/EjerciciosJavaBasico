/*
 * 23. Hacer un programa que invierta el orden de la última secuencia
en un arreglo.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp05_Ej23 {

	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	
	public static void main (String [] args) {
		
		int [] arr = {0,4,4,4,4,0,0,9,4,0,4,2,0,2,7,3,2,8,5,0};
		//int [] arr = new int[MAX];
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			//cargar_arreglo(arr);
			
			imprimir_arreglo(arr);
			
			invertir_ult_secuencia(arr);
		
			imprimir_arreglo(arr);
		}
		catch(Exception exc) {
			
		}
		
	}
	
	public static void invertir_ult_secuencia(int [] arr) {
		
		int indice = 0;
		int inicio = MAX-1;
		int fin = MAX-1;
		int aux = 0;
		int aux2 = 0;
		
		inicio = buscar_pos_inicio(arr, fin);
		fin = buscar_pos_fin(arr, inicio);
		
		
		
		System.out.println(inicio + "" + fin);
		
		aux2 = fin;
		fin = inicio;
		inicio = aux2;
		
		System.out.println(inicio + "" + fin);
		
		while(indice < (((fin+1)-inicio)/2)) {
			aux = arr[inicio+indice];
			arr[inicio+indice] = arr[fin-indice];
			arr[fin-indice] = aux;
			
			indice++;
		}
	}
	
	
	public static int buscar_pos_inicio(int [] arr, int indice) {
		
		while((indice > 0) && (arr[indice] == 0)) {
			indice--;
		}
		
		return indice;
	}
	
	
	public static int buscar_pos_fin(int [] arr, int indice) {
		
		while((indice > 0) && (arr[indice] != 0)) {
			indice--;
		}
		
		return indice+1;
	}
	

	
	
	
	public static void cargar_arreglo(int [] arr) {
		
		arr[0] = 0;
		arr[MAX-1] = 0;
		
		Random r = new Random();
		int indice;
		indice = 1;
		
		while(indice < MAX-1) {
			
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