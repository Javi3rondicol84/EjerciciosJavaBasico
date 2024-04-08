
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Base {

	public static int MAX = 10;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	
	public static void main(String [] args) {
		
		int [] arr = new int[MAX];
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			cargar_arreglo(arr);
			imprimir_arreglo(arr);
			
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
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
