package CapaLogica;

public class Autor {
    private String nombre;
    private String telefono;

    public Autor(String nombre, String telefono) {

        this.nombre = nombre;
        this.telefono = telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public String toString() {
        return this.getNombre() + "Telefono: " + this.getTelefono();

    }
}
