/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.repositorio;

import org.astralexpress.modelo.domain.PassengerContact;
import org.astralexpress.shared.FileJsonAdapter;
import org.astralexpress.shared.FileJsonInterface;
import org.model.io.array.Array;

import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 */
public class PassengerContactRepository {
    private FileJsonInterface<PassengerContactEntity> fileJson;
    private String pathFile;
    
    public PassengerContactRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }
    
    public PassengerContact getPassengerContactByIdPassenger(String idPassenger){
        PassengerContactEntity[] pCEntity = fileJson.getObjects(pathFile, PassengerContactEntity[].class);
        Array<PassengerContactEntity> pCsEntity = new Array<>(pCEntity);
        Iterator<PassengerContactEntity> iterator = pCsEntity.iterator();
        while (iterator.hasNext()){
            PassengerContactEntity PCE = iterator.next();
            if (PCE.id.equals(idPassenger)){
                return new PassengerContact(PCE.names, PCE.lastNames, new Array<>(PCE.phoneNumbers.split(",")));
            }

        }
        return PassengerContact.returnEmptyPassengerContact();
    }
}
