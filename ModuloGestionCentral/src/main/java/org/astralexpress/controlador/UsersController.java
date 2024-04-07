/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.controlador;

import org.astralexpress.modelo.AbstractModel;
import org.astralexpress.modelo.UsersModel;
import org.astralexpress.vista.UsersView;

/**
 *
 * @author admin
 */
public class UsersController{

    UsersModel UM;
    UsersView UV;

    public UsersController(UsersModel UM, UsersView UV){
        this.UM = UM;
        this.UV = UV;
    }

    public void start(){
        UV.initComponents();
    }
    
}
