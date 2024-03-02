/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.controlador;

import org.astralexpress.modelo.domain.ModuloEmpleados;
import org.astralexpress.vista.InicioSesionVista;
import org.astralexpress.vista.ModuloCentral;

/**
 *
 * @author admin
 */
public class InicioSesionControlador {

    InicioSesionVista ISV;
    ModuloEmpleados ME;
    ModuloCentral CE;

    public InicioSesionControlador(InicioSesionVista ISV) {
        this.ISV = ISV;
        this.ME = new ModuloEmpleados();
        this.CE = new ModuloCentral();
    }

    public void inicioSesionBoton() {
        String usuario = ISV.FieldUsuario.getText();
        String contraseña = ISV.FieldContraseña.getText();
        if (!usuario.isBlank() && !contraseña.isBlank()) {
            if (ME.buscarEmpleado(usuario, contraseña)) {
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
