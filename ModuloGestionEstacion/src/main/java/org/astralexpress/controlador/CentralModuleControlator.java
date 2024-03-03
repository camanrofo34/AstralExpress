/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.controlador;

import javax.swing.JLayeredPane;
import org.astralexpress.vista.CentralModuleView;
import org.astralexpress.vista.TrainModuleTableView;

/**
 *
 * @author PC 4060TI
 */
public class CentralModuleControlator {
    private CentralModuleView CE;
    private TrainModuleTableView TMT;

    public CentralModuleControlator(CentralModuleView CE) {
        this.CE = CE;
        this.TMT = new TrainModuleTableView();
    }

    public void TrainModuleButton() {
        System.out.println("TrainModuleButton called");
        TMT.setVisible(true);
    }
}
