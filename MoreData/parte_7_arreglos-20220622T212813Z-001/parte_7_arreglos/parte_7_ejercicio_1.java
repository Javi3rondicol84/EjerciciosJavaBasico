package parte_7_arreglos;
/*Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, invierta el orden del contenido (por ejemplo: el que está en 0 se intercambia con
el que está en 9, el que está en 1 con el que está en 8...). Este intercambio no se debe realizar
de manera explícita, hay que hacer un método que incluya una iteración de intercambio.*/
import java.util.Random;;
public class parte_7_ejercicio_1 {
	public static int MAXVALOR = 10;
	public static int MINVALOR = 1;
	public static int MAX = 10;
	public static void main(String[] args) {
		int [] arreglo = new int [MAX];
		cargar_arreglo_aleatorio_int(arreglo);
		imprimir_arreglo_int(arreglo);
		invertir_orden_contenido(arreglo);
		System.out.println("----------");
		imprimir_arreglo_int(arreglo);
	}
	
	public static void invertir_orden_contenido(int [] arreglo){
		int aux;
		for(int posicion=0; posicion<MAX/2; posicion++){
			aux = arreglo[posicion];
			arreglo[posicion] = arreglo[MAX-1-posicion];
			arreglo[MAX-1-posicion] = aux;
		}
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

