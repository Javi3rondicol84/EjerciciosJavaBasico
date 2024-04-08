import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*
 * . Se tiene un arreglo de enteros de tamaño 20 de secuencias de números
entre 1 y 9, separadas por 0. El arreglo esta precargado, y además
empieza y termina con uno o más separadores 0. 

Hacer un programa que
permita obtener a través de métodos la posición de inicio y la posición de
fin de la secuencia ubicada a partir de una posición entera ingresada por
el usuario. 

Finalmente, si existen imprima por pantalla ambas posiciones
obtenidas. 
 */

public class Tp3_Ej10 {
	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	
	public static void main(String [] args) {
		
		int [] arr = new int[MAX];
		int inicio = 0;
		int fin = 0;
		int pos = 0;
		
		cargar_arreglo(arr);
		
		imprimir_arreglo(arr);
		
		try {
			BufferedReader entrada = new BufferedReader( new InputStreamReader(System.in));
			
			System.out.println("Introduce una pos para obtener pos inicio y fin de la secuencia");
			pos = Integer.valueOf(entrada.readLine());

			inicio = pos_inicio(arr, pos);
			if(inicio < MAX) {
				fin = pos_fin(arr, inicio);
			}
			
			System.out.println("La secuencia empieza en la pos "+inicio+" y termina en la pos "+fin);
			
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	public static int pos_inicio(int [] arr, int pos) {
		
		while((pos < MAX) && (arr[pos] == 0)) {
			pos++;
		}
		
		return pos;
	}
	
	public static int pos_fin(int [] arr, int inicio) {
		
		while((inicio < MAX) && (arr[inicio] != 0)) {
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
