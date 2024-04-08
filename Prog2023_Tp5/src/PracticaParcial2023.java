/*
 * Ejercicio tipo parcial
Cuando se debe procesar texto expresado en lenguaje natural, una de las primeras tareas que se realiza es la de
eliminación de stopwords. Las stopwords son palabras muy comunes en un determinado lenguaje, por ejemplo, artículos
(el, la, las, los...), preposiciones (a, ante, con, por...), etc.
Dado un texto almacenado en un arreglo de caracteres de tamaño MAX_A, donde cada palabra está delimitada por
espacios, comas (,) o puntos (.) se pide eliminar todas las stopwords almacenadas en otro arreglo de caracteres de
tamaño MAX_S que se encuentra delimitado por espacios.
Por ejemplo, dado un texto almacenado en un arreglo A:
 */

public class PracticaParcial2023 {
	
	public static final int MAX_A = 39;
	public static final int MAX_S = 20;

	public static void main (String [] args) {
		int inicio = 0;
		int fin = -1;
		char [] arrA = {' ','l','a',' ','c','a','s','a',' ','r','o','j','a',',',' ','a',' ','v','u','e','l','t','a',' ','d','e',' ','l','a',' ','e','s','q','u','i','n','a','.',' '};
		char [] arrS = {' ','l','a',' ','o',' ','l','o','s',' ','d','e',' ','l','a',' ','l','a','s',' '};
		
		imprimir_arreglo(arrA);
		
		while(inicio < MAX_A) {
			inicio = buscar_pos_inicio(arrA, fin+1, MAX_A);
			if(inicio < MAX_A) {
				fin = buscar_pos_fin(arrA, inicio, MAX_A);
				
				if(comprobar_secs(arrA, arrS, inicio, fin) == true) {
					eliminar_todas_las_secs(arrA, inicio, fin);
				}
				
			}
		}
		
		System.out.println("Arreglo transformado: ");
		
		imprimir_arreglo(arrA);
	}
	
	public static void eliminar_todas_las_secs(char [] arr, int iniA, int finA) {
		int inicio = 0;
		int fin = -1;
		int indice = 0;
		
		while(inicio < MAX_A) {
			inicio = buscar_pos_inicio(arr, fin+1, MAX_A);
			if(inicio < MAX_A) {
				fin = buscar_pos_fin(arr, inicio, MAX_A);
				
				if(((fin+1)-inicio) == ((finA+1)-iniA)) {
					
					while((inicio+indice <= fin) && (arr[inicio+indice] == arr[iniA+indice])) {
						indice++;
					}
					
					if(inicio+indice > fin) {
						eliminar_sec(arr, inicio, fin);
						fin = inicio;
					}
					
				}
				
			}
		}
	}
	
	

	public static int buscar_pos_inicio(char [] arr, int inicio, int MAX) {
		
		while((inicio < MAX) && ((arr[inicio] == ' ') || (arr[inicio] == ',') || (arr[inicio] == '.'))) {
			inicio++;
		}
		
		return inicio;
	}
	
	public static int buscar_pos_fin(char [] arr, int inicio, int MAX) {
		
		while((inicio < MAX) && ((arr[inicio] != ' ') && (arr[inicio] != ',') && (arr[inicio] != '.'))) {
			inicio++;
		}
		
		return inicio-1;
	}
	
	public static boolean comprobar_secs(char [] A, char [] S, int iniA, int finA) {
		boolean encontrar = false;
		int inicio = 0;
		int fin = -1;
		
		while((inicio < MAX_S) && (encontrar == false)) {
			inicio = buscar_pos_inicio(S, fin+1, MAX_S);
			if(inicio < MAX_S) {
				fin = buscar_pos_fin(S, inicio, MAX_S);
				encontrar = chequear_igualdad(A, S, iniA, finA, inicio, fin);
			}
		}
		
		return encontrar;
	}
	
	public static boolean chequear_igualdad(char [] A, char [] S, int iniA, int finA, int iniS, int finS) {
		boolean chequear = false;
		int indice = 0;
		if(((finA+1)-iniA) == ((finS+1)-iniS)) {
			while((iniA <= finA) && (A[iniA] == S[iniS+indice])) {
				iniA++;
				indice++;
			}
			if(iniA > finA) {
				chequear = true;
			}
		}
	
		return chequear;
	}
	
	public static void eliminar_sec(char [] arr, int inicio, int fin) {
		int indice = 0;
		int tam = (fin+1)-inicio;
		
		while(indice < tam) {
			corrimiento_izq(arr, inicio);
			indice++;
		}
		
	}
	
	public static void corrimiento_izq(char [] arr, int inicio) {
		while(inicio < MAX_A-1) {
			arr[inicio] = arr[inicio+1];
			inicio++;
		}
	}
	
	public static void imprimir_arreglo(char [] arr) {
		
		int indice;
		indice = 0;
		
		System.out.println("Arreglo: ");
		while(indice < MAX_A) {
			
			System.out.print("["+arr[indice]+"]");
			
			indice++;
		}
		
		
	}
	
}

