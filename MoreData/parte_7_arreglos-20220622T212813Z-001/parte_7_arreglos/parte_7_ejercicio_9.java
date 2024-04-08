package parte_7_arreglos;
/*Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
*precargado, solicite al usuario el ingreso de dos números enteros (posiciones 
*del arreglo) y ordene de forma creciente el arreglo entre dos posiciones 
*correspondientes a los números ingresados.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
public class parte_7_ejercicio_9 {
	 public static int MAX = 10;
	    public static final int MAXVALOR = 10;
	    public static final int MINVALOR = 1;
	    public static final int MAXPOS = 9;
	    public static final int MINPOS = 0;

	    public static void main(String[] args) {
	        int[] arrenteros = new int[MAX];
	        int entero_pos1, entero_pos2;
	        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	        try {
	            cargar_arreglo_aleatorio_int(arrenteros);
	            imprimir_arreglo_int(arrenteros);
	            System.out.println("Ingrese un entero: entre " + MINPOS + " y " + MAXPOS);
	            entero_pos1 = Integer.valueOf(entrada.readLine());
	            System.out.println("Ingrese otro entero: entre " + MINPOS + " y " + MAXPOS);
	            entero_pos2 = Integer.valueOf(entrada.readLine());
	            ordenar_arreglo(arrenteros, entero_pos1, entero_pos2);
	            imprimir_arreglo_int(arrenteros);
	        } catch (Exception exc) {
	            System.out.println(exc);
	        }
	    }

	    public static void cargar_arreglo_aleatorio_int(int[] arr) {
	        Random r = new Random();
	        for (int pos = 0; pos < MAX; pos++) {
	            arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
	        }
	    }

	    public static void imprimir_arreglo_int(int[] arr) {
	        for (int pos = 0; pos < MAX; pos++) {
	            System.out.println("arrenteros [" + pos + "]=>: " + arr[pos]);
	        }
	    }

	    public static void ordenar_arreglo(int[] arr, int pos1, int pos2) {
	        int pos_menor, tmp;
	        for (int i = pos1; i < pos2; i++) {
	            pos_menor = i;
	            for (int j = i + 1; j < pos2; j++) {
	                if (arr[j] < arr[pos_menor]) {
	                    pos_menor = j;
	                }
	            }
	            if (pos_menor != i) {
	                tmp = arr[i];
	                arr[i] = arr[pos_menor];
	                arr[pos_menor] = tmp;
	            }
	        }
	    }
}
