package dataStructures;

import dataStructures.Interfaces.Collection;
import dataStructures.Interfaces.Iterator;

import java.util.function.Function;

public class Queue<E> {

    ArrayList<E> queue;

    public Queue() {
        this.queue = new ArrayList<>();
    }

    public Queue(int capacity) {
        this.queue = new ArrayList<>(capacity);
    }

    public Queue(E[] array) {
        this.queue = new ArrayList<>(array);
    }

    public boolean clear() {
        return queue.clear();
    }

    public boolean contains(E element) {
        return queue.contains(element);
    }

    public boolean contains(E[] array) {
        return queue.contains(array);
    }

    public boolean contains(Collection<E> collection) {
        return queue.contains(collection);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean reverse() {
        return queue.reverse();
    }

    public int size() {
        return queue.size();
    }

    public void forEach(Function<E, Void> action) {
        queue.forEach(action);
    }

    public Iterator<E> iterator() {
        return queue.iterator();
    }

    public E peek() {
        return queue.peek();
    }

    public E extract() {
        return queue.poll();
    }

    public boolean insert(E element) {
        return queue.add(element);
    }

}

