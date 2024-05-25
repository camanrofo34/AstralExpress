package model;

import model.interfaces.communication.toServer.TicketManagerServiceToServer;

import java.rmi.Naming;

public class DischargeModel {
    String uri;

    public DischargeModel(String uri) {
        this.uri = uri;
    }
    /**
     * Method to discharge the luggage and passenger
     * @param idTicket
     * @return
     * @throws Exception
     */
    public Boolean discharge(String idTicket) throws Exception {
        TicketManagerServiceToServer ticketManagerServiceToServer = (TicketManagerServiceToServer) Naming.lookup(uri);
        return ticketManagerServiceToServer.dispatch(idTicket);
    }
}
