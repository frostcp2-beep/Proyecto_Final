
public class Rutas {

    // Atributos
    private String nombreRuta;
    private double distancia;
    private boolean autopista;

    private double kmMarcha1;
    private double kmMarcha2;
    private double kmMarcha3;

    // Constructor
    public Rutas(String nombreRuta,double distancia,boolean autopista,double kmMarcha1,double kmMarcha2,double kmMarcha3) {

        this.nombreRuta = nombreRuta;
        this.distancia = distancia;
        this.autopista = autopista;
        this.kmMarcha1 = kmMarcha1;
        this.kmMarcha2 = kmMarcha2;
        this.kmMarcha3 = kmMarcha3;
    }

    // Getters

    public String obNombreRuta() {
        return nombreRuta;
    }

    public double obDistancia() {
        return distancia;
    }

    public boolean esAutopista() {
        return autopista;
    }

    public double obKmMarcha1() {
        return kmMarcha1;
    }

    public double obKmMarcha2() {
        return kmMarcha2;
    }

    public double obKmMarcha3() {
        return kmMarcha3;
    }

    // Setters

    public void modNombreRuta(String nombreRuta) {

        this.nombreRuta = nombreRuta;
    }

    public void modDistancia(double distancia) {

        this.distancia = distancia;
    }

    public void modAutopista(boolean autopista) {

        this.autopista = autopista;
    }

    public void modKmMarcha1(double kmMarcha1) {

        this.kmMarcha1 = kmMarcha1;
    }

    public void modKmMarcha2(double kmMarcha2) {

        this.kmMarcha2 = kmMarcha2;
    }

    public void modKmMarcha3(double kmMarcha3) {

        this.kmMarcha3 = kmMarcha3;
    }
}
