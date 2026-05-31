public class Vehiculo {

    // Atributos
    protected String tipo;
    protected double consumoGasolina;
    protected double valorPasaje;
    protected int capacidadMax;
    protected double peaje;

    // Constructor
    public Vehiculo(String tipo,double consumoGasolina,double valorPasaje,int capacidadMax,double peaje) {

        this.tipo = tipo;
        this.consumoGasolina = consumoGasolina;
        this.valorPasaje = valorPasaje;
        this.capacidadMax = capacidadMax;
        this.peaje = peaje;
    }

    // Calcular gasto gasolina
    public double calcularGastoGasolina(Rutas ruta, int pasajeros, boolean esSubida) {

        // Consumo base
        double gasto =ruta.obDistancia()/ consumoGasolina;

        // Recargo pasajeros
        gasto += calcularRecargoPasajeros(pasajeros);

        // Recargo por subida
        if (esSubida) {

            gasto += calcularRecargoSubida(gasto);
        }

        // Marchas SOLO Medellin-Rionegro subida
        if (ruta.obNombreRuta().equalsIgnoreCase("Medellin-Rionegro")&& esSubida) {//&& actua como un ^

            gasto += calcularRecargoMarchas(ruta);
        }

        // Peaje en todas las rutas
        gasto += peaje;

        return gasto;
    }

    // Calcular ingresos
    public double calcularIngresos(int pasajeros) {

        return pasajeros * valorPasaje;
    }

    // Calcular rentabilidad
    public double calcularRentabilidad(double ingresos, double gastos) {

        return ingresos - gastos;
    }

    // Metodo para sobrescribir en hijos
    public double calcularRecargoPasajeros(int pasajeros) {//esto es necesario para que el override funcione

        return 0;//se pone 0 porque cada tipo tiene parametros diferentes (“si nadie lo redefine, el recargo será 0”) el override le da el parametro que va a requerir

    }

    // Metodo para sobrescribir en hijos
    public double calcularRecargoSubida(double gastoBase) {//esto es necesario para que el override funcione

        return 0;//se pone 0 porque cada tipo tiene parametros diferentes (“si nadie lo redefine, el recargo será 0”) el override le da el parametro que va a requerir
    }

    // Marchas Medellin-Rionegro subida
    public double calcularRecargoMarchas(Rutas ruta) {//esto es necesario para que el override funcione

        double recargo = 0;//se pone 0 porque cada tipo tiene parametros diferentes (“si nadie lo redefine, el recargo será 0”) el override le da el parametro que va a requerir

        recargo += ruta.obKmMarcha1() * 0.03;
        recargo += ruta.obKmMarcha2() * 0.02;
        recargo += ruta.obKmMarcha3() * 0.01;

        return recargo;
    }

    // Getters

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
