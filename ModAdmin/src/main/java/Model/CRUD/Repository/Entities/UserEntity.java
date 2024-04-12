package Model.CRUD.Repository.Entities;

public class UserEntity {
    private String username;
    private String password;
    private String idPerson;

    public UserEntity(String username, String password, String idPerson) {
        this.username = username;
        this.password = password;
        this.idPerson = idPerson;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }
}
