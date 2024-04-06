/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.controlador;

import java.util.function.UnaryOperator;
import org.astralexpress.modelo.ModuloModel;
import org.astralexpress.modelo.RMISettings;
import org.astralexpress.modelo.TrainsModel;
import org.astralexpress.vista.ModuloView;
import org.astralexpress.vista.TrainsView;
import org.model.array.Array;

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

    public void start() {
        MV.initComponents(
                new Array<>(new UnaryOperator[]{
            event -> {
                TrainsController TC = new TrainsController(new TrainsModel(RMISettings.getInstance().getRMIAddress()), new TrainsView());
                TC.start();
                return null;
            },
            event -> {

                return null;
            }
        })
        );
    }

}
