/*
 * 19. Hacer un programa que dado un número N ingresado por el
usuario, elimine las secuencias de tamaño N de números distintos
de cero.
 */



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp05_Ej19 {

	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	
	public static void main (String [] args) {
		
		int [] arr = {0,4,4,4,4,0,0,9,4,0,4,2,4,8,0,0,0,0,5,0};
		//int [] arr = new int[MAX];
		int num = 0;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			//cargar_arreglo(arr);
			
			imprimir_arreglo(arr);
			
			System.out.println("Ingrese un numero para eliminar todas las secuencias de ese tamaño: ");
			num = Integer.valueOf(entrada.readLine());
			
			eliminar_secuencias(arr, num);
			
			imprimir_arreglo(arr);
		
		}
		catch(Exception exc) {
			
		}
		
	}
	
	public static void eliminar_secuencias(int [] arr, int num) {
		
		int indice = 0;
		int inicio = 0;
		int fin = -1;
		
		
		while(indice < MAX-1) {
			
			inicio = buscar_pos_inicio(arr, fin+1);
			
			if(inicio < MAX-1) {
				fin = buscar_pos_fin(arr, inicio);
				
				if(((fin+1)-inicio) == num) {
					eliminar_sec(arr, inicio, num);
					fin = inicio;
				}
			
			
			}
			
			indice++;
		}
	}
	
	public static void eliminar_sec(int [] arr, int inicio, int num) {
		int pos = inicio;
		int indice = 0;
		
		while(indice < num) {
			
			
			corrimiento_izq(arr, pos);
			
			indice++;
			
		}
		
	
	}
		
	
	public static void corrimiento_izq(int [] arr, int pos) {
		
		while(pos < MAX-1) {
			
			arr[pos] = arr[pos+1];
			
			pos++;
		}
		
	}
	
	
	public static int buscar_pos_fin(int [] arr, int indice) {
	
		
		while((indice < MAX-1) && (arr[indice] != 0)) {
			indice++;
		}
		
		return indice-1;
	}
	
	public static int buscar_pos_inicio(int [] arr, int indice) {
		
		
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