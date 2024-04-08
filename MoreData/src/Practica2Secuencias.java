import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*Hacer un programa que dado el arreglo definido y precargado, imprima lo que suma el contenido de cada secuencia.
*/

public class Practica2Secuencias {
	
	public static int MAX = 10;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad_letra = 0.4;
	public static double probabilidad_numero = 0.4;
	
	public static void main (String[]args) {
			
			int arr[] = new int [MAX];
			char arrchar[] = new char [MAX];
			
			int inicio, fin, suma;

			try {
				
	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
				cargar_arr_sec(arr);
				
				cargar_arr_sec_char(arrchar);
				
				imprimirarr(arr);
				
				suma = sumarsecuencias(arr);
				
				System.out.println("la suma de las secuencias es: "+suma);
				
				imprimirarr_char(arrchar);
				
				
		
			}
			catch (Exception exc) {
				System.out.print(exc);
			}
			
	}
	
	public static int sumarsecuencias(int [] arr) {
		int suma = 0;
		int pos = 0;
		
		while(pos < MAX) {
			suma += arr[pos];
			
			pos++;
		}
		
		return suma;
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
	
	
	public static int buscarpos_inicio(int [] arr, int pos) {
		
		while((pos < MAX-1) && (arr[pos] == 0)) {
			
			pos++;
		}
		
		return pos;
	}
	
	
	public static int buscarpos_final(int [] arr, int pos) {
		
		while((pos < MAX) && (arr[pos] != 0)) {
			pos++;
		}
		
		return (pos-1);
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
