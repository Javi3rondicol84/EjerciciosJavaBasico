import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*Hacer un programa que dado el arreglo definido y precargado elimine todas las
*secuencias que tienen orden descendente entre sus elementos.
 */


public class Tp3_Ej16_v2 {
	public static int MAX = 20;
	public static int MIN = 1;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	
	public static void main(String [] args) {
		
		int [] arr = {0,2,4,0,8,7,5,2,1,0,3,0,6,5,2,1,0,2,1,0};
		
		imprimir_arreglo(arr);
		
		secuencias_desc(arr);
		
		imprimir_arreglo(arr);
	}
	
	public static void secuencias_desc(int [] arr) {
		int inicio = 0;
		int fin = -1;
		
		while(inicio < MAX-1) {
			inicio = buscar_inicio(arr, fin+1);
			
			if(inicio < MAX-1) {
				fin = buscar_fin(arr, inicio);
			}
			
			if(comprobar(arr, inicio, fin) == true) {
				eliminar_sec(arr, inicio, fin);
				fin = inicio;
			}
		}
		
	}
	
	public static boolean comprobar(int [] arr, int inicio, int fin) {
		int tam = ((fin+1)-inicio);
		int i = 0;
		boolean frenar = true;
		
		while((inicio+i <= fin)&&(arr[inicio+i]) > (arr[inicio+i+1])&&(frenar == true)) {
			if(tam > MIN) {
				i++;
			}
			else {
				frenar = false;
			}
		}
		
		if(i == tam) {
			return true;
		}
		else {
			return false;
		}

	}
	
	public static void eliminar_sec(int [] arr, int inicio, int fin) {
		
		int i = 0;
		
		while(i < ((fin+1)-inicio)) {
			corrimiento_izq(arr, inicio);
			i++;
		}
	}
	
	public static void corrimiento_izq(int [] arr, int inicio) {
		int i = inicio;
		
		while(i < MAX-1) {
			arr[i] = arr[i+1];
			i++;
		}
	}
	
	public static int buscar_inicio(int [] arr, int indice) {
		while((indice < MAX-1)&&(arr[indice] == 0)) {
			indice++;
		}
		
		return indice;
	}
	
	public static int buscar_fin(int [] arr, int indice) {
		while((indice < MAX-1)&&(arr[indice] != 0)) {
			indice++;
		}
		
		return indice-1;
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
		
		System.out.print("\nArreglo: ");
		
		while(index < MAX) {
			
			System.out.print("["+arr[index]+"]");
			
			index++;
		}
		
	}
}
