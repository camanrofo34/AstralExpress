/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

import org.model.array.Array;
import org.model.util.iterator.Iterator;

/**
 *
 * @author admin
 */
public class ModuloEmpleados {
    Array<Empleado> empleados;

    public ModuloEmpleados() {
        this.empleados = new Array<>(new Empleado[]{
            new Empleado("Cargo1", "Usuario1", "Contraseña1", 1, "Nombre1", 12345, "Residencia1", 111111),
            new Empleado("Cargo2", "Usuario2", "Contraseña2", 2, "Nombre2", 67890, "Residencia2", 222222),
            new Empleado("Cargo3", "Usuario3", "Contraseña3", 3, "Nombre3", 11111, "Residencia3", 333333),
            new Empleado("Cargo4", "Usuario4", "Contraseña4", 4, "Nombre4", 99999, "Residencia4", 444444),
            new Empleado("Cargo5", "Usuario5", "Contraseña5", 5, "Nombre5", 55555, "Residencia5", 555555)
        });
    }
    
    public boolean buscarEmpleado(String name, String password){
        Iterator<Empleado> iterator = empleados.iterator();
        while(iterator.hasNext()){
            Empleado empleado = iterator.next();
            if (empleado.getUsuario().equals(name) && empleado.getContraseña().equals(password)) return true;
        }
        return false;
    }
    
    
    
    
    
}
