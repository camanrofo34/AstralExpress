package Model.CRUD.Shared;

public interface FileJsonInterface<E>{
    E getObject(String pathFile, Class<E> classofT);

    E[] getObjects(String pathFile, Class<E[]> classOfT);

    Boolean writeObject(String pathFile, E object);

    Boolean writeObjects(String pathFile, E[] objects);
}
