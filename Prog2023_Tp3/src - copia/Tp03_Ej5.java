/*
 * 5. Hacer un método que dado un número entero con valor inicial 1,
haga una iteración incrementando el número de a uno hasta un
valor MAX = 4 (constante). Mientras itera deberá imprimir el
número. Luego invocarlo desde el programa principal y cuando
termina imprimir por pantalla “terminó”.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp03_Ej5 {

	public static final int MAX = 4;
	
	public static void main (String [] args) {
		int num;
		
		num = iteracion();
	
		System.out.println("Terminó");
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

