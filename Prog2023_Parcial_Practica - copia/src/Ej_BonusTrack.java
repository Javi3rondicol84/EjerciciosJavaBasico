/*
 * Bonus Track 1 - Ejercicio dominio real
1. El departamento de ventas de la cadena de supermercados
carrefive desea hacer un análisis sobre lo comercializado en el
último fin de semana largo. Para ello solicita al grupo de desarrollo
que le prepare algunas rutinas para conocer:
a. cuántos tickets se emitieron ese fin de semana
b. cuánto fue el importe total de ventas
c. cuál fue el ticket de mayor importe, cuánto fue su valor
d. cuál fue la mayor cantidad de artículos vendidos en un ticket
e. del ticket con mayor cantidad de artículos vendidos, cuál fue
el de mayor importe, el de menor y el promedio
f. del ticket de mayor importe, cuántos artículos hay
involucrados y cuál es el promedio de valores
g. cuanto es el valor promedio de venta por ticket en todo el fin
de semana
h. cuál fue el ticket con el menor importe, cuánto fue su valor
i. cuál fue el ticket con la menor cantidad de artículos vendidos
Hacer un programa completo con un menú de opciones (con la
opción ‘0’ sale) para que informe los diferentes valores al
departamento de ventas. Considerar constantes y variables
acordes al problema. Establezca cómo será la estructura que
usará y definala en el programa teniendo en cuenta los conceptos
de secuencias vistos en la teoría.

//tickets secuencias. 
 * articulos posiciones dentro de una sec
 * acceder a las rutinas desde a hacia i mediante un do while
 * 
 * a.cantidad de secuencias del arreglo
 * b. suma de todo el arreglo
 * c. ver la secuencia con mayor valor y su importe
 * d. ver la secuencia mas grande de todas
 * e. reutulizando la rutina de d, ver el articulo de mayor numero, el de menor y el promedio
 * f. reutilizando la rutina de c, ver la cantidad de articulos y el promedio de los valores
 * g. ver promedio de todo el arreglo
 * 
 * 
 * 
 * 
 * HACER
 * h. ver la secuencia con menor importe y su valor
 * i. ver la secuencia mas pequeña de todas
 * 
 * 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Ej_BonusTrack {

	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	
	public static void main (String [] args) {
		
		int [] arr = {0,4,4,7,0,1,0,9,4,0,4,1,9,9,0,2,2,2,0,0};
		char opcion = ' ';
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {

			imprimir_arreglo(arr);

			do {
				System.out.println("Introduzca una letra entre a y i");
				opcion = entrada.readLine().charAt(0);
			}while((opcion < 'a') || (opcion > 'i'));
			
			if(opcion == 'a') {
				ver_cant_secuencias(arr);
			}
			else if(opcion == 'b') {
				ver_suma_arreglo(arr);
			}
			else if(opcion == 'c') {
				ver_secuencia_mayor_valor(arr, opcion);
			}
			else if(opcion == 'd') {
				ver_secuencia_mayor_tamanio(arr, opcion);
			}
			else if(opcion == 'e') {
				ver_secuencia_mayor_tamanio(arr, opcion);
			}
			else if(opcion == 'f') {
				ver_secuencia_mayor_valor(arr, opcion);
				//ver_secuencia_mayor_cantidad_articulos_promedio(arr);
			}
			else if(opcion == 'g') {
				ver_promedio_arreglo(arr);
			}
			else if(opcion == 'h') {
				ver_secuencia_menor_valor(arr);
			}
			else if(opcion == 'i') {
				ver_secuencia_mas_pequeña(arr);
			}
			
			imprimir_arreglo(arr);
		}
		catch(Exception exc) {
			
		}
		
	}
	
	public static void ver_cant_secuencias(int [] arr) {
		int inicio = 0;
		int fin = -1;
		int tmp = 0;
		
		while(inicio < MAX-1) {
			inicio = buscar_pos_inicio(arr, fin+1);
			if(inicio < MAX-1) {
				fin = buscar_pos_fin(arr, inicio);
				
				tmp++;
				
			}
		}
		
		System.out.println("Hay "+tmp+" tickets del fin de semana.");
		
		
	}
	
	public static void ver_suma_arreglo(int [] arr) {
		int indice = 0;
		int suma = 0;
		
		while(indice < MAX) {
			suma += arr[indice];
			indice++;
		}
		
		System.out.println("la suma del arreglo es: "+suma);
	}
	
	public static void ver_secuencia_mayor_valor(int [] arr, int opcion) {
		int inicio = 0;
		int fin = -1;
		int suma = 0;
		int mayorsuma = 0;
		int mayorinicio = 0;
		int mayorfin = 0;
		int tam = 0;
		int promedio = 0;
		
		while(inicio < MAX-1) {
			inicio = buscar_pos_inicio(arr, fin+1);
			if(inicio < MAX-1) {
				fin = buscar_pos_fin(arr, inicio);
				
				suma = ver_suma_sec(arr, inicio, fin);
				
				if(suma > mayorsuma) {
					mayorsuma = suma;
					mayorinicio = inicio;
					mayorfin = fin;
				}
			}
		}
		
		if(opcion == 'c') {
			System.out.println("La secuencia de mayor valor empieza en la pos "+mayorinicio+", termina en la pos "+mayorfin+" y la suma de sus articulos es de "+mayorsuma);
		}
		else if(opcion == 'f') {
			tam = (mayorfin+1)-mayorinicio;
			promedio = calcular_valor_promedio(arr, mayorinicio, mayorfin);
			System.out.println("La secuencia tiene "+tam+" articulos y el promedio es de "+promedio);
		}
		
	}
	
	public static int ver_suma_sec(int [] arr, int inicio, int fin) {
		int suma = 0;
		
		while(inicio <= fin) {
			suma += arr[inicio];
			
			inicio++;
		}
		
		return suma;
	}
	
	
	public static void 	ver_secuencia_mayor_tamanio(int [] arr, char opcion) {
		int inicio = 0;
		int fin = -1;
		int tamanio = 0;
		int mayortamanio = 0;
		int mayorinicio = 0;
		int mayorfin = 0;
		int mayorvalor = 0;
		int menorvalor = 0;
		int promedio = 0;
		
		while(inicio < MAX-1) {
			inicio = buscar_pos_inicio(arr, fin+1);
			if(inicio < MAX-1) {
				fin = buscar_pos_fin(arr, inicio);
				
				tamanio = (fin+1)-inicio;
	
				if(tamanio > mayortamanio) {
					mayortamanio = tamanio;
					mayorinicio = inicio;
					mayorfin = fin;
				}
			}
		}
		
		if(opcion == 'd') {
			System.out.println("La secuencia de mayor tamaño empieza en la pos "+mayorinicio+", termina en la pos "+mayorfin+" y su tamaño es de "+mayortamanio);
		}
		else if(opcion == 'e') {
			mayorvalor = calcular_mayor_valor(arr, mayorinicio, mayorfin);
			menorvalor = calcular_menor_valor(arr, mayorinicio, mayorfin);
			promedio = calcular_valor_promedio(arr, mayorinicio, mayorfin);
			//ver_secuencia_mayor_menor_promedio_valor(arr, opcion);
			
			System.out.println("el mayor valor es: "+mayorvalor);
			System.out.println("el menor valor es: "+menorvalor);
			System.out.println("el valor promedio es: "+promedio);
		}
		
		
	}
	
	public static int calcular_mayor_valor(int [] arr, int inicio, int fin) {
		int indice = 0;
		int tam = (fin+1)-inicio;
		int valor = 0;
		int mayorvalor = 0;
		int init = inicio;
		
		while(indice < tam) {
			
			while(init < fin) {
				
				if(arr[inicio+indice] >= arr[init]) {
					valor = arr[inicio+indice];
				}
				
				if(valor > mayorvalor) {
					mayorvalor = valor;
				}
				
				init++;
			}
			
			init = inicio;
			indice++;
		}
		
		
		return mayorvalor;
	}
	
	public static int calcular_menor_valor(int [] arr, int inicio, int fin) {
		int indice = 0;
		int tam = (fin+1)-inicio;
		int valor = 0;
		int menorvalor = 0;
		int init = inicio;
		boolean frenar = false;
		
		while(indice < tam) {
			
			while((init < fin) && (frenar == false)) {
				if(arr[inicio+indice] <= arr[init]) {
					valor = arr[inicio+indice];
				}
				else {
					frenar = true;
					menorvalor = valor;
				}
				
				if(valor < menorvalor) {
					menorvalor = valor;
				}
				
				init++;
			}
			
			frenar = false;
			init = inicio;
			indice++;
		}
		
		
		return menorvalor;
	}
	
	public static int calcular_valor_promedio(int [] arr, int inicio, int fin) {
		int suma = 0;
		int tam = (fin+1)-inicio;
		
		while(inicio <= fin) {
			suma += arr[inicio];
			inicio++;
		}
		
		suma /= tam;
		
		return suma;
	}
	
	public static void 	ver_promedio_arreglo(int [] arr) {
		int inicio = 0;
		double suma = 0;
		
		while(inicio < MAX-1) {
			
			suma += arr[inicio];
			
			inicio++;
		}
		
		suma /= MAX;
		
		System.out.println("El valor promedio del arreglo es de "+suma);
	
	}
	
	public static void ver_secuencia_menor_valor(int [] arr) {
		int inicio = 0;
		int fin = -1;
		int suma = 0;
		int menorsuma = 0;
		int menorinicio = 0;
		int menorfin = 0;
		
		while(inicio < MAX-1) {
			inicio = buscar_pos_inicio(arr, fin+1);
			if(inicio < MAX-1) {
				fin = buscar_pos_fin(arr, inicio);
				
				suma = ver_suma_sec(arr, inicio, fin);
				
				if(menorsuma == 0) {
					menorsuma = suma;
				}
				
				if(suma < menorsuma) {
					menorsuma = suma;
					menorinicio = inicio;
					menorfin = fin;
				}
			
			}
			
		}
		
		System.out.println("la secuencia mas pequeña empieza en:"+menorinicio+" y termina en "+menorfin+" y su suma de valores es de "+menorsuma);
	}

	public static void ver_secuencia_mas_pequeña(int [] arr) {
		int inicio = 0;
		int fin = -1;
		int tamanio = 0;
		int menortamanio = 0;
		int menorinicio = 0;
		int menorfin = 0;
		int tmp = 0;
		while(inicio < MAX-1) {
			inicio = buscar_pos_inicio(arr, fin+1);
			if(inicio < MAX-1) {
				fin = buscar_pos_fin(arr, inicio);
				
				tamanio = (fin+1)-inicio;
				
				if(menortamanio == 0) {
					menortamanio = tamanio;
				}
				
				if(tamanio < menortamanio) {
					menortamanio = tamanio;
					menorinicio = inicio;
					menorfin = fin;
				}
				

			}
		}
		
		
		
			System.out.println("La secuencia de menor tamaño empieza en la pos "+menorinicio+", termina en la pos "+menorfin+" y su tamaño es de "+menortamanio);
		
	}	
	
	public static int buscar_pos_fin(int [] arr, int pos) {
		int indice = pos;
		
		while((indice < MAX-1) && (arr[indice] != 0)) {
			indice++;
		}
		
		return indice-1;
	}
	
	public static int buscar_pos_inicio(int [] arr, int pos) {
		int indice = pos;
		
		while((indice < MAX-1) && (arr[indice] == 0)) {
			indice++;
		}
		
		return indice;
	}
	
	
	
	public static void cargar_arreglo(int [] arr) {
		
		arr[0] = 0;
		arr[MAX-1] = 0;
		
		Random r = new Random();
		int indice;
		indice = 1;
		
		while(indice < MAX-1) {
			
			if(r.nextDouble() > probabilidad) {
				arr[indice] = (r.nextInt(MAXVALOR-MINVALOR+1)+MINVALOR);
			}
			
			indice++;
		}
		
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
