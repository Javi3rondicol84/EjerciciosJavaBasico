
/*
 * Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, solicite al usuario un numero entero y elimine la primer ocurrencia del numero
(un número igual) en el arreglo (si existe). Para ello tendrá que buscar la posición y si está,
realizar un corrimiento a izquierda (queda una copia de la última posición del arreglo en la
anteúltima posición).

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp1_Ej5 {

	public static int MAX = 10;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	
	public static void main(String [] args) {
		
		int [] arr = new int[MAX];
		int num = 0;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			cargar_arreglo(arr);
			imprimir_arreglo(arr);
			
			System.out.println("Introduce un num para eliminar su ocurrencia.");
			num = Integer.valueOf(entrada.readLine());
			
			eliminar_ocurr(arr, num);
			
			imprimir_arreglo(arr);
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	public static void eliminar_ocurr(int [] arr, int num) {
		int index = 0;
		boolean find = false;
		int pos = 0;
		
		while((index < MAX) && (find == false)) {
			
			if(arr[index] == num) {
				find = true;
				pos = index;
			}
			
			index++;
		}
		
		if(pos < MAX) {
			corrimiento_izq(arr, pos);
		}
		else {
			System.out.println("No hubo ninguna ocurrencia de "+num);
		}
	}
	
	public static void corrimiento_izq(int [] arr, int pos) {
		
		while(pos < MAX-1) {
			
			arr[pos] = arr[pos+1];
			
			pos++;
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
