/*
 * . Hacer un programa que dado el arreglo definido y precargado, y un número entero
ingresado por el usuario, copie de forma continua las secuencias de tamaño igual al
número ingresado en otro arreglo de iguales características e inicializado con 0. La
copia en este último arreglo deben comenzar desde el principio del mismo.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp3_Ej14 {
	
	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	
	public static void main(String [] args) {
		
		int [] arrA = new int[MAX];
		int [] arrB = new int[MAX];
		int num = 0;
		
		cargar_arreglo(arrA);
		cargar_arregloB(arrB);
		
		imprimir_arreglo(arrA);
		System.out.println();
		imprimir_arreglo(arrB);
		
		try {
			BufferedReader entrada = new BufferedReader( new InputStreamReader(System.in));
			System.out.println("Introduce el tamaño de las secuencias a copiar del arreglo A al B.");
			num = Integer.valueOf(entrada.readLine());
				
			copiar_secuencias(arrA, arrB, num);
			
			imprimir_arreglo(arrA);
			System.out.println();
			imprimir_arreglo(arrB);
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	public static void copiar_secuencias(int [] arrA, int [] arrB, int num) {
		
		int inicio = 0;
		int fin = -1;
		int init = 0;
		
			//buscarpos en arreglo a
		//si coincide con num, pasar pos a nuevo metodo junto a ambos arreglos.
		//habilitar que se haga todas las veces necesarias
		//en dicho metodo, copiar desde pos0 del arreglo b, los datos en arreglo a desde la pos de la sec que coincidio con num.
		//asegurarse que tras copiar hasta 4 en arreglo b por ej, luego vuelva a 5 y siga, y asi por cada secuencia.
		
		while(inicio < MAX-1) {
			inicio = buscar_inicio(arrA, fin+1);
			
			if(inicio < MAX-1) {
				fin = buscar_fin(arrA, inicio);
			}
			
			if(((fin+1)-inicio)==num) {
				copiar_Secs(arrA, arrB, inicio, fin, init);
				inicio = 0;
			}
		}
		
	}
	
	public static void copiar_Secs(int [] arrA, int [] arrB, int inicio, int fin, int init) {
		
		while(inicio <= fin) {
			
			arrB[init] = arrA[inicio];
			
			init++;
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
	
	
	
	public static void cargar_arregloB(int [] arr) {
		
		int index = 1;
		arr[0] = 0;
		arr[MAX-1] = 0;
	
		while(index < MAX-1) {
			
			arr[index] = 0;
			
			index++;
		}
		
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
