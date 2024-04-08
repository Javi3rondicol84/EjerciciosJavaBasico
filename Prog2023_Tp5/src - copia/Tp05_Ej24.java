/*
 * 24. Se tiene un arreglo de enteros de tamaño 20 de secuencias de
números entre 1 y 9, separadas por 0. El arreglo está precargado,
y además empieza y termina con uno o más separadores 0.

 Hacer
un programa que permita obtener a través de métodos la posición
de inicio y la posición de fin de la secuencia ubicada a partir de
una posición entera ingresada por el usuario. Finalmente, si
existen imprima por pantalla ambas posiciones obtenidas.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp05_Ej24 {

	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	
	public static void main (String [] args) {
		
		int num = 0;
		int [] arr = {0,4,4,4,4,0,0,9,4,0,4,2,4,8,0,0,0,0,5,0};
		//int [] arr = new int[MAX];
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			//cargar_arreglo(arr);
			
			imprimir_arreglo(arr);
		
			System.out.println("Ingrese un numero para encontrar una secuencia a partir de el");
			num = Integer.valueOf(entrada.readLine());
			
			if(num < MAX-1) {
				encontrar_sec(arr, num);
			}
			else {
				System.out.println("numero mayor al tamaño del arreglo");
			}
			
			
		}
		catch(Exception exc) {
			
		}
		
	}
	
	public static void encontrar_sec(int [] arr, int num) {
		
		int inicio = num;
		int fin = 0;
		
		inicio = buscar_pos_inicio(arr, num);
		
		if(inicio < MAX-1) {
			fin = buscar_pos_fin(arr, inicio);
		}
		
		System.out.println("La pos inicio de la sec a partir del numero ingresado es: "+inicio+" y termina en: "+fin);
	
	}
	
	
	
	public static int buscar_pos_fin(int [] arr, int pos) {
		int indice = pos;
		
		while((indice < MAX-1) && (arr[indice] != 0)) {
			indice++;
		}
		
		return indice-1;
	}
	
	public static int buscar_pos_inicio(int [] arr, int pos) {
		int indice = pos;
		
		while((indice < MAX-1) && (arr[indice] == 0)) {
			indice++;
		}
		
		return indice;
	}
	
	
	
	public static void cargar_arreglo(int [] arr) {
		
		arr[0] = 0;
		arr[MAX-1] = 0;
		
		Random r = new Random();
		int indice;
		indice = 1;
		
		while(indice < MAX-1) {
			
			if(r.nextDouble() > probabilidad) {
				arr[indice] = (r.nextInt(MAXVALOR-MINVALOR+1)+MINVALOR);
			}
			
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