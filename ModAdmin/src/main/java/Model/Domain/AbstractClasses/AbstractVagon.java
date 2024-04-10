package Model.Domain.AbstractClasses;

public abstract class AbstractVagon {
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
