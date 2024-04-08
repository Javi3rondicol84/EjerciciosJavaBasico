//insertar secuencia mas repetida y con al menos 2 valores consecutivos de arr en res.


public class Ej_Arr_Res_Parcial {
	public static final int MAX = 20;
	
	public static void main(String [] args) {
		
		int [] arr = {0,2,2,3,8,0,0,1,1,1,3,0,0,0,1,1,1,3,0,0};
		int [] res = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
		int inicio = 0;
		int fin = -1;
		int cant = 0;
		int mayorcant = 0;
		int mayorinicio = 0;
		int mayorfin = 0;
		
		imprimir_arreglo(arr);
		imprimir_arreglo(res);
		
		System.out.println("res modificado");
		
		while(inicio < MAX-1) {
			inicio = buscar_pos_inicio(arr, fin+1);
			
			if(inicio < MAX-1) {
				fin = buscar_pos_fin(arr, inicio);
				
				if(es_consecutiva(arr, inicio, fin) == true) {
					
					cant = hallar_mas_repetida(arr, inicio, fin);
					
					if(cant > mayorcant) {
						mayorcant = cant;
						mayorinicio = inicio;
						mayorfin = fin;
					}
					
				}
				
			}
		}
		
		insertar_sec_en_res(arr, res, mayorinicio, mayorfin);
		
		imprimir_arreglo(res);
	}
	
public static boolean es_consecutiva(int [] arr, int inicio, int fin) {
	
	boolean es_cons = false;
	int tmp = 0;
	final int consecutivo = 2;
	int indice = 0;
	int tam = (fin+1)-inicio;
	
	while(indice < tam) { 
		if(arr[inicio] == arr[inicio+indice]) {  //corregir, usar 
			tmp++;
		}
		indice++;
	}
	
	if(tmp >= consecutivo) {
		es_cons = true;
	}
	 
	
	
	return es_cons;
}
	
	
public static int hallar_mas_repetida(int [] arr, int inicio, int fin) {
	int init = 0;
	int finit = -1;
	int aux = 0;
	
	while(init < MAX-1) {
		init = buscar_pos_inicio(arr, finit+1);
		
		if(init < MAX-1) {
			finit = buscar_pos_fin(arr, init);
			
			if(comparar_igualdad(arr, init, finit, inicio, fin) == true) {
				aux++;
			}
			
		}
		
	
	}
	
	return aux;
}

public static boolean comparar_igualdad(int [] arr, int init, int finit, int inicio, int fin) {
	boolean es_igual = false;
	int pos = 0;
	
	if(((finit+1)-init) == ((fin+1)-inicio)) {
		while((inicio <= fin) && (arr[inicio] == arr[init+pos])) {
			inicio++;
			pos++;
		}
		
		if(inicio > fin) {
			es_igual = true;
		}
	}

	return es_igual;
}

public static void insertar_sec_en_res(int [] arr, int [] res, int inicio, int fin) {
	int indice = 0;
	
	while(inicio <= fin) {
		res[indice] = arr[inicio];
		indice++;
		inicio++;
	}
	
	
	
}

	
	public static int buscar_pos_fin(int [] arr, int indice) {
		
		while((indice < MAX-1) && (arr[indice] != 0)) {
			indice++;
		}
		
		return indice-1;
	}
	
	public static int buscar_pos_inicio(int [] arr, int indice) {
		
		while((indice < MAX-1) && (arr[indice] == 0)) {
			indice++;
		}
		
		return indice;
	}
	

	public static void imprimir_arreglo(int [] arr) {
		
		int indice;
		indice = 0;
		
		System.out.println("Arreglo: ");
		while(indice < MAX) {
			
			System.out.print("["+arr[indice]+"]");
			
			indice++;
		}
	}
}
