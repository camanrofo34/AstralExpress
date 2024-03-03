/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

import org.model.queue.array.Queue;

/**
 *
 * @author PC 4060TI
 */
public class PassengersVagon extends AbstractVagon{
    Queue<Seat> seats;

    public PassengersVagon(Queue<Seat> seats, String idVagon) {
        super(idVagon);
        this.seats = seats;
    }


    
    
}