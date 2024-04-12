package Model.CRUD.Repository.Entities;

public class PassengerEntity {
    private String idPassenger;
    private String idType;
    private String names;
    private String lastNames;
    private String phoneNumbers;
    private String homeAdress;

    public PassengerEntity(String idPassenger, String idType, String names, String lastNames, String phoneNumbers, String homeAdress) {
        this.idPassenger = idPassenger;
        this.idType = idType;
        this.names = names;
        this.lastNames = lastNames;
        this.phoneNumbers = phoneNumbers;
        this.homeAdress = homeAdress;
    }

    public String getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(String idPassenger) {
        this.idPassenger = idPassenger;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getHomeAdress() {
        return homeAdress;
    }

    public void setHomeAdress(String homeAdress) {
        this.homeAdress = homeAdress;
    }
}
