/*
 * 4. Buscar un elemento en un arreglo de caracteres ya cargado de
tamaño 10 y mostrar la/s posición/es del elemento, en caso de no
estar indicarlo también
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp05_Ej4 {

	public static int MAX = 15;
	
	public static void main (String [] args) {
		
		int [] arr = new int[MAX];
		int num;
		int pos;
		
		cargar_arreglo(arr);
		
		imprimir_arreglo(arr);
		
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
		
			System.out.println("Introduzca un num para buscarlo en el arreglo");
			num = Integer.valueOf(entrada.readLine());
			
			pos = buscar_pos(arr, num);
				
			System.out.println("El numero esta en la pos: "+pos);
			
		}
		catch(Exception exc) {
			
		}
	
	}
	
	public static int buscar_pos(int [] arr, int num) {
		
		int indice = 0;
		
		while((indice < MAX) && arr[indice] != num) {
		
			indice++;
		}
		
		
		return indice;
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