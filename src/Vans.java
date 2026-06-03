public class Vans extends Vehiculo {

    // Constructor
    public Vans() {

        super( "Vans",40, 17000,10,19500);//el "SUPER" le dara los atributos a la plantilla "THIS" de la superclase
    }

    // Recargo pasajeros
    @Override
    public double calcularRecargoPasajeros(int pasajeros) {//aqui el override le da el parametro que va a utilizar este tipo

        return pasajeros * 0.08;
    }

    // Recargo subida
    @Override
    public double calcularRecargoSubida( double gastoBase) {//aqui el override le da el parametro que va a utilizar este tipo

        return gastoBase * 0.15;
    }
}