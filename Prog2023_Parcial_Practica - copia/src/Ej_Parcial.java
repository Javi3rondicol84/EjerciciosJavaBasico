/*
 *   pasar secuencias par de arr en arreglo PAR
 */
public class Ej_Parcial {
	
	public static final int MAX = 20;
	
	public static void main(String [] args) {
		
		int inicio = 0;
		int fin = -1;
		int tam = 0;
		int pos = 0;
		int aux = 0;
		int [] arr = {0,1,2,3,0,6,2,2,6,4,4,0,0,3,3,2,3,0,0,0,0};
		int [] par = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		
		imprimir_arreglo(par);
		
		System.out.println("par rellenado: ");
		
		while(inicio < MAX-1) {
			inicio = buscar_pos_inicio(arr, fin+1);
			if(inicio < MAX-1) {
				fin = buscar_pos_fin(arr, inicio);
				tam = (fin+1)-inicio;
				
				if(tam % 2 == 0) {
					pos = extraer_sec(arr, par, inicio, fin, aux);
					aux = pos;
				}
				
				
			}
		}
		
		imprimir_arreglo(par);

		
	}
	
	public static int extraer_sec(int [] arr, int [] par, int inicio, int fin, int indice) {
		int tam = (fin+1)-inicio;
		int pos = 0;
		
		while(pos < tam) {
			par[indice] = arr[inicio+pos];
			indice++;
			pos++;
		}
		
		return indice+1;
	}	
	
	
	public static int buscar_pos_fin(int [] arr, int indice) {
		
		while((indice < MAX-1) && (arr[indice] != 0)) {
			indice++;
		}
		
		return indice-1;
	}
	
	public static int buscar_pos_inicio(int [] arr, int indice) {
		
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
