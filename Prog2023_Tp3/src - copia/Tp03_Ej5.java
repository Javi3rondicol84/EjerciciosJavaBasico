/*
 * 5. Hacer un m�todo que dado un n�mero entero con valor inicial 1,
haga una iteraci�n incrementando el n�mero de a uno hasta un
valor MAX = 4 (constante). Mientras itera deber� imprimir el
n�mero. Luego invocarlo desde el programa principal y cuando
termina imprimir por pantalla �termin�.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp03_Ej5 {

	public static final int MAX = 4;
	
	public static void main (String [] args) {
		int num;
		
		num = iteracion();
	
		System.out.println("Termin�");
	}
	
	public static int iteracion() {
		int num = 1;
		
		while(num <= MAX) {
			System.out.println(num);
			num++;
		}
		
		return num;
	}
	
}

