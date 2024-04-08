/*
 * Hacer un programa que dado un arreglo ordenado creciente de enteros
de tamaño 10 que se encuentra precargado, solicite al usuario un numero
entero y elimine la primer ocurrencia de numero (un número igual) en el
arreglo (si existe).
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp2_Ej8 {

	public static int MAX = 10;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	
	public static void main(String [] args) {
		
		int [] arr = new int[MAX];
		int num = 0;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			cargar_arreglo(arr);
			ordenar_seleccion(arr);
			imprimir_arreglo(arr);
			
			System.out.println("Introduce un num para eliminar su ocurrencia.");
			num = Integer.valueOf(entrada.readLine());
			
			eliminar_ocurrencia(arr, num);
			
			System.out.println("Ocurrencia eliminada.");
			imprimir_arreglo(arr);
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	public static void eliminar_ocurrencia(int [] arr, int num) {
		
		int index = 0;
		
		while((index < MAX) && (arr[index] < num)) {
			index++;
		}
		
		corrimiento_izq(arr, index);
	}
	
	public static void corrimiento_izq(int [] arr, int pos) {
		
		while(pos < MAX-1) {
			
			arr[pos] = arr[pos+1];
			
			pos++;
			
		}
		
	}
	
	
	public static void ordenar_seleccion(int [] arr) {
		
		int posmenor = 0;
		int tmp = 0;
		
		for(int i = 0; i < MAX; i++) {
			
			posmenor = i;
			
			for(int j = i + 1; j < MAX; j++) {
				
				if(arr[j] < arr[posmenor]) {
					posmenor = j;
				}
				
			}
			
			if(posmenor != i) {
				tmp = arr[i];
				arr[i] = arr[posmenor];
				arr[posmenor] = tmp;
			}
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
