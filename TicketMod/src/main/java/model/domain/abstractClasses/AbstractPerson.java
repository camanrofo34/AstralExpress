package model.domain.abstractClasses;

import dataStructures.Array;

import java.io.Serializable;

public abstract class AbstractPerson implements Serializable {
    protected String idPerson;
    protected String names;
    protected String lastNames;
    protected Array<String> phoneNumbers;

    protected AbstractPerson() {
        this.idPerson = "";
        this.names = "";
        this.lastNames = "";
        this.phoneNumbers = new Array<>(1);
    }

    protected AbstractPerson(String idPerson, String names, String lastNames, Array<String> phoneNumbers) {
        this.idPerson = idPerson;
        this.names = names;
        this.lastNames = lastNames;
        this.phoneNumbers = phoneNumbers;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
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

    public Array<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Array<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getPhoneNumbersString() {
        StringBuilder sb = new StringBuilder();
        int size = phoneNumbers.size();
        for (int i = 0; i < size; i++) {
            sb.append(phoneNumbers.get(i));
            if (i < size - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
