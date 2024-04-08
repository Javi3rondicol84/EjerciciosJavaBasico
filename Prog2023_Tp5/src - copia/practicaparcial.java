/*
 * /*Dado un arreglo ARR de tamaño N de secuencias de enteros separadas por uno o más ceros, hacer un programa que
 extraiga todas las secuencias con cantidad par de elementos y las copie en un arreglo PAR de enteros de tamaño N
 (quedando separadas por un 0). */
 

public class practicaparcial {
	public static final int MAX = 20;
	
	public static void main(String [] args) {
		int aux = 0;
		int indice = 0;
		int tam = 0;
		int inicio = 0;
		int fin = -1;
		int [] arrA = {0,2,2,0,0,1,5,0,0,4,4,1,4,0,0,2,3,0,0,0};
		int [] arrB = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		
		imprimir_arreglo(arrB);
		
		while(inicio < MAX-1) {
			inicio = buscar_pos_inicio(arrA, fin+1);
			if(inicio < MAX-1) {
				fin = buscar_pos_fin(arrA, inicio);
				tam = (fin+1)-inicio;
				if(tam % 2 == 0) {
					aux = copiar_sec(arrA, arrB, inicio, fin, indice);
					indice = aux+1;
				}
			}
		}
		
		System.out.println("");
		imprimir_arreglo(arrB);
		
	}
	
	public static int copiar_sec(int [] arrA, int [] arrB, int inicio, int fin, int indice) {
		int tam = (fin+1)-inicio;
		int init = 0;
		
		while(init < tam) {
			arrB[indice] = arrA[inicio+init];
			indice++;
			init++;
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
	
	public static int buscar_pos_inicio(int [] arr, int pos) {
		int indice = pos;
		
		while((indice < MAX-1) && (arr[indice] == 0)) {
			indice++;
		}
		
		return indice;
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
