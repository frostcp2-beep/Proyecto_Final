public class Vehiculo {

    private static final double VALOR_GALON_GASOLINA = 16000;

    protected String tipo;
    protected double consumoGasolina;
    protected double valorPasaje;
    protected int capacidadMax;
    protected double peaje;

    public Vehiculo(String tipo, double consumoGasolina, double valorPasaje, int capacidadMax, double peaje) {

        this.tipo = tipo;
        this.consumoGasolina = consumoGasolina;
        this.valorPasaje = valorPasaje;
        this.capacidadMax = capacidadMax;
        this.peaje = peaje;
    }

    public double calcularGastoGasolina(Rutas ruta, int pasajeros, boolean esSubida) {

        double galones = ruta.obDistancia() / consumoGasolina;

        galones += calcularRecargoPasajeros(ruta, pasajeros, galones);

        if (ruta.esAutopista() && esSubida) {
            galones += calcularRecargoMarchas(ruta);
        }

        return (galones * VALOR_GALON_GASOLINA) + peaje;
    }

    public double calcularIngresos(int pasajeros) {

        return pasajeros * valorPasaje;
    }

    public double calcularRentabilidad(double ingresos, double gastos) {

        return ingresos - gastos;
    }

    public double calcularRecargoPasajeros(Rutas ruta, int pasajeros, double galonesBase) {

        return galonesBase * obPorcentajeRecargoPasajero(ruta) * pasajeros;
    }

    public double obPorcentajeRecargoPasajero(Rutas ruta) {

        return 0;
    }

    public double calcularRecargoMarchas(Rutas ruta) {

        double recargo = 0;

        recargo += (ruta.obKmMarcha1() / consumoGasolina) * 0.03;
        recargo += (ruta.obKmMarcha2() / consumoGasolina) * 0.02;
        recargo += (ruta.obKmMarcha3() / consumoGasolina) * 0.01;

        return recargo;
    }

    public String obTipo() {
        return tipo;
    }

    public double obConsumoGasolina() {
        return consumoGasolina;
    }

    public double obValorPasaje() {
        return valorPasaje;
    }

    public int obCapacidadMax() {
        return capacidadMax;
    }

    public double obPeaje() {
        return peaje;
    }
}
