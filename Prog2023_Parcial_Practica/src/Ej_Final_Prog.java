/*
 * /*
 * se tiene arreglo ARREGLO ordenado ascendente segun la suma de los elementos de cada secuencia
 * 
 * arr {0,9,0,0,5,2,3,0,9,9,3,3,0,0,5,5,5,5,0}
 * 
 * se tiene arreglo NUEVO con secuencias dadas
 * 
 * INSERTAR EN ARREGLO una secuencia dada de NUEVO, manteniendo el orden
 * 
 * ver la suma de los elems de la secuencia dada de NUEVO, segun su cantidad compararla con la suma de elems de cada secuencia de arr
 * y colocarla en el lugar correcto, haciendo corrimiento a derecho segun la cantidad de elems de la secuencia y luego insertando los 
 * valores 
 * 
 */
 

public class Ej_Final_Prog {
	public static final int MAX = 20;
	
	public static void main(String [] args) {
		int [] arr = {0,9,0,8,3,0,0,2,2,3,6,0,0,9,9,9,0,0,0,0};
		int [] nuevo = {0,9,9,0,5,0,0,3,3,3,3,3,0,0,0,0,0,0,0,0};
		int inicio = 0;
		int fin = -1;
		int ininuevo = 0;
		int finnuevo = -1;
		int sumanuevo = 0;
		int sumaarr = 0;
		boolean frenar = false;
		
		System.out.println("arr");
		imprimir_arreglo(arr);
		System.out.println("nuevo");
		imprimir_arreglo(nuevo);
		
		ininuevo = buscar_pos_inicio(nuevo, finnuevo+1);
		finnuevo = buscar_pos_fin(nuevo, ininuevo);
		sumanuevo = chequear_suma(nuevo, ininuevo, finnuevo);
		
		while((inicio < MAX) && (frenar == false)) {
			inicio = buscar_pos_inicio(arr, fin+1);
			if(inicio < MAX) {
				fin = buscar_pos_fin(arr, inicio);
				sumaarr = chequear_suma(arr, inicio, fin);
					if(sumanuevo <= sumaarr) {
						hacer_espacio_y_insertar(arr, nuevo, inicio, fin, ininuevo, finnuevo);
						frenar = true;
					}	
			}
		}
		
		System.out.println("arr modificado con sec de nuevo");
		imprimir_arreglo(arr);
	}
	
	public static int chequear_suma(int [] arr, int inicio, int fin) {
		int suma = 0;
		while(inicio <= fin) {
			suma += arr[inicio];
			inicio++;
		}
		return suma;
	}
	
	public static void hacer_espacio_y_insertar(int [] arr, int [] nuevo, int iniarr, int finarr, int ininuevo, int finnuevo) {
		int tamnuevo = ((finnuevo+1)-ininuevo);
		tamnuevo++;
		int indice = 0;
		
		while(indice < tamnuevo) {
			corrimiento_derecha(arr, iniarr);
			indice++;
		}
		insertar(arr, nuevo, iniarr, ininuevo, finnuevo);
		
		
		
	}
	
	public static void corrimiento_derecha(int [] arr, int iniarr) {
		int pos = MAX-1;
		
		while(pos > iniarr) {
			arr[pos] = arr[pos-1];
			pos--;
		}
		
		arr[pos] = 0;
	}
	
	public static void insertar(int [] arr, int [] nuevo, int iniarr, int ininuevo, int finnuevo) {
		int indice = 0;
		int tamnuevo = (finnuevo+1)-ininuevo;
		
		while(indice < tamnuevo) {
			arr[iniarr+indice] = nuevo[ininuevo+indice];
			indice++;
		}
		
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
