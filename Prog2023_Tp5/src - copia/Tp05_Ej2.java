/*
 * 2. Hacer un programa que dado un arreglo ya cargado con 10
enteros, calcule el promedio y lo muestre por la consola.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp05_Ej2 {
	
	public static int MAX = 10;

	public static void main (String [] args) {
		
		int promedio = 0;
		int [] arr = new int[MAX];
		cargar_arreglo(arr);
		imprimir_arreglo(arr);
		promedio = calcular_promedio(arr);
		
		System.out.println("El promedio de los valores del arreglo es: "+promedio);
	}
	
	public static int calcular_promedio(int [] arr) {
		int sum;
		int indice;
		int promedio;
		indice = 0;
		sum = 0;
		promedio = 0;
		
		while(indice < MAX) {
			sum = sum + arr[indice];
			indice++;
		}
		
		promedio = sum / MAX;
		
		return promedio;
	}
	
	public static void cargar_arreglo(int [] arr) {
		
		int indice, sum;
		indice = 0;
		sum = 1;
		
		while(indice < MAX) {
			
			arr[indice] = sum;
			
			indice++;
			sum++;
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