import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GestionPedidos gestion = new GestionPedidos();

        int opcion = -1;

        while (opcion != 0) {

            System.out.println("\n===== Pizza-Track =====");
            System.out.println("1. Registrar Pizza");
            System.out.println("2. Deshacer (Undo)");
            System.out.println("3. Rehacer (Redo)");
            System.out.println("4. Mostrar Pedido Actual");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero(sc);

            switch (opcion) {

                case 1:
                    System.out.print("Nombre de la pizza: ");
                    String nombre = sc.nextLine();

                    String[] ingredientes = new String[3];
                    for (int i = 0; i < 3; i++) {
                        System.out.print("Ingrediente " + (i + 1) + ": ");
                        ingredientes[i] = sc.nextLine();
                    }

                    Pizza pizza = new Pizza(nombre, ingredientes);
                    gestion.registrarPedido(pizza);
                    System.out.println("Pedido registrado -> " + pizza);
                    break;

                case 2:
                    Pizza deshecha = gestion.deshacer();
                    if (deshecha != null) {
                        System.out.println("Pedido deshecho -> " + deshecha);
                    } else {
                        System.out.println("No hay pedidos para deshacer.");
                    }
                    break;

                case 3:
                    Pizza rehecha = gestion.rehacer();
                    if (rehecha != null) {
                        System.out.println("Pedido rehecho -> " + rehecha);
                    } else {
                        System.out.println("No hay pedidos para rehacer.");
                    }
                    break;

                case 4:
                    Pizza actual = gestion.pedidoActual();
                    if (actual != null) {
                        System.out.println("Pedido actual (listo para producción) -> " + actual);
                    } else {
                        System.out.println("No hay pedidos activos.");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo de Pizza-Track...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        sc.close();
    }

    // Valida que lo ingresado sea un número entero.
    static int leerEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Entrada inválida. Ingrese un número entero.");
            sc.next();
        }
        int valor = sc.nextInt();
        sc.nextLine(); // limpia el salto de línea pendiente para las próximas lecturas de texto
        return valor;
    }
}
