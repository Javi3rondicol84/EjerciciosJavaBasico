/*
 * 29. Hacer un programa que dado un arreglo de enteros de tamaño
10 que se encuentra precargado, solicite al usuario el ingreso de
dos números enteros (posiciones del arreglo) y ordene de forma
creciente el arreglo entre dos posiciones correspondientes a los
números ingresados.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp05_Ej29 {

	public static int MAX = 10;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	
	public static void main (String [] args) {
		
		int [] arr = new int[MAX];
		int n1 = 0;
		int n2 = 0;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			cargar_arreglo(arr);
			
			imprimir_arreglo(arr);
		
			
			
			do {
				System.out.println("Introduzca dos pos para ordenar el arreglo, la primera debe ser menor que la segunda,  (entre 0 y 9)");
				n1 = Integer.valueOf(entrada.readLine());
				n2 = Integer.valueOf(entrada.readLine());
				
			}while(n1 > n2); 
			
			ordenar_arreglo(arr, n1, n2);
			
			imprimir_arreglo(arr);
			
		}
		catch(Exception exc) {
			
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
	
	
	public static void ordenar_arreglo(int [] arr, int n1, int n2) {
		
		int tmp = 0;
		
		for(int j = n1+1; j <= n2; j++) {
			
			for(int i = n1; i < n2; i++) {
				
				if(arr[i] > arr[i+1]) {
					
					tmp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = tmp;
					
				}
				
			}
			
		}
		
	}
	
	
}