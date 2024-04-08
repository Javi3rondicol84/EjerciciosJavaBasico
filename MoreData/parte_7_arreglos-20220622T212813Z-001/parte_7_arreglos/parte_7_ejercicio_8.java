package parte_7_arreglos;
/*Hacer un programa que dado un arreglo ordenado creciente de enteros de tamaño 
*10 que se encuentra precargado, solicite al usuario un numero entero y elimine 
*la primer ocurrencia de numero (un número igual) en el arreglo si existe.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class parte_7_ejercicio_8 {

    public static int MAX = 10;
    public static final int MAXVALOR = 10;
    public static final int MINVALOR = 1;

    public static void main(String[] args) {
        int[] arrenteros = {0,1,2,3,4,5,6,7,8,9};
        int entero, pos = 0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try{
            imprimir_arreglo_int(arrenteros);
            System.out.println("Ingrese un entero:");
            entero = Integer.valueOf(entrada.readLine());
            pos = buscar_ocurrencia(arrenteros, entero);
            corrimiento_izq(arrenteros, pos);
            imprimir_arreglo_int(arrenteros);
        } catch (Exception exc){
            System.out.println(exc);
        }
    }
    
    public static void imprimir_arreglo_int(int[] arr) {
        for (int pos = 0; pos < MAX; pos++) {
            System.out.println("arrenteros [" + pos + "]=>: " + arr[pos]);
        }
    }
    
    public static int buscar_ocurrencia(int[] arr, int numero) {
        int pos = 0;
        int ubicacion = -1;
        boolean encontrado = false;
        while ((pos <= MAX - 1)&&(encontrado == false)) {
            if (arr[pos] == numero) {
                ubicacion = pos;
                encontrado = true;
            } else {
                pos++;
            }
        }
        return ubicacion;
    }
    
    public static void corrimiento_izq(int[] arrenteros, int posicion) {
        for (int pos = posicion; pos < MAX - 1; pos++) {
            arrenteros[pos] = arrenteros[pos + 1];
        }
    }
}
