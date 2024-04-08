/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

import org.model.LinkedList.doubly.LinkedList;
import org.model.util.list.List;

/**
 * @author PC 4060TI
 */
public class ChargeVagon extends AbstractVagon {
    private List<Luggage> luggages;

    public ChargeVagon(List<Luggage> luggages, String idVagon) {
        super(idVagon);
        this.luggages = luggages;
    }

    public static ChargeVagon getNullChargeVagon() {
        return new ChargeVagon(new LinkedList<>(), "");
    }

}
