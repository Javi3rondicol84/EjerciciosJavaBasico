import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp3_Ej15_2 {
	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	
	public static void main(String [] args) {
		
		//int [] arr = {0,5,3,5,0,1,2,3,4,0,0,2,0,1,2,3,4,0,1,2,3,4,0,0,0};
		//int [] patron = {1,2,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		
		int [] arr = { 0, 4, 3, 0, 0, 3,4,5,2,0,0,3,0,3,4,5,2,0,0,0,3,4,5,2,0,0}; // { 0
		int [] patron = { 0, 3, 4, 5, 2, 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};  
		
		imprimir_arreglo(arr);
		
		eliminar_patron(arr, patron);
	
		imprimir_arreglo(arr);
	}
	
	public static void eliminar_patron(int [] arr, int [] patron) {
			int inicio = 0;
			int fin = -1;
			int init = 0;
			
			while(inicio < MAX-1) {
				inicio = buscar_inicio(arr, fin+1);
		
				if(inicio < MAX-1) {
					fin = buscar_fin(arr, inicio);
				}
				
				if(comprobar(arr, patron, inicio, fin) == true) {
				
					init = inicio;
			
					while(init <= fin) {
						corrimiento_izq(arr, inicio);
						init++;
					}
					fin = inicio; 
				}
				
			}
	}
	
	public static void corrimiento_izq(int [] arr, int inicio) {
		int pos = inicio;
		
		while(pos < MAX-1) {
			arr[pos] = arr[pos+1];
			pos++;
		}
	}
	
	public static boolean comprobar(int [] arr, int [] patron, int inicio, int fin) {
		int aux = 0;
		boolean check = false;
		int i = 0;
		aux = ((fin+1)-inicio);
		
		
		while(((inicio + i) <= fin) &&(arr[inicio+i] == patron[i])) {
			i++;
		}
		
		
		if(i == aux) {
			check = true;
		}
		else {
			check = false;
		}
				
		return check;		
	}
	
	
	
	public static int buscar_inicio(int [] arr, int inicio) {

		while((inicio < MAX-1) && (arr[inicio]) == 0) {
			
			inicio++;
		}
		
		return inicio;
	}
	
	public static int buscar_fin(int [] arr, int inicio) {

		while((inicio < MAX-1) && (arr[inicio]) != 0) {
			
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
		System.out.println();
		int index = 0;
		
		System.out.print("Arreglo: ");
		
		while(index < MAX) {
			
			System.out.print("["+arr[index]+"]");
			
			index++;
		}
		
	}
}
