package Model.Domain;

public enum Brand {
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
