public class Localidad {
    private double precio;
    private int espaciosDisponibles;
    private int boletosVendidos;

    public Localidad(double precio, int espaciosDisponibles) {
        this.precio = precio;
        this.espaciosDisponibles = espaciosDisponibles;
        this.boletosVendidos = 0;
    }

    public boolean venderBoletos(int cantidad) {
        if (espaciosDisponibles >= cantidad) {
            espaciosDisponibles -= cantidad;
            boletosVendidos += cantidad;
            return true;
        }
        return false;
    }

    public int consultarDisponibilidad() {
        return espaciosDisponibles;
    }

    public double generarReporteCaja() {
        return boletosVendidos * precio;
    }

    public double getPrecio() {
        return precio;
    }
}
