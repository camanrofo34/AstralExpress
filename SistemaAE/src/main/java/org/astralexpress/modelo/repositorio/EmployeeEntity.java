/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.repositorio;

import java.io.Serializable;

/**
 * @author admin
 */
public class EmployeeEntity implements Serializable {
    String id;
    String names;
    String lastNames;
    String phoneNumbers;

    public EmployeeEntity(String id, String names, String lastNames, String phoneNumbers) {
        this.id = id;
        this.names = names;
        this.lastNames = lastNames;
        this.phoneNumbers = phoneNumbers;
    }


}
