package model.domain;

import dataStructures.Array;
import model.domain.abstractClasses.AbstractVagon;

public class PassengerVagon extends AbstractVagon {
    private Array<Boolean> premium;
    private Array<Boolean> executive;
    private Array<Boolean> standard;

    public PassengerVagon(String idVagon, Array<Boolean> premium, Array<Boolean> executive, Array<Boolean> standard) {
        super(idVagon);
        this.premium = premium;
        this.executive = executive;
        this.standard = standard;
    }

    public PassengerVagon(String idVagon) {
        super(idVagon);
        this.premium = new Array<>(4);
        for (int i = 0; i < 4; i++) {
            this.premium.add(false);
        }
        this.executive = new Array<>(8);
        for (int i = 0; i < 8; i++) {
            this.executive.add(false);
        }
        this.standard = new Array<>(28);
        for (int i = 0; i < 28; i++) {
            this.standard.add(false);
        }
    }

    public Array<Boolean> getPremium() {
        return premium;
    }

    public void setPremium(Array<Boolean> premium) {
        this.premium = premium;
    }

    public Array<Boolean> getExecutive() {
        return executive;
    }

    public void setExecutive(Array<Boolean> executive) {
        this.executive = executive;
    }

    public Array<Boolean> getStandard() {
        return standard;
    }

    public void setStandard(Array<Boolean> standard) {
        this.standard = standard;
    }

}
