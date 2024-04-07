/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.controlador;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.function.UnaryOperator;
import org.astralexpress.modelo.ModuloModel;
import org.astralexpress.modelo.RMISettings;
import org.astralexpress.modelo.TrainsModel;
import org.astralexpress.modelo.UsersModel;
import org.astralexpress.vista.ModuloView;
import org.astralexpress.vista.TrainsView;
import org.astralexpress.vista.UsersView;
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
                TrainsModel TM = new TrainsModel(RMISettings.getInstance().getRMIAddress());
                TrainsController TC = new TrainsController(TM, new TrainsView(TM.getMessenger()));
                try {
                    TC.start();
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (NotBoundException e) {
                    throw new RuntimeException(e);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
                return null;
            },
            event -> {
                UsersModel UM = new UsersModel(RMISettings.getInstance().getRMIAddress());
                UsersController UC = new UsersController(UM, new UsersView(UM.getMessenger()));
                UC.start();
                return null;
            }
        })
        );
    }

}
