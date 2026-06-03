public class Vans extends Vehiculo {

    public Vans() {
        super("Vans", 40, 17000, 10, 19500);
    }

    @Override
    public double calcularRecargoPasajeros(double gastoBase, int pasajeros, boolean esAutopista) {
        if (esAutopista) {
            return gastoBase * 0.08 * pasajeros; // 8% por persona en autopista
        } else {
            return gastoBase * 0.03 * pasajeros; // 3% por persona en otras rutas
        }
    }
}