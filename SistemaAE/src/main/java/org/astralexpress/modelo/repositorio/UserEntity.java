/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.repositorio;

import java.io.Serializable;

/**
 * @author admin
 */
public class UserEntity implements Serializable {
    String username;
    String password;
    String person;

    public UserEntity(String username, String password, String person) {
        this.username = username;
        this.password = password;
        this.person = person;
    }

}
