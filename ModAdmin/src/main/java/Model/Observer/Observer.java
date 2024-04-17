package Model.Observer;

import java.io.Serializable;

public abstract class Observer<E extends Serializable> implements Serializable {
    protected E subject;

    protected Observer(E subject) {
        this.subject = subject;
    }

    public abstract void update();
}
