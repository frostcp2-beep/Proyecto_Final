
public class Ruta {
    private String nombreRuta;
    private int valorPeaje;
    private int marcha;

    public double distancia;
    public boolean autopista;

    public Rutas (String nombreRuta, int valorPeaje, int marcha, double distancia, boolean autopista) {
        this.nombreRuta = nombreRuta;
        this.valorPeaje = marcha;
        this.distancia = distancia;
        this.autopista = autopista;
    }
    public double obDistancia(){
        return distancia;
    }
    public boolean isAutopista(){
        return autopista;
    }
}
