public class Buseta extends Vehiculo {

    public Buseta() {
        super("Buseta", 30, 12000, 15, 22000);
    }

    @Override
    public double calcularRecargoPasajeros(double gastoBase, int pasajeros, boolean esAutopista) {
        if (esAutopista) {
            return gastoBase * 0.12 * pasajeros; // 12% por persona en autopista
        } else {
            return gastoBase * 0.03 * pasajeros; // 3% por persona en otras rutas
        }
    }
}