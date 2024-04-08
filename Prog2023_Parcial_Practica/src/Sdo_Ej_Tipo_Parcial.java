/*
 * 2do Ejercicio tipo parcial
Un dispositivo que lleva un animal bovino en su cuello recolecta datos de un acelerómetro en tres ejes: X Y Z.
Cada toma de datos se representa como una secuencia de valores enteros entre 0 y 1023 para cada eje, las
secuencias están separadas por -1 (valor no válido para esta lógica). El productor quiere conocer cómo se ha
comportado su animal en el transcurso del día y para ello ingresa un patrón de aceleración X Y Z y una cantidad
N de repeticiones. Un patrón que se repite una cierta cantidad de veces significa que el animal puede estar
pastoreando, caminando, rumiando, etc. Dado un valor N y el patrón X Y Z en un arreglo inicializado con -1 (de
tamaño igual al arreglo que tiene los datos), hacer un programa en JAVA que:
- Compruebe si el patrón se repitió N o más veces y si es así que elimine del arreglo las secuencias que se
siguen repitiendo luego de la cantidad N. 
Por ejemplo, si tenemos el siguiente arreglo de datos:

arr {-1 12 22 44 -1 23 34 55 -1 23 34 55 -1 23 34 55 -1 23 34 57 -1}
El arreglo patrón X Y Z a analizar es X=23, Y=34, Z=55 y el N=2
{-1 -1 -1 -1 -1 -1 -1 -1 23 34 55 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1}

El arreglo resultante sería
{-1 12 22 44 -1 23 34 55 -1 23 34 55 -1 -1 23 34 57 -1 -1 -1 -1}

eliminar las secs patron que se repiten mas de N veces, en este caso >= 2, 3.

23 34 55 se repite 4 veces, asi que hay que eliminar 1 vez. y que solo queden 3.

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Sdo_Ej_Tipo_Parcial {
	public static final int MAX = 21;
	public static final int SEPARADOR = -1;
	public static void main(String [] args) {
		int[] arr =
			{-1,23,34,55,-1,23,34,55,-1,23,34,55,-1,23,34,55,-1,23,34,55,-1};
			int[] patron =
			{-1,-1,-1,-1,-1,-1,-1,-1,23,34,55,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	final int min = 0;
	int inipat = 0;
	int finpat = -1;
	int inicio = 0;
	int fin = -1;
	int num = 0;
	int cant = 1;
	
	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		imprimir_arreglo(arr);
	
		System.out.println();
		
		try {
			
			do {
				System.out.println("Introduce un numero limite de aparecion de secuencia patron(mayor a "+min+")");
				num = Integer.valueOf(entrada.readLine());
			}while(num <= min);
			
			inipat = buscar_pos_inicio(patron, finpat+1);
			if(inipat < MAX-1) {
				finpat = buscar_pos_fin(patron, inipat);
			}
			
			while(inicio < MAX-1) {
				inicio = buscar_pos_inicio(arr, fin+1);
				
				if(inicio < MAX-1) {
					
					fin = buscar_pos_fin(arr, inicio);
					
					
					if(es_igual(arr, patron, inicio, fin, inipat, finpat) == true) {
						
						if(cant > num) {
							eliminar_secs(arr, inicio, fin);
							fin = inicio;
							
						}
						
						cant++;
					}
				}
			}
			
			System.out.println("arr modificado: ");
			imprimir_arreglo(arr);
			
		}
		catch(Exception exc) {
			
		}
			
	}
	
	public static boolean es_igual(int [] arr, int [] pat, int iniarr, int finarr, int inipat, int finpat) {
		boolean es_igual = false;
		int indice = 0;
		int tam = (finarr+1)-iniarr;
		
		if(((finarr+1)-iniarr) == ((finpat+1)-inipat)) {
			while((indice < tam) && (arr[iniarr+indice] == pat[inipat+indice])) {
				indice++;
			}
			if(indice == tam) {
				es_igual = true;
			}
		}
		
		
		return es_igual;
	}
	
	
	public static void eliminar_secs(int [] arr, int inicio, int fin) {
		int indice = 0;
		int tam = (fin+1)-inicio;
		while(indice < tam) {
			corrimiento_izq(arr, inicio);
			indice++;
		}
	}
	
	public static void corrimiento_izq(int [] arr, int pos) {
		while(pos < MAX-1) {
			arr[pos] = arr[pos+1];
			pos++;
		}
	}
	
	
	public static int buscar_pos_fin(int [] arr, int pos) {
		int indice = pos;
		
		while((indice < MAX-1) && (arr[indice] != SEPARADOR)) {
			indice++;
		}
		
		return indice-1;
	}
	
	public static int buscar_pos_inicio(int [] arr, int pos) {
		int indice = pos;
		
		while((indice < MAX-1) && (arr[indice] == SEPARADOR)) {
			indice++;
		}
		
		return indice;
	}
	
	
public static void imprimir_arreglo(int [] arr) {
		
		int indice;
		indice = 0;
		
		System.out.println("Arreglo: ");
		while(indice < MAX) {
			
			System.out.print("["+arr[indice]+"]");
			
			indice++;
		}
		
		
	}
	
	
}
