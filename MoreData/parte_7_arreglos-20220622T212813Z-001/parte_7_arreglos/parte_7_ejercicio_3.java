package parte_7_arreglos;
/*Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, solicite al usuario una posición y realice un corrimiento a izquierda o hacia la
menor posición del arreglo.*/
import java.util.Random;
import java.io.*;
public class parte_7_ejercicio_3 {
	public static int MAXVALOR = 10;
	public static int MINVALOR = 1;
	public static int MAX = 10;
	public static void main(String[] args) {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		int [] arreglo = new int [MAX];
		int posicion;
		try{
			cargar_arreglo_aleatorio_int(arreglo);
			imprimir_arreglo_int(arreglo);
			System.out.println("Ingrese una posicion");
			posicion = Integer.valueOf(entrada.readLine());
			corrimiento_hacia_la_izquierda(arreglo, posicion);
			imprimir_arreglo_int(arreglo);
		}
		catch(Exception exc){
			System.out.println(exc);
		}
	}
	
	public static void corrimiento_hacia_la_izquierda(int [] arreglo, int posicion){
		while (arreglo[posicion] < arreglo[MAXVALOR-1]){
		arreglo[posicion] = arreglo[posicion+1];
		posicion++;
		}
	}
	//CUALQUIERA DE ESTOS DOS FUNCIONA
	/*public static void corrimiento_izq(int[] arrenteros, int posicion) {       
        for(int pos = posicion; pos < MAX-1; pos++){
            arrenteros[pos] = arrenteros[pos+1];
        }
    }*/
	
	public static void cargar_arreglo_aleatorio_int(int [] arr){
		Random r = new Random();
		for (int pos = 0; pos < MAX; pos++){
			arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
		}
	}

	public static void imprimir_arreglo_int(int [] arr){
		for (int pos = 0; pos < MAX; pos++){
			System.out.println("nombre_arreglo["+pos+"]=>: "+arr[pos]);
		}
	}
}
