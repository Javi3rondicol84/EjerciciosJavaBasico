import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;


/*
 * Hacer un programa que dado el arreglo definido y precargado permita encontrar la
posición de inicio de la anteúltima secuencia (considerar comenzar a buscarla a
partir de la ultima posición del arreglo).
 */


public class Tp3_Ej12 {
	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	public static int STOP = 1;
	
	public static void main(String [] args) {
		
		int [] arr = new int[MAX];
		
		cargar_arreglo(arr);
		
		imprimir_arreglo(arr);
		
		try {
			BufferedReader entrada = new BufferedReader( new InputStreamReader(System.in));
			
			encontrar_anteult_sec(arr);
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	public static void encontrar_anteult_sec(int [] arr) {
		int inicio = MAX-1;
		int fin = MAX-1;
		int aux = 0; 
		
		while((inicio > 0) && (aux <= STOP)) {
		
			inicio = buscar_inicio(arr, fin);
			
			if(inicio > 0) {
				fin = buscar_fin(arr, inicio);
			}
			
			aux++;
		}
		
		fin++;
		System.out.println("La anteult secuencia empieza en "+fin+" y termina en "+inicio);
	}
	
	public static int buscar_inicio(int [] arr, int inicio) {
		
		while((inicio > 0)&&(arr[inicio] == 0)) {
			inicio--;
		}
		
		return inicio;
	}
	
	public static int buscar_fin(int [] arr, int fin) {
		
		while((fin > 0)&&(arr[fin] != 0)) {
			fin--;
		}
		
		return fin;
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
