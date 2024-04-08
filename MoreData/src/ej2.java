//ingresar num y encontrar ocurrencia en el arreglo, si existe mostrar la pos. si no existe, indicarlo

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ej2 {
	
	public static int MAX = 10;
	public static int MAXVALOR = 10;
	public static int MINVALOR = 1;
	
	public static void main (String[]args) {
		
		insertar();

	}
	
	
	public static void insertar() {
		
		int num = 0;
		int pos = 0;
		int arr[] = new int [MAX];	
		
		try {
			
			cargararr(arr);
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Introduce un num para buscar si está en el arreglo y hallar su pos.");
			
			num = Integer.valueOf(entrada.readLine());
			
			pos = buscar_num(arr, num);
			
			if(pos < MAX) {
				System.out.println("El numero que ingreso: ("+num+") está en la pos"+pos+" del arreglo.");
			}
			else {
				System.out.println("El numero que ingresó no se encuentra en el arreglo.");
			}
			
			imprimirarr(arr);

			
			
		}
		catch (Exception exc) {
			System.out.print(exc);
		}
		
	}
	
	public static int buscar_num(int [] arr, int num) {
		
		int pos = 0;
		boolean frenar = false;
		
		while(pos < MAX && frenar == false) {
			
			if(arr[pos] == num) {
				frenar = true;
			}
			
			pos++;
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
	}
	
	
	
	
}
