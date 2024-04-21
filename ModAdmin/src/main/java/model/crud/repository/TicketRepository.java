package model.crud.repository;

import dataStructures.ArrayList;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;
import model.crud.repository.entities.StationEntity;
import model.crud.repository.entities.TicketEntity;
import model.crud.shared.FileJsonAdapter;
import model.crud.shared.FileJsonInterface;
import model.domain.*;

public class TicketRepository {

    private final FileJsonInterface<TicketEntity> fileJson;
    private final String pathFile;

    public TicketRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public Boolean insert(Ticket ticket){
        List<TicketEntity> tickets = fileJson.getObjects(pathFile, TicketEntity[].class);
        TicketEntity ticketEntity = new TicketEntity(ticket.getIdTicket(), ticket.getDateOfPurchase(), ticket.getDepartureTime(),
                ticket.getArrivalTime(), ticket.getPassenger(), ticket.getPassengerContact(), ticket.getIdPassenger(),
                ticket.getIdType().toString(), ticket.getPrice(), ticket.getClasse().toString(), ticket.getLuggage(),
                ticket.getTrains().toArray(new Train[0]), ticket.getStations().toArray(new Station[0]));
        tickets.add(ticketEntity);
        return fileJson.writeObjects(pathFile, tickets);
    }

    public List<Ticket> getTickets() {
        List<TicketEntity> tickets = fileJson.getObjects(pathFile, TicketEntity[].class);
        List<Ticket> ticketsList = new dataStructures.ArrayList<>();
        Iterator<TicketEntity> it = tickets.iterator();
        while (it.hasNext()) {
            TicketEntity ticketEntity = it.next();
            ticketsList.add(new Ticket(ticketEntity.getIdTicket(), ticketEntity.getDateOfPurchase(), ticketEntity.getDepartureTime(),
                    ticketEntity.getArrivalTime(), ticketEntity.getPassenger(), ticketEntity.getPassengerContact(), ticketEntity.getIdPassenger(),
                    IdType.valueOf(ticketEntity.getIdType()), ticketEntity.getPrice(), Classe.valueOf(ticketEntity.getClasse()), ticketEntity.getLuggage(),
                    new ArrayList<>(ticketEntity.getTrains()), new ArrayList<>(ticketEntity.getStations())));
        }
        return ticketsList;
    }

}
