package model;

import dataStructures.Interfaces.List;
import model.domain.Ticket;
import model.interfaces.communication.toClient.TicketManagerServiceToClient;

import java.rmi.Naming;

public class ValidationModel {
    String uri;

    public ValidationModel(String uri) {
        this.uri = uri;
    }
    /**
     * Method to get the tickets
     * @return
     * @throws Exception
     */
    public List<Ticket> getTicketSearch(String ticket) throws Exception{
        TicketManagerServiceToClient ticketBuyInterface = (TicketManagerServiceToClient) Naming.lookup(uri);
        return ticketBuyInterface.getTicketSearch(ticket);
    }
}
