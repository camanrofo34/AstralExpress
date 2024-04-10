package DataStructures;

import DataStructures.Interfaces.Collection;
import DataStructures.Interfaces.Iterator;
import DataStructures.Interfaces.StackInterface;

import java.util.function.Function;

public class Stack<E> implements StackInterface<E> {

    ArrayList<E> stack;

    public Stack() {
        this.stack = new ArrayList<>();
    }

    @Override
    public boolean clear() {
        return stack.clear();
    }

    @Override
    public boolean contains(E element) {
        return stack.contains(element);
    }

    @Override
    public boolean contains(E[] array) {
        return stack.contains(array);
    }

    @Override
    public boolean contains(Collection<E> collection) {
        return stack.contains(collection);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public boolean reverse() {
        return stack.reverse();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public void forEach(Function<E, Void> action) {
        stack.forEach(action);
    }

    @Override
    public Iterator<E> iterator() {
        return stack.iterator();
    }

    @Override
    public E peek() {
        return stack.peekLast();
    }

    @Override
    public E pop() {
        return stack.pollLast();
    }

    @Override
    public boolean push(E element) {
        return stack.add(element);
    }
}
