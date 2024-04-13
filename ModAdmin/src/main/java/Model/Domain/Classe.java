package Model.Domain;

import java.io.Serializable;

public enum Classe implements Serializable {
    Estandar(0), Ejecutivo(1), Premium(2);

    private int prioridad;

    private Classe(int prioridad) {
        this.prioridad = prioridad;
    }

    public static Classe findByPriority(String prioridad) {
        for (Classe clase : Classe.values()) {
            if (clase.getPrioridad() == Integer.parseInt(prioridad)) {
                return clase;
            }
        }
        return null;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

}
