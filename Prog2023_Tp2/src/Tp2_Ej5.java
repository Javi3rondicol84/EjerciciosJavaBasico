/*
 * Escribir un programa que solicite una hora del día (valor entero de
la hora solamente) y resuelva en cada caso:
a. Si la hora está entre las 0 y las 5, pida ingresar la
temperatura y si la misma es menor a 20 grados imprima
“Encender la calefacción”. Si es mayor a 25, imprima
“Apagar calefacción”. Si está en el rango de 20 a 25 imprima
“Calefacción encendida, no abra las ventanas!!!”.

b. Si la hora está entre las 6 y las 11, pida un carácter letra
minúscula y si es vocal imprima por la consola la cantidad de
vocales que tiene la palabra que corresponde con la hora.
Ejemplo 8 (ocho) tiene 2 vocales. Si no es vocal imprima la
cantidad de consonantes que tiene, para el ejemplo 8 (ocho)
tiene 2 consonantes.

c. Si la hora está entre las 12 y 17 y es par, imprima el
promedio entre la hora ingresada y el límite inferior del
rango. 

Si la hora es impar debe imprimir el promedio entre la
hora ingresada y el límite superior del rango.


d. Si la hora está entre las 18 y 23, pida ingresar una clave
numérica, si coincide con la clave almacenada previamente
en una constante, pida ingresar una segunda clave de
verificación (un valor entre 100 y 999). Para esta segunda
clave (que solo la conoce el usuario) se debe verificar que el
el dígito de mayor peso (centena) es múltiplo del dígito de
mayor peso de la clave almacenada. Si todo esto se cumple
debería mostrar por la consola el mensaje “Clave correcta”.
Ejemplo: clave almacenada 364, clave ingresada 364,
segunda clave ingresada 698.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp2_Ej5 {

	public static void main (String [] args) {
		
		final int dos = 2;
		final int limiteinferior = 13;
		final int limitesuperior = 16;
		int hour;
		int temperature;
		char letra;
		float promedio;
		final int clavealmacenada = 364;
		int claveingresada, segundaclaveingresada;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Introduzca una hora");
			hour = Integer.valueOf(entrada.readLine());
			
			if(hour > 0 && hour < 5) {
				System.out.println("Introduzca la temperatura");
				temperature = Integer.valueOf(entrada.readLine());
				
				if(temperature < 20) {
					System.out.println("Encender la Calefaccion");
				}
				else if(temperature > 25) {
					System.out.println("Apagar la calefaccion");
				}
				else if(temperature >= 20 && temperature <= 25) {
					System.out.println("Calefaccion encendida, no abra las ventanas!!!");
				}
			}
			else if(hour > 6 && hour < 11) {
				System.out.println("Introduzca una letra minuscula");
				letra = entrada.readLine().charAt(0);
				
				switch(letra) {
					case 'a': case 'e': case 'i': case 'o': case 'u': {
					
						if(hour == 6) {
							System.out.println("Tiene 2 vocales");
						}
						else if(hour == 7) {
							System.out.println("Tiene 3 consonantes");
						}
						else if(hour == 8) {
							System.out.println("Tiene 2 vocales");
						}
						else if(hour == 9) {
							System.out.println("Tiene 3 vocales");
						}
						else if(hour == 10) {
							System.out.println("Tiene 2 vocales");
						}
						else if(hour == 11) {
							System.out.println("Tiene 2 vocales");
						}
						
						break;
					}
					default: {
						if(hour == 6) {
							System.out.println("Tiene 2 consonantes");
						}
						else if(hour == 7) {
							System.out.println("Tiene 2 consonantes");
						}
						else if(hour == 8) {
							System.out.println("Tiene 2 consonantes");
						}
						else if(hour == 9) {
							System.out.println("Tiene 2 consonantes");
						}
						else if(hour == 10) {
							System.out.println("Tiene 2 consonantes");
						}
						else if(hour == 11) {
							System.out.println("Tiene 2 consonantes");
						}
					}
				}
				
			}
			else if((hour >= 12) && (hour <= 17)) {
				if(hour % dos == 0) {
					promedio = (hour + limiteinferior) / dos;
					System.out.println(promedio);
				}
				else if(hour % dos != 0) {
					promedio = (hour + limitesuperior) / dos;
					System.out.println(promedio);
				}
				
			}
			else if((hour >= 18 && hour <= 23)) {
				System.out.println("Ingrese una clave entre 100 y 999");
				claveingresada = Integer.valueOf(entrada.readLine());
				
				if(claveingresada == clavealmacenada) {
					System.out.println("Ingrese una segunda clave entre 100 y 999");
					segundaclaveingresada = Integer.valueOf(entrada.readLine());
					
					if((segundaclaveingresada % 100) % (clavealmacenada % 100) == 0) {
						System.out.println("Clave correcta");
					}
				}
			}
			
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
}
