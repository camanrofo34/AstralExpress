/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

import org.model.array.Array;

/**
 *
 * @author PC 4060TI
 */
public class ChargeVagon extends AbstractVagon{
    private Array<Luggage> luggages;

    public ChargeVagon(Array<Luggage> luggages, String idVagon) {
        super(idVagon);
        this.luggages = luggages;
    }
    
}
