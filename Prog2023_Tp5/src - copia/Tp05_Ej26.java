/*
 * 26. Suponer que se tienen dos arreglos A y B de secuencias (de
caracteres separados por uno o más espacio) de tamaño MAX
(cada arreglo empieza y termina con uno o más caracteres
espacio). A y B están precargados y además se tienen los
siguientes métodos (existen y no se tienen que implementar):
a. un método que permite obtener el índice inicial de la
secuencia que más se repite de un arreglo de secuencias de
tamaño MAX (que empieza y termina con o más caracteres
espacios).
b. un método que retorna el índice inicial de la secuencia que
tiene más caracteres repetidos de un arreglo de secuencias
(de caracteres separados por uno o más caracteres espacio)
de tamaño MAX (que empieza y termina con espacio).
Se pide realizar un programa completo que (sin utilizar arreglos
auxiliares/extras a los mencionados):
_reemplace en A la secuencia que más se repite por la secuencia
de B con más caracteres repetidos (la separación previa entre las
secuencias de A debe mantenerse). Considerar poner un
separador al final del arreglo si se desplaza a derecha para
mantener consistencia en la terminación de la secuencia.
En caso de utilizar uno o más de los métodos preexistentes
mencionados en el enunciado definir el o los encabezados de los
mismos. No se requiere hacer métodos de carga e impresión de
arreglos.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp05_Ej26 {

	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	
	public static void main (String [] args) {
		
		int indiceA = 0;
		int indiceB = 0;
		int [] arrA = {0,2,1,3,2,2,0,0,2,5,0,0,2,1,3,2,2,0,3,0}; 
		int [] arrB = {0,5,5,0,0,0,0,9,1,0,5,5,0,0,0,0,5,5,0,0};   

		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			//cargar_arreglo(arr);
			
			imprimir_arreglo(arrA);
			imprimir_arreglo(arrB);
			
			indiceA = indice_sec_repetida(arrA);
			indiceB = indice_caracs_sec_repetida(arrB);
			
			reemplazar_sec(arrA, arrB, indiceA, indiceB);
			
			imprimir_arreglo(arrA);
		}
		catch(Exception exc) {
			
		}
		
	}
	
	public static void reemplazar_sec(int [] arrA, int [] arrB, int indiceA, int indiceB) {
	
			int finA = 0;
			int finB = 0;
			int tamA = 0;
			int tamB = 0;
			int indice = 0;
			int diferencia = 0;
			
			finA = buscar_pos_fin(arrA, indiceA);
			finB = buscar_pos_fin(arrB, indiceB);
			
			tamA = (finA+1)-indiceA;
			tamB = (finB+1)-indiceB;
			
			if(tamA == tamB) {
				//4,3,2,1 reemp por 5,5,5,4
				//quedaria 5,5,5,4
				
				reemplazar(arrA, arrB, indice, tamA, indiceA, indiceB);
				
				
				
			
			}
			else if(tamA < tamB) {
				//4,3,2 reemp por 5,5,5,4
				//corrimiento a derecha
				
				diferencia = tamB - tamA;
				
				hacer_espacio(arrA, diferencia, indiceA);
				
				reemplazar(arrA, arrB, indice, tamB, indiceA, indiceB);
				
				
			}
			else if(tamA > tamB) {
				//4,3,2,1 reemp por 5,5,5
				//corrimiento a izq cant de veces de la diferencia, en este caso 1.
				
				diferencia = tamA - tamB;
				
				eliminar_para_insertar(arrA, diferencia, indiceA);
				
				reemplazar(arrA, arrB, indice, tamB, indiceA, indiceB);
			}
			
	}
	
	public static void eliminar_para_insertar(int [] arrA, int diferencia, int indice) {
		
		int pos = 0;
		
		while(pos < diferencia) {
			
			corrimiento_izq(arrA, indice);
			
			
			pos++;
		}
		
	}
	
	public static void corrimiento_izq(int [] arrA, int indice) {
		
		
		while(indice < MAX-1) {
			
			arrA[indice] = arrA[indice+1];
			
			indice++;
		}
		
	}
	
	
	public static void reemplazar(int [] arrA, int [] arrB, int indice, int tam, int indiceA, int indiceB) {
		
		while(indice < tam) {
			
			arrA[indiceA+indice] = arrB[indiceB+indice];
			
			
			indice++;
		}
		
	}
	
	public static void hacer_espacio(int [] arrA, int dif, int fin) {
		
		for(int i = 0; i < dif; i++) {
			
			corrimiento_der(arrA, fin);
			

			
		}
		
	}
	
	public static void corrimiento_der(int [] arrA, int fin) {
		
		int indice = MAX-1;
		
		while(indice > fin) {
			
			arrA[indice] = arrA[indice-1];
			
			indice--;
			
		}
		
	}
	
	
	
	public static boolean comprobar(int [] arrA, int indiceA, int finA, int inicio, int fin) {
		boolean comprobar = false;
		
		int indice = 0;
		int temp = 0;
		int cont = ((finA+1)-indiceA);
		int cont2 = (fin+1)-inicio;
		int indA = indiceA;
		
		while((indice < cont2)) {
			//la sec debe ser de igual tamaño e iguales valores
			if((((fin+1)-inicio) == ((finA+1)-indiceA))) {
				System.out.println(arrA[inicio+indice]+""+arrA[indA+indice]); //error a aqui
				imprimir_arreglo(arrA);
				if((arrA[inicio+indice] == arrA[indA+indice])) {
					temp++;
				}
				
			}
			
			
			indice++;
		}
		
		if(temp == ((finA+1)-indiceA)) {
			comprobar = true;
		}
		
		
		
		return comprobar;
	}
	
	
	public static int indice_sec_repetida(int [] arrA) {
		int indice = 0;
		int inicio = 0;
		int fin = -1;
		int cant = 0; //nueva cantidad, que puede ser mayor o menor a la anterior cantidad
		int oldcant = 0; //cantidad original en que se repitio la sec
		int iniRep = 0;
		int finRep = 0;
		
		while(indice < MAX-1) {
			inicio = buscar_pos_inicio(arrA, fin+1);
			
			if(inicio < MAX-1) {
				fin = buscar_pos_fin(arrA, inicio); //seccion en que se toma una secuencia, luego se pasa a un metodo donde se compara con todas las demas
				
				oldcant = comprobar_cant_repetidas(arrA, inicio, fin);
				
				if(oldcant > cant) {
					cant = oldcant;
					iniRep = inicio;
					finRep = fin;
				}
				
			}
			
			indice++;
		}
		
		System.out.println("La secuencia mas repetida empieza en: "+iniRep+" y termina en: "+finRep);
		
		return iniRep;
	}
	
	public static int comprobar_cant_repetidas(int [] arrA, int iniSec, int finSec) {
		
		int indice = 0;
		int inicio = 0;
		int fin = -1;
		int tmp = 0;
		int cont = 0;
		int tmp2 = 0;
		
		while(indice < MAX-1) {
			
			inicio = buscar_pos_inicio(arrA, fin+1);
			
			if(inicio < MAX-1) {
				fin = buscar_pos_fin(arrA, inicio);
				
				if(((finSec+1)-iniSec) == ((fin+1)-inicio)) {  //si son de igual tamaño
					
					while((arrA[iniSec+cont] == arrA[inicio+cont]) && (arrA[iniSec+cont] != 0)) {
						tmp++;
						cont++;
					}
					
					if(tmp == ((finSec+1)-iniSec)) { //si ambas secs comparadas son de igual tamaño y de iguales valores
						tmp2++;  //cont podria ser 4 por ej, osea que la sec comparada se repitio cuatro veces
					}
					
					cont = 0;
					tmp = 0;
				}

			}

			indice++;
		}
		
		return tmp2; //retornamos la cantidad de veces que la secuencia comparada traida del metodo anterior es repetida.
	}
	
	public static int indice_caracs_sec_repetida(int [] arrB) {
		int indice = 0;
		int inicio = 0;
		int fin = -1;
		int cant = 0; //nueva cantidad, que puede ser mayor o menor a la anterior cantidad
		int oldcant = 0; //cantidad original de caracs repetidos
		int iniRep = 0;
		int finRep = 0;
		
		while(indice < MAX-1) {
			inicio = buscar_pos_inicio(arrB, fin+1);
			
			if(inicio < MAX-1) {
				fin = buscar_pos_fin(arrB, inicio);
				
				oldcant = comprobar_cant_carac_repetidas(arrB, inicio, fin);
				
				if(oldcant > cant) {
					cant = oldcant;
					iniRep = inicio;
					finRep = fin;
				}
				
			}
			
			indice++;
		}
		
		System.out.println("La secuencia con mas caracteres repetidos empieza en: "+iniRep+" y termina en: "+finRep);
		
		return iniRep;
	}
	
	public static int comprobar_cant_carac_repetidas(int [] arrB, int iniSec, int finSec) {
		
		int tmp = 0;
		int indice = 0;
		int val = 0;
		int oldval = 0;
	
		
		
		while(iniSec+indice <= finSec) {
			
			// 5, 5, 5, 4    3,2,3,3,4
			
			oldval = contabilizar(arrB, iniSec+indice, iniSec, finSec);
			
			if(oldval > val) {
				val = oldval;
			}
			
			indice++;
		}
			
		return val; //retornamos la cantidad de caracs repetidos en la secuencia que esta siendo evaluada.
	}
	
	public static int contabilizar(int [] arrB, int iniSec, int pos, int finSec) {
		
		int indice = 0;
		int tmp = 0;
		
		while((indice < MAX-1) && (arrB[pos+indice] != 0)) {
			
		if(arrB[iniSec] == arrB[pos+indice]) {
			tmp++;
		}
			
			indice++;
		}
		
		
		return tmp;
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
