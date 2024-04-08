/*
 * Hacer un programa que dado el arreglo definido y precargado permita encontrar la
posición de inicio de la secuencia cuya suma de valores sea mayor.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp3_Ej11 {
	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	
	public static void main(String [] args) {
		
		int [] arr = new int[MAX];
		
		cargar_arreglo(arr);
		
		imprimir_arreglo(arr);
		
		try {
			BufferedReader entrada = new BufferedReader( new InputStreamReader(System.in));
			
			encontrar_suma_mayor_secuencia(arr);
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
	public static void encontrar_suma_mayor_secuencia(int [] arr) {
		
		int maxinicio = 0;
		int maxfin = 0;
		int suma = 0;
		int sumamayor = 0;
		int inicio = 0;
		int fin = -1;
		
		while(inicio < MAX-1) {
			inicio = buscar_inicio(arr, fin+1);
			
			if(inicio < MAX-1) {
				fin = buscar_fin(arr, inicio);
				
				suma = sumar_secuencia(arr, inicio, fin);
				
				if(suma > sumamayor) {
					sumamayor = suma;
					maxinicio = inicio;
					maxfin = fin;
				}
				
				
			}
		}
		
		System.out.println("La mayor secuencia empieza en la pos "+maxinicio+" y termina en "+maxfin+", su suma es de "+sumamayor);
		
	}
	
	public static int sumar_secuencia(int [] arr, int inicio, int fin) {
		int suma = 0;
		
		while(inicio <= fin) {
			suma += arr[inicio];
			
			inicio++;
		}
		
		return suma;
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
		
		System.out.print("Arreglo: ");
		
		while(index < MAX) {
			
			System.out.print("["+arr[index]+"]");
			
			index++;
		}
		
	}
}
