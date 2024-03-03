/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.astralexpress.modulogestionestacion;

import org.astralexpress.controlador.LoginControlator;
import org.astralexpress.vista.LoginView;

/**
 *
 * @author admin
 */
public class ModuloGestionEstacion {

    public static void main(String[] args) {
        LoginControlator LC = new LoginControlator(new LoginView());
        LC.init();
    }
}
