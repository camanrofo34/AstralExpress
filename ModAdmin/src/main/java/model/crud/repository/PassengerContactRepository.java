package model.crud.repository;

import model.crud.repository.entities.PassengerContactEntity;
import model.crud.shared.FileJsonAdapter;
import model.crud.shared.FileJsonInterface;
import model.domain.PassengerContact;
import model.interfaces.CRUD.PassengerContactRepoInterface;
import dataStructures.Array;
import dataStructures.ArrayList;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;

public class PassengerContactRepository implements PassengerContactRepoInterface {
    private final FileJsonInterface<PassengerContactEntity> fileJson;
    private final String pathFile;

    public PassengerContactRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    @Override
    public Boolean insert(PassengerContact passengerContact) {
        List<PassengerContactEntity> passengerContacts = getPassengerContactEntityList();
        PassengerContactEntity passengerContactEntity = new PassengerContactEntity(passengerContact.getIdPerson(), passengerContact.getNames(), passengerContact.getLastNames(), passengerContact.getPhoneNumbersString());
        passengerContacts.add(passengerContactEntity);
        return fileJson.writeObjects(pathFile, passengerContacts);
    }

    @Override
    public Boolean delete(PassengerContact passengerContact) {
        List<PassengerContactEntity> passengerContacts = getPassengerContactEntityList();
        PassengerContactEntity passengerContactEntity = new PassengerContactEntity(passengerContact.getIdPerson(), passengerContact.getNames(), passengerContact.getLastNames(), passengerContact.getPhoneNumbersString());
        passengerContacts.remove(passengerContactEntity);
        return fileJson.writeObjects(pathFile, passengerContacts);
    }

    @Override
    public Boolean update(PassengerContact passengerContact) {
        ArrayList<PassengerContactEntity> passengerContacts = (ArrayList<PassengerContactEntity>) getPassengerContactEntityList();
        PassengerContactEntity passengerContactEntity = new PassengerContactEntity(passengerContact.getIdPerson(),
                passengerContact.getNames(), passengerContact.getLastNames(), passengerContact.getPhoneNumbersString());
        for (int i = 0; i < passengerContacts.size(); i++) {
            if (passengerContacts.get(i).getIdPassenger().equals(passengerContact.getIdPerson())) {
                passengerContacts.set(i, passengerContactEntity);
                return fileJson.writeObjects(pathFile, passengerContacts);
            }
        }
        return false;
    }

    @Override
    public PassengerContact getPassengerContact(String idPassenger) {
        List<PassengerContactEntity> passengerContacts = getPassengerContactEntityList();
        Iterator<PassengerContactEntity> it = passengerContacts.iterator();
        while (it.hasNext()) {
            PassengerContactEntity passengerContactEntity = it.next();
            if (passengerContactEntity.getIdPassenger().equals(idPassenger)) {
                return new PassengerContact(passengerContactEntity.getIdPassenger(), passengerContactEntity.getNames(), passengerContactEntity.getLastNames(),
                        new Array<String>(passengerContactEntity.getPhoneNumbers().split(",")));
            }
        }
        return PassengerContact.returnNullPassengerContact();
    }

    @Override
    public List<PassengerContact> getPassengerContacts() {
        List<PassengerContactEntity> passengerContacts = getPassengerContactEntityList();
        List<PassengerContact> passengerContactsList = new ArrayList<>();
        Iterator<PassengerContactEntity> it = passengerContacts.iterator();
        while (it.hasNext()) {
            PassengerContactEntity passengerContactEntity = it.next();
            passengerContactsList.add(new PassengerContact(passengerContactEntity.getIdPassenger(), passengerContactEntity.getNames(), passengerContactEntity.getLastNames(),
                    new Array<String>(passengerContactEntity.getPhoneNumbers().split(","))));
        }
        return passengerContactsList;
    }

    private List<PassengerContactEntity> getPassengerContactEntityList() {
        List<PassengerContactEntity> passengerContacts = fileJson.getObjects(pathFile, PassengerContactEntity[].class);
        return passengerContacts;
    }


}
