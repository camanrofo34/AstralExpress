/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.controlador;

import org.astralexpress.modelo.TrainsModel;
import org.astralexpress.vista.TrainsView;

/**
 *
 * @author admin
 */
public class TrainsController {
    TrainsView TV;
    TrainsModel TM;
    
    public TrainsController(TrainsModel TM, TrainsView TV){
        this.TV = TV;
        this.TM = TM;
    }
    
    public void start(){
        TV.initComponents();
    }
}
