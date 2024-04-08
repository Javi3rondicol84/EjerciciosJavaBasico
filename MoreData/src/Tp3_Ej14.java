import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Hacer un programa que dado el arreglo definido y precargado, 
 * y un número entero
ingresado por el usuario, 
copie de forma continua las secuencias de tamaño igual al
número ingresado en otro arreglo de iguales características e inicializado con 0. 
La
copia en este último arreglo deben comenzar desde el principio del mismo.
 */

public class Tp3_Ej14 {
	
	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad_letra = 0.4;
	public static double probabilidad_numero = 0.4;
	
	public static void main (String[]args) {
		
		eliminar_secuencia();
					
	}
	
public static void eliminar_secuencia() {
		
		int arr[] = new int [MAX];
		int arreglo[] = new int[MAX];
		
		cargar_Arreglo(arreglo);
		
		int num = 0;
		int inicio = 0;
		int fin = -1;
		int pos = 0;
		
		cargar_arr_sec(arr);
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
					
						
						imprimirarr(arr);
						
						System.out.println("Introduce un num para copiar dicha secuencia en un arreglo");
						num = Integer.valueOf(entrada.readLine());
						
						while(inicio < MAX-1) {
							inicio = buscarpos_inicio(arr, fin+1);
							if(inicio < MAX-1) {
								fin = buscarpos_fin(arr, inicio);
								if((fin+1-inicio) == num) {
						         
					                    for (int i = inicio; i <= fin; i++) {
					                        arreglo[pos] = arr[i];
					                        pos++;
					                    }
					                
								}

							}
						}
			
						
						imprimirarreglo(arreglo);
				
					}
					catch (Exception exc) {
						System.out.print(exc);
					}
	}

	public static void cargar_Arreglo(int [] arr) {
		int pos = 0;
		
		while(pos < MAX) {
			arr[pos] = 0;
			pos++;
		}
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
	
	public static void imprimirarreglo(int [] arreglo) {
		int pos = 0;
		
		System.out.print("arreglo sin secuencias: ");
		
		while(pos < MAX) {
			
			System.out.print("["+arreglo[pos]+"]");
			
			pos++;
		}
		
		System.out.println();
  }
	

	
	
	
	

}
