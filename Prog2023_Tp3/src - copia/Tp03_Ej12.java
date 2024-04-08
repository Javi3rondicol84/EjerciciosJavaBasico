/*
 * 12. Escribir un programa que simule 1000 lanzamientos de un dado
y muestre por pantalla cuántas veces salió el valor del dado
correspondiente al número entero N ingresado por el usuario.
Considerar que el valor N ingresado se corresponda a un valor
posible para un dado. Usar la sentencia Math.random() que
devuelve un valor aleatorio real entre 0 y 1.
Para asignar un posible valor a la variable dado entero:
dado = (int) (6*Math.random() + 1)
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp03_Ej12 {

	public static void main (String [] args) {
		
		simular();
		
	}
	
	public static void simular() {
		final int lanz = 1000;
		int num;
		int indice = 0;
		int random = 0;
		int aux = 0;
		
		/*ingresar numero n
		 * numero random que se genera entre 1 y 6 en bucle hasta 1000
		 *  si n numero ingresado aparecio, sumarlo en un aux
		 * 
		 */
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Elija un numero entre 1 y 6 para ver cuantas veces salió en 1000 lanzamientos");
			num = Integer.valueOf(entrada.readLine());
			
			while(indice < lanz) {
				
				random = (int)(6*Math.random() + 1);

				
				if(random == num) {
					aux++;
				}
				
				indice++;
			}
			
			System.out.println("El numero "+num+" salió "+aux+" veces.");
		}
		catch(Exception exc) {
			
		}
		
		
		
	}
	
	
}