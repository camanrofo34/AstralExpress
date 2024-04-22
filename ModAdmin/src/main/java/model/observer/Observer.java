package model.observer;

import java.io.Serializable;

public abstract class Observer<E extends Serializable> implements Serializable {
    protected E subject;
    /**
     * Constructor
     * @param subject
     */
    protected Observer(E subject) {
        this.subject = subject;
    }
    /**
     * Method to update the observer
     */
    public abstract void update();
}
