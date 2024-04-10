package Model.Domain;

import Model.Domain.AbstractClasses.AbstractPerson;

public class User {
    private String username;
    private String password;
    private AbstractPerson person;

    public User(String username, String password, AbstractPerson person) {
        this.username = username;
        this.password = password;
        this.person = person;
    }

    public static User getNullUser() {
        return new User("", "", new AbstractPerson() {
        });
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

    public AbstractPerson getPerson() {
        return person;
    }

    public void setPerson(AbstractPerson person) {
        this.person = person;
    }

}
