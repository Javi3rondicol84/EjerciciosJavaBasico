package parte_7_arreglos;
/*Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, solicite al usuario un numero entero y elimine todas las ocurrencia de numero en el
arreglo si existe. Mientras exista (en cada iteración tiene que buscar la posición dentro del
arreglo) tendrá que usar la posición para realizar un corrimiento a izquierda (quedarán tantas
copias de la última posición del arreglo como cantidad de ocurrencias del número).*/
import java.util.Random;
import java.io.*;
public class parte_7_ejercicio_6 {
	public static int MAXVALOR = 10;
	public static int MINVALOR = 1;
	public static int MAX = 10;
	public static void main(String[] args) {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		int [] arreglo = new int [MAX];
		int numero;
		try{
			cargar_arreglo_aleatorio_int(arreglo);
			imprimir_arreglo_int(arreglo);
			System.out.println("Ingrese un numero");
			numero = Integer.valueOf(entrada.readLine());
			obtener_pos_arreglo(arreglo,numero);			
			imprimir_arreglo_int(arreglo);
		}
		catch(Exception exc){
			System.out.println(exc);
		}



	}
	public static void obtener_pos_arreglo(int [] arreglo, int numero){
		int ultimaPosicion = arreglo[MAXVALOR-1];
		for(int pos=0; pos<MAXVALOR; pos++){
			if(numero == arreglo[pos]){
				System.out.println("Existe "+numero+" en la posicion "+arreglo[pos]);
				corrimiento_hacia_la_izquierda(arreglo, pos);
				arreglo[pos] = ultimaPosicion;
			}
		}
		
	}
	public static void corrimiento_hacia_la_izquierda(int [] arreglo, int posicion){
		for (int pos = posicion; pos < MAX - 1; pos++) {
            arreglo[pos] = arreglo[pos + 1];
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
