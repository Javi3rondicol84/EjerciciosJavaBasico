import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Hacer un programa que dado el arreglo definido y precargado permita encontrar la
posición de inicio de la secuencia cuya suma de valores sea mayor.
 */

public class Tp3_Ej11 {
	
	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad_letra = 0.4;
	public static double probabilidad_numero = 0.4;
	
	public static void main (String[]args) {
			
			int arr[] = new int [MAX];
			char arrchar[] = new char [MAX];
			
			int num = 0;
			int suma = 0;
			int maxInicio = 0;
			int maxFin = 0;
			int maxSuma = 0;
			int inicio = 0;
			int fin = -1;

			try {
				
	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
				cargar_arr_sec(arr);
				
				cargar_arr_sec_char(arrchar);
				
				imprimirarr(arr);
				
				System.out.println();
				
				while(inicio < MAX-1) {
					
					inicio = buscarpos_inicio(arr, fin+1);
					
					if(inicio < MAX) {
						fin = buscarpos_fin(arr, inicio);
						
						suma = sumarsecuencia(arr, inicio, fin);
						
						if(suma > maxSuma) {
							maxSuma = suma;
							maxInicio = inicio;
							maxFin = fin;
						}
					}

				}
				
				System.out.println("La mayor secuencia empieza en "+maxInicio+" y termina en "+maxFin+" y la suma de esa secuencia es "+maxSuma);

		
			}
			catch (Exception exc) {
				System.out.print(exc);
			}
			
	}
	
	public static int sumarsecuencia(int [] arr, int inicio, int fin) {
		
		int suma = 0;
		
		while(inicio <= fin) {
			suma += arr[inicio];
			
			inicio++;
		}
		
		return suma;
	}
	
	public static int buscarpos_inicio(int [] arr, int pos) {
		
		while((pos < MAX-1) && (arr[pos] == 0)) {
			pos++;
		}
		
		return pos;
	}
	
	public static int buscarpos_fin(int [] arr, int pos) {
		
		while((pos < MAX-1) && (arr[pos] != 0)) {
			pos++;
		}
		
		return (pos-1);
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
