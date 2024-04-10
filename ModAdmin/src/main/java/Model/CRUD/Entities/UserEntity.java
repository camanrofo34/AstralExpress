package Model.CRUD.Entities;

import Model.Domain.AbstractClasses.AbstractPerson;

public class UserEntity {
    String userName;
    String password;
    AbstractPerson person;

    public UserEntity(String userName, String password, AbstractPerson person) {
        this.userName = userName;
        this.password = password;
        this.person = person;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
