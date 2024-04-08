
/*
 Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, obtenga la cantidad de números pares que tiene y la imprima.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp1_Ej2 {

	public static int MAX = 10;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	
	public static void main(String [] args) {
		
		int [] arr = new int[MAX];
		int pares = 0;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			cargar_arreglo(arr);
			
			pares = calcular_pares(arr);
			
			if(pares > 0) {
				System.out.println("Hay "+pares+" pares en el arreglo.");
			}
			else {
				System.out.println("No hay ningun num par en el arreglo");
			}
			
			imprimir_arreglo(arr);
			
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	public static int calcular_pares(int [] arr) {
		
		int index = 0;
		int pares = 0;
		
		while(index < MAX) {
			
			if(arr[index] % 2 == 0) {
				pares++;
			}
			
			index++;
		}
		
		return pares;
	}
	
	public static void cargar_arreglo(int [] arr) {
		Random r = new Random();
		
		int index = 0;
		
		while(index < MAX) {
			
			arr[index] = (r.nextInt(MAXVALOR-MINVALOR+1)+MINVALOR);
			
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
