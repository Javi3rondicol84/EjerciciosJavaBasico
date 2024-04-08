/*
 * 25. Hacer un programa que dado el arreglo definido y precargado,
y un número entero ingresado por el usuario, copie de forma
continua las secuencias de tamaño igual al número ingresado en
otro arreglo de iguales características e inicializado con 0. La
copia en este último arreglo deben comenzar desde el principio
del mismo.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp05_Ej25 {

	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	
	public static void main (String [] args) {
		
		int num = 0;
		int [] arr = {0,4,4,4,4,0,0,9,4,0,4,2,4,8,0,2,2,2,5,0};
		int [] arrB = new int[MAX];
		//int [] arr = new int[MAX];
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			//cargar_arreglo(arr);
			
			imprimir_arreglo(arr);
			
			inicializar_en_cero(arrB);
			
			imprimir_arreglo(arrB);
			
			System.out.println();
			System.out.println("Ingrese un num de tamanio de secuencia");
			num = Integer.valueOf(entrada.readLine());
			
			copiar_secs(arr, arrB, num);
			
			System.out.println("resultado final en arrB");
			imprimir_arreglo(arrB);
		}
		catch(Exception exc) {
			
		}
		
	}
	
	
	public static void copiar_secs(int [] arr, int [] arrB, int num) {
		
		int indice = 0;
		int inicio = 0;
		int fin = -1;
		int init = 0;
		int aux = 0;
		
		while(indice < MAX-1) {
			
			inicio = buscar_pos_inicio(arr, fin+1);
			
			if(inicio < MAX-1) {
				
				fin = buscar_pos_fin(arr, inicio);
				
				if(((fin+1)-inicio) == num) {
					
					aux = copiar_sec_arr_arrB(arr, arrB, inicio, init);
					init = aux;
				}
			}
			
			indice++;
		}
	}
	
	public static int copiar_sec_arr_arrB(int [] arr, int [] arrB, int inicio, int init) {
		
		int indice = 0;
		
		while((indice < MAX-1) && (arr[inicio+indice] != 0)) {
			
			arrB[init] = arr[inicio+indice];
			
			indice++;
			init++;
		}
		
		return init;
	}

	
	public static void inicializar_en_cero(int [] arrB) {
		
		int indice = 0;
		
		while(indice < MAX-1) {
			
			arrB[indice] = 0;
			
			indice++;
			
		}
		
		
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