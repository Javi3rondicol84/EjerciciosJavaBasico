
/*
 *vHacer un programa que dado un arreglo de enteros de tamaño 10 que se
encuentra precargado, solicite al usuario el ingreso de dos números
enteros (posiciones del arreglo) y ordene de forma creciente el arreglo
entre dos posiciones correspondientes a los números ingresados. 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp2_Ej9 {

	public static int MAX = 10;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	
	public static void main(String [] args) {
		
		int [] arr = new int[MAX];
		int num1 = 0;
		int num2 = 0;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			cargar_arreglo(arr);
			imprimir_arreglo(arr);
			
			System.out.println("Introduce primer posicion para ordenar arreglo.");
			num1 = Integer.valueOf(entrada.readLine());
			
			System.out.println("Introduce segunda posicion para ordenar arreglo.");
			num2 = Integer.valueOf(entrada.readLine());
			
			ordenar_seleccion(arr, num1, num2);
			
			System.out.println("Arreglo ordenado.");
			imprimir_arreglo(arr);
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	public static void ordenar_seleccion(int [] arr, int num1, int num2) {
		
		int posmenor = 0;
		int tmp = 0;
		
		for(int i = num1; i < num2; i++) {
			posmenor = i;
			
			for(int j = i + 1; j < num2; j++) {
				
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
