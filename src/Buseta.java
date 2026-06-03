public class Buseta extends Vehiculo {

    public Buseta() {

        super("Buseta", 30, 12000, 15, 22000);
    }

    @Override
    public double obPorcentajeRecargoPasajero(Rutas ruta) {

        if (ruta.esAutopista()) {
            return 0.12;
        }

        return 0.03;
    }
}
