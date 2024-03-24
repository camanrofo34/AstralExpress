/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import org.astralexpress.modelo.repositorio.UserRepository;

/**
 *
 * @author PC 4060TI
 */
public class LoginManager extends UnicastRemoteObject implements LoginManagerInterface{
    
    
    public LoginManager () throws RemoteException{
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
}
