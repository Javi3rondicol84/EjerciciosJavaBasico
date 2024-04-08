import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*
 * Hacer un programa que dado el arreglo definido y precargado, y un número entero
ingresado por el usuario, elimine las secuencias de tamaño igual al número ingresado.
 */

public class Tp3_Ej13 {
	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	
	public static void main(String [] args) {
		
		int [] arr = new int[MAX];
		int num = 0;
		
		cargar_arreglo(arr);
		
		imprimir_arreglo(arr);
		
		try {
			BufferedReader entrada = new BufferedReader( new InputStreamReader(System.in));
			
			System.out.println("Introduce un num para eliminar una secuencia de ese tamaño.");
			num = Integer.valueOf(entrada.readLine());
			
			eliminar_secuencia(arr, num);
			
			System.out.println("Sec eliminada.");
			imprimir_arreglo(arr);
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	public static void eliminar_secuencia(int [] arr, int num) {
		
		int inicio = 0;
		int fin = -1;
		
		while(inicio < MAX-1) {
			inicio = buscar_inicio(arr, fin+1);
			
			if(inicio < MAX-1) {
				fin = buscar_fin(arr, inicio);
			}
			
			if(((fin+1)-inicio) == num) {
				eliminar(arr, inicio, fin);
			
				inicio = 0;
			}
			
	
		}
		
	}
	
	public static void eliminar(int [] arr, int inicio, int fin) {
		int init = inicio;
		int ft = fin;
		
		while(init <= ft) {
			
			corrimiento_izq(arr, inicio);
			
			init++;
		}
	}
	
	public static void corrimiento_izq(int [] arr, int inicio) {
		
		while(inicio < MAX-1) {
			
			arr[inicio] = arr[inicio+1];
			
			inicio++;
		}
	}
	
	public static int buscar_inicio(int [] arr, int inicio) {
		
		while((inicio < MAX-1)&&(arr[inicio] == 0)) {
			inicio++;
		}
		
		return inicio;
	}
	
	public static int buscar_fin(int [] arr, int fin) {
		
		while((fin < MAX-1)&&(arr[fin] != 0)) {
			fin++;
		}
		
		return fin-1;
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
