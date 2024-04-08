/*
 * Bonus Track 1 - Ejercicio dominio real
1. La clínica “Dolores” tiene un sistema de historias clínicas para
todos sus pacientes. El gerente de administración solicita emitir
algunos informes y elige en un menú de opciones:
a. Si la opción es ‘1’ se debe pedir ingrese la cantidad de
pacientes (no mayor a 15) y por cada uno solicitar la edad.
Informar cuántos pacientes son mayores de 78 años.
b. Si la opción es ‘2’ se debe ingresar una cantidad de
prestadores de servicios que tiene la clínica (no mayor a 10).
Por cada prestador solicitar la cantidad de pacientes que ha
atendido en los últimos 2 días. Finalmente, informar cuántos
prestadores han atendido a más de 10 pacientes en los
últimos 2 días.
c. Si la opción es ‘3’ se desea saber la cantidad de pacientes
de cada sexo y el promedio de edades de cada grupo. Para
ello deberá solicitar primero que ingrese qué cantidad son
femeninos (no mayor a 10) y qué cantidad son masculinos
(no mayor a 10). Por cada grupo solicitar el ingreso de las
edades para luego informar los promedios correspondientes.
d. Por último, si la opción es ‘4’ se desea conocer cuántos
pacientes no tienen obra social. Para ello se debe solicitar la
cantidad de pacientes (no mayor a 15) y por cada uno
solicitar si tiene o no obra social. Puede suponer un valor
numérico para verdadero y otro para falso.
e. Cualquier otra opción se debe informar que “No es una
opción válida” y debe volver a pedirla. Con ‘0’ termina.
Escribir un programa que permita obtener al gerente de
administración los informes que necesita.

2. La cadena de supermercados carrefive desea aplicar descuentos
según el día que se realiza la compra:
a. Los días martes, si el importe total de la compra supera los
$13.000 el descuento es del 5%, pero si supera los $20.000
es del 7.5%.
b. Los jueves, en cambio, el descuento es para todos los
tickets cuyo importe supere los $25.000 y será el 10% con
un tope de reintegro de $3.000 por ticket.
c. Si es viernes o sábado, si el número de ticket es par y el
importe es a lo sumo de $15.000 se le aplicará un descuento
del 8% si el DNI es par.
Escribir un programa que dado el día, solicite al usuario los

restantes datos para calcular los descuentos en cada caso y lo
aplique sobre el valor final a pagar. Debe informar el importe final
a pagar en cada caso.
 */



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp2_BonusTrack {

	public static void main (String [] args) {
		int opcion;
		int pacientes;
		int indice = 0;
		int indice2 = 0;
		int edad;
		int tmp = 0;
		final int mayor = 78;
		final int diez = 10;
		int cantprest;
		int hombre;
		int mujer;
		int edadmasculina;
		int edadfemenina;
		int suma = 0;
		int suma2 = 0;
		int promhombre;
		int prommujer;
		int falso = 0;
		int plan;

		//2- carrefour
		
		int dia;
		double importe;
		int nroticket;
		double descuento;
		int DNI;
		final int reintegro = 3000;
		final int dos = 2;
		final int cien = 100;

		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
		//1. clinica
		 
			do {
				System.out.println("Elige una opción entre 1 y 4");
				opcion = Integer.valueOf(entrada.readLine());
				
				if(opcion == 1) {
					do {
						System.out.println("Ingrese la cantidad de pacientes(max15)");
						pacientes = Integer.valueOf(entrada.readLine());

						while(indice < pacientes) {
							
							System.out.println("Ingrese la edad del paciente");
							edad = Integer.valueOf(entrada.readLine());
							
							if(edad > mayor) {
								tmp++;
							}
							
							indice++;
						}
						
						System.out.println(tmp+" son mayores de 78 años.");
					}while((pacientes < 0) || (pacientes > 15));
					
				}
				else if(opcion == 2) {
					do {
						System.out.println("Ingrese la cantidad de prestadores de servicios(max10)");
						cantprest = Integer.valueOf(entrada.readLine());

						while(indice < cantprest) {
							
							System.out.println("Ingrese la cantidad de pacientes atendidos en los ultimos dos dias");
							pacientes = Integer.valueOf(entrada.readLine());
							
							if(pacientes > diez) {
								tmp++;
							}
							
							indice++;
						}
						
						System.out.println(tmp+" prestadores de servicios han atendido a más de 10 pacientes.");
					}while((cantprest < 0) || (cantprest > 10));
					
				}
				else if(opcion == 3) {
					do {
						System.out.println("Ingrese la cantidad de pacientes hombre(max10)");
						hombre = Integer.valueOf(entrada.readLine());
						
							while(indice < hombre) {
							
								System.out.println("Ingrese las edades de los pacientes");
								edadmasculina = Integer.valueOf(entrada.readLine());
								
								suma = suma + edadmasculina;
								
								indice++;
						    }
							
							promhombre = (suma / hombre);
							
								do {
									
									System.out.println("Ingrese la cantidad de pacientes mujer(max10)");
									mujer = Integer.valueOf(entrada.readLine());
	
									while(indice2 < mujer) {
										
										System.out.println("Ingrese las edades de los pacientes");
										edadfemenina = Integer.valueOf(entrada.readLine());
										
										suma2 = suma2 + edadfemenina;
										
										indice2++;
									}
									
									prommujer = (suma2 / mujer);
									
								}while(((mujer < 0) || (mujer > 10)));
						
					}while(((hombre < 0) || (hombre > 10)));
					
					System.out.println("El promedio de las edades de los pacientes hombre es de "+promhombre);
					System.out.println("El promedio de las edades de los pacientes mujer es de "+prommujer);
				}
				else if(opcion == 4) {
					do {
						System.out.println("Ingrese la cantidad de pacientes(max15)");
						pacientes = Integer.valueOf(entrada.readLine());

						while(indice < pacientes) {
									
								System.out.println("Ingrese si tiene plan social(1-si, 0-no)");
								plan = Integer.valueOf(entrada.readLine());

								if(plan == falso) {
									tmp++;
								}
							
							indice++;
						}
						
						System.out.println(tmp+" pacientes no tienen obra social.");
					}while((pacientes < 0) || (pacientes > 15));
					
				}
				else {
					System.out.println("No es una opcion valida");
				}
				
			}while((opcion < 1) || (opcion > 4));
		
			
		//2.carrefour
			
			System.out.println("Introduzca el importe");
			importe = Double.valueOf(entrada.readLine());
			System.out.println("Introduzca el nro de ticket");
			nroticket = Integer.valueOf(entrada.readLine());
			System.out.println("Introduzca el nro de DNI");
			DNI = Integer.valueOf(entrada.readLine());
			
			do {
				System.out.println("Introduzca el dia: (martes-1, jueves-2, viernes-3, sabado-4");
				dia = Integer.valueOf(entrada.readLine());
				
				if(dia == 1) {
					
					if((importe > 13000) && (importe < 20000)) {
						descuento = 5;
						
						importe = importe - (importe * (descuento / cien));
						
						System.out.println("Se aplica el descuento del 5% y el importe final es de: "+importe);
					}
					else if(importe > 20000) {
						descuento = 7.5;
						importe = importe - (importe * (descuento / cien));
						
						System.out.println("Se aplica el descuento del 7.5% y el importe final es de: "+importe);
					}
					
				}
				else if(dia == 2) {
					
					if(importe > 25000) {
						descuento = 10;
						importe = importe - (importe * (descuento / cien));
						importe = importe + reintegro;
						
						System.out.println("Se aplica el descuento del 10%  + reintegro de 3000, el importe final es de: "+importe);
					}
				
				}
				else if((dia == 3) || (dia == 4)) {
					
							if((importe >= 15000) && (nroticket % dos == 0) && (DNI % dos == 0)) {
								descuento = 8;
								importe = importe - (importe * (descuento / cien));
								
								System.out.println("Se aplica el descuento del 8% y el importe final es de: "+importe);
							}
						
				}else {
					System.out.println("Elige una opción entre 1 y 4");
				}
				
				
			}while((dia < 1) || (dia > 4));
			
			
			
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
}