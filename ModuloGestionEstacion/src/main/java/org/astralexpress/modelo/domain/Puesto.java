/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

/**
 *
 * @author PC 4060TI
 */
public class Puesto {
    private String idPuesto;
    private ClasePuesto clase;
    
    private enum ClasePuesto { Estandar, Ejecutivo, Premium }
}
