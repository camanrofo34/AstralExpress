/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.repositorio;

import org.astralexpress.modelo.domain.Ticket;
import org.astralexpress.shared.FileJsonAdapter;
import org.astralexpress.shared.FileJsonInterface;
import org.model.io.array.Array;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 */
public class TicketRepository {
    private FileJsonInterface<TicketEntity> fileJson;
    private String pathFile;

    public TicketRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }
    
    public Ticket getTicket(String idTicket) {
        TicketEntity[] ticketsEntity = fileJson.getObjects("", TicketEntity[].class);
        Array<TicketEntity> seatEntity = new Array<>(ticketsEntity);
        Iterator<TicketEntity> iterator = seatEntity.iterator();
        while (iterator.hasNext()) {
            TicketEntity ticketE = iterator.next();
            if (ticketE.idSeat.equals(idTicket)) {
                return new Ticket(
                        new TrainRepository("").getTrain(ticketE.idTrain), 
                        new PassengersVagonRepository("").getPassangerVagon(ticketE.idVagon), 
                        new SeatRepository("").getSeat(ticketE.idSeat),
                        new StationRepository("").getStation(ticketE.idDepartureStation),
                        new StationRepository("").getStation(ticketE.idArrivalStation),
                        new PassengersRepository("").getPassenger(ticketE.idPassenger),
                        Double.parseDouble(ticketE.value)                        
                );
            }
        }
        return Ticket.returnNullTicket();
    }
}
