import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado,

 
solicite al usuario un numero entero y elimine todas las ocurrencia de numero
en el arreglo. 


Mientras exista (en cada iteración tiene que buscar la posición dentro del
arreglo) 

tendrá que usar la posición para realizar un corrimiento a izquierda (quedarán
tantas copias de la última posición del arreglo como cantidad de ocurrencias del número).
*/

public class Tp1_Ej6 {
	
	public static int MAX = 10;
	public static int MAXVALOR = 10;
	public static int MINVALOR = 1;
	
	public static void main (String[]args) {
			
			int arr[] = new int [MAX];
			int num = 0;

			try {
				
	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
				cargararr(arr);
				
				imprimirarr(arr);
				
				System.out.println("Introduce un num para eliminar sus ocurrencias");
					num = Integer.valueOf(entrada.readLine());
					
					eliminar_ocurr(arr, num);
				
				imprimirarr(arr);
		
			}
			catch (Exception exc) {
				System.out.print(exc);
			}
			
	}
	
	public static void eliminar_ocurr(int [] arr, int num) {
		int pos = 0;

		
		while(pos < MAX) {
			pos = buscarpos(arr, num, pos);
		}
		
		
	}
	

	public static int buscarpos(int [] arr, int num, int pos) {
		
		boolean hallado = false;

		while(pos < MAX) {
			
			if(arr[pos] == num) {
				corrimiento_izq(arr, pos);
				hallado = true;
			}
			else {
				pos++;

			}
		}
		
		if(hallado == false) {
			System.out.println("El numero ("+num+") no está no esta ni se repite en el arreglo.");
		}
		
		return pos;
	}
	
	
	public static void corrimiento_izq(int [] arr, int pos) {
			
		int pos2 = pos;
		
			while(pos2 < MAX-1) {
				
				arr[pos2] = arr[pos2+1];
				
				pos2++;
			}
			
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
