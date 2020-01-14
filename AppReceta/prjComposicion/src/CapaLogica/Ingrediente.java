package CapaLogica;

public class Ingrediente {
    private String nombreIngrediente;
    public Ingrediente(String nombreIngrediente) {
        this.setNombreIngrediente(nombreIngrediente);
    }
    public String toString(){
        return this.getNombreIngrediente();
    }
    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }
    
}
