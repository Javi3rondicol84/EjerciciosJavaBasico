import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 *Hacer un programa que dado el arreglo definido y precargado 
 *elimine del arreglo todas las ocurrencias de una secuencia patrón dada por otro arreglo de iguales
características (solo tiene esa secuencia). 
Al eliminar se pierden valores haciendo
corrimientos.

 */

public class Tp3_Ej15 {
	
	public static int MAX = 13;
	public static int MAXVALOR = 10;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	
	
	public static void main (String[]args) {
		
		int arr[] = {2,2,3,4,6,0,0,3,5,7,0,2,0};
		int arrpatron[] = {2,2,3,4,6,0,0,2,2,3,4,0,0};
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {
			imprimirarr(arr);
			
			comprobarpatron(arr, arrpatron);
			
			System.out.println();
			
			imprimirarr(arr);
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
					
	}
	
	public static void comprobarpatron(int [] arr, int [] arrpatron) {
		
		int inicio = 0;
		int fin = -1;
		int inicio2 = 0;
		boolean encontrar = false;
		
		while(inicio < MAX-1) {
			inicio = buscar_inicio(arr, fin+1);
			
			if(inicio < MAX-1) {
				fin = buscar_fin(arr, inicio);
				
				encontrar = eliminarpatron(arr, arrpatron, inicio, fin);
				
				if(encontrar) {
					eliminar(arr, inicio, fin);
				}
			}
			
			
		}
		
	}
	
	public static void eliminar(int [] arr, int inicio, int fin) {
		int inicio2 = inicio;
		
		while(inicio2 <= fin) {
			corrimiento_izq(arr, inicio);
			inicio2++;
		}
	}
	
	public static boolean eliminarpatron(int [] arr, int [] arrpatron, int inicio, int fin) {
		
		int pos = 0;
		int inicio2 = inicio;
		int aux = 0;
		boolean encontrar = false;
		
		while(inicio2 <= fin) {
			
			if(arr[inicio2] == arrpatron[pos]) {
				aux++;
			}
			
			inicio2++;
			pos++;
		}
		
		if(((fin+1) - inicio) == aux) {
			encontrar = true;
		}
		
		return encontrar;
	}
	
	
	public static void imprimirarr(int [] arr) {
		int pos = 0;
		
		while(pos < MAX) {
			
			System.out.print(arr[pos] + "|");
			
			pos++;
		}
	}
	
	public static int buscar_inicio(int [] arr, int pos) {
		
		while((pos < MAX-1)&&(arr[pos] == 0)) {
			pos++;
		}
		
		return pos;
	}
	
	public static int buscar_fin(int [] arr, int pos) {
		
		while((pos < MAX-1) && (arr[pos] != 0)) {
			pos++;
		}
		
		
		return (pos-1);
	}
	
	public static void corrimiento_izq(int [] arr, int pos) {
		
		
		while(pos < MAX-1) {
			
			arr[pos] = arr[pos+1];
			
			pos++;
		}
	}
	

}
