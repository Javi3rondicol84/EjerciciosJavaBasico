/*Hacer un programa que dado el arreglo definido y precargado elimine todas las
*secuencias que tienen orden descendente entre sus elementos.
 */

public class Tp3_Ej15_Other {
	public static final int MAX = 20;

    public static void main(String[] args) {
        int[] arrint = {0, 1, 2, 0, 3, 4, 0, 6, 5, 4, 3, 0, 0, 6, 3, 1, 0, 8, 5, 0};
        imprimir_arreglo_secuencias_int(arrint);
        eliminar_secuencias_descendentes(arrint);
        imprimir_arreglo_secuencias_int(arrint);
    }

    public static void imprimir_arreglo_secuencias_int(int[] arr) {
        System.out.print("Arreglo de secuencias int\n|");
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print(arr[pos] + "|");
        }
        System.out.print("\n");
    }

    public static void eliminar_secuencias_descendentes(int[] arr) {
        int inicio, fin;
        inicio = 0;
        fin = -1;
        while ((inicio < MAX - 1)) {
            inicio = obtener_inicio_secuencia(arr, fin + 1);
            if (inicio < MAX - 1) {
                fin = obtener_fin_secuencia(arr, inicio);
                if (es_descendente(arr, inicio, fin) == true) {
                    corrimiento_izq(arr, inicio, fin);
                }
            }
        }
    }

    public static boolean es_descendente(int[] arr, int inicio, int fin) {
        int i = inicio;
        while ((i < fin) && (arr[i + 1] < arr[i])) {
            i++;
        }
        return (i==fin);
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

    public static void corrimiento_izq(int[] arr, int inicio, int fin) {
        int longuitud = (fin + 1) - inicio;
        while (longuitud > 0) {
            for (int i = inicio; i < MAX - 1; i++) {
                arr[i] = arr[i + 1];
            }
            longuitud--;
        }
    }
}
