
public class Empresa {
    private String nombre;
    private Vehiculo vehiculo;

    public Empresa(
            String nombre,
            Vehiculo vehiculo) {

        this.nombre = nombre;
        this.vehiculo = vehiculo;
    }

    public void matrizRentabilidad() {

        System.out.println(
                "Matriz");
    }

    public void simulacionSemana() {

        System.out.println(
                "Simulacion Semanal");
    }

    public void imprimirPromedio() {

        System.out.println(
                "Promedio");
    }
    
}
