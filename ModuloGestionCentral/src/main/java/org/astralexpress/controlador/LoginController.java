/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.controlador;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.astralexpress.modelo.LoginModel;
import org.astralexpress.modelo.ModuloModel;
import org.astralexpress.modelo.RMISettings;
import org.astralexpress.vista.LoginView;
import org.astralexpress.vista.Modulo;
import org.astralexpress.vista.ModuloView;

/**
 *
 * @author PC 4060TI
 */
public class LoginController {

    LoginModel LM;
    LoginView LV;

    public LoginController(LoginModel LM, LoginView LV) {
        this.LM = LM;
        this.LV = LV;
    }

    public void start() {
        LV.initComponents(event -> {
            String username = LV.getjTextField1();
            String password = LV.getjTextField2();
            if (username.isBlank() || password.isBlank()){
                LM.getMessenger().setMessage("Por favor ingresar los datos correspondientes");
                return null;
            }
            try {
                boolean tried = LM.login(username, password);
                if (tried){
                    ModuloController MC = new ModuloController(new ModuloModel(RMISettings.getInstance().getRMIAddress()), new ModuloView());
                    MC.start();
                }
            } catch (MalformedURLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        });
    }

}
