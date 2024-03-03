/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo;

import org.astralexpress.modelo.domain.Brand;
import org.astralexpress.modelo.domain.Train;
import org.model.LinkedList.singly.LinkedList;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 */
public class TrainsModule {
    LinkedList<Train> trains;

    public TrainsModule() {
        this.trains = new LinkedList<>(new Train[]{
            new Train("Tren1", "IdTren1", 28, 0.0, Brand.Mercedez_Benz),
            new Train("Tren2", "IdTren2", 28, 0.0, Brand.Mercedez_Benz),
            new Train("Tren3", "IdTren3", 28, 0.0, Brand.Mercedez_Benz),
            new Train("Tren4", "IdTren4", 28, 0.0, Brand.Mercedez_Benz),
            new Train("Tren5", "IdTren5", 28, 0.0, Brand.Mercedez_Benz),
        });
    }
    
    
    
    public Object[][] crearTablaTrenes(){
        Object[][] table = new Object[trains.size()][5];
        Iterator <Train> iterator = trains.iterator();
        int i=0;
        while(iterator.hasNext()){
            Train train = iterator.next();
            table [i][0] = train.getIdTrain();
            table [i][1] = train.getTrainName();
            table [i][2] = train.getCapacity();
            table [i][3] = train.getMileage();
            table [i][4] = train.getBrand();
            i++;
        }
        return table;
    }
}
