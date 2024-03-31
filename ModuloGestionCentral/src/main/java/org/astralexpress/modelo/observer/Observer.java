/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.observer;

/**
 *
 * @author PC 4060TI
 */
public abstract class Observer<E> {
    protected E subject;

    public Observer(E subject) {
        this.subject = subject;
    }
    
    public abstract void update();
}
