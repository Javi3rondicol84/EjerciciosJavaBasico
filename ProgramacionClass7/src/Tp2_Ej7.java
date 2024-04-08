/*
 * Hacer un programa que dado un arreglo ordenado creciente de enteros
de tamaño 10 que se encuentra precargado, solicite al usuario un numero
entero y lo inserte en el arreglo manteniendo su orden. Para ello tendrá
que realizar un corrimiento a derecha (se pierde el último valor del arreglo)
y colocar el numero en el arreglo en la posición indicada.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp2_Ej7 {

	public static int MAX = 10;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	
	public static void main(String [] args) {
		
		int [] arr = new int[MAX];
		int num = 0;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			cargar_arreglo(arr);
			ordenar_seleccion(arr);
			imprimir_arreglo(arr);
			System.out.println("Introduce un Num para insertar: ");
			num = Integer.valueOf(entrada.readLine());
			corrimiento_der(arr);
			System.out.println("Corr a derecha");
			imprimir_arreglo(arr);
			System.out.println("Num insertado.");
			insertar_num(arr, num);
			imprimir_arreglo(arr);
			
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	public static void corrimiento_der(int [] arr) {
		int index = MAX-1;
		
		while(index > 0) {
			
			arr[index] = arr[index-1];
			
			index--;
		}
	
	}
	
	public static void insertar_num(int [] arr, int num) {
		int index = 0;
		
		while((index < MAX-1) && (arr[index] < num)) {
				
			index++;
		}
		
	}
		
	public static void ordenar_seleccion(int [] arr) {
		
		int posmenor = 0;
		int tmp = 0;
		
		for(int i = 0; i < MAX; i++) {
			
			posmenor = i;
			
			for(int j = i + 1; j < MAX; j++) {
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
