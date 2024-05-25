package model.domain;

import java.io.Serializable;

public enum Brand implements Serializable {
    Mercedez_Benz,
    Arnold;

    public static Brand getBrandByName(String brandName) {
        switch (brandName) {
            case "Mercedez_Benz":
                return Mercedez_Benz;
            case "Arnold":
                return Arnold;
            default:
                return null;
        }
    }
}
