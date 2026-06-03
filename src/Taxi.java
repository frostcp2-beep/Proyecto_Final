
public class Taxi extends Vehiculo {

    public Taxi() {
        super("Taxi", 50, 25000, 4, 15500);
    }

    // Recargo = gastoBase * porcentaje * pasajeros
    // Ejemplo: 28800 * 0.05 * 4 = $5.760 en autopista
    @Override
    public double calcularRecargoPasajeros(double gastoBase, int pasajeros, boolean esAutopista) {
        if (esAutopista) {
            return gastoBase * 0.05 * pasajeros; // 5% por persona en autopista
        } else {
            return gastoBase * 0.02 * pasajeros; // 2% por persona en otras rutas
        }
    }
}