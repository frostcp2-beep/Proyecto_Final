public class Vehiculo{
    protected String tipo;
    protected double consumoGasolina;
    protected double valorPasaje;
    protected int capacidadMax;
    protected double peaje;
    
     public Vehiculo(String tipo,
            double consumoGasolina,
            double valorPasaje,
            int capacidadMax,
            double peaje) {

        this.tipo = tipo;
        this.consumoGasolina = consumoGasolina;
        this.valorPasaje = valorPasaje;
        this.capacidadMax = capacidadMax;
        this.peaje = peaje;
    }
     
     
}