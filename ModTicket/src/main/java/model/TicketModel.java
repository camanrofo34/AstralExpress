package model;

import dataStructures.Interfaces.List;
import model.interfaces.communication.sendToServer.TicketBuyInterface;

import java.rmi.Naming;

public class TicketModel {
    String uri;

    public TicketModel(String uri) {
        this.uri = uri;
    }

    public Boolean buyTicket() throws Exception {
        TicketBuyInterface ticketBuyInterface = (TicketBuyInterface) Naming.lookup(uri);
        return ticketBuyInterface.buyTicket();
    }

    public List<String> getStationsForShortPath() {
        return null;
    }
}
