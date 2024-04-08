/*
 * Escribir un programa que imprima por pantalla la tabla de verdad
para los operadores lógicos or y and (por separado) para dos
valores booleanos. Utilizar los operadores para calcular el
resultado. Por ejemplo, imprimir el siguiente caso para el operador
or:
false or true es: true
y se genera con:
System.out.println(“ false or true es: ” + (false || true));
 */


public class Ej8 {

	public static void main (String [] args) {
		
		System.out.println("Tabla de verdad AND");
		System.out.println("false and false: "+(false && false));
		System.out.println("false and true: "+(false && true));
		System.out.println("true and false: " +(true && false));
		System.out.println("true and true: "+(true && true));
		System.out.println("\nTabla de verdad OR");
		System.out.println("false or false: "+(false || false));
		System.out.println("false or true: "+(false || true));
		System.out.println("true or false: "+(true || false));
		System.out.println("true or true: "+(true || true));
		
		
	}
	
	
}