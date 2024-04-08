/*
 * Suponer que se tienen dos arreglos A y B de secuencias (de caracteres separados por uno o
más espacio) de tamaño MAX (arreglo empieza y termina con uno o más caracteres
espacio). A y B que están precargadas, y además se tienen los siguientes métodos (existen y
no se tienen que implementar):
a) un método que permite obtener el índice inicial de la secuencia que más se repite de un
arreglo de secuencias de tamaño MAX (que empieza y termina con o más caracteres
espacios).

b) un método que retorna el índice inicial de la secuencia que tiene más caracteres
repetidos de un arreglo de secuencias (de caracteres separados por uno o más caracteres
espacio) de tamaño MAX (que empieza y termina con espacio).


Se pide realizar un programa completo que (sin utilizar arreglos auxiliares/extras a los
mencionados):

_reemplace en A la secuencia que más se repite por la secuencia de B con más
caracteres repetidos (la separación previa entre las secuencias de A debe mantenerse).

En caso de utilizar uno o más de los métodos preexistentes mencionados en el enunciado
definir el o los encabezados de los mismos. No se requiere hacer métodos de carga e
impresión de arreglos.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp3_Ej17 {
	public static int MAX = 20;
	public static int MIN = 0;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	
	public static void main(String [] args) {
		
		int [] arrA = {0,1,3,2,4,0,1,3,2,4,0,2,0,2,4,0,2,5,0,0}; // 2,4,3
		int [] arrB = {0,1,2,3,0,0,1,1,0,0,0,3,2,0,0,0,3,2,0,0};
		
		//si sec arrB es menor a arrA, hacer corr izq
		System.out.println("Arreglo A:");
		imprimir_arreglo(arrA);
		System.out.println("\nArreglo B:");
		imprimir_arreglo(arrB);
		
		encontrar_secs(arrA, arrB);
		
	}
	
	public static void encontrar_secs(int [] arrA, int [] arrB) {
		int inicio_repetida_arrA = 0;
		int inicio_carac_rep_arrB = 0;
		

			inicio_repetida_arrA = secuencia_mas_repetida(arrA);
			inicio_carac_rep_arrB = secuencia_carac_rep(arrB);
					
			System.out.println("\nla secuencia más repetida empieza en la pos "+inicio_repetida_arrA);
			System.out.println("\nLa secuencia con caracteres más repetidos empieza en la pos: "+inicio_carac_rep_arrB);
			
			reemplazar_sec_arrA(arrA, arrB, inicio_repetida_arrA, inicio_carac_rep_arrB);
			
			System.out.println("\nSecuencia mas repetida de arreglo A reemplazada por sec con mas caracteres repetidos de arreglo B");
			imprimir_arreglo(arrA);
	}
	
	public static void reemplazar_sec_arrA(int [] arrA, int [] arrB, int in_rep_arrA, int in_car_rep_arrB) {

		int i = 0;
		int fin = 0;
		fin = buscar_fin(arrB, in_car_rep_arrB);
		int aux = ((fin-in_car_rep_arrB)+1);

		
		corrimiento_der(arrA,  in_rep_arrA);
		while(i < aux) {
			
			arrA[in_rep_arrA+i] = arrB[in_car_rep_arrB+i];
			
			i++;
		}
		
		
	}
	

	
	
	public static void corrimiento_der(int [] arr, int init) {
	
		int indice = MAX-1;
		
		while(indice > init) {
			
			arr[indice] = arr[indice-1];
			
			indice--;
		}
		
	}
	
	
	public static int secuencia_carac_rep(int [] arrB) {
		 
		int inicio = 0;
		int fin = -1;
		int aux = 0;
		int aux2 = 0;
		int iniciocar = 0;
		
		while(inicio < MAX-1) {
			
			inicio = buscar_inicio(arrB, fin+1);
			
			if(inicio < MAX-1) {
				fin = buscar_fin(arrB, inicio);
				
				aux = comprobar_rep(arrB, inicio, fin);
				
				if(aux > aux2) {
					aux2 = aux;
					iniciocar = inicio;
				}
			}
		}
		
		
		
		return iniciocar;
	}
	
	public static int comprobar_rep(int [] arr, int inicio, int fin) {
		int tmp = 0;
		int init = inicio;
		
		while(init <= fin) {
			if(arr[init] == arr[init+1]) {
				tmp++;
			}
			init++;
		}
		
		
		return tmp;
	}
	
	public static int secuencia_mas_repetida(int [] arrA) {
		int inicio = 0;
		int fin = -1;
		int iniciorep = 0;
		int aux = 0;
		int aux2 = 0;
		
		while(inicio < MAX-1) {
			inicio = buscar_inicio(arrA, fin+1);
			
			if(inicio < MAX-1) {
				fin = buscar_fin(arrA, inicio);
				
				aux = comparar(arrA, inicio,  fin);
				
					if(aux > aux2) {
						aux2 = aux;
						iniciorep = inicio;
					}
					
					
				}
			
			}
		
		
		return iniciorep;
	}
	
	public static int comparar(int [] arr, int inicio, int fin) {
		int oldinicio = inicio;
		int oldfin = fin;
		int inicio2 = 0;
		int fin2 = -1;
		int tmp = 0;
		int i;
		
		while(inicio2 < MAX-1) {
			i = 0;
			inicio2 = buscar_inicio(arr, fin2+1);
			
			if(inicio2 < MAX-1) {
					fin2 = buscar_fin(arr, inicio2);
					
					if(((fin2-inicio2)+1) == ((oldfin-oldinicio)+1)) {
						while((inicio2+i <= fin2) && (arr[inicio2+i] == arr[oldinicio+i])) {
							i++;
						}
						
						if(i == ((fin2-inicio2)+1)) {
							tmp++;
						}
					}
				
				
				}
			}
		
		return tmp;
	}

	
	
	public static int buscar_inicio(int [] arr, int indice) {
		while((indice < MAX-1)&&(arr[indice] == 0)) {
			indice++;
		}
		
		return indice;
	}
	
	public static int buscar_fin(int [] arr, int indice) {
		while((indice < MAX-1)&&(arr[indice] != 0)) {
			indice++;
		}
		
		return indice-1;
	}
	
	
	
	public static void cargar_arreglo(int [] arr) {
		
		Random r = new Random();
		int index = 1;
		arr[0] = 0;
		arr[MAX-1] = 0;
	
		while(index < MAX-1) {
			
			if(r.nextDouble() > probabilidad) {
				
				arr[index] = (r.nextInt(MAXVALOR-MINVALOR+1)+MINVALOR);
				
			}
			else {
				arr[index] = 0;
			}
			
			index++;
		}
		
	}
	
	
	public static void imprimir_arreglo(int [] arr) {
		int index = 0;
		
		System.out.print("Arreglo: ");
		
		while(index < MAX) {
			
			System.out.print("["+arr[index]+"]");
			
			index++;
		}
		
	}
}
