/*
 * Hacer un programa que dado el arreglo definido y precargado elimine del arreglo
todas las ocurrencias de una secuencia patrón dada por otro arreglo de iguales
características (solo tiene esa secuencia). Al eliminar se pierden valores haciendo
corrimientos.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp3_Ej15 {
	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	
	public static void main(String [] args) {
		
		//int [] arr = {0,5,3,3,0,0,1,2,3,4,7,0,0,0,1,2,3,4,7,0};
		//int [] arrPatron = {1,2,3,4,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int [] arr = {0,5,3,5,0,1,2,3,4,0,2,0,1,2,3,4,0,2,0,0};
		int [] arrPatron = {1,2,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		//cargar_arreglo(arr);
		
		imprimir_arreglo(arr);
		System.out.println();
		imprimir_arreglo(arrPatron);
		System.out.println();
		
		try {
			BufferedReader entrada = new BufferedReader( new InputStreamReader(System.in));
			
			eliminar_patron_secuencia(arr, arrPatron);
			
			System.out.println("Secuencias eliminadas: ");
			imprimir_arreglo(arr);
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	public static void eliminar_patron_secuencia(int [] arr, int [] arrPatron) {
			int inicio = 0;
			int fin = -1;
		
			while(inicio < MAX-1) {
				inicio = buscar_inicio(arr, fin+1);
				
				if(inicio < MAX-1) {
					fin = buscar_fin(arr, inicio);
				}
				
				revisar_secs(arr, arrPatron, inicio, fin);
				
			}
	}
	
	public static void revisar_secs(int [] arr, int [] arrPatron, int inicio, int fin) {
		
		int init = 0;
		int suma = 0;
		int inicio2 = 0;
		int fin2 = -1;
		int aux = inicio;
		
		inicio2 = buscar_inicio(arrPatron, fin2+1);
		
		if(inicio2 < MAX-1) {
			fin2 = buscar_fin(arrPatron, inicio2);
		}
		
		while(inicio <= fin) {
			
			if(arr[inicio] == arrPatron[init]) {
				suma++;
			}
			
			inicio++;
			init++;
		}
		
		if(suma == ((fin2+1)-inicio2)) {
			eliminar_sec(arr, aux, fin);
			inicio = 0;
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
		
		while((inicio < MAX-1)&&(arr[inicio] == 0)) {
			inicio++;
		}
		
		return inicio;
	}
	
	public static int buscar_fin(int [] arr, int inicio) {
		
		while((inicio < MAX-1)&&(arr[inicio] != 0)) {
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
