
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Parcial_2023_16_6 {
	public static final int MAX = 20;
	public static final int SEPARADOR = 255;
	
	public static void main(String [] args) {
		int[] arr = { 255, 67, 67, 67, 67, 67, 67, 67, 67, 255, 13, 255, 33, 33, 33, 33, 255, 34, 22, 255};
		int num = 0;
		final int min = 0;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		imprimir_arreglo(arr);
		
		System.out.println("transformado: ");
		
		try {
			
			do {
				
				System.out.println("Introduce un num mayor a cero");
				num = Integer.valueOf(entrada.readLine());
				
			}while(num <= min);
			
			eliminar_ocurrencias_extras(arr, num);
			
			imprimir_arreglo(arr);
			
		}
		catch(Exception exc) {
			
		}
		
		
	}
	
	
	
	public static void eliminar_ocurrencias_extras(int [] arr, int num) {
		
		int inicio = 0;
		int fin = -1;
		int tamanio = 0;
		final int negativo = -1;
		
		while(inicio < MAX-1) {
			inicio = buscar_pos_inicio(arr, fin+1);
			if(inicio < MAX-1) {
				fin = buscar_pos_fin(arr, inicio);
				
				tamanio = (fin+1)-inicio;
				
				if(es_valor_repetido(arr, tamanio, inicio) == true) {
					if(tamanio > num) {
						
						eliminar_ocurr(arr, tamanio, inicio);
						corrimiento_derecha(arr, inicio);
						arr[inicio] = tamanio * negativo;
						fin = inicio;
						
					}
				}
				
				
			}
			
		}
		
	}
	
	public static void eliminar_ocurr(int [] arr, int tamanio, int inicio) {
		int indice = 0;
		
		while(indice < tamanio-1) {
			corrimiento_izquierda(arr, inicio);
			indice++;
		}
		
	}
	
	public static void corrimiento_izquierda(int [] arr, int pos) {
		while(pos < MAX-1) {
			arr[pos] = arr[pos+1];
			pos++;
		}
	}
	
	public static void corrimiento_derecha(int [] arr, int inicio) {
		int pos = MAX-1;
		
		while(pos > inicio) {
			arr[pos] = arr[pos-1];
			pos--;
		}
	}
	
	
	public static boolean es_valor_repetido(int [] arr, int tamanio, int inicio) {
		boolean es_repetido = false;
		int indice = 0;
		int init = inicio;
		
		while((indice < tamanio) && (arr[inicio] == arr[init+indice])) {
			indice++;
		}
		
		if(indice == tamanio) {
			es_repetido = true;
		}
		
		return es_repetido;
	}
	
	public static int buscar_pos_inicio(int [] arr, int pos) {
		
		while((pos < MAX-1) && (arr[pos] == SEPARADOR)) {
			pos++;
		}
		
		return pos;
	}
	
	public static int buscar_pos_fin(int [] arr, int pos) {
		
		while((pos < MAX-1) && (arr[pos] != SEPARADOR)) {
			pos++;
		}
		
		return pos-1;
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
