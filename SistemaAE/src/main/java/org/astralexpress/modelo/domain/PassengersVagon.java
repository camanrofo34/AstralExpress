/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

import org.model.priorityQueue.list.PriorityQueue;

/**
 * @author PC 4060TI
 */
public class PassengersVagon extends AbstractVagon {

    PriorityQueue<Seat> seats;

    public PassengersVagon(PriorityQueue<Seat> seats, String idVagon) {
        super(idVagon);
        this.seats = seats;
    }

    public static PassengersVagon returnNullPassengersVagon() {
        return new PassengersVagon(new PriorityQueue<>(3), "");
    }
}
