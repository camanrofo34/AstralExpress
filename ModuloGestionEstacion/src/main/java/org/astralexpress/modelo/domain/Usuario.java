/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

/**
 *
 * @author admin
 */
public class Usuario {
    private String username;
    private String password;
    private AbstractPerson person;

    public Usuario(String username, String password, AbstractPerson person) {
        this.username = username;
        this.password = password;
        this.person = person;
        
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
    
    public static Usuario getNullUser(){
        return new Usuario ("", "", new AbstractPerson() {});
    }
    
}
