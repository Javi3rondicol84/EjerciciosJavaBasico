/*
 * 17. Hacer un programa que devuelva la posición de inicio y fin de la
anteúltima secuencia de números distintos de ceros
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp05_Ej17 {

	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	public static int iteracion = 2;
	
	public static void main (String [] args) {
		
		int [] arr = new int[MAX];
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			cargar_arreglo(arr);
			
			imprimir_arreglo(arr);
			
			buscar_anteult_secuencia(arr);
		
		}
		catch(Exception exc) {
			
		}
		
	}
	
	public static void buscar_anteult_secuencia(int [] arr) {
		int indice = MAX-1;	
		int inicio = MAX-1;
		int fin = MAX-1;
		int tmp = 0;
		
		while(indice > 0) {
			
				if(tmp < iteracion) {
					
					inicio = buscar_pos_inicio(arr, fin);
					
					if(inicio > 0) {
						
						fin = buscar_pos_fin(arr, inicio);
						
						tmp++;
					}
							
				}

			
			indice--;
		}
		
		System.out.println("la anteultima secuencia empieza en: "+(fin+1)+" y termina en: "+(inicio));
	}
	
	public static int buscar_pos_fin(int [] arr, int pos) {
		int indice = pos;
		
		while((indice > 0) && (arr[indice] != 0)) {
			indice--;
		}
		
		return indice;
	}
	
	
	public static int buscar_pos_inicio(int [] arr, int pos) {
		
		int indice = pos;
		
		while((indice > 0) && (arr[indice] == 0)) {
			
			indice--;
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