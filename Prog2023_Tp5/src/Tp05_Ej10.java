/*
 * 10. Hacer un programa que dado un arreglo de enteros de tama�o
10 que se encuentra precargado, solicite al usuario un n�mero
entero y elimine la primera ocurrencia del n�mero (un n�mero
igual) en el arreglo (si existe). Para ello tendr� que buscar la
posici�n y si est�, realizar un corrimiento a izquierda (queda una
copia de la �ltima posici�n del arreglo en la ante�ltima posici�n).

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp05_Ej10 {

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
			
			System.out.println("Introduzca un numero, si se encuentra se elimina");
			num = Integer.valueOf(entrada.readLine());
			
			buscar_eliminar(arr, num);
			
			imprimir_arreglo(arr);
		
		}
		catch(Exception exc) {
			
		}
		
	}
	
	public static void buscar_eliminar(int [] arr, int num) {
		int indice = 0;
		
		while((indice < MAX) && (arr[indice] != num)) {
			indice++;
		}
		
		if(indice < MAX) {
			corrimiento_izq(arr, indice);
		}
		else {
			System.out.println("El numero no est� en el arreglo");
		}
		
	}
	
	public static void corrimiento_izq(int [] arr, int pos) {
		int indice = pos;
		
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