import java.util.Random;
import java.util.Scanner;

public class Comprador {
    private String nombre;
    private String email;
    // No se porque sigue tirando esto pero aparentemente no afecta la funcinalidad 
    private int boletosDeseados;
    private double presupuestoMaximo;

    public Comprador(String nombre, String email, int boletosDeseados, double presupuestoMaximo) {
        this.nombre = nombre;
        this.email = email;
        this.boletosDeseados = boletosDeseados;
        this.presupuestoMaximo = presupuestoMaximo;
    }

    public int generarNumeroAleatorio() {
        Random random = new Random();
        return random.nextInt(15000) + 1;
    }

    public void solicitarBoletos() {
        int numeroTicket = generarNumeroAleatorio();
        int a = generarNumeroAleatorio();
        int b = generarNumeroAleatorio();

        if (numeroTicket >= a && numeroTicket <= b) {
            System.out.println("¡Hola " + nombre + "! Tu ticket es apto para comprar boletos.");
        } else {
            System.out.println("¡Hola " + nombre + "! Lo siento, tu ticket no es apto para comprar boletos.");
        }
    }

    public boolean validarCompra(Localidad localidad) {
        double precioTotal = localidad.getPrecio() * boletosDeseados;
        return localidad.consultarDisponibilidad() >= boletosDeseados && precioTotal <= presupuestoMaximo;
    }

    public void realizarCompra(Localidad localidad) {
        if (validarCompra(localidad)) {
            localidad.venderBoletos(boletosDeseados);
            System.out.println("Compra realizada exitosamente. ¡Disfruta del concierto!");
        } else {
            System.out.println("No se pudo realizar la compra. Verifica disponibilidad y presupuesto.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa tu nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa tu correo: ");
        String email = scanner.nextLine();
        System.out.print("¿Cuántos boletos deseas comprar?: ");
        int boletosDeseados = scanner.nextInt();
        System.out.print("¿Cuál es tu presupuesto máximo?: ");
        double presupuestoMaximo = scanner.nextDouble();

        Comprador comprador = new Comprador(nombre, email, boletosDeseados, presupuestoMaximo);

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Solicitar boletos");
            System.out.println("2. Realizar compra");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    comprador.solicitarBoletos();
                    break;
                case 2:
                    // Aquí debes crear una instancia de la clase Localidad y luego llamar a comprador.realizarCompra(localidad);
                    // Ejemplo:
                    // Localidad localidad = new Localidad(100, 20); // Ejemplo de una localidad
                    // comprador.realizarCompra(localidad);
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        } while (opcion != 3);

        scanner.close();
    }
}
