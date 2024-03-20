/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.repositorio;

import org.astralexpress.modelo.domain.Passenger;
import org.astralexpress.shared.FileJsonAdapter;
import org.astralexpress.shared.FileJsonInterface;
import org.model.io.array.Array;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 */
public class PassengersRepository {

    private FileJsonInterface<PassengerEntity> fileJson;
    private String pathFile;

    public PassengersRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public Passenger getPassenger(String idPassenger) {
        PassengerContactRepository PCR = new PassengerContactRepository("");
        PassengerEntity[] passengerEntity = fileJson.getObjects("", PassengerEntity[].class);
        Array<PassengerEntity> passengerEntities = new Array<>(passengerEntity);
        Iterator<PassengerEntity> iterator = passengerEntities.iterator();
        while (iterator.hasNext()) {
            PassengerEntity passenger = iterator.next();
            if (passenger.idPassenger.equals(idPassenger)) {
                return new Passenger(passenger.idPassenger, passenger.idType, passenger.homeAdress, PCR.getPassengerContactByIdPassenger(idPassenger),passenger.names, passenger.lastNames, new Array<String>(passenger.phoneNumbers.split(",")) );
            }
        }
        return Passenger.returnNullPassenger();
    }
}
