/*
 * 27. Hacer un programa que dado un arreglo ordenado creciente de
enteros de tamaño 10 que se encuentra precargado, solicite al
usuario un número entero y lo inserte en el arreglo manteniendo
su orden. Para ello tendrá que realizar un corrimiento a derecha
(se pierde el último valor del arreglo) y colocar el número en el
arreglo en la posición indicada.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp05_Ej27 {

	public static int MAX = 10;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	
	public static void main (String [] args) {
		
		int [] arr = new int[MAX];
		int num = 0;
		int pos = 0;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			cargar_arreglo(arr);
			imprimir_arreglo(arr);
			ordenar_arreglo(arr);
			imprimir_arreglo(arr);
			
			System.out.println("introduce un numero para agregarlo");
			num = Integer.valueOf(entrada.readLine());
			
			pos = buscar_pos(arr, num);
			
			System.out.println(pos);
			
			corrimiento_der(arr, pos);
			
			imprimir_arreglo(arr);
			
			arr[pos] = num;
			
			imprimir_arreglo(arr);
			
		
		
		}
		catch(Exception exc) {
			
		}
		
	}
	
	public static void corrimiento_der(int [] arr, int pos) {
	
		int indice = MAX-1;
		
		while(indice > pos) {
			
			arr[pos] = arr[pos-1];
			
			indice--;
		}
		
	}
	
	
	public static int buscar_pos(int [] arr, int num) {
		
		int pos = 0;
		
		while((pos < MAX) && (arr[pos] < num)) {
			pos++;
		}
		
		return pos;
	}
	
	
	
	public static void ordenar_arreglo(int [] arr) {
		
		int tmp = 0;
		
		for(int j = 1; j < MAX; j++) {
			
			for(int i = 0; i < MAX-1; i++) {
				
				if(arr[i] > arr[i+1]) {
					
					tmp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = tmp;
					
				}
				
			}
			
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