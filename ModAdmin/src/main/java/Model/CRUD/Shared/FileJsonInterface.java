package Model.CRUD.Shared;

import DataStructures.Interfaces.List;

public interface FileJsonInterface<E>{

    List<E> getObjects(String pathFile, Class<E[]> classOfT);


    Boolean writeObjects(String pathFile, List<E> objects);
}
