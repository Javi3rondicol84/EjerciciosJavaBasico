/*
 * 9. Hacer un programa que dado un arreglo de enteros de tama�o 10
que se encuentra cargado, solicite al usuario un n�mero entero y
lo agregue al principio del arreglo (posici�n 0). Para ello tendr�
que realizar un corrimiento a derecha (se pierde el �ltimo valor del
arreglo) y colocar el n�mero en el arreglo en la posici�n indicada.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp05_Ej9 {

	public static int MAX = 10;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	
	public static void main (String [] args) {
		
		int [] arr = new int[MAX];
		int num;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			cargar_arreglo(arr);
			
			imprimir_arreglo(arr);
		
			System.out.println("Ingrese un num para ponerlo en el inicio del arreglo");
			num = Integer.valueOf(entrada.readLine());
			
			corrimiento_der(arr);
			
			arr[0] = num;
			
			imprimir_arreglo(arr);
			
		}
		catch(Exception exc) {
			
		}
		
	}
	
	public static void corrimiento_der(int [] arr) {
		int indice = MAX-1;
		
		while(indice > 0) {
			
			arr[indice] = arr[indice-1];
			
			indice--;
		}
		
	}
	
	
	public static void cargar_arreglo(int [] arr) {
		
		Random r = new Random();
		int indice;
		indice = 0;
		
		while(indice < MAX) {
			
			arr[indice] = (r.nextInt(MAXVALOR-MINVALOR+1)+MINVALOR);
			
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