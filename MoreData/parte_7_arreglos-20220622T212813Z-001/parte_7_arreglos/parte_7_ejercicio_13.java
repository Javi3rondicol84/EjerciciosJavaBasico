package parte_7_arreglos;
/*Hacer un programa que dado el arreglo definido y precargado, y un número entero 
*ingresado por el usuario, elimine las secuencias de tamaño igual al número ingresado.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
public class parte_7_ejercicio_13 {
	public static final int MAX = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final int MAXPOS = 19;
    public static final int MINPOS = 0;
    public static final double probabilidad_numero = 0.4;

    public static void main(String[] args) {
        int[] arrint = new int[MAX];
        int entero;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            cargar_arreglo_aleatorio_secuencias_int(arrint);
            imprimir_arreglo_secuencias_int(arrint);
            System.out.println("Ingrese un entero:");
            entero = Integer.valueOf(entrada.readLine());
            eliminar_secuencia(arrint, entero);
            imprimir_arreglo_secuencias_int(arrint);
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

    public static void eliminar_secuencia(int[] arr, int entero) {
        int inicio, fin;
        inicio = 0;
        fin = -1;
        while ((inicio < MAX - 1)) {
            inicio = obtener_inicio_secuencia(arr, fin + 1);
            if (inicio < MAX - 1) {
                fin = obtener_fin_secuencia(arr, inicio);
                if ((fin - inicio + 1) == entero) {
                    corrimiento_izq(arr, inicio, entero);
                }
            }
        }
    }

    public static int obtener_inicio_secuencia(int[] arr, int pos) {
        while ((pos < MAX - 1) && (arr[pos] == 0)) {
            pos++;
        }
        return pos;
    }

    public static int obtener_fin_secuencia(int[] arr, int pos) {
        while ((pos < MAX - 1) && (arr[pos] != 0)) {
            pos++;
        }
        return pos - 1;
    }

    public static void corrimiento_izq(int[] arrenteros, int inicio, int entero) {
        while (entero > 0) {
            for (int pos = inicio; pos < MAX-1; pos++) {
                arrenteros[pos] = arrenteros[pos + 1];
            }
            entero--;
        }
    }
}
