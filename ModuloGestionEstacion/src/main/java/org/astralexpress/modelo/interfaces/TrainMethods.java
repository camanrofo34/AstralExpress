/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.astralexpress.modelo.interfaces;

import org.astralexpress.modelo.domain.AbstractVagon;

/**
 *
 * @author PC 4060TI
 */
public interface TrainMethods {
    public AbstractVagon consultVagon (String idVagon);
    public boolean addVagon(AbstractVagon vagon);
    public boolean removeVagon(String idVagon);
    public void initVagones();
}
