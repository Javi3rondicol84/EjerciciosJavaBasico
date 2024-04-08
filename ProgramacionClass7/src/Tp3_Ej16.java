import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*
 * Hacer un programa que dado el arreglo definido y precargado elimine todas las
secuencias que tienen orden descendente entre sus elementos.
 */

public class Tp3_Ej16 {
	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	
	public static void main(String [] args) {
		
		int [] arr = {0,0,9,7,5,0,0,6,7,0,0,7,6,5,4,0,0,7,2,0};
		
		//cargar_arreglo(arr);
		
		imprimir_arreglo(arr);
		
		try {
			BufferedReader entrada = new BufferedReader( new InputStreamReader(System.in));
			
			System.out.println();
			
			eliminar_descendente(arr);
			
			System.out.println("Secuencias eliminadas: ");
			
			imprimir_arreglo(arr);
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
	public static void eliminar_descendente(int [] arr) {
	
		
		int inicio = 0;
		int fin = -1;
		int aux = 0;
		
		while(inicio < MAX-1) {
			
			inicio = buscar_inicio(arr, fin+1);
			
			if(inicio < MAX-1) {
				fin = buscar_fin(arr, inicio);
				
			}
			
			aux = ((fin+1)-inicio);
			
			revisar(arr, inicio, fin, aux);
			
		}
		
	}
	
	public static void revisar(int [] arr, int inicio, int fin, int aux) {
		
		int tmp = 0;
		int init = inicio;
		
		while(init <= fin) {
			if(arr[init] > arr[init+1]) {
				tmp++;
			}
			
			init++;
		}
		
		if(tmp == aux) {
			eliminar_sec(arr, inicio, fin);
		}
		
	}
	
	public static void eliminar_sec(int [] arr, int inicio, int fin) {
		int init = inicio;
		
		while(init <= fin) {
			
			corrimiento_izq(arr, inicio);
			
			init++;
		}
	}
	
	public static void corrimiento_izq(int [] arr, int inicio) {
		
		while(inicio < MAX-1) {
			arr[inicio] = arr[inicio+1];
			
			inicio++;
		}
		
	}
	
	public static int buscar_inicio(int [] arr, int inicio) {
		
		while((inicio < MAX-1) && (arr[inicio] == 0)) {
			inicio++;
		}
		
		return inicio;
	}
	
	public static int buscar_fin(int [] arr, int inicio) {
		
		while((inicio < MAX-1) && (arr[inicio] != 0)) {
			inicio++;
		}
		
		return inicio-1;
	}
	
	
	public static void cargar_arreglo(int [] arr) {
		
		Random r = new Random();
		int index = 1;
		arr[0] = 0;
		arr[MAX-1] = 0;
	
		while(index < MAX-1) {
			
			if(r.nextDouble() > probabilidad) {
				
				arr[index] = (r.nextInt(MAXVALOR-MINVALOR+1)+MINVALOR);
				
			}
			else {
				arr[index] = 0;
			}
			
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
