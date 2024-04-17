package Model.CRUD.Repository.Entities;

public class TrainEntity {
    private String trainName;
    private String idTrain;
    private String capacity;
    private String mileage;
    private String brand;

    public TrainEntity(String trainName, String idTrain, String capacity, String mileage, String brand) {
        this.trainName = trainName;
        this.idTrain = idTrain;
        this.capacity = capacity;
        this.mileage = mileage;
        this.brand = brand;
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

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
