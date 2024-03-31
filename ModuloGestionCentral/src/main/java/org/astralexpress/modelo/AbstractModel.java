/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo;

import org.astralexpress.modelo.domain.LoginManagerInterface;

/**
 *
 * @author PC 4060TI
 */
public abstract class AbstractModel {

    protected static LoginManagerInterface look_up;
    protected String uri;
    public AbstractModel(String uri) {
        this.uri = uri;
    }

}
