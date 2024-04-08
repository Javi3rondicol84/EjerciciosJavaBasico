/*
 * 16. Hacer un programa que devuelva la posición de inicio y fin de la
secuencia de números distintos de ceros cuya suma del contenido
sea mayor.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp05_Ej16 {

	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	
	public static void main (String [] args) {
		
		int [] arr = new int[MAX];
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			cargar_arreglo(arr);
			
			imprimir_arreglo(arr);
			
			obtener_mayor_suma(arr);
		
		}
		catch(Exception exc) {
			
		}
		
	}
	
	public static void obtener_mayor_suma(int [] arr) {
		int indice = 0;
		int inicio = 0;
		int fin = -1;
		int suma = 0;
		int mayorsuma = 0;
		int mayorinicio = 0;
		int mayorfin = 0;
		
		while(indice < MAX-1) {
				
				
					inicio = buscar_pos_inicio(arr, fin+1);
					
					if(inicio < MAX-1) {
						fin = buscar_pos_fin(arr, inicio);
						
						suma = sumar_secuencia(arr, inicio, fin);
						System.out.println("Secuencia empieza en: "+inicio+", termina en: "+fin);
						
						System.out.println("suma de secuencia: "+suma);
						
						if(suma > mayorsuma) {
							mayorsuma = suma;
							mayorinicio = inicio;
							mayorfin = fin;
						}
						
						
					}
				

			indice++;
			
		}
		
		System.out.println("La secuencia cuya es mayor que las demas empieza en la pos "+mayorinicio+" y termina en la pos "+mayorfin+", la suma es: "+mayorsuma);
	}
	
	public static int sumar_secuencia(int [] arr, int inicio, int fin) {
		
		int suma = 0;
		
		while(inicio <= fin) {
			
			suma += arr[fin];
			
			inicio++;
		}
		
		
		return suma;
	}
	
	public static int buscar_pos_inicio(int [] arr, int pos) {
		
		int indice = pos;
		
		while((indice < MAX-1) && (arr[indice] == 0)) {
			indice++;
		}
		
		return indice;
	}
	
	public static int buscar_pos_fin(int [] arr, int pos) {
		
		int indice = pos;
		
		while((indice < MAX-1) && (arr[indice] != 0)) {
			indice++;
		}
		
		return indice-1;
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