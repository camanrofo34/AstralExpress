/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

/**
 *
 * @author PC 4060TI
 */
public abstract class AbstractVagon {
    protected String idVagon;

    public AbstractVagon(String idVagon) {
        this.idVagon = idVagon;
    }

    public String getIdVagon() {
        return idVagon;
    }

    public void setIdVagon(String idVagon) {
        this.idVagon = idVagon;
    }
    
}
