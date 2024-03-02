/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.astralexpress.controlador;

import com.astralexpress.view.BusquedaBoletoVista;

/**
 *
 * @author admin
 */
public class BusquedaBoletoControlador {
    BusquedaBoletoVista BBV;

    public BusquedaBoletoControlador(BusquedaBoletoVista BBV) {
        this.BBV = BBV;
    }
    
    public void buscarBoleto(){
        String Id = BBV.FieldBusqueda.getText();
        if(Id.matches("^[A-Z]\\d{10}$")){
            //Llama al metodo de model
        }else{
            BBV.Respuesta.setText("Error: No posee el formato de Boleta del sistema");
        }
    }
    
}
