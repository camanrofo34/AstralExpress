/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.controlador;

import org.astralexpress.modelo.ModuloModel;
import org.astralexpress.vista.ModuloView;

/**
 *
 * @author PC 4060TI
 */
public class ModuloController {
    ModuloModel MM;
    ModuloView MV;

    public ModuloController(ModuloModel MM, ModuloView MV) {
        this.MM = MM;
        this.MV = MV;
    }
    
    public void start(){
        MV.initComponents();
    }

    
}
