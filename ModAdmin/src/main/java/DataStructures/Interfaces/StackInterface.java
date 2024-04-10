package DataStructures.Interfaces;

public interface StackInterface<E> extends Collection<E>{
    public E peek();
    public E pop();
    public boolean push(E element);
}
