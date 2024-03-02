/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

import org.model.array.Array;

/**
 *
 * @author admin
 */
public class Empleado extends AbstractPerson{
    private String idEmpleado;
    
    public Empleado() {
        this.idEmpleado = "";
    }

    public Empleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(String idEmpleado, String names, String lastNames, Array<String> phoneNumbers) {
        super(names, lastNames, phoneNumbers);
        this.idEmpleado = idEmpleado;
    }
    
    public static Empleado getNullEmployee() {
        return new Empleado();
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
}
