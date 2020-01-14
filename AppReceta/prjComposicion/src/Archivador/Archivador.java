package Archivador;

import CapaLogica.Ingrediente;

import java.util.ArrayList;
import java.util.List;

public class Archivador {
    private static ArrayList<Ingrediente>arrayIngrediente=new ArrayList<Ingrediente>();

    public static void setArrayIngrediente(ArrayList<Ingrediente> arrayIngrediente) {
        Archivador.arrayIngrediente = arrayIngrediente;
    }

    public static ArrayList<Ingrediente> getArrayIngrediente() {
        return arrayIngrediente;
    }
}
