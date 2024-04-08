
/*Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, solicite al usuario un numero entero y elimine todas las ocurrencia de numero
en el arreglo. Mientras exista (en cada iteración tiene que buscar la posición dentro del
arreglo) tendrá que usar la posición para realizar un corrimiento a izquierda (quedarán
tantas copias de la última posición del arreglo como cantidad de ocurrencias del número).
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp1_Ej6 {

	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	
	public static void main(String [] args) {
		
		int [] arr = new int[MAX];
		//int [] arr = {4,6,6,6,6,1,3};
		int num = 0;
		
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			cargar_arreglo(arr);
			
			imprimir_arreglo(arr);
			
			System.out.println("Introduce un num para eliminar sus ocurrencias");
			num = Integer.valueOf(entrada.readLine());
			
			eliminar_ocurrencias(arr, num);
			
			System.out.println("Ocurrencias eliminadas: ");
			
			imprimir_arreglo(arr);
			
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
	public static void eliminar_ocurrencias(int [] arr, int num) {
		
		int index = 0;
		
		while(index < MAX) {
			
			if(arr[index] == num) {
				
				corrimiento_izq(arr, index);
				index--;
				
			}
			
			index++;
		}
		
	}
	
	public static void corrimiento_izq(int [] arr, int indice) {
		int index = indice;
		
		while(index < MAX-1) {
			
			
			arr[index] = arr[index+1];
			
			index++;
		}
		
	}
	
	
	public static void cargar_arreglo(int [] arr) {
		Random r = new Random();
		
		int index = 0;
		
		while(index < MAX) {
			
			arr[index] = (r.nextInt(MAXVALOR-MINVALOR+1)+MINVALOR);
			
			index++;
			
		}
		
	}
	
	public static void imprimir_arreglo(int [] arr) {
		int index = 0;
		
		System.out.print("Arreglo: ");
		
		while(index < MAX) {
			
			System.out.print("["+arr[index]+"]");
			
			index++;
		}
		
	}
	
	
	

	
	
	
}
