import java.util.Scanner;
//Jorge Palacios , Ejercicio No.1 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear localidades con sus respectivos precios y espacios disponibles
        Localidad localidad1 = new Localidad(100, 20);
        Localidad localidad5 = new Localidad(500, 20);
        Localidad localidad10 = new Localidad(1000, 20);

        Comprador comprador = null;

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    System.out.print("Ingresa tu nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingresa tu correo: ");
                    String email = scanner.nextLine();
                    System.out.print("¿Cuántos boletos deseas comprar?: ");
                    int boletosDeseados = scanner.nextInt();
                    System.out.print("¿Cuál es tu presupuesto máximo?: ");
                    double presupuestoMaximo = scanner.nextDouble();

                    comprador = new Comprador(nombre, email, boletosDeseados, presupuestoMaximo);
                    break;
                case 2:
                    if (comprador != null) {
                        comprador.solicitarBoletos();
                        System.out.println("Solicitud de boletos realizada.");
                    } else {
                        System.out.println("Primero debes ingresar los datos del comprador.");
                    }
                    break;
                case 3:
                    System.out.println("Disponibilidad total en Localidad 1: " + localidad1.consultarDisponibilidad());
                    System.out.println("Disponibilidad total en Localidad 5: " + localidad5.consultarDisponibilidad());
                    System.out.println("Disponibilidad total en Localidad 10: " + localidad10.consultarDisponibilidad());
                    break;
                case 4:
                    System.out.print("Ingresa el número de localidad (1, 5 o 10): ");
                    int numeroLocalidad = scanner.nextInt();
                    Localidad localidadSeleccionada = null;
                    switch (numeroLocalidad) {
                        case 1:
                            localidadSeleccionada = localidad1;
                            break;
                        case 5:
                            localidadSeleccionada = localidad5;
                            break;
                        case 10:
                            localidadSeleccionada = localidad10;
                            break;
                        default:
                            System.out.println("Localidad no válida.");
                    }
                    if (localidadSeleccionada != null) {
                        System.out.println("Disponibilidad en Localidad " + numeroLocalidad + ": " + localidadSeleccionada.consultarDisponibilidad());
                    }
                    break;
                case 5:
                    double reporteCajaTotal = localidad1.generarReporteCaja() + localidad5.generarReporteCaja() + localidad10.generarReporteCaja();
                    System.out.println("Reporte de caja total: $" + reporteCajaTotal);
                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}
