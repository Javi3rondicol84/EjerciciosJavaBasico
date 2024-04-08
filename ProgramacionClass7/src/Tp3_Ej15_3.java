import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp3_Ej15_3 {
	public static int MAX = 20;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	
	public static void main(String [] args) {
		
		int [] arr = { 0, 4, 3, 0, 0, 3,4,5,2,7,0,3,0,3,4,5,2,7,0,0,3,4,5,2,7,0}; 
		int [] patron = { 0, 0, 3, 4, 5, 2,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		
		
		imprimir_arreglo(arr);
		
		eliminar_patron(arr, patron);
	
		imprimir_arreglo(arr);
	}
	
	public static void eliminar_patron(int [] arr, int [] patron) {
			int inicio = 0;
			int fin = -1;
			int ini_patron = 0;
			int fin_patron = -1;
			
			ini_patron = buscar_inicio(patron, fin_patron+1);
			fin_patron = buscar_fin(patron, ini_patron);
			
			while(inicio < MAX-1) {
				inicio = buscar_inicio(arr, fin+1);
		
				if(inicio < MAX-1) {
					fin = buscar_fin(arr, inicio);
					System.out.println("arreglo_normal inicio: "+inicio+" fin: "+ fin);
					System.out.println("arreglo_patron inicio: "+ini_patron+" fin: "+ fin_patron);
				
				}
				
				if(comprobar(arr, patron, inicio, fin, ini_patron, fin_patron) == true) {
	
				
					eliminar_sec(arr, inicio, fin);
					fin = inicio;
				}
				
			}
	}
	
	public static void eliminar_sec(int [] arr, int inicio, int fin) {
		
		int i = 0;
		
		while(i < (fin-inicio)+1) {
			
			corrimiento_izq(arr, inicio);
			
			i++;
		}
		
	}
	
	//ESTUDIAR ESTE METODO Y SUS CONDICIONES
	public static boolean comprobar(int [] arr, int [] arr_patron, int inicio, int fin, int inicio_patron, int fin_patron) {
	
		int i = 0;
		int tampatron;
		int tam;
		tampatron = (fin_patron - inicio_patron+1);
		tam = (fin - inicio+1);
		int init = inicio;
		int init2 = inicio_patron;
	
		while((init+i < MAX-1)&&(arr[init+i] == arr_patron[init2+i])&&(arr[init+i] != 0)) {
			i++;
		}
		
		if((i == tam)&&(tam == tampatron)) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
	
	public static void corrimiento_izq(int [] arr, int inicio) {
		int pos = inicio;
		
		while(pos < MAX-1) {
			arr[pos] = arr[pos+1];
			pos++;
		}
	}
	
	
	public static int buscar_inicio(int [] arr, int inicio) {

		while((inicio < MAX-1) && (arr[inicio]) == 0) {
			
			inicio++;
		}
		
		return inicio;
	}
	
	public static int buscar_fin(int [] arr, int inicio) {

		while((inicio < MAX-1) && (arr[inicio]) != 0) {
			
			inicio++;
		}
		
		return inicio-1;
	}
	
	public static void cargar_arreglo(int [] arr) {
		
		Random r = new Random();
		int index = 1;
		arr[0] = 0;
		arr[MAX-1] = 0;
	
		while(index < MAX-1) {
			
			if(r.nextDouble() > probabilidad) {
				
				arr[index] = (r.nextInt(MAXVALOR-MINVALOR+1)+MINVALOR);
				
			}
			else {
				arr[index] = 0;
			}
			
			index++;
		}
		
	}
	
	
	public static void imprimir_arreglo(int [] arr) {
		System.out.println();
		int index = 0;
		
		System.out.print("Arreglo: ");
		
		while(index < MAX) {
			
			System.out.print("["+arr[index]+"]");
			
			index++;
		}
		
	}
}
