/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.controlador;

import org.astralexpress.modelo.TrainsModel;
import org.astralexpress.modelo.domain.Brand;
import org.astralexpress.modelo.domain.Train;
import org.astralexpress.vista.TrainsView;
import org.model.array.Array;
import org.model.io.LinkedList.LinkedList;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.function.UnaryOperator;

/**
 *
 * @author admin
 */
public class TrainsController {
    TrainsView TV;
    TrainsModel TM;
    
    public TrainsController(TrainsModel TM, TrainsView TV){
        this.TV = TV;
        this.TM = TM;
    }
    
    public void start() throws MalformedURLException, NotBoundException, RemoteException {
        TV.initComponents(new Array<>(new UnaryOperator[]{
                event -> {
                    String trainName = TV.getTrainName();
                    String trainType = TV.getTrainBrand();
                    String trainCapacity = TV.getTrainCapacity();
                    if (trainName.isBlank() || trainType.isBlank() || trainCapacity.isBlank()) {
                        TM.getMessenger().setMessage("Por favor ingresar los datos correspondientes");
                        return null;
                    }
                    if (!trainCapacity.matches("[0-9]+")) {
                        TM.getMessenger().setMessage("La capacidad debe ser un número");
                        return null;
                    }
                    Brand brand = Brand.getBrandByName(trainType);
                    if (brand.equals(Brand.Mercedez_Benz)){
                        if (Integer.parseInt(trainCapacity) > 32){
                            TM.getMessenger().setMessage("La capacidad máxima para un Mercedez Benz es de 32");
                            return null;
                        }
                    }
                    if (brand.equals(Brand.Arnold)){
                        if (Integer.parseInt(trainCapacity) > 28){
                            TM.getMessenger().setMessage("La capacidad máxima para un Arnold es de 28");
                            return null;
                        }
                    }
                    try {
                        boolean up = TM.addTrain(trainName, Integer.parseInt(trainCapacity), brand);
                        if (!up) {
                            TM.getMessenger().setMessage("Error al crear el tren");
                            return null;
                        }else{
                            TM.getMessenger().setMessage("Tren creado con éxito");
                        }
                    } catch (IOException | NotBoundException e) {
                        throw new RuntimeException(e);
                    }
                    return null;
                },
                event -> {
                    return null;
                },
                event -> {
                    return null;
                }
        }), (LinkedList<Train>) TM.getTrains());
    }
}
