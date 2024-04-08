import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Hacer un programa que dado el arreglo definido y precargado 
 * elimine todas las
secuencias que tienen orden descendente entre sus elementos.
 */

public class Tp3_Ej16 {
	
	public static int MAX = 12;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad_letra = 0.4;
	public static double probabilidad_numero = 0.4;
	
	public static void main (String[]args) {
			
		int arr[] = {0,0,3,2,0,0,4,3,2,1,0,0};
		
			try {
				
				imprimirarr(arr);
				
				ejercicio(arr);
				
				System.out.println();
				
				imprimirarr(arr);				

			}
			catch (Exception exc) {
				System.out.print(exc);
			}
			
	}
	
	public static void ejercicio(int [] arr) {

		int inicio = 0;
		int fin = -1;
		int ini = 0;
		boolean desc = false;
		

		/*
		 * obtener inicio y fin
		 * if (arr de inicio <= fin, es arr[inicio] > arr[inicio+1], aux++ 
		 *  si aux == fin+1-inicio, encontrar es true
		 *  si encontrar es true, eliminar esa secuencia
		 */
		
		while(inicio < MAX-1) {
			
			inicio = buscarpos_inicio(arr, fin+1);
			
			if(inicio < MAX-1) {
				
				fin = buscarpos_fin(arr, inicio);
				
				desc = comprobardesc(arr, inicio, fin, desc);
				
				if(desc) {
					borrarsec(arr, inicio, fin);
				}
			}
	
		}
		
	}
	
	public static void borrarsec(int [] arr, int inicio, int fin) {
			int ini = inicio;
			
		while(ini <= fin) {
			
			corrimiento_izq(arr, inicio);
			
			ini++;
		}
	}
	
	public static void corrimiento_izq(int [] arr, int inicio) {
		int ini = inicio;
		
		while(ini < MAX-1) {
			arr[ini] = arr[ini+1];
			ini++;
		}
		
	}
	
	
	public static boolean comprobardesc(int [] arr, int inicio, int fin, boolean desc) {
		
		int ini = inicio;
		int aux = 0;
		
		while(ini <= fin) {
			
			if(arr[ini] > arr[ini+1]) {
				aux++;
			}
			
			ini++;
		}
		
		if(((fin+1) - inicio) == aux) {
			desc = true;
		}
		
		
		return desc;
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
