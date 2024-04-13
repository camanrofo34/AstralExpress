package Model.Domain.AbstractClasses;

import java.io.Serializable;

public abstract class AbstractVagon implements Serializable {
    protected String idVagon;

    protected AbstractVagon() {
        this.idVagon = "";
    }

    protected AbstractVagon(String idVagon) {
        this.idVagon = idVagon;
    }

    public String getIdVagon() {
        return idVagon;
    }

    public void setIdVagon(String idVagon) {
        this.idVagon = idVagon;
    }
}
