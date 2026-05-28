
public class Ruta {
    private String nombreRuta;
    private double distancia;
    private boolean autopista;

    public double kmMarcha1;
    public double kmMarcha2;
    public double kmMarcha3;

    public Rutas (String nombreRuta, double distancia, boolean autopista, double kmMarcha1, double kmMarcha2, double kmMarcha3) {
        this.nombreRuta = nombreRuta;
        this.distancia = distancia;
        this.autopista = autopista;
        this.kmMarcha1 = kmMarcha1;
        this.kmMarcha2 = kmMarcha2;
        this.kmMarcha3 = kmMarcha3;
    }
    public String obNombreRuta(){
        return nombreRuta;
    }
    public double obDistancia(){
        return distancia;
    }
    public boolean isAutopista(){
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
    
}
