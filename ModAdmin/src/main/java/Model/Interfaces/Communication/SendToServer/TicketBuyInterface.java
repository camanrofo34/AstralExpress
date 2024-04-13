package Model.Interfaces.Communication.SendToServer;

import java.rmi.Remote;

public interface TicketBuyInterface extends Remote {
    Boolean buyTicket(String ticket) throws Exception;
}
