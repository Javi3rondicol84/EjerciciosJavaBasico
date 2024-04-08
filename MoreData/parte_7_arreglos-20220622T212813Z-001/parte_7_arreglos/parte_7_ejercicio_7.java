package parte_7_arreglos;
/*Hacer un programa que dado un arreglo ordenado creciente de enteros
de tamaño 10 que se encuentra precargado, solicite al usuario un numero
entero y lo inserte en el arreglo manteniendo su orden. Para ello tendrá
que realizar un corrimiento a derecha (se pierde el último valor del arreglo)
y colocar el numero en el arreglo en la posición indicada.*/
import java.io.*;
import java.util.Random;
public class parte_7_ejercicio_7 {
	public static int MAXVALOR = 10;
	public static int MINVALOR = 1;
	public static int MAX = 10;
	public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) {
		int [] arreglo = new int [MAX];
		int numero, pos;
		try{
			cargar_arreglo_aleatorio_int(arreglo);
			ordenar_arreglo_seleccion(arreglo);
			imprimir_arreglo_int(arreglo);
			System.out.println("Ingrese un numero entero");
			numero = Integer.valueOf(entrada.readLine());
			pos = posicionar_entero(arreglo, numero);
	        corrimiento_der(arreglo, pos);
			imprimir_arreglo_int(arreglo);

		}
		catch(Exception exc){
			System.out.println(exc);
		}

	}
	public static void corrimiento_der(int [] arrenteros, int pos){
		int indice = MAX-1;
		while (indice > pos){
			arrenteros[indice] = arrenteros[indice-1];
			indice--;
		}
	}
	
	public static int posicionar_entero(int[] arr, int entero) {
        int pos = 0;
        int ubicacion = -1;
        boolean encontrado = false;
        while ((pos <= MAX - 1) && (encontrado == false)) {
            if (arr[pos] >= entero) {
                ubicacion = pos;
                arr[pos] = entero;
                encontrado = true;
            } else {
                pos++;
            }
        }
        return ubicacion;
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
	public static void ordenar_arreglo_seleccion(int[]arr) {
		int pos_menor, tmp;
		for (int i = 0; i < MAX; i++) {
			pos_menor = i;
			for (int j = i + 1; j < MAX; j++){
				if (arr[j] < arr[pos_menor]) {
					pos_menor = j;

				}
			}
			if (pos_menor != i){
				tmp = arr[i];
				arr[i] = arr[pos_menor];
				arr[pos_menor] = tmp;
			}
		}
	}
}
