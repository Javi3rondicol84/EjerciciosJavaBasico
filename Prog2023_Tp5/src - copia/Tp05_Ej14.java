/*
 * 14. Hacer un programa que elimine los valores pares en un arreglo
de tamaño MAX=10.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp05_Ej14 {

	public static int MAX = 10;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	
	public static void main (String [] args) {
		
		//int [] arr = {2,8,2,2,9,8,3,2,2,1};
		int [] arr = new int [MAX];

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			cargar_arreglo(arr);
			
			imprimir_arreglo(arr);
			
			eliminar_pares(arr);
		
			imprimir_arreglo(arr);
		}
		catch(Exception exc) {
			
		}
		
	}
	
	public static void eliminar_pares(int [] arr) {
		
		int indice = 0;
		int pos = 0;
		
		/*
		 * 	int [] arr = {5,8,3,2,9,8,3,2,1,1}; pos 2
		 * 	int [] arr = {5,2,2,9,8,2,5,1,1,0}; 
		 *  int [] arr = {5,9,8,2,5,1,1,1,1,0}; 
		 * 
		 */
		

			while(indice < MAX-1) {
				

				
				if(comprobar_par(arr, pos) == true) {
					//si es par, usar indice 0, mirar devuelta si es par, si lo es, indice 0, si no lo es, incrementar 1.
					
					corrimiento_izq(arr, pos);
					
				
				}
				else {
					pos++;
				}
			
				
				indice++;
		}

	}
	
	

	
	public static boolean comprobar_par(int [] arr, int indice) {
		boolean comprobar = false;
		
		if(arr[indice] % 2 == 0) {
			comprobar = true;
		}
		
		
		return comprobar;
	}
	

	public static void corrimiento_izq(int [] arr, int indice) {

	
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
		
		arr[MAX-1] = 0;
		
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