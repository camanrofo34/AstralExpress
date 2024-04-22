package model.interfaces.communication.sendToClient;

import model.domain.Ticket;

import java.rmi.Remote;

public interface TicketSearchInterface extends Remote {
    Ticket getTicket(String ticket) throws Exception;
}
