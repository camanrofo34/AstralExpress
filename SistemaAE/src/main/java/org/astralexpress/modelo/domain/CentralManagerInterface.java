/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

import org.model.util.list.List;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author PC 4060TI
 */
public interface CentralManagerInterface extends Remote{
    
    public boolean login(String username, String password) throws RemoteException;

    public List<Train> getTrains() throws RemoteException;
}
