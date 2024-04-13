package Model.Interfaces.Communication.SendToClient;

import Model.Domain.Ticket;

public interface TicketSearchInterface {
    Ticket getTicket(String ticket) throws Exception;
}
