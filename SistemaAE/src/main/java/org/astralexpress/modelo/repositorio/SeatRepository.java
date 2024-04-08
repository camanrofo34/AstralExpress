/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.repositorio;

import org.astralexpress.modelo.domain.Classe;
import org.astralexpress.modelo.domain.Seat;
import org.astralexpress.shared.FileJsonAdapter;
import org.astralexpress.shared.FileJsonInterface;
import org.model.io.array.Array;
import org.model.priorityQueue.list.PriorityQueue;
import org.model.util.iterator.Iterator;

/**
 * @author PC 4060TI
 */
public class SeatRepository {
    private FileJsonInterface<SeatEntity> fileJson;
    private String pathFile;

    public SeatRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public Seat getSeat(String idSeat) {
        SeatEntity[] seatsEntity = fileJson.getObjects(pathFile, SeatEntity[].class);
        Array<SeatEntity> seatEntity = new Array<>(seatsEntity);
        Iterator<SeatEntity> iterator = seatEntity.iterator();
        while (iterator.hasNext()) {
            SeatEntity seatE = iterator.next();
            if (seatE.idSeat.equals(idSeat)) {
                return new Seat(seatE.idSeat, Classe.findByPriority(seatE.Class));
            }
        }
        return Seat.returnNullSeat();
    }

    public PriorityQueue<Seat> getSeats(String idVagonPassengers) {
        SeatEntity[] seatsEntity = fileJson.getObjects(pathFile, SeatEntity[].class);
        PriorityQueue<Seat> seats = new PriorityQueue<>(3);
        Array<SeatEntity> seatEntity = new Array<>(seatsEntity);
        Iterator<SeatEntity> iterator = seatEntity.iterator();
        while (iterator.hasNext()) {
            SeatEntity seatE = iterator.next();
            if (seatE.idSeat.startsWith(idVagonPassengers)) {
                seats.insert(Integer.parseInt(seatE.Class), new Seat(seatE.idSeat, Classe.findByPriority(seatE.Class)));
            }
        }
        return seats;
    }
}
