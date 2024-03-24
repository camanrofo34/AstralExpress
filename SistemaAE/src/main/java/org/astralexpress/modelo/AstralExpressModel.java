/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import org.astralexpress.modelo.domain.LoginManager;
import org.astralexpress.modelo.domain.LoginManagerInterface;
import org.astralexpress.modelo.messenger.Messenger;

/**
 *
 * @author PC 4060TI
 */
public class AstralExpressModel {   
    private String ip;
    private String port;
    private String serviceName;
    private String uri;
    private Messenger messenger;

    public AstralExpressModel(String ip, String port, String serviceName) {
        this.ip = ip;
        this.port = port;
        this.serviceName = serviceName;
        this.uri = "//" + this.ip + ":" + this.port + "/" + this.serviceName;
        this.messenger = new Messenger("Sever Status: Stopped");
    }

    public Messenger getMessenger() {
        return messenger;
    }

    public boolean deploy() {
        try {
            System.setProperty("java.rmi.server.hostname", ip);
            LoginManagerInterface service = new LoginManager();
            LocateRegistry.createRegistry(Integer.parseInt(port));
            Naming.rebind(uri, service);
            messenger.setMessage("Server Status: Running");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
