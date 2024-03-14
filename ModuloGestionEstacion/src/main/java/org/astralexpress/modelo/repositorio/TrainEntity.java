/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.repositorio;

import java.io.Serializable;

/**
 *
 * @author PC 4060TI
 */
public class TrainEntity implements Serializable{
    String trainName;
    String idTrain;
    String capacity;
    String mileage;
    String brand;
    String idVagons;

    public TrainEntity(String trainName, String idTrain, String capacity, String mileage, String brand, String idVagons) {
        this.trainName = trainName;
        this.idTrain = idTrain;
        this.capacity = capacity;
        this.mileage = mileage;
        this.brand = brand;
        this.idVagons = idVagons;
    }
    
}
