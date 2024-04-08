import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class PracticaSecuencias {
	
	public static int MAX = 10;
	public static int MAXVALOR = 10;
	public static int MINVALOR = 1;
	public static double probabilidad_letra = 0.4;
	public static double probabilidad_numero = 0.4;
	
	public static void main (String[]args) {
			
			int arr[] = new int [MAX];
			char arrchar[] = new char [MAX];
			
			int num = 0;

			try {
				
	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
				cargar_arr_sec(arr);
				
				cargar_arr_sec_char(arrchar);
				
				imprimirarr(arr);
				
				System.out.println();
				
				imprimirarr_char(arrchar);
				
	//			System.out.println("Introduce algo");
		//			num = Integer.valueOf(entrada.readLine());

		
			}
			catch (Exception exc) {
				System.out.print(exc);
			}
			
	}
	

	
	public static void cargar_arr_sec_char(char [] arr) {
		Random r = new Random();
		arr[0] = ' ';
		arr[MAX-1] = ' ';
		
		int pos = 1;
		
		while(pos < MAX-1) {
			
			if(r.nextDouble() > probabilidad_letra) {
				arr[pos] = (char)(r.nextInt(26) + 'a');
			}
			else {
				arr[pos] = ' ';
			}
			
			
			
			pos++;
		}
		
		
		
		
	}
	
	
	public static void cargar_arr_sec(int [] arr) {
		Random r = new Random();
		
		arr[0] = 0;
		arr[MAX-1] = 0;
		
		int pos = 1;
		
		while(pos < MAX-1) {
			
			if(r.nextDouble() > probabilidad_numero) {
				arr[pos] = (r.nextInt(MAXVALOR-MINVALOR+1)+MINVALOR);
				pos++;
			}
			else {
				arr[pos] = 0;
			}

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
	
	public static void imprimirarr_char(char [] arr) {
		int pos = 0;
		
		System.out.print("arreglo: ");
		
		while(pos < MAX) {
			
			System.out.print("["+arr[pos]+"]");
			
			pos++;
		}
		
		System.out.println();
  }
	
	
	
	

}
