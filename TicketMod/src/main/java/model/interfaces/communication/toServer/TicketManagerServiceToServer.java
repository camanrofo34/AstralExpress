package model.interfaces.communication.toServer;

import dataStructures.Array;
import dataStructures.Interfaces.List;
import model.domain.Ticket;
import model.domain.Train;

import java.rmi.Remote;

public interface TicketManagerServiceToServer extends Remote {
    Ticket buyTicket(String names, String lastName, String idType, String idNumber, String address, Array<String> phone, String seatType, String contactName, String contactPhones, String weight, List<Train> trains, List<String> stations) throws Exception;

    Boolean dispatch(String idTicket) throws Exception;
}
