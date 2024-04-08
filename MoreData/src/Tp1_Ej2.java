import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, obtenga la cantidad de números pares que tiene y la imprima.
*/

public class Tp1_Ej2 {
	
	public static int MAX = 10;
	public static int MAXVALOR = 10;
	public static int MINVALOR = 1;
	
	public static void main (String[]args) {
			
			int arr[] = new int [MAX];
			int cant = 0;
			
			try {
				
				cargararr(arr);
				
				imprimirarr(arr);
				
				cant = obt_pares(arr);
				
				System.out.println("\nEl arreglo tiene "+cant+" pares.");
				
		
		
			}
			catch (Exception exc) {
				System.out.print(exc);
			}
			
	}
	
	public static int obt_pares(int [] arr) {
		int pos = 0;
		int aux = 0;
		int pares = 0;
		
		while(pos < MAX) {
			
			if(arr[pos] % 2 == 0) {
				System.out.print(arr[pos]+",");
				pares++;
			}
			
			pos++;
		}
		
		
		return pares;
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
