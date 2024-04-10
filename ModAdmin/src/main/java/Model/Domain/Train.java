package Model.Domain;

import DataStructures.ArrayList;
import DataStructures.Interfaces.Iterator;
import DataStructures.Interfaces.List;
import Model.Domain.AbstractClasses.AbstractVagon;

import java.io.IOException;

public class Train {
    private String trainName;
    private String idTrain;
    private int capacity;
    private double mileage;
    private Brand brand;
    private ArrayList<AbstractVagon> vagons;

    public Train(String trainName, String idTrain, int capacity, double mileage, Brand brand) {
        this.trainName = trainName;
        this.idTrain = idTrain;
        this.capacity = capacity;
        this.mileage = mileage;
        this.brand = brand;
        this.vagons = new ArrayList<>();
    }

    public Train(String trainName, int capacity, Brand brand) throws IOException {
        this.trainName = trainName;
        this.idTrain = actualTrainId();
        this.capacity = capacity;
        this.mileage = 0.0;
        this.brand = brand;
        this.vagons = new ArrayList<>();
    }


    public Train(String trainName, String idTrain, int capacity, double mileage, Brand brand, ArrayList<AbstractVagon> vagons) {
        this.trainName = trainName;
        this.idTrain = idTrain;
        this.capacity = capacity;
        this.mileage = mileage;
        this.brand = brand;
        this.vagons = vagons;
    }
/*
    private static final String ID_FILE_PATH = "src\\main\\java\\org\\astralexpress\\database\\idTrain.txt";

    private String actualTrainId() {
        String id = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(ID_FILE_PATH))) {
            id = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace(); // Consider handling this error more appropriately
        }

        if (id != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(ID_FILE_PATH))) {
                int nextId = Integer.parseInt(id) + 1;
                writer.write(String.valueOf(nextId));
            } catch (IOException e) {
                e.printStackTrace(); // Consider handling this error more appropriately
            }
        }
        return id;
    }

 */
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

    public List<AbstractVagon> getVagons() {
        return vagons;
    }

    public void setVagons(ArrayList<AbstractVagon> vagons) {
        this.vagons = vagons;
    }

    public AbstractVagon consultVagon(String idVagon) {
        Iterator<AbstractVagon> iterator = vagons.iterator();
        while (iterator.hasNext()) {
            AbstractVagon vagon = iterator.next();
            if (vagon.getIdVagon().equals(idVagon)) return vagon;
        }
        return new AbstractVagon() {
        };
    }

    public boolean addVagon(AbstractVagon vagon) {
        return vagons.add(vagon);
    }

    public boolean removeVagon(String idVagon) {
        return vagons.remove(vagon -> vagon.getIdVagon().equals(idVagon));
    }

    public void initVagones() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
