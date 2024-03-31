/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import org.astralexpress.modelo.domain.LoginManagerInterface;
import org.astralexpress.modelo.messenger.Messenger;

/**
 *
 * @author PC 4060TI
 */
public class LoginModel extends AbstractModel{
    
    private Messenger messenger;
    public LoginModel(String uri) {
        super(uri);
        messenger = new Messenger("");
    } 

    public Messenger getMessenger() {
        return messenger;
    }
    
    public boolean login(String username, String password) throws MalformedURLException, NotBoundException, RemoteException{
        look_up = (LoginManagerInterface) Naming.lookup(uri);   
        boolean ask = look_up.login(username, password);
        if (!ask){
            messenger.setMessage("Usuario o contraseña incorrectos");
        }
        return ask;
    }
}
