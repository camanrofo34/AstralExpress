package model.crud.repository;

import model.crud.repository.entities.ChargeVagonEntity;
import model.crud.shared.FileJsonAdapter;
import model.crud.shared.FileJsonInterface;
import model.domain.ChargeVagon;
import dataStructures.ArrayList;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;

public class ChargeVagonRepository {

    private final FileJsonInterface<ChargeVagonEntity> fileJson;
    private final String pathFile;

    public ChargeVagonRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public Boolean insert(ChargeVagon chargeVagon) {
        List<ChargeVagonEntity> chargeVagonEntities = fileJson.getObjects(pathFile, ChargeVagonEntity[].class);
        ChargeVagonEntity chargeVagonEntity = new ChargeVagonEntity(chargeVagon.getIdVagon());
        chargeVagonEntities.add(chargeVagonEntity);
        return fileJson.writeObjects(pathFile, chargeVagonEntities);
    }

    public Boolean delete(ChargeVagon chargeVagon) {
        List<ChargeVagonEntity> chargeVagonEntities = fileJson.getObjects(pathFile, ChargeVagonEntity[].class);
        ChargeVagonEntity chargeVagonEntity = new ChargeVagonEntity(chargeVagon.getIdVagon());
        chargeVagonEntities.remove(e -> e.getIdVagon().equals(chargeVagonEntity.getIdVagon()));
        return fileJson.writeObjects(pathFile, chargeVagonEntities);
    }

    public Boolean update(ChargeVagon chargeVagon) {
        ArrayList<ChargeVagonEntity> chargeVagonEntities = (ArrayList<ChargeVagonEntity>) fileJson.getObjects(pathFile, ChargeVagonEntity[].class);
        ChargeVagonEntity chargeVagonEntity = new ChargeVagonEntity(chargeVagon.getIdVagon());
        for (int i = 0; i < chargeVagonEntities.size(); i++) {
            if (chargeVagonEntities.get(i).getIdVagon().equals(chargeVagon.getIdVagon())) {
                chargeVagonEntities.set(i, chargeVagonEntity);
                return fileJson.writeObjects(pathFile, chargeVagonEntities);
            }
        }
        return false;
    }

    public ChargeVagon getChargeVagon(String idVagon) {
        List<ChargeVagonEntity> chargeVagonEntities = fileJson.getObjects(pathFile, ChargeVagonEntity[].class);
        Iterator<ChargeVagonEntity> it = chargeVagonEntities.iterator();
        while (it.hasNext()) {
            ChargeVagonEntity chargeVagonEntity = it.next();
            if (chargeVagonEntity.getIdVagon().equals(idVagon)) {
                return new ChargeVagon(chargeVagonEntity.getIdVagon());
            }
        }
        return null;
    }

    public List<ChargeVagon> getChargeVagons() {
        List<ChargeVagonEntity> chargeVagonEntities = fileJson.getObjects(pathFile, ChargeVagonEntity[].class);
        List<ChargeVagon> chargeVagons = new ArrayList<>();
        Iterator<ChargeVagonEntity> it = chargeVagonEntities.iterator();
        while (it.hasNext()) {
            ChargeVagonEntity chargeVagonEntity = it.next();
            chargeVagons.add(new ChargeVagon(chargeVagonEntity.getIdVagon()));
        }
        return chargeVagons;
    }
}
