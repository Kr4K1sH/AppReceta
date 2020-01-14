package CapaLogica;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

public class Receta {
    private static int cantRecetas = 0;
    private int numReceta;
    private String nombreReceta;
    private String preparacion;
    private TipoReceta tipo;
    private Autor objAutor;
    private Date fechaRegistro;

    /**
     * @aggregation composite
     */
    private ArrayList<PorcionReceta> arrayPorcIngrediente;

    public Receta() {
        this.numReceta = ++cantRecetas;
        this.fechaRegistro = new Date();
        this.tipo = null;
        this.arrayPorcIngrediente=new ArrayList<PorcionReceta>();
    }
    //Composicion de las porciones de la receta

    public void agregarPocionIngrediente(Ingrediente ingrediente, double cantidad,double precioUnidad,UnidadMedida unidad) {
        //Construir el objeto
        PorcionReceta porcion = new PorcionReceta(ingrediente, cantidad, precioUnidad, unidad);
        //Agregar al ARRAY
        this.arrayPorcIngrediente.add(porcion);
            
   
    }
    public double calculaCostoReceta(){
        double total=0;
        for (PorcionReceta porcionReceta : arrayPorcIngrediente) {
            total+=porcionReceta.costoPorcion();
        }
        return total;
    }
    public String toString(){
    SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
        String hilera="\nReceta Num. "+this.numReceta+"\nFecha Registro: "+formato.format(this.fechaRegistro)+"\nNombre Receta: "+this.nombreReceta+
            "\nAutor: "+this.getObjAutor().toString()+"\nTipo de receta: "+this.getTipo().toString();
        if(arrayPorcIngrediente.size()>0){
            for (PorcionReceta porcionReceta : arrayPorcIngrediente) {
                hilera+="\n"+porcionReceta.toString();
            }
        }else{
            hilera+="\nNo hay ingredientes";
        }
        hilera+="\n----------------------------";
        hilera+="\nPreparación: \n"+this.preparacion;
        hilera+="\nCosto Total receta:"+formato.format(this.calculaCostoReceta());
        return hilera;
    }
    public void setNumReceta(int numReceta) {
        this.numReceta = numReceta;
    }

    public int getNumReceta() {
        return numReceta;
    }

    public void setNombreReceta(String nombreReceta) {
        this.nombreReceta = nombreReceta;
    }

    public String getNombreReceta() {
        return nombreReceta;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setTipo(TipoReceta tipo) {
        this.tipo = tipo;
    }

    public TipoReceta getTipo() {
        return tipo;
    }

    public void setObjAutor(Autor objAutor) {
        this.objAutor = objAutor;
    }

    public Autor getObjAutor() {
        return objAutor;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setArrayPorcIngrediente(ArrayList<PorcionReceta> arrayPorcIngrediente) {
        this.arrayPorcIngrediente = arrayPorcIngrediente;
    }

    public ArrayList<PorcionReceta> getArrayPorcIngrediente() {
        return arrayPorcIngrediente;
    }
}
