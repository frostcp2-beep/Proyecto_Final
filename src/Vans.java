public class Vans extends Vehiculo {

    public Vans() {

        super("Vans", 40, 17000, 10, 19500);
    }

    @Override
    public double obPorcentajeRecargoPasajero(Rutas ruta) {

        if (ruta.esAutopista()) {
            return 0.08;
        }

        return 0.03;
    }
}
