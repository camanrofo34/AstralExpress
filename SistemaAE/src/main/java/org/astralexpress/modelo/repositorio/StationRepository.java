/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.repositorio;

import org.astralexpress.modelo.domain.Station;
import org.astralexpress.shared.FileJsonAdapter;
import org.astralexpress.shared.FileJsonInterface;
import org.model.io.array.Array;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 */
public class StationRepository {
    private FileJsonInterface<StationEntity> fileJson;
    private String pathFile;

    public StationRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }
    
    public Station getStation(String idStation) {
        StationEntity[] stationsEntity = fileJson.getObjects("", StationEntity[].class);
        Array<StationEntity> stationEntity = new Array<>(stationsEntity);
        Iterator<StationEntity> iterator = stationEntity.iterator();
        while (iterator.hasNext()) {
            StationEntity stationE = iterator.next();
            if (stationE.idStation.equals(idStation)) {
                return new Station(stationE.idStation, stationE.stationName);
            }
        }
        return Station.returnNullStation();
    }
}
