/*
 * 1. La cadena de supermercados Carrefive ha pedido la
refactorización del componente de software que usa para el
control de stock. El código original no estaba modularizado por lo
tanto no era legible y no se aprovechaba la reutilización. El
componente que maneja el stock atiende algunas necesidades
como:
a. Cuando la cantidad de unidades de un artículo llega a un
límite de seguridad se debe agregar una línea en un pedido
para luego ser enviado al proveedor. El informe debe tener
los siguientes datos: ID_Producto, Nombre, Fecha, Hora,
Cantidad, Prioridad baja.
b. Cuando la cantidad de unidades está por debajo del límite
de seguridad en más de un 30% se debe aumentar la
prioridad de baja a media y actualizar la cantidad, la fecha y
la hora en el informe.
c. Cuando la cantidad de unidades está por debajo del límite
de seguridad en más de un 70% la prioridad cambia a alta y
se debe actualizar la cantidad, la fecha y la hora en el
informe.
d. Cuando la cantidad es cero se debe imprimir por consola un
mensaje “No hay más unidades del producto” + ID_Producto
+ Nombre. También se debe actualizar la cantidad (0), la
fecha y la hora en el informe.
e. Si la cantidad vendida excede lo que hay en stock se debe
informar y no descontar del stock. Informar cuánto stock
queda para vender de ese producto.
Escribir el método que genera/modifica el informe para un artículo
a partir de los datos que necesita (solo imprimir por consola no
hay que armar un informe en sí). Luego escribir un programa con
declaración de constantes y variables que haga uso de dicho
método y que mientras el usuario no ingrese 0 (en un sistema real
lo genera otro componente por ejemplo el que se ejecuta en la
caja registradora) pida el ingreso de los datos necesarios (la
prioridad se debe obtener automáticamente dependiendo de los
valores) para generar el informe correctamente. Modularizar la
solución.
 */


/*
 * 2. Los días lunes se recibe la mercadería que envían los
proveedores y se debe actualizar el stock. Suponga que se tiene
un método que modifica el stock con la cantidad recibida y que
invoca a otro método que elimina la línea del pedido para el
producto recibido (se conoce el ID_Producto). Programar un
método al cual se le pase el día de la semana y si es lunes pida al
usuario el ID_Producto y la cantidad recibida. Con estos datos
invoque al método que modifica el stock (no implementar) y al que
elimina la línea del pedido (no implementar). Hacer un programa
que llame a los diferentes métodos, establezca variables y
constantes. Finalmente imprima cuanto stock quedó.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bonus_Track_1_Tp03 {

	public static int limite_seguridad = 20;
	public static int stock = 16;
	
	public static void main (String [] args) {
		
		int num, id_producto, hora, cantidad;
		String nombre, fecha;
		String prioridad = "baja";
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			
			do {
				
				System.out.println("Introduzca un numero distinto de cero");
				num = Integer.valueOf(entrada.readLine());
				if(num != 0) {
					System.out.println("Introduzca el id del producto");
					id_producto = Integer.valueOf(entrada.readLine());
					System.out.println("Introduzca la hora");
					hora = Integer.valueOf(entrada.readLine());
					System.out.println("Introduzca la cantidad");
					cantidad = Integer.valueOf(entrada.readLine());
					System.out.println("Introduzca el nombre");
					nombre = entrada.readLine();
					System.out.println("Introduzca fecha");
					fecha = entrada.readLine();
					
					comprobacion(id_producto, hora, cantidad, nombre, fecha, prioridad);
					
				}
				
			}while(num != 0);
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
	}
	
	public static void comprobacion(int id_producto, int hora, int cantidad, String nombre, String fecha, String prioridad) {
		
		String linea_proveedor;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
					
		try {
			
			if(cantidad > stock) {
				System.out.println("Se ha excedido del stock, el stock actual es: "+stock);
			}
			else if(cantidad == limite_seguridad) {

				System.out.println("Agregue una linea para el proveedor dado");
				linea_proveedor = entrada.readLine();
				
			}
			else if(cantidad < (limite_seguridad - (limite_seguridad * 0.3))) {
				
				prioridad = "media";
				
				System.out.println("Actualice: ");
				System.out.println("Introduzca la cantidad");
				cantidad = Integer.valueOf(entrada.readLine());
				
				System.out.println("Introduzca fecha");
				fecha = entrada.readLine();
				
				System.out.println("Introduzca la hora");
				hora = Integer.valueOf(entrada.readLine());
				
				
			}
			else if(cantidad < (limite_seguridad - (limite_seguridad * 0.7))) {
				
				prioridad = "alta";
				
				System.out.println("Actualice: ");
				System.out.println("Introduzca la cantidad");
				cantidad = Integer.valueOf(entrada.readLine());
				
				System.out.println("Introduzca fecha");
				fecha = entrada.readLine();
				
				System.out.println("Introduzca la hora");
				hora = Integer.valueOf(entrada.readLine());
				
			}
			else if(cantidad == 0) {

				System.out.println("No hay más unidades del producto"+id_producto + nombre);

				System.out.println("Actualice: ");
				System.out.println("Introduzca la cantidad");
				cantidad = Integer.valueOf(entrada.readLine());
				
				System.out.println("Introduzca fecha");
				fecha = entrada.readLine();
				
				System.out.println("Introduzca la hora");
				hora = Integer.valueOf(entrada.readLine());
			}
			
			
			System.out.println("Datos Finales: ");
			System.out.println("Id producto: "+id_producto+",Hora: "+hora+",cantidad: "+cantidad+", nombre: "+nombre+", fecha: "+fecha+", prioridad: "+prioridad);
			
		}
		catch(Exception exc) {
			
		}
		
	}
	
}