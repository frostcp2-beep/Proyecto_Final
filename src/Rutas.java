public class Rutas {

    // ─── ATRIBUTOS ───────────────────────────────────────────
    // Esta clase estaba bien estructurada.
    // No se cambia nada en la lógica, solo se agregan comentarios.

    private String  nombreRuta;
    private double  distancia;
    private boolean autopista;

    // Kilómetros en cada marcha durante la SUBIDA (Medellín→Rionegro)
    // Solo aplican en esa dirección porque es la que requiere más fuerza
    private double kmMarcha1; // tramos en 1ª → consume 3% más por km
    private double kmMarcha2; // tramos en 2ª → consume 2% más por km
    private double kmMarcha3; // tramos en 3ª → consume 1% más por km


    // ─── CONSTRUCTOR ─────────────────────────────────────────
    public Rutas(String nombreRuta, double distancia, boolean autopista,
                 double kmMarcha1, double kmMarcha2, double kmMarcha3) {

        this.nombreRuta = nombreRuta;
        this.distancia  = distancia;
        this.autopista  = autopista;
        this.kmMarcha1  = kmMarcha1;
        this.kmMarcha2  = kmMarcha2;
        this.kmMarcha3  = kmMarcha3;
    }


    // ─── GETTERS ──────────────────────────────────────────────
    // Nota: los nombres "ob..." los dejamos igual para no romper
    // las referencias que ya tiene el resto del código.

    public String  obNombreRuta() { return nombreRuta; }
    public double  obDistancia()  { return distancia; }
    public boolean esAutopista()  { return autopista; }
    public double  obKmMarcha1()  { return kmMarcha1; }
    public double  obKmMarcha2()  { return kmMarcha2; }
    public double  obKmMarcha3()  { return kmMarcha3; }


    // ─── SETTERS ──────────────────────────────────────────────
    // Permiten modificar los valores después de crear el objeto.
    // Útil si en el futuro cambian las condiciones de una ruta.

    public void modNombreRuta(String nombreRuta) { this.nombreRuta = nombreRuta; }
    public void modDistancia(double distancia)   { this.distancia  = distancia; }
    public void modAutopista(boolean autopista)  { this.autopista  = autopista; }
    public void modKmMarcha1(double kmMarcha1)   { this.kmMarcha1  = kmMarcha1; }
    public void modKmMarcha2(double kmMarcha2)   { this.kmMarcha2  = kmMarcha2; }
    public void modKmMarcha3(double kmMarcha3)   { this.kmMarcha3  = kmMarcha3; }
}