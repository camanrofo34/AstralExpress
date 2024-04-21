package model.domain;

public enum IdType {
    DNI, PASSPORT, NIE;

    public IdType fromString(String idType) {
        switch (idType) {
            case "DNI":
                return DNI;
            case "PASSPORT":
                return PASSPORT;
            case "NIE":
                return NIE;
            default:
                return null;
        }
    }
}
