

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*Hacer un programa que dado un arreglo de enteros de tamaño 10 que se
encuentra precargado, 

solicite al usuario el ingreso de dos números
enteros (posiciones del arreglo) 

y ordene de forma creciente el arreglo
entre dos posiciones correspondientes a los números ingresados.
*/


public class Tp2_Ej9 {
	
	public static int MAX = 10;
	public static int MAXVALOR = 10;
	public static int MINVALOR = 1;
	
	public static void main (String[]args) {
			
			int arr[] = new int [MAX];
			int num = 0;
			int num2 = 0;

			try {
				
	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
				cargararr(arr);
				
				imprimirarr(arr);
				
				do {
					System.out.println("Introduce un num para empezar a ordenar (min 0 - max 8)");
					num = Integer.valueOf(entrada.readLine());
				}while(num < 0 || num > 8);
				
	
				do {
					
					System.out.println("Introduce un num mayor al primero (max 9)");
					num2 = Integer.valueOf(entrada.readLine());
					
				}while(num2 < num || num2 > 9);
				
				ordenararr(arr, num, num2);
					
				imprimirarr(arr);
		
			}
			catch (Exception exc) {
				System.out.print(exc);
			}
			
	}
	

	public static void ordenararr(int [] arr, int num, int num2) {

		int temp = 0;
		
		for(int i = num+1; i < num2+1; i++) {
			for(int j = num; j < num2; j++) {
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
