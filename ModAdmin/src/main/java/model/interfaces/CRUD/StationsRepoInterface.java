package model.interfaces.CRUD;

import model.domain.Station;
import dataStructures.Interfaces.List;

import java.rmi.Remote;

public interface StationsRepoInterface extends Remote {
    Boolean insert(Station station) throws Exception;

    Boolean delete(Station station) throws Exception;

    Boolean update(Station station) throws Exception;

    Station getStation(String idStation) throws Exception;

    Station getStationById(String idStation) throws Exception;

    List<Station> getAllStations() throws Exception;
}
