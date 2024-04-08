/*
 * 30. Hacer un programa que cargue un arreglo (sin orden) de
tamaño MAX=10 con números enteros aleatorios entre 0 y 100.
Finalmente imprima por pantalla el arreglo ordenado. Hacerlo para
orden creciente y decreciente
 */



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp05_Ej30 {

	public static int MAX = 10;
	public static int MAXVALOR = 100;
	public static int MINVALOR = 0;
	
	public static void main (String [] args) {
		
		int [] arr = new int[MAX];
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			cargar_arreglo(arr);
			
			imprimir_arreglo(arr);
		
		}
		catch(Exception exc) {
			
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
	
	
	public static void ordenar_arreglo(int [] arr) {
		
		int tmp = 0;
		
		for(int j = 1; j < MAX; j++) {
			
			for(int i = 0; i < MAX-1; i++) {
				
				if(arr[i] > arr[i+1]) {
					
					tmp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = tmp;
					
				}
				
			}
			
		}
		
	}
	
	
}