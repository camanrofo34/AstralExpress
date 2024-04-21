package model.interfaces.communication.sendToServer;

import java.rmi.Remote;

public interface TicketBuyInterface extends Remote {
    Boolean buyTicket() throws Exception;
}
