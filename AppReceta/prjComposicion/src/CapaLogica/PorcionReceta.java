package CapaLogica;

import java.text.DecimalFormat;

public class PorcionReceta {
    /**
     * @aggregation shared
     */
    private Ingrediente ingrediente;
    private double cantidad;
    private double precioUnidad;
    private UnidadMedida unidadMedida;

    public PorcionReceta(Ingrediente ingrediente, double cantidad, double precioUnidad, UnidadMedida unidadMedida) {
        this.ingrediente = ingrediente;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
        this.unidadMedida = unidadMedida;
    }
    public double costoPorcion(){
        return this.precioUnidad*this.cantidad;
    }
    public String toString(){
        DecimalFormat formato=new DecimalFormat("#,##0.##");
        return formato.format(this.cantidad)+" "+this.getIngrediente().toString()+" con el precio unitario de : "+this.precioUnidad+" Total: ¢"+this.costoPorcion();
    }
    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }
}
