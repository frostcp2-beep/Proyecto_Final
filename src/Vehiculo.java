
public class Vehiculo {
    //protegidos
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
// calculo gasto gasolina / km x galon
    public double gastoGasolina (Rutas ruta, int pasajeros, boolean esAutopista) {
        
        double gasto = ruta.obDistancia() / consumoGasolina;
        
//recargo de pasajeros
        gasto += recargoPasajeros (pasajeros, esAutopista);
        
//recargo por marcha
        gasto += recargoMarchas (ruta);
//peaje por rutas
        gasto += peaje;
        
        return gasto;
    }
//sobreescritura para clases herederas
    public double recargoPasajeros (int pasajeros, boolean esAutopista) {
        return 0;
    }
//calculo recargo por marchas
    public double recargoMarchas (Rutas ruta) {
        double recargo = 0;
        recargo += ruta.obKmMarcha1() * 0.03;
        recargo += ruta.obKmMarcha2() * 0.02;
        recargo += ruta.obKmMarcha3() * 0.01;
        
        return recargo;
    }
    //calculo ingreos
    public double ingresos (int pasajeros) {
        return pasajeros * valorPasaje;
    }
    //calculo rentabilidad
    public double rentabilidad (double ingreos, double gastos) {
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
