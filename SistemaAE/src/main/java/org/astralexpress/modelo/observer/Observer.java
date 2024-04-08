/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.observer;

import java.io.Serializable;

/**
 * @param <E>
 * @author PC 4060TI
 */
public abstract class Observer<E extends Serializable> implements Serializable {
    protected E subject;

    public Observer(E subject) {
        this.subject = subject;
    }

    public abstract void update();

}
