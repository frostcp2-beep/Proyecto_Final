
public class Buseta extends Vehiculo {

    // Constructor
    public Buseta() {

        super("Buseta",30, 12000, 15, 22000);//el "SUPER" le dara los atributos a la plantilla "THIS" de la superclase
    }

    // Recargo pasajeros
    @Override
    public double calcularRecargoPasajeros(int pasajeros) {//aqui el override le da el parametro que va a utilizar este tipo

        return pasajeros * 0.12;
    }

    // Recargo subida
    @Override
    public double calcularRecargoSubida( double gastoBase) {//aqui el override le da el parametro que va a utilizar este tipo

        return gastoBase * 0.20;
    }
}

