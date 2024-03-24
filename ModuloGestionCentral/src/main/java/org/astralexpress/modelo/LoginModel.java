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

/**
 *
 * @author PC 4060TI
 */
public class LoginModel {
        private String ip;
    private String port;
    private String serviceName;
    private String uri;

    public LoginModel(String ip, String port, String serviceName) {
        this.ip = ip;
        this.port = port;
        this.serviceName = serviceName;
        this.uri = "//" + this.ip + ":" + this.port + "/" + this.serviceName;
    }
    
    private static LoginManagerInterface look_up;
    
    public boolean login(String username, String password) throws MalformedURLException, NotBoundException, RemoteException{
        look_up = (LoginManagerInterface) Naming.lookup(uri);   
        return look_up.login(username, password);
    }
}
