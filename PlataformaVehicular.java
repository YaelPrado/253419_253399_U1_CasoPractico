public class PlataformaVehicular{

    private Vehiculo[] listaVehiculos;
    private int contador;

    public PlataformaVehicular() {
        this.listaVehiculos = new Vehiculo[5];
        this.contador = 0;
    }

    public int getContador() {
        return contador;
    }


    public boolean agregarVehiculo(Vehiculo vehiculo) {
        if (contador >= 5) {
            System.out.println("Límite alcanzado (máximo 5 vehículos).");
            System.out.println("");
            return false;
        }
        listaVehiculos[contador] = vehiculo;
        contador++;
        System.out.println("Vehículo registrado exitosamente como DISPONIBLE.");
        System.out.println("");
        return true;
    }

    public void buscarVehiculosLibres() {
        System.out.println("\n--- VEHÍCULOS DISPONIBLES ---");
        System.out.println("");
        boolean hayLibres = false;
        for (int i = 0; i < contador; i++) {
            if (listaVehiculos[i].getEstatus()) {
                hayLibres = true;
                System.out.println("Placa: " + listaVehiculos[i].getPlaca() + " | Kilometraje: " + listaVehiculos[i].getKilometraje());
                System.out.println("");
            }
        }
        if (!hayLibres) {
            System.out.println("No hay vehículos disponibles.");
            System.out.println("");
        }
    }

    public boolean asignarChoferAVehiculo(String placa, Chofer chofer) {
        for (int i = 0; i < contador; i++) {
            if (listaVehiculos[i].getPlaca().equalsIgnoreCase(placa)) {
                if (!listaVehiculos[i].getEstatus()) {
                    System.out.println("El vehículo ya está ocupado.");
                    System.out.println("");
                    return false;
                }
                listaVehiculos[i].setConductor(chofer);
                listaVehiculos[i].setEstatus(false);
                System.out.println("Chofer asignado exitosamente. El vehículo ahora está OCUPADO.");
                System.out.println("");
                return true;
            }
        }
        System.out.println("Vehículo no encontrado.");
        System.out.println("");
        return false;
    }

    public void mostrarVehiculos() {
        for (int i = 0; i < contador; i++) {
            Vehiculo v = listaVehiculos[i];
            System.out.println("Placa: " + v.getPlaca() + " | KM: " + v.getKilometraje() + " | Estatus: " + (v.getEstatus() ? "Disponible" : "Ocupado"));
            System.out.println("");
            if (v.getConductor() != null) {
                System.out.println("  Chofer: " + v.getConductor().getNombre() + " | Licencia: " + v.getConductor().getLicencia());
                System.out.println("");
            } else {
                System.out.println("  Chofer: Sin asignar");
                System.out.println("");
            }
        }
    }
}