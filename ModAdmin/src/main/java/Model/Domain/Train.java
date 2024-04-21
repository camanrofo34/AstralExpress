package Model.Domain;

import dataStructures.Array;
import dataStructures.Interfaces.List;

import java.io.IOException;
import java.io.Serializable;

public class Train implements Serializable {
    private String trainName;
    private String idTrain;
    private int capacity;
    private double mileage;
    private Brand brand;
    private Boolean inRoute;
    private Array<PassengerVagon> passengersVagon;
    private Array<ChargeVagon> chargeVagon;


    public Train(String trainName, String idTrain, int capacity, double mileage, Brand brand) {
        this.trainName = trainName;
        this.idTrain = idTrain;
        this.capacity = capacity;
        this.mileage = mileage;
        this.brand = brand;
        this.inRoute = false;
        initVagones();
    }

    public Train(String trainName, String idTrain, int capacity, double mileage, Brand brand, Boolean inRoute) {
        this.trainName = trainName;
        this.idTrain = idTrain;
        this.capacity = capacity;
        this.mileage = mileage;
        this.brand = brand;
        this.inRoute = inRoute;
        initVagones();
    }

    public Train(String trainName, int capacity, Brand brand) throws IOException {
        this.trainName = trainName;
        this.capacity = capacity;
        this.mileage = 0.0;
        this.brand = brand;
        this.inRoute = false;
        initVagones();
    }


    public Train(String trainName, String idTrain, int capacity, double mileage, Brand brand, List<PassengerVagon> passengersVagon, List<ChargeVagon> chargeVagon) {
        this.trainName = trainName;
        this.idTrain = idTrain;
        this.capacity = capacity;
        this.mileage = mileage;
        this.brand = brand;
        this.passengersVagon = new Array<>(passengersVagon.toArray(new PassengerVagon[] {}));
        this.chargeVagon = new Array<>(chargeVagon.toArray(new ChargeVagon[] {}));
    }

    public Train(String trainName, int i, double v, Brand brandByName) {
        this.trainName = trainName;
        this.idTrain = "";
        this.capacity = i;
        this.mileage = v;
        this.brand = brandByName;
        this.inRoute = false;
        initVagones();
    }

    public Train(String trainName, String idTrain, int i, float v, Brand brand, Boolean inRoute, List<PassengerVagon> passengerVagons, List<ChargeVagon> chargeVagons) {
        this.trainName = trainName;
        this.idTrain = idTrain;
        this.capacity = i;
        this.mileage = v;
        this.brand = brand;
        this.inRoute = inRoute;
        this.passengersVagon = new Array<>(passengerVagons.toArray(new PassengerVagon[] {}));
        this.chargeVagon = new Array<>(chargeVagons.toArray(new ChargeVagon[] {}));
    }

    public static Train getNullTrain() {
        return new Train("", "", 0, 0.0, Brand.getBrandByName(""));
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getIdTrain() {
        return idTrain;
    }

    public void setIdTrain(String idTrain) {
        this.idTrain = idTrain;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Boolean getInRoute() {
        return inRoute;
    }

    public void setInRoute(Boolean inRoute) {
        this.inRoute = inRoute;
    }

    public Array<PassengerVagon> getPassengersVagon() {
        return passengersVagon;
    }

    public void setPassengersVagon(Array<PassengerVagon> passengersVagon) {
        this.passengersVagon = passengersVagon;
    }

    public Array<ChargeVagon> getChargeVagon() {
        return chargeVagon;
    }

    public void setChargeVagon(Array<ChargeVagon> chargeVagon) {
        this.chargeVagon = chargeVagon;
    }

    private void initVagones() {
        int count = capacity / 3;
        passengersVagon = new Array<>(count * 2);
        for (int i = 0; i < count*2 ; i++) {
            passengersVagon.add(new PassengerVagon(idTrain + "-P" + i));
        }
        chargeVagon = new Array<>(count);
        for (int i = 0; i < count; i++) {
            chargeVagon.add(new ChargeVagon(idTrain + "-C" + i));
        }
    }

}
