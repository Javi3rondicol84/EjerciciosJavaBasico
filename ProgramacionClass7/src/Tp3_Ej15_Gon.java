import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 15. Hacer un programa que dado el arreglo definido y precargado elimine del arreglo
todas las ocurrencias de una secuencia patrón dada por otro arreglo de iguales
características (solo tiene esa secuencia). Al eliminar se pierden valores haciendo
corrimientos. */
public class Tp3_Ej15_Gon {
	public static final int MAX=20;
	public static final int MIN=0;
	public static void main(String[] args) {
		int [] arreglo = { 0, 4, 3, 0, 0, 3,4,5,2,7,0,3,0,3,4,5,2,7,0,0,3,4,5,2,7,0}; // { 0, 4, 3, 2, 0, 0,3,4,5,2,0,3,5,7,5,3,0,2,3,0 };
		int [] arreglo_patron = { 0, 3, 4, 5, 2, 7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		
		//int [] arreglo = {0,5,3,5,0,1,2,3,4,0,0,2,0,1,2,3,4,0,1,2,3,4,0,0,0};
	//	int [] arreglo_patron = {1,2,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		
		int numero;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {
			imprimir_arreglo(arreglo);
			buscar_numero_igual_secuencia(arreglo,arreglo_patron);
			imprimir_arreglo(arreglo);
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}

	}
	public static void buscar_numero_igual_secuencia(int [] arr,int [] arr_patron) {
		int inicio,fin,inicio_patron,fin_patron;
		inicio = 0;
		fin =-1;
		inicio_patron=0;
		fin_patron=-1;
		inicio_patron=obtener_inicio_secuencia(arr_patron,fin_patron+1);
		fin_patron=obtener_fin_secuencia(arr_patron,inicio_patron);
		while (inicio<MAX) {
			inicio = obtener_inicio_secuencia(arr,fin+1);
			if(inicio<MAX) {
				fin=obtener_fin_secuencia(arr,inicio);				
					System.out.println("arreglo_normal inicio: "+inicio+" fin: "+ fin);
					System.out.println("arreglo_patron inicio: "+inicio_patron+" fin: "+ fin_patron);
					if(comparar_secuencias(arr,arr_patron,inicio,fin,inicio_patron,fin_patron)==true) {
						System.out.println("correr.");
							corrimiento_secuencia(arr,fin,inicio);
							fin=inicio;
							
							
						}
					}
				}
				 
			}

	public static boolean comparar_secuencias(int [] arr,int [] arr_patron,int inicio, int fin, int inicio_patron, int fin_patron) {
		int i=0;
		while((arr[inicio+i]==arr_patron[inicio_patron+i])&&(arr[inicio+i]!=arr[fin])) {
			i++;
		}
		if((arr[inicio+i]==arr[fin])&&(arr_patron[inicio_patron+i]==arr_patron[fin_patron])&&(arr[fin]==arr_patron[fin_patron])) {
			
			return true;
		}
		else {
		return false;
	}
	}
	public static int obtener_inicio_secuencia(int [] arr,int pos) {
		while((pos<MAX)&&(arr[pos]==0)) {
			pos++;
		}
		return pos;
	}
	public static int obtener_fin_secuencia(int [] arr,int pos) {
		while((pos<MAX)&&(arr[pos]!=0)) {
			pos++;
		}
		return pos-1;
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
	
	public static void corrimiento_secuencia(int [] arr,int fin,int inicio) {
		int i=0;
		while(i<(fin-inicio)+1) {
			corrimiento_izquierda_desde_final(arr,inicio);
			i++;
		}
		
	}
	public static void corrimiento_izquierda_desde_final(int [] arr, int pos) {
		while (pos< MAX-1){    
		arr[pos] = arr[pos+1];
		pos++;
		}
	}

}