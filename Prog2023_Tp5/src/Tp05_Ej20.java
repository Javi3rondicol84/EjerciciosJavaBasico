/*
 * 20. Hacer un programa que elimine de un arreglo todas las
ocurrencias de una secuencia patrón dada por otro arreglo
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp05_Ej20 {

	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	
	public static void main (String [] args) {
		
		int [] arr = {0,4,4,4,4,0,0,9,4,0,4,2,4,8,0,4,4,4,4,0};
		int [] arrPatron = {0,4,4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	//	int [] arr = new int[MAX];
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
		//	cargar_arreglo(arr);
			
			imprimir_arreglo(arr);
			System.out.println("arreglo b:");
			imprimir_arreglo(arrPatron);
			
			eliminar_secs_patron(arr, arrPatron);
			
			imprimir_arreglo(arr);
		
		}
		catch(Exception exc) {
			
		}
		
	}
	
	public static void eliminar_secs_patron(int [] arr, int [] arrB) {
		
		int indice = 0;
		int inicio = 0;
		int fin = -1;
		
		while(indice < MAX-1) {
			
			inicio = buscar_pos_inicio(arr, fin+1);
			
			if(inicio < MAX-1) {
				fin = buscar_pos_fin(arr, inicio);
				
				if(comprobacion(arr, arrB, inicio, fin) == true) {
					eliminar_sec(arr, inicio, fin);
					fin = inicio;
				}
				
			}
			
			
			indice++;
		}
		
	}
	
	public static void eliminar_sec(int [] arr, int inicio, int fin) {
		int tam = ((fin+1)-inicio);
		int indice = 0;
		
		while(indice < tam) {
			
			corrimiento_izq(arr, inicio);
			
			indice++;
		}
		
	}
	
	public static void corrimiento_izq(int [] arr, int inicio) {
		int pos = inicio;
		
		while(pos < MAX-1) {
			arr[pos] = arr[pos+1];
			pos++;
		}
		
	}
	
	public static boolean comprobacion(int [] arr, int [] arrB, int posin, int posfin) {
		int indice = 0;
		int inicioB = 0;
		int finB = -1;
		int tmp = 0;
		boolean resultado = false;
		
		inicioB = buscar_pos_inicio(arrB, finB+1);
		finB = buscar_pos_fin(arrB, inicioB);
			
		if((posfin+1-posin) == (finB+1-inicioB)) {
			while((indice < MAX-1)  && (arr[posin+indice] != 0)) {
				
				if((arr[posin+indice] == arrB[inicioB+indice])) {
					tmp++;
				}
				
				indice++;
			}
			
			if(tmp == (finB+1-inicioB)) {
				resultado = true;
			}
		
		}
		
		return resultado;
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