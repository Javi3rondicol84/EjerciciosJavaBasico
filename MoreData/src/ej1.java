
//calcular prom de arreglo de 10.

import java.util.Random;

public class ej1 {
	
	public static int MAX = 10;
	public static int MAXVALOR = 10;
	public static int MINVALOR = 1;
	
	public static void main (String[] args) {
		
		float prom = 0;
		int arr[] = new int [MAX];
		
		cargararr(arr);
		
		prom = calcularprom(arr);
		
		imprimirarr(arr);
		
		System.out.println("\nel prom es: "+prom);
	}
	
	public static void cargararr(int [] arr) {
		Random r = new Random();
		
		int pos = 0;
		
		while(pos < MAX) {
			arr[pos] = (r.nextInt(MAXVALOR-MINVALOR+1)+MINVALOR);
			pos++;
		}
	}
	
	public static float calcularprom(int [] arr) {
		float prom = 0;
		int pos = 0;
		
		while(pos < MAX) {
			prom += arr[pos];
			pos++;
		}
		
		prom /= MAX;
		
		
		return prom;
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
