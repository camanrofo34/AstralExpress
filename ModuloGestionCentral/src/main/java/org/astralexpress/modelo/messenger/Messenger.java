/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.messenger;
import org.astralexpress.modelo.observer.Observer;
import org.model.array.Array;

/**
 *
 * @author PC 4060TI
 */
public class Messenger {
        private String message;
    private Array<Observer<Messenger>> observers;

    public Messenger(String message) {
        this.message = message;
        this.observers = new Array<>(10);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        notifyAllObservers();
    }
    
    public void attach(Observer<Messenger> observer){
        observers.add(observer);
    }
    
    public void notifyAllObservers(){
        observers.forEach(observer -> {
            if (observer != null){
                observer.update();
            }
            return null;
        });
    }
}
