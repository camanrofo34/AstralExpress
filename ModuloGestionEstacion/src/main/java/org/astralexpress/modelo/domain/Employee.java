/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

import org.model.io.array.Array;



/**
 *
 * @author admin
 */
public class Employee extends AbstractPerson{
    private String idEmployee;
    
    public Employee() {
        this.idEmployee = "";
    }

    public Employee(String idEmpleado) {
        this.idEmployee = idEmpleado;
    }

    public Employee(String names, String lastNames, Array<String> phoneNumbers) {
        super(names, lastNames, phoneNumbers);
    }

    public Employee(String idEmployee, String names, String lastNames, Array<String> phoneNumbers) {
        super(names, lastNames, phoneNumbers);
        this.idEmployee = idEmployee;
    }

    public static Employee getNullEmployee() {
        return new Employee();
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }


    
}
