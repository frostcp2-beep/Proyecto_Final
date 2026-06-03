import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Vehiculo taxi   = new Taxi();
        Vehiculo van    = new Vans();
        Vehiculo buseta = new Buseta();

        Rutas autopista  = new Rutas("Medellin-Rionegro", 90,  true,  5, 8, 10);
        Rutas santaElena = new Rutas("Via Santa Elena",   100, false, 3, 5,  7);
        Rutas lasPalmas  = new Rutas("Via Las Palmas",    110, false, 4, 6,  8);

        Rutas[] rutas = { autopista, santaElena, lasPalmas };

        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║    TRANSPORTES CHACHAFRUTO - LIQUIDADOR      ║");
        System.out.println("╚══════════════════════════════════════════════╝");

        System.out.println("\nSeleccione el tipo de vehiculo:");
        System.out.println("  1. Taxi   (4 puestos  - $25.000 pasaje)");
        System.out.println("  2. Van    (10 puestos - $17.000 pasaje)");
        System.out.println("  3. Buseta (15 puestos - $12.000 pasaje)");
        System.out.print("Opcion (1-3): ");

        int opcionV = sc.nextInt();
        Vehiculo vehiculoElegido;
        switch (opcionV) {
            case 1:  vehiculoElegido = taxi;   break;
            case 2:  vehiculoElegido = van;    break;
            case 3:  vehiculoElegido = buseta; break;
            default:
                System.out.println("Opcion invalida. Se usara Taxi.");
                vehiculoElegido = taxi;
        }

        System.out.println("\nSeleccione la ruta:");
        System.out.println("  1. Autopista Medellin-Bogota (90 km)");
        System.out.println("  2. Via Santa Elena (100 km)");
        System.out.println("  3. Via Las Palmas (110 km)");
        System.out.print("Opcion (1-3): ");

        int opcionR = sc.nextInt();
        Rutas rutaElegida = rutas[Math.max(0, Math.min(opcionR - 1, 2))];
        System.out.println("Ruta seleccionada: " + rutaElegida.obNombreRuta());

        // Scanner se pasa a Empresa — NO se cierra aquí
        // Si lo cerramos aquí, Empresa no puede leer del teclado
        Empresa empresa = new Empresa("Transportes Chachafruto", vehiculoElegido, rutaElegida);
        empresa.simulacionSemana(sc);
        empresa.matrizRentabilidad();
        empresa.imprimirPromedio();

        sc.close(); // Se cierra al final de todo
    }
}