/*
 * 3. Una refactorización del sistema se ha aplicado sobre la estructura
que permite almacenar los tickets para poder soportar una nueva
funcionalidad. En el nuevo esquema cada secuencia tiene en
primer lugar el id del producto, al lado la cantidad vendida de ese
producto para ese ticket. Ese se repite hasta que no hay más
productos y el último lugar lo ocupa el importe total. Ejemplo:

double arr = {0,3,24,7,1,203.56,0,99,2,87.5,0,12,8,3,5,1233.4,0};
//la ultima pos es el total en cada ticket.
 
 Para este ejemplo tenemos 3 tickets:
i. el primero para el producto de id 3 se vendieron 24,
para el id 7, 1 solo y el importe de la venta fue de
$203.56
ii. para el segundo solo se vendieron 2 productos del id
99 por un importe de $87.5
iii. para el tercero se vendieron 8 del id 12 y 5 del id 3
todo por un importe de $1233.4
Con este esquema el departamento de ventas pretende conocer
cuantos descuentos se aplicaron sabiendo que si la cantidad de
productos iguales es mayor o igual a 2 y es una cantidad par se
aplicó un descuento del 10% en el valor total del ticket. Tomando
en cuenta estos descuentos el departamento de ventas quiere
saber
a. cuánto fue el total de descuentos aplicados en todo el fin de
semana para lo cual necesita saber cuánto sumó en pesos
todos los descuentos aplicados. Para el ejemplo suma:
$152.45 (redondeado)
b. cuantos productos tuvieron descuento (la cantidad de
productos diferentes no la cantidad de unidades). Para el
ejemplo fueron 3 artículos: el de id 3, id 99 e id 12.

 se aplica descuento del 10% en el total, si cierto id se repite en todo el arreglo 2 o mas veces o su cantidad es par, 2,4,6,etc.
a.guardar el 10% aplicado en cada ticket y e ir sumandolos, deberia dar 152.45 al final.}
 
b.si la cantidad de un producto es par, o dicho producto(id) se repite 2 o mas veces, se le aplica descuento.
sumar la cantidad de articulos diferentes a los que se le aplico. (deberia ser 3).
 */

public class Ej_BonusTrack_3 {

	public static int MAX = 17;
	public static int MAXVALOR = 9;
	public static int MINVALOR = 1;
	public static double probabilidad = 0.4;
	
	public static void main (String [] args) {
		
		double [] arr = {0,3,23,7,1,203.56,0,99,2,87.5,0,12,8,3,5,1233.4,0};
		
		imprimir_arreglo(arr);
		
		System.out.println();
		conocer_descuentos_tickets(arr);
		
		

	}
	
	public static void conocer_descuentos_tickets(double [] arr) {
		
		int inicio = 0;
		int fin = -1;
		double total = 0;
		final double desc = 0.1;
		
		System.out.println("se aplica descuento en los articulos: ");
		
		while(inicio < MAX-1) {
			inicio = buscar_pos_inicio(arr, fin+1);
			
			if(inicio < MAX-1) {
				fin = buscar_pos_fin(arr, inicio);
				
				if(se_aplica_descuento(arr, inicio, fin) == true) {
					System.out.print(arr[inicio]+", ");
					total += (arr[fin] * desc);
				}
			}
		}
		
		System.out.println("el total en pesos de los descuentos aplicados es de: "+total);
		
	}
	
	
	public static boolean se_aplica_descuento(double [] arr, int inicio, int fin) {
		boolean se_aplica = false;
		int indice = 1;
		int tam = (fin+1)-inicio;
		final int par_o_impar = 2;
		
		while((indice < tam) && (!se_aplica)) {
			
			if(indice % par_o_impar != 0) { 
				inicio = inicio + (indice-1);
			
				if(chequear_id(arr, inicio) == true) {
					se_aplica = true;
			     }
			}
			else if(indice % par_o_impar == 0) { 
			
				inicio = inicio + (indice-1); 
				if((arr[inicio] % par_o_impar == 0)) {
				
					se_aplica = true;
				}
				else {
					indice--;
				}
			}
			
			indice++;
		}


		
		return se_aplica;
	}
	
	public static boolean chequear_id(double [] arr, int posTicket) {
		int inicio = 0;   
		int fin = -1;
		int cantId = 0;
		boolean chequear = false;
		final int cantmin = 2;
		int indice = 1;
		int tam = 0;
		
		
		while(inicio < MAX-1) {
			inicio = buscar_pos_inicio(arr, fin+1);
			
			if(inicio < MAX-1) {
				fin = buscar_pos_fin(arr, inicio);
				
				tam = (fin+1)-inicio;
				
				while(indice < tam) { //resetear indice
					
						if(indice % 2 != 0) { 
							
							inicio += (indice-1);
							
							if(arr[inicio] == arr[posTicket]) {
			
								cantId++;
							}
						}
						
						indice++;
					}
				
				indice = 0;
			}
		}
		
		if(cantId >= cantmin) {
			chequear = true;
		}

		return chequear;
	}
	
	
	
	
	public static int buscar_pos_fin(double [] arr, int pos) {
		int indice = pos;
		
		while((indice < MAX-1) && (arr[indice] != 0)) {
			indice++;
		}
		
		return indice-1;
	}
	
	public static int buscar_pos_inicio(double [] arr, int pos) {
		int indice = pos;
		
		while((indice < MAX-1) && (arr[indice] == 0)) {
			indice++;
		}
		
		return indice;
	}
	
	
	public static void imprimir_arreglo(double [] arr) {
		
		int indice;
		indice = 0;
		
		System.out.println("Arreglo: ");
		while(indice < MAX) {
			
			System.out.print("["+arr[indice]+"]");
			
			indice++;
		}
		
		
	}
	
	
}