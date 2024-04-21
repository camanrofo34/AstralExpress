package dataStructures;

import dataStructures.Interfaces.Collection;
import dataStructures.Interfaces.Iterator;

import java.util.NoSuchElementException;
import java.util.function.Function;

public class PriorityQueue<E> {

    Array<Queue<E>> prioridad;
    int prioridades;
    int size;

    public PriorityQueue(int n) {
        this.size = 0;
        this.prioridad = new Array<>(n);
        this.prioridades = n;
        for (int i = 0; i < n; i++) {
            prioridad.add(new Queue<>());
        }
    }

    public boolean clear() {
        for (int i = 0; i < prioridades; i++) {
            prioridad.get(i).clear();
        }
        size = 0;
        return true;
    }

    public boolean contains(E element) {
        for (int i = 0; i < prioridades; i++) {
            if (prioridad.get(i).contains(element)) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(E[] array) {
        for (E element : array) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    public boolean contains(Collection<E> collection) {
        Iterator<E> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!contains(iterator.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean reverse() {
        for (int i = 0; i < prioridades; i++) {
            prioridad.get(i).reverse();
        }
        prioridad.reverse();
        return true;
    }

    public int size() {
        return size;
    }

    public void forEach(Function<E, Void> action) {
        for (int i = 0; i < prioridades; i++) {
            prioridad.get(i).forEach(action);
        }
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int i = 0;
            Iterator<E> iteradorElementos = prioridad.get(i).iterator();

            @Override
            public boolean hasNext() {
                while (!iteradorElementos.hasNext() && i < prioridad.size() - 1) {
                    iteradorElementos = prioridad.get(++i).iterator();
                }
                return iteradorElementos.hasNext();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No hay más elementos");
                }
                return iteradorElementos.next();
            }

        };
    }

    public boolean insert(E element) {
        boolean insert = prioridad.get(prioridades - 1).insert(element);
        if (insert) {
            size++;
            return true;
        }
        return false;
    }

    public boolean insert(int index, E element) {
        boolean insert = prioridad.get(index).insert(element);
        if (insert) {
            size++;
            return true;
        }
        return false;
    }

    public E peek() {
        for (int i = 0; i < prioridades; i++) {
            if (prioridad.get(i).size() != 0) {
                return prioridad.get(i).peek();
            }
        }
        return null;
    }

    public E extract() {
        for (int i = 0; i < prioridades; i++) {
            if (prioridad.get(i).size() != 0) {
                size--;
                return prioridad.get(i).extract();
            }
        }
        return null;
    }

}

