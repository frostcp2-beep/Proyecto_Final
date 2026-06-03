import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        Vehiculo vehiculo = null;
        Rutas ruta = null;

        double totalIngresos = 0;
        double totalGastos = 0;
        double totalRentabilidad = 0;
        double[][] matrizRentabilidad = new double[6][2];
        String[] diasSemana = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};

        int opcionVehiculo = leerEntero("Seleccione vehiculo:\n"
                + "1. Taxi\n"
                + "2. Vans\n"
                + "3. Buseta", 1, 3);

        switch (opcionVehiculo) {

            case 1:
                vehiculo = new Taxi();
                break;
            case 2:
                vehiculo = new Vans();
                break;
            case 3:
                vehiculo = new Buseta();
                break;
        }

        int opcionRuta = leerEntero("Seleccione ruta:\n"
                + "1. Medellin-Rionegro / Rionegro-Medellin\n"
                + "2. Santa Elena\n"
                + "3. Las Palmas", 1, 3);

        switch (opcionRuta) {

            case 1:
                ruta = new Rutas("Medellin-Rionegro", 45, true, 0, 0, 0);
                pedirKilometrosMarchas(ruta);
                break;
            case 2:
                ruta = new Rutas("Santa Elena", 50, false, 0, 0, 0);
                break;
            case 3:
                ruta = new Rutas("Las Palmas", 55, false, 0, 0, 0);
                break;
        }

        int ordenRecorrido = leerEntero("Seleccione el orden del recorrido:\n\n"
                + "1. SUBIDA -> BAJADA\n"
                + "2. BAJADA -> SUBIDA", 1, 2);

        int eventosSubida = 0;
        int[] kmSubida = null;
        int eventosBajada = 0;
        int[] kmBajada = null;

        if (!(vehiculo instanceof Taxi)) {

            eventosSubida = leerEntero("Cuantos eventos tiene SUBIDA?", 0, Integer.MAX_VALUE);
            kmSubida = new int[eventosSubida];

            for (int i = 0; i < eventosSubida; i++) {
                kmSubida[i] = leerEntero("Km del evento " + (i + 1) + " de SUBIDA",
                        0, (int) ruta.obDistancia());
            }

            eventosBajada = leerEntero("Cuantos eventos tiene BAJADA?", 0, Integer.MAX_VALUE);
            kmBajada = new int[eventosBajada];

            for (int i = 0; i < eventosBajada; i++) {
                kmBajada[i] = leerEntero("Km del evento " + (i + 1) + " de BAJADA",
                        0, (int) ruta.obDistancia());
            }
        }

        double ingresosDia = 0;
        double gastosDia = 0;
        double rentabilidadDia = 0;
        double[] rentabilidadRecorridoBase = new double[2];

        for (int recorrido = 1; recorrido <= 2; recorrido++) {

            boolean esSubida;

            if (ordenRecorrido == 1) {
                esSubida = (recorrido == 1);
            } else {
                esSubida = (recorrido == 2);
            }

            int pasajeros;

            if (vehiculo instanceof Taxi) {
                pasajeros = vehiculo.obCapacidadMax();
            } else {
                pasajeros = leerEntero("Dia base\n"
                        + (esSubida ? "SUBIDA" : "BAJADA")
                        + "\n\nIngrese pasajeros iniciales:",
                        0, vehiculo.obCapacidadMax());

                int[] kmActual;
                int cantidadEventos;

                if (esSubida) {
                    kmActual = kmSubida;
                    cantidadEventos = eventosSubida;
                } else {
                    kmActual = kmBajada;
                    cantidadEventos = eventosBajada;
                }

                for (int i = 0; i < cantidadEventos; i++) {

                    int km = kmActual[i];
                    int cuposDisponibles = vehiculo.obCapacidadMax() - pasajeros;

                    int nuevosPasajeros = leerEntero("Dia base\n"
                            + (esSubida ? "SUBIDA" : "BAJADA")
                            + "\nEvento " + (i + 1) + " (Km " + km + ")"
                            + "\nCuantos pasajeros suben?",
                            0, cuposDisponibles);

                    pasajeros += nuevosPasajeros;
                }
            }

            double gasto = vehiculo.calcularGastoGasolina(ruta, pasajeros, esSubida);
            double ingresos = vehiculo.calcularIngresos(pasajeros);
            double rentabilidad = vehiculo.calcularRentabilidad(ingresos, gasto);

            ingresosDia += ingresos;
            gastosDia += gasto;
            rentabilidadDia += rentabilidad;

            if (esSubida) {
                rentabilidadRecorridoBase[0] = rentabilidad;
            } else {
                rentabilidadRecorridoBase[1] = rentabilidad;
            }
        }

        for (int dia = 0; dia < 6; dia++) {
            matrizRentabilidad[dia][0] = rentabilidadRecorridoBase[0];
            matrizRentabilidad[dia][1] = rentabilidadRecorridoBase[1];
        }

        totalIngresos = ingresosDia * 6;
        totalGastos = gastosDia * 6;
        totalRentabilidad = rentabilidadDia * 6;

        double promedioRentabilidad = totalRentabilidad / 12;

        JOptionPane.showMessageDialog(null, construirResultadoFinal(
                vehiculo,
                ruta,
                ordenRecorrido,
                totalIngresos,
                totalGastos,
                totalRentabilidad,
                promedioRentabilidad,
                matrizRentabilidad,
                diasSemana));
    }

    private static void pedirKilometrosMarchas(Rutas ruta) {

        while (true) {

            int kmMarcha1 = leerEntero("Km recorridos en cambio 1 para la subida Medellin-Rionegro:",
                    0, (int) ruta.obDistancia());
            int kmMarcha2 = leerEntero("Km recorridos en cambio 2 para la subida Medellin-Rionegro:",
                    0, (int) ruta.obDistancia());
            int kmMarcha3 = leerEntero("Km recorridos en cambio 3 para la subida Medellin-Rionegro:",
                    0, (int) ruta.obDistancia());

            if (kmMarcha1 + kmMarcha2 + kmMarcha3 <= ruta.obDistancia()) {
                ruta.modKmMarcha1(kmMarcha1);
                ruta.modKmMarcha2(kmMarcha2);
                ruta.modKmMarcha3(kmMarcha3);
                return;
            }

            JOptionPane.showMessageDialog(null, "La suma de kilometros en cambios no puede exceder "
                    + (int) ruta.obDistancia() + " km.");
        }
    }

    private static String construirResultadoFinal(Vehiculo vehiculo,
            Rutas ruta,
            int ordenRecorrido,
            double totalIngresos,
            double totalGastos,
            double totalRentabilidad,
            double promedioRentabilidad,
            double[][] matrizRentabilidad,
            String[] diasSemana) {

        StringBuilder resultado = new StringBuilder();

        resultado.append("RESULTADO TOTAL DEL PERIODO\n\n");
        resultado.append("Vehiculo: ").append(vehiculo.obTipo()).append("\n");
        resultado.append("Ruta: ").append(ruta.obNombreRuta()).append("\n");
        resultado.append("Orden del recorrido: ")
                .append(ordenRecorrido == 1 ? "SUBIDA -> BAJADA" : "BAJADA -> SUBIDA")
                .append("\n\n");
        resultado.append("MATRIZ DE RENTABILIDAD\n");
        resultado.append("Dia                 Subida          Bajada\n");

        for (int i = 0; i < matrizRentabilidad.length; i++) {
            resultado.append(String.format("%-12s $%12.2f $%12.2f%n",
                    diasSemana[i],
                    matrizRentabilidad[i][0],
                    matrizRentabilidad[i][1]));
        }

        resultado.append("\nPeriodo evaluado: 6 dias");
        resultado.append("\nRecorridos realizados: 12");
        resultado.append("\n\nIngresos Totales: $").append(String.format("%.2f", totalIngresos));
        resultado.append("\nGastos Totales: $").append(String.format("%.2f", totalGastos));
        resultado.append("\nRentabilidad Total: $").append(String.format("%.2f", totalRentabilidad));
        resultado.append("\nPromedio de Rentabilidad: $").append(String.format("%.2f", promedioRentabilidad));

        return resultado.toString();
    }

    private static int leerEntero(String mensaje, int minimo, int maximo) {

        while (true) {

            String entrada = JOptionPane.showInputDialog(mensaje);

            if (entrada == null) {
                JOptionPane.showMessageDialog(null, "Programa finalizado por el usuario.");
                System.exit(0);
            }

            try {
                int valor = Integer.parseInt(entrada.trim());

                if (valor >= minimo && valor <= maximo) {
                    return valor;
                }

                JOptionPane.showMessageDialog(null, "Ingrese un valor entre " + minimo + " y " + maximo + ".");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un numero entero valido.");
            }
        }
    }
}
