/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.repositorio;

import java.io.Serializable;

/**
 * @author PC 4060TI
 */
public class StationEntity implements Serializable {
    String idStation;
    String stationName;

    public StationEntity(String idStation, String stationName) {
        this.idStation = idStation;
        this.stationName = stationName;
    }
}
