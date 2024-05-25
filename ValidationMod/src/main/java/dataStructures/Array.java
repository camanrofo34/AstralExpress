package dataStructures;


import dataStructures.Interfaces.ArrayInterface;
import dataStructures.Interfaces.Collection;
import dataStructures.Interfaces.Iterator;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Array<E> implements ArrayInterface<E> {
    int size;
    private E[] elements;

    /**
     * @param dimension
     */
    public Array(int dimension) {
        this.elements = (E[]) new Object[dimension];
        this.size = 0;
    }

    public Array(E[] array) {
        this.elements = array;
        this.size = array.length;
    }

    /**
     * @param element
     * @return
     */
    @Override
    public boolean add(E element) {
        try {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] == null) {
                    elements[i] = element;
                    size++;
                    return true;
                }
            }
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    /**
     * @param index
     * @param array
     * @return
     */
    @Override
    public boolean add(int index, E[] array) {
        try {
            int e = 0;
            int restSpaces = elements.length - index;
            if (restSpaces >= array.length) {
                for (int i = index; e < array.length; i++) {
                    elements[i] = array[e++];
                    size++;
                }
                return true;
            } else {
                for (int i = index; e < elements.length; i++) {
                    elements[i] = array[e++];
                    size++;
                }
                return false;
            }
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    /**
     * @param index
     * @param collection
     * @return
     */
    @Override
    public boolean add(int index, Collection<E> collection) {
        try {
            Iterator<E> collectionIterator = collection.iterator();
            int e = 0;
            int restSpaces = elements.length - index;
            if (restSpaces >= collection.size()) {
                for (int i = index; e < collection.size(); i++) {
                    elements[i] = collectionIterator.next();
                    e++;
                    size++;
                }
                return true;
            } else {
                for (int i = index; e < elements.length; i++) {
                    elements[i] = collectionIterator.next();
                    e++;
                    size++;
                }
                return false;
            }
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    /**
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        try {
            if (index < elements.length && index >= 0) {
                return elements[index];
            }
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    /**
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {
        int index = -1;
        try {
            for (int i = 0; i < elements.length && index == -1; i++) {
                if (elements[i] != null && elements[i].equals(element)) {
                    index = i;
                }
            }
            return index;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return index;
    }

    /**
     * @param element
     * @return
     */
    @Override
    public int lastIndexOf(E element) {
        int index = -1;
        try {
            for (int i = elements.length - 1; i >= 0 && index == -1; i--) {
                if (elements[i] != null && elements[i].equals(element)) {
                    index = i;
                }
            }
            return index;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return index;
    }

    /**
     * @param index
     * @return
     */
    @Override
    public boolean remove(int index) {
        try {
            elements[index] = null;
            size--;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    /**
     * @param filter
     * @return
     */
    @Override
    public boolean remove(Predicate<E> filter) {
        try {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] != null && filter.test(elements[i])) {
                    elements[i] = null;
                    size--;
                }
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    /**
     * @param from
     * @param to
     * @return
     */
    @Override
    public boolean remove(int from, int to) {
        try {
            if (to <= elements.length && from >= 0 && to > 0 && from < to) {
                for (int i = from; i < to; i++) {
                    elements[i] = null;
                    size--;
                }
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    /**
     * @param index
     * @param element
     * @return
     */
    @Override
    public boolean set(int index, E element) {
        try {
            elements[index] = element;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    /**
     * @return
     */
    @Override
    public boolean clear() {
        try {
            for (int i = 0; i < elements.length; i++) {
                elements[i] = null;
            }
            size = 0;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    /**
     * @param element
     * @return
     */
    @Override
    public boolean contains(E element) {
        try {
            for (E element1 : elements) {
                if (element1.equals(element)) {
                    return true;
                }
            }
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    /**
     * @param array
     * @return
     */
    @Override
    public boolean contains(E[] array) {
        try {
            for (E element : array) {
                if (!contains(element)) {
                    return false;
                }
            }
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return true;
    }

    /**
     * @param collection
     * @return
     */
    @Override
    public boolean contains(Collection<E> collection) {
        try {
            Iterator<E> collectionIterator = collection.iterator();
            while (collectionIterator.hasNext()) {
                E element = collectionIterator.next();
                if (!contains(element)) {
                    return false;
                }
            }
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return true;
    }

    /**
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return
     */
    @Override
    public boolean reverse() {
        try {
            for (int i = 0; i < size / 2; i++) {
                E temp = elements[i];
                elements[i] = elements[size - i - 1];
                elements[size - i - 1] = temp;
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    /**
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int indice = 0;

            @Override
            public boolean hasNext() {
                return indice < size;
            }

            @Override
            public E next() {
                return elements[indice++];
            }
        };
    }

    /**
     * @param action
     */
    @Override
    public void forEach(Function<E, Void> action) {
        for (int i = 0; i < size; i++) {
            action.apply(elements[i]);
        }
    }

    public E[] toPrimitiveArray() {
        return this.elements;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]).append(",");
        }
        return sb.toString();
    }
}
