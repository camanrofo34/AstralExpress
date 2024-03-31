/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

import java.io.Serializable;

/**
 *
 * @author PC 4060TI
 */
public class Station implements Serializable{
    private String idStation;
    private String stationName;

    public Station(String idStation, String stationName) {
        this.idStation = idStation;
        this.stationName = stationName;
    }
    
    public static Station returnNullStation(){
        return new Station("", "");
    }
    
}
