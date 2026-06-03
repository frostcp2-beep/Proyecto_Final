public class Vehiculo {

    protected String tipo;
    protected double kmPorGalon;
    protected double valorPasaje;
    protected int    capacidadMax;
    protected double peaje;

    protected static final double PRECIO_GALON = 16000;

    public Vehiculo(String tipo, double kmPorGalon, double valorPasaje,
                    int capacidadMax, double peaje) {
        this.tipo         = tipo;
        this.kmPorGalon   = kmPorGalon;
        this.valorPasaje  = valorPasaje;
        this.capacidadMax = capacidadMax;
        this.peaje        = peaje;
    }

    public double calcularGastoGasolina(Rutas ruta, int pasajeros, boolean esSubida) {

        // Paso 1: gasto base vehículo vacío
        // Ejemplo Taxi 90km: (90/50) * 16000 = $28.800
        double gastoBase = (ruta.obDistancia() / kmPorGalon) * PRECIO_GALON;

        // Paso 2: recargo por pasajeros según ruta (polimorfismo)
        // gastoBase * porcentaje * pasajeros
        // Ejemplo Taxi autopista 4 pasajeros: 28800 * 0.05 * 4 = $5.760
        double gasto = gastoBase + calcularRecargoPasajeros(gastoBase, pasajeros, ruta.esAutopista());

        // Paso 3: recargo por marchas en subida (aplica en CUALQUIER ruta)
        // El enunciado dice "en la subida de Medellín a Rionegro" — es la dirección,
        // no el nombre de la ruta. Las tres rutas tienen esa subida.
        if (esSubida) {
            gasto += calcularRecargoMarchas(ruta);
        }

        // Paso 4: peajes ida y vuelta
        // El atributo peaje es solo ida → x2
        gasto += peaje * 2;

        return gasto;
    }

    public double calcularIngresos(int pasajeros) {
        return pasajeros * valorPasaje;
    }

    public double calcularRentabilidad(double ingresos, double gastos) {
        return ingresos - gastos;
    }

    // Se pone 0 aquí — cada subclase lo sobreescribe con su porcentaje
    public double calcularRecargoPasajeros(double gastoBase, int pasajeros, boolean esAutopista) {
        return 0;
    }

    public double calcularRecargoMarchas(Rutas ruta) {
        double costoPorKm = PRECIO_GALON / kmPorGalon;
        double recargo = 0;
        recargo += ruta.obKmMarcha1() * 0.03 * costoPorKm;
        recargo += ruta.obKmMarcha2() * 0.02 * costoPorKm;
        recargo += ruta.obKmMarcha3() * 0.01 * costoPorKm;
        return recargo;
    }

    public String obTipo()         { return tipo; }
    public double obKmPorGalon()   { return kmPorGalon; }
    public double obValorPasaje()  { return valorPasaje; }
    public int    obCapacidadMax() { return capacidadMax; }
    public double obPeaje()        { return peaje; }
}