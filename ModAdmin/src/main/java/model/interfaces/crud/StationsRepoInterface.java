package model.interfaces.crud;

import model.domain.Station;
import dataStructures.Interfaces.List;

import java.rmi.Remote;

public interface StationsRepoInterface extends Remote {
    /**
     * Insert a Station in the repository
     * @param station Station to be inserted
     * @return true if the Station was inserted, false if not
     */
    Boolean insert(Station station) throws Exception;
    /**
     * Delete a Station in the repository
     * @param station Station to be deleted
     * @return true if the Station was deleted, false if not
     */
    Boolean delete(Station station) throws Exception;
    /**
     * Update a Station in the repository
     * @param station Station to be updated
     * @return true if the Station was updated, false if not
     */
    Boolean update(Station station) throws Exception;
    /**
     * Get a Station from the repository
     * @param idStation Station to be obtained
     * @return Station if the Station was found, null if not
     */
    Station getStation(String idStation) throws Exception;
    /**
     * Get all Stations from the repository
     * @return List of Stations
     */
    Station getStationById(String idStation) throws Exception;
    /**
     * Get all Stations from the repository
     * @return List of Stations
     */
    List<Station> getAllStations() throws Exception;
}
