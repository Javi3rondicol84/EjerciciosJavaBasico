/*
 * Escribir un programa que pida se ingresen datos necesarios para
emitir una factura por la compra de dos artículos de librería (tipo
factura, número, nombre cliente, producto 1, importe 1, producto 2,
importe 2, importe total). Como salida debe imprimir por pantalla la
factura en un formato similar al del siguiente ejemplo:
Factura C N 249
Nombre: Juan Perez
Producto Importe
Lápiz 15.5
Papel 20.6
Importe total 36.1

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ej6 {

	public static void main (String [] args) {
		
		char bill;
		String name;
		String product1;
		String product2;
		int num;
		float import1;
		float import2;
		float totalimport;
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Introduce el tipo de factura");
			bill = entrada.readLine().charAt(0);
			System.out.println("Introduce el numero de factura");
			num = Integer.valueOf(entrada.readLine());
			System.out.println("Introduce el nombre del cliente");
			name = entrada.readLine();
			System.out.println("Introduce el primer producto");
			product1 = entrada.readLine();
			System.out.println("Introduce el importe del primer producto");
			import1 = Float.valueOf(entrada.readLine());
			System.out.println("Introduce el segundo producto");
			product2 = entrada.readLine();
			System.out.println("Introduce el importe del segundo producto");
			import2 = Float.valueOf(entrada.readLine());
			
			totalimport = import1 + import2;
			
			System.out.print("Factura\t\t"+bill+"\t\tN "+num+"\nNombre: "+name+"\nProducto\t\t\tImporte\n"+product1+"\t\t\t\t"+import1+"\n"+product2+"\t\t\t\t"+import2+"\nImporte total\t\t\t"+totalimport);
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	
}
