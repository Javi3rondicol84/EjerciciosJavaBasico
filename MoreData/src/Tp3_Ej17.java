import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 *  Suponer que se tienen dos arreglos A y B de secuencias (de caracteres separados por uno o
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


public class Tp3_Ej17 {
	
	public static int MAX = 15;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad_letra = 0.4;
	public static double probabilidad_numero = 0.4;
	
	public static void main (String[]args) {
			
			char arrA[] = {' ', 'a','b','c',' ',' ',' ','f','g','h',' ','a','b','c',' '};
			char arrB[] = {' ', 'a','a','a',' ',' ',' ','f','g','h',' ','a','a','a',' '};


			imprimirarr_char(arrA);
			imprimirarr_char(arrB);
			
			System.out.println();

			operar(arrA, arrB);
			
			
		
			
	}
	
	public static void operar(char [] arrA, char [] arrB) {
		
		int indiceA = 0; //para la secuencia mas repetida
		int indiceB = 0; //para la secuencia con mas caracteres repetidos
		
		indiceA = secuencia_repetida(arrA);
		indiceB = caracteres_repetidos(arrB);
		
		
	}
	
	public static int secuencia_repetida(char [] arrA) {
		int inicio = 0;
		int fin = -1;
		
		int oldinicio = 0;
		int oldfin = 0;
		boolean frenar = false;
		int contador = 0;
		int cont = 0;
		
		while(inicio < MAX-1) {
			
			inicio = buscarpos_inicio(arrA, fin+1);
			
			if(inicio < MAX-1) {
				fin = buscarpos_fin(arrA, inicio);
				
				oldinicio = inicio;
				oldfin = fin;
				
				frenar = comprobar(arrA, inicio, fin, oldinicio, oldfin);
				
				if(frenar) {
					
				}
			}
		}
		
		return inicio;
	}
	
	
	public static boolean comprobar(char [] arrA, int inicio, int fin, int oldinicio, int oldfin) {
		int contador = 0;
		int init = inicio;
		int oldinit = oldinicio;
		boolean frenar = false;
		
		while(init <= fin) {
			
			if(arrA[init] == arrA[oldinit]) {
				contador++;
			}
			
			init++;
			oldinit++;
		}
		
		if((fin+1)-inicio == contador) {
			frenar = true;
		}
		
		
		return frenar;
	}
	
	
	
	public static int caracteres_repetidos(char [] arrB) {
		int pos = 0;
		
		
		return pos;
	}
	
	
	
	public static int buscarpos_inicio(char [] arr, int pos) {
		
		while((pos < MAX-1) && (arr[pos] == 0)) {
			pos++;
		}
		
		return pos;
	}
	
	public static int buscarpos_fin(char [] arr, int pos) {
		
		while((pos < MAX-1) && (arr[pos] != 0)) {
			pos++;
		}
		
		return (pos-1);
	}


	
	public static void imprimirarr_char(char [] arr) {
		int pos = 0;
		
		System.out.print("arreglo: ");
		
		while(pos < MAX) {
			
			System.out.print("["+arr[pos]+"]");
			
			pos++;
		}
		
		System.out.println();
  }
	
	
	
	

}
