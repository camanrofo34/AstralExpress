/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

import java.io.Serializable;

/**
 * @author PC 4060TI
 */
public class Ticket implements Serializable {

    private Train train;
    private AbstractVagon vagon;
    private Seat seat;
    private Station departureStation;
    private Station arrivalStation;
    private Passenger passenger;
    private double Value;

    public Ticket(Train train, PassengersVagon vagon, Seat seat, Station departureStation, Station arrivalStation, Passenger passenger, double Value) {
        this.train = train;
        this.vagon = vagon;
        this.seat = seat;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.passenger = passenger;
        this.Value = Value;
    }

    public static Ticket returnNullTicket() {
        return new Ticket(Train.getNullTrain(),
                PassengersVagon.returnNullPassengersVagon(),
                Seat.returnNullSeat(),
                Station.returnNullStation(),
                Station.returnNullStation(),
                Passenger.returnNullPassenger(),
                0.0);
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public AbstractVagon getVagon() {
        return vagon;
    }

    public void setVagon(AbstractVagon vagon) {
        this.vagon = vagon;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Station getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(Station departureStation) {
        this.departureStation = departureStation;
    }

    public Station getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(Station arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public double getValue() {
        return Value;
    }

    public void setValue(double Value) {
        this.Value = Value;
    }


}
