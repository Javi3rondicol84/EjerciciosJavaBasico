import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Se tiene un arreglo de enteros de tamaño 20 de secuencias de números
entre 1 y 9, separadas por 0. 


El arreglo esta precargado, y además
empieza y termina con uno o más separadores 0. 

Hacer un programa que
permita obtener a través de métodos la posición de inicio y la posición de
fin de la secuencia ubicada a partir de una posición entera ingresada por
el usuario. 

Finalmente, si existen imprima por pantalla ambas posiciones
obtenidas.
 */

public class Tp3_Ej10 {
	
	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad_letra = 0.4;
	public static double probabilidad_numero = 0.4;
	
	public static void main (String[]args) {
			
			int arr[] = new int [MAX];
			char arrchar[] = new char [MAX];
			
			int num;
			
			int inicio, fin;

			try {
				
	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
				cargar_arr_sec(arr);
				
				cargar_arr_sec_char(arrchar);
				
				imprimirarr(arr);
				
				System.out.println();
				
				imprimirarr_char(arrchar);
				
	      		System.out.println("Introduce num para encontrar secuencia");
				num = Integer.valueOf(entrada.readLine());
				
				inicio = buscarpos_inicio(arr, num);
				fin = buscarpos_final(arr, inicio);
				
				if(inicio < MAX) {
					System.out.println("La secuencia empieza en: "+inicio+" y termina en: "+fin);
				}
				else {
					System.out.println("No hay secuencia en la posicion ingresada.");
				}
	

		
			}
			catch (Exception exc) {
				System.out.print(exc);
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
	
	
	public static void cargar_arr_sec_char(char [] arr) {
		Random r = new Random();
		arr[0] = ' ';
		arr[MAX-1] = ' ';
		
		int pos = 1;
		
		while(pos < MAX) {
			
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
