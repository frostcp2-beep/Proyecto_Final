public class Taxi extends Vehiculo {

    public Taxi() {

        super("Taxi", 50, 25000, 4, 15500);
    }

    @Override
    public double obPorcentajeRecargoPasajero(Rutas ruta) {

        if (ruta.esAutopista()) {
            return 0.05;
        }

        return 0.02;
    }
}
