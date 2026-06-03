import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        Vehiculo vehiculo = null;
        Rutas ruta = null;
        
        double totalIngresos = 0;
        double totalGastos = 0;
        double totalRentabilidad = 0;

        // SELECCIONAR VEHICULO
        int opcionVehiculo = Integer.parseInt(JOptionPane.showInputDialog("Seleccione vehículo:\n"+ "1. Taxi\n"+ "2. Vans\n"+ "3. Buseta"));

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
            default:JOptionPane.showMessageDialog(null,"Opción inválida");
                System.exit(0);
        }
        // SELECCIONAR RUTA
        int opcionRuta = Integer.parseInt(JOptionPane.showInputDialog("Seleccione ruta:\n"+ "1. Medellin-Rionegro\n" + "2. Santa Elena\n"+ "3. Las Palmas"));

        switch (opcionRuta) {

            case 1:
                ruta = new Rutas("Medellin-Rionegro", 45, true,15,20,10);
                break;

            case 2:
                ruta = new Rutas("Santa Elena",50, false, 0,0, 0);
                break;

            case 3:
                ruta = new Rutas("Las Palmas", 55,false,0,0, 0);
                break;

            default:JOptionPane.showMessageDialog(null,"Ruta inválida");
                System.exit(0);
        }
        // ORDEN DEL RECORRIDO
        int ordenRecorrido = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el orden del recorrido:\n\n" + "1. SUBIDA → BAJADA\n" + "2. BAJADA → SUBIDA"));
        
        // EVENTOS (SE PREGUNTA UNA VEZ)
        // EVENTOS DE SUBIDA
        int eventosSubida = 0;
        int[] kmSubida = null;

        // EVENTOS DE BAJADA
        int eventosBajada = 0;
        int[] kmBajada = null;

        if (!(vehiculo instanceof Taxi)) {

            eventosSubida = Integer.parseInt( JOptionPane.showInputDialog("¿Cuántos eventos tiene SUBIDA?"));

            kmSubida = new int[eventosSubida];

            for (int i = 0; i < eventosSubida; i++) {

             kmSubida[i] = Integer.parseInt(JOptionPane.showInputDialog("Km del evento " + (i + 1) + " de SUBIDA"));
    }

             eventosBajada = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos eventos tiene BAJADA?"));

                kmBajada = new int[eventosBajada];

                for (int i = 0; i < eventosBajada; i++) {

                kmBajada[i] = Integer.parseInt(JOptionPane.showInputDialog("Km del evento " + (i + 1) + " de BAJADA"));
    }
}
        // CICLO DE 6 DIAS
        for (int dia = 1; dia <= 6; dia++) {
            // 2 recorridos por día
            for (int recorrido = 1;recorrido <= 2;recorrido++) {
                boolean esSubida;
                // Orden recorrido
                if (ordenRecorrido == 1) {
                    // SUBIDA → BAJADA
                    esSubida =(recorrido == 1);
                } else {
                    // BAJADA → SUBIDA
                    esSubida =(recorrido == 2);
                }
                int pasajeros;
                // TAXI
                if (vehiculo instanceof Taxi) {
                    pasajeros = 4;
                } else {
                    // PASAJEROS INICIALES
                    boolean datoCorrecto =false;
                    pasajeros = 0;
                    while (!datoCorrecto) {//el "?" actua como un if y else si no se cumple la funcion subida → bajada entonces aplica bajada → subida
                        pasajeros =Integer.parseInt(JOptionPane.showInputDialog( "Día " + dia + "\n"+ (esSubida ? "SUBIDA": "BAJADA") + "\n\nIngrese pasajeros iniciales:"));
                        if (pasajeros <= vehiculo.obCapacidadMax()) {
                            datoCorrecto = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Capacidad máxima excedida.\n" + "Ingrese nuevamente.");
                        }
                    }
                    // EVENTOS
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

                    boolean eventoCorrecto = false;

                    while (!eventoCorrecto) {

                    int nuevosPasajeros =Integer.parseInt(JOptionPane.showInputDialog( "Día " + dia+ "\n"+ (esSubida ? "SUBIDA" : "BAJADA")+ "\nEvento "+ (i + 1)+ " (Km " + km + ")"+ "\n¿Cuántos pasajeros suben?"));

                         if ((pasajeros + nuevosPasajeros)
                            <= vehiculo.obCapacidadMax()) {

                        pasajeros += nuevosPasajeros;
                        eventoCorrecto = true;

                         } else {

                             JOptionPane.showMessageDialog(null,"Capacidad excedida.\n" + "Ingrese nuevamente el mismo evento.");
        }
    }
}
                }
                // CALCULOS
                double gasto =vehiculo.calcularGastoGasolina(ruta,pasajeros,esSubida);
                double ingresos =vehiculo.calcularIngresos(pasajeros);
                double rentabilidad =vehiculo.calcularRentabilidad(ingresos, gasto);               
                // ACUMULAR              
                totalIngresos += ingresos;
                totalGastos += gasto;
                totalRentabilidad += rentabilidad;
            }
        }    
        double promedioRentabilidad = totalRentabilidad / 12;
        // RESULTADO FINAL
        JOptionPane.showMessageDialog( null,"RESULTADO TOTAL DEL PERIODO\n\n" + "Vehículo: "+ vehiculo.obTipo() + "\nRuta: "+ ruta.obNombreRuta()+ "\nOrden del recorrido: "+ (ordenRecorrido == 1 ? "SUBIDA → BAJADA": "BAJADA → SUBIDA")
                + "\n\nPeriodo evaluado: 6 días"+ "\nRecorridos realizados: 12"+ "\n\nIngresos Totales: $" + String.format("%.2f", totalIngresos)
                + "\nGastos Totales: $"+ String.format("%.2f",totalGastos)+ "\nRentabilidad Total: $" + String.format("%.2f",totalRentabilidad)+ "\nPromedio de Rentabilidad: $"+ String.format("%.2f", promedioRentabilidad));
    }
}