/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

import java.io.Serializable;

/**
 *
 * @author PC 4060TI
 */
public abstract class AbstractVagon implements Serializable{
    protected String idVagon;

    public AbstractVagon(String idVagon) {
        this.idVagon = idVagon;
    }
    
    public AbstractVagon() {
        this.idVagon = "";
    }

    public String getIdVagon() {
        return idVagon;
    }

    public void setIdVagon(String idVagon) {
        this.idVagon = idVagon;
    }
    
    
    
}
