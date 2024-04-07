/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo;

import org.astralexpress.modelo.domain.CentralManagerInterface;
import org.astralexpress.modelo.domain.Train;
import org.astralexpress.modelo.messenger.Messenger;
import org.model.util.list.List;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author admin
 */
public class TrainsModel extends AbstractModel{
    private Messenger messenger;

    public TrainsModel(String uri) {
        super(uri);
        this.messenger = new Messenger("");
    }

    public List<Train> getTrains() throws MalformedURLException, NotBoundException, RemoteException {
        CentralManagerInterface lookUp = (CentralManagerInterface) Naming.lookup(uri);
        return lookUp.getTrains();
    }

    public Messenger getMessenger() {
        return messenger;
    }
}
