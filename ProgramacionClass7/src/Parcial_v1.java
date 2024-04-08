/*
 * /*
Tema 1: Se tiene un arreglo A de enteros ordenado ascendente, y un arreglo B de secuencias de enteros donde cada secuencia 
tiene m�ltiplos de 2 o m�ltiplos de 3 o n�meros primos 
(solo divisible por 1 y por s� mismo). 
Adem�s se tiene el siguiente m�todo pre-existente: _un m�todo que permite obtener el �ndice final de la secuencia con 
mayor cantidad de n�meros primos de un arreglo de secuencias.
Se pide realizar el programa y los m�todos que permitan eliminar de A los n�meros primos de la secuencia de B con mayor 
cantidad de n�meros primos.
Observaciones: _los arreglos son de tama�o MAX y est�n precargados,
_las secuencias est�n separadas por uno o m�s ceros, empiezan y terminan con uno o m�s ceros,
_definir el encabezado del m�todo pre-existente (no hay que implementarlo),
_no realizar m�todos de carga e impresi�n de arreglos ni utilizar arreglos auxiliares.
 */
 


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Parcial_v1 {
	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	public static int ct2 = 2;
	public static int ct3 = 3;
	
	public static void main(String [] args) {
		
		int [] arrA = new int [MAX];
		int [] arrB = {0,2,4,6,0,0,3,9,6,0,0,5,3,13,17,2,0,0,0,0};
 		int indiceB = 0;
		int fin = 0;
		int inicio = 0;
 		
		cargar_arreglo(arrA);
		ordenar_arreglo(arrA);
		imprimir_arreglo(arrA);

		
		
	
		
	}
	
	
	
	

	public static void ordenar_arreglo(int [] arr) {
		int inicio = 0;
		int fin = -1;
		
		while(inicio < MAX-1) {
			inicio = buscar_inicio(arr, fin+1);
			
			if(inicio < MAX-1) {
				fin = buscar_fin(arr, inicio);
				
				ordenar(arr, inicio, fin);
			}
		}
		
	}
	
	public static void ordenar(int [] arr, int inicio, int fin) {
		
		
		int posmenor = 0;
		int tmp = 0;
		
		for(int i = inicio; i <= fin; i++) {
			
			posmenor = i;
			
			for(int j = i + 1; j <= fin; j++) {
				if(arr[j] < arr[posmenor]) {
					posmenor = j;
				}
			}
			
			if(posmenor != i) {
				tmp = arr[i];
				arr[i] = arr[posmenor];
				arr[posmenor] = tmp;
			}
			
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
		
		System.out.print("Arreglo: ");
		
		while(index < MAX) {
			
			System.out.print("["+arr[index]+"]");
			
			index++;
		}
		
	}
}
