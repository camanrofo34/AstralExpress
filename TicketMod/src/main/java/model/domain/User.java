package model.domain;

import model.domain.abstractClasses.AbstractPerson;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private AbstractPerson person;

    private Boolean isAdmin;

    public User(String username, String password, Boolean isAdmin, AbstractPerson person) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.person = person;
    }

    public static User getNullUser() {
        return new User("", "", false, new AbstractPerson() {
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

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

}
