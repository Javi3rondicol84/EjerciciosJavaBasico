/*
 * 2. Dado que el equipo de desarrollo es muy eficiente, el
departamento de ventas le ha generado un nuevo requerimiento
para que el sistema pueda emitir algunos informes extras:
a. dado un importe, el sistema le debe informar cuantos tickets
superan dicho importe
b. dada una cantidad de artículos, el sistema le debe informar
cuántos tickets están por encima de esa cantidad.
c. dado un importe, el sistema debe informar cuantos artículos
vendidos están por encima del mismo.
d. dado un importe promedio, cuántos tickets superan en
promedio a dicho importe
Hacer un programa completo con un menú de opciones (con la
opción ‘0’ sale) para que informe los diferentes valores al
departamento de ventas.
 * 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Ej_BonusTrack_2 {

	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	
public static void main (String [] args) {
		
		int [] arr = {0,4,4,7,0,1,0,9,4,0,4,1,9,9,0,2,2,2,0,0};
		char opcion = ' ';
		final char minvalor = 'a';
		final char maxvalor = 'd';
		int importe = 0;
		int articulos = 0;
		double imporpromedio = 0;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {

			imprimir_arreglo(arr);

			do {
				System.out.println("Introduzca una letra entre a y i");
				opcion = entrada.readLine().charAt(0);
				
				switch(opcion) {
				case 'a':
					System.out.println("introduzca un importe");
					importe = Integer.valueOf(entrada.readLine());
					
					tickets_superan_importe(arr, importe);
					break;
				case 'b':
					System.out.println("introduzca x cantidad de articulos");
					articulos = Integer.valueOf(entrada.readLine());
					
					tickets_superan_articulos(arr, articulos);
					break;
				case 'c':
					System.out.println("introduzca un importe");
					importe = Integer.valueOf(entrada.readLine());
					
					
					articulos_superan_importe(arr, importe);
					break;
					
				case 'd':
					System.out.println("introduzca un importe promedio");
					imporpromedio = Double.valueOf(entrada.readLine());
				
					tickets_promedio_supera_importe(arr, imporpromedio);
					break;
				}
				

				
				/*
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
				*/
				
				imprimir_arreglo(arr);
				
			}while(((opcion > minvalor) || (opcion < maxvalor)) && (opcion != '0'));
			
			
		}
		catch(Exception exc) {
			
		}
		
	}
	

	public static void tickets_promedio_supera_importe(int [] arr, double imporpromedio) {
		int inicio = 0;
		int fin = -1;
		double promedio = 0;
		double mayorprom = imporpromedio;
		int cant = 0;
		
		while(inicio < MAX-1) {
			inicio = buscar_pos_inicio(arr, fin+1);
			
			if(inicio < MAX-1) {
				fin = buscar_pos_fin(arr, inicio);
				
				promedio = calcular_valor_promedio(arr, inicio, fin);
				
				if(promedio > mayorprom) {
					cant++;
				}
				
			}
			
		}
		
		System.out.println("el promedio de "+cant+" tickets superan dicho importe promedio introducido");
		
		
	}


	public static void tickets_superan_importe(int [] arr, int importe) {
		int inicio = 0;
		int fin = -1;
		int suma = 0;
		int mayorsuma = importe;
		int cant = 0;
		
		while(inicio < MAX-1) {
			inicio = buscar_pos_inicio(arr, fin+1);
			
			if(inicio < MAX-1) {
				fin = buscar_pos_fin(arr, inicio);
				suma = ver_suma_sec(arr, inicio, fin);
				
				if(suma > mayorsuma) {
					cant++;
				}
				
			}
			
		}
		
		System.out.println(cant+" tickets superan dicho importe");
		
		
	}
	
	public static void tickets_superan_articulos(int [] arr, int articulos) {
		int inicio = 0;
		int fin = -1;
		int cant = 0;
		
		while(inicio < MAX-1) {
			inicio = buscar_pos_inicio(arr, fin+1);
			
			if(inicio < MAX-1) {
				fin = buscar_pos_fin(arr, inicio);
				
				if(((fin+1)-inicio) > articulos) {
					cant++;
				}
				
				
			}
			
		}
		
		System.out.println(cant+" tickets superan dichos articulos");
		
	}
	
	
	public static void articulos_superan_importe(int [] arr, int importe) {
		int indice = 0;
		int cant = 0;
		
		while(indice < MAX-1) {
			
			if(arr[indice] > importe) {
				cant++;
			}
			
			indice++;
		}
		
		System.out.println(cant+" articulos superan el importe");
		
	}

	
	
	

//metodos parte 1
	
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
		double promedio = 0;
		
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
		double promedio = 0;
		
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
	
	public static double calcular_valor_promedio(int [] arr, int inicio, int fin) {
		double suma = 0;
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