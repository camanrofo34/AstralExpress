/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.repositorio;

import org.astralexpress.modelo.domain.PassengersVagon;
import org.astralexpress.modelo.domain.Seat;
import org.astralexpress.shared.FileJsonAdapter;
import org.astralexpress.shared.FileJsonInterface;
import org.model.LinkedList.doubly.LinkedList;
import org.model.io.array.Array;
import org.model.priorityQueue.list.PriorityQueue;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 */
public class PassengersVagonRepository {

    private FileJsonInterface<PassengersVagonEntity> fileJson;
    private String pathFile;

    public PassengersVagonRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public PassengersVagon getPassangerVagon(String idVagon) {
        PassengersVagonEntity[] passengersVagonEntity = fileJson.getObjects("", PassengersVagonEntity[].class);
        Array<PassengersVagonEntity> passengerVagonsEntity = new Array<>(passengersVagonEntity);
        Iterator<PassengersVagonEntity> iterator = passengerVagonsEntity.iterator();
        SeatRepository seatRepository = new SeatRepository("../../database/.json");
        while (iterator.hasNext()) {
            PassengersVagonEntity passengersVagonE = iterator.next();
            PriorityQueue<Seat> seats = seatRepository.getSeats(idVagon);
            if (passengersVagonE.idVagon.equals(idVagon)) {
                return new PassengersVagon(seats, passengersVagonE.idVagon);
            }
        }
        return PassengersVagon.returnNullPassengersVagon();
    }

    public LinkedList<PassengersVagon> getPassangerVagons(String idTrain) {
        PassengersVagonEntity[] passengersVagonEntity = fileJson.getObjects("", PassengersVagonEntity[].class);
        LinkedList<PassengersVagon> passengersVagon = new LinkedList<>();
        Array<PassengersVagonEntity> passengerVagonsEntity = new Array<>(passengersVagonEntity);
        Iterator<PassengersVagonEntity> iterator = passengerVagonsEntity.iterator();
        SeatRepository seatRepository = new SeatRepository("../../database/.json");
        while (iterator.hasNext()) {
            PassengersVagonEntity passengersVagonE = iterator.next();
            if (passengersVagonE.idVagon.startsWith(idTrain)) {
                PriorityQueue<Seat> seats = seatRepository.getSeats(passengersVagonE.idVagon);
                passengersVagon.add(new PassengersVagon(seats, passengersVagonE.idVagon));
            }
        }
        return passengersVagon;
    }

}
