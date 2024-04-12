package Model.Interfaces.CRUD;

import DataStructures.Interfaces.List;
import Model.Domain.Passenger;

import java.rmi.Remote;

public interface PassengerRepoInterface extends Remote {
    Boolean insert(Passenger passenger) throws Exception;

    Boolean delete(Passenger passenger) throws Exception;

    Boolean update(Passenger passenger) throws Exception;

    Passenger getPassenger(String idPassenger) throws Exception;

    List<Passenger> getPassengers() throws Exception;
}
