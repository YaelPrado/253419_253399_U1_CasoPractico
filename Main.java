import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PlataformaVehicular gestor = new PlataformaVehicular();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("=== SISTEMA DE GESTIÓN DE FLOTILLA ===");
            System.out.println("1. Registrar nuevo vehículo");
            System.out.println("2. Consultar vehículos disponibles");
            System.out.println("3. Asignar chofer a un vehículo");
            System.out.println("4. Mostrar todos los vehículos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            System.out.println("");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    if (gestor.getContador() >= 5) {
                        System.out.println("No se pueden registrar más vehículos. Límite de 5 alcanzado.\n");
                    } else {
                        System.out.println("\n--- REGISTRO DE VEHÍCULO ---");
                        System.out.print("Placa del Vehículo: ");
                        String placa = scanner.nextLine();

                        System.out.print("Kilometraje: ");
                        int kilometraje = scanner.nextInt();
                        scanner.nextLine();

                        Vehiculo nuevoVehiculo = new Vehiculo(placa, kilometraje);
                        gestor.agregarVehiculo(nuevoVehiculo);
                    }
                    break;

                case 2:
                    gestor.buscarVehiculosLibres();
                    break;

                case 3:
                    System.out.println("\n--- ASIGNACIÓN DE CHOFER ---");
                    gestor.buscarVehiculosLibres();
                    
                    System.out.print("Ingrese la placa del vehículo a asignar: ");
                    String placaBuscar = scanner.nextLine();

                    System.out.print("Nombre completo del Chofer: ");
                    String nombreChofer = scanner.nextLine();

                    System.out.print("Número de Licencia del Chofer: ");
                    String licenciaChofer = scanner.nextLine();

                    Chofer chofer = new Chofer(nombreChofer, licenciaChofer);
                    gestor.asignarChoferAVehiculo(placaBuscar, chofer);
                    break;

                case 4:
                    gestor.mostrarVehiculos();
                    break;

                case 5:
                    System.out.println("Saliendo del programa.");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.\n");
                    break;
            }
        }
        scanner.close();
    }
}



