package Model.CRUD.Repository;

import dataStructures.Array;
import dataStructures.ArrayList;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;
import Model.CRUD.Repository.Entities.PassengerEntity;
import Model.CRUD.Shared.FileJsonAdapter;
import Model.CRUD.Shared.FileJsonInterface;
import Model.Domain.Passenger;
import Model.Domain.PassengerContact;
import Model.Interfaces.CRUD.PassengerRepoInterface;

public class PassengerRepository implements PassengerRepoInterface {
    private final FileJsonInterface<PassengerEntity> fileJson;
    private final String pathFile;

    public PassengerRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    @Override
    public Boolean insert(Passenger passenger){
        List<PassengerEntity> passengers = fileJson.getObjects(pathFile, PassengerEntity[].class);
        PassengerEntity passengerEntity = new PassengerEntity(passenger.getIdPerson(), passenger.getIdType(), passenger.getNames(), passenger.getLastNames(), passenger.getPhoneNumbersString(), passenger.getHomeAdress());
        PassengerContact passengerContact = passenger.getPassengerContact();
        PassengerContactRepository passengerContactRepository = new PassengerContactRepository("ModAdmin\\src\\main\\resources\\Model\\JSONFiles\\passengerContacts.json");
        passengerContactRepository.insert(passengerContact);
        passengers.add(passengerEntity);
        return fileJson.writeObjects(pathFile, passengers);
    }

    @Override
    public Boolean delete(Passenger passenger){
        List<PassengerEntity> passengers = fileJson.getObjects(pathFile, PassengerEntity[].class);
        PassengerEntity passengerEntity = new PassengerEntity(passenger.getIdPerson(), passenger.getIdType(), passenger.getNames(), passenger.getLastNames(), passenger.getPhoneNumbersString(), passenger.getHomeAdress());
        PassengerContact passengerContact = passenger.getPassengerContact();
        PassengerContactRepository passengerContactRepository = new PassengerContactRepository("ModAdmin\\src\\main\\resources\\Model\\JSONFiles\\passengerContacts.json");
        passengerContactRepository.delete(passengerContact);
        passengers.remove(passengerEntity);
        return fileJson.writeObjects(pathFile, passengers);
    }

    @Override
    public Boolean update(Passenger passenger) {
        ArrayList<PassengerEntity> passengers = (ArrayList<PassengerEntity>) fileJson.getObjects(pathFile, PassengerEntity[].class);
        PassengerEntity passengerEntity = new PassengerEntity(passenger.getIdPerson(), passenger.getIdType(), passenger.getNames(), passenger.getLastNames(), passenger.getPhoneNumbersString(), passenger.getHomeAdress());
        PassengerContactRepository passengerContactRepository = new PassengerContactRepository("ModAdmin\\src\\main\\resources\\Model\\JSONFiles\\passengerContacts.json");
        passengerContactRepository.update(passenger.getPassengerContact());
        for (int i=0; i<passengers.size(); i++){
            if (passengers.get(i).getIdPassenger().equals(passenger.getIdPerson())){
                passengers.set(i, passengerEntity);
                return fileJson.writeObjects(pathFile, passengers);
            }
        }
        return false;
    }

    @Override
    public Passenger getPassenger(String idPassenger){
        List<PassengerEntity> passengers = fileJson.getObjects(pathFile, PassengerEntity[].class);
        Iterator<PassengerEntity> it = passengers.iterator();
        while (it.hasNext()){
            PassengerEntity passengerEntity = it.next();
            if (passengerEntity.getIdPassenger().equals(idPassenger)){
                PassengerContactRepository passengerContactRepository = new PassengerContactRepository("passengerContacts.json");
                PassengerContact passengerContact = passengerContactRepository.getPassengerContact(passengerEntity.getIdPassenger());
                return new Passenger(passengerEntity.getIdPassenger(), passengerEntity.getIdType(), passengerEntity.getNames(), passengerContact,
                        passengerEntity.getLastNames(), passengerEntity.getHomeAdress(), new Array<String>(passengerEntity.getPhoneNumbers().split(",")));
            }
        }
        return Passenger.returnNullPassenger();
    }

    @Override
    public List<Passenger> getPassengers(){
        List<PassengerEntity> passengers = fileJson.getObjects(pathFile, PassengerEntity[].class);
        List<Passenger> passengersList = new ArrayList<>();
        Iterator<PassengerEntity> it = passengers.iterator();
        while (it.hasNext()){
            PassengerEntity passengerEntity = it.next();
            PassengerContactRepository passengerContactRepository = new PassengerContactRepository("passengerContacts.json");
            PassengerContact passengerContact = passengerContactRepository.getPassengerContact(passengerEntity.getIdPassenger());
            passengersList.add(new Passenger(passengerEntity.getIdPassenger(), passengerEntity.getIdType(), passengerEntity.getNames(), passengerContact,
                    passengerEntity.getLastNames(), passengerEntity.getHomeAdress(), new Array<String>(passengerEntity.getPhoneNumbers().split(","))));
        }
        return passengersList;
    }
}
