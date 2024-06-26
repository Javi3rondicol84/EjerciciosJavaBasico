/*
 * 11. Hacer un programa que dado un arreglo de enteros de tama�o
10 que se encuentra precargado, solicite al usuario un n�mero
entero y elimine todas las ocurrencia de n�mero en el arreglo.
Mientras exista (en cada iteraci�n tiene que buscar la posici�n
dentro del arreglo) tendr� que usar la posici�n para realizar un
corrimiento a izquierda (quedar�n tantas copias de la �ltima posici�n
 del arreglo como cantidad de ocurrencias del n�mero).

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp05_Ej11 {

	public static int MAX = 10;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	
	public static void main (String [] args) {
		
	//	int [] arr = new int[MAX];
		int [] arr = {1,1,9,1,9,3,1,1,3,0};
		int num;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			//cargar_arreglo(arr);
			
			imprimir_arreglo(arr);
			
			System.out.println("Introduzca un numero, si se encuentra se elimina");
			num = Integer.valueOf(entrada.readLine());
			
			buscar_eliminar_ocurrencias(arr, num);
			
			imprimir_arreglo(arr);
		
		}
		catch(Exception exc) {
			
		}
		
	}
	
	public static void buscar_eliminar_ocurrencias(int [] arr, int num) {
		int indice = 0;
		
		while(indice < MAX) {
			
			if(arr[indice] == num) {
				
				corrimiento_izq(arr, indice);
				
				indice--;
			}
			
			
			indice++;
		}
		

		
	}
	
	public static void corrimiento_izq(int [] arr, int pos) {
		int indice = pos;
		
		while(indice < MAX-1) {
			
			arr[indice] = arr[indice+1];
			
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