/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.repositorio;

import org.astralexpress.modelo.domain.ChargeVagon;
import org.astralexpress.modelo.domain.Luggage;
import org.astralexpress.shared.FileJsonAdapter;
import org.astralexpress.shared.FileJsonInterface;
import org.model.ArrayList.ArrayList;
import org.model.array.Array;
import org.model.io.LinkedList.LinkedList;
import org.model.util.iterator.Iterator;
import org.model.util.list.List;

/**
 *
 * @author PC 4060TI
 */
public class ChargeVagonRepository {

    private FileJsonInterface<ChargeVagonEntity> fileJson;
    private String pathFile;

    public ChargeVagonRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public ChargeVagon getChargeVagon(String idVagon) {
        ChargeVagonEntity[] chargeVagonEntity = fileJson.getObjects(pathFile, ChargeVagonEntity[].class);
        Array<ChargeVagonEntity> chargeVagonsEntity = new Array<>(chargeVagonEntity);
        Iterator<ChargeVagonEntity> iterator = chargeVagonsEntity.iterator();
        LuggageRepository luggageRepository = new LuggageRepository("src\\main\\java\\org\\astralexpress\\database\\luggage.json");
        while (iterator.hasNext()) {
            ChargeVagonEntity chargeVagonE = iterator.next();
            List<Luggage> luggages = luggageRepository.getLuggagesByIdVagon(chargeVagonE.idVagon);
            if (chargeVagonE.idVagon.equals(idVagon)) {
                return new ChargeVagon(luggages, chargeVagonE.idVagon);
            }
        }
        return ChargeVagon.getNullChargeVagon();
    }

    public List<ChargeVagon> getChargeVagons(String idTrain) {
        ChargeVagonEntity[] chargeVagonEntity = fileJson.getObjects(pathFile, ChargeVagonEntity[].class);
        List<ChargeVagon> chargeVagons = new LinkedList<>();
        Array<ChargeVagonEntity> chargeVagonsEntity = new Array<>(chargeVagonEntity);
        Iterator<ChargeVagonEntity> iterator = chargeVagonsEntity.iterator();
        LuggageRepository luggageRepository = new LuggageRepository("src\\main\\java\\org\\astralexpress\\database\\luggage.json");
        while (iterator.hasNext()) {
            ChargeVagonEntity chargeVagonE = iterator.next();
            List<Luggage> luggages = luggageRepository.getLuggagesByIdVagon(chargeVagonE.idVagon);
            if (chargeVagonE.idVagon.startsWith(idTrain)) {
                chargeVagons.add(new ChargeVagon(luggages, chargeVagonE.idVagon));
            }
        }
        return chargeVagons;
    }

    public void addChargeVagon(ChargeVagonEntity newChargeVagon) {
        ChargeVagonEntity[] chargeVagonEntities = fileJson.getObjects("", ChargeVagonEntity[].class);
        LinkedList<ChargeVagonEntity> chargeVagons = new LinkedList<>(chargeVagonEntities);
        chargeVagons.add(newChargeVagon);
        fileJson.writeObjects("", chargeVagons.toArray());
    }

    public void updateChargeVagon(String idVagon, ChargeVagonEntity updatedChargeVagon) {
        ChargeVagonEntity[] chargeVagonEntities = fileJson.getObjects("", ChargeVagonEntity[].class);
        ArrayList<ChargeVagonEntity> chargeVagons = new ArrayList<>(chargeVagonEntities);
        for (int i = 0; i < chargeVagons.size(); i++) {
            if (chargeVagons.get(i).idVagon.equals(idVagon)) {
                chargeVagons.set(i, updatedChargeVagon);
                break;
            }
        }
        fileJson.writeObjects("", chargeVagons.toArray());
    }

    public void deleteChargeVagon(String idVagon) {
        ChargeVagonEntity[] chargeVagonEntities = fileJson.getObjects("", ChargeVagonEntity[].class);
        LinkedList<ChargeVagonEntity> chargeVagons = new LinkedList<>(chargeVagonEntities);
        for (Iterator<ChargeVagonEntity> iterator = chargeVagons.iterator(); iterator.hasNext();) {
            ChargeVagonEntity chargeVagon = iterator.next();
            if (chargeVagon.idVagon.equals(idVagon)) {
                chargeVagons.remove(chargeVagon);
                break;
            }
        }
        fileJson.writeObjects("", chargeVagons.toArray());
    }

}
