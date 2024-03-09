package ejercicio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TiendaECommerce tienda = new TiendaECommerce();

        //Crear cuenta o iniciar sesión
        ClienteECommerce cliente = iniciarSesionOCrearCuenta(tienda, scanner);

        //Imprimir un menú con las opciones disponibles para la tienda online
        if (cliente != null) {
            int opcion;
            do {
                System.out.println("\n Menú Principal: ");
                System.out.println("1. Ver catálogo de obras.");
                System.out.println("2. Realizar pedido.");
                System.out.println("3. Mostrar historial de compras.");
                System.out.println("4. Mostrar recomendaciones.");
                System.out.println("5. Salir.");
                System.out.println("Introduzca una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        tienda.mostrarObras();
                        break;
                    case 2:
                        realizarPedido(cliente, tienda, scanner);
                        break;
                    case 3:
                        cliente.mostrarHistorialCompras();
                        break;
                    case 4:
                        cliente.generarRecomendaciones();
                        break;
                    case 5:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, elija una opción correcta.");
                }
            } while (opcion != 5);
        } else {
            System.out.println("No se pudo iniciar sesión. Saliendo del programa...");
        }
    }

   private static ClienteECommerce iniciarSesionOCrearCuenta(TiendaECommerce tienda, Scanner scanner) {
        ClienteECommerce cliente = null;
       System.out.println("\nBienvenido a la tienda online");
       System.out.println("1. Iniciar sesión.");
       System.out.println("2. Crear cuenta.");
       System.out.println("Introduzca una opción: ");
       int opcion = scanner.nextInt();

       switch (opcion) {
           case 1:
               System.out.println("Ingrese su número de cliente: ");
               int numeroCliente = scanner.nextInt();
               cliente = tienda.buscarCliente(numeroCliente);

               if (cliente != null) {
                   System.out.println("Inicio de sesión exitoso. Bienvenido, " + cliente.getNombre());
               } else {
                   System.out.println("Número de cliente no válido. Inicio de sesión fallido.");
               }
               break;
           case 2:
               System.out.println("Ingrese su nombre: ");
               String nombre = scanner.next();
               cliente = new ClienteECommerce(nombre, tienda.generarNumeroCliente());
               tienda.agregarCliente(cliente);
               System.out.println("Cuenta creada exitosamente. Bienvenido, " + cliente.getNombre());
               break;
           default:
               System.out.println("Opción no válida. Saliendo del programa;");
       }
       return cliente;
   }

   private static void realizarPedido(ClienteECommerce cliente, TiendaECommerce tienda, Scanner scanner) {
       System.out.println("\n Realizar pedido");
       tienda.mostrarObras();
       System.out.println("Ingrese el título de la obra que desea agregar al pedido (0 para finalizar): ");
       String tituloObra = scanner.next();

       Pedido pedidoNuevo = new Pedido(cliente);
       while (!tituloObra.equals("0")) {
           Obra obra = tienda.buscarObra(tituloObra);
           if (obra != null) {
               pedidoNuevo.agregarObra(obra);
               System.out.println("Obra agregada al pedido.");
           } else {
               System.out.println("Obra no encontrada.");
           }

           System.out.println("Ingrese el título de una nueva obra o 0 para finalizar el pedido: ");
           tituloObra = scanner.next();
       }

       tienda.realizarPedido(pedidoNuevo);
       System.out.println("Pedido realizado correctamente.");
   }
}
