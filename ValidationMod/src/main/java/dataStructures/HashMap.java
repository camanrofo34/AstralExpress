package dataStructures;

public class HashMap<E> {

    private ArrayList<ArrayList<E>> hashMap;

    public HashMap(int size) {
        this.hashMap = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            hashMap.add(new ArrayList<E>());
        }
    }

    private int hashFunction(E clue) {
        int hashCode = clue.hashCode();
        return Math.abs(hashCode % hashMap.size());
    }

    public void put(E clue, E element) {
        int index = hashFunction(clue);
        ArrayList<E> list = hashMap.get(index);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i * 2).equals(clue)) {
                list.set(i * 2 + 1, element); // Actualizar valor
                return;
            }
        }
        list.add(clue);
        list.add(element);
    }

    public E get(E clue) {
        int index = hashFunction(clue);
        ArrayList<E> list = hashMap.get(index);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i * 2).equals(clue)) {
                return list.get(i * 2 + 1);
            }
        }
        return null;
    }

}
