package parte_7_arreglos;
/*Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, obtenga la cantidad de números pares que tiene y la imprima.*/
import java.util.Random;
public class parte_7_ejercicio_2 {
	public static int MAXVALOR = 10;
	public static int MINVALOR = 1;
	public static int MAX = 10;
	public static void main(String[] args) {
		int [] arreglo = new int [MAX];
		int cantidadPares;
		cargar_arreglo_aleatorio_int(arreglo);
		imprimir_arreglo_int(arreglo);
		cantidadPares = obtener_cantidad_pares_arreglo(arreglo);
		System.out.println("La cantidad de numeros pares dentro del arreglo es: "+cantidadPares);
	}
	
	public static int obtener_cantidad_pares_arreglo(int [] arreglo){
		int suma = 0;
		for(int pos = 0; pos<=MAX-1; pos++){
			if(arreglo[pos]%2==0){
				suma++;
			}
		}
		return suma;
	}
	
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
