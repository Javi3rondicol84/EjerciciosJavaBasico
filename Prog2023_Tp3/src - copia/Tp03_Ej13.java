/*
 * 13. Realizar un programa que, dada una opción entera (1,2,3,4),
permita realizar operaciones entre tres números reales (r1,r2,r3)
ingresados desde teclado. Para la opción:
1. Calcular la raíz cuadrada de (r1-r3)
2. Calcular el promedio de r1, r2 y r3
3. Calcular cociente de la raíz cuadrada de (r3 - r2) dividida por
r1
4. Calcular el cociente del promedio de los tres valores dividido
por la raíz cuadrada de r2
Observación: La raíz cuadrada de un número se calcula con la
sentencia: Math.sqrt(numero). Hacer uso del diseño descendente
y de la modularización para la solución. Tener en cuenta posibles
errores o excepciones como la división por cero.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp03_Ej13 {

	public static void main (String [] args) {
		
		int opcion;
		double n1, n2, n3;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Introduzca un valor entre 1 y 4: 1-calcular raiz cuadrada, 2-el promedio, 3-cociente de raiz cuadrada, 4-cociente del promedio dividido por la raiz");
			opcion = Integer.valueOf(entrada.readLine());
			System.out.println("Introduzca tres numeros");
			n1 = Double.valueOf(entrada.readLine());
			n2 = Double.valueOf(entrada.readLine());
			n3 = Double.valueOf(entrada.readLine());
			
			if(opcion == 1) {
				calcular_raiz_cuadrada(n1,n3);
			}
			else if(opcion == 2) {
				calcular_promedio(n1,n2,n3);
			}
			else if(opcion == 3) {
				calcular_cociente_raiz_cuadrada(n1, n2, n3);
			}
			else if(opcion == 4) {
				calcular_cociente_promedio(n1, n2, n3);
			}
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	public static double calcular_raiz_cuadrada(double n1, double n2) {
		
		double raiz;
		
		raiz = (n1 - n2);
		
		if(raiz >= 0) {
			Math.sqrt(raiz);
			System.out.println("El resultado es: "+raiz);
		}
		else {
			System.out.println("error el numero es negativo");
		}
	
		return raiz;
	}
	
	public static double calcular_promedio(double n1, double n2, double n3) {
		final int totalnums = 3;
		double promedio;
		
		promedio = (n1 + n2 + n3) / totalnums;
		
		System.out.println("El promedio es: "+promedio);
		
		return promedio;
	}
	
	public static void calcular_cociente_raiz_cuadrada(double n1, double n2, double n3) {
		
		double raiz;
		
		if(n1 > 0) {
			raiz = calcular_raiz_cuadrada(n3, n2);
			
			raiz = raiz / n1;
			
			if(raiz > 0) {
				System.out.println("El cociente entre la raiz y el numero 1 es: "+raiz);
			}
		}
		else {
			System.out.println("no se puede dividir por cero.");
		}
		
		
		
	}
	
	public static void calcular_cociente_promedio(double n1, double n2, double n3) {
		double  promedio;
		double raiz = 0;
		
		if(n2 > 0) {
			raiz = Math.sqrt(n2);
		}
		
		promedio = calcular_promedio(n1, n2, n3);
		
		if(promedio > 0) {
			promedio = promedio / raiz;
			
			System.out.println("el cociente del promedio de los tres valores dividido por la raiz cuadrada de n2 es: "+promedio);
		}
		
	}
}