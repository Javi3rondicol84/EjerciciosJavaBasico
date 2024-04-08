
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Ej_Buscar_Sec_Pos {

	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	
	public static void main (String [] args) {
		int inicio = 0;
		int pos = 0;
		int fin = -1;
		int [] arr = {0,4,4,4,4,0,0,9,4,0,4,2,4,8,0,0,0,0,5,0};
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			imprimir_arreglo(arr);
			
			do {
				System.out.println("introduzca una pos a partir de la cual hallar una sec");
				pos = Integer.valueOf(entrada.readLine());
				
			}while((pos < 0) || (pos > MAX-1));
			
			if(pos == MAX-1) {
				System.out.println("no hay secuencias a partir de esta pos");
			}
			else {
				
				inicio = buscar_pos_inicio(arr, pos);
				
				if(inicio < MAX) {
					fin = buscar_pos_fin(arr, inicio);
					
					if(inicio < pos) {
						inicio = buscar_pos_inicio(arr, fin+1);
						fin = buscar_pos_fin(arr, inicio);
					}
				}
				
				System.out.println("La secuencia a partir de la pos "+pos+", empieza en "+inicio+" y termina en "+fin);
				
				
			}
		
		}
		catch(Exception exc) {
			
		}
		
	}
	
	
	public static int buscar_pos_fin(int [] arr, int pos) {
		int indice = pos;
		
		while((indice < MAX-1) && (arr[indice] != 0)) {
			indice++;
		}
		
		return indice-1;
	}
	
	public static int buscar_pos_inicio(int [] arr, int indice) {
		int aux = 0;
		
		while((indice < MAX) && (arr[indice] == 0)) {
			indice++;
		}
		
		while((indice < MAX && (arr[indice] != 0))) {
			indice--;
			aux = 1;
		}
		
		return indice+aux;
	}
	
	
	
	public static void cargar_arreglo(int [] arr) {
		
		arr[0] = 0;
		arr[MAX-1] = 0;
		
		Random r = new Random();
		int indice;
		indice = 1;
		
		while(indice < MAX-1) {
			
			if(r.nextDouble() > probabilidad) {
				arr[indice] = (r.nextInt(MAXVALOR-MINVALOR+1)+MINVALOR);
			}
			
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