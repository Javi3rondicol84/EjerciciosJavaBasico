/*Hacer un programa que dado un arreglo de enteros de tamano 8 que se encuentra precargado, solicite al usuario una posicion y
realice un corrimiento a derecha o hacia la mayor posicion del arreglo. Ademas imprima el arreglo antes y despues del
corrimiento
*/

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ej3 {
	
	public static int MAX = 10;
	public static int MAXVALOR = 10;
	public static int MINVALOR = 1;
	
	public static void main (String[]args) {
		
		int arr[] = new int [MAX];	
		int num = 0;
		
		
		try {
			
			cargararr(arr);
			
			imprimirarr(arr);
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			
			
			do {
				System.out.println("\nIntroduce una posicion en el arreglo para realizar corrimiento a derecha(MAXIMO 9).");
				num = Integer.valueOf(entrada.readLine());
			}while(num >= 10);
			
			
			corr_derecha(arr, num);
			
			imprimirarr(arr);
	
		}
		catch (Exception exc) {
			System.out.print(exc);
		}

	}
	
	
	public static void corr_derecha(int [] arr, int pos) {
		
		while(pos > 0) {
			
			arr[pos] = arr[pos-1]; 
			
			pos--;
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
  }
	
}