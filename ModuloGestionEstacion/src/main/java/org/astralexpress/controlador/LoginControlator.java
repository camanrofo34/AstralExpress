/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.controlador;

import org.astralexpress.modelo.UsersModule;
import org.astralexpress.vista.LoginView;
import org.astralexpress.vista.CentralModuleView;

/**
 *
 * @author admin
 */
public class LoginControlator {

    private LoginView ISV;
    private UsersModule ME;
    private CentralModuleView CE;

    public LoginControlator(LoginView ISV) {
        this.ISV = ISV;
        this.ME = new UsersModule();
        this.CE = new CentralModuleView();
    }
    
    public void init(){
        ISV.setVisible(true);
    }

    public void loginButton() {
        String user = ISV.FieldUsuario.getText();
        String password = ISV.FieldContraseña.getText();
        if (!user.isBlank() && !password.isBlank()) {
            if (ME.buscarEmpleado(user, password)) {
                ISV.dispose();
                CE.setVisible(true);
            } else {
                ISV.Warning.setText("Usuario o contraseña errónea");
            }
        }
        else{
            ISV.Warning.setText("Por favor ingresa los datos");
        }

    }
}
