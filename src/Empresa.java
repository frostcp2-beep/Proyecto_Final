import java.util.Scanner;

public class Empresa {

    // ─── ATRIBUTOS ───────────────────────────────────────────
    private String   nombre;
    private Vehiculo vehiculo;
    private Rutas    ruta;

    // Matriz de rentabilidad semanal
    // matriz[dia][0] = rentabilidad BAJADA (Rionegro→Medellín)
    // matriz[dia][1] = rentabilidad SUBIDA (Medellín→Rionegro)
    private double[][] matriz = new double[6][2];

    // Índices para las columnas — más legible que [0] y [1]
    private static final int BAJADA = 0;
    private static final int SUBIDA = 1;

    // Nombres de los días para el reporte
    private static final String[] DIAS = {
            "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"
    };


    // ─── CONSTRUCTOR ─────────────────────────────────────────
    public Empresa(String nombre, Vehiculo vehiculo, Rutas ruta) {
        this.nombre   = nombre;
        this.vehiculo = vehiculo;
        this.ruta     = ruta;
    }


    // ─── SIMULACIÓN SEMANAL ───────────────────────────────────
    //
    // El enunciado dice "la ruta se hace semanalmente en el mismo recorrido"
    // → se piden los pasajeros UNA sola vez y se repiten los 6 días
    public void simulacionSemana(Scanner sc) {

        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("  EMPRESA: " + nombre);
        System.out.println("  Vehiculo: " + vehiculo.obTipo());
        System.out.println("  Ruta: " + ruta.obNombreRuta());
        System.out.println("═══════════════════════════════════════════");
        System.out.println("\n  Ingrese los pasajeros del recorrido semanal:");

        int pasajerosBajada;
        int pasajerosSubida;

        // ── Taxi: siempre sale lleno, no se pregunta ──────────
        if (vehiculo instanceof Taxi) {
            pasajerosBajada = vehiculo.obCapacidadMax();
            pasajerosSubida = vehiculo.obCapacidadMax();
            System.out.println("  Taxi completo: " + pasajerosBajada + " pasajeros en ambas direcciones");

        } else {
            // ── Van / Buseta: pueden salir con puestos disponibles ──

            // BAJADA
            System.out.print("  Pasajeros BAJADA (0 a " + vehiculo.obCapacidadMax() + "): ");
            pasajerosBajada = leerEntero(sc, 0, vehiculo.obCapacidadMax());

            // Si no salen llenos → preguntar en qué km sube cada pasajero
            // El pasaje es el mismo sin importar el km donde suba
            if (pasajerosBajada < vehiculo.obCapacidadMax() && pasajerosBajada > 0) {
                System.out.println("  En que km sube cada pasajero (bajada):");
                for (int p = 1; p <= pasajerosBajada; p++) {
                    System.out.print("    Pasajero " + p + " sube en el km: ");
                    leerEntero(sc, 0, (int) ruta.obDistancia());
                }
            }

            // SUBIDA
            System.out.print("  Pasajeros SUBIDA (0 a " + vehiculo.obCapacidadMax() + "): ");
            pasajerosSubida = leerEntero(sc, 0, vehiculo.obCapacidadMax());

            // Si no salen llenos → preguntar en qué km sube cada pasajero
            if (pasajerosSubida < vehiculo.obCapacidadMax() && pasajerosSubida > 0) {
                System.out.println("  En que km sube cada pasajero (subida):");
                for (int p = 1; p <= pasajerosSubida; p++) {
                    System.out.print("    Pasajero " + p + " sube en el km: ");
                    leerEntero(sc, 0, (int) ruta.obDistancia());
                }
            }
        }

        // ── Calcular rentabilidad una sola vez ────────────────
        // Como la ruta y pasajeros son los mismos toda la semana,
        // el resultado es idéntico cada día

        // Bajada = Rionegro→Medellín (esSubida = false)
        double gastoB   = vehiculo.calcularGastoGasolina(ruta, pasajerosBajada, false);
        double ingresoB = vehiculo.calcularIngresos(pasajerosBajada);
        double rentB    = vehiculo.calcularRentabilidad(ingresoB, gastoB);

        // Subida = Medellín→Rionegro (esSubida = true)
        double gastoS   = vehiculo.calcularGastoGasolina(ruta, pasajerosSubida, true);
        double ingresoS = vehiculo.calcularIngresos(pasajerosSubida);
        double rentS    = vehiculo.calcularRentabilidad(ingresoS, gastoS);

        // ── Llenar la matriz con el mismo valor los 6 días ────
        // For recorre las 6 filas (días) y asigna bajada y subida
        for (int dia = 0; dia < 6; dia++) {
            matriz[dia][BAJADA] = rentB;
            matriz[dia][SUBIDA] = rentS;
        }

        System.out.printf("%n  Rentabilidad bajada (diaria): $%,.0f%n", rentB);
        System.out.printf("  Rentabilidad subida (diaria): $%,.0f%n", rentS);
    }


    // ─── IMPRIMIR MATRIZ ─────────────────────────────────────
    // Recorre la matriz[6][2] e imprime cada día con su rentabilidad
    // de bajada, subida y total
    public void matrizRentabilidad() {

        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║         MATRIZ DE RENTABILIDAD SEMANAL          ║");
        System.out.println("╠════════════╦══════════════╦══════════════╦══════╣");
        System.out.printf( "║ %-10s ║ %-12s ║ %-12s ║ %-4s ║%n",
                "Dia", "Bajada ($)", "Subida ($)", "Total");
        System.out.println("╠════════════╬══════════════╬══════════════╬══════╣");

        // For externo → días (filas de la matriz)
        // For interno → no es necesario aquí porque sabemos que
        //               columna 0 = bajada, columna 1 = subida
        for (int dia = 0; dia < 6; dia++) {
            double total = matriz[dia][BAJADA] + matriz[dia][SUBIDA];
            System.out.printf("║ %-10s ║ %,12.0f ║ %,12.0f ║%,5.0f ║%n",
                    DIAS[dia], matriz[dia][BAJADA], matriz[dia][SUBIDA], total);
        }

        System.out.println("╚════════════╩══════════════╩══════════════╩══════╝");
    }


    // ─── IMPRIMIR PROMEDIO ────────────────────────────────────
    // Suma todas las celdas de la matriz y divide entre 12 (6 días × 2 viajes)
    public void imprimirPromedio() {

        double suma = 0;

        // Doble for para recorrer TODA la matriz
        // For externo → filas (días)
        // For interno → columnas (bajada y subida)
        for (int dia = 0; dia < matriz.length; dia++) {
            for (int dir = 0; dir < matriz[dia].length; dir++) {
                suma += matriz[dia][dir];
            }
        }

        // 6 días × 2 direcciones = 12 viajes en total
        double promedio = suma / (matriz.length * matriz[0].length);

        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.printf( "║  Total semana:       $%,24.0f      ║%n", suma);
        System.out.printf( "║  Promedio por viaje: $%,24.0f      ║%n", promedio);
        System.out.println("╚══════════════════════════════════════════════════╝");
    }


    // ─── MÉTODO AUXILIAR ─────────────────────────────────────
    // Lee un entero del teclado y valida que esté en el rango [min, max]
    // Si el usuario ingresa algo inválido, vuelve a preguntar
    private int leerEntero(Scanner sc, int min, int max) {
        int valor;
        do {
            while (!sc.hasNextInt()) {
                System.out.print("  Ingrese un numero entero: ");
                sc.next();
            }
            valor = sc.nextInt();
            if (valor < min || valor > max)
                System.out.printf("  Debe ser entre %d y %d: ", min, max);
        } while (valor < min || valor > max);
        return valor;
    }
}