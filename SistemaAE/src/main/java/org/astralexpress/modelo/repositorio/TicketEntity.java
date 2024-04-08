/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.repositorio;

import java.io.Serializable;

/**
 * @author PC 4060TI
 */
public class TicketEntity implements Serializable {

    String idTrain;
    String idVagon;
    String idSeat;
    String idDepartureStation;
    String idArrivalStation;
    String idPassenger;
    String value;

    public TicketEntity(String idTrain, String idVagon, String idSeat, String idDepartureStation, String idArrivalStation, String idPassenger, String value) {
        this.idTrain = idTrain;
        this.idVagon = idVagon;
        this.idSeat = idSeat;
        this.idDepartureStation = idDepartureStation;
        this.idArrivalStation = idArrivalStation;
        this.idPassenger = idPassenger;
        this.value = value;
    }


} 
