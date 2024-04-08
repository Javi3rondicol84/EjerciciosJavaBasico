import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, 

solicite al usuario un numero entero y elimine la primer ocurrencia del numero
(un número igual) en el arreglo (si existe). 


Para ello tendrá que buscar la posición y si está,


realizar un corrimiento a izquierda 


(queda una copia de la última posición del arreglo en la
anteúltima posición).
*/

public class Tp1_Ej5 {
	
	public static int MAX = 10;
	public static int MAXVALOR = 10;
	public static int MINVALOR = 1;
	
	public static void main (String[]args) {
			
			int arr[] = new int [MAX];
			int num = 0;
			int pos = 0;
			
			try {
				
	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
				cargararr(arr);
				
				imprimirarr(arr);
				
				System.out.println("Introduce un num para eliminar ocurrencia");
					num = Integer.valueOf(entrada.readLine());
					
					pos = buscarpos(arr, num);
				
					System.out.println("esta en la pos: "+arr[pos]);
					
					if(pos < MAX) {
						corrimiento_izq(arr, pos);
					}
					else {
						System.out.println("No hubo ninguna ocurrencia de ese num");
					}
					
				
				imprimirarr(arr);
		
			}
			catch (Exception exc) {
				System.out.print(exc);
			}
			
	}
	
	public static void corrimiento_izq(int [] arr, int pos) {
		
		while(pos < MAX-1) {
			
			arr[pos] = arr[pos+1];
			
			pos++;
		}
		
	}
	

	public static int buscarpos(int [] arr, int num) {
		int pos = 0;
		boolean frenar = false;
		
		while(pos < MAX && frenar == false) {
			
			if(arr[pos] == num) {
				frenar = true;
			}
			else {
				pos++;
			}
		}
		
		return pos;
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
