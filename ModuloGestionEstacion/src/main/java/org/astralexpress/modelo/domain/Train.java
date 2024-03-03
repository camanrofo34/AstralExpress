/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

import org.astralexpress.modelo.interfaces.TrainMethods;
import org.model.LinkedList.singly.LinkedList;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 */
public class Train implements TrainMethods{
    private String trainName;
    private String idTrain;
    private int capacity;
    private double mileage;
    private Brand brand;
    private LinkedList<AbstractVagon> vagons;

    public Train(String trainName, String idTrain, int capacity, double mileage, Brand brand) {
        this.trainName = trainName;
        this.idTrain = idTrain;
        this.capacity = capacity;
        this.mileage = mileage;
        this.brand = brand;
        this.vagons = new LinkedList<>();
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

    public LinkedList<AbstractVagon> getVagons() {
        return vagons;
    }

    public void setVagons(LinkedList<AbstractVagon> vagons) {
        this.vagons = vagons;
    }

    @Override
    public AbstractVagon consultVagon(String idVagon) {
        Iterator<AbstractVagon> iterator = vagons.iterator();
        while(iterator.hasNext()){
            AbstractVagon vagon = iterator.next();
            if (vagon.getIdVagon().equals(idVagon)) return vagon;
        }
        return new AbstractVagon(){};
    }

    @Override
    public boolean addVagon(AbstractVagon vagon) {
        return vagons.add(vagon);
    }

    @Override
    public boolean removeVagon(String idVagon) {
        return vagons.remove(vagon -> vagon.getIdVagon().equals(idVagon));
    }

    @Override
    public void initVagones() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
