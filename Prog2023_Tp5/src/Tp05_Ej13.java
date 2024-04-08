/*
 * 13. Hacer un programa que inserte un elemento en un arreglo
(ordenado decrecientemente) de tamaño MAX=10.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp05_Ej13 {

	public static int MAX = 10;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	
	public static void main (String [] args) {
		
		int num = 0;
		int [] arr = {9,8,6,5,4,2,2,2,2,1};
	//	int [] arr = new int[MAX];
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			//cargar_arreglo(arr);
			
			imprimir_arreglo(arr);
			
			ordenar_arreglo_decreciente(arr);
			
			imprimir_arreglo(arr);
		
			System.out.println("ingrese un num para ingresarlo en un arreglo ordenado decreciente");
			num = Integer.valueOf(entrada.readLine());
			
			insertar_num(arr, num);
			
			imprimir_arreglo(arr);
			
		}
		catch(Exception exc) {
			
		}
		
	}
	
	public static void insertar_num(int [] arr, int num) {
		
		int indice = 0;
		
		indice = buscar_pos_arr_decreciente(arr, num);
		
		corrimiento_der(arr, indice);
		
		arr[indice] = num;
		
	}
	
	public static int buscar_pos_arr_decreciente(int [] arr, int num) {
		
		int indice = 0;
		
		while((indice < MAX-1) && (num < arr[indice])) {
			indice++;
		}
		
		
		return indice;
	}
	
	public static void corrimiento_der(int [] arr, int indice) {
		
		int pos = indice;
		
		while(pos > 0) {
			
			arr[pos] = arr[pos-1];
			
			pos--;
		}
		
	}
	
	
	public static void ordenar_arreglo_decreciente(int [] arr) {
		
		int aux = 0;
		
		for(int i = 1; i < MAX; i++) {
			
			for(int j = 0; j < MAX-1; j++) {
				if(arr[j] < arr[j+1]) {
					aux = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = aux;
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