package model.crud.repository;

import model.crud.repository.entities.PassengerVagonEntity;
import model.crud.shared.FileJsonAdapter;
import model.crud.shared.FileJsonInterface;
import model.domain.PassengerVagon;
import dataStructures.Array;
import dataStructures.ArrayList;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;
import model.interfaces.crud.PassengerVagonRepoInterface;

public class PassengerVagonRepository implements PassengerVagonRepoInterface {

    private final FileJsonInterface<PassengerVagonEntity> fileJson;
    private final String pathFile;

    public PassengerVagonRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    @Override
    public List<PassengerVagon> getPassengerVagons() {
        List<PassengerVagonEntity> passengerVagonEntities = fileJson.getObjects(pathFile, PassengerVagonEntity[].class);
        List<PassengerVagon> passengerVagons = new ArrayList<>();
        Iterator<PassengerVagonEntity> it = passengerVagonEntities.iterator();
        while (it.hasNext()) {
            PassengerVagonEntity passengerVagonEntity = it.next();
            passengerVagons.add(new PassengerVagon(passengerVagonEntity.getIdVagon(), new Array<>(passengerVagonEntity.getPremium()), new Array<>(passengerVagonEntity.getExecutive()), new Array<>(passengerVagonEntity.getStandard())));
        }
        return passengerVagons;
    }

    @Override
    public Boolean insert(PassengerVagon passengerVagon) {
        List<PassengerVagonEntity> passengerVagonEntities = fileJson.getObjects(pathFile, PassengerVagonEntity[].class);
        Boolean[] premiumSeats = new Boolean[passengerVagon.getPremium().size()];
        for (int i = 0; i < passengerVagon.getPremium().size(); i++) {
            premiumSeats[i] = passengerVagon.getPremium().get(i);
        }
        Boolean[] executiveSeats = new Boolean[passengerVagon.getExecutive().size()];
        for (int i = 0; i < passengerVagon.getExecutive().size(); i++) {
            executiveSeats[i] = passengerVagon.getExecutive().get(i);
        }
        Boolean[] standardSeats = new Boolean[passengerVagon.getStandard().size()];
        for (int i = 0; i < passengerVagon.getStandard().size(); i++) {
            standardSeats[i] = passengerVagon.getStandard().get(i);
        }
        PassengerVagonEntity passengerVagonEntity = new PassengerVagonEntity(passengerVagon.getIdVagon(), premiumSeats , executiveSeats, standardSeats);
        passengerVagonEntities.add(passengerVagonEntity);
        return fileJson.writeObjects(pathFile, passengerVagonEntities);
    }

    @Override
    public Boolean delete(PassengerVagon passengerVagon) {
        List<PassengerVagonEntity> passengerVagonEntities = fileJson.getObjects(pathFile, PassengerVagonEntity[].class);
        Boolean[] premiumSeats = new Boolean[passengerVagon.getPremium().size()];
        for (int i = 0; i < passengerVagon.getPremium().size(); i++) {
            premiumSeats[i] = passengerVagon.getPremium().get(i);
        }
        Boolean[] executiveSeats = new Boolean[passengerVagon.getExecutive().size()];
        for (int i = 0; i < passengerVagon.getExecutive().size(); i++) {
            executiveSeats[i] = passengerVagon.getExecutive().get(i);
        }
        Boolean[] standardSeats = new Boolean[passengerVagon.getStandard().size()];
        for (int i = 0; i < passengerVagon.getStandard().size(); i++) {
            standardSeats[i] = passengerVagon.getStandard().get(i);
        }
        PassengerVagonEntity passengerVagonEntity = new PassengerVagonEntity(passengerVagon.getIdVagon(), premiumSeats , executiveSeats, standardSeats);
        passengerVagonEntities.remove(e -> e.getIdVagon().equals(passengerVagonEntity.getIdVagon()));
        return fileJson.writeObjects(pathFile, passengerVagonEntities);
    }

    @Override
    public Boolean update(PassengerVagon passengerVagon) {
        ArrayList<PassengerVagonEntity> passengerVagonEntities = (ArrayList<PassengerVagonEntity>) fileJson.getObjects(pathFile, PassengerVagonEntity[].class);
        Boolean[] premiumSeats = new Boolean[passengerVagon.getPremium().size()];
        for (int i = 0; i < passengerVagon.getPremium().size(); i++) {
            premiumSeats[i] = passengerVagon.getPremium().get(i);
        }
        Boolean[] executiveSeats = new Boolean[passengerVagon.getExecutive().size()];
        for (int i = 0; i < passengerVagon.getExecutive().size(); i++) {
            executiveSeats[i] = passengerVagon.getExecutive().get(i);
        }
        Boolean[] standardSeats = new Boolean[passengerVagon.getStandard().size()];
        for (int i = 0; i < passengerVagon.getStandard().size(); i++) {
            standardSeats[i] = passengerVagon.getStandard().get(i);
        }
        PassengerVagonEntity passengerVagonEntity = new PassengerVagonEntity(passengerVagon.getIdVagon(), premiumSeats , executiveSeats, standardSeats);
        for (int i = 0; i < passengerVagonEntities.size(); i++) {
            if (passengerVagonEntities.get(i).getIdVagon().equals(passengerVagon.getIdVagon())) {
                passengerVagonEntities.set(i, passengerVagonEntity);
                return fileJson.writeObjects(pathFile, passengerVagonEntities);
            }
        }
        return false;
    }

    @Override
    public PassengerVagon getPassengerVagon(String idVagon) {
        List<PassengerVagonEntity> passengerVagonEntities = fileJson.getObjects(pathFile, PassengerVagonEntity[].class);
        Iterator<PassengerVagonEntity> it = passengerVagonEntities.iterator();
        while (it.hasNext()) {
            PassengerVagonEntity passengerVagonEntity = it.next();
            if (passengerVagonEntity.getIdVagon().equals(idVagon)) {
                return new PassengerVagon(passengerVagonEntity.getIdVagon(), new Array<>(passengerVagonEntity.getPremium()), new Array<>(passengerVagonEntity.getExecutive()), new Array<>(passengerVagonEntity.getStandard()));
            }
        }
        return null;
    }
}
