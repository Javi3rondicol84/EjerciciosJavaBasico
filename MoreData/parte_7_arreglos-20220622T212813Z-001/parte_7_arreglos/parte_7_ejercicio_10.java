package parte_7_arreglos;
/*Hacer un programa que dado el arreglo definido y precargado permita obtener a
*través de métodos la posición de inicio y la posición de fin de la secuencia 
*ubicada a partir de una posición entera ingresada por el usuario. Finalmente, 
*si existen imprima por pantalla ambas posiciones obtenidas.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
public class parte_7_ejercicio_10 {
	 public static final int MAX = 20;
	    public static final int MAXVALOR = 9;
	    public static final int MINVALOR = 1;
	    public static final int MAXPOS = 19;
	    public static final int MINPOS = 0;
	    public static final double probabilidad_numero = 0.4;

	    public static void main(String[] args) {
	        int[] arrint = new int[MAX];
	        int entero, inicio_secuencia, final_secuencia;
	        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	        try {
	            cargar_arreglo_aleatorio_secuencias_int(arrint);
	            imprimir_arreglo_secuencias_int(arrint);
	            System.out.println("Ingrese un entero entre: " + MINPOS + " y " + MAXPOS);
	            entero = Integer.valueOf(entrada.readLine());
	            inicio_secuencia = buscar_posicion_inicio(arrint, entero);
	            final_secuencia = buscar_posicion_final(arrint, inicio_secuencia);
	            System.out.println("El inicio de la secuencia es la pos [" + inicio_secuencia + "]");
	            System.out.println("El final de la secuencia es la pos [" + final_secuencia + "]");
	        } catch (Exception exc) {
	            System.out.println(exc);
	        }
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

	    public static int buscar_posicion_inicio(int[] arr, int pos) {
	        while ((arr[pos] == 0) && (pos < MAX-1)) {
	            pos++;
	        }
	        return pos;
	    }

	    public static int buscar_posicion_final(int[] arr, int pos) {
	        while ((arr[pos] != 0) && (pos < MAX-1)) {
	            pos++;
	        }
	        return (pos-1);
	    }
}