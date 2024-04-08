package parte_7_arreglos;
/*Hacer un programa que dado el arreglo definido y precargado elimine del arreglo 
*todas las ocurrencias de una secuencia patrón dada por otro arreglo de iguales 
*características (solo tiene esa secuencia). Al eliminar se pierden los valores 
*haciendo los corrimientos.
 */
public class parte_7_ejercicio_15 {
	 public static final int MAX = 20;
	    public static final int MAX_PATRON = 4;

	    public static void main(String[] args) {
	        int[] arrint = {0, 1, 2, 0, 3, 4, 0, 6, 5, 4, 3, 0, 0, 0, 3, 5, 0, 8, 5, 0};
	        int[] arrpatron = {6, 5, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	        imprimir_arreglo_secuencias_int(arrint);
	        buscar_secuencia(arrint, arrpatron);
	        imprimir_arreglo_secuencias_int(arrint);
	    }

	    public static void imprimir_arreglo_secuencias_int(int[] arr) {
	        System.out.print("Arreglo de secuencias int\n|");
	        for (int pos = 0; pos < MAX; pos++) {
	            System.out.print(arr[pos] + "|");
	        }
	        System.out.print("\n");
	    }

	    public static void buscar_secuencia(int[] arr, int[] patron) {
	        int inicio, fin;
	        inicio = 0;
	        fin = -1;
	        while ((inicio < MAX - 1)) {
	            inicio = obtener_inicio_secuencia(arr, fin + 1);
	            if (inicio < MAX - 1) {
	                fin = obtener_fin_secuencia(arr, inicio);
	                if (secuencia_cumple_patron(arr, patron, inicio, fin) == true) {
	                    int veces = fin - inicio;
	                    while (veces >= 0) {
	                        corrimiento_izq(arr, inicio);
	                        veces--;
	                    }
	                }
	            }
	        }
	    }

	    public static boolean secuencia_cumple_patron(int[] arr, int[] patron, int inicio, int fin) {
	        boolean iguales = true;
	        int i = 0;
	        while (((inicio + i) <= fin) && (arr[inicio + i] == patron[i])) {
	            i++;
	        }
	        if (((inicio + i) > fin) && (patron[i] == 0)) {
	            iguales = true;
	        } else {
	            iguales = false;
	        }
	        return iguales;
	    }

	    public static int obtener_inicio_secuencia(int[] arr, int pos) {
	        while ((arr[pos] == 0) && (pos < MAX - 1)) {
	            pos++;
	        }
	        return pos;
	    }

	    public static int obtener_fin_secuencia(int[] arr, int pos) {
	        while ((arr[pos] != 0) && (pos < MAX - 1)) {
	            pos++;
	        }
	        return pos - 1;
	    }

	    public static void corrimiento_izq(int[] arrenteros, int posicion) {
	        for (int pos = posicion; pos < MAX - 1; pos++) {
	            arrenteros[pos] = arrenteros[pos + 1];
	        }
	    }
}
