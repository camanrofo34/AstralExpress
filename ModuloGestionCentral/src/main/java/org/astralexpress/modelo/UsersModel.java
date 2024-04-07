/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo;

import org.astralexpress.modelo.messenger.Messenger;

/**
 *
 * @author admin
 */
public class UsersModel extends AbstractModel{
    private Messenger messenger;
    public UsersModel(String uri) {
        super(uri);
        this.messenger = new Messenger("");
    }

    public Messenger getMessenger() {
        return messenger;
    }
}
