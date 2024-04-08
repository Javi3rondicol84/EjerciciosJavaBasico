import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, invierta el orden del contenido (por ejemplo: el que está en 0 se intercambia
con el que está en 9, el que está en 1 con el que está en 8…). Este intercambio no se debe
realizar de manera explícita, hay que hacer un método que incluya una iteración de
intercambio.
*/

public class Tp1_Ej1 {
	
	public static int MAX = 10;
	public static int MAXVALOR = 10;
	public static int MINVALOR = 1;
	
	public static void main (String[]args) {
			
			int arr[] = new int [MAX];
			

			try {
				
				cargararr(arr);
				
				imprimirarr(arr);
				
				invertir_arr(arr);
				
				imprimirarr(arr);
		
			}
			catch (Exception exc) {
				System.out.print(exc);
			}
			
	}
	
	public static void invertir_arr(int [] arr) {
		int pos = 0;
		int aux = 0;
		
		while(pos < (MAX-1)/2) {
			
			aux = arr[pos]; 
			arr[pos] = arr[MAX-1-pos]; 
			arr[MAX-1-pos] = aux; 
			
			pos++;
		}
		
		System.out.println("lel");
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
