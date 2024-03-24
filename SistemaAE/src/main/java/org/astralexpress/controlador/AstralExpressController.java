/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.controlador;

import org.astralexpress.modelo.AstralExpressModel;
import org.astralexpress.vista.ServerView;

/**
 *
 * @author PC 4060TI
 */
public class AstralExpressController {
    AstralExpressModel model;
    ServerView view;

    public AstralExpressController(AstralExpressModel model, ServerView view) {
        this.model=model;
        this.view=view;
    }
    
    public void start(){
        view.initComponents(event -> {view.showServerStatus("Server started");model.deploy(); return null;});
    }
}
