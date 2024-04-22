package model.messenger;

import model.observer.Observer;
import dataStructures.Array;

import java.io.Serializable;

public class Messenger implements Serializable {
    private String message;
    private Array<Observer<Messenger>> observers;
    /**
     * Constructor
     * @param message
     */
    public Messenger(String message) {
        this.message = message;
        observers = new Array<>(10);
    }
    /**
     * Method to get the message
     * @return
     */
    public String getMessage() {
        return message;
    }
    /**
     * Method to set the message
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
        notifyAllObservers();
    }
    /**
     * Method to attach the observer
     * @param observer
     */
    public void attach(Observer<Messenger> observer) {
        observers.add(observer);
    }
    /**
     * Method to notify all the observers
     */
    public void notifyAllObservers() {
        observers.forEach(observer -> {
            if (observer != null) {
                observer.update();
            }
            return null;
        });
    }
}
