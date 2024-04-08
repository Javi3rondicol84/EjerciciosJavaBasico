/*
 * 8. Realizar un programa que dado dos n�meros enteros y un
car�cter, todos ingresados por el usuario, muestre por pantalla el
resultado de la operaci�n matem�tica b�sica considerando el valor
del car�cter. Si ingreso el car�cter: �a� la suma, �b� la resta, �c� la
multiplicaci�n y �d� la divisi�n entre ambos n�meros
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp03_Ej8 {

	public static void main (String [] args) {
		
		int num1, num2;
		char car;
		int resultado;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			do {
				System.out.println("Elige una operacion: a-sumar, b-restar, c-multiplicacion, d-division");
				car = entrada.readLine().charAt(0);
				
				if((car == 'a') || (car == 'b') || (car == 'c') || (car == 'd')) {
					System.out.println("Introduzca dos numeros.");
					num1 = Integer.valueOf(entrada.readLine());
					num2 = Integer.valueOf(entrada.readLine());
					
					resultado = calcular(car, num1, num2);
					System.out.println("El resultado de la operaci�n es: "+resultado);
				}

				
			
			}while((car == 'a') || (car == 'b') || (car == 'c') || (car == 'd'));
			
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	public static int calcular(char car, int num1, int num2) {
		
		int resultado = 0;
		
		if(car == 'a') {
			resultado = num1 + num2;
		}
		else if(car == 'b') {
			resultado = num1 - num2;
		}
		else if(car == 'c') {
			resultado = num1 * num2;
		}
		else if(car == 'd') {
			resultado = num1 / num2;
		}
		
		return resultado;
	}
	
	
}