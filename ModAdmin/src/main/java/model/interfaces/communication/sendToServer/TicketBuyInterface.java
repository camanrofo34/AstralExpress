package model.interfaces.communication.sendToServer;

import dataStructures.Array;
import dataStructures.ArrayList;
import dataStructures.Interfaces.List;
import model.domain.Station;
import model.domain.Train;

import java.rmi.Remote;

public interface TicketBuyInterface extends Remote {
    /**
     *
     * @param names
     * @param lastName
     * @param idType
     * @param idNumber
     * @param address
     * @param phone
     * @param seatType
     * @param contactName
     * @param contactPhones
     * @param weight
     * @param trains
     * @param stations
     * @return Boolean
     * @throws Exception
     */
    Boolean buyTicket(String names, String lastName, String idType, String idNumber, String address, Array<String> phone, String seatType, String contactName, String contactPhones, String weight, List<Train> trains, List<String> stations) throws Exception;
    /**
     * Get the shortest path between two stations
     * @param station1
     * @param station2
     * @return
     * @throws Exception
     */
    List<Station> getShortestPath(Station station1, Station station2) throws Exception;
    /**
     * Get a station
     * @param stationId
     * @return
     * @throws Exception
     */
    Station getStation(String stationId) throws Exception;
    /**
     * Get the trains from the path
     * @param stations
     * @return
     * @throws Exception
     */
    List<Train> getTrainsFromThePath(ArrayList<Station> stations) throws Exception;
    /**
     * Get the stations
     * @param stations
     * @return
     * @throws Exception
     */
    List<Station> getStations(List<String> stations) throws Exception;
}
