/*
 * 3. Con el mismo arreglo del ejercicio anterior informe por pantalla
cuantos elementos del mismo están por encima del promedio
calculado
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp05_Ej3 {
	
	public static int MAX = 10;

	public static void main (String [] args) {
		
		int elementos = 0;
		int promedio = 0;
		int [] arr = new int[MAX];
		cargar_arreglo(arr);
		imprimir_arreglo(arr);
		promedio = calcular_promedio(arr);
		elementos = encima_del_promedio(arr, promedio);
		
		System.out.println("El promedio de los valores del arreglo es: "+promedio);
		System.out.println(elementos+" valores superan el promedio de los valores del arreglo");
	}
	
	public static int encima_del_promedio(int [] arr, int promedio) {
		
		int indice = 0;
		int elem = 0;
		
		while(indice < MAX) {
			
			if(promedio < arr[indice]) {
				elem++;
			}
			
			indice++;
		}
		
		return elem;
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