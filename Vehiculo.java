public class Vehiculo{
private String placa;
private int kilometraje;
private Boolean estatus;
private Chofer conductor;


    public Vehiculo(String placa, int kilometraje) {
        this.placa = placa;
        this.kilometraje = kilometraje;
        this.estatus = true;
        this.conductor = null;
    }

    public String  getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa=placa;
    }

    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus=estatus;
    }

    public int  getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje=kilometraje;
    }

    public Chofer getConductor() { 
        return conductor; 
    }

    public void setConductor(Chofer conductor) {
        this.conductor = conductor; 
    }

}


