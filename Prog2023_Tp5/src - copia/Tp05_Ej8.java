/*
 * 8. Implementar un método que realice un corrimiento a izquierda en
un arreglo ordenado de tamaño MAX=10 a partir de una posición.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp05_Ej8 {

	public static int MAX = 10;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	
	public static void main (String [] args) {
		
		int [] arr = new int[MAX];
		int num;
	
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			cargar_arreglo(arr);
			
			imprimir_arreglo(arr);
			
			
			System.out.println("Introduzca una pos desde la que realizar un cor a izquierda");
			num = Integer.valueOf(entrada.readLine());
			
			corrimiento_izquierda(arr, num);
			
			imprimir_arreglo(arr);
			
		}
		catch(Exception exc) {
			
		}

	}
	
	public static void corrimiento_izquierda(int [] arr, int num) {
		int indice = num;
		
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