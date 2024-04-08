import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*Hacer un programa que dado un arreglo ordenado creciente de enteros
de tamaño 10 que se encuentra precargado,
 solicite al usuario un numero
entero 
y elimine la primer ocurrencia de numero (un número igual) en el
arreglo (
si existe).

*/

public class Tp2_Ej8 {
	
	public static int MAX = 10;
	public static int MAXVALOR = 10;
	public static int MINVALOR = 1;
	
	public static void main (String[]args) {
			
			int arr[] = new int [MAX];
			int num = 0;

			try {
				
	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
				cargararr(arr);
				
				ordenararr(arr);
				
				imprimirarr(arr);
				
				System.out.println("Introduce un num para eliminar la primer ocurrencia");
					num = Integer.valueOf(entrada.readLine());
				
				eliminar_ocurr(arr, num);
					
				imprimirarr(arr);
		
			}
			catch (Exception exc) {
				System.out.print(exc);
			}
			
	}
	
	public static void eliminar_ocurr(int [] arr, int num) {
		
		int pos = 0;
		
		while(pos < MAX && arr[pos] != num) {
			pos++;
		}
		
		corr_izq(arr, pos);
		
	}
	
	public static void corr_izq(int [] arr, int pos) {
		
		while(pos < MAX-1) {
		
			arr[pos] = arr[pos+1];
			
			pos++;
		}
		
		
	}
	

	public static void ordenararr(int [] arr) {

		int temp = 0;
		
		for(int i = 1; i < MAX; i++) {
			for(int j = 0; j < MAX-1; j++) {
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
	}
	
	
	
	public static void cargararr(int [] arr) {
		Random r = new Random();
		
		int pos = 0;
		
		while(pos < MAX) {
			arr[pos] = (r.nextInt(MAXVALOR-MINVALOR+1)+MINVALOR);
			pos++;
		}
	}
	
	public static void imprimirarr(int [] arr) {
		int pos = 0;
		
		System.out.print("arreglo: ");
		
		while(pos < MAX) {
			
			System.out.print("["+arr[pos]+"]");
			
			pos++;
		}
		
		System.out.println();
  }
	
	
	
	

}
