package Model.Domain;

import java.io.Serializable;

public enum Brand implements Serializable {
    Mercedez_Benz,
    Arnold;

    public static Brand getBrandByName(String brandName) {
        for (Brand brand : Brand.values()) {
            if (brand.name().equals(brandName)) {
                return brand;
            }
        }
        return null;
    }
}
