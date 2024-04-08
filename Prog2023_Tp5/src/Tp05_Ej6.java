/*
 * 6. Hacer un programa que dado un arreglo de enteros de tamaño 10
que se encuentra cargado, obtenga la cantidad de números pares
que tiene y la imprima.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp05_Ej6 {

	public static int MAX = 10;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	
	public static void main (String [] args) {
		
		int [] arr = new int[MAX];
		int pares;
		
		cargar_arreglo(arr);
		
		imprimir_arreglo(arr);
		
		pares = obtener_pares(arr);
		
		System.out.println("El arreglo tiene "+pares+" numeros pares");
	}
	
	public static int obtener_pares(int [] arr) {
		
		int sum = 0;
		int indice = 0;
		
		while(indice < MAX) {
			
			if(arr[indice] % 2 == 0) {
				sum++;
			}
			
			indice++;
		}
		
		return sum;
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