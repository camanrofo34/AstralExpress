/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.controlador;

import org.astralexpress.modelo.RMISettings;
import org.astralexpress.modelo.TrainsModel;
import org.astralexpress.modelo.UsersModel;
import org.astralexpress.modelo.domain.Train;
import org.astralexpress.vista.TrainsView;
import org.astralexpress.vista.UsersView;
import org.model.array.Array;
import org.model.io.LinkedList.LinkedList;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.function.UnaryOperator;

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
    
    public void start() throws MalformedURLException, NotBoundException, RemoteException {
        TV.initComponents(new Array<>(new UnaryOperator[]{
                event -> {

                     return null;
                },
                event -> {
                    return null;
                },
                event -> {
                    return null;
                }
        }), (LinkedList<Train>) TM.getTrains());
    }
}
