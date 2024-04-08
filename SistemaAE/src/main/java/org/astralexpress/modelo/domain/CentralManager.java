/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

import org.astralexpress.modelo.repositorio.TrainRepository;
import org.astralexpress.modelo.repositorio.UserRepository;
import org.model.util.list.List;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author PC 4060TI
 */
public class CentralManager extends UnicastRemoteObject implements CentralManagerInterface {


    public CentralManager() throws RemoteException {
        super();
    }

    @Override
    public boolean login(String username, String password) {
        UserRepository userRepository = new UserRepository("src\\main\\java\\org\\astralexpress\\database\\user.json");
        User user = userRepository.getUser(username);
        if (user.equals(User.getNullUser())) {
            return false;
        }
        return user.getPassword().equals(password);
    }

    @Override
    public List<Train> getTrains() throws RemoteException {
        TrainRepository trainRepository = new TrainRepository("src\\main\\java\\org\\astralexpress\\database\\trains.json");
        return trainRepository.getTrains();
    }

    @Override
    public boolean addTrain(String trainName, int capacity, Brand brand) throws IOException {
        TrainRepository trainRepository = new TrainRepository("src\\main\\java\\org\\astralexpress\\database\\trains.json");
        Train train = new Train(trainName, capacity, brand);
        return trainRepository.addTrain(train);
    }
}
