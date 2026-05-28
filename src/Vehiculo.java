
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
    public double calcularRentabilidad (double ingreos, double gastos) {
        return ingresos - gastos;
    }
    
    
}
