package Model.CRUD.Repository.Entities;

public class PassengerVagonEntity {
    private String idVagon;
    private Boolean[] premium;
    private Boolean[] executive;
    private Boolean[] standard;

    public PassengerVagonEntity(String idVagon, Boolean[] premium, Boolean[] executive, Boolean[] standard) {
        this.idVagon = idVagon;
        this.premium = premium;
        this.executive = executive;
        this.standard = standard;
    }

    public static PassengerVagonEntity returnNullPassengerVagon() {
        return new PassengerVagonEntity("", new Boolean[4], new Boolean[8], new Boolean[28]);
    }

    public String getIdVagon() {
        return idVagon;
    }

    public void setIdVagon(String idVagon) {
        this.idVagon = idVagon;
    }

    public Boolean[] getPremium() {
        return premium;
    }

    public void setPremium(Boolean[] premium) {
        this.premium = premium;
    }

    public Boolean[] getExecutive() {
        return executive;
    }

    public void setExecutive(Boolean[] executive) {
        this.executive = executive;
    }

    public Boolean[] getStandard() {
        return standard;
    }

    public void setStandard(Boolean[] standard) {
        this.standard = standard;
    }
}
