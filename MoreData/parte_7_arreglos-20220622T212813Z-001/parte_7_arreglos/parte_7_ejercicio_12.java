package parte_7_arreglos;
/*Hacer un programa que dado el arreglo definido y precargado permita encontrar 
*la posición de inicio y fin de la anteúltima secuencia (considerar comenzar a 
*buscarla a partir de la ultima posición del arreglo).
 */

import java.util.Random;
public class parte_7_ejercicio_12 {
	 public static final int MAX = 20;
	    public static final int MAXVALOR = 9;
	    public static final int MINVALOR = 1;
	    public static final double probabilidad_numero = 0.4;

	    public static void main(String[] args) {
	        int[] arr = new int[MAX];
	        cargar_arreglo_aleatorio_secuencias_int(arr);
	        imprimir_arreglo_secuencias_int(arr);
	        encontrar_anteultima_secuencia(arr, 2);
	    }

	    public static void cargar_arreglo_aleatorio_secuencias_int(int[] arr) {
	        Random r = new Random();
	        arr[0] = 0;
	        arr[MAX - 1] = 0;
	        for (int pos = 1; pos < MAX - 1; pos++) {
	            if (r.nextDouble() > probabilidad_numero) {
	                arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
	            } else {
	                arr[pos] = 0;
	            }
	        }
	    }

	    public static void imprimir_arreglo_secuencias_int(int[] arr) {
	        System.out.print("Arreglo de secuencias int\n|");
	        for (int pos = 0; pos < MAX; pos++) {
	            System.out.print(arr[pos] + "|");
	        }
	        System.out.print("\n");
	    }

	    public static void encontrar_anteultima_secuencia(int[] arr, int pos) {
	        int fin = MAX;
	        int inicio = MAX - 1;
	        int i = 0;
	        while ((0 <= inicio)&&(i<pos)){
	            inicio = obtener_inicio_secuencia(arr, fin - 1);
	            if (inicio >= 0) {
	                fin = obtener_fin_secuencia(arr, inicio);
	                i++;
	            }
	        }
	        System.out.println("Inicio: " + inicio);
	        System.out.println("Fin: " + fin);
	    }

	    public static int obtener_inicio_secuencia(int[] arr, int pos) {
	        while ((pos >= 0) && (arr[pos] == 0)) {
	            pos--;
	        }
	        return pos;
	    }

	    public static int obtener_fin_secuencia(int[] arr, int pos) {
	        while ((pos >= 0) && (arr[pos] != 0)) {
	            pos--;
	        }
	        return pos + 1;
	    }
}
