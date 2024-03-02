/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

/**
 *
 * @author admin
 */
public class Pasajero extends Usuario{
    private String personaContacto;
    private int numeroContacto;

    public Pasajero(String personaContacto, int numeroContacto, int idUsuario, String nombreCompleto, int numIdentificacion, String residencia, int telefono) {
        super(idUsuario, nombreCompleto, numIdentificacion, residencia, telefono);
        this.personaContacto = personaContacto;
        this.numeroContacto = numeroContacto;
    }
    
    
}
