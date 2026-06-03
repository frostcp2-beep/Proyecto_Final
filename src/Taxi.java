
public class Taxi extends Vehiculo {

    // Constructor
    public Taxi() {

        super("Taxi",50,25000, 4, 15500); //el "SUPER" le dara los atributos a la plantilla "THIS" de la superclase
    }

    // Recargo pasajeros
    @Override
    public double calcularRecargoPasajeros(int pasajeros) {//aqui el override le da el parametro que va a utilizar este tipo

        return pasajeros * 0.05;
    }

    // Recargo subida
    @Override
    public double calcularRecargoSubida(double gastoBase) {//aqui el override le da el parametro que va a utilizar este tipo

        return gastoBase * 0.10;
    }
}