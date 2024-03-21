/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package org.astralexpress.modelo.domain;

/**
 *
 * @author PC 4060TI
 */
public enum Brand {
    Mercedez_Benz,
    Arnold;
    
    public static Brand getBrandByName(String brandName){
        for (Brand brand : Brand.values()) {
            if (brand.equals(brandName)) {
                return brand;
            }
        }
        return null;
    }
}
