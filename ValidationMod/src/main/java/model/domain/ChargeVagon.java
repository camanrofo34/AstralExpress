package model.domain;

import dataStructures.Array;
import model.domain.abstractClasses.AbstractVagon;

public class ChargeVagon extends AbstractVagon {
    Array<Boolean> charge;
    public ChargeVagon(String idVagon) {
        super(idVagon);
        charge = new Array<>(80);
        for (int i = 0; i < 80; i++) {
            charge.add(false);
        }
    }

    public ChargeVagon(String idVagon, Array<Boolean> charge) {
        super(idVagon);
        this.charge = charge;
    }

    public Array<Boolean> getCharge() {
        return charge;
    }

    public void setCharge(Array<Boolean> charge) {
        this.charge = charge;
    }

    public Boolean addLuggage(){
        boolean added = false;
        for (int i = 0; i < charge.size(); i++) {
            if (!charge.get(i)) {
                charge.set(i, true);
                added = true;
                break;
            }
        }
        return added;
    }

    public Boolean removeLuggage(){
        boolean removed = false;
        for (int i = charge.size()-1; i >= 0; i--) {
            if (charge.get(i)) {
                charge.set(i, false);
                removed = true;
                break;
            }
        }
        return removed;
    }
}
