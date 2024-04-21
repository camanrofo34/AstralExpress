package model.interfaces.communication.sendToClient;

import model.domain.Ticket;

public interface TicketSearchInterface {
    Ticket getTicket(String ticket) throws Exception;
}
