package model;

import dataStructures.Interfaces.List;
import model.domain.Ticket;
import model.interfaces.communication.toClient.TicketManagerServiceToClient;

import java.rmi.Naming;

public class QueueTModel {
    String uri;

    public QueueTModel(String uri) {
        this.uri = uri;
    }
    /**
     * Method to get the tickets
     * @return
     * @throws Exception
     */
    public List<Ticket> getPerTrainId(String id) throws Exception{
        TicketManagerServiceToClient ticketBuyInterface = (TicketManagerServiceToClient) Naming.lookup(uri);
        return ticketBuyInterface.getTicketOrden(id);
    }
}
