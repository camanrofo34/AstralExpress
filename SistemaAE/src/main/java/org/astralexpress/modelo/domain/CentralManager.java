/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.astralexpress.modelo.repositorio.TrainRepository;
import org.astralexpress.modelo.repositorio.UserRepository;
import org.model.util.list.List;

/**
 *
 * @author PC 4060TI
 */
public class CentralManager extends UnicastRemoteObject implements CentralManagerInterface {
    
    
    public CentralManager() throws RemoteException{
        super();
    }
    
    @Override
    public boolean login(String username, String password){
        UserRepository userRepository = new UserRepository("src\\main\\java\\org\\astralexpress\\database\\user.json");
        User user = userRepository.getUser(username);
        if (user.equals(User.getNullUser())){
            return false;
        }
        return user.getPassword().equals(password);
    }

    @Override
    public List<Train> getTrains() throws RemoteException {
        TrainRepository trainRepository = new TrainRepository("src\\main\\java\\org\\astralexpress\\database\\trains.json");
        return trainRepository.getTrains();
    }
}
