package CapaLogica;

public enum TipoReceta {
    PANES,
    REPOSTERIA,
    MARISCOS,
    CARNES,
    ARROCES,
    POSTRES_Y_DULCES {
        public String toString() {
            return "Postres y Dulces";
        }
    }
}
