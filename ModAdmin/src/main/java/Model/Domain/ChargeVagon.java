package Model.Domain;

import DataStructures.ArrayList;
import DataStructures.Interfaces.List;
import Model.Domain.AbstractClasses.AbstractVagon;

public class ChargeVagon extends AbstractVagon {
    private List<Luggage> luggages;

    public ChargeVagon(List<Luggage> luggages, String idVagon) {
        super(idVagon);
        this.luggages = luggages;
    }

    public static ChargeVagon getNullChargeVagon() {
        return new ChargeVagon(new ArrayList<Luggage>(), "");
    }

}
