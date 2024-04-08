/*
 * /*
Tema 1: Se tiene un arreglo A de enteros ordenado ascendente, y un arreglo B de secuencias de enteros donde cada secuencia tiene múltiplos de 2 o múltiplos de 3 o números primos 
(solo divisible por 1 y por sí mismo). 
Además se tiene el siguiente método pre-existente: _un método que permite obtener el índice final de la secuencia con mayor cantidad de números primos de un arreglo de secuencias.
Se pide realizar el programa y los métodos que permitan eliminar de A los números primos de la secuencia de B con mayor cantidad de números primos.
Observaciones: _los arreglos son de tamaño MAX y están precargados,
_las secuencias están separadas por uno o más ceros, empiezan y terminan con uno o más ceros,
_definir el encabezado del método pre-existente (no hay que implementarlo),
_no realizar métodos de carga e impresión de arreglos ni utilizar arreglos auxiliares.
 */

public class Ej_Parcial_2 {
	
	public static final int MAX = 20;
	
	public static void main(String [] args) {
		int indiceB = 0;
		int indice_final_B = 0;
		int indice = 0;
		int num = 0;
		int tam = 0;
		int [] arrA = {0,2,0,7,11,0,2,0,0,3,17,0,1,1,5,7,9,0,0,0,0,0};
		int [] arrB = {0,2,0,5,7,0,11,0,0,3,17,0,5,9,7,11,17,0,2,0};
		indice_final_B = obtener_indice_final(arrB);
		indiceB = obtener_inicio_b(arrB, indice_final_B);
		tam = (indice_final_B+1)-indiceB;
		
		imprimir_arreglo(arrA);
		
		while(indice < tam) {
			if((arrB[indiceB+indice] % 2 != 0) && ((arrB[indiceB+indice] % 3 != 0))) {
				num = arrB[indiceB+indice];
				eliminar_de_arrA(arrA, num);
			}
			indice++;
		}
		
		System.out.println("arreglo A con primos eliminados");
		imprimir_arreglo(arrA);
		
	}
	
	public static int obtener_indice_final(int [] arrB) {
		
		
		return 16;
	}
	
	public static int obtener_inicio_b(int [] arrB, int indice) {
		
		while((indice < MAX) && (arrB[indice] != 0)) {
			indice--;
		}
		
		return indice+1;
	}
	
	public static void eliminar_de_arrA(int [] arr, int num) {
		int indice = 0;
		while(indice < MAX-1) {
			
			if(arr[indice] == num) {
				corrimiento_izq(arr, indice);
			}
			else {
				indice++;
			}
		}
	}
	
	public static void corrimiento_izq(int [] arr, int indice) {
		while(indice < MAX-1) {
			arr[indice] = arr[indice+1];
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
