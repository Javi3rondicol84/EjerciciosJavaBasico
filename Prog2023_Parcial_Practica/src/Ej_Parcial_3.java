/*
 * /*
Tema 2: Se tiene un arreglo A de secuencias de enteros y un arreglo B de enteros ordenado ascendente. Cada secuencia de A tiene n�meros primos (solo divisible por 1 y por s� mismo) 
o m�ltiplos de 5. 
Adem�s se tiene el siguiente m�todo pre-existente: _un m�todo que permite obtener el �ndice inicial de la secuencia con menor cantidad de n�meros m�ltiplos de un valor dado
 para un arreglo de secuencias.
Se pide realizar el programa y los m�todos que permitan agregar en B (manteniendo su orden) los n�meros primos de la secuencia de A con menor cantidad de n�meros m�ltiplos de 5.
Observaciones: _los arreglos son de tama�o MAX y est�n precargados,
_las secuencias est�n separadas por uno o m�s ceros, empiezan y terminan con uno o m�s ceros,
_definir el encabezado del m�todo pre-existente (no hay que implementarlo),
_no realizar m�todos de carga e impresi�n de arreglos ni utilizar arreglos auxiliares.
 */
 
public class Ej_Parcial_3 {
	public static final int MAX = 20;
	public static void main(String [] args) {
		
		int indice = 0;
		int num = 0;
		int tam = 0;
		int inicioA = 0;
		int finA = 0;
		int [] arrA = {0,0,0,0,0,0,0,0,0,5,7,11,17,0,0,0,0,0,0,0};
		int [] arrB = {1,1,1,2,3,3,3,4,5,5,5,7,7,7,11,11,17,19,19,20};
		inicioA = obtener_inicio_sec_primos(arrA);
		finA = obtener_fin_sec_primos(arrA, inicioA);
		tam = (finA+1)-inicioA;
		
		System.out.println("arrA");
		imprimir_arreglo(arrA);
		System.out.println("arrB");
		imprimir_arreglo(arrB);
		
		while(indice < tam) {
			if((arrA[inicioA+indice] % 2 != 0) && (arrA[inicioA+indice] % 5 != 0)) {
				num = arrA[inicioA+indice];
				insertar_ordenado(arrB, num);
			}
			indice++;
		}
		
		System.out.println("Arreglo b con valores insertados de A");
		imprimir_arreglo(arrB);
	}
	
	public static int obtener_inicio_sec_primos(int [] arr) {
		
		return 9;
	}

	public static int obtener_fin_sec_primos(int [] arr, int pos) {
		
		while((pos < MAX) && (arr[pos] != 0)) {
			pos++;
		}
		
		return pos-1;
	}
	
	public static void insertar_ordenado(int [] arr, int num) {
		int pos = 0;
		pos = encontrar_pos(arr, num);
		corrimiento_derecha(arr, pos);
		arr[pos] = num;
	}
	
	public static int encontrar_pos(int [] arr, int num) {
		int indice = 0;
		while((indice < MAX) && (arr[indice] < num)) {
			indice++;
		}
		
		return indice;
	}
	
	public static void corrimiento_derecha(int [] arr, int pos) {
		int indice = MAX-1;
		
		while(indice > pos) {
			arr[indice] = arr[indice-1];
			indice--;
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



