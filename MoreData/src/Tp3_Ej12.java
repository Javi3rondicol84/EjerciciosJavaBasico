import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Hacer un programa que dado el arreglo definido y precargado permita encontrar la
posición de inicio de la anteúltima secuencia (considerar comenzar a buscarla a
partir de la ultima posición del arreglo).

 */

public class Tp3_Ej12 {
	
	public static int CANT = 2;
	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad_letra = 0.4;
	public static double probabilidad_numero = 0.4;
	
	public static void main (String[]args) {
			
			int arr[] = new int [MAX];
			char arrchar[] = new char [MAX];
			
			int num = 0;
			int inicio = MAX-1;
			int fin = MAX-1;
			int aux = 0;

			try {
				
	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
				cargar_arr_sec(arr);
				
				cargar_arr_sec_char(arrchar);
				
				imprimirarr(arr);
				
				while(inicio > 0 && aux < CANT) {
					
					inicio = buscarpos_inicio(arr, fin);
					
					if(inicio > 0) {
						fin = buscarpos_fin(arr, inicio);
						aux++;
					}
				}
				
	
				
				
				
			System.out.println("La anteult secuencia empieza en: "+(fin+1)+" y termina en: "+inicio);


		
			}
			catch (Exception exc) {
				System.out.print(exc);
			}
			
	}
	
	public static int buscarpos_inicio(int [] arr, int pos) {
		
		while((pos >= 0) && (arr[pos] == 0)) {
			pos--;
		}
		
		return pos;
	}
	
	public static int buscarpos_fin(int [] arr, int pos) {
		
		while((pos >= 0) && (arr[pos] != 0)) {
			pos--;
		}
		
		return (pos);
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
			}
			else {
				arr[pos] = 0;
			}
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
