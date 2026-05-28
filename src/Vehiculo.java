
public class Vehiculo {
    protected String tipo;
    protected double consumoGasolina;
    protected double valorPasaje;
    protected int capacidadMax;
    protected double peaje;

    public vehiculo(){
    }
    //parametros
    public vehiculo (String tipo, double consumoGasolina, double valorPasaje, int capacidadMax, double peaje){

        this.tipo = tipo;
        this.consumoGasolina = consumoGasolina;
        this.valorPasaje = valorPasaje;
        this.capacidadMax = capacidadMax;
        this.peaje = peaje;
    }
// calculo gasto gasolina
    public double gastoGasolina (Rutas ruta, int pasajeros, boolean esAutopista) {
        
        double gasto = ruta.getDistancia() * consumoGasolina;

        if (esAutopista){
            gasto += peaje;
        }
        return gastos;
    }
    //calculo ingreos
    public double calcularIngresos (int pasajeros) {
        return pasajeros * valorPasaje;
    }
    //calculo rentabilidad
    public double calRentabilidad (double ingreos, double gastos) {
        return ingresos - gastos;
    }
    //Obtencion y Modificacion de datos
    public String obTipo() {
        return tipo;
    }
    public void modTipo (String tipo) {
        this.tipo = tipo;
    }
    public double obConsumoGasolina() {
        return consumoGasolina;
    }
    public void modConsumoGasolina (double consumoGasolina) {
        this.consumoGasolina = consumoGasolina;
    }
    public double obValorPasaje() {
        return valorPasaje;
    }
    public void modValorPasaje (double valorPasaje) {
        this.valorPasaje = valorPasaje;
    }
    public int obCapacidadMax() {
        return capacidadMax;
    }
    public void modCapacidadMax (int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }
    public double obpeaje() {
        return peaje;
    }
    public void modPeaje (double peaje) {
        this.peaje = peaje;
    }

    
}
