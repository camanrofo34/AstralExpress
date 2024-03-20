/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.repositorio;

import org.astralexpress.modelo.domain.ChargeVagon;
import org.astralexpress.modelo.domain.Luggage;
import org.astralexpress.shared.FileJsonAdapter;
import org.astralexpress.shared.FileJsonInterface;
import org.model.LinkedList.singly.LinkedList;
import org.model.array.Array;
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
    
    public ChargeVagon getChargeVagon(String idVagon){
        ChargeVagonEntity[] chargeVagonEntity = fileJson.getObjects("", ChargeVagonEntity[].class);
        Array<ChargeVagonEntity> chargeVagonsEntity = new Array<>(chargeVagonEntity);
        Iterator<ChargeVagonEntity> iterator = chargeVagonsEntity.iterator();
        LuggageRepository luggageRepository = new LuggageRepository("../../database/.json");
        while (iterator.hasNext()){
            ChargeVagonEntity chargeVagonE = iterator.next();
            List<Luggage> luggages = luggageRepository.getLuggagesByIdVagon(chargeVagonE.idVagon);
            if (chargeVagonE.idVagon.equals(idVagon)){
                return new ChargeVagon(new Array<>(luggages.toArray()),chargeVagonE.idVagon );
            }
        }
        return ChargeVagon.getNullChargeVagon();
    }
    
        public LinkedList<ChargeVagon> getChargeVagons(String idTrain){
        ChargeVagonEntity[] chargeVagonEntity = fileJson.getObjects("", ChargeVagonEntity[].class);
        LinkedList<ChargeVagon> chargeVagons = new LinkedList<> ();
        Array<ChargeVagonEntity> chargeVagonsEntity = new Array<>(chargeVagonEntity);
        Iterator<ChargeVagonEntity> iterator = chargeVagonsEntity.iterator();
        LuggageRepository luggageRepository = new LuggageRepository("../../database/.json");
        while (iterator.hasNext()){
            ChargeVagonEntity chargeVagonE = iterator.next();
            List<Luggage> luggages = luggageRepository.getLuggagesByIdVagon(chargeVagonE.idVagon);
            if (chargeVagonE.idVagon.startsWith(idTrain)){
                chargeVagons.add(new ChargeVagon(new Array<>(luggages.toArray()),chargeVagonE.idVagon ));
            }
        }
        return chargeVagons;
    }
}
