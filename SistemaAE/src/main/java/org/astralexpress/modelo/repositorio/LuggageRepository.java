/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.repositorio;

import org.astralexpress.modelo.domain.Luggage;
import org.astralexpress.shared.FileJsonAdapter;
import org.astralexpress.shared.FileJsonInterface;
import org.model.io.LinkedList.LinkedList;
import org.model.io.array.Array;
import org.model.util.iterator.Iterator;
import org.model.util.list.List;

import java.io.Serializable;

/**
 * @author PC 4060TI
 */
public class LuggageRepository implements Serializable {
    private FileJsonInterface<LuggageEntity> fileJson;
    private String pathFile;

    public LuggageRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public List<Luggage> getLuggagesByIdVagon(String idVagon) {
        LuggageEntity[] luggageEntity = fileJson.getObjects(pathFile, LuggageEntity[].class);
        Array<LuggageEntity> luggagesEntity = new Array<>(luggageEntity);
        List<Luggage> luggages = new LinkedList<>();
        Iterator<LuggageEntity> iterator = luggagesEntity.iterator();
        while (iterator.hasNext()) {
            LuggageEntity luggage = iterator.next();
            if (luggage.idVagon.equals(idVagon)) {
                luggages.add(new Luggage(luggage.idPassenger, luggage.idVagon));
            }
        }
        return luggages;
    }

    public List<Luggage> getLuggagesByIdPssenger(String idPassenger) {
        LuggageEntity[] luggageEntity = fileJson.getObjects(pathFile, LuggageEntity[].class);
        Array<LuggageEntity> luggagesEntity = new Array<>(luggageEntity);
        List<Luggage> luggages = new LinkedList<>();
        Iterator<LuggageEntity> iterator = luggagesEntity.iterator();
        while (iterator.hasNext()) {
            LuggageEntity luggage = iterator.next();
            if (luggage.idVagon.equals(idPassenger)) {
                luggages.add(new Luggage(luggage.idPassenger, luggage.idVagon));
            }
        }
        return luggages;
    }

}
