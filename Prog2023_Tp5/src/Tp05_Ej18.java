/*
 * 18. Hacer un programa que devuelva la posición de inicio y de fin
de la secuencia de mayor tamaño.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp05_Ej18 {

	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	
	public static void main (String [] args) {
		
		int [] arr = new int[MAX];
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			cargar_arreglo(arr);
			
			imprimir_arreglo(arr);
			
			buscar_sec_mayor_tam(arr);
		
		}
		catch(Exception exc) {
			
		}
		
	}
	
	
	public static void buscar_sec_mayor_tam(int [] arr) {
		
		int indice = 0;
		int inicio = 0;
		int fin = -1;
		int tmp = 0;
		int mayortam = 0;
		int mayorinicio = 0;
		int mayorfin = 0;
		
		while(indice < MAX-1) {
			
			inicio = buscar_pos_inicio(arr, fin+1);
			
			if(inicio < MAX-1) {
				fin = buscar_pos_fin(arr, inicio);
				
				tmp = ((fin+1) - inicio);
				
				if(tmp > mayortam) {
					mayortam = tmp;
					mayorinicio = inicio;
					mayorfin = fin;
				}
			}
				
			indice++;
		}
		
		System.out.println("La secuencia de mayor tamaño empieza en: "+mayorinicio+" y termina en la pos: "+mayorfin+" y es de tamaño: "+mayortam);
		
	}
	
	public static int buscar_pos_fin(int [] arr, int pos) {
		int indice = pos;
		
		while((indice < MAX-1) && (arr[indice] != 0)) {
			indice++;
		}
		
		return indice-1;
	}
	
	public static int buscar_pos_inicio(int [] arr, int pos) {
		int indice = pos;
		
		while((indice < MAX-1) && (arr[indice] == 0)) {
			indice++;
		}
		
		return indice;
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