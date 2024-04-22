package model.interfaces.crud;

import dataStructures.Interfaces.List;
import model.domain.Ticket;

public interface TicketRepoInterface {
    /**
     * Insert a Ticket in the repository
     * @param ticket Ticket to be inserted
     * @return true if the Ticket was inserted, false if not
     */
    Boolean insert(Ticket ticket);
    /**
     * Get all Tickets from the repository
     * @return List of Tickets
     */
    List<Ticket> getTickets();
}
